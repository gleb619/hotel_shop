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
import org.test.shop.model.domain.entity.TmContact;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmContactDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmc0 FROM TmContact tmc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmc0";
	private String className = "TmContact";
	private String tableName = "tm_contact";

	public TmContact create(TmContact tmcontact) {
		em.persist(tmcontact);
		return tmcontact;
	}

	public TmContact update(TmContact tmcontact) {
		return em.merge(tmcontact);
	}
	
	public void popularityByKey(Object key) {
		TmContact tmcontact = findById(key, false);
		
		if(tmcontact != null){
			if (SObject.class.isAssignableFrom(TmContact.class)) {
				if (tmcontact.getPopularity() == null) {
					tmcontact.setPopularity(-1);
				}
				tmcontact.setPopularity(tmcontact.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContact.class)
							.setParameter("popularity", tmcontact.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmContact item) {
		TmContact tmcontact = null;
		if(item != null){
			tmcontact = findById(item.getId(), false);
		}
		
		if(tmcontact != null){
			if (SObject.class.isAssignableFrom(TmContact.class)) {
				if (tmcontact.getPopularity() == null) {
					tmcontact.setPopularity(-1);
				}
				tmcontact.setPopularity(tmcontact.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmContact.class)
							.setParameter("popularity", tmcontact.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmContact.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmContact> namedFilter(ScrollableSettings settings) {
		List<TmContact> tmcontacts = new ArrayList<TmContact>();
		
		try {
			tmcontacts = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmContact.class), settings,
				TmContact.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmcontacts;
	}

	@SuppressWarnings("unchecked")
	public List<TmContact> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmContact>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmContact(), settings.getFilter(), TmContact.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmContact.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmContact.class)), TmContact.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmContact.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContact> findByExample(TmContact example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmContact.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmContact.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmContact> findByExample2(TmContact example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmContact.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmContact> findAll(ScrollableSettings settings) {
		List<TmContact> tmcontacts = DaoUtil.sasQuery(selectClause, settings,
				TmContact.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContact item : tmcontacts) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContact item : tmcontacts) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacts;
	}

	@SuppressWarnings("unchecked")
	public List<TmContact> findAllScrollable(ScrollableSettings settings) {
		List<TmContact> tmcontacts = DaoUtil
				.sasQuery(selectClause, settings, TmContact.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmContact item : tmcontacts) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmContact item : tmcontacts) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmcontacts;
	}

	public TmContact findById(Object key, Boolean initAll) {
		TmContact item = em.find(TmContact.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmContact findById(ScrollableSettings settings) {
		TmContact item = em.find(TmContact.class, settings.getId());

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
			em.remove(em.getReference(TmContact.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
