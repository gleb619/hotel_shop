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
import org.test.shop.model.domain.entity.view.ServTransferRouteView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServTransferRouteViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServTransferRouteView ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServTransferRouteView";
	private String tableName = "serv_transfer_route_view";

	public ServTransferRouteView create(ServTransferRouteView servtransferrouteview) {
		em.persist(servtransferrouteview);
		return servtransferrouteview;
	}

	public ServTransferRouteView update(ServTransferRouteView servtransferrouteview) {
		return em.merge(servtransferrouteview);
	}
	
	public void popularityByKey(Object key) {
		ServTransferRouteView servtransferrouteview = findById(key, false);
		
		if(servtransferrouteview != null){
			if (SObject.class.isAssignableFrom(ServTransferRouteView.class)) {
				if (servtransferrouteview.getPopularity() == null) {
					servtransferrouteview.setPopularity(-1);
				}
				servtransferrouteview.setPopularity(servtransferrouteview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRouteView.class)
							.setParameter("popularity", servtransferrouteview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServTransferRouteView item) {
		ServTransferRouteView servtransferrouteview = null;
		if(item != null){
			servtransferrouteview = findById(item.getId(), false);
		}
		
		if(servtransferrouteview != null){
			if (SObject.class.isAssignableFrom(ServTransferRouteView.class)) {
				if (servtransferrouteview.getPopularity() == null) {
					servtransferrouteview.setPopularity(-1);
				}
				servtransferrouteview.setPopularity(servtransferrouteview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransferRouteView.class)
							.setParameter("popularity", servtransferrouteview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServTransferRouteView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServTransferRouteView> namedFilter(ScrollableSettings settings) {
		List<ServTransferRouteView> servtransferrouteviews = new ArrayList<ServTransferRouteView>();
		
		try {
			servtransferrouteviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServTransferRouteView.class), settings,
				ServTransferRouteView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servtransferrouteviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRouteView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServTransferRouteView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServTransferRouteView(), settings.getFilter(), ServTransferRouteView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServTransferRouteView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServTransferRouteView.class)), ServTransferRouteView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServTransferRouteView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRouteView> findByExample(ServTransferRouteView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServTransferRouteView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServTransferRouteView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServTransferRouteView> findByExample2(ServTransferRouteView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServTransferRouteView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRouteView> findAll(ScrollableSettings settings) {
		List<ServTransferRouteView> servtransferrouteviews = DaoUtil.sasQuery(selectClause, settings,
				ServTransferRouteView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRouteView item : servtransferrouteviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRouteView item : servtransferrouteviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferrouteviews;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransferRouteView> findAllScrollable(ScrollableSettings settings) {
		List<ServTransferRouteView> servtransferrouteviews = DaoUtil
				.sasQuery(selectClause, settings, ServTransferRouteView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransferRouteView item : servtransferrouteviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransferRouteView item : servtransferrouteviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransferrouteviews;
	}

	public ServTransferRouteView findById(Object key, Boolean initAll) {
		ServTransferRouteView item = em.find(ServTransferRouteView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServTransferRouteView findById(ScrollableSettings settings) {
		ServTransferRouteView item = em.find(ServTransferRouteView.class, settings.getId());

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
			em.remove(em.getReference(ServTransferRouteView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
