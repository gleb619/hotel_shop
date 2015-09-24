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
import org.test.shop.model.domain.entity.TmMailNewsletterGroup;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmMailNewsletterGroupDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmm0 FROM TmMailNewsletterGroup tmm0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmm0";
	private String className = "TmMailNewsletterGroup";
	private String tableName = "tm_mail_newsletter_group";

	public TmMailNewsletterGroup create(TmMailNewsletterGroup tmmailnewslettergroup) {
		em.persist(tmmailnewslettergroup);
		return tmmailnewslettergroup;
	}

	public TmMailNewsletterGroup update(TmMailNewsletterGroup tmmailnewslettergroup) {
		return em.merge(tmmailnewslettergroup);
	}
	
	public void popularityByKey(Object key) {
		TmMailNewsletterGroup tmmailnewslettergroup = findById(key, false);
		
		if(tmmailnewslettergroup != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterGroup.class)) {
				if (tmmailnewslettergroup.getPopularity() == null) {
					tmmailnewslettergroup.setPopularity(-1);
				}
				tmmailnewslettergroup.setPopularity(tmmailnewslettergroup.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterGroup.class)
							.setParameter("popularity", tmmailnewslettergroup.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmMailNewsletterGroup item) {
		TmMailNewsletterGroup tmmailnewslettergroup = null;
		if(item != null){
			tmmailnewslettergroup = findById(item.getId(), false);
		}
		
		if(tmmailnewslettergroup != null){
			if (SObject.class.isAssignableFrom(TmMailNewsletterGroup.class)) {
				if (tmmailnewslettergroup.getPopularity() == null) {
					tmmailnewslettergroup.setPopularity(-1);
				}
				tmmailnewslettergroup.setPopularity(tmmailnewslettergroup.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmMailNewsletterGroup.class)
							.setParameter("popularity", tmmailnewslettergroup.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmMailNewsletterGroup.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmMailNewsletterGroup> namedFilter(ScrollableSettings settings) {
		List<TmMailNewsletterGroup> tmmailnewslettergroups = new ArrayList<TmMailNewsletterGroup>();
		
		try {
			tmmailnewslettergroups = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmMailNewsletterGroup.class), settings,
				TmMailNewsletterGroup.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmmailnewslettergroups;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroup> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmMailNewsletterGroup>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmMailNewsletterGroup(), settings.getFilter(), TmMailNewsletterGroup.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmMailNewsletterGroup.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmMailNewsletterGroup.class)), TmMailNewsletterGroup.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmMailNewsletterGroup.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroup> findByExample(TmMailNewsletterGroup example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmMailNewsletterGroup.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmMailNewsletterGroup.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroup> findByExample2(TmMailNewsletterGroup example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmMailNewsletterGroup.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroup> findAll(ScrollableSettings settings) {
		List<TmMailNewsletterGroup> tmmailnewslettergroups = DaoUtil.sasQuery(selectClause, settings,
				TmMailNewsletterGroup.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterGroup item : tmmailnewslettergroups) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterGroup item : tmmailnewslettergroups) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewslettergroups;
	}

	@SuppressWarnings("unchecked")
	public List<TmMailNewsletterGroup> findAllScrollable(ScrollableSettings settings) {
		List<TmMailNewsletterGroup> tmmailnewslettergroups = DaoUtil
				.sasQuery(selectClause, settings, TmMailNewsletterGroup.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmMailNewsletterGroup item : tmmailnewslettergroups) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmMailNewsletterGroup item : tmmailnewslettergroups) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmmailnewslettergroups;
	}

	public TmMailNewsletterGroup findById(Object key, Boolean initAll) {
		TmMailNewsletterGroup item = em.find(TmMailNewsletterGroup.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmMailNewsletterGroup findById(ScrollableSettings settings) {
		TmMailNewsletterGroup item = em.find(TmMailNewsletterGroup.class, settings.getId());

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
			em.remove(em.getReference(TmMailNewsletterGroup.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
