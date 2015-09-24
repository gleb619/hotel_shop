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
import org.test.shop.model.domain.entity.view.ShopRoomTarriffGeneralRateView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopRoomTarriffGeneralRateViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopRoomTarriffGeneralRateView sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopRoomTarriffGeneralRateView";
	private String tableName = "shop_room_tarriff_general_rate_view";

	public ShopRoomTarriffGeneralRateView create(ShopRoomTarriffGeneralRateView shoproomtarriffgeneralrateview) {
		em.persist(shoproomtarriffgeneralrateview);
		return shoproomtarriffgeneralrateview;
	}

	public ShopRoomTarriffGeneralRateView update(ShopRoomTarriffGeneralRateView shoproomtarriffgeneralrateview) {
		return em.merge(shoproomtarriffgeneralrateview);
	}
	
	public void popularityByKey(Object key) {
		ShopRoomTarriffGeneralRateView shoproomtarriffgeneralrateview = findById(key, false);
		
		if(shoproomtarriffgeneralrateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffGeneralRateView.class)) {
				if (shoproomtarriffgeneralrateview.getPopularity() == null) {
					shoproomtarriffgeneralrateview.setPopularity(-1);
				}
				shoproomtarriffgeneralrateview.setPopularity(shoproomtarriffgeneralrateview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffGeneralRateView.class)
							.setParameter("popularity", shoproomtarriffgeneralrateview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopRoomTarriffGeneralRateView item) {
		ShopRoomTarriffGeneralRateView shoproomtarriffgeneralrateview = null;
		if(item != null){
			shoproomtarriffgeneralrateview = findById(item.getId(), false);
		}
		
		if(shoproomtarriffgeneralrateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffGeneralRateView.class)) {
				if (shoproomtarriffgeneralrateview.getPopularity() == null) {
					shoproomtarriffgeneralrateview.setPopularity(-1);
				}
				shoproomtarriffgeneralrateview.setPopularity(shoproomtarriffgeneralrateview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffGeneralRateView.class)
							.setParameter("popularity", shoproomtarriffgeneralrateview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopRoomTarriffGeneralRateView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopRoomTarriffGeneralRateView> namedFilter(ScrollableSettings settings) {
		List<ShopRoomTarriffGeneralRateView> shoproomtarriffgeneralrateviews = new ArrayList<ShopRoomTarriffGeneralRateView>();
		
		try {
			shoproomtarriffgeneralrateviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopRoomTarriffGeneralRateView.class), settings,
				ShopRoomTarriffGeneralRateView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shoproomtarriffgeneralrateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffGeneralRateView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopRoomTarriffGeneralRateView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopRoomTarriffGeneralRateView(), settings.getFilter(), ShopRoomTarriffGeneralRateView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopRoomTarriffGeneralRateView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopRoomTarriffGeneralRateView.class)), ShopRoomTarriffGeneralRateView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopRoomTarriffGeneralRateView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffGeneralRateView> findByExample(ShopRoomTarriffGeneralRateView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopRoomTarriffGeneralRateView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopRoomTarriffGeneralRateView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffGeneralRateView> findByExample2(ShopRoomTarriffGeneralRateView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopRoomTarriffGeneralRateView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffGeneralRateView> findAll(ScrollableSettings settings) {
		List<ShopRoomTarriffGeneralRateView> shoproomtarriffgeneralrateviews = DaoUtil.sasQuery(selectClause, settings,
				ShopRoomTarriffGeneralRateView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffGeneralRateView item : shoproomtarriffgeneralrateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffGeneralRateView item : shoproomtarriffgeneralrateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarriffgeneralrateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffGeneralRateView> findAllScrollable(ScrollableSettings settings) {
		List<ShopRoomTarriffGeneralRateView> shoproomtarriffgeneralrateviews = DaoUtil
				.sasQuery(selectClause, settings, ShopRoomTarriffGeneralRateView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffGeneralRateView item : shoproomtarriffgeneralrateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffGeneralRateView item : shoproomtarriffgeneralrateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarriffgeneralrateviews;
	}

	public ShopRoomTarriffGeneralRateView findById(Object key, Boolean initAll) {
		ShopRoomTarriffGeneralRateView item = em.find(ShopRoomTarriffGeneralRateView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopRoomTarriffGeneralRateView findById(ScrollableSettings settings) {
		ShopRoomTarriffGeneralRateView item = em.find(ShopRoomTarriffGeneralRateView.class, settings.getId());

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
			em.remove(em.getReference(ShopRoomTarriffGeneralRateView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
