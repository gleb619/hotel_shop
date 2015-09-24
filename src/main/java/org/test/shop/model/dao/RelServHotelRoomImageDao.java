package org.test.shop.model.dao;

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
import org.test.shop.model.domain.entity.RelServHotelRoomImage;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelRoomImageDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelRoomImage rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelRoomImage";
	private String tableName = "rel_serv_hotel_room_image";

	public RelServHotelRoomImage create(RelServHotelRoomImage relservhotelroomimage) {
		em.persist(relservhotelroomimage);
		return relservhotelroomimage;
	}

	public RelServHotelRoomImage update(RelServHotelRoomImage relservhotelroomimage) {
		return em.merge(relservhotelroomimage);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelRoomImage relservhotelroomimage = findById(key, false);
		
		if(relservhotelroomimage != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImage.class)) {
				if (relservhotelroomimage.getPopularity() == null) {
					relservhotelroomimage.setPopularity(-1);
				}
				relservhotelroomimage.setPopularity(relservhotelroomimage.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImage.class)
							.setParameter("popularity", relservhotelroomimage.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelRoomImage item) {
		RelServHotelRoomImage relservhotelroomimage = null;
		if(item != null){
			relservhotelroomimage = findById(item.getId(), false);
		}
		
		if(relservhotelroomimage != null){
			if (SObject.class.isAssignableFrom(RelServHotelRoomImage.class)) {
				if (relservhotelroomimage.getPopularity() == null) {
					relservhotelroomimage.setPopularity(-1);
				}
				relservhotelroomimage.setPopularity(relservhotelroomimage.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelRoomImage.class)
							.setParameter("popularity", relservhotelroomimage.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelRoomImage.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelRoomImage> namedFilter(ScrollableSettings settings) {
		List<RelServHotelRoomImage> relservhotelroomimages = new ArrayList<RelServHotelRoomImage>();
		
		try {
			relservhotelroomimages = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelRoomImage.class), settings,
				RelServHotelRoomImage.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhotelroomimages;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImage> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelRoomImage>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelRoomImage(), settings.getFilter(), RelServHotelRoomImage.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelRoomImage.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelRoomImage.class)), RelServHotelRoomImage.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelRoomImage.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImage> findByExample(RelServHotelRoomImage example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelRoomImage.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelRoomImage.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImage> findByExample2(RelServHotelRoomImage example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelRoomImage.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImage> findAll(ScrollableSettings settings) {
		List<RelServHotelRoomImage> relservhotelroomimages = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelRoomImage.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImage item : relservhotelroomimages) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImage item : relservhotelroomimages) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimages;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelRoomImage> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelRoomImage> relservhotelroomimages = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelRoomImage.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelRoomImage item : relservhotelroomimages) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelRoomImage item : relservhotelroomimages) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelroomimages;
	}

	public RelServHotelRoomImage findById(Object key, Boolean initAll) {
		RelServHotelRoomImage item = em.find(RelServHotelRoomImage.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelRoomImage findById(ScrollableSettings settings) {
		RelServHotelRoomImage item = em.find(RelServHotelRoomImage.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelRoomImage.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
