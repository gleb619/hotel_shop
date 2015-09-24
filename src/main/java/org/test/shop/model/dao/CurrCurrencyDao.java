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
import org.test.shop.model.domain.entity.CurrCurrency;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class CurrCurrencyDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT cur0 FROM CurrCurrency cur0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "cur0";
	private String className = "CurrCurrency";
	private String tableName = "curr_currency";

	public CurrCurrency create(CurrCurrency currcurrency) {
		em.persist(currcurrency);
		return currcurrency;
	}

	public CurrCurrency update(CurrCurrency currcurrency) {
		return em.merge(currcurrency);
	}
	
	public void popularityByKey(Object key) {
		CurrCurrency currcurrency = findById(key, false);
		
		if(currcurrency != null){
			if (SObject.class.isAssignableFrom(CurrCurrency.class)) {
				if (currcurrency.getPopularity() == null) {
					currcurrency.setPopularity(-1);
				}
				currcurrency.setPopularity(currcurrency.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCurrency.class)
							.setParameter("popularity", currcurrency.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(CurrCurrency item) {
		CurrCurrency currcurrency = null;
		if(item != null){
			currcurrency = findById(item.getId(), false);
		}
		
		if(currcurrency != null){
			if (SObject.class.isAssignableFrom(CurrCurrency.class)) {
				if (currcurrency.getPopularity() == null) {
					currcurrency.setPopularity(-1);
				}
				currcurrency.setPopularity(currcurrency.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCurrency.class)
							.setParameter("popularity", currcurrency.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, CurrCurrency.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<CurrCurrency> namedFilter(ScrollableSettings settings) {
		List<CurrCurrency> currcurrencys = new ArrayList<CurrCurrency>();
		
		try {
			currcurrencys = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), CurrCurrency.class), settings,
				CurrCurrency.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return currcurrencys;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrency> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<CurrCurrency>();
		}
	
		FindByExample findByExample = DaoUtil.search(new CurrCurrency(), settings.getFilter(), CurrCurrency.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, CurrCurrency.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(CurrCurrency.class)), CurrCurrency.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, CurrCurrency.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrency> findByExample(CurrCurrency example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				CurrCurrency.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, CurrCurrency.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CurrCurrency> findByExample2(CurrCurrency example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, CurrCurrency.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrency> findAll(ScrollableSettings settings) {
		List<CurrCurrency> currcurrencys = DaoUtil.sasQuery(selectClause, settings,
				CurrCurrency.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCurrency item : currcurrencys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCurrency item : currcurrencys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcurrencys;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrency> findAllScrollable(ScrollableSettings settings) {
		List<CurrCurrency> currcurrencys = DaoUtil
				.sasQuery(selectClause, settings, CurrCurrency.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCurrency item : currcurrencys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCurrency item : currcurrencys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcurrencys;
	}

	public CurrCurrency findById(Object key, Boolean initAll) {
		CurrCurrency item = em.find(CurrCurrency.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public CurrCurrency findById(ScrollableSettings settings) {
		CurrCurrency item = em.find(CurrCurrency.class, settings.getId());

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
			em.remove(em.getReference(CurrCurrency.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
