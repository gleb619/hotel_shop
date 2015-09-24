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
import org.test.shop.model.domain.entity.view.PaymentPriceShopSimpleView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentPriceShopSimpleViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentPriceShopSimpleView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentPriceShopSimpleView";
	private String tableName = "payment_price_shop_simple_view";

	public PaymentPriceShopSimpleView create(PaymentPriceShopSimpleView paymentpriceshopsimpleview) {
		em.persist(paymentpriceshopsimpleview);
		return paymentpriceshopsimpleview;
	}

	public PaymentPriceShopSimpleView update(PaymentPriceShopSimpleView paymentpriceshopsimpleview) {
		return em.merge(paymentpriceshopsimpleview);
	}
	
	public void popularityByKey(Object key) {
		PaymentPriceShopSimpleView paymentpriceshopsimpleview = findById(key, false);
		
		if(paymentpriceshopsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentPriceShopSimpleView.class)) {
				if (paymentpriceshopsimpleview.getPopularity() == null) {
					paymentpriceshopsimpleview.setPopularity(-1);
				}
				paymentpriceshopsimpleview.setPopularity(paymentpriceshopsimpleview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceShopSimpleView.class)
							.setParameter("popularity", paymentpriceshopsimpleview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentPriceShopSimpleView item) {
		PaymentPriceShopSimpleView paymentpriceshopsimpleview = null;
		if(item != null){
			paymentpriceshopsimpleview = findById(item.getId(), false);
		}
		
		if(paymentpriceshopsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentPriceShopSimpleView.class)) {
				if (paymentpriceshopsimpleview.getPopularity() == null) {
					paymentpriceshopsimpleview.setPopularity(-1);
				}
				paymentpriceshopsimpleview.setPopularity(paymentpriceshopsimpleview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentPriceShopSimpleView.class)
							.setParameter("popularity", paymentpriceshopsimpleview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentPriceShopSimpleView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentPriceShopSimpleView> namedFilter(ScrollableSettings settings) {
		List<PaymentPriceShopSimpleView> paymentpriceshopsimpleviews = new ArrayList<PaymentPriceShopSimpleView>();
		
		try {
			paymentpriceshopsimpleviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentPriceShopSimpleView.class), settings,
				PaymentPriceShopSimpleView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymentpriceshopsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShopSimpleView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentPriceShopSimpleView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentPriceShopSimpleView(), settings.getFilter(), PaymentPriceShopSimpleView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentPriceShopSimpleView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentPriceShopSimpleView.class)), PaymentPriceShopSimpleView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentPriceShopSimpleView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShopSimpleView> findByExample(PaymentPriceShopSimpleView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentPriceShopSimpleView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentPriceShopSimpleView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentPriceShopSimpleView> findByExample2(PaymentPriceShopSimpleView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentPriceShopSimpleView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShopSimpleView> findAll(ScrollableSettings settings) {
		List<PaymentPriceShopSimpleView> paymentpriceshopsimpleviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentPriceShopSimpleView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceShopSimpleView item : paymentpriceshopsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceShopSimpleView item : paymentpriceshopsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceshopsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentPriceShopSimpleView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentPriceShopSimpleView> paymentpriceshopsimpleviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentPriceShopSimpleView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentPriceShopSimpleView item : paymentpriceshopsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentPriceShopSimpleView item : paymentpriceshopsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentpriceshopsimpleviews;
	}

	public PaymentPriceShopSimpleView findById(Object key, Boolean initAll) {
		PaymentPriceShopSimpleView item = em.find(PaymentPriceShopSimpleView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentPriceShopSimpleView findById(ScrollableSettings settings) {
		PaymentPriceShopSimpleView item = em.find(PaymentPriceShopSimpleView.class, settings.getId());

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
			em.remove(em.getReference(PaymentPriceShopSimpleView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
