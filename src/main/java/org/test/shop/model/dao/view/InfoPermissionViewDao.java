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
import org.test.shop.model.domain.entity.view.InfoPermissionView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class InfoPermissionViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT inf0 FROM InfoPermissionView inf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "inf0";
	private String className = "InfoPermissionView";
	private String tableName = "info_permission_view";

	public InfoPermissionView create(InfoPermissionView infopermissionview) {
		em.persist(infopermissionview);
		return infopermissionview;
	}

	public InfoPermissionView update(InfoPermissionView infopermissionview) {
		return em.merge(infopermissionview);
	}
	
	public void popularityByKey(Object key) {
		InfoPermissionView infopermissionview = findById(key, false);
		
		if(infopermissionview != null){
			if (SObject.class.isAssignableFrom(InfoPermissionView.class)) {
				if (infopermissionview.getPopularity() == null) {
					infopermissionview.setPopularity(-1);
				}
				infopermissionview.setPopularity(infopermissionview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), InfoPermissionView.class)
							.setParameter("popularity", infopermissionview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(InfoPermissionView item) {
		InfoPermissionView infopermissionview = null;
		if(item != null){
			infopermissionview = findById(item.getId(), false);
		}
		
		if(infopermissionview != null){
			if (SObject.class.isAssignableFrom(InfoPermissionView.class)) {
				if (infopermissionview.getPopularity() == null) {
					infopermissionview.setPopularity(-1);
				}
				infopermissionview.setPopularity(infopermissionview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), InfoPermissionView.class)
							.setParameter("popularity", infopermissionview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, InfoPermissionView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<InfoPermissionView> namedFilter(ScrollableSettings settings) {
		List<InfoPermissionView> infopermissionviews = new ArrayList<InfoPermissionView>();
		
		try {
			infopermissionviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), InfoPermissionView.class), settings,
				InfoPermissionView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return infopermissionviews;
	}

	@SuppressWarnings("unchecked")
	public List<InfoPermissionView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<InfoPermissionView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new InfoPermissionView(), settings.getFilter(), InfoPermissionView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, InfoPermissionView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(InfoPermissionView.class)), InfoPermissionView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, InfoPermissionView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<InfoPermissionView> findByExample(InfoPermissionView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				InfoPermissionView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, InfoPermissionView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<InfoPermissionView> findByExample2(InfoPermissionView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, InfoPermissionView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<InfoPermissionView> findAll(ScrollableSettings settings) {
		List<InfoPermissionView> infopermissionviews = DaoUtil.sasQuery(selectClause, settings,
				InfoPermissionView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (InfoPermissionView item : infopermissionviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (InfoPermissionView item : infopermissionviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return infopermissionviews;
	}

	@SuppressWarnings("unchecked")
	public List<InfoPermissionView> findAllScrollable(ScrollableSettings settings) {
		List<InfoPermissionView> infopermissionviews = DaoUtil
				.sasQuery(selectClause, settings, InfoPermissionView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (InfoPermissionView item : infopermissionviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (InfoPermissionView item : infopermissionviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return infopermissionviews;
	}

	public InfoPermissionView findById(Object key, Boolean initAll) {
		InfoPermissionView item = em.find(InfoPermissionView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public InfoPermissionView findById(ScrollableSettings settings) {
		InfoPermissionView item = em.find(InfoPermissionView.class, settings.getId());

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
			em.remove(em.getReference(InfoPermissionView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
