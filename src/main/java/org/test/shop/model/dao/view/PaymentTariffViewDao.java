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
import org.test.shop.model.domain.entity.view.PaymentTariffView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class PaymentTariffViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT pay0 FROM PaymentTariffView pay0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "pay0";
	private String className = "PaymentTariffView";
	private String tableName = "payment_tariff_view";

	public PaymentTariffView create(PaymentTariffView paymenttariffview) {
		em.persist(paymenttariffview);
		return paymenttariffview;
	}

	public PaymentTariffView update(PaymentTariffView paymenttariffview) {
		return em.merge(paymenttariffview);
	}
	
	public void popularityByKey(Object key) {
		PaymentTariffView paymenttariffview = findById(key, false);
		
		if(paymenttariffview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffView.class)) {
				if (paymenttariffview.getPopularity() == null) {
					paymenttariffview.setPopularity(-1);
				}
				paymenttariffview.setPopularity(paymenttariffview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffView.class)
							.setParameter("popularity", paymenttariffview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(PaymentTariffView item) {
		PaymentTariffView paymenttariffview = null;
		if(item != null){
			paymenttariffview = findById(item.getId(), false);
		}
		
		if(paymenttariffview != null){
			if (SObject.class.isAssignableFrom(PaymentTariffView.class)) {
				if (paymenttariffview.getPopularity() == null) {
					paymenttariffview.setPopularity(-1);
				}
				paymenttariffview.setPopularity(paymenttariffview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), PaymentTariffView.class)
							.setParameter("popularity", paymenttariffview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, PaymentTariffView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<PaymentTariffView> namedFilter(ScrollableSettings settings) {
		List<PaymentTariffView> paymenttariffviews = new ArrayList<PaymentTariffView>();
		
		try {
			paymenttariffviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), PaymentTariffView.class), settings,
				PaymentTariffView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return paymenttariffviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<PaymentTariffView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new PaymentTariffView(), settings.getFilter(), PaymentTariffView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, PaymentTariffView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(PaymentTariffView.class)), PaymentTariffView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, PaymentTariffView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffView> findByExample(PaymentTariffView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				PaymentTariffView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, PaymentTariffView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentTariffView> findByExample2(PaymentTariffView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, PaymentTariffView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffView> findAll(ScrollableSettings settings) {
		List<PaymentTariffView> paymenttariffviews = DaoUtil.sasQuery(selectClause, settings,
				PaymentTariffView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffView item : paymenttariffviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffView item : paymenttariffviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffviews;
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTariffView> findAllScrollable(ScrollableSettings settings) {
		List<PaymentTariffView> paymenttariffviews = DaoUtil
				.sasQuery(selectClause, settings, PaymentTariffView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (PaymentTariffView item : paymenttariffviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (PaymentTariffView item : paymenttariffviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return paymenttariffviews;
	}

	public PaymentTariffView findById(Object key, Boolean initAll) {
		PaymentTariffView item = em.find(PaymentTariffView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public PaymentTariffView findById(ScrollableSettings settings) {
		PaymentTariffView item = em.find(PaymentTariffView.class, settings.getId());

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
			em.remove(em.getReference(PaymentTariffView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
