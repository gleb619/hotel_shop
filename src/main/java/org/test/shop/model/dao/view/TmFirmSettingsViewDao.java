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
import org.test.shop.model.domain.entity.view.TmFirmSettingsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmFirmSettingsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmf0 FROM TmFirmSettingsView tmf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmf0";
	private String className = "TmFirmSettingsView";
	private String tableName = "tm_firm_settings_view";

	public TmFirmSettingsView create(TmFirmSettingsView tmfirmsettingsview) {
		em.persist(tmfirmsettingsview);
		return tmfirmsettingsview;
	}

	public TmFirmSettingsView update(TmFirmSettingsView tmfirmsettingsview) {
		return em.merge(tmfirmsettingsview);
	}
	
	public void popularityByKey(Object key) {
		TmFirmSettingsView tmfirmsettingsview = findById(key, false);
		
		if(tmfirmsettingsview != null){
			if (SObject.class.isAssignableFrom(TmFirmSettingsView.class)) {
				if (tmfirmsettingsview.getPopularity() == null) {
					tmfirmsettingsview.setPopularity(-1);
				}
				tmfirmsettingsview.setPopularity(tmfirmsettingsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmSettingsView.class)
							.setParameter("popularity", tmfirmsettingsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmFirmSettingsView item) {
		TmFirmSettingsView tmfirmsettingsview = null;
		if(item != null){
			tmfirmsettingsview = findById(item.getId(), false);
		}
		
		if(tmfirmsettingsview != null){
			if (SObject.class.isAssignableFrom(TmFirmSettingsView.class)) {
				if (tmfirmsettingsview.getPopularity() == null) {
					tmfirmsettingsview.setPopularity(-1);
				}
				tmfirmsettingsview.setPopularity(tmfirmsettingsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmSettingsView.class)
							.setParameter("popularity", tmfirmsettingsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmFirmSettingsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmFirmSettingsView> namedFilter(ScrollableSettings settings) {
		List<TmFirmSettingsView> tmfirmsettingsviews = new ArrayList<TmFirmSettingsView>();
		
		try {
			tmfirmsettingsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmFirmSettingsView.class), settings,
				TmFirmSettingsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmfirmsettingsviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettingsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmFirmSettingsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmFirmSettingsView(), settings.getFilter(), TmFirmSettingsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmFirmSettingsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmFirmSettingsView.class)), TmFirmSettingsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmFirmSettingsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettingsView> findByExample(TmFirmSettingsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmFirmSettingsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmFirmSettingsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmFirmSettingsView> findByExample2(TmFirmSettingsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmFirmSettingsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettingsView> findAll(ScrollableSettings settings) {
		List<TmFirmSettingsView> tmfirmsettingsviews = DaoUtil.sasQuery(selectClause, settings,
				TmFirmSettingsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmSettingsView item : tmfirmsettingsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmSettingsView item : tmfirmsettingsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsettingsviews;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettingsView> findAllScrollable(ScrollableSettings settings) {
		List<TmFirmSettingsView> tmfirmsettingsviews = DaoUtil
				.sasQuery(selectClause, settings, TmFirmSettingsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmSettingsView item : tmfirmsettingsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmSettingsView item : tmfirmsettingsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsettingsviews;
	}

	public TmFirmSettingsView findById(Object key, Boolean initAll) {
		TmFirmSettingsView item = em.find(TmFirmSettingsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmFirmSettingsView findById(ScrollableSettings settings) {
		TmFirmSettingsView item = em.find(TmFirmSettingsView.class, settings.getId());

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
			em.remove(em.getReference(TmFirmSettingsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
