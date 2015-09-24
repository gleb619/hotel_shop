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
import org.test.shop.model.domain.entity.view.TmContactEasyView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmContactEasyViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmc0 FROM TmContactEasyView tmc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmc0";
	private String className = "TmContactEasyView";
	private String tableName = "tm_contact_easy_view";

	public TmContactEasyView create(TmContactEasyView tmcontacteasyview) {
		em.persist(tmcontacteasyview);
		return tmcontacteasyview;
	}

	public TmContactEasyView update(TmContactEasyView tmcontacteasyview) {
		return em.merge(tmcontacteasyview);
	}
	
	public void popularityByKey(Object key) {
		TmContactEasyView tmcontacteasyview = findById(key, false);
		
		if(tmcontacteasyview != null){
			if (SObject.class.isAssignableFrom(TmContactEasyView.class)) {
				if (tmcontacteasyview.getPopularity() == null) {
					tmcontacteasyview.setPopularity(-1);
				}
				tmcontacteasyview.setPopularity(tmcontacteasyview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactEasyView.class)
							.setParameter("popularity", tmcontacteasyview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmContactEasyView item) {
		TmContactEasyView tmcontacteasyview = null;
		if(item != null){
			tmcontacteasyview = findById(item.getId(), false);
		}
		
		if(tmcontacteasyview != null){
			if (SObject.class.isAssignableFrom(TmContactEasyView.class)) {
				if (tmcontacteasyview.getPopularity() == null) {
					tmcontacteasyview.setPopularity(-1);
				}
				tmcontacteasyview.setPopularity(tmcontacteasyview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactEasyView.class)
							.setParameter("popularity", tmcontacteasyview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmContactEasyView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmContactEasyView> namedFilter(ScrollableSettings settings) {
		List<TmContactEasyView> tmcontacteasyviews = new ArrayList<TmContactEasyView>();
		
		try {
			tmcontacteasyviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmContactEasyView.class), settings,
				TmContactEasyView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmcontacteasyviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasyView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmContactEasyView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmContactEasyView(), settings.getFilter(), TmContactEasyView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmContactEasyView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmContactEasyView.class)), TmContactEasyView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmContactEasyView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasyView> findByExample(TmContactEasyView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmContactEasyView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmContactEasyView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmContactEasyView> findByExample2(TmContactEasyView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmContactEasyView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasyView> findAll(ScrollableSettings settings) {
		List<TmContactEasyView> tmcontacteasyviews = DaoUtil.sasQuery(selectClause, settings,
				TmContactEasyView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactEasyView item : tmcontacteasyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactEasyView item : tmcontacteasyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacteasyviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactEasyView> findAllScrollable(ScrollableSettings settings) {
		List<TmContactEasyView> tmcontacteasyviews = DaoUtil
				.sasQuery(selectClause, settings, TmContactEasyView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactEasyView item : tmcontacteasyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactEasyView item : tmcontacteasyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacteasyviews;
	}

	public TmContactEasyView findById(Object key, Boolean initAll) {
		TmContactEasyView item = em.find(TmContactEasyView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmContactEasyView findById(ScrollableSettings settings) {
		TmContactEasyView item = em.find(TmContactEasyView.class, settings.getId());

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
			em.remove(em.getReference(TmContactEasyView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
