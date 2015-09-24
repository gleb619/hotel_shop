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
import org.test.shop.model.domain.entity.LocationCountries;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationCountriesDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationCountries loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationCountries";
	private String tableName = "location_countries";

	public LocationCountries create(LocationCountries locationcountries) {
		em.persist(locationcountries);
		return locationcountries;
	}

	public LocationCountries update(LocationCountries locationcountries) {
		return em.merge(locationcountries);
	}
	
	public void popularityByKey(Object key) {
		LocationCountries locationcountries = findById(key, false);
		
		if(locationcountries != null){
			if (SObject.class.isAssignableFrom(LocationCountries.class)) {
				if (locationcountries.getPopularity() == null) {
					locationcountries.setPopularity(-1);
				}
				locationcountries.setPopularity(locationcountries.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCountries.class)
							.setParameter("popularity", locationcountries.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationCountries item) {
		LocationCountries locationcountries = null;
		if(item != null){
			locationcountries = findById(item.getId(), false);
		}
		
		if(locationcountries != null){
			if (SObject.class.isAssignableFrom(LocationCountries.class)) {
				if (locationcountries.getPopularity() == null) {
					locationcountries.setPopularity(-1);
				}
				locationcountries.setPopularity(locationcountries.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCountries.class)
							.setParameter("popularity", locationcountries.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationCountries.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationCountries> namedFilter(ScrollableSettings settings) {
		List<LocationCountries> locationcountriess = new ArrayList<LocationCountries>();
		
		try {
			locationcountriess = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationCountries.class), settings,
				LocationCountries.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationcountriess;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountries> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationCountries>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationCountries(), settings.getFilter(), LocationCountries.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationCountries.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationCountries.class)), LocationCountries.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationCountries.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountries> findByExample(LocationCountries example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationCountries.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationCountries.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationCountries> findByExample2(LocationCountries example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationCountries.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountries> findAll(ScrollableSettings settings) {
		List<LocationCountries> locationcountriess = DaoUtil.sasQuery(selectClause, settings,
				LocationCountries.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCountries item : locationcountriess) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCountries item : locationcountriess) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcountriess;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountries> findAllScrollable(ScrollableSettings settings) {
		List<LocationCountries> locationcountriess = DaoUtil
				.sasQuery(selectClause, settings, LocationCountries.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCountries item : locationcountriess) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCountries item : locationcountriess) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcountriess;
	}

	public LocationCountries findById(Object key, Boolean initAll) {
		LocationCountries item = em.find(LocationCountries.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationCountries findById(ScrollableSettings settings) {
		LocationCountries item = em.find(LocationCountries.class, settings.getId());

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
			em.remove(em.getReference(LocationCountries.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
