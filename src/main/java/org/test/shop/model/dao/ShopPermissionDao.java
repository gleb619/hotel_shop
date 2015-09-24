package org.test.shop.model.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.test.shop.config.settings.NamedFilter;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.SObject;
import org.test.shop.model.domain.entity.ShopPermission;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopPermissionDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopPermission sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopPermission";
	private String tableName = "shop_permission";

	public ShopPermission create(ShopPermission shoppermission) {
		em.persist(shoppermission);
		return shoppermission;
	}

	public ShopPermission update(ShopPermission shoppermission) {
		return em.merge(shoppermission);
	}
	
	public void popularityByKey(Object key) {
		ShopPermission shoppermission = findById(key, false);
		
		if(shoppermission != null){
			if (SObject.class.isAssignableFrom(ShopPermission.class)) {
				if (shoppermission.getPopularity() == null) {
					shoppermission.setPopularity(-1);
				}
				shoppermission.setPopularity(shoppermission.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopPermission.class)
							.setParameter("popularity", shoppermission.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopPermission item) {
		ShopPermission shoppermission = null;
		if(item != null){
			shoppermission = findById(item.getId(), false);
		}
		
		if(shoppermission != null){
			if (SObject.class.isAssignableFrom(ShopPermission.class)) {
				if (shoppermission.getPopularity() == null) {
					shoppermission.setPopularity(-1);
				}
				shoppermission.setPopularity(shoppermission.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopPermission.class)
							.setParameter("popularity", shoppermission.getPopularity())
							.setParameter("id", item.getId())
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		Query query = em.createNativeQuery(
				String.format(
						"SELECT count(*) from %s %s WHERE %s.firmid = %s and CAST(%s.createon as DATE) = CAST('%s' as DATE)"
						, tableName, shortName, shortName, settings.getSasUser().getUser().getFirmid(), shortName, today
				)
		);
		
		return ((BigInteger) query.getSingleResult()).intValue();
	}

	public Integer total(ScrollableSettings settings) throws Exception {
		TotalQuery totalQuery = DaoUtil.total(settings, ShopPermission.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopPermission> namedFilter(ScrollableSettings settings) {
		List<ShopPermission> shoppermissions = new ArrayList<ShopPermission>();
		
		try {
			shoppermissions = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopPermission.class), settings,
				ShopPermission.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shoppermissions;
	}

	@SuppressWarnings("unchecked")
	public List<ShopPermission> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopPermission>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopPermission(), settings.getFilter(), ShopPermission.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopPermission.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopPermission.class)), ShopPermission.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopPermission.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopPermission> findByExample(ShopPermission example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopPermission.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopPermission.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopPermission> findByExample2(ShopPermission example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopPermission.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopPermission> findAll(ScrollableSettings settings) {
		List<ShopPermission> shoppermissions = DaoUtil.sasQuery(selectClause, settings,
				ShopPermission.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopPermission item : shoppermissions) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopPermission item : shoppermissions) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoppermissions;
	}

	@SuppressWarnings("unchecked")
	public List<ShopPermission> findAllScrollable(ScrollableSettings settings) {
		List<ShopPermission> shoppermissions = DaoUtil
				.sasQuery(selectClause, settings, ShopPermission.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopPermission item : shoppermissions) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopPermission item : shoppermissions) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoppermissions;
	}

	public ShopPermission findById(Object key, Boolean initAll) {
		ShopPermission item = em.find(ShopPermission.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopPermission findById(ScrollableSettings settings) {
		ShopPermission item = em.find(ShopPermission.class, settings.getId());

		if(item != null){
			if (settings.getList().size() > 0) {
				item.customInit(item, settings.getList());
			}
	
			if (settings.getInitDicts()) {
				item.initDicts();
			}
	
			if (settings.getInitLists()) {
				item.initList();
			}
			
			try {
				item.specialInit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return item;
	}

	public Boolean delete(Object id) {
		try {
			em.remove(em.getReference(ShopPermission.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
