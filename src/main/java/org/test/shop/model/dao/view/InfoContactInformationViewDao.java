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
import org.test.shop.model.domain.entity.view.InfoContactInformationView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class InfoContactInformationViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT inf0 FROM InfoContactInformationView inf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "inf0";
	private String className = "InfoContactInformationView";
	private String tableName = "info_contact_information_view";

	public InfoContactInformationView create(InfoContactInformationView infocontactinformationview) {
		em.persist(infocontactinformationview);
		return infocontactinformationview;
	}

	public InfoContactInformationView update(InfoContactInformationView infocontactinformationview) {
		return em.merge(infocontactinformationview);
	}
	
	public void popularityByKey(Object key) {
		InfoContactInformationView infocontactinformationview = findById(key, false);
		
		if(infocontactinformationview != null){
			if (SObject.class.isAssignableFrom(InfoContactInformationView.class)) {
				if (infocontactinformationview.getPopularity() == null) {
					infocontactinformationview.setPopularity(-1);
				}
				infocontactinformationview.setPopularity(infocontactinformationview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), InfoContactInformationView.class)
							.setParameter("popularity", infocontactinformationview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(InfoContactInformationView item) {
		InfoContactInformationView infocontactinformationview = null;
		if(item != null){
			infocontactinformationview = findById(item.getId(), false);
		}
		
		if(infocontactinformationview != null){
			if (SObject.class.isAssignableFrom(InfoContactInformationView.class)) {
				if (infocontactinformationview.getPopularity() == null) {
					infocontactinformationview.setPopularity(-1);
				}
				infocontactinformationview.setPopularity(infocontactinformationview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), InfoContactInformationView.class)
							.setParameter("popularity", infocontactinformationview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, InfoContactInformationView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<InfoContactInformationView> namedFilter(ScrollableSettings settings) {
		List<InfoContactInformationView> infocontactinformationviews = new ArrayList<InfoContactInformationView>();
		
		try {
			infocontactinformationviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), InfoContactInformationView.class), settings,
				InfoContactInformationView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return infocontactinformationviews;
	}

	@SuppressWarnings("unchecked")
	public List<InfoContactInformationView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<InfoContactInformationView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new InfoContactInformationView(), settings.getFilter(), InfoContactInformationView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, InfoContactInformationView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(InfoContactInformationView.class)), InfoContactInformationView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, InfoContactInformationView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<InfoContactInformationView> findByExample(InfoContactInformationView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				InfoContactInformationView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, InfoContactInformationView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<InfoContactInformationView> findByExample2(InfoContactInformationView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, InfoContactInformationView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<InfoContactInformationView> findAll(ScrollableSettings settings) {
		List<InfoContactInformationView> infocontactinformationviews = DaoUtil.sasQuery(selectClause, settings,
				InfoContactInformationView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (InfoContactInformationView item : infocontactinformationviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (InfoContactInformationView item : infocontactinformationviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return infocontactinformationviews;
	}

	@SuppressWarnings("unchecked")
	public List<InfoContactInformationView> findAllScrollable(ScrollableSettings settings) {
		List<InfoContactInformationView> infocontactinformationviews = DaoUtil
				.sasQuery(selectClause, settings, InfoContactInformationView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (InfoContactInformationView item : infocontactinformationviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (InfoContactInformationView item : infocontactinformationviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return infocontactinformationviews;
	}

	public InfoContactInformationView findById(Object key, Boolean initAll) {
		InfoContactInformationView item = em.find(InfoContactInformationView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public InfoContactInformationView findById(ScrollableSettings settings) {
		InfoContactInformationView item = em.find(InfoContactInformationView.class, settings.getId());

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
			em.remove(em.getReference(InfoContactInformationView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
