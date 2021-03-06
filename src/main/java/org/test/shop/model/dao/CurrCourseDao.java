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
import org.test.shop.model.domain.entity.CurrCourse;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class CurrCourseDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT cur0 FROM CurrCourse cur0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "cur0";
	private String className = "CurrCourse";
	private String tableName = "curr_course";

	public CurrCourse create(CurrCourse currcourse) {
		em.persist(currcourse);
		return currcourse;
	}

	public CurrCourse update(CurrCourse currcourse) {
		return em.merge(currcourse);
	}
	
	public void popularityByKey(Object key) {
		CurrCourse currcourse = findById(key, false);
		
		if(currcourse != null){
			if (SObject.class.isAssignableFrom(CurrCourse.class)) {
				if (currcourse.getPopularity() == null) {
					currcourse.setPopularity(-1);
				}
				currcourse.setPopularity(currcourse.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCourse.class)
							.setParameter("popularity", currcourse.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(CurrCourse item) {
		CurrCourse currcourse = null;
		if(item != null){
			currcourse = findById(item.getId(), false);
		}
		
		if(currcourse != null){
			if (SObject.class.isAssignableFrom(CurrCourse.class)) {
				if (currcourse.getPopularity() == null) {
					currcourse.setPopularity(-1);
				}
				currcourse.setPopularity(currcourse.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCourse.class)
							.setParameter("popularity", currcourse.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, CurrCourse.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<CurrCourse> namedFilter(ScrollableSettings settings) {
		List<CurrCourse> currcourses = new ArrayList<CurrCourse>();
		
		try {
			currcourses = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), CurrCourse.class), settings,
				CurrCourse.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return currcourses;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourse> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<CurrCourse>();
		}
	
		FindByExample findByExample = DaoUtil.search(new CurrCourse(), settings.getFilter(), CurrCourse.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, CurrCourse.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(CurrCourse.class)), CurrCourse.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, CurrCourse.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourse> findByExample(CurrCourse example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				CurrCourse.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, CurrCourse.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CurrCourse> findByExample2(CurrCourse example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, CurrCourse.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourse> findAll(ScrollableSettings settings) {
		List<CurrCourse> currcourses = DaoUtil.sasQuery(selectClause, settings,
				CurrCourse.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCourse item : currcourses) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCourse item : currcourses) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcourses;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCourse> findAllScrollable(ScrollableSettings settings) {
		List<CurrCourse> currcourses = DaoUtil
				.sasQuery(selectClause, settings, CurrCourse.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCourse item : currcourses) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCourse item : currcourses) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcourses;
	}

	public CurrCourse findById(Object key, Boolean initAll) {
		CurrCourse item = em.find(CurrCourse.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public CurrCourse findById(ScrollableSettings settings) {
		CurrCourse item = em.find(CurrCourse.class, settings.getId());

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
			em.remove(em.getReference(CurrCourse.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
