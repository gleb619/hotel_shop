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
import org.test.shop.model.domain.entity.view.CurrCurrencyView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class CurrCurrencyViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT cur0 FROM CurrCurrencyView cur0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "cur0";
	private String className = "CurrCurrencyView";
	private String tableName = "curr_currency_view";

	public CurrCurrencyView create(CurrCurrencyView currcurrencyview) {
		em.persist(currcurrencyview);
		return currcurrencyview;
	}

	public CurrCurrencyView update(CurrCurrencyView currcurrencyview) {
		return em.merge(currcurrencyview);
	}
	
	public void popularityByKey(Object key) {
		CurrCurrencyView currcurrencyview = findById(key, false);
		
		if(currcurrencyview != null){
			if (SObject.class.isAssignableFrom(CurrCurrencyView.class)) {
				if (currcurrencyview.getPopularity() == null) {
					currcurrencyview.setPopularity(-1);
				}
				currcurrencyview.setPopularity(currcurrencyview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCurrencyView.class)
							.setParameter("popularity", currcurrencyview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(CurrCurrencyView item) {
		CurrCurrencyView currcurrencyview = null;
		if(item != null){
			currcurrencyview = findById(item.getId(), false);
		}
		
		if(currcurrencyview != null){
			if (SObject.class.isAssignableFrom(CurrCurrencyView.class)) {
				if (currcurrencyview.getPopularity() == null) {
					currcurrencyview.setPopularity(-1);
				}
				currcurrencyview.setPopularity(currcurrencyview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), CurrCurrencyView.class)
							.setParameter("popularity", currcurrencyview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, CurrCurrencyView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<CurrCurrencyView> namedFilter(ScrollableSettings settings) {
		List<CurrCurrencyView> currcurrencyviews = new ArrayList<CurrCurrencyView>();
		
		try {
			currcurrencyviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), CurrCurrencyView.class), settings,
				CurrCurrencyView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return currcurrencyviews;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrencyView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<CurrCurrencyView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new CurrCurrencyView(), settings.getFilter(), CurrCurrencyView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, CurrCurrencyView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(CurrCurrencyView.class)), CurrCurrencyView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, CurrCurrencyView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrencyView> findByExample(CurrCurrencyView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				CurrCurrencyView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, CurrCurrencyView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CurrCurrencyView> findByExample2(CurrCurrencyView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, CurrCurrencyView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrencyView> findAll(ScrollableSettings settings) {
		List<CurrCurrencyView> currcurrencyviews = DaoUtil.sasQuery(selectClause, settings,
				CurrCurrencyView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCurrencyView item : currcurrencyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCurrencyView item : currcurrencyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcurrencyviews;
	}

	@SuppressWarnings("unchecked")
	public List<CurrCurrencyView> findAllScrollable(ScrollableSettings settings) {
		List<CurrCurrencyView> currcurrencyviews = DaoUtil
				.sasQuery(selectClause, settings, CurrCurrencyView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (CurrCurrencyView item : currcurrencyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (CurrCurrencyView item : currcurrencyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return currcurrencyviews;
	}

	public CurrCurrencyView findById(Object key, Boolean initAll) {
		CurrCurrencyView item = em.find(CurrCurrencyView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public CurrCurrencyView findById(ScrollableSettings settings) {
		CurrCurrencyView item = em.find(CurrCurrencyView.class, settings.getId());

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
			em.remove(em.getReference(CurrCurrencyView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
