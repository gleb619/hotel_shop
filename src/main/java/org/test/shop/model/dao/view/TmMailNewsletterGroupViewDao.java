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
import org.test.shop.model.domain.entity.view.TmMailNewsletterGroupView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmMailNewsletterGroupViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmm0 FROM TmMailNewsletterGroupView tmm0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmm0";
	private String className = "TmMailNewsletterGroupView";
	private String tableName = "tm_mail_newsletter_group_view";

	public TmMailNewsletterGroupView create(TmMailNewsletterGroupView tmmailnewslettergroupview) {
		em.persist(tmmailnewslettergroupview);
		return tmmailnewslettergroupview;
	}

	public TmMailNewsletterGroupView update(TmMailNewsletterGroupView tmmailnewslettergroupview) {
		return em.merge(tmmailnewslettergroupview);
	}
	
	public void popularityByKey(Object key) {
		TmMailNewsletterGroupView tmmailnewslettergroupview = findById(key, false);
		
		if(tmmailnewslettergroupview != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterGroupView.class)) {
				if (tmmailnewslettergroupview.getPopularity() == null) {
					tmmailnewslettergroupview.setPopularity(-1);
				}
				tmmailnewslettergroupview.setPopularity(tmmailnewslettergroupview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterGroupView.class)
							.setParameter("popularity", tmmailnewslettergroupview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmMailNewsletterGroupView item) {
		TmMailNewsletterGroupView tmmailnewslettergroupview = null;
		if(item != null){
			tmmailnewslettergroupview = findById(item.getId(), false);
		}
		
		if(tmmailnewslettergroupview != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterGroupView.class)) {
				if (tmmailnewslettergroupview.getPopularity() == null) {
					tmmailnewslettergroupview.setPopularity(-1);
				}
				tmmailnewslettergroupview.setPopularity(tmmailnewslettergroupview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterGroupView.class)
							.setParameter("popularity", tmmailnewslettergroupview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmMailNewsletterGroupView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmMailNewsletterGroupView> namedFilter(ScrollableSettings settings) {
		List<TmMailNewsletterGroupView> tmmailnewslettergroupviews = new ArrayList<TmMailNewsletterGroupView>();
		
		try {
			tmmailnewslettergroupviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmMailNewsletterGroupView.class), settings,
				TmMailNewsletterGroupView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmmailnewslettergroupviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroupView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmMailNewsletterGroupView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmMailNewsletterGroupView(), settings.getFilter(), TmMailNewsletterGroupView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmMailNewsletterGroupView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmMailNewsletterGroupView.class)), TmMailNewsletterGroupView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmMailNewsletterGroupView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroupView> findByExample(TmMailNewsletterGroupView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmMailNewsletterGroupView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmMailNewsletterGroupView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroupView> findByExample2(TmMailNewsletterGroupView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmMailNewsletterGroupView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroupView> findAll(ScrollableSettings settings) {
		List<TmMailNewsletterGroupView> tmmailnewslettergroupviews = DaoUtil.sasQuery(selectClause, settings,
				TmMailNewsletterGroupView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterGroupView item : tmmailnewslettergroupviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterGroupView item : tmmailnewslettergroupviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewslettergroupviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroupView> findAllScrollable(ScrollableSettings settings) {
		List<TmMailNewsletterGroupView> tmmailnewslettergroupviews = DaoUtil
				.sasQuery(selectClause, settings, TmMailNewsletterGroupView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterGroupView item : tmmailnewslettergroupviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterGroupView item : tmmailnewslettergroupviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewslettergroupviews;
	}

	public TmMailNewsletterGroupView findById(Object key, Boolean initAll) {
		TmMailNewsletterGroupView item = em.find(TmMailNewsletterGroupView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmMailNewsletterGroupView findById(ScrollableSettings settings) {
		TmMailNewsletterGroupView item = em.find(TmMailNewsletterGroupView.class, settings.getId());

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
			em.remove(em.getReference(TmMailNewsletterGroupView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
