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
import org.test.shop.model.domain.entity.ServTransferRoute;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServTransferRouteDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServTransferRoute ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServTransferRoute";
	private String tableName = "serv_transfer_route";

	public ServTransferRoute create(ServTransferRoute servtransferroute) {
		em.persist(servtransferroute);
		return servtransferroute;
	}

	public ServTransferRoute update(ServTransferRoute servtransferroute) {
		return em.merge(servtransferroute);
	}
	
	public void popularityByKey(Object key) {
		ServTransferRoute servtransferroute = findById(key, false);
		
		if(servtransferroute != null){
			if (SObject.class.isAssignableFrom(ServTransferRoute.class)) {
				if (servtransferroute.getPopularity() == null) {
					servtransferroute.setPopularity(-1);
				}
				servtransferroute.setPopularity(servtransferroute.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoute.class)
							.setParameter("popularity", servtransferroute.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServTransferRoute item) {
		ServTransferRoute servtransferroute = null;
		if(item != null){
			servtransferroute = findById(item.getId(), false);
		}
		
		if(servtransferroute != null){
			if (SObject.class.isAssignableFrom(ServTransferRoute.class)) {
				if (servtransferroute.getPopularity() == null) {
					servtransferroute.setPopularity(-1);
				}
				servtransferroute.setPopularity(servtransferroute.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoute.class)
							.setParameter("popularity", servtransferroute.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServTransferRoute.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServTransferRoute> namedFilter(ScrollableSettings settings) {
		List<ServTransferRoute> servtransferroutes = new ArrayList<ServTransferRoute>();
		
		try {
			servtransferroutes = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServTransferRoute.class), settings,
				ServTransferRoute.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servtransferroutes;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoute> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServTransferRoute>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServTransferRoute(), settings.getFilter(), ServTransferRoute.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServTransferRoute.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServTransferRoute.class)), ServTransferRoute.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServTransferRoute.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoute> findByExample(ServTransferRoute example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServTransferRoute.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServTransferRoute.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServTransferRoute> findByExample2(ServTransferRoute example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServTransferRoute.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoute> findAll(ScrollableSettings settings) {
		List<ServTransferRoute> servtransferroutes = DaoUtil.sasQuery(selectClause, settings,
				ServTransferRoute.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoute item : servtransferroutes) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoute item : servtransferroutes) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutes;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoute> findAllScrollable(ScrollableSettings settings) {
		List<ServTransferRoute> servtransferroutes = DaoUtil
				.sasQuery(selectClause, settings, ServTransferRoute.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoute item : servtransferroutes) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoute item : servtransferroutes) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutes;
	}

	public ServTransferRoute findById(Object key, Boolean initAll) {
		ServTransferRoute item = em.find(ServTransferRoute.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServTransferRoute findById(ScrollableSettings settings) {
		ServTransferRoute item = em.find(ServTransferRoute.class, settings.getId());

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
			em.remove(em.getReference(ServTransferRoute.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
