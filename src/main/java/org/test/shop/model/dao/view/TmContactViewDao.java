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
import org.test.shop.model.domain.entity.view.TmContactView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmContactViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmc0 FROM TmContactView tmc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmc0";
	private String className = "TmContactView";
	private String tableName = "tm_contact_view";

	public TmContactView create(TmContactView tmcontactview) {
		em.persist(tmcontactview);
		return tmcontactview;
	}

	public TmContactView update(TmContactView tmcontactview) {
		return em.merge(tmcontactview);
	}
	
	public void popularityByKey(Object key) {
		TmContactView tmcontactview = findById(key, false);
		
		if(tmcontactview != null){
			if (SObject.class.isAssignableFrom(TmContactView.class)) {
				if (tmcontactview.getPopularity() == null) {
					tmcontactview.setPopularity(-1);
				}
				tmcontactview.setPopularity(tmcontactview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactView.class)
							.setParameter("popularity", tmcontactview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmContactView item) {
		TmContactView tmcontactview = null;
		if(item != null){
			tmcontactview = findById(item.getId(), false);
		}
		
		if(tmcontactview != null){
			if (SObject.class.isAssignableFrom(TmContactView.class)) {
				if (tmcontactview.getPopularity() == null) {
					tmcontactview.setPopularity(-1);
				}
				tmcontactview.setPopularity(tmcontactview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContactView.class)
							.setParameter("popularity", tmcontactview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmContactView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmContactView> namedFilter(ScrollableSettings settings) {
		List<TmContactView> tmcontactviews = new ArrayList<TmContactView>();
		
		try {
			tmcontactviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmContactView.class), settings,
				TmContactView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmcontactviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmContactView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmContactView(), settings.getFilter(), TmContactView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmContactView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmContactView.class)), TmContactView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmContactView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactView> findByExample(TmContactView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmContactView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmContactView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmContactView> findByExample2(TmContactView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmContactView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContactView> findAll(ScrollableSettings settings) {
		List<TmContactView> tmcontactviews = DaoUtil.sasQuery(selectClause, settings,
				TmContactView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactView item : tmcontactviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactView item : tmcontactviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontactviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmContactView> findAllScrollable(ScrollableSettings settings) {
		List<TmContactView> tmcontactviews = DaoUtil
				.sasQuery(selectClause, settings, TmContactView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContactView item : tmcontactviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContactView item : tmcontactviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontactviews;
	}

	public TmContactView findById(Object key, Boolean initAll) {
		TmContactView item = em.find(TmContactView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmContactView findById(ScrollableSettings settings) {
		TmContactView item = em.find(TmContactView.class, settings.getId());

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
			em.remove(em.getReference(TmContactView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
