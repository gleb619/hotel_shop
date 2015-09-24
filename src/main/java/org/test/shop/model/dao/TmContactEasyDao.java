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
import org.test.shop.model.domain.entity.TmContactEasy;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmContactEasyDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmc0 FROM TmContactEasy tmc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmc0";
	private String className = "TmContactEasy";
	private String tableName = "tm_contact_easy";

	public TmContactEasy create(TmContactEasy tmcontacteasy) {
		em.persist(tmcontacteasy);
		return tmcontacteasy;
	}

	public TmContactEasy update(TmContactEasy tmcontacteasy) {
		return em.merge(tmcontacteasy);
	}
	
	public void popularityByKey(Object key) {
		TmContactEasy tmcontacteasy = findById(key, false);
		
		if(tmcontacteasy != null){
			if (SObject.class.isAssignableFrom(TmContactEasy.class)) {
				if (tmcontacteasy.getPopularity() == null) {
					tmcontacteasy.setPopularity(-1);
				}
				tmcontacteasy.setPopularity(tmcontacteasy.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactEasy.class)
							.setParameter("popularity", tmcontacteasy.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmContactEasy item) {
		TmContactEasy tmcontacteasy = null;
		if(item != null){
			tmcontacteasy = findById(item.getId(), false);
		}
		
		if(tmcontacteasy != null){
			if (SObject.class.isAssignableFrom(TmContactEasy.class)) {
				if (tmcontacteasy.getPopularity() == null) {
					tmcontacteasy.setPopularity(-1);
				}
				tmcontacteasy.setPopularity(tmcontacteasy.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactEasy.class)
							.setParameter("popularity", tmcontacteasy.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmContactEasy.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmContactEasy> namedFilter(ScrollableSettings settings) {
		List<TmContactEasy> tmcontacteasys = new ArrayList<TmContactEasy>();
		
		try {
			tmcontacteasys = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmContactEasy.class), settings,
				TmContactEasy.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmcontacteasys;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasy> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmContactEasy>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmContactEasy(), settings.getFilter(), TmContactEasy.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmContactEasy.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmContactEasy.class)), TmContactEasy.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmContactEasy.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasy> findByExample(TmContactEasy example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmContactEasy.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmContactEasy.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmContactEasy> findByExample2(TmContactEasy example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmContactEasy.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasy> findAll(ScrollableSettings settings) {
		List<TmContactEasy> tmcontacteasys = DaoUtil.sasQuery(selectClause, settings,
				TmContactEasy.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactEasy item : tmcontacteasys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactEasy item : tmcontacteasys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacteasys;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasy> findAllScrollable(ScrollableSettings settings) {
		List<TmContactEasy> tmcontacteasys = DaoUtil
				.sasQuery(selectClause, settings, TmContactEasy.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactEasy item : tmcontacteasys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactEasy item : tmcontacteasys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacteasys;
	}

	public TmContactEasy findById(Object key, Boolean initAll) {
		TmContactEasy item = em.find(TmContactEasy.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmContactEasy findById(ScrollableSettings settings) {
		TmContactEasy item = em.find(TmContactEasy.class, settings.getId());

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
			em.remove(em.getReference(TmContactEasy.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
