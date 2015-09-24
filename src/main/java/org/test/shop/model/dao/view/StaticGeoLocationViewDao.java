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
import org.test.shop.model.domain.entity.view.StaticGeoLocationView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class StaticGeoLocationViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sta0 FROM StaticGeoLocationView sta0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sta0";
	private String className = "StaticGeoLocationView";
	private String tableName = "static_geo_location_view";

	public StaticGeoLocationView create(StaticGeoLocationView staticgeolocationview) {
		em.persist(staticgeolocationview);
		return staticgeolocationview;
	}

	public StaticGeoLocationView update(StaticGeoLocationView staticgeolocationview) {
		return em.merge(staticgeolocationview);
	}
	
	public void popularityByKey(Object key) {
		StaticGeoLocationView staticgeolocationview = findById(key, false);
		
		if(staticgeolocationview != null){
			if (SObject.class.isAssignableFrom(StaticGeoLocationView.class)) {
				if (staticgeolocationview.getPopularity() == null) {
					staticgeolocationview.setPopularity(-1);
				}
				staticgeolocationview.setPopularity(staticgeolocationview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), StaticGeoLocationView.class)
							.setParameter("popularity", staticgeolocationview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(StaticGeoLocationView item) {
		StaticGeoLocationView staticgeolocationview = null;
		if(item != null){
			staticgeolocationview = null;
		}
		
		if(staticgeolocationview != null){
			if (SObject.class.isAssignableFrom(StaticGeoLocationView.class)) {
				if (staticgeolocationview.getPopularity() == null) {
					staticgeolocationview.setPopularity(-1);
				}
				staticgeolocationview.setPopularity(staticgeolocationview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), StaticGeoLocationView.class)
							.setParameter("popularity", staticgeolocationview.getPopularity())
							.setParameter("id", -1)
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
		TotalQuery totalQuery = DaoUtil.total(settings, StaticGeoLocationView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<StaticGeoLocationView> namedFilter(ScrollableSettings settings) {
		List<StaticGeoLocationView> staticgeolocationviews = new ArrayList<StaticGeoLocationView>();
		
		try {
			staticgeolocationviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), StaticGeoLocationView.class), settings,
				StaticGeoLocationView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return staticgeolocationviews;
	}

	@SuppressWarnings("unchecked")
	public List<StaticGeoLocationView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<StaticGeoLocationView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new StaticGeoLocationView(), settings.getFilter(), StaticGeoLocationView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, StaticGeoLocationView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(StaticGeoLocationView.class)), StaticGeoLocationView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, StaticGeoLocationView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<StaticGeoLocationView> findByExample(StaticGeoLocationView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				StaticGeoLocationView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, StaticGeoLocationView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<StaticGeoLocationView> findByExample2(StaticGeoLocationView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, StaticGeoLocationView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<StaticGeoLocationView> findAll(ScrollableSettings settings) {
		List<StaticGeoLocationView> staticgeolocationviews = DaoUtil.sasQuery(selectClause, settings,
				StaticGeoLocationView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (StaticGeoLocationView item : staticgeolocationviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (StaticGeoLocationView item : staticgeolocationviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return staticgeolocationviews;
	}

	@SuppressWarnings("unchecked")
	public List<StaticGeoLocationView> findAllScrollable(ScrollableSettings settings) {
		List<StaticGeoLocationView> staticgeolocationviews = DaoUtil
				.sasQuery(selectClause, settings, StaticGeoLocationView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (StaticGeoLocationView item : staticgeolocationviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (StaticGeoLocationView item : staticgeolocationviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return staticgeolocationviews;
	}

	public StaticGeoLocationView findById(Object key, Boolean initAll) {
		StaticGeoLocationView item = em.find(StaticGeoLocationView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public StaticGeoLocationView findById(ScrollableSettings settings) {
		StaticGeoLocationView item = em.find(StaticGeoLocationView.class, settings.getId());

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
			em.remove(em.getReference(StaticGeoLocationView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
