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
import org.test.shop.model.domain.entity.RelShopPermission;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelShopPermissionDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelShopPermission rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelShopPermission";
	private String tableName = "rel_shop_permission";

	public RelShopPermission create(RelShopPermission relshoppermission) {
		em.persist(relshoppermission);
		return relshoppermission;
	}

	public RelShopPermission update(RelShopPermission relshoppermission) {
		return em.merge(relshoppermission);
	}
	
	public void popularityByKey(Object key) {
		RelShopPermission relshoppermission = findById(key, false);
		
		if(relshoppermission != null){
			if (SObject.class.isAssignableFrom(RelShopPermission.class)) {
				if (relshoppermission.getPopularity() == null) {
					relshoppermission.setPopularity(-1);
				}
				relshoppermission.setPopularity(relshoppermission.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelShopPermission.class)
							.setParameter("popularity", relshoppermission.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelShopPermission item) {
		RelShopPermission relshoppermission = null;
		if(item != null){
			relshoppermission = findById(item.getId(), false);
		}
		
		if(relshoppermission != null){
			if (SObject.class.isAssignableFrom(RelShopPermission.class)) {
				if (relshoppermission.getPopularity() == null) {
					relshoppermission.setPopularity(-1);
				}
				relshoppermission.setPopularity(relshoppermission.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelShopPermission.class)
							.setParameter("popularity", relshoppermission.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelShopPermission.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelShopPermission> namedFilter(ScrollableSettings settings) {
		List<RelShopPermission> relshoppermissions = new ArrayList<RelShopPermission>();
		
		try {
			relshoppermissions = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelShopPermission.class), settings,
				RelShopPermission.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relshoppermissions;
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermission> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelShopPermission>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelShopPermission(), settings.getFilter(), RelShopPermission.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelShopPermission.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelShopPermission.class)), RelShopPermission.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelShopPermission.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermission> findByExample(RelShopPermission example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelShopPermission.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelShopPermission.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelShopPermission> findByExample2(RelShopPermission example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelShopPermission.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermission> findAll(ScrollableSettings settings) {
		List<RelShopPermission> relshoppermissions = DaoUtil.sasQuery(selectClause, settings,
				RelShopPermission.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelShopPermission item : relshoppermissions) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelShopPermission item : relshoppermissions) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relshoppermissions;
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermission> findAllScrollable(ScrollableSettings settings) {
		List<RelShopPermission> relshoppermissions = DaoUtil
				.sasQuery(selectClause, settings, RelShopPermission.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelShopPermission item : relshoppermissions) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelShopPermission item : relshoppermissions) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relshoppermissions;
	}

	public RelShopPermission findById(Object key, Boolean initAll) {
		RelShopPermission item = em.find(RelShopPermission.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelShopPermission findById(ScrollableSettings settings) {
		RelShopPermission item = em.find(RelShopPermission.class, settings.getId());

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
			em.remove(em.getReference(RelShopPermission.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
