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
import org.test.shop.model.domain.entity.view.PaymentPriceView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentPriceViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentPriceView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentPriceView";
	private String tableName = "payment_price_view";

	public PaymentPriceView create(PaymentPriceView paymentpriceview) {
		em.persist(paymentpriceview);
		return paymentpriceview;
	}

	public PaymentPriceView update(PaymentPriceView paymentpriceview) {
		return em.merge(paymentpriceview);
	}
	
	public void popularityByKey(Object key) {
		PaymentPriceView paymentpriceview = findById(key, false);
		
		if(paymentpriceview != null){
			if (SObject.class.isAssignableFrom(PaymentPriceView.class)) {
				if (paymentpriceview.getPopularity() == null) {
					paymentpriceview.setPopularity(-1);
				}
				paymentpriceview.setPopularity(paymentpriceview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceView.class)
							.setParameter("popularity", paymentpriceview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentPriceView item) {
		PaymentPriceView paymentpriceview = null;
		if(item != null){
			paymentpriceview = findById(item.getId(), false);
		}
		
		if(paymentpriceview != null){
			if (SObject.class.isAssignableFrom(PaymentPriceView.class)) {
				if (paymentpriceview.getPopularity() == null) {
					paymentpriceview.setPopularity(-1);
				}
				paymentpriceview.setPopularity(paymentpriceview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceView.class)
							.setParameter("popularity", paymentpriceview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentPriceView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentPriceView> namedFilter(ScrollableSettings settings) {
		List<PaymentPriceView> paymentpriceviews = new ArrayList<PaymentPriceView>();
		
		try {
			paymentpriceviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentPriceView.class), settings,
				PaymentPriceView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymentpriceviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentPriceView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentPriceView(), settings.getFilter(), PaymentPriceView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentPriceView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentPriceView.class)), PaymentPriceView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentPriceView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceView> findByExample(PaymentPriceView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentPriceView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentPriceView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentPriceView> findByExample2(PaymentPriceView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentPriceView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceView> findAll(ScrollableSettings settings) {
		List<PaymentPriceView> paymentpriceviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentPriceView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceView item : paymentpriceviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceView item : paymentpriceviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentPriceView> paymentpriceviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentPriceView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceView item : paymentpriceviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceView item : paymentpriceviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceviews;
	}

	public PaymentPriceView findById(Object key, Boolean initAll) {
		PaymentPriceView item = em.find(PaymentPriceView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentPriceView findById(ScrollableSettings settings) {
		PaymentPriceView item = em.find(PaymentPriceView.class, settings.getId());

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
			em.remove(em.getReference(PaymentPriceView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
