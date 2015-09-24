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
import org.test.shop.model.domain.entity.view.UserRegistrationRequestView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UserRegistrationRequestViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UserRegistrationRequestView use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UserRegistrationRequestView";
	private String tableName = "user_registration_request_view";

	public UserRegistrationRequestView create(UserRegistrationRequestView userregistrationrequestview) {
		em.persist(userregistrationrequestview);
		return userregistrationrequestview;
	}

	public UserRegistrationRequestView update(UserRegistrationRequestView userregistrationrequestview) {
		return em.merge(userregistrationrequestview);
	}
	
	public void popularityByKey(Object key) {
		UserRegistrationRequestView userregistrationrequestview = findById(key, false);
		
		if(userregistrationrequestview != null){
			if (SObject.class.isAssignableFrom(UserRegistrationRequestView.class)) {
				if (userregistrationrequestview.getPopularity() == null) {
					userregistrationrequestview.setPopularity(-1);
				}
				userregistrationrequestview.setPopularity(userregistrationrequestview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRegistrationRequestView.class)
							.setParameter("popularity", userregistrationrequestview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UserRegistrationRequestView item) {
		UserRegistrationRequestView userregistrationrequestview = null;
		if(item != null){
			userregistrationrequestview = findById(item.getId(), false);
		}
		
		if(userregistrationrequestview != null){
			if (SObject.class.isAssignableFrom(UserRegistrationRequestView.class)) {
				if (userregistrationrequestview.getPopularity() == null) {
					userregistrationrequestview.setPopularity(-1);
				}
				userregistrationrequestview.setPopularity(userregistrationrequestview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserRegistrationRequestView.class)
							.setParameter("popularity", userregistrationrequestview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UserRegistrationRequestView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UserRegistrationRequestView> namedFilter(ScrollableSettings settings) {
		List<UserRegistrationRequestView> userregistrationrequestviews = new ArrayList<UserRegistrationRequestView>();
		
		try {
			userregistrationrequestviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UserRegistrationRequestView.class), settings,
				UserRegistrationRequestView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return userregistrationrequestviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserRegistrationRequestView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UserRegistrationRequestView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UserRegistrationRequestView(), settings.getFilter(), UserRegistrationRequestView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UserRegistrationRequestView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UserRegistrationRequestView.class)), UserRegistrationRequestView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UserRegistrationRequestView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRegistrationRequestView> findByExample(UserRegistrationRequestView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UserRegistrationRequestView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UserRegistrationRequestView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRegistrationRequestView> findByExample2(UserRegistrationRequestView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UserRegistrationRequestView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserRegistrationRequestView> findAll(ScrollableSettings settings) {
		List<UserRegistrationRequestView> userregistrationrequestviews = DaoUtil.sasQuery(selectClause, settings,
				UserRegistrationRequestView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRegistrationRequestView item : userregistrationrequestviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRegistrationRequestView item : userregistrationrequestviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userregistrationrequestviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserRegistrationRequestView> findAllScrollable(ScrollableSettings settings) {
		List<UserRegistrationRequestView> userregistrationrequestviews = DaoUtil
				.sasQuery(selectClause, settings, UserRegistrationRequestView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UserRegistrationRequestView item : userregistrationrequestviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserRegistrationRequestView item : userregistrationrequestviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userregistrationrequestviews;
	}

	public UserRegistrationRequestView findById(Object key, Boolean initAll) {
		UserRegistrationRequestView item = em.find(UserRegistrationRequestView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UserRegistrationRequestView findById(ScrollableSettings settings) {
		UserRegistrationRequestView item = em.find(UserRegistrationRequestView.class, settings.getId());

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
			em.remove(em.getReference(UserRegistrationRequestView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
