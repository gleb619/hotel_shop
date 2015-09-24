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
import org.test.shop.model.domain.entity.view.RelServHotelRoomImageView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelRoomImageViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelRoomImageView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelRoomImageView";
	private String tableName = "rel_serv_hotel_room_image_view";

	public RelServHotelRoomImageView create(RelServHotelRoomImageView relservhotelroomimageview) {
		em.persist(relservhotelroomimageview);
		return relservhotelroomimageview;
	}

	public RelServHotelRoomImageView update(RelServHotelRoomImageView relservhotelroomimageview) {
		return em.merge(relservhotelroomimageview);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelRoomImageView relservhotelroomimageview = findById(key, false);
		
		if(relservhotelroomimageview != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImageView.class)) {
				if (relservhotelroomimageview.getPopularity() == null) {
					relservhotelroomimageview.setPopularity(-1);
				}
				relservhotelroomimageview.setPopularity(relservhotelroomimageview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImageView.class)
							.setParameter("popularity", relservhotelroomimageview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelRoomImageView item) {
		RelServHotelRoomImageView relservhotelroomimageview = null;
		if(item != null){
			relservhotelroomimageview = findById(item.getId(), false);
		}
		
		if(relservhotelroomimageview != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImageView.class)) {
				if (relservhotelroomimageview.getPopularity() == null) {
					relservhotelroomimageview.setPopularity(-1);
				}
				relservhotelroomimageview.setPopularity(relservhotelroomimageview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImageView.class)
							.setParameter("popularity", relservhotelroomimageview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelRoomImageView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelRoomImageView> namedFilter(ScrollableSettings settings) {
		List<RelServHotelRoomImageView> relservhotelroomimageviews = new ArrayList<RelServHotelRoomImageView>();
		
		try {
			relservhotelroomimageviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelRoomImageView.class), settings,
				RelServHotelRoomImageView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhotelroomimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelRoomImageView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelRoomImageView(), settings.getFilter(), RelServHotelRoomImageView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelRoomImageView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelRoomImageView.class)), RelServHotelRoomImageView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelRoomImageView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageView> findByExample(RelServHotelRoomImageView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelRoomImageView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelRoomImageView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageView> findByExample2(RelServHotelRoomImageView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelRoomImageView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageView> findAll(ScrollableSettings settings) {
		List<RelServHotelRoomImageView> relservhotelroomimageviews = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelRoomImageView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImageView item : relservhotelroomimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImageView item : relservhotelroomimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImageView> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelRoomImageView> relservhotelroomimageviews = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelRoomImageView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImageView item : relservhotelroomimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImageView item : relservhotelroomimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimageviews;
	}

	public RelServHotelRoomImageView findById(Object key, Boolean initAll) {
		RelServHotelRoomImageView item = em.find(RelServHotelRoomImageView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelRoomImageView findById(ScrollableSettings settings) {
		RelServHotelRoomImageView item = em.find(RelServHotelRoomImageView.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelRoomImageView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
