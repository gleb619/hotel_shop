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
import org.test.shop.model.domain.entity.view.UserDetailView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UserDetailViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UserDetailView use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UserDetailView";
	private String tableName = "user_detail_view";

	public UserDetailView create(UserDetailView userdetailview) {
		em.persist(userdetailview);
		return userdetailview;
	}

	public UserDetailView update(UserDetailView userdetailview) {
		return em.merge(userdetailview);
	}
	
	public void popularityByKey(Object key) {
		UserDetailView userdetailview = findById(key, false);
		
		if(userdetailview != null){
			if (SObject.class.isAssignableFrom(UserDetailView.class)) {
				if (userdetailview.getPopularity() == null) {
					userdetailview.setPopularity(-1);
				}
				userdetailview.setPopularity(userdetailview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserDetailView.class)
							.setParameter("popularity", userdetailview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UserDetailView item) {
		UserDetailView userdetailview = null;
		if(item != null){
			userdetailview = findById(item.getId(), false);
		}
		
		if(userdetailview != null){
			if (SObject.class.isAssignableFrom(UserDetailView.class)) {
				if (userdetailview.getPopularity() == null) {
					userdetailview.setPopularity(-1);
				}
				userdetailview.setPopularity(userdetailview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UserDetailView.class)
							.setParameter("popularity", userdetailview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UserDetailView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UserDetailView> namedFilter(ScrollableSettings settings) {
		List<UserDetailView> userdetailviews = new ArrayList<UserDetailView>();
		
		try {
			userdetailviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UserDetailView.class), settings,
				UserDetailView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return userdetailviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UserDetailView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UserDetailView(), settings.getFilter(), UserDetailView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UserDetailView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UserDetailView.class)), UserDetailView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UserDetailView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailView> findByExample(UserDetailView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UserDetailView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UserDetailView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDetailView> findByExample2(UserDetailView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UserDetailView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailView> findAll(ScrollableSettings settings) {
		List<UserDetailView> userdetailviews = DaoUtil.sasQuery(selectClause, settings,
				UserDetailView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UserDetailView item : userdetailviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserDetailView item : userdetailviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userdetailviews;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailView> findAllScrollable(ScrollableSettings settings) {
		List<UserDetailView> userdetailviews = DaoUtil
				.sasQuery(selectClause, settings, UserDetailView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UserDetailView item : userdetailviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UserDetailView item : userdetailviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return userdetailviews;
	}

	public UserDetailView findById(Object key, Boolean initAll) {
		UserDetailView item = em.find(UserDetailView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UserDetailView findById(ScrollableSettings settings) {
		UserDetailView item = em.find(UserDetailView.class, settings.getId());

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
			em.remove(em.getReference(UserDetailView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
