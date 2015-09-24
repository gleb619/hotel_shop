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
import org.test.shop.model.domain.entity.view.RelUserDetailsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelUserDetailsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelUserDetailsView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelUserDetailsView";
	private String tableName = "rel_user_details_view";

	public RelUserDetailsView create(RelUserDetailsView reluserdetailsview) {
		em.persist(reluserdetailsview);
		return reluserdetailsview;
	}

	public RelUserDetailsView update(RelUserDetailsView reluserdetailsview) {
		return em.merge(reluserdetailsview);
	}
	
	public void popularityByKey(Object key) {
		RelUserDetailsView reluserdetailsview = findById(key, false);
		
		if(reluserdetailsview != null){
			if (SObject.class.isAssignableFrom(RelUserDetailsView.class)) {
				if (reluserdetailsview.getPopularity() == null) {
					reluserdetailsview.setPopularity(-1);
				}
				reluserdetailsview.setPopularity(reluserdetailsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelUserDetailsView.class)
							.setParameter("popularity", reluserdetailsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelUserDetailsView item) {
		RelUserDetailsView reluserdetailsview = null;
		if(item != null){
			reluserdetailsview = findById(item.getId(), false);
		}
		
		if(reluserdetailsview != null){
			if (SObject.class.isAssignableFrom(RelUserDetailsView.class)) {
				if (reluserdetailsview.getPopularity() == null) {
					reluserdetailsview.setPopularity(-1);
				}
				reluserdetailsview.setPopularity(reluserdetailsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelUserDetailsView.class)
							.setParameter("popularity", reluserdetailsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelUserDetailsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelUserDetailsView> namedFilter(ScrollableSettings settings) {
		List<RelUserDetailsView> reluserdetailsviews = new ArrayList<RelUserDetailsView>();
		
		try {
			reluserdetailsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelUserDetailsView.class), settings,
				RelUserDetailsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reluserdetailsviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetailsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelUserDetailsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelUserDetailsView(), settings.getFilter(), RelUserDetailsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelUserDetailsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelUserDetailsView.class)), RelUserDetailsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelUserDetailsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetailsView> findByExample(RelUserDetailsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelUserDetailsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelUserDetailsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelUserDetailsView> findByExample2(RelUserDetailsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelUserDetailsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetailsView> findAll(ScrollableSettings settings) {
		List<RelUserDetailsView> reluserdetailsviews = DaoUtil.sasQuery(selectClause, settings,
				RelUserDetailsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelUserDetailsView item : reluserdetailsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelUserDetailsView item : reluserdetailsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reluserdetailsviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetailsView> findAllScrollable(ScrollableSettings settings) {
		List<RelUserDetailsView> reluserdetailsviews = DaoUtil
				.sasQuery(selectClause, settings, RelUserDetailsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelUserDetailsView item : reluserdetailsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelUserDetailsView item : reluserdetailsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reluserdetailsviews;
	}

	public RelUserDetailsView findById(Object key, Boolean initAll) {
		RelUserDetailsView item = em.find(RelUserDetailsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelUserDetailsView findById(ScrollableSettings settings) {
		RelUserDetailsView item = em.find(RelUserDetailsView.class, settings.getId());

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
			em.remove(em.getReference(RelUserDetailsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
