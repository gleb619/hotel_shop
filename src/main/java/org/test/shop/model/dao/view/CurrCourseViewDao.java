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
import org.test.shop.model.domain.entity.view.CurrCourseView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class CurrCourseViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT cur0 FROM CurrCourseView cur0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "cur0";
	private String className = "CurrCourseView";
	private String tableName = "curr_course_view";

	public CurrCourseView create(CurrCourseView currcourseview) {
		em.persist(currcourseview);
		return currcourseview;
	}

	public CurrCourseView update(CurrCourseView currcourseview) {
		return em.merge(currcourseview);
	}
	
	public void popularityByKey(Object key) {
		CurrCourseView currcourseview = findById(key, false);
		
		if(currcourseview != null){
			if (SObject.class.isAssignableFrom(CurrCourseView.class)) {
				if (currcourseview.getPopularity() == null) {
					currcourseview.setPopularity(-1);
				}
				currcourseview.setPopularity(currcourseview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCourseView.class)
							.setParameter("popularity", currcourseview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(CurrCourseView item) {
		CurrCourseView currcourseview = null;
		if(item != null){
			currcourseview = findById(item.getId(), false);
		}
		
		if(currcourseview != null){
			if (SObject.class.isAssignableFrom(CurrCourseView.class)) {
				if (currcourseview.getPopularity() == null) {
					currcourseview.setPopularity(-1);
				}
				currcourseview.setPopularity(currcourseview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCourseView.class)
							.setParameter("popularity", currcourseview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, CurrCourseView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<CurrCourseView> namedFilter(ScrollableSettings settings) {
		List<CurrCourseView> currcourseviews = new ArrayList<CurrCourseView>();
		
		try {
			currcourseviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), CurrCourseView.class), settings,
				CurrCourseView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return currcourseviews;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourseView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<CurrCourseView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new CurrCourseView(), settings.getFilter(), CurrCourseView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, CurrCourseView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(CurrCourseView.class)), CurrCourseView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, CurrCourseView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourseView> findByExample(CurrCourseView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				CurrCourseView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, CurrCourseView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CurrCourseView> findByExample2(CurrCourseView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, CurrCourseView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourseView> findAll(ScrollableSettings settings) {
		List<CurrCourseView> currcourseviews = DaoUtil.sasQuery(selectClause, settings,
				CurrCourseView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCourseView item : currcourseviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCourseView item : currcourseviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcourseviews;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourseView> findAllScrollable(ScrollableSettings settings) {
		List<CurrCourseView> currcourseviews = DaoUtil
				.sasQuery(selectClause, settings, CurrCourseView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCourseView item : currcourseviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCourseView item : currcourseviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcourseviews;
	}

	public CurrCourseView findById(Object key, Boolean initAll) {
		CurrCourseView item = em.find(CurrCourseView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public CurrCourseView findById(ScrollableSettings settings) {
		CurrCourseView item = em.find(CurrCourseView.class, settings.getId());

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
			em.remove(em.getReference(CurrCourseView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
