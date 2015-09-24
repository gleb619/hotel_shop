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
import org.test.shop.model.domain.entity.view.ShopRoomTarriffCorporateRateView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopRoomTarriffCorporateRateViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopRoomTarriffCorporateRateView sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopRoomTarriffCorporateRateView";
	private String tableName = "shop_room_tarriff_corporate_rate_view";

	public ShopRoomTarriffCorporateRateView create(ShopRoomTarriffCorporateRateView shoproomtarriffcorporaterateview) {
		em.persist(shoproomtarriffcorporaterateview);
		return shoproomtarriffcorporaterateview;
	}

	public ShopRoomTarriffCorporateRateView update(ShopRoomTarriffCorporateRateView shoproomtarriffcorporaterateview) {
		return em.merge(shoproomtarriffcorporaterateview);
	}
	
	public void popularityByKey(Object key) {
		ShopRoomTarriffCorporateRateView shoproomtarriffcorporaterateview = findById(key, false);
		
		if(shoproomtarriffcorporaterateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffCorporateRateView.class)) {
				if (shoproomtarriffcorporaterateview.getPopularity() == null) {
					shoproomtarriffcorporaterateview.setPopularity(-1);
				}
				shoproomtarriffcorporaterateview.setPopularity(shoproomtarriffcorporaterateview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffCorporateRateView.class)
							.setParameter("popularity", shoproomtarriffcorporaterateview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopRoomTarriffCorporateRateView item) {
		ShopRoomTarriffCorporateRateView shoproomtarriffcorporaterateview = null;
		if(item != null){
			shoproomtarriffcorporaterateview = findById(item.getId(), false);
		}
		
		if(shoproomtarriffcorporaterateview != null){
			if (SObject.class.isAssignableFrom(ShopRoomTarriffCorporateRateView.class)) {
				if (shoproomtarriffcorporaterateview.getPopularity() == null) {
					shoproomtarriffcorporaterateview.setPopularity(-1);
				}
				shoproomtarriffcorporaterateview.setPopularity(shoproomtarriffcorporaterateview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopRoomTarriffCorporateRateView.class)
							.setParameter("popularity", shoproomtarriffcorporaterateview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopRoomTarriffCorporateRateView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopRoomTarriffCorporateRateView> namedFilter(ScrollableSettings settings) {
		List<ShopRoomTarriffCorporateRateView> shoproomtarriffcorporaterateviews = new ArrayList<ShopRoomTarriffCorporateRateView>();
		
		try {
			shoproomtarriffcorporaterateviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopRoomTarriffCorporateRateView.class), settings,
				ShopRoomTarriffCorporateRateView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shoproomtarriffcorporaterateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffCorporateRateView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopRoomTarriffCorporateRateView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopRoomTarriffCorporateRateView(), settings.getFilter(), ShopRoomTarriffCorporateRateView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopRoomTarriffCorporateRateView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopRoomTarriffCorporateRateView.class)), ShopRoomTarriffCorporateRateView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopRoomTarriffCorporateRateView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffCorporateRateView> findByExample(ShopRoomTarriffCorporateRateView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopRoomTarriffCorporateRateView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopRoomTarriffCorporateRateView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffCorporateRateView> findByExample2(ShopRoomTarriffCorporateRateView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopRoomTarriffCorporateRateView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffCorporateRateView> findAll(ScrollableSettings settings) {
		List<ShopRoomTarriffCorporateRateView> shoproomtarriffcorporaterateviews = DaoUtil.sasQuery(selectClause, settings,
				ShopRoomTarriffCorporateRateView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffCorporateRateView item : shoproomtarriffcorporaterateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffCorporateRateView item : shoproomtarriffcorporaterateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarriffcorporaterateviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopRoomTarriffCorporateRateView> findAllScrollable(ScrollableSettings settings) {
		List<ShopRoomTarriffCorporateRateView> shoproomtarriffcorporaterateviews = DaoUtil
				.sasQuery(selectClause, settings, ShopRoomTarriffCorporateRateView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopRoomTarriffCorporateRateView item : shoproomtarriffcorporaterateviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopRoomTarriffCorporateRateView item : shoproomtarriffcorporaterateviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shoproomtarriffcorporaterateviews;
	}

	public ShopRoomTarriffCorporateRateView findById(Object key, Boolean initAll) {
		ShopRoomTarriffCorporateRateView item = em.find(ShopRoomTarriffCorporateRateView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopRoomTarriffCorporateRateView findById(ScrollableSettings settings) {
		ShopRoomTarriffCorporateRateView item = em.find(ShopRoomTarriffCorporateRateView.class, settings.getId());

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
			em.remove(em.getReference(ShopRoomTarriffCorporateRateView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
