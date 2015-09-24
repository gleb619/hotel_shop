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
import org.test.shop.model.domain.entity.PaymentPrice;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentPriceDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentPrice pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentPrice";
	private String tableName = "payment_price";

	public PaymentPrice create(PaymentPrice paymentprice) {
		em.persist(paymentprice);
		return paymentprice;
	}

	public PaymentPrice update(PaymentPrice paymentprice) {
		return em.merge(paymentprice);
	}
	
	public void popularityByKey(Object key) {
		PaymentPrice paymentprice = findById(key, false);
		
		if(paymentprice != null){
			if (SObject.class.isAssignableFrom(PaymentPrice.class)) {
				if (paymentprice.getPopularity() == null) {
					paymentprice.setPopularity(-1);
				}
				paymentprice.setPopularity(paymentprice.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPrice.class)
							.setParameter("popularity", paymentprice.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentPrice item) {
		PaymentPrice paymentprice = null;
		if(item != null){
			paymentprice = findById(item.getId(), false);
		}
		
		if(paymentprice != null){
			if (SObject.class.isAssignableFrom(PaymentPrice.class)) {
				if (paymentprice.getPopularity() == null) {
					paymentprice.setPopularity(-1);
				}
				paymentprice.setPopularity(paymentprice.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPrice.class)
							.setParameter("popularity", paymentprice.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentPrice.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentPrice> namedFilter(ScrollableSettings settings) {
		List<PaymentPrice> paymentprices = new ArrayList<PaymentPrice>();
		
		try {
			paymentprices = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentPrice.class), settings,
				PaymentPrice.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymentprices;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPrice> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentPrice>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentPrice(), settings.getFilter(), PaymentPrice.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentPrice.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentPrice.class)), PaymentPrice.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentPrice.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPrice> findByExample(PaymentPrice example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentPrice.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentPrice.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentPrice> findByExample2(PaymentPrice example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentPrice.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPrice> findAll(ScrollableSettings settings) {
		List<PaymentPrice> paymentprices = DaoUtil.sasQuery(selectClause, settings,
				PaymentPrice.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPrice item : paymentprices) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPrice item : paymentprices) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentprices;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPrice> findAllScrollable(ScrollableSettings settings) {
		List<PaymentPrice> paymentprices = DaoUtil
				.sasQuery(selectClause, settings, PaymentPrice.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPrice item : paymentprices) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPrice item : paymentprices) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentprices;
	}

	public PaymentPrice findById(Object key, Boolean initAll) {
		PaymentPrice item = em.find(PaymentPrice.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentPrice findById(ScrollableSettings settings) {
		PaymentPrice item = em.find(PaymentPrice.class, settings.getId());

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
			em.remove(em.getReference(PaymentPrice.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
