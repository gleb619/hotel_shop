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
import org.test.shop.model.domain.entity.view.PaymentDetailsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentDetailsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentDetailsView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentDetailsView";
	private String tableName = "payment_details_view";

	public PaymentDetailsView create(PaymentDetailsView paymentdetailsview) {
		em.persist(paymentdetailsview);
		return paymentdetailsview;
	}

	public PaymentDetailsView update(PaymentDetailsView paymentdetailsview) {
		return em.merge(paymentdetailsview);
	}
	
	public void popularityByKey(Object key) {
		PaymentDetailsView paymentdetailsview = findById(key, false);
		
		if(paymentdetailsview != null){
			if (SObject.class.isAssignableFrom(PaymentDetailsView.class)) {
				if (paymentdetailsview.getPopularity() == null) {
					paymentdetailsview.setPopularity(-1);
				}
				paymentdetailsview.setPopularity(paymentdetailsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentDetailsView.class)
							.setParameter("popularity", paymentdetailsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentDetailsView item) {
		PaymentDetailsView paymentdetailsview = null;
		if(item != null){
			paymentdetailsview = findById(item.getId(), false);
		}
		
		if(paymentdetailsview != null){
			if (SObject.class.isAssignableFrom(PaymentDetailsView.class)) {
				if (paymentdetailsview.getPopularity() == null) {
					paymentdetailsview.setPopularity(-1);
				}
				paymentdetailsview.setPopularity(paymentdetailsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentDetailsView.class)
							.setParameter("popularity", paymentdetailsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentDetailsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentDetailsView> namedFilter(ScrollableSettings settings) {
		List<PaymentDetailsView> paymentdetailsviews = new ArrayList<PaymentDetailsView>();
		
		try {
			paymentdetailsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentDetailsView.class), settings,
				PaymentDetailsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymentdetailsviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetailsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentDetailsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentDetailsView(), settings.getFilter(), PaymentDetailsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentDetailsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentDetailsView.class)), PaymentDetailsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentDetailsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetailsView> findByExample(PaymentDetailsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentDetailsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentDetailsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentDetailsView> findByExample2(PaymentDetailsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentDetailsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetailsView> findAll(ScrollableSettings settings) {
		List<PaymentDetailsView> paymentdetailsviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentDetailsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentDetailsView item : paymentdetailsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentDetailsView item : paymentdetailsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentdetailsviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentDetailsView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentDetailsView> paymentdetailsviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentDetailsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentDetailsView item : paymentdetailsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentDetailsView item : paymentdetailsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymentdetailsviews;
	}

	public PaymentDetailsView findById(Object key, Boolean initAll) {
		PaymentDetailsView item = em.find(PaymentDetailsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentDetailsView findById(ScrollableSettings settings) {
		PaymentDetailsView item = em.find(PaymentDetailsView.class, settings.getId());

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
			em.remove(em.getReference(PaymentDetailsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
