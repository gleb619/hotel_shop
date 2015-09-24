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
import org.test.shop.model.domain.entity.ShopUser;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopUserDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopUser sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopUser";
	private String tableName = "shop_user";

	public ShopUser create(ShopUser shopuser) {
		em.persist(shopuser);
		return shopuser;
	}

	public ShopUser update(ShopUser shopuser) {
		return em.merge(shopuser);
	}
	
	public void popularityByKey(Object key) {
		ShopUser shopuser = findById(key, false);
		
		if(shopuser != null){
			if (SObject.class.isAssignableFrom(ShopUser.class)) {
				if (shopuser.getPopularity() == null) {
					shopuser.setPopularity(-1);
				}
				shopuser.setPopularity(shopuser.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopUser.class)
							.setParameter("popularity", shopuser.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopUser item) {
		ShopUser shopuser = null;
		if(item != null){
			shopuser = findById(item.getId(), false);
		}
		
		if(shopuser != null){
			if (SObject.class.isAssignableFrom(ShopUser.class)) {
				if (shopuser.getPopularity() == null) {
					shopuser.setPopularity(-1);
				}
				shopuser.setPopularity(shopuser.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopUser.class)
							.setParameter("popularity", shopuser.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopUser.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopUser> namedFilter(ScrollableSettings settings) {
		List<ShopUser> shopusers = new ArrayList<ShopUser>();
		
		try {
			shopusers = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopUser.class), settings,
				ShopUser.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shopusers;
	}

	@SuppressWarnings("unchecked")
	public List<ShopUser> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopUser>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopUser(), settings.getFilter(), ShopUser.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopUser.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopUser.class)), ShopUser.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopUser.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopUser> findByExample(ShopUser example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopUser.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopUser.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopUser> findByExample2(ShopUser example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopUser.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopUser> findAll(ScrollableSettings settings) {
		List<ShopUser> shopusers = DaoUtil.sasQuery(selectClause, settings,
				ShopUser.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopUser item : shopusers) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopUser item : shopusers) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shopusers;
	}

	@SuppressWarnings("unchecked")
	public List<ShopUser> findAllScrollable(ScrollableSettings settings) {
		List<ShopUser> shopusers = DaoUtil
				.sasQuery(selectClause, settings, ShopUser.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopUser item : shopusers) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopUser item : shopusers) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shopusers;
	}

	public ShopUser findById(Object key, Boolean initAll) {
		ShopUser item = em.find(ShopUser.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopUser findById(ScrollableSettings settings) {
		ShopUser item = em.find(ShopUser.class, settings.getId());

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
			em.remove(em.getReference(ShopUser.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
