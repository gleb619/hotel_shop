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
import org.test.shop.model.domain.entity.view.RelServHotelImageSimpleView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelImageSimpleViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelImageSimpleView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelImageSimpleView";
	private String tableName = "rel_serv_hotel_image_simple_view";

	public RelServHotelImageSimpleView create(RelServHotelImageSimpleView relservhotelimagesimpleview) {
		em.persist(relservhotelimagesimpleview);
		return relservhotelimagesimpleview;
	}

	public RelServHotelImageSimpleView update(RelServHotelImageSimpleView relservhotelimagesimpleview) {
		return em.merge(relservhotelimagesimpleview);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelImageSimpleView relservhotelimagesimpleview = findById(key, false);
		
		if(relservhotelimagesimpleview != null){
			if (SObject.class.isAssignableFrom(RelServHotelImageSimpleView.class)) {
				if (relservhotelimagesimpleview.getPopularity() == null) {
					relservhotelimagesimpleview.setPopularity(-1);
				}
				relservhotelimagesimpleview.setPopularity(relservhotelimagesimpleview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelImageSimpleView.class)
							.setParameter("popularity", relservhotelimagesimpleview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelImageSimpleView item) {
		RelServHotelImageSimpleView relservhotelimagesimpleview = null;
		if(item != null){
			relservhotelimagesimpleview = findById(item.getId(), false);
		}
		
		if(relservhotelimagesimpleview != null){
			if (SObject.class.isAssignableFrom(RelServHotelImageSimpleView.class)) {
				if (relservhotelimagesimpleview.getPopularity() == null) {
					relservhotelimagesimpleview.setPopularity(-1);
				}
				relservhotelimagesimpleview.setPopularity(relservhotelimagesimpleview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelImageSimpleView.class)
							.setParameter("popularity", relservhotelimagesimpleview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelImageSimpleView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelImageSimpleView> namedFilter(ScrollableSettings settings) {
		List<RelServHotelImageSimpleView> relservhotelimagesimpleviews = new ArrayList<RelServHotelImageSimpleView>();
		
		try {
			relservhotelimagesimpleviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelImageSimpleView.class), settings,
				RelServHotelImageSimpleView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhotelimagesimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageSimpleView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelImageSimpleView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelImageSimpleView(), settings.getFilter(), RelServHotelImageSimpleView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelImageSimpleView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelImageSimpleView.class)), RelServHotelImageSimpleView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelImageSimpleView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageSimpleView> findByExample(RelServHotelImageSimpleView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelImageSimpleView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelImageSimpleView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelImageSimpleView> findByExample2(RelServHotelImageSimpleView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelImageSimpleView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageSimpleView> findAll(ScrollableSettings settings) {
		List<RelServHotelImageSimpleView> relservhotelimagesimpleviews = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelImageSimpleView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelImageSimpleView item : relservhotelimagesimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelImageSimpleView item : relservhotelimagesimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelimagesimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelImageSimpleView> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelImageSimpleView> relservhotelimagesimpleviews = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelImageSimpleView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelImageSimpleView item : relservhotelimagesimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelImageSimpleView item : relservhotelimagesimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhotelimagesimpleviews;
	}

	public RelServHotelImageSimpleView findById(Object key, Boolean initAll) {
		RelServHotelImageSimpleView item = em.find(RelServHotelImageSimpleView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelImageSimpleView findById(ScrollableSettings settings) {
		RelServHotelImageSimpleView item = em.find(RelServHotelImageSimpleView.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelImageSimpleView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
