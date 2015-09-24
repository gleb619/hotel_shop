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
import org.test.shop.model.domain.entity.ServHotel;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServHotelDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServHotel ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServHotel";
	private String tableName = "serv_hotel";

	public ServHotel create(ServHotel servhotel) {
		em.persist(servhotel);
		return servhotel;
	}

	public ServHotel update(ServHotel servhotel) {
		return em.merge(servhotel);
	}
	
	public void popularityByKey(Object key) {
		ServHotel servhotel = findById(key, false);
		
		if(servhotel != null){
			if (SObject.class.isAssignableFrom(ServHotel.class)) {
				if (servhotel.getPopularity() == null) {
					servhotel.setPopularity(-1);
				}
				servhotel.setPopularity(servhotel.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotel.class)
							.setParameter("popularity", servhotel.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServHotel item) {
		ServHotel servhotel = null;
		if(item != null){
			servhotel = findById(item.getId(), false);
		}
		
		if(servhotel != null){
			if (SObject.class.isAssignableFrom(ServHotel.class)) {
				if (servhotel.getPopularity() == null) {
					servhotel.setPopularity(-1);
				}
				servhotel.setPopularity(servhotel.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServHotel.class)
							.setParameter("popularity", servhotel.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServHotel.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServHotel> namedFilter(ScrollableSettings settings) {
		List<ServHotel> servhotels = new ArrayList<ServHotel>();
		
		try {
			servhotels = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServHotel.class), settings,
				ServHotel.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servhotels;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotel> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServHotel>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServHotel(), settings.getFilter(), ServHotel.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServHotel.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServHotel.class)), ServHotel.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServHotel.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotel> findByExample(ServHotel example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServHotel.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServHotel.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServHotel> findByExample2(ServHotel example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServHotel.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServHotel> findAll(ScrollableSettings settings) {
		List<ServHotel> servhotels = DaoUtil.sasQuery(selectClause, settings,
				ServHotel.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotel item : servhotels) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotel item : servhotels) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotels;
	}

	@SuppressWarnings("unchecked")
	public List<ServHotel> findAllScrollable(ScrollableSettings settings) {
		List<ServHotel> servhotels = DaoUtil
				.sasQuery(selectClause, settings, ServHotel.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServHotel item : servhotels) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServHotel item : servhotels) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servhotels;
	}

	public ServHotel findById(Object key, Boolean initAll) {
		ServHotel item = em.find(ServHotel.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServHotel findById(ScrollableSettings settings) {
		ServHotel item = em.find(ServHotel.class, settings.getId());

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
			em.remove(em.getReference(ServHotel.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
