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
import org.test.shop.model.domain.entity.PaymentPriceShop;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentPriceShopDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentPriceShop pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentPriceShop";
	private String tableName = "payment_price_shop";

	public PaymentPriceShop create(PaymentPriceShop paymentpriceshop) {
		em.persist(paymentpriceshop);
		return paymentpriceshop;
	}

	public PaymentPriceShop update(PaymentPriceShop paymentpriceshop) {
		return em.merge(paymentpriceshop);
	}
	
	public void popularityByKey(Object key) {
		PaymentPriceShop paymentpriceshop = findById(key, false);
		
		if(paymentpriceshop != null){
			if (SObject.class.isAssignableFrom(PaymentPriceShop.class)) {
				if (paymentpriceshop.getPopularity() == null) {
					paymentpriceshop.setPopularity(-1);
				}
				paymentpriceshop.setPopularity(paymentpriceshop.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceShop.class)
							.setParameter("popularity", paymentpriceshop.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentPriceShop item) {
		PaymentPriceShop paymentpriceshop = null;
		if(item != null){
			paymentpriceshop = findById(item.getId(), false);
		}
		
		if(paymentpriceshop != null){
			if (SObject.class.isAssignableFrom(PaymentPriceShop.class)) {
				if (paymentpriceshop.getPopularity() == null) {
					paymentpriceshop.setPopularity(-1);
				}
				paymentpriceshop.setPopularity(paymentpriceshop.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceShop.class)
							.setParameter("popularity", paymentpriceshop.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentPriceShop.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentPriceShop> namedFilter(ScrollableSettings settings) {
		List<PaymentPriceShop> paymentpriceshops = new ArrayList<PaymentPriceShop>();
		
		try {
			paymentpriceshops = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentPriceShop.class), settings,
				PaymentPriceShop.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymentpriceshops;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShop> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentPriceShop>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentPriceShop(), settings.getFilter(), PaymentPriceShop.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentPriceShop.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentPriceShop.class)), PaymentPriceShop.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentPriceShop.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShop> findByExample(PaymentPriceShop example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentPriceShop.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentPriceShop.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentPriceShop> findByExample2(PaymentPriceShop example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentPriceShop.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShop> findAll(ScrollableSettings settings) {
		List<PaymentPriceShop> paymentpriceshops = DaoUtil.sasQuery(selectClause, settings,
				PaymentPriceShop.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceShop item : paymentpriceshops) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceShop item : paymentpriceshops) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceshops;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShop> findAllScrollable(ScrollableSettings settings) {
		List<PaymentPriceShop> paymentpriceshops = DaoUtil
				.sasQuery(selectClause, settings, PaymentPriceShop.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceShop item : paymentpriceshops) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceShop item : paymentpriceshops) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceshops;
	}

	public PaymentPriceShop findById(Object key, Boolean initAll) {
		PaymentPriceShop item = em.find(PaymentPriceShop.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentPriceShop findById(ScrollableSettings settings) {
		PaymentPriceShop item = em.find(PaymentPriceShop.class, settings.getId());

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
			em.remove(em.getReference(PaymentPriceShop.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
