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
import org.test.shop.model.domain.entity.RelUserDetails;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelUserDetailsDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelUserDetails rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelUserDetails";
	private String tableName = "rel_user_details";

	public RelUserDetails create(RelUserDetails reluserdetails) {
		em.persist(reluserdetails);
		return reluserdetails;
	}

	public RelUserDetails update(RelUserDetails reluserdetails) {
		return em.merge(reluserdetails);
	}
	
	public void popularityByKey(Object key) {
		RelUserDetails reluserdetails = findById(key, false);
		
		if(reluserdetails != null){
			if (SObject.class.isAssignableFrom(RelUserDetails.class)) {
				if (reluserdetails.getPopularity() == null) {
					reluserdetails.setPopularity(-1);
				}
				reluserdetails.setPopularity(reluserdetails.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelUserDetails.class)
							.setParameter("popularity", reluserdetails.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelUserDetails item) {
		RelUserDetails reluserdetails = null;
		if(item != null){
			reluserdetails = findById(item.getId(), false);
		}
		
		if(reluserdetails != null){
			if (SObject.class.isAssignableFrom(RelUserDetails.class)) {
				if (reluserdetails.getPopularity() == null) {
					reluserdetails.setPopularity(-1);
				}
				reluserdetails.setPopularity(reluserdetails.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelUserDetails.class)
							.setParameter("popularity", reluserdetails.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelUserDetails.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelUserDetails> namedFilter(ScrollableSettings settings) {
		List<RelUserDetails> reluserdetailss = new ArrayList<RelUserDetails>();
		
		try {
			reluserdetailss = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelUserDetails.class), settings,
				RelUserDetails.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return reluserdetailss;
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetails> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelUserDetails>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelUserDetails(), settings.getFilter(), RelUserDetails.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelUserDetails.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelUserDetails.class)), RelUserDetails.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelUserDetails.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetails> findByExample(RelUserDetails example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelUserDetails.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelUserDetails.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelUserDetails> findByExample2(RelUserDetails example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelUserDetails.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetails> findAll(ScrollableSettings settings) {
		List<RelUserDetails> reluserdetailss = DaoUtil.sasQuery(selectClause, settings,
				RelUserDetails.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelUserDetails item : reluserdetailss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelUserDetails item : reluserdetailss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reluserdetailss;
	}

	@SuppressWarnings("unchecked")
	public List<RelUserDetails> findAllScrollable(ScrollableSettings settings) {
		List<RelUserDetails> reluserdetailss = DaoUtil
				.sasQuery(selectClause, settings, RelUserDetails.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelUserDetails item : reluserdetailss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelUserDetails item : reluserdetailss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return reluserdetailss;
	}

	public RelUserDetails findById(Object key, Boolean initAll) {
		RelUserDetails item = em.find(RelUserDetails.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelUserDetails findById(ScrollableSettings settings) {
		RelUserDetails item = em.find(RelUserDetails.class, settings.getId());

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
			em.remove(em.getReference(RelUserDetails.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
