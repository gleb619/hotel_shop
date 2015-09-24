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
import org.test.shop.model.domain.entity.TmMailNewsletter;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmMailNewsletterDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmm0 FROM TmMailNewsletter tmm0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmm0";
	private String className = "TmMailNewsletter";
	private String tableName = "tm_mail_newsletter";

	public TmMailNewsletter create(TmMailNewsletter tmmailnewsletter) {
		em.persist(tmmailnewsletter);
		return tmmailnewsletter;
	}

	public TmMailNewsletter update(TmMailNewsletter tmmailnewsletter) {
		return em.merge(tmmailnewsletter);
	}
	
	public void popularityByKey(Object key) {
		TmMailNewsletter tmmailnewsletter = findById(key, false);
		
		if(tmmailnewsletter != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletter.class)) {
				if (tmmailnewsletter.getPopularity() == null) {
					tmmailnewsletter.setPopularity(-1);
				}
				tmmailnewsletter.setPopularity(tmmailnewsletter.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletter.class)
							.setParameter("popularity", tmmailnewsletter.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmMailNewsletter item) {
		TmMailNewsletter tmmailnewsletter = null;
		if(item != null){
			tmmailnewsletter = findById(item.getId(), false);
		}
		
		if(tmmailnewsletter != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletter.class)) {
				if (tmmailnewsletter.getPopularity() == null) {
					tmmailnewsletter.setPopularity(-1);
				}
				tmmailnewsletter.setPopularity(tmmailnewsletter.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletter.class)
							.setParameter("popularity", tmmailnewsletter.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmMailNewsletter.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmMailNewsletter> namedFilter(ScrollableSettings settings) {
		List<TmMailNewsletter> tmmailnewsletters = new ArrayList<TmMailNewsletter>();
		
		try {
			tmmailnewsletters = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmMailNewsletter.class), settings,
				TmMailNewsletter.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmmailnewsletters;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletter> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmMailNewsletter>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmMailNewsletter(), settings.getFilter(), TmMailNewsletter.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmMailNewsletter.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmMailNewsletter.class)), TmMailNewsletter.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmMailNewsletter.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletter> findByExample(TmMailNewsletter example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmMailNewsletter.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmMailNewsletter.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmMailNewsletter> findByExample2(TmMailNewsletter example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmMailNewsletter.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletter> findAll(ScrollableSettings settings) {
		List<TmMailNewsletter> tmmailnewsletters = DaoUtil.sasQuery(selectClause, settings,
				TmMailNewsletter.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletter item : tmmailnewsletters) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletter item : tmmailnewsletters) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewsletters;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletter> findAllScrollable(ScrollableSettings settings) {
		List<TmMailNewsletter> tmmailnewsletters = DaoUtil
				.sasQuery(selectClause, settings, TmMailNewsletter.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletter item : tmmailnewsletters) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletter item : tmmailnewsletters) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewsletters;
	}

	public TmMailNewsletter findById(Object key, Boolean initAll) {
		TmMailNewsletter item = em.find(TmMailNewsletter.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmMailNewsletter findById(ScrollableSettings settings) {
		TmMailNewsletter item = em.find(TmMailNewsletter.class, settings.getId());

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
			em.remove(em.getReference(TmMailNewsletter.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
