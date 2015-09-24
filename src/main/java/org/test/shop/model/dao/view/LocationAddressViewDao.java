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
import org.test.shop.model.domain.entity.view.LocationAddressView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class LocationAddressViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT loc0 FROM LocationAddressView loc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "loc0";
	private String className = "LocationAddressView";
	private String tableName = "location_address_view";

	public LocationAddressView create(LocationAddressView locationaddressview) {
		em.persist(locationaddressview);
		return locationaddressview;
	}

	public LocationAddressView update(LocationAddressView locationaddressview) {
		return em.merge(locationaddressview);
	}
	
	public void popularityByKey(Object key) {
		LocationAddressView locationaddressview = findById(key, false);
		
		if(locationaddressview != null){
			if (SObject.class.isAssignableFrom(LocationAddressView.class)) {
				if (locationaddressview.getPopularity() == null) {
					locationaddressview.setPopularity(-1);
				}
				locationaddressview.setPopularity(locationaddressview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationAddressView.class)
							.setParameter("popularity", locationaddressview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(LocationAddressView item) {
		LocationAddressView locationaddressview = null;
		if(item != null){
			locationaddressview = findById(item.getId(), false);
		}
		
		if(locationaddressview != null){
			if (SObject.class.isAssignableFrom(LocationAddressView.class)) {
				if (locationaddressview.getPopularity() == null) {
					locationaddressview.setPopularity(-1);
				}
				locationaddressview.setPopularity(locationaddressview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), LocationAddressView.class)
							.setParameter("popularity", locationaddressview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, LocationAddressView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<LocationAddressView> namedFilter(ScrollableSettings settings) {
		List<LocationAddressView> locationaddressviews = new ArrayList<LocationAddressView>();
		
		try {
			locationaddressviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), LocationAddressView.class), settings,
				LocationAddressView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return locationaddressviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddressView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<LocationAddressView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new LocationAddressView(), settings.getFilter(), LocationAddressView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, LocationAddressView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(LocationAddressView.class)), LocationAddressView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, LocationAddressView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddressView> findByExample(LocationAddressView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				LocationAddressView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, LocationAddressView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocationAddressView> findByExample2(LocationAddressView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, LocationAddressView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddressView> findAll(ScrollableSettings settings) {
		List<LocationAddressView> locationaddressviews = DaoUtil.sasQuery(selectClause, settings,
				LocationAddressView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationAddressView item : locationaddressviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationAddressView item : locationaddressviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationaddressviews;
	}

	@SuppressWarnings("unchecked")
	public List<LocationAddressView> findAllScrollable(ScrollableSettings settings) {
		List<LocationAddressView> locationaddressviews = DaoUtil
				.sasQuery(selectClause, settings, LocationAddressView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (LocationAddressView item : locationaddressviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (LocationAddressView item : locationaddressviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return locationaddressviews;
	}

	public LocationAddressView findById(Object key, Boolean initAll) {
		LocationAddressView item = em.find(LocationAddressView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public LocationAddressView findById(ScrollableSettings settings) {
		LocationAddressView item = em.find(LocationAddressView.class, settings.getId());

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
			em.remove(em.getReference(LocationAddressView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
