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
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.RelReqServHotelTmContactEasy;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelReqServHotelTmContactEasyDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelReqServHotelTmContactEasy rel0";
	private String shortName = "rel0";
	private String className = "RelReqServHotelTmContactEasy";
	private String tableName = "rel_req_serv_hotel_tm_contact_easy";

	public RelReqServHotelTmContactEasy create(RelReqServHotelTmContactEasy relreqservhoteltmcontacteasy) {
		em.persist(relreqservhoteltmcontacteasy);
		return relreqservhoteltmcontacteasy;
	}

	public RelReqServHotelTmContactEasy update(RelReqServHotelTmContactEasy relreqservhoteltmcontacteasy) {
		return em.merge(relreqservhoteltmcontacteasy);
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelReqServHotelTmContactEasy.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasy> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelReqServHotelTmContactEasy>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelReqServHotelTmContactEasy(), settings.getFilter(), RelReqServHotelTmContactEasy.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelReqServHotelTmContactEasy.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelReqServHotelTmContactEasy.class)), RelReqServHotelTmContactEasy.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelReqServHotelTmContactEasy.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasy> findByExample(RelReqServHotelTmContactEasy example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelReqServHotelTmContactEasy.class, em, delimitter);
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelReqServHotelTmContactEasy.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasy> findByExample2(RelReqServHotelTmContactEasy example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelReqServHotelTmContactEasy.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasy> findAll(ScrollableSettings settings) {
		List<RelReqServHotelTmContactEasy> relreqservhoteltmcontacteasys = DaoUtil.sasQuery(selectClause, settings,
				RelReqServHotelTmContactEasy.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelReqServHotelTmContactEasy item : relreqservhoteltmcontacteasys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelReqServHotelTmContactEasy item : relreqservhoteltmcontacteasys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relreqservhoteltmcontacteasys;
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasy> findAllScrollable(ScrollableSettings settings) {
		List<RelReqServHotelTmContactEasy> relreqservhoteltmcontacteasys = DaoUtil
				.sasQuery(selectClause, settings, RelReqServHotelTmContactEasy.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelReqServHotelTmContactEasy item : relreqservhoteltmcontacteasys) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelReqServHotelTmContactEasy item : relreqservhoteltmcontacteasys) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relreqservhoteltmcontacteasys;
	}

	public RelReqServHotelTmContactEasy findById(Object key, Boolean initAll) {
		RelReqServHotelTmContactEasy item = em.find(RelReqServHotelTmContactEasy.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelReqServHotelTmContactEasy findById(ScrollableSettings settings) {
		RelReqServHotelTmContactEasy item = em.find(RelReqServHotelTmContactEasy.class, settings.getId());

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
		}

		return item;
	}

	public Boolean delete(Object id) {
		try {
			em.remove(em.getReference(RelReqServHotelTmContactEasy.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
