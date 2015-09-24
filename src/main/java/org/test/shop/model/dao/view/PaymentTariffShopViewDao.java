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
import org.test.shop.model.domain.entity.view.PaymentTariffShopView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentTariffShopViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentTariffShopView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentTariffShopView";
	private String tableName = "payment_tariff_shop_view";

	public PaymentTariffShopView create(PaymentTariffShopView paymenttariffshopview) {
		em.persist(paymenttariffshopview);
		return paymenttariffshopview;
	}

	public PaymentTariffShopView update(PaymentTariffShopView paymenttariffshopview) {
		return em.merge(paymenttariffshopview);
	}
	
	public void popularityByKey(Object key) {
		PaymentTariffShopView paymenttariffshopview = findById(key, false);
		
		if(paymenttariffshopview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShopView.class)) {
				if (paymenttariffshopview.getPopularity() == null) {
					paymenttariffshopview.setPopularity(-1);
				}
				paymenttariffshopview.setPopularity(paymenttariffshopview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShopView.class)
							.setParameter("popularity", paymenttariffshopview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentTariffShopView item) {
		PaymentTariffShopView paymenttariffshopview = null;
		if(item != null){
			paymenttariffshopview = findById(item.getId(), false);
		}
		
		if(paymenttariffshopview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShopView.class)) {
				if (paymenttariffshopview.getPopularity() == null) {
					paymenttariffshopview.setPopularity(-1);
				}
				paymenttariffshopview.setPopularity(paymenttariffshopview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShopView.class)
							.setParameter("popularity", paymenttariffshopview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentTariffShopView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentTariffShopView> namedFilter(ScrollableSettings settings) {
		List<PaymentTariffShopView> paymenttariffshopviews = new ArrayList<PaymentTariffShopView>();
		
		try {
			paymenttariffshopviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentTariffShopView.class), settings,
				PaymentTariffShopView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymenttariffshopviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentTariffShopView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentTariffShopView(), settings.getFilter(), PaymentTariffShopView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentTariffShopView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentTariffShopView.class)), PaymentTariffShopView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentTariffShopView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopView> findByExample(PaymentTariffShopView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentTariffShopView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentTariffShopView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopView> findByExample2(PaymentTariffShopView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentTariffShopView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopView> findAll(ScrollableSettings settings) {
		List<PaymentTariffShopView> paymenttariffshopviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentTariffShopView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShopView item : paymenttariffshopviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShopView item : paymenttariffshopviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshopviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentTariffShopView> paymenttariffshopviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentTariffShopView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShopView item : paymenttariffshopviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShopView item : paymenttariffshopviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshopviews;
	}

	public PaymentTariffShopView findById(Object key, Boolean initAll) {
		PaymentTariffShopView item = em.find(PaymentTariffShopView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentTariffShopView findById(ScrollableSettings settings) {
		PaymentTariffShopView item = em.find(PaymentTariffShopView.class, settings.getId());

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
			em.remove(em.getReference(PaymentTariffShopView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
