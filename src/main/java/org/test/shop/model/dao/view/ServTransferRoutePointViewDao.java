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
import org.test.shop.model.domain.entity.view.ServTransferRoutePointView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServTransferRoutePointViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServTransferRoutePointView ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServTransferRoutePointView";
	private String tableName = "serv_transfer_route_point_view";

	public ServTransferRoutePointView create(ServTransferRoutePointView servtransferroutepointview) {
		em.persist(servtransferroutepointview);
		return servtransferroutepointview;
	}

	public ServTransferRoutePointView update(ServTransferRoutePointView servtransferroutepointview) {
		return em.merge(servtransferroutepointview);
	}
	
	public void popularityByKey(Object key) {
		ServTransferRoutePointView servtransferroutepointview = findById(key, false);
		
		if(servtransferroutepointview != null){
			if (SObject.class.isAssignableFrom(ServTransferRoutePointView.class)) {
				if (servtransferroutepointview.getPopularity() == null) {
					servtransferroutepointview.setPopularity(-1);
				}
				servtransferroutepointview.setPopularity(servtransferroutepointview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoutePointView.class)
							.setParameter("popularity", servtransferroutepointview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServTransferRoutePointView item) {
		ServTransferRoutePointView servtransferroutepointview = null;
		if(item != null){
			servtransferroutepointview = findById(item.getId(), false);
		}
		
		if(servtransferroutepointview != null){
			if (SObject.class.isAssignableFrom(ServTransferRoutePointView.class)) {
				if (servtransferroutepointview.getPopularity() == null) {
					servtransferroutepointview.setPopularity(-1);
				}
				servtransferroutepointview.setPopularity(servtransferroutepointview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRoutePointView.class)
							.setParameter("popularity", servtransferroutepointview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServTransferRoutePointView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServTransferRoutePointView> namedFilter(ScrollableSettings settings) {
		List<ServTransferRoutePointView> servtransferroutepointviews = new ArrayList<ServTransferRoutePointView>();
		
		try {
			servtransferroutepointviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServTransferRoutePointView.class), settings,
				ServTransferRoutePointView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servtransferroutepointviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePointView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServTransferRoutePointView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServTransferRoutePointView(), settings.getFilter(), ServTransferRoutePointView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServTransferRoutePointView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServTransferRoutePointView.class)), ServTransferRoutePointView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServTransferRoutePointView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePointView> findByExample(ServTransferRoutePointView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServTransferRoutePointView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServTransferRoutePointView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePointView> findByExample2(ServTransferRoutePointView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServTransferRoutePointView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePointView> findAll(ScrollableSettings settings) {
		List<ServTransferRoutePointView> servtransferroutepointviews = DaoUtil.sasQuery(selectClause, settings,
				ServTransferRoutePointView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoutePointView item : servtransferroutepointviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoutePointView item : servtransferroutepointviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutepointviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRoutePointView> findAllScrollable(ScrollableSettings settings) {
		List<ServTransferRoutePointView> servtransferroutepointviews = DaoUtil
				.sasQuery(selectClause, settings, ServTransferRoutePointView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRoutePointView item : servtransferroutepointviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRoutePointView item : servtransferroutepointviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferroutepointviews;
	}

	public ServTransferRoutePointView findById(Object key, Boolean initAll) {
		ServTransferRoutePointView item = em.find(ServTransferRoutePointView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServTransferRoutePointView findById(ScrollableSettings settings) {
		ServTransferRoutePointView item = em.find(ServTransferRoutePointView.class, settings.getId());

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
			em.remove(em.getReference(ServTransferRoutePointView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
