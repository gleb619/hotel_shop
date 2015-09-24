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
import org.test.shop.model.domain.entity.view.RelShopPermissionView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelShopPermissionViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelShopPermissionView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelShopPermissionView";
	private String tableName = "rel_shop_permission_view";

	public RelShopPermissionView create(RelShopPermissionView relshoppermissionview) {
		em.persist(relshoppermissionview);
		return relshoppermissionview;
	}

	public RelShopPermissionView update(RelShopPermissionView relshoppermissionview) {
		return em.merge(relshoppermissionview);
	}
	
	public void popularityByKey(Object key) {
		RelShopPermissionView relshoppermissionview = findById(key, false);
		
		if(relshoppermissionview != null){
			if (SObject.class.isAssignableFrom(RelShopPermissionView.class)) {
				if (relshoppermissionview.getPopularity() == null) {
					relshoppermissionview.setPopularity(-1);
				}
				relshoppermissionview.setPopularity(relshoppermissionview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelShopPermissionView.class)
							.setParameter("popularity", relshoppermissionview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelShopPermissionView item) {
		RelShopPermissionView relshoppermissionview = null;
		if(item != null){
			relshoppermissionview = findById(item.getId(), false);
		}
		
		if(relshoppermissionview != null){
			if (SObject.class.isAssignableFrom(RelShopPermissionView.class)) {
				if (relshoppermissionview.getPopularity() == null) {
					relshoppermissionview.setPopularity(-1);
				}
				relshoppermissionview.setPopularity(relshoppermissionview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelShopPermissionView.class)
							.setParameter("popularity", relshoppermissionview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelShopPermissionView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelShopPermissionView> namedFilter(ScrollableSettings settings) {
		List<RelShopPermissionView> relshoppermissionviews = new ArrayList<RelShopPermissionView>();
		
		try {
			relshoppermissionviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelShopPermissionView.class), settings,
				RelShopPermissionView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relshoppermissionviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermissionView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelShopPermissionView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelShopPermissionView(), settings.getFilter(), RelShopPermissionView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelShopPermissionView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelShopPermissionView.class)), RelShopPermissionView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelShopPermissionView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermissionView> findByExample(RelShopPermissionView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelShopPermissionView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelShopPermissionView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelShopPermissionView> findByExample2(RelShopPermissionView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelShopPermissionView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermissionView> findAll(ScrollableSettings settings) {
		List<RelShopPermissionView> relshoppermissionviews = DaoUtil.sasQuery(selectClause, settings,
				RelShopPermissionView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelShopPermissionView item : relshoppermissionviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelShopPermissionView item : relshoppermissionviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relshoppermissionviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelShopPermissionView> findAllScrollable(ScrollableSettings settings) {
		List<RelShopPermissionView> relshoppermissionviews = DaoUtil
				.sasQuery(selectClause, settings, RelShopPermissionView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelShopPermissionView item : relshoppermissionviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelShopPermissionView item : relshoppermissionviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relshoppermissionviews;
	}

	public RelShopPermissionView findById(Object key, Boolean initAll) {
		RelShopPermissionView item = em.find(RelShopPermissionView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelShopPermissionView findById(ScrollableSettings settings) {
		RelShopPermissionView item = em.find(RelShopPermissionView.class, settings.getId());

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
			em.remove(em.getReference(RelShopPermissionView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
