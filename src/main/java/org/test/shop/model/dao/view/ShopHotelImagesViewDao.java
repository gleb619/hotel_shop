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
import org.test.shop.model.domain.entity.view.ShopHotelImagesView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ShopHotelImagesViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT sho0 FROM ShopHotelImagesView sho0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "sho0";
	private String className = "ShopHotelImagesView";
	private String tableName = "shop_hotel_images_view";

	public ShopHotelImagesView create(ShopHotelImagesView shophotelimagesview) {
		em.persist(shophotelimagesview);
		return shophotelimagesview;
	}

	public ShopHotelImagesView update(ShopHotelImagesView shophotelimagesview) {
		return em.merge(shophotelimagesview);
	}
	
	public void popularityByKey(Object key) {
		ShopHotelImagesView shophotelimagesview = findById(key, false);
		
		if(shophotelimagesview != null){
			if (SObject.class.isAssignableFrom(ShopHotelImagesView.class)) {
				if (shophotelimagesview.getPopularity() == null) {
					shophotelimagesview.setPopularity(-1);
				}
				shophotelimagesview.setPopularity(shophotelimagesview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopHotelImagesView.class)
							.setParameter("popularity", shophotelimagesview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ShopHotelImagesView item) {
		ShopHotelImagesView shophotelimagesview = null;
		if(item != null){
			shophotelimagesview = findById(item.getId(), false);
		}
		
		if(shophotelimagesview != null){
			if (SObject.class.isAssignableFrom(ShopHotelImagesView.class)) {
				if (shophotelimagesview.getPopularity() == null) {
					shophotelimagesview.setPopularity(-1);
				}
				shophotelimagesview.setPopularity(shophotelimagesview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ShopHotelImagesView.class)
							.setParameter("popularity", shophotelimagesview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ShopHotelImagesView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ShopHotelImagesView> namedFilter(ScrollableSettings settings) {
		List<ShopHotelImagesView> shophotelimagesviews = new ArrayList<ShopHotelImagesView>();
		
		try {
			shophotelimagesviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ShopHotelImagesView.class), settings,
				ShopHotelImagesView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return shophotelimagesviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopHotelImagesView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ShopHotelImagesView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ShopHotelImagesView(), settings.getFilter(), ShopHotelImagesView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ShopHotelImagesView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ShopHotelImagesView.class)), ShopHotelImagesView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ShopHotelImagesView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopHotelImagesView> findByExample(ShopHotelImagesView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ShopHotelImagesView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ShopHotelImagesView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ShopHotelImagesView> findByExample2(ShopHotelImagesView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ShopHotelImagesView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ShopHotelImagesView> findAll(ScrollableSettings settings) {
		List<ShopHotelImagesView> shophotelimagesviews = DaoUtil.sasQuery(selectClause, settings,
				ShopHotelImagesView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopHotelImagesView item : shophotelimagesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopHotelImagesView item : shophotelimagesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shophotelimagesviews;
	}

	@SuppressWarnings("unchecked")
	public List<ShopHotelImagesView> findAllScrollable(ScrollableSettings settings) {
		List<ShopHotelImagesView> shophotelimagesviews = DaoUtil
				.sasQuery(selectClause, settings, ShopHotelImagesView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ShopHotelImagesView item : shophotelimagesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ShopHotelImagesView item : shophotelimagesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return shophotelimagesviews;
	}

	public ShopHotelImagesView findById(Object key, Boolean initAll) {
		ShopHotelImagesView item = em.find(ShopHotelImagesView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ShopHotelImagesView findById(ScrollableSettings settings) {
		ShopHotelImagesView item = em.find(ShopHotelImagesView.class, settings.getId());

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
			em.remove(em.getReference(ShopHotelImagesView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
