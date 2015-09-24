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
import org.test.shop.model.domain.entity.view.ReqServHotelArchivedView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ReqServHotelArchivedViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT req0 FROM ReqServHotelArchivedView req0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "req0";
	private String className = "ReqServHotelArchivedView";
	private String tableName = "req_serv_hotel_archived_view";

	public ReqServHotelArchivedView create(ReqServHotelArchivedView reqservhotelarchivedview) {
		em.persist(reqservhotelarchivedview);
		return reqservhotelarchivedview;
	}

	public ReqServHotelArchivedView update(ReqServHotelArchivedView reqservhotelarchivedview) {
		return em.merge(reqservhotelarchivedview);
	}
	
	public void popularityByKey(Object key) {
		ReqServHotelArchivedView reqservhotelarchivedview = findById(key, false);
		
		if(reqservhotelarchivedview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelArchivedView.class)) {
				if (reqservhotelarchivedview.getPopularity() == null) {
					reqservhotelarchivedview.setPopularity(-1);
				}
				reqservhotelarchivedview.setPopularity(reqservhotelarchivedview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelArchivedView.class)
							.setParameter("popularity", reqservhotelarchivedview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ReqServHotelArchivedView item) {
		ReqServHotelArchivedView reqservhotelarchivedview = null;
		if(item != null){
			reqservhotelarchivedview = findById(item.getId(), false);
		}
		
		if(reqservhotelarchivedview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelArchivedView.class)) {
				if (reqservhotelarchivedview.getPopularity() == null) {
					reqservhotelarchivedview.setPopularity(-1);
				}
				reqservhotelarchivedview.setPopularity(reqservhotelarchivedview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelArchivedView.class)
							.setParameter("popularity", reqservhotelarchivedview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ReqServHotelArchivedView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ReqServHotelArchivedView> namedFilter(ScrollableSettings settings) {
		List<ReqServHotelArchivedView> reqservhotelarchivedviews = new ArrayList<ReqServHotelArchivedView>();
		
		try {
			reqservhotelarchivedviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ReqServHotelArchivedView.class), settings,
				ReqServHotelArchivedView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reqservhotelarchivedviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelArchivedView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ReqServHotelArchivedView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ReqServHotelArchivedView(), settings.getFilter(), ReqServHotelArchivedView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ReqServHotelArchivedView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ReqServHotelArchivedView.class)), ReqServHotelArchivedView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ReqServHotelArchivedView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelArchivedView> findByExample(ReqServHotelArchivedView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ReqServHotelArchivedView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ReqServHotelArchivedView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReqServHotelArchivedView> findByExample2(ReqServHotelArchivedView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ReqServHotelArchivedView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelArchivedView> findAll(ScrollableSettings settings) {
		List<ReqServHotelArchivedView> reqservhotelarchivedviews = DaoUtil.sasQuery(selectClause, settings,
				ReqServHotelArchivedView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelArchivedView item : reqservhotelarchivedviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelArchivedView item : reqservhotelarchivedviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelarchivedviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelArchivedView> findAllScrollable(ScrollableSettings settings) {
		List<ReqServHotelArchivedView> reqservhotelarchivedviews = DaoUtil
				.sasQuery(selectClause, settings, ReqServHotelArchivedView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelArchivedView item : reqservhotelarchivedviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelArchivedView item : reqservhotelarchivedviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelarchivedviews;
	}

	public ReqServHotelArchivedView findById(Object key, Boolean initAll) {
		ReqServHotelArchivedView item = em.find(ReqServHotelArchivedView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ReqServHotelArchivedView findById(ScrollableSettings settings) {
		ReqServHotelArchivedView item = em.find(ReqServHotelArchivedView.class, settings.getId());

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
			em.remove(em.getReference(ReqServHotelArchivedView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
