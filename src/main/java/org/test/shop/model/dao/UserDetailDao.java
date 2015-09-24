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
import org.test.shop.model.domain.entity.UserDetail;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UserDetailDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UserDetail use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UserDetail";
	private String tableName = "user_detail";

	public UserDetail create(UserDetail userdetail) {
		em.persist(userdetail);
		return userdetail;
	}

	public UserDetail update(UserDetail userdetail) {
		return em.merge(userdetail);
	}
	
	public void popularityByKey(Object key) {
		UserDetail userdetail = findById(key, false);
		
		if(userdetail != null){
			if (SObject.class.isAssignableFrom(UserDetail.class)) {
				if (userdetail.getPopularity() == null) {
					userdetail.setPopularity(-1);
				}
				userdetail.setPopularity(userdetail.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserDetail.class)
							.setParameter("popularity", userdetail.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UserDetail item) {
		UserDetail userdetail = null;
		if(item != null){
			userdetail = findById(item.getId(), false);
		}
		
		if(userdetail != null){
			if (SObject.class.isAssignableFrom(UserDetail.class)) {
				if (userdetail.getPopularity() == null) {
					userdetail.setPopularity(-1);
				}
				userdetail.setPopularity(userdetail.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserDetail.class)
							.setParameter("popularity", userdetail.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UserDetail.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UserDetail> namedFilter(ScrollableSettings settings) {
		List<UserDetail> userdetails = new ArrayList<UserDetail>();
		
		try {
			userdetails = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UserDetail.class), settings,
				UserDetail.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return userdetails;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UserDetail>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UserDetail(), settings.getFilter(), UserDetail.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UserDetail.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UserDetail.class)), UserDetail.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UserDetail.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> findByExample(UserDetail example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UserDetail.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UserDetail.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDetail> findByExample2(UserDetail example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UserDetail.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> findAll(ScrollableSettings settings) {
		List<UserDetail> userdetails = DaoUtil.sasQuery(selectClause, settings,
				UserDetail.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UserDetail item : userdetails) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserDetail item : userdetails) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userdetails;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetail> findAllScrollable(ScrollableSettings settings) {
		List<UserDetail> userdetails = DaoUtil
				.sasQuery(selectClause, settings, UserDetail.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UserDetail item : userdetails) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserDetail item : userdetails) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userdetails;
	}

	public UserDetail findById(Object key, Boolean initAll) {
		UserDetail item = em.find(UserDetail.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UserDetail findById(ScrollableSettings settings) {
		UserDetail item = em.find(UserDetail.class, settings.getId());

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
			em.remove(em.getReference(UserDetail.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
