package org.test.shop.model.dao.view;

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
import org.test.shop.model.domain.entity.view.LocationCountriesView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationCountriesViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationCountriesView loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationCountriesView";
	private String tableName = "location_countries_view";

	public LocationCountriesView create(LocationCountriesView locationcountriesview) {
		em.persist(locationcountriesview);
		return locationcountriesview;
	}

	public LocationCountriesView update(LocationCountriesView locationcountriesview) {
		return em.merge(locationcountriesview);
	}
	
	public void popularityByKey(Object key) {
		LocationCountriesView locationcountriesview = findById(key, false);
		
		if(locationcountriesview != null){
			if (SObject.class.isAssignableFrom(LocationCountriesView.class)) {
				if (locationcountriesview.getPopularity() == null) {
					locationcountriesview.setPopularity(-1);
				}
				locationcountriesview.setPopularity(locationcountriesview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCountriesView.class)
							.setParameter("popularity", locationcountriesview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationCountriesView item) {
		LocationCountriesView locationcountriesview = null;
		if(item != null){
			locationcountriesview = findById(item.getId(), false);
		}
		
		if(locationcountriesview != null){
			if (SObject.class.isAssignableFrom(LocationCountriesView.class)) {
				if (locationcountriesview.getPopularity() == null) {
					locationcountriesview.setPopularity(-1);
				}
				locationcountriesview.setPopularity(locationcountriesview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCountriesView.class)
							.setParameter("popularity", locationcountriesview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationCountriesView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationCountriesView> namedFilter(ScrollableSettings settings) {
		List<LocationCountriesView> locationcountriesviews = new ArrayList<LocationCountriesView>();
		
		try {
			locationcountriesviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationCountriesView.class), settings,
				LocationCountriesView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationcountriesviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountriesView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationCountriesView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationCountriesView(), settings.getFilter(), LocationCountriesView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationCountriesView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationCountriesView.class)), LocationCountriesView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationCountriesView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountriesView> findByExample(LocationCountriesView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationCountriesView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationCountriesView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationCountriesView> findByExample2(LocationCountriesView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationCountriesView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountriesView> findAll(ScrollableSettings settings) {
		List<LocationCountriesView> locationcountriesviews = DaoUtil.sasQuery(selectClause, settings,
				LocationCountriesView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCountriesView item : locationcountriesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCountriesView item : locationcountriesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcountriesviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCountriesView> findAllScrollable(ScrollableSettings settings) {
		List<LocationCountriesView> locationcountriesviews = DaoUtil
				.sasQuery(selectClause, settings, LocationCountriesView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCountriesView item : locationcountriesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCountriesView item : locationcountriesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcountriesviews;
	}

	public LocationCountriesView findById(Object key, Boolean initAll) {
		LocationCountriesView item = em.find(LocationCountriesView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationCountriesView findById(ScrollableSettings settings) {
		LocationCountriesView item = em.find(LocationCountriesView.class, settings.getId());

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
			em.remove(em.getReference(LocationCountriesView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
