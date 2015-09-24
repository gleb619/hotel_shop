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
import org.test.shop.model.domain.entity.ServTransferRoutePoint;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServTransferRoutePointDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServTransferRoutePoint ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServTransferRoutePoint";
	private String tableName = "serv_transfer_route_point";

	public ServTransferRoutePoint create(ServTransferRoutePoint servtransferroutepoint) {
		em.persist(servtransferroutepoint);
		return servtransferroutepoint;
	}

	public ServTransferRoutePoint update(ServTransferRoutePoint servtransferroutepoint) {
		return em.merge(servtransferroutepoint);
	}
	
	public void popularityByKey(Object key) {
		ServTransferRoutePoint servtransferroutepoint = findById(key, false);
		
		if(servtransferroutepoint != null){
			if (SObject.class.isAssignableFrom(ServTransferRoutePoint.class)) {
				if (servtransferroutepoint.getPopularity() == null) {
					servtransferroutepoint.setPopularity(-1);
				}
				servtransferroutepoint.setPopularity(servtransferroutepoint.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoutePoint.class)
							.setParameter("popularity", servtransferroutepoint.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServTransferRoutePoint item) {
		ServTransferRoutePoint servtransferroutepoint = null;
		if(item != null){
			servtransferroutepoint = findById(item.getId(), false);
		}
		
		if(servtransferroutepoint != null){
			if (SObject.class.isAssignableFrom(ServTransferRoutePoint.class)) {
				if (servtransferroutepoint.getPopularity() == null) {
					servtransferroutepoint.setPopularity(-1);
				}
				servtransferroutepoint.setPopularity(servtransferroutepoint.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoutePoint.class)
							.setParameter("popularity", servtransferroutepoint.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServTransferRoutePoint.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServTransferRoutePoint> namedFilter(ScrollableSettings settings) {
		List<ServTransferRoutePoint> servtransferroutepoints = new ArrayList<ServTransferRoutePoint>();
		
		try {
			servtransferroutepoints = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServTransferRoutePoint.class), settings,
				ServTransferRoutePoint.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servtransferroutepoints;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePoint> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServTransferRoutePoint>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServTransferRoutePoint(), settings.getFilter(), ServTransferRoutePoint.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServTransferRoutePoint.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServTransferRoutePoint.class)), ServTransferRoutePoint.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServTransferRoutePoint.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePoint> findByExample(ServTransferRoutePoint example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServTransferRoutePoint.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServTransferRoutePoint.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePoint> findByExample2(ServTransferRoutePoint example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServTransferRoutePoint.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePoint> findAll(ScrollableSettings settings) {
		List<ServTransferRoutePoint> servtransferroutepoints = DaoUtil.sasQuery(selectClause, settings,
				ServTransferRoutePoint.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoutePoint item : servtransferroutepoints) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoutePoint item : servtransferroutepoints) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutepoints;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePoint> findAllScrollable(ScrollableSettings settings) {
		List<ServTransferRoutePoint> servtransferroutepoints = DaoUtil
				.sasQuery(selectClause, settings, ServTransferRoutePoint.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoutePoint item : servtransferroutepoints) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoutePoint item : servtransferroutepoints) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutepoints;
	}

	public ServTransferRoutePoint findById(Object key, Boolean initAll) {
		ServTransferRoutePoint item = em.find(ServTransferRoutePoint.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServTransferRoutePoint findById(ScrollableSettings settings) {
		ServTransferRoutePoint item = em.find(ServTransferRoutePoint.class, settings.getId());

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
			em.remove(em.getReference(ServTransferRoutePoint.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
