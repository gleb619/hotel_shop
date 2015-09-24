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
import org.test.shop.model.domain.entity.view.TmAccountView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmAccountViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tma0 FROM TmAccountView tma0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tma0";
	private String className = "TmAccountView";
	private String tableName = "tm_account_view";

	public TmAccountView create(TmAccountView tmaccountview) {
		em.persist(tmaccountview);
		return tmaccountview;
	}

	public TmAccountView update(TmAccountView tmaccountview) {
		return em.merge(tmaccountview);
	}
	
	public void popularityByKey(Object key) {
		TmAccountView tmaccountview = findById(key, false);
		
		if(tmaccountview != null){
			if (SObject.class.isAssignableFrom(TmAccountView.class)) {
				if (tmaccountview.getPopularity() == null) {
					tmaccountview.setPopularity(-1);
				}
				tmaccountview.setPopularity(tmaccountview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmAccountView.class)
							.setParameter("popularity", tmaccountview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmAccountView item) {
		TmAccountView tmaccountview = null;
		if(item != null){
			tmaccountview = findById(item.getId(), false);
		}
		
		if(tmaccountview != null){
			if (SObject.class.isAssignableFrom(TmAccountView.class)) {
				if (tmaccountview.getPopularity() == null) {
					tmaccountview.setPopularity(-1);
				}
				tmaccountview.setPopularity(tmaccountview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmAccountView.class)
							.setParameter("popularity", tmaccountview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmAccountView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmAccountView> namedFilter(ScrollableSettings settings) {
		List<TmAccountView> tmaccountviews = new ArrayList<TmAccountView>();
		
		try {
			tmaccountviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmAccountView.class), settings,
				TmAccountView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmaccountviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmAccountView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmAccountView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmAccountView(), settings.getFilter(), TmAccountView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmAccountView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmAccountView.class)), TmAccountView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmAccountView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmAccountView> findByExample(TmAccountView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmAccountView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmAccountView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmAccountView> findByExample2(TmAccountView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmAccountView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmAccountView> findAll(ScrollableSettings settings) {
		List<TmAccountView> tmaccountviews = DaoUtil.sasQuery(selectClause, settings,
				TmAccountView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmAccountView item : tmaccountviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmAccountView item : tmaccountviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmaccountviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmAccountView> findAllScrollable(ScrollableSettings settings) {
		List<TmAccountView> tmaccountviews = DaoUtil
				.sasQuery(selectClause, settings, TmAccountView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmAccountView item : tmaccountviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmAccountView item : tmaccountviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmaccountviews;
	}

	public TmAccountView findById(Object key, Boolean initAll) {
		TmAccountView item = em.find(TmAccountView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmAccountView findById(ScrollableSettings settings) {
		TmAccountView item = em.find(TmAccountView.class, settings.getId());

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
			em.remove(em.getReference(TmAccountView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
