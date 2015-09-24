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
import org.test.shop.model.domain.entity.view.PaymentTariffSimpleView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentTariffSimpleViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentTariffSimpleView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentTariffSimpleView";
	private String tableName = "payment_tariff_simple_view";

	public PaymentTariffSimpleView create(PaymentTariffSimpleView paymenttariffsimpleview) {
		em.persist(paymenttariffsimpleview);
		return paymenttariffsimpleview;
	}

	public PaymentTariffSimpleView update(PaymentTariffSimpleView paymenttariffsimpleview) {
		return em.merge(paymenttariffsimpleview);
	}
	
	public void popularityByKey(Object key) {
		PaymentTariffSimpleView paymenttariffsimpleview = findById(key, false);
		
		if(paymenttariffsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffSimpleView.class)) {
				if (paymenttariffsimpleview.getPopularity() == null) {
					paymenttariffsimpleview.setPopularity(-1);
				}
				paymenttariffsimpleview.setPopularity(paymenttariffsimpleview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffSimpleView.class)
							.setParameter("popularity", paymenttariffsimpleview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentTariffSimpleView item) {
		PaymentTariffSimpleView paymenttariffsimpleview = null;
		if(item != null){
			paymenttariffsimpleview = findById(item.getId(), false);
		}
		
		if(paymenttariffsimpleview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffSimpleView.class)) {
				if (paymenttariffsimpleview.getPopularity() == null) {
					paymenttariffsimpleview.setPopularity(-1);
				}
				paymenttariffsimpleview.setPopularity(paymenttariffsimpleview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffSimpleView.class)
							.setParameter("popularity", paymenttariffsimpleview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentTariffSimpleView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentTariffSimpleView> namedFilter(ScrollableSettings settings) {
		List<PaymentTariffSimpleView> paymenttariffsimpleviews = new ArrayList<PaymentTariffSimpleView>();
		
		try {
			paymenttariffsimpleviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentTariffSimpleView.class), settings,
				PaymentTariffSimpleView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymenttariffsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffSimpleView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentTariffSimpleView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentTariffSimpleView(), settings.getFilter(), PaymentTariffSimpleView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentTariffSimpleView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentTariffSimpleView.class)), PaymentTariffSimpleView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentTariffSimpleView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffSimpleView> findByExample(PaymentTariffSimpleView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentTariffSimpleView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentTariffSimpleView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentTariffSimpleView> findByExample2(PaymentTariffSimpleView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentTariffSimpleView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffSimpleView> findAll(ScrollableSettings settings) {
		List<PaymentTariffSimpleView> paymenttariffsimpleviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentTariffSimpleView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffSimpleView item : paymenttariffsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffSimpleView item : paymenttariffsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffsimpleviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffSimpleView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentTariffSimpleView> paymenttariffsimpleviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentTariffSimpleView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffSimpleView item : paymenttariffsimpleviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffSimpleView item : paymenttariffsimpleviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffsimpleviews;
	}

	public PaymentTariffSimpleView findById(Object key, Boolean initAll) {
		PaymentTariffSimpleView item = em.find(PaymentTariffSimpleView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentTariffSimpleView findById(ScrollableSettings settings) {
		PaymentTariffSimpleView item = em.find(PaymentTariffSimpleView.class, settings.getId());

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
			em.remove(em.getReference(PaymentTariffSimpleView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
