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
import org.test.shop.model.domain.entity.view.TmFirmsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmFirmsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmf0 FROM TmFirmsView tmf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmf0";
	private String className = "TmFirmsView";
	private String tableName = "tm_firms_view";

	public TmFirmsView create(TmFirmsView tmfirmsview) {
		em.persist(tmfirmsview);
		return tmfirmsview;
	}

	public TmFirmsView update(TmFirmsView tmfirmsview) {
		return em.merge(tmfirmsview);
	}
	
	public void popularityByKey(Object key) {
		TmFirmsView tmfirmsview = findById(key, false);
		
		if(tmfirmsview != null){
			if (SObject.class.isAssignableFrom(TmFirmsView.class)) {
				if (tmfirmsview.getPopularity() == null) {
					tmfirmsview.setPopularity(-1);
				}
				tmfirmsview.setPopularity(tmfirmsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmsView.class)
							.setParameter("popularity", tmfirmsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmFirmsView item) {
		TmFirmsView tmfirmsview = null;
		if(item != null){
			tmfirmsview = findById(item.getId(), false);
		}
		
		if(tmfirmsview != null){
			if (SObject.class.isAssignableFrom(TmFirmsView.class)) {
				if (tmfirmsview.getPopularity() == null) {
					tmfirmsview.setPopularity(-1);
				}
				tmfirmsview.setPopularity(tmfirmsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmsView.class)
							.setParameter("popularity", tmfirmsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmFirmsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmFirmsView> namedFilter(ScrollableSettings settings) {
		List<TmFirmsView> tmfirmsviews = new ArrayList<TmFirmsView>();
		
		try {
			tmfirmsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmFirmsView.class), settings,
				TmFirmsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmfirmsviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmFirmsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmFirmsView(), settings.getFilter(), TmFirmsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmFirmsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmFirmsView.class)), TmFirmsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmFirmsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmsView> findByExample(TmFirmsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmFirmsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmFirmsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmFirmsView> findByExample2(TmFirmsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmFirmsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmsView> findAll(ScrollableSettings settings) {
		List<TmFirmsView> tmfirmsviews = DaoUtil.sasQuery(selectClause, settings,
				TmFirmsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmsView item : tmfirmsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmsView item : tmfirmsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmsView> findAllScrollable(ScrollableSettings settings) {
		List<TmFirmsView> tmfirmsviews = DaoUtil
				.sasQuery(selectClause, settings, TmFirmsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmsView item : tmfirmsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmsView item : tmfirmsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsviews;
	}

	public TmFirmsView findById(Object key, Boolean initAll) {
		TmFirmsView item = em.find(TmFirmsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmFirmsView findById(ScrollableSettings settings) {
		TmFirmsView item = em.find(TmFirmsView.class, settings.getId());

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
			em.remove(em.getReference(TmFirmsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
