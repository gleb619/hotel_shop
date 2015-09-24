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
import org.test.shop.model.domain.entity.view.ShopRoomView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopRoomViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopRoomView sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopRoomView";
	private String tableName = "shop_room_view";

	public ShopRoomView create(ShopRoomView shoproomview) {
		em.persist(shoproomview);
		return shoproomview;
	}

	public ShopRoomView update(ShopRoomView shoproomview) {
		return em.merge(shoproomview);
	}
	
	public void popularityByKey(Object key) {
		ShopRoomView shoproomview = findById(key, false);
		
		if(shoproomview != null){
			if (SObject.class.isAssignableFrom(ShopRoomView.class)) {
				if (shoproomview.getPopularity() == null) {
					shoproomview.setPopularity(-1);
				}
				shoproomview.setPopularity(shoproomview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomView.class)
							.setParameter("popularity", shoproomview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopRoomView item) {
		ShopRoomView shoproomview = null;
		if(item != null){
			shoproomview = findById(item.getId(), false);
		}
		
		if(shoproomview != null){
			if (SObject.class.isAssignableFrom(ShopRoomView.class)) {
				if (shoproomview.getPopularity() == null) {
					shoproomview.setPopularity(-1);
				}
				shoproomview.setPopularity(shoproomview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomView.class)
							.setParameter("popularity", shoproomview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopRoomView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopRoomView> namedFilter(ScrollableSettings settings) {
		List<ShopRoomView> shoproomviews = new ArrayList<ShopRoomView>();
		
		try {
			shoproomviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopRoomView.class), settings,
				ShopRoomView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shoproomviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopRoomView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopRoomView(), settings.getFilter(), ShopRoomView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopRoomView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopRoomView.class)), ShopRoomView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopRoomView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomView> findByExample(ShopRoomView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopRoomView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopRoomView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopRoomView> findByExample2(ShopRoomView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopRoomView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomView> findAll(ScrollableSettings settings) {
		List<ShopRoomView> shoproomviews = DaoUtil.sasQuery(selectClause, settings,
				ShopRoomView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomView item : shoproomviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomView item : shoproomviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomView> findAllScrollable(ScrollableSettings settings) {
		List<ShopRoomView> shoproomviews = DaoUtil
				.sasQuery(selectClause, settings, ShopRoomView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomView item : shoproomviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomView item : shoproomviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomviews;
	}

	public ShopRoomView findById(Object key, Boolean initAll) {
		ShopRoomView item = em.find(ShopRoomView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopRoomView findById(ScrollableSettings settings) {
		ShopRoomView item = em.find(ShopRoomView.class, settings.getId());

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
			em.remove(em.getReference(ShopRoomView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
