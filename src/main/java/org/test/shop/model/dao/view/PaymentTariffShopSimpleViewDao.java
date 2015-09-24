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
import org.test.shop.model.domain.entity.view.PaymentTariffShopSimpleView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentTariffShopSimpleViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentTariffShopSimpleView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentTariffShopSimpleView";
	private String tableName = "payment_tariff_shop_simple_view";

	public PaymentTariffShopSimpleView create(PaymentTariffShopSimpleView paymenttariffshopsimpleview) {
		em.persist(paymenttariffshopsimpleview);
		return paymenttariffshopsimpleview;
	}

	public PaymentTariffShopSimpleView update(PaymentTariffShopSimpleView paymenttariffshopsimpleview) {
		return em.merge(paymenttariffshopsimpleview);
	}
	
	public void popularityByKey(Object key) {
		PaymentTariffShopSimpleView paymenttariffshopsimpleview = findById(key, false);
		
		if(paymenttariffshopsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShopSimpleView.class)) {
				if (paymenttariffshopsimpleview.getPopularity() == null) {
					paymenttariffshopsimpleview.setPopularity(-1);
				}
				paymenttariffshopsimpleview.setPopularity(paymenttariffshopsimpleview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShopSimpleView.class)
							.setParameter("popularity", paymenttariffshopsimpleview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentTariffShopSimpleView item) {
		PaymentTariffShopSimpleView paymenttariffshopsimpleview = null;
		if(item != null){
			paymenttariffshopsimpleview = findById(item.getId(), false);
		}
		
		if(paymenttariffshopsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffShopSimpleView.class)) {
				if (paymenttariffshopsimpleview.getPopularity() == null) {
					paymenttariffshopsimpleview.setPopularity(-1);
				}
				paymenttariffshopsimpleview.setPopularity(paymenttariffshopsimpleview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffShopSimpleView.class)
							.setParameter("popularity", paymenttariffshopsimpleview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentTariffShopSimpleView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentTariffShopSimpleView> namedFilter(ScrollableSettings settings) {
		List<PaymentTariffShopSimpleView> paymenttariffshopsimpleviews = new ArrayList<PaymentTariffShopSimpleView>();
		
		try {
			paymenttariffshopsimpleviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentTariffShopSimpleView.class), settings,
				PaymentTariffShopSimpleView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymenttariffshopsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopSimpleView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentTariffShopSimpleView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentTariffShopSimpleView(), settings.getFilter(), PaymentTariffShopSimpleView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentTariffShopSimpleView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentTariffShopSimpleView.class)), PaymentTariffShopSimpleView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentTariffShopSimpleView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopSimpleView> findByExample(PaymentTariffShopSimpleView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentTariffShopSimpleView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentTariffShopSimpleView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopSimpleView> findByExample2(PaymentTariffShopSimpleView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentTariffShopSimpleView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopSimpleView> findAll(ScrollableSettings settings) {
		List<PaymentTariffShopSimpleView> paymenttariffshopsimpleviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentTariffShopSimpleView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShopSimpleView item : paymenttariffshopsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShopSimpleView item : paymenttariffshopsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshopsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffShopSimpleView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentTariffShopSimpleView> paymenttariffshopsimpleviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentTariffShopSimpleView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffShopSimpleView item : paymenttariffshopsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffShopSimpleView item : paymenttariffshopsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffshopsimpleviews;
	}

	public PaymentTariffShopSimpleView findById(Object key, Boolean initAll) {
		PaymentTariffShopSimpleView item = em.find(PaymentTariffShopSimpleView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentTariffShopSimpleView findById(ScrollableSettings settings) {
		PaymentTariffShopSimpleView item = em.find(PaymentTariffShopSimpleView.class, settings.getId());

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
			em.remove(em.getReference(PaymentTariffShopSimpleView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
