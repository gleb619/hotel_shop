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
import org.test.shop.model.domain.entity.view.UserRolesView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UserRolesViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UserRolesView use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UserRolesView";
	private String tableName = "user_roles_view";

	public UserRolesView create(UserRolesView userrolesview) {
		em.persist(userrolesview);
		return userrolesview;
	}

	public UserRolesView update(UserRolesView userrolesview) {
		return em.merge(userrolesview);
	}
	
	public void popularityByKey(Object key) {
		UserRolesView userrolesview = findById(key, false);
		
		if(userrolesview != null){
			if (SObject.class.isAssignableFrom(UserRolesView.class)) {
				if (userrolesview.getPopularity() == null) {
					userrolesview.setPopularity(-1);
				}
				userrolesview.setPopularity(userrolesview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRolesView.class)
							.setParameter("popularity", userrolesview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UserRolesView item) {
		UserRolesView userrolesview = null;
		if(item != null){
			userrolesview = findById(item.getId(), false);
		}
		
		if(userrolesview != null){
			if (SObject.class.isAssignableFrom(UserRolesView.class)) {
				if (userrolesview.getPopularity() == null) {
					userrolesview.setPopularity(-1);
				}
				userrolesview.setPopularity(userrolesview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRolesView.class)
							.setParameter("popularity", userrolesview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UserRolesView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UserRolesView> namedFilter(ScrollableSettings settings) {
		List<UserRolesView> userrolesviews = new ArrayList<UserRolesView>();
		
		try {
			userrolesviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UserRolesView.class), settings,
				UserRolesView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return userrolesviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserRolesView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UserRolesView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UserRolesView(), settings.getFilter(), UserRolesView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UserRolesView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UserRolesView.class)), UserRolesView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UserRolesView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRolesView> findByExample(UserRolesView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UserRolesView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UserRolesView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRolesView> findByExample2(UserRolesView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UserRolesView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRolesView> findAll(ScrollableSettings settings) {
		List<UserRolesView> userrolesviews = DaoUtil.sasQuery(selectClause, settings,
				UserRolesView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRolesView item : userrolesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRolesView item : userrolesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userrolesviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserRolesView> findAllScrollable(ScrollableSettings settings) {
		List<UserRolesView> userrolesviews = DaoUtil
				.sasQuery(selectClause, settings, UserRolesView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRolesView item : userrolesviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRolesView item : userrolesviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userrolesviews;
	}

	public UserRolesView findById(Object key, Boolean initAll) {
		UserRolesView item = em.find(UserRolesView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UserRolesView findById(ScrollableSettings settings) {
		UserRolesView item = em.find(UserRolesView.class, settings.getId());

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
			em.remove(em.getReference(UserRolesView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
