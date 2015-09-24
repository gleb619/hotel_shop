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
import org.test.shop.model.domain.entity.view.LocationCitiesView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationCitiesViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationCitiesView loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationCitiesView";
	private String tableName = "location_cities_view";

	public LocationCitiesView create(LocationCitiesView locationcitiesview) {
		em.persist(locationcitiesview);
		return locationcitiesview;
	}

	public LocationCitiesView update(LocationCitiesView locationcitiesview) {
		return em.merge(locationcitiesview);
	}
	
	public void popularityByKey(Object key) {
		LocationCitiesView locationcitiesview = findById(key, false);
		
		if(locationcitiesview != null){
			if (SObject.class.isAssignableFrom(LocationCitiesView.class)) {
				if (locationcitiesview.getPopularity() == null) {
					locationcitiesview.setPopularity(-1);
				}
				locationcitiesview.setPopularity(locationcitiesview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCitiesView.class)
							.setParameter("popularity", locationcitiesview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationCitiesView item) {
		LocationCitiesView locationcitiesview = null;
		if(item != null){
			locationcitiesview = findById(item.getId(), false);
		}
		
		if(locationcitiesview != null){
			if (SObject.class.isAssignableFrom(LocationCitiesView.class)) {
				if (locationcitiesview.getPopularity() == null) {
					locationcitiesview.setPopularity(-1);
				}
				locationcitiesview.setPopularity(locationcitiesview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationCitiesView.class)
							.setParameter("popularity", locationcitiesview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationCitiesView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationCitiesView> namedFilter(ScrollableSettings settings) {
		List<LocationCitiesView> locationcitiesviews = new ArrayList<LocationCitiesView>();
		
		try {
			locationcitiesviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationCitiesView.class), settings,
				LocationCitiesView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationcitiesviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCitiesView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationCitiesView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationCitiesView(), settings.getFilter(), LocationCitiesView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationCitiesView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationCitiesView.class)), LocationCitiesView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationCitiesView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCitiesView> findByExample(LocationCitiesView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationCitiesView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationCitiesView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationCitiesView> findByExample2(LocationCitiesView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationCitiesView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationCitiesView> findAll(ScrollableSettings settings) {
		List<LocationCitiesView> locationcitiesviews = DaoUtil.sasQuery(selectClause, settings,
				LocationCitiesView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCitiesView item : locationcitiesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCitiesView item : locationcitiesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcitiesviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationCitiesView> findAllScrollable(ScrollableSettings settings) {
		List<LocationCitiesView> locationcitiesviews = DaoUtil
				.sasQuery(selectClause, settings, LocationCitiesView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationCitiesView item : locationcitiesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationCitiesView item : locationcitiesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationcitiesviews;
	}

	public LocationCitiesView findById(Object key, Boolean initAll) {
		LocationCitiesView item = em.find(LocationCitiesView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationCitiesView findById(ScrollableSettings settings) {
		LocationCitiesView item = em.find(LocationCitiesView.class, settings.getId());

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
			em.remove(em.getReference(LocationCitiesView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
