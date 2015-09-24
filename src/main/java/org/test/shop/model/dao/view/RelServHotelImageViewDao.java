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
import org.test.shop.model.domain.entity.view.RelServHotelImageView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelImageViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelImageView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelImageView";
	private String tableName = "rel_serv_hotel_image_view";

	public RelServHotelImageView create(RelServHotelImageView relservhotelimageview) {
		em.persist(relservhotelimageview);
		return relservhotelimageview;
	}

	public RelServHotelImageView update(RelServHotelImageView relservhotelimageview) {
		return em.merge(relservhotelimageview);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelImageView relservhotelimageview = findById(key, false);
		
		if(relservhotelimageview != null){
			if (SObject.class.isAssignableFrom(RelServHotelImageView.class)) {
				if (relservhotelimageview.getPopularity() == null) {
					relservhotelimageview.setPopularity(-1);
				}
				relservhotelimageview.setPopularity(relservhotelimageview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelImageView.class)
							.setParameter("popularity", relservhotelimageview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelImageView item) {
		RelServHotelImageView relservhotelimageview = null;
		if(item != null){
			relservhotelimageview = findById(item.getId(), false);
		}
		
		if(relservhotelimageview != null){
			if (SObject.class.isAssignableFrom(RelServHotelImageView.class)) {
				if (relservhotelimageview.getPopularity() == null) {
					relservhotelimageview.setPopularity(-1);
				}
				relservhotelimageview.setPopularity(relservhotelimageview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelImageView.class)
							.setParameter("popularity", relservhotelimageview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelImageView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelImageView> namedFilter(ScrollableSettings settings) {
		List<RelServHotelImageView> relservhotelimageviews = new ArrayList<RelServHotelImageView>();
		
		try {
			relservhotelimageviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelImageView.class), settings,
				RelServHotelImageView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhotelimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelImageView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelImageView(), settings.getFilter(), RelServHotelImageView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelImageView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelImageView.class)), RelServHotelImageView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelImageView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageView> findByExample(RelServHotelImageView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelImageView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelImageView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelImageView> findByExample2(RelServHotelImageView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelImageView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageView> findAll(ScrollableSettings settings) {
		List<RelServHotelImageView> relservhotelimageviews = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelImageView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelImageView item : relservhotelimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelImageView item : relservhotelimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelimageviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageView> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelImageView> relservhotelimageviews = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelImageView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelImageView item : relservhotelimageviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelImageView item : relservhotelimageviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelimageviews;
	}

	public RelServHotelImageView findById(Object key, Boolean initAll) {
		RelServHotelImageView item = em.find(RelServHotelImageView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelImageView findById(ScrollableSettings settings) {
		RelServHotelImageView item = em.find(RelServHotelImageView.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelImageView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
