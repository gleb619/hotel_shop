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
import org.test.shop.model.domain.entity.view.ReqServHotelOpenView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ReqServHotelOpenViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT req0 FROM ReqServHotelOpenView req0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "req0";
	private String className = "ReqServHotelOpenView";
	private String tableName = "req_serv_hotel_open_view";

	public ReqServHotelOpenView create(ReqServHotelOpenView reqservhotelopenview) {
		em.persist(reqservhotelopenview);
		return reqservhotelopenview;
	}

	public ReqServHotelOpenView update(ReqServHotelOpenView reqservhotelopenview) {
		return em.merge(reqservhotelopenview);
	}
	
	public void popularityByKey(Object key) {
		ReqServHotelOpenView reqservhotelopenview = findById(key, false);
		
		if(reqservhotelopenview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelOpenView.class)) {
				if (reqservhotelopenview.getPopularity() == null) {
					reqservhotelopenview.setPopularity(-1);
				}
				reqservhotelopenview.setPopularity(reqservhotelopenview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelOpenView.class)
							.setParameter("popularity", reqservhotelopenview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ReqServHotelOpenView item) {
		ReqServHotelOpenView reqservhotelopenview = null;
		if(item != null){
			reqservhotelopenview = findById(item.getId(), false);
		}
		
		if(reqservhotelopenview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelOpenView.class)) {
				if (reqservhotelopenview.getPopularity() == null) {
					reqservhotelopenview.setPopularity(-1);
				}
				reqservhotelopenview.setPopularity(reqservhotelopenview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelOpenView.class)
							.setParameter("popularity", reqservhotelopenview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ReqServHotelOpenView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ReqServHotelOpenView> namedFilter(ScrollableSettings settings) {
		List<ReqServHotelOpenView> reqservhotelopenviews = new ArrayList<ReqServHotelOpenView>();
		
		try {
			reqservhotelopenviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ReqServHotelOpenView.class), settings,
				ReqServHotelOpenView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reqservhotelopenviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelOpenView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ReqServHotelOpenView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ReqServHotelOpenView(), settings.getFilter(), ReqServHotelOpenView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ReqServHotelOpenView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ReqServHotelOpenView.class)), ReqServHotelOpenView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ReqServHotelOpenView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelOpenView> findByExample(ReqServHotelOpenView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ReqServHotelOpenView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ReqServHotelOpenView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReqServHotelOpenView> findByExample2(ReqServHotelOpenView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ReqServHotelOpenView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelOpenView> findAll(ScrollableSettings settings) {
		List<ReqServHotelOpenView> reqservhotelopenviews = DaoUtil.sasQuery(selectClause, settings,
				ReqServHotelOpenView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelOpenView item : reqservhotelopenviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelOpenView item : reqservhotelopenviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelopenviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelOpenView> findAllScrollable(ScrollableSettings settings) {
		List<ReqServHotelOpenView> reqservhotelopenviews = DaoUtil
				.sasQuery(selectClause, settings, ReqServHotelOpenView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelOpenView item : reqservhotelopenviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelOpenView item : reqservhotelopenviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelopenviews;
	}

	public ReqServHotelOpenView findById(Object key, Boolean initAll) {
		ReqServHotelOpenView item = em.find(ReqServHotelOpenView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ReqServHotelOpenView findById(ScrollableSettings settings) {
		ReqServHotelOpenView item = em.find(ReqServHotelOpenView.class, settings.getId());

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
			em.remove(em.getReference(ReqServHotelOpenView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
