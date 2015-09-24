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
import org.test.shop.model.domain.entity.view.TmMailNewsletterView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmMailNewsletterViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmm0 FROM TmMailNewsletterView tmm0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmm0";
	private String className = "TmMailNewsletterView";
	private String tableName = "tm_mail_newsletter_view";

	public TmMailNewsletterView create(TmMailNewsletterView tmmailnewsletterview) {
		em.persist(tmmailnewsletterview);
		return tmmailnewsletterview;
	}

	public TmMailNewsletterView update(TmMailNewsletterView tmmailnewsletterview) {
		return em.merge(tmmailnewsletterview);
	}
	
	public void popularityByKey(Object key) {
		TmMailNewsletterView tmmailnewsletterview = findById(key, false);
		
		if(tmmailnewsletterview != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterView.class)) {
				if (tmmailnewsletterview.getPopularity() == null) {
					tmmailnewsletterview.setPopularity(-1);
				}
				tmmailnewsletterview.setPopularity(tmmailnewsletterview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterView.class)
							.setParameter("popularity", tmmailnewsletterview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmMailNewsletterView item) {
		TmMailNewsletterView tmmailnewsletterview = null;
		if(item != null){
			tmmailnewsletterview = findById(item.getId(), false);
		}
		
		if(tmmailnewsletterview != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterView.class)) {
				if (tmmailnewsletterview.getPopularity() == null) {
					tmmailnewsletterview.setPopularity(-1);
				}
				tmmailnewsletterview.setPopularity(tmmailnewsletterview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterView.class)
							.setParameter("popularity", tmmailnewsletterview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmMailNewsletterView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmMailNewsletterView> namedFilter(ScrollableSettings settings) {
		List<TmMailNewsletterView> tmmailnewsletterviews = new ArrayList<TmMailNewsletterView>();
		
		try {
			tmmailnewsletterviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmMailNewsletterView.class), settings,
				TmMailNewsletterView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmmailnewsletterviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmMailNewsletterView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmMailNewsletterView(), settings.getFilter(), TmMailNewsletterView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmMailNewsletterView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmMailNewsletterView.class)), TmMailNewsletterView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmMailNewsletterView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterView> findByExample(TmMailNewsletterView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmMailNewsletterView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmMailNewsletterView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterView> findByExample2(TmMailNewsletterView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmMailNewsletterView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterView> findAll(ScrollableSettings settings) {
		List<TmMailNewsletterView> tmmailnewsletterviews = DaoUtil.sasQuery(selectClause, settings,
				TmMailNewsletterView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterView item : tmmailnewsletterviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterView item : tmmailnewsletterviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewsletterviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterView> findAllScrollable(ScrollableSettings settings) {
		List<TmMailNewsletterView> tmmailnewsletterviews = DaoUtil
				.sasQuery(selectClause, settings, TmMailNewsletterView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterView item : tmmailnewsletterviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterView item : tmmailnewsletterviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewsletterviews;
	}

	public TmMailNewsletterView findById(Object key, Boolean initAll) {
		TmMailNewsletterView item = em.find(TmMailNewsletterView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmMailNewsletterView findById(ScrollableSettings settings) {
		TmMailNewsletterView item = em.find(TmMailNewsletterView.class, settings.getId());

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
			em.remove(em.getReference(TmMailNewsletterView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
