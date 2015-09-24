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
import org.test.shop.model.domain.entity.view.UsersView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class UsersViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT use0 FROM UsersView use0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "use0";
	private String className = "UsersView";
	private String tableName = "users_view";

	public UsersView create(UsersView usersview) {
		em.persist(usersview);
		return usersview;
	}

	public UsersView update(UsersView usersview) {
		return em.merge(usersview);
	}
	
	public void popularityByKey(Object key) {
		UsersView usersview = findById(key, false);
		
		if(usersview != null){
			if (SObject.class.isAssignableFrom(UsersView.class)) {
				if (usersview.getPopularity() == null) {
					usersview.setPopularity(-1);
				}
				usersview.setPopularity(usersview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UsersView.class)
							.setParameter("popularity", usersview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(UsersView item) {
		UsersView usersview = null;
		if(item != null){
			usersview = findById(item.getId(), false);
		}
		
		if(usersview != null){
			if (SObject.class.isAssignableFrom(UsersView.class)) {
				if (usersview.getPopularity() == null) {
					usersview.setPopularity(-1);
				}
				usersview.setPopularity(usersview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), UsersView.class)
							.setParameter("popularity", usersview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, UsersView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<UsersView> namedFilter(ScrollableSettings settings) {
		List<UsersView> usersviews = new ArrayList<UsersView>();
		
		try {
			usersviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), UsersView.class), settings,
				UsersView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return usersviews;
	}

	@SuppressWarnings("unchecked")
	public List<UsersView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<UsersView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new UsersView(), settings.getFilter(), UsersView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, UsersView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(UsersView.class)), UsersView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, UsersView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UsersView> findByExample(UsersView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				UsersView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, UsersView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UsersView> findByExample2(UsersView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, UsersView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UsersView> findAll(ScrollableSettings settings) {
		List<UsersView> usersviews = DaoUtil.sasQuery(selectClause, settings,
				UsersView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (UsersView item : usersviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UsersView item : usersviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return usersviews;
	}

	@SuppressWarnings("unchecked")
	public List<UsersView> findAllScrollable(ScrollableSettings settings) {
		List<UsersView> usersviews = DaoUtil
				.sasQuery(selectClause, settings, UsersView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (UsersView item : usersviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (UsersView item : usersviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return usersviews;
	}

	public UsersView findById(Object key, Boolean initAll) {
		UsersView item = em.find(UsersView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public UsersView findById(ScrollableSettings settings) {
		UsersView item = em.find(UsersView.class, settings.getId());

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
			em.remove(em.getReference(UsersView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
