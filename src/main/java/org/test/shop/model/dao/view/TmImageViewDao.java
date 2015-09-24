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
import org.test.shop.model.domain.entity.view.TmImageView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmImageViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmi0 FROM TmImageView tmi0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmi0";
	private String className = "TmImageView";
	private String tableName = "tm_image_view";

	public TmImageView create(TmImageView tmimageview) {
		em.persist(tmimageview);
		return tmimageview;
	}

	public TmImageView update(TmImageView tmimageview) {
		return em.merge(tmimageview);
	}
	
	public void popularityByKey(Object key) {
		TmImageView tmimageview = findById(key, false);
		
		if(tmimageview != null){
			if (SObject.class.isAssignableFrom(TmImageView.class)) {
				if (tmimageview.getPopularity() == null) {
					tmimageview.setPopularity(-1);
				}
				tmimageview.setPopularity(tmimageview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmImageView.class)
							.setParameter("popularity", tmimageview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmImageView item) {
		TmImageView tmimageview = null;
		if(item != null){
			tmimageview = findById(item.getId(), false);
		}
		
		if(tmimageview != null){
			if (SObject.class.isAssignableFrom(TmImageView.class)) {
				if (tmimageview.getPopularity() == null) {
					tmimageview.setPopularity(-1);
				}
				tmimageview.setPopularity(tmimageview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmImageView.class)
							.setParameter("popularity", tmimageview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmImageView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmImageView> namedFilter(ScrollableSettings settings) {
		List<TmImageView> tmimageviews = new ArrayList<TmImageView>();
		
		try {
			tmimageviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmImageView.class), settings,
				TmImageView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmImageView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmImageView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmImageView(), settings.getFilter(), TmImageView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmImageView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmImageView.class)), TmImageView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmImageView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmImageView> findByExample(TmImageView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmImageView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmImageView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmImageView> findByExample2(TmImageView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmImageView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmImageView> findAll(ScrollableSettings settings) {
		List<TmImageView> tmimageviews = DaoUtil.sasQuery(selectClause, settings,
				TmImageView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmImageView item : tmimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmImageView item : tmimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmImageView> findAllScrollable(ScrollableSettings settings) {
		List<TmImageView> tmimageviews = DaoUtil
				.sasQuery(selectClause, settings, TmImageView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmImageView item : tmimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmImageView item : tmimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmimageviews;
	}

	public TmImageView findById(Object key, Boolean initAll) {
		TmImageView item = em.find(TmImageView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmImageView findById(ScrollableSettings settings) {
		TmImageView item = em.find(TmImageView.class, settings.getId());

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
			em.remove(em.getReference(TmImageView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
