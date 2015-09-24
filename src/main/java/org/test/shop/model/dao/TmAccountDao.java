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
import org.test.shop.model.domain.entity.TmAccount;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmAccountDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tma0 FROM TmAccount tma0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tma0";
	private String className = "TmAccount";
	private String tableName = "tm_account";

	public TmAccount create(TmAccount tmaccount) {
		em.persist(tmaccount);
		return tmaccount;
	}

	public TmAccount update(TmAccount tmaccount) {
		return em.merge(tmaccount);
	}
	
	public void popularityByKey(Object key) {
		TmAccount tmaccount = findById(key, false);
		
		if(tmaccount != null){
			if (SObject.class.isAssignableFrom(TmAccount.class)) {
				if (tmaccount.getPopularity() == null) {
					tmaccount.setPopularity(-1);
				}
				tmaccount.setPopularity(tmaccount.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmAccount.class)
							.setParameter("popularity", tmaccount.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmAccount item) {
		TmAccount tmaccount = null;
		if(item != null){
			tmaccount = findById(item.getId(), false);
		}
		
		if(tmaccount != null){
			if (SObject.class.isAssignableFrom(TmAccount.class)) {
				if (tmaccount.getPopularity() == null) {
					tmaccount.setPopularity(-1);
				}
				tmaccount.setPopularity(tmaccount.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmAccount.class)
							.setParameter("popularity", tmaccount.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmAccount.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmAccount> namedFilter(ScrollableSettings settings) {
		List<TmAccount> tmaccounts = new ArrayList<TmAccount>();
		
		try {
			tmaccounts = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmAccount.class), settings,
				TmAccount.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmaccounts;
	}

	@SuppressWarnings("unchecked")
	public List<TmAccount> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmAccount>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmAccount(), settings.getFilter(), TmAccount.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmAccount.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmAccount.class)), TmAccount.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmAccount.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmAccount> findByExample(TmAccount example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmAccount.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmAccount.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmAccount> findByExample2(TmAccount example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmAccount.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmAccount> findAll(ScrollableSettings settings) {
		List<TmAccount> tmaccounts = DaoUtil.sasQuery(selectClause, settings,
				TmAccount.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmAccount item : tmaccounts) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmAccount item : tmaccounts) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmaccounts;
	}

	@SuppressWarnings("unchecked")
	public List<TmAccount> findAllScrollable(ScrollableSettings settings) {
		List<TmAccount> tmaccounts = DaoUtil
				.sasQuery(selectClause, settings, TmAccount.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmAccount item : tmaccounts) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmAccount item : tmaccounts) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmaccounts;
	}

	public TmAccount findById(Object key, Boolean initAll) {
		TmAccount item = em.find(TmAccount.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmAccount findById(ScrollableSettings settings) {
		TmAccount item = em.find(TmAccount.class, settings.getId());

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
			em.remove(em.getReference(TmAccount.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
