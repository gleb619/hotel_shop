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
import org.test.shop.model.domain.entity.RelMailNewsletterGroup;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelMailNewsletterGroupDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelMailNewsletterGroup rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelMailNewsletterGroup";
	private String tableName = "rel_mail_newsletter_group";

	public RelMailNewsletterGroup create(RelMailNewsletterGroup relmailnewslettergroup) {
		em.persist(relmailnewslettergroup);
		return relmailnewslettergroup;
	}

	public RelMailNewsletterGroup update(RelMailNewsletterGroup relmailnewslettergroup) {
		return em.merge(relmailnewslettergroup);
	}
	
	public void popularityByKey(Object key) {
		RelMailNewsletterGroup relmailnewslettergroup = findById(key, false);
		
		if(relmailnewslettergroup != null){
			if (SObject.class.isAssignableFrom(RelMailNewsletterGroup.class)) {
				if (relmailnewslettergroup.getPopularity() == null) {
					relmailnewslettergroup.setPopularity(-1);
				}
				relmailnewslettergroup.setPopularity(relmailnewslettergroup.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelMailNewsletterGroup.class)
							.setParameter("popularity", relmailnewslettergroup.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelMailNewsletterGroup item) {
		RelMailNewsletterGroup relmailnewslettergroup = null;
		if(item != null){
			relmailnewslettergroup = findById(item.getId(), false);
		}
		
		if(relmailnewslettergroup != null){
			if (SObject.class.isAssignableFrom(RelMailNewsletterGroup.class)) {
				if (relmailnewslettergroup.getPopularity() == null) {
					relmailnewslettergroup.setPopularity(-1);
				}
				relmailnewslettergroup.setPopularity(relmailnewslettergroup.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelMailNewsletterGroup.class)
							.setParameter("popularity", relmailnewslettergroup.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelMailNewsletterGroup.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelMailNewsletterGroup> namedFilter(ScrollableSettings settings) {
		List<RelMailNewsletterGroup> relmailnewslettergroups = new ArrayList<RelMailNewsletterGroup>();
		
		try {
			relmailnewslettergroups = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelMailNewsletterGroup.class), settings,
				RelMailNewsletterGroup.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relmailnewslettergroups;
	}

	@SuppressWarnings("unchecked")
	public List<RelMailNewsletterGroup> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelMailNewsletterGroup>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelMailNewsletterGroup(), settings.getFilter(), RelMailNewsletterGroup.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelMailNewsletterGroup.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelMailNewsletterGroup.class)), RelMailNewsletterGroup.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelMailNewsletterGroup.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelMailNewsletterGroup> findByExample(RelMailNewsletterGroup example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelMailNewsletterGroup.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelMailNewsletterGroup.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelMailNewsletterGroup> findByExample2(RelMailNewsletterGroup example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelMailNewsletterGroup.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelMailNewsletterGroup> findAll(ScrollableSettings settings) {
		List<RelMailNewsletterGroup> relmailnewslettergroups = DaoUtil.sasQuery(selectClause, settings,
				RelMailNewsletterGroup.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelMailNewsletterGroup item : relmailnewslettergroups) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelMailNewsletterGroup item : relmailnewslettergroups) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relmailnewslettergroups;
	}

	@SuppressWarnings("unchecked")
	public List<RelMailNewsletterGroup> findAllScrollable(ScrollableSettings settings) {
		List<RelMailNewsletterGroup> relmailnewslettergroups = DaoUtil
				.sasQuery(selectClause, settings, RelMailNewsletterGroup.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelMailNewsletterGroup item : relmailnewslettergroups) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelMailNewsletterGroup item : relmailnewslettergroups) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relmailnewslettergroups;
	}

	public RelMailNewsletterGroup findById(Object key, Boolean initAll) {
		RelMailNewsletterGroup item = em.find(RelMailNewsletterGroup.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelMailNewsletterGroup findById(ScrollableSettings settings) {
		RelMailNewsletterGroup item = em.find(RelMailNewsletterGroup.class, settings.getId());

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
			em.remove(em.getReference(RelMailNewsletterGroup.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
