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
import org.test.shop.model.domain.entity.view.ReqServHotelProcessedView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ReqServHotelProcessedViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT req0 FROM ReqServHotelProcessedView req0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "req0";
	private String className = "ReqServHotelProcessedView";
	private String tableName = "req_serv_hotel_processed_view";

	public ReqServHotelProcessedView create(ReqServHotelProcessedView reqservhotelprocessedview) {
		em.persist(reqservhotelprocessedview);
		return reqservhotelprocessedview;
	}

	public ReqServHotelProcessedView update(ReqServHotelProcessedView reqservhotelprocessedview) {
		return em.merge(reqservhotelprocessedview);
	}
	
	public void popularityByKey(Object key) {
		ReqServHotelProcessedView reqservhotelprocessedview = findById(key, false);
		
		if(reqservhotelprocessedview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelProcessedView.class)) {
				if (reqservhotelprocessedview.getPopularity() == null) {
					reqservhotelprocessedview.setPopularity(-1);
				}
				reqservhotelprocessedview.setPopularity(reqservhotelprocessedview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelProcessedView.class)
							.setParameter("popularity", reqservhotelprocessedview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ReqServHotelProcessedView item) {
		ReqServHotelProcessedView reqservhotelprocessedview = null;
		if(item != null){
			reqservhotelprocessedview = findById(item.getId(), false);
		}
		
		if(reqservhotelprocessedview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelProcessedView.class)) {
				if (reqservhotelprocessedview.getPopularity() == null) {
					reqservhotelprocessedview.setPopularity(-1);
				}
				reqservhotelprocessedview.setPopularity(reqservhotelprocessedview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelProcessedView.class)
							.setParameter("popularity", reqservhotelprocessedview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ReqServHotelProcessedView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ReqServHotelProcessedView> namedFilter(ScrollableSettings settings) {
		List<ReqServHotelProcessedView> reqservhotelprocessedviews = new ArrayList<ReqServHotelProcessedView>();
		
		try {
			reqservhotelprocessedviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ReqServHotelProcessedView.class), settings,
				ReqServHotelProcessedView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reqservhotelprocessedviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelProcessedView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ReqServHotelProcessedView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ReqServHotelProcessedView(), settings.getFilter(), ReqServHotelProcessedView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ReqServHotelProcessedView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ReqServHotelProcessedView.class)), ReqServHotelProcessedView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ReqServHotelProcessedView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelProcessedView> findByExample(ReqServHotelProcessedView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ReqServHotelProcessedView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ReqServHotelProcessedView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReqServHotelProcessedView> findByExample2(ReqServHotelProcessedView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ReqServHotelProcessedView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelProcessedView> findAll(ScrollableSettings settings) {
		List<ReqServHotelProcessedView> reqservhotelprocessedviews = DaoUtil.sasQuery(selectClause, settings,
				ReqServHotelProcessedView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelProcessedView item : reqservhotelprocessedviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelProcessedView item : reqservhotelprocessedviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelprocessedviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelProcessedView> findAllScrollable(ScrollableSettings settings) {
		List<ReqServHotelProcessedView> reqservhotelprocessedviews = DaoUtil
				.sasQuery(selectClause, settings, ReqServHotelProcessedView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelProcessedView item : reqservhotelprocessedviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelProcessedView item : reqservhotelprocessedviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelprocessedviews;
	}

	public ReqServHotelProcessedView findById(Object key, Boolean initAll) {
		ReqServHotelProcessedView item = em.find(ReqServHotelProcessedView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ReqServHotelProcessedView findById(ScrollableSettings settings) {
		ReqServHotelProcessedView item = em.find(ReqServHotelProcessedView.class, settings.getId());

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
			em.remove(em.getReference(ReqServHotelProcessedView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
