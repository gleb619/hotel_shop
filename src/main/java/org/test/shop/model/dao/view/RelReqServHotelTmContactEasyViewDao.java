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
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.view.RelReqServHotelTmContactEasyView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelReqServHotelTmContactEasyViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelReqServHotelTmContactEasyView rel0";
	private String shortName = "rel0";
	private String className = "RelReqServHotelTmContactEasyView";
	private String tableName = "rel_req_serv_hotel_tm_contact_easy_view";

	public RelReqServHotelTmContactEasyView create(RelReqServHotelTmContactEasyView relreqservhoteltmcontacteasyview) {
		em.persist(relreqservhoteltmcontacteasyview);
		return relreqservhoteltmcontacteasyview;
	}

	public RelReqServHotelTmContactEasyView update(RelReqServHotelTmContactEasyView relreqservhoteltmcontacteasyview) {
		return em.merge(relreqservhoteltmcontacteasyview);
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelReqServHotelTmContactEasyView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasyView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelReqServHotelTmContactEasyView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelReqServHotelTmContactEasyView(), settings.getFilter(), RelReqServHotelTmContactEasyView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelReqServHotelTmContactEasyView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelReqServHotelTmContactEasyView.class)), RelReqServHotelTmContactEasyView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelReqServHotelTmContactEasyView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasyView> findByExample(RelReqServHotelTmContactEasyView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelReqServHotelTmContactEasyView.class, em, delimitter);
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelReqServHotelTmContactEasyView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasyView> findByExample2(RelReqServHotelTmContactEasyView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelReqServHotelTmContactEasyView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasyView> findAll(ScrollableSettings settings) {
		List<RelReqServHotelTmContactEasyView> relreqservhoteltmcontacteasyviews = DaoUtil.sasQuery(selectClause, settings,
				RelReqServHotelTmContactEasyView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelReqServHotelTmContactEasyView item : relreqservhoteltmcontacteasyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelReqServHotelTmContactEasyView item : relreqservhoteltmcontacteasyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relreqservhoteltmcontacteasyviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelReqServHotelTmContactEasyView> findAllScrollable(ScrollableSettings settings) {
		List<RelReqServHotelTmContactEasyView> relreqservhoteltmcontacteasyviews = DaoUtil
				.sasQuery(selectClause, settings, RelReqServHotelTmContactEasyView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelReqServHotelTmContactEasyView item : relreqservhoteltmcontacteasyviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelReqServHotelTmContactEasyView item : relreqservhoteltmcontacteasyviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relreqservhoteltmcontacteasyviews;
	}

	public RelReqServHotelTmContactEasyView findById(Object key, Boolean initAll) {
		RelReqServHotelTmContactEasyView item = em.find(RelReqServHotelTmContactEasyView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelReqServHotelTmContactEasyView findById(ScrollableSettings settings) {
		RelReqServHotelTmContactEasyView item = em.find(RelReqServHotelTmContactEasyView.class, settings.getId());

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
			em.remove(em.getReference(RelReqServHotelTmContactEasyView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
