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
import org.test.shop.model.domain.entity.view.ServHotelView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServHotelViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServHotelView ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServHotelView";
	private String tableName = "serv_hotel_view";

	public ServHotelView create(ServHotelView servhotelview) {
		em.persist(servhotelview);
		return servhotelview;
	}

	public ServHotelView update(ServHotelView servhotelview) {
		return em.merge(servhotelview);
	}
	
	public void popularityByKey(Object key) {
		ServHotelView servhotelview = findById(key, false);
		
		if(servhotelview != null){
			if (SObject.class.isAssignableFrom(ServHotelView.class)) {
				if (servhotelview.getPopularity() == null) {
					servhotelview.setPopularity(-1);
				}
				servhotelview.setPopularity(servhotelview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotelView.class)
							.setParameter("popularity", servhotelview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServHotelView item) {
		ServHotelView servhotelview = null;
		if(item != null){
			servhotelview = findById(item.getId(), false);
		}
		
		if(servhotelview != null){
			if (SObject.class.isAssignableFrom(ServHotelView.class)) {
				if (servhotelview.getPopularity() == null) {
					servhotelview.setPopularity(-1);
				}
				servhotelview.setPopularity(servhotelview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotelView.class)
							.setParameter("popularity", servhotelview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServHotelView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServHotelView> namedFilter(ScrollableSettings settings) {
		List<ServHotelView> servhotelviews = new ArrayList<ServHotelView>();
		
		try {
			servhotelviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServHotelView.class), settings,
				ServHotelView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servhotelviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServHotelView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServHotelView(), settings.getFilter(), ServHotelView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServHotelView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServHotelView.class)), ServHotelView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServHotelView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelView> findByExample(ServHotelView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServHotelView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServHotelView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServHotelView> findByExample2(ServHotelView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServHotelView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelView> findAll(ScrollableSettings settings) {
		List<ServHotelView> servhotelviews = DaoUtil.sasQuery(selectClause, settings,
				ServHotelView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotelView item : servhotelviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotelView item : servhotelviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotelviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotelView> findAllScrollable(ScrollableSettings settings) {
		List<ServHotelView> servhotelviews = DaoUtil
				.sasQuery(selectClause, settings, ServHotelView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotelView item : servhotelviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotelView item : servhotelviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotelviews;
	}

	public ServHotelView findById(Object key, Boolean initAll) {
		ServHotelView item = em.find(ServHotelView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServHotelView findById(ScrollableSettings settings) {
		ServHotelView item = em.find(ServHotelView.class, settings.getId());

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
			em.remove(em.getReference(ServHotelView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
