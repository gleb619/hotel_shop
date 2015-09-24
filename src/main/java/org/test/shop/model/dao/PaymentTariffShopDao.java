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
import org.test.shop.model.domain.entity.PaymentTariffShop;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentTariffShopDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentTariffShop pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentTariffShop";
	private String tableName = "payment_tariff_shop";

	public PaymentTariffShop create(PaymentTariffShop paymenttariffshop) {
		em.persist(paymenttariffshop);
		return paymenttariffshop;
	}

	public PaymentTariffShop update(PaymentTariffShop paymenttariffshop) {
		return em.merge(paymenttariffshop);
	}
	
	public void popularityByKey(Object key) {
		PaymentTariffShop paymenttariffshop = findById(key, false);
		
		if(paymenttariffshop != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShop.class)) {
				if (paymenttariffshop.getPopularity() == null) {
					paymenttariffshop.setPopularity(-1);
				}
				paymenttariffshop.setPopularity(paymenttariffshop.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShop.class)
							.setParameter("popularity", paymenttariffshop.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentTariffShop item) {
		PaymentTariffShop paymenttariffshop = null;
		if(item != null){
			paymenttariffshop = findById(item.getId(), false);
		}
		
		if(paymenttariffshop != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShop.class)) {
				if (paymenttariffshop.getPopularity() == null) {
					paymenttariffshop.setPopularity(-1);
				}
				paymenttariffshop.setPopularity(paymenttariffshop.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShop.class)
							.setParameter("popularity", paymenttariffshop.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentTariffShop.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentTariffShop> namedFilter(ScrollableSettings settings) {
		List<PaymentTariffShop> paymenttariffshops = new ArrayList<PaymentTariffShop>();
		
		try {
			paymenttariffshops = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentTariffShop.class), settings,
				PaymentTariffShop.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymenttariffshops;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShop> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentTariffShop>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentTariffShop(), settings.getFilter(), PaymentTariffShop.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentTariffShop.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentTariffShop.class)), PaymentTariffShop.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentTariffShop.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShop> findByExample(PaymentTariffShop example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentTariffShop.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentTariffShop.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentTariffShop> findByExample2(PaymentTariffShop example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentTariffShop.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShop> findAll(ScrollableSettings settings) {
		List<PaymentTariffShop> paymenttariffshops = DaoUtil.sasQuery(selectClause, settings,
				PaymentTariffShop.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShop item : paymenttariffshops) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShop item : paymenttariffshops) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshops;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShop> findAllScrollable(ScrollableSettings settings) {
		List<PaymentTariffShop> paymenttariffshops = DaoUtil
				.sasQuery(selectClause, settings, PaymentTariffShop.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShop item : paymenttariffshops) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShop item : paymenttariffshops) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshops;
	}

	public PaymentTariffShop findById(Object key, Boolean initAll) {
		PaymentTariffShop item = em.find(PaymentTariffShop.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentTariffShop findById(ScrollableSettings settings) {
		PaymentTariffShop item = em.find(PaymentTariffShop.class, settings.getId());

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
			em.remove(em.getReference(PaymentTariffShop.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
