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
import org.test.shop.model.domain.entity.view.TmUserInfoView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmUserInfoViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmu0 FROM TmUserInfoView tmu0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmu0";
	private String className = "TmUserInfoView";
	private String tableName = "tm_user_info_view";

	public TmUserInfoView create(TmUserInfoView tmuserinfoview) {
		em.persist(tmuserinfoview);
		return tmuserinfoview;
	}

	public TmUserInfoView update(TmUserInfoView tmuserinfoview) {
		return em.merge(tmuserinfoview);
	}
	
	public void popularityByKey(Object key) {
		TmUserInfoView tmuserinfoview = findById(key, false);
		
		if(tmuserinfoview != null){
			if (SObject.class.isAssignableFrom(TmUserInfoView.class)) {
				if (tmuserinfoview.getPopularity() == null) {
					tmuserinfoview.setPopularity(-1);
				}
				tmuserinfoview.setPopularity(tmuserinfoview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmUserInfoView.class)
							.setParameter("popularity", tmuserinfoview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmUserInfoView item) {
		TmUserInfoView tmuserinfoview = null;
		if(item != null){
			tmuserinfoview = findById(item.getId(), false);
		}
		
		if(tmuserinfoview != null){
			if (SObject.class.isAssignableFrom(TmUserInfoView.class)) {
				if (tmuserinfoview.getPopularity() == null) {
					tmuserinfoview.setPopularity(-1);
				}
				tmuserinfoview.setPopularity(tmuserinfoview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmUserInfoView.class)
							.setParameter("popularity", tmuserinfoview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmUserInfoView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmUserInfoView> namedFilter(ScrollableSettings settings) {
		List<TmUserInfoView> tmuserinfoviews = new ArrayList<TmUserInfoView>();
		
		try {
			tmuserinfoviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmUserInfoView.class), settings,
				TmUserInfoView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmuserinfoviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmUserInfoView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmUserInfoView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmUserInfoView(), settings.getFilter(), TmUserInfoView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmUserInfoView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmUserInfoView.class)), TmUserInfoView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmUserInfoView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmUserInfoView> findByExample(TmUserInfoView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmUserInfoView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmUserInfoView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmUserInfoView> findByExample2(TmUserInfoView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmUserInfoView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmUserInfoView> findAll(ScrollableSettings settings) {
		List<TmUserInfoView> tmuserinfoviews = DaoUtil.sasQuery(selectClause, settings,
				TmUserInfoView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmUserInfoView item : tmuserinfoviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmUserInfoView item : tmuserinfoviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmuserinfoviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmUserInfoView> findAllScrollable(ScrollableSettings settings) {
		List<TmUserInfoView> tmuserinfoviews = DaoUtil
				.sasQuery(selectClause, settings, TmUserInfoView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmUserInfoView item : tmuserinfoviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmUserInfoView item : tmuserinfoviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmuserinfoviews;
	}

	public TmUserInfoView findById(Object key, Boolean initAll) {
		TmUserInfoView item = em.find(TmUserInfoView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmUserInfoView findById(ScrollableSettings settings) {
		TmUserInfoView item = em.find(TmUserInfoView.class, settings.getId());

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
			em.remove(em.getReference(TmUserInfoView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
