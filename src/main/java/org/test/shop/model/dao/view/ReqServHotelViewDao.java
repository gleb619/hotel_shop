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
import org.test.shop.model.domain.entity.view.ReqServHotelView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ReqServHotelViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT req0 FROM ReqServHotelView req0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "req0";
	private String className = "ReqServHotelView";
	private String tableName = "req_serv_hotel_view";

	public ReqServHotelView create(ReqServHotelView reqservhotelview) {
		em.persist(reqservhotelview);
		return reqservhotelview;
	}

	public ReqServHotelView update(ReqServHotelView reqservhotelview) {
		return em.merge(reqservhotelview);
	}
	
	public void popularityByKey(Object key) {
		ReqServHotelView reqservhotelview = findById(key, false);
		
		if(reqservhotelview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelView.class)) {
				if (reqservhotelview.getPopularity() == null) {
					reqservhotelview.setPopularity(-1);
				}
				reqservhotelview.setPopularity(reqservhotelview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelView.class)
							.setParameter("popularity", reqservhotelview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ReqServHotelView item) {
		ReqServHotelView reqservhotelview = null;
		if(item != null){
			reqservhotelview = findById(item.getId(), false);
		}
		
		if(reqservhotelview != null){
			if (SObject.class.isAssignableFrom(ReqServHotelView.class)) {
				if (reqservhotelview.getPopularity() == null) {
					reqservhotelview.setPopularity(-1);
				}
				reqservhotelview.setPopularity(reqservhotelview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ReqServHotelView.class)
							.setParameter("popularity", reqservhotelview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ReqServHotelView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ReqServHotelView> namedFilter(ScrollableSettings settings) {
		List<ReqServHotelView> reqservhotelviews = new ArrayList<ReqServHotelView>();
		
		try {
			reqservhotelviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ReqServHotelView.class), settings,
				ReqServHotelView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reqservhotelviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ReqServHotelView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ReqServHotelView(), settings.getFilter(), ReqServHotelView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ReqServHotelView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ReqServHotelView.class)), ReqServHotelView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ReqServHotelView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelView> findByExample(ReqServHotelView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ReqServHotelView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ReqServHotelView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ReqServHotelView> findByExample2(ReqServHotelView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ReqServHotelView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelView> findAll(ScrollableSettings settings) {
		List<ReqServHotelView> reqservhotelviews = DaoUtil.sasQuery(selectClause, settings,
				ReqServHotelView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelView item : reqservhotelviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelView item : reqservhotelviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelviews;
	}

	@SuppressWarnings("unchecked")
	public List<ReqServHotelView> findAllScrollable(ScrollableSettings settings) {
		List<ReqServHotelView> reqservhotelviews = DaoUtil
				.sasQuery(selectClause, settings, ReqServHotelView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ReqServHotelView item : reqservhotelviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ReqServHotelView item : reqservhotelviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reqservhotelviews;
	}

	public ReqServHotelView findById(Object key, Boolean initAll) {
		ReqServHotelView item = em.find(ReqServHotelView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ReqServHotelView findById(ScrollableSettings settings) {
		ReqServHotelView item = em.find(ReqServHotelView.class, settings.getId());

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
			em.remove(em.getReference(ReqServHotelView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
