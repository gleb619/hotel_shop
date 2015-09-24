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
import org.test.shop.model.domain.entity.view.RelServHotelRoomImageSimpleView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelRoomImageSimpleViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelRoomImageSimpleView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelRoomImageSimpleView";
	private String tableName = "rel_serv_hotel_room_image_simple_view";

	public RelServHotelRoomImageSimpleView create(RelServHotelRoomImageSimpleView relservhotelroomimagesimpleview) {
		em.persist(relservhotelroomimagesimpleview);
		return relservhotelroomimagesimpleview;
	}

	public RelServHotelRoomImageSimpleView update(RelServHotelRoomImageSimpleView relservhotelroomimagesimpleview) {
		return em.merge(relservhotelroomimagesimpleview);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelRoomImageSimpleView relservhotelroomimagesimpleview = findById(key, false);
		
		if(relservhotelroomimagesimpleview != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImageSimpleView.class)) {
				if (relservhotelroomimagesimpleview.getPopularity() == null) {
					relservhotelroomimagesimpleview.setPopularity(-1);
				}
				relservhotelroomimagesimpleview.setPopularity(relservhotelroomimagesimpleview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImageSimpleView.class)
							.setParameter("popularity", relservhotelroomimagesimpleview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelRoomImageSimpleView item) {
		RelServHotelRoomImageSimpleView relservhotelroomimagesimpleview = null;
		if(item != null){
			relservhotelroomimagesimpleview = findById(item.getId(), false);
		}
		
		if(relservhotelroomimagesimpleview != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImageSimpleView.class)) {
				if (relservhotelroomimagesimpleview.getPopularity() == null) {
					relservhotelroomimagesimpleview.setPopularity(-1);
				}
				relservhotelroomimagesimpleview.setPopularity(relservhotelroomimagesimpleview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImageSimpleView.class)
							.setParameter("popularity", relservhotelroomimagesimpleview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelRoomImageSimpleView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelRoomImageSimpleView> namedFilter(ScrollableSettings settings) {
		List<RelServHotelRoomImageSimpleView> relservhotelroomimagesimpleviews = new ArrayList<RelServHotelRoomImageSimpleView>();
		
		try {
			relservhotelroomimagesimpleviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelRoomImageSimpleView.class), settings,
				RelServHotelRoomImageSimpleView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhotelroomimagesimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageSimpleView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelRoomImageSimpleView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelRoomImageSimpleView(), settings.getFilter(), RelServHotelRoomImageSimpleView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelRoomImageSimpleView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelRoomImageSimpleView.class)), RelServHotelRoomImageSimpleView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelRoomImageSimpleView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageSimpleView> findByExample(RelServHotelRoomImageSimpleView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelRoomImageSimpleView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelRoomImageSimpleView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageSimpleView> findByExample2(RelServHotelRoomImageSimpleView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelRoomImageSimpleView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageSimpleView> findAll(ScrollableSettings settings) {
		List<RelServHotelRoomImageSimpleView> relservhotelroomimagesimpleviews = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelRoomImageSimpleView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImageSimpleView item : relservhotelroomimagesimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImageSimpleView item : relservhotelroomimagesimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimagesimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageSimpleView> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelRoomImageSimpleView> relservhotelroomimagesimpleviews = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelRoomImageSimpleView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImageSimpleView item : relservhotelroomimagesimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImageSimpleView item : relservhotelroomimagesimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimagesimpleviews;
	}

	public RelServHotelRoomImageSimpleView findById(Object key, Boolean initAll) {
		RelServHotelRoomImageSimpleView item = em.find(RelServHotelRoomImageSimpleView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelRoomImageSimpleView findById(ScrollableSettings settings) {
		RelServHotelRoomImageSimpleView item = em.find(RelServHotelRoomImageSimpleView.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelRoomImageSimpleView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
