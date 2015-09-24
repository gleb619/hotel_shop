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
import org.test.shop.model.domain.entity.view.ServHotelRoomView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServHotelRoomViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServHotelRoomView ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServHotelRoomView";
	private String tableName = "serv_hotel_room_view";

	public ServHotelRoomView create(ServHotelRoomView servhotelroomview) {
		em.persist(servhotelroomview);
		return servhotelroomview;
	}

	public ServHotelRoomView update(ServHotelRoomView servhotelroomview) {
		return em.merge(servhotelroomview);
	}
	
	public void popularityByKey(Object key) {
		ServHotelRoomView servhotelroomview = findById(key, false);
		
		if(servhotelroomview != null){
			if (SObject.class.isAssignableFrom(ServHotelRoomView.class)) {
				if (servhotelroomview.getPopularity() == null) {
					servhotelroomview.setPopularity(-1);
				}
				servhotelroomview.setPopularity(servhotelroomview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotelRoomView.class)
							.setParameter("popularity", servhotelroomview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServHotelRoomView item) {
		ServHotelRoomView servhotelroomview = null;
		if(item != null){
			servhotelroomview = findById(item.getId(), false);
		}
		
		if(servhotelroomview != null){
			if (SObject.class.isAssignableFrom(ServHotelRoomView.class)) {
				if (servhotelroomview.getPopularity() == null) {
					servhotelroomview.setPopularity(-1);
				}
				servhotelroomview.setPopularity(servhotelroomview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotelRoomView.class)
							.setParameter("popularity", servhotelroomview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServHotelRoomView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServHotelRoomView> namedFilter(ScrollableSettings settings) {
		List<ServHotelRoomView> servhotelroomviews = new ArrayList<ServHotelRoomView>();
		
		try {
			servhotelroomviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServHotelRoomView.class), settings,
				ServHotelRoomView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servhotelroomviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelRoomView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServHotelRoomView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServHotelRoomView(), settings.getFilter(), ServHotelRoomView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServHotelRoomView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServHotelRoomView.class)), ServHotelRoomView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServHotelRoomView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelRoomView> findByExample(ServHotelRoomView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServHotelRoomView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServHotelRoomView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServHotelRoomView> findByExample2(ServHotelRoomView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServHotelRoomView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelRoomView> findAll(ScrollableSettings settings) {
		List<ServHotelRoomView> servhotelroomviews = DaoUtil.sasQuery(selectClause, settings,
				ServHotelRoomView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotelRoomView item : servhotelroomviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotelRoomView item : servhotelroomviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotelroomviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelRoomView> findAllScrollable(ScrollableSettings settings) {
		List<ServHotelRoomView> servhotelroomviews = DaoUtil
				.sasQuery(selectClause, settings, ServHotelRoomView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotelRoomView item : servhotelroomviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotelRoomView item : servhotelroomviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotelroomviews;
	}

	public ServHotelRoomView findById(Object key, Boolean initAll) {
		ServHotelRoomView item = em.find(ServHotelRoomView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServHotelRoomView findById(ScrollableSettings settings) {
		ServHotelRoomView item = em.find(ServHotelRoomView.class, settings.getId());

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
			em.remove(em.getReference(ServHotelRoomView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
