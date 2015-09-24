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
import org.test.shop.model.domain.entity.LocationAddress;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationAddressDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationAddress loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationAddress";
	private String tableName = "location_address";

	public LocationAddress create(LocationAddress locationaddress) {
		em.persist(locationaddress);
		return locationaddress;
	}

	public LocationAddress update(LocationAddress locationaddress) {
		return em.merge(locationaddress);
	}
	
	public void popularityByKey(Object key) {
		LocationAddress locationaddress = findById(key, false);
		
		if(locationaddress != null){
			if (SObject.class.isAssignableFrom(LocationAddress.class)) {
				if (locationaddress.getPopularity() == null) {
					locationaddress.setPopularity(-1);
				}
				locationaddress.setPopularity(locationaddress.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationAddress.class)
							.setParameter("popularity", locationaddress.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationAddress item) {
		LocationAddress locationaddress = null;
		if(item != null){
			locationaddress = findById(item.getId(), false);
		}
		
		if(locationaddress != null){
			if (SObject.class.isAssignableFrom(LocationAddress.class)) {
				if (locationaddress.getPopularity() == null) {
					locationaddress.setPopularity(-1);
				}
				locationaddress.setPopularity(locationaddress.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationAddress.class)
							.setParameter("popularity", locationaddress.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationAddress.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationAddress> namedFilter(ScrollableSettings settings) {
		List<LocationAddress> locationaddresss = new ArrayList<LocationAddress>();
		
		try {
			locationaddresss = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationAddress.class), settings,
				LocationAddress.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationaddresss;
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddress> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationAddress>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationAddress(), settings.getFilter(), LocationAddress.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationAddress.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationAddress.class)), LocationAddress.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationAddress.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddress> findByExample(LocationAddress example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationAddress.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationAddress.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationAddress> findByExample2(LocationAddress example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationAddress.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddress> findAll(ScrollableSettings settings) {
		List<LocationAddress> locationaddresss = DaoUtil.sasQuery(selectClause, settings,
				LocationAddress.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationAddress item : locationaddresss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationAddress item : locationaddresss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationaddresss;
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddress> findAllScrollable(ScrollableSettings settings) {
		List<LocationAddress> locationaddresss = DaoUtil
				.sasQuery(selectClause, settings, LocationAddress.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationAddress item : locationaddresss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationAddress item : locationaddresss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationaddresss;
	}

	public LocationAddress findById(Object key, Boolean initAll) {
		LocationAddress item = em.find(LocationAddress.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationAddress findById(ScrollableSettings settings) {
		LocationAddress item = em.find(LocationAddress.class, settings.getId());

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
			em.remove(em.getReference(LocationAddress.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
