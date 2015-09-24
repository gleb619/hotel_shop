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
import org.test.shop.model.domain.entity.TmFirms;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmFirmsDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmf0 FROM TmFirms tmf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmf0";
	private String className = "TmFirms";
	private String tableName = "tm_firms";

	public TmFirms create(TmFirms tmfirms) {
		em.persist(tmfirms);
		return tmfirms;
	}

	public TmFirms update(TmFirms tmfirms) {
		return em.merge(tmfirms);
	}
	
	public void popularityByKey(Object key) {
		TmFirms tmfirms = findById(key, false);
		
		if(tmfirms != null){
			if (SObject.class.isAssignableFrom(TmFirms.class)) {
				if (tmfirms.getPopularity() == null) {
					tmfirms.setPopularity(-1);
				}
				tmfirms.setPopularity(tmfirms.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirms.class)
							.setParameter("popularity", tmfirms.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmFirms item) {
		TmFirms tmfirms = null;
		if(item != null){
			tmfirms = findById(item.getId(), false);
		}
		
		if(tmfirms != null){
			if (SObject.class.isAssignableFrom(TmFirms.class)) {
				if (tmfirms.getPopularity() == null) {
					tmfirms.setPopularity(-1);
				}
				tmfirms.setPopularity(tmfirms.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirms.class)
							.setParameter("popularity", tmfirms.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmFirms.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmFirms> namedFilter(ScrollableSettings settings) {
		List<TmFirms> tmfirmss = new ArrayList<TmFirms>();
		
		try {
			tmfirmss = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmFirms.class), settings,
				TmFirms.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmfirmss;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirms> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmFirms>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmFirms(), settings.getFilter(), TmFirms.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmFirms.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmFirms.class)), TmFirms.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmFirms.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirms> findByExample(TmFirms example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmFirms.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmFirms.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmFirms> findByExample2(TmFirms example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmFirms.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirms> findAll(ScrollableSettings settings) {
		List<TmFirms> tmfirmss = DaoUtil.sasQuery(selectClause, settings,
				TmFirms.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirms item : tmfirmss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirms item : tmfirmss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmss;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirms> findAllScrollable(ScrollableSettings settings) {
		List<TmFirms> tmfirmss = DaoUtil
				.sasQuery(selectClause, settings, TmFirms.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirms item : tmfirmss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirms item : tmfirmss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmss;
	}

	public TmFirms findById(Object key, Boolean initAll) {
		TmFirms item = em.find(TmFirms.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmFirms findById(ScrollableSettings settings) {
		TmFirms item = em.find(TmFirms.class, settings.getId());

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
			em.remove(em.getReference(TmFirms.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
