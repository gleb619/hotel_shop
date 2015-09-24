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
import org.test.shop.model.domain.entity.view.ShopRoomTarriffOriginalRateView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopRoomTarriffOriginalRateViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopRoomTarriffOriginalRateView sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopRoomTarriffOriginalRateView";
	private String tableName = "shop_room_tarriff_original_rate_view";

	public ShopRoomTarriffOriginalRateView create(ShopRoomTarriffOriginalRateView shoproomtarrifforiginalrateview) {
		em.persist(shoproomtarrifforiginalrateview);
		return shoproomtarrifforiginalrateview;
	}

	public ShopRoomTarriffOriginalRateView update(ShopRoomTarriffOriginalRateView shoproomtarrifforiginalrateview) {
		return em.merge(shoproomtarrifforiginalrateview);
	}
	
	public void popularityByKey(Object key) {
		ShopRoomTarriffOriginalRateView shoproomtarrifforiginalrateview = findById(key, false);
		
		if(shoproomtarrifforiginalrateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffOriginalRateView.class)) {
				if (shoproomtarrifforiginalrateview.getPopularity() == null) {
					shoproomtarrifforiginalrateview.setPopularity(-1);
				}
				shoproomtarrifforiginalrateview.setPopularity(shoproomtarrifforiginalrateview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffOriginalRateView.class)
							.setParameter("popularity", shoproomtarrifforiginalrateview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopRoomTarriffOriginalRateView item) {
		ShopRoomTarriffOriginalRateView shoproomtarrifforiginalrateview = null;
		if(item != null){
			shoproomtarrifforiginalrateview = findById(item.getId(), false);
		}
		
		if(shoproomtarrifforiginalrateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffOriginalRateView.class)) {
				if (shoproomtarrifforiginalrateview.getPopularity() == null) {
					shoproomtarrifforiginalrateview.setPopularity(-1);
				}
				shoproomtarrifforiginalrateview.setPopularity(shoproomtarrifforiginalrateview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffOriginalRateView.class)
							.setParameter("popularity", shoproomtarrifforiginalrateview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopRoomTarriffOriginalRateView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopRoomTarriffOriginalRateView> namedFilter(ScrollableSettings settings) {
		List<ShopRoomTarriffOriginalRateView> shoproomtarrifforiginalrateviews = new ArrayList<ShopRoomTarriffOriginalRateView>();
		
		try {
			shoproomtarrifforiginalrateviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopRoomTarriffOriginalRateView.class), settings,
				ShopRoomTarriffOriginalRateView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shoproomtarrifforiginalrateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffOriginalRateView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopRoomTarriffOriginalRateView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopRoomTarriffOriginalRateView(), settings.getFilter(), ShopRoomTarriffOriginalRateView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopRoomTarriffOriginalRateView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopRoomTarriffOriginalRateView.class)), ShopRoomTarriffOriginalRateView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopRoomTarriffOriginalRateView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffOriginalRateView> findByExample(ShopRoomTarriffOriginalRateView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopRoomTarriffOriginalRateView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopRoomTarriffOriginalRateView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffOriginalRateView> findByExample2(ShopRoomTarriffOriginalRateView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopRoomTarriffOriginalRateView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffOriginalRateView> findAll(ScrollableSettings settings) {
		List<ShopRoomTarriffOriginalRateView> shoproomtarrifforiginalrateviews = DaoUtil.sasQuery(selectClause, settings,
				ShopRoomTarriffOriginalRateView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffOriginalRateView item : shoproomtarrifforiginalrateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffOriginalRateView item : shoproomtarrifforiginalrateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarrifforiginalrateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffOriginalRateView> findAllScrollable(ScrollableSettings settings) {
		List<ShopRoomTarriffOriginalRateView> shoproomtarrifforiginalrateviews = DaoUtil
				.sasQuery(selectClause, settings, ShopRoomTarriffOriginalRateView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffOriginalRateView item : shoproomtarrifforiginalrateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffOriginalRateView item : shoproomtarrifforiginalrateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarrifforiginalrateviews;
	}

	public ShopRoomTarriffOriginalRateView findById(Object key, Boolean initAll) {
		ShopRoomTarriffOriginalRateView item = em.find(ShopRoomTarriffOriginalRateView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopRoomTarriffOriginalRateView findById(ScrollableSettings settings) {
		ShopRoomTarriffOriginalRateView item = em.find(ShopRoomTarriffOriginalRateView.class, settings.getId());

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
			em.remove(em.getReference(ShopRoomTarriffOriginalRateView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
