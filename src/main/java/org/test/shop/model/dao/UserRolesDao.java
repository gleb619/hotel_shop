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
import org.test.shop.model.domain.entity.UserRoles;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UserRolesDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UserRoles use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UserRoles";
	private String tableName = "user_roles";

	public UserRoles create(UserRoles userroles) {
		em.persist(userroles);
		return userroles;
	}

	public UserRoles update(UserRoles userroles) {
		return em.merge(userroles);
	}
	
	public void popularityByKey(Object key) {
		UserRoles userroles = findById(key, false);
		
		if(userroles != null){
			if (SObject.class.isAssignableFrom(UserRoles.class)) {
				if (userroles.getPopularity() == null) {
					userroles.setPopularity(-1);
				}
				userroles.setPopularity(userroles.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRoles.class)
							.setParameter("popularity", userroles.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UserRoles item) {
		UserRoles userroles = null;
		if(item != null){
			userroles = findById(item.getId(), false);
		}
		
		if(userroles != null){
			if (SObject.class.isAssignableFrom(UserRoles.class)) {
				if (userroles.getPopularity() == null) {
					userroles.setPopularity(-1);
				}
				userroles.setPopularity(userroles.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRoles.class)
							.setParameter("popularity", userroles.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UserRoles.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UserRoles> namedFilter(ScrollableSettings settings) {
		List<UserRoles> userroless = new ArrayList<UserRoles>();
		
		try {
			userroless = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UserRoles.class), settings,
				UserRoles.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return userroless;
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UserRoles>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UserRoles(), settings.getFilter(), UserRoles.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UserRoles.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UserRoles.class)), UserRoles.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UserRoles.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findByExample(UserRoles example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UserRoles.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UserRoles.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRoles> findByExample2(UserRoles example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UserRoles.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findAll(ScrollableSettings settings) {
		List<UserRoles> userroless = DaoUtil.sasQuery(selectClause, settings,
				UserRoles.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRoles item : userroless) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRoles item : userroless) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userroless;
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findAllScrollable(ScrollableSettings settings) {
		List<UserRoles> userroless = DaoUtil
				.sasQuery(selectClause, settings, UserRoles.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRoles item : userroless) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRoles item : userroless) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userroless;
	}

	public UserRoles findById(Object key, Boolean initAll) {
		UserRoles item = em.find(UserRoles.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UserRoles findById(ScrollableSettings settings) {
		UserRoles item = em.find(UserRoles.class, settings.getId());

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
			em.remove(em.getReference(UserRoles.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
