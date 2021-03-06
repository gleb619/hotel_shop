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
import org.test.shop.model.domain.entity.LocationCities;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationCitiesDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationCities loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationCities";
	private String tableName = "location_cities";

	public LocationCities create(LocationCities locationcities) {
		em.persist(locationcities);
		return locationcities;
	}

	public LocationCities update(LocationCities locationcities) {
		return em.merge(locationcities);
	}
	
	public void popularityByKey(Object key) {
		LocationCities locationcities = findById(key, false);
		
		if(locationcities != null){
			if (SObject.class.isAssignableFrom(LocationCities.class)) {
				if (locationcities.getPopularity() == null) {
					locationcities.setPopularity(-1);
				}
				locationcities.setPopularity(locationcities.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCities.class)
							.setParameter("popularity", locationcities.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationCities item) {
		LocationCities locationcities = null;
		if(item != null){
			locationcities = findById(item.getId(), false);
		}
		
		if(locationcities != null){
			if (SObject.class.isAssignableFrom(LocationCities.class)) {
				if (locationcities.getPopularity() == null) {
					locationcities.setPopularity(-1);
				}
				locationcities.setPopularity(locationcities.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCities.class)
							.setParameter("popularity", locationcities.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationCities.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationCities> namedFilter(ScrollableSettings settings) {
		List<LocationCities> locationcitiess = new ArrayList<LocationCities>();
		
		try {
			locationcitiess = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationCities.class), settings,
				LocationCities.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationcitiess;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCities> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationCities>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationCities(), settings.getFilter(), LocationCities.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationCities.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationCities.class)), LocationCities.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationCities.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCities> findByExample(LocationCities example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationCities.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationCities.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationCities> findByExample2(LocationCities example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationCities.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCities> findAll(ScrollableSettings settings) {
		List<LocationCities> locationcitiess = DaoUtil.sasQuery(selectClause, settings,
				LocationCities.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCities item : locationcitiess) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCities item : locationcitiess) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcitiess;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCities> findAllScrollable(ScrollableSettings settings) {
		List<LocationCities> locationcitiess = DaoUtil
				.sasQuery(selectClause, settings, LocationCities.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCities item : locationcitiess) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCities item : locationcitiess) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcitiess;
	}

	public LocationCities findById(Object key, Boolean initAll) {
		LocationCities item = em.find(LocationCities.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationCities findById(ScrollableSettings settings) {
		LocationCities item = em.find(LocationCities.class, settings.getId());

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
			em.remove(em.getReference(LocationCities.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
