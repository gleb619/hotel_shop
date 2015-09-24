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
import org.test.shop.model.domain.entity.TmFirmSettings;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class TmFirmSettingsDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT tmf0 FROM TmFirmSettings tmf0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "tmf0";
	private String className = "TmFirmSettings";
	private String tableName = "tm_firm_settings";

	public TmFirmSettings create(TmFirmSettings tmfirmsettings) {
		em.persist(tmfirmsettings);
		return tmfirmsettings;
	}

	public TmFirmSettings update(TmFirmSettings tmfirmsettings) {
		return em.merge(tmfirmsettings);
	}
	
	public void popularityByKey(Object key) {
		TmFirmSettings tmfirmsettings = findById(key, false);
		
		if(tmfirmsettings != null){
			if (SObject.class.isAssignableFrom(TmFirmSettings.class)) {
				if (tmfirmsettings.getPopularity() == null) {
					tmfirmsettings.setPopularity(-1);
				}
				tmfirmsettings.setPopularity(tmfirmsettings.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmSettings.class)
							.setParameter("popularity", tmfirmsettings.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(TmFirmSettings item) {
		TmFirmSettings tmfirmsettings = null;
		if(item != null){
			tmfirmsettings = findById(item.getId(), false);
		}
		
		if(tmfirmsettings != null){
			if (SObject.class.isAssignableFrom(TmFirmSettings.class)) {
				if (tmfirmsettings.getPopularity() == null) {
					tmfirmsettings.setPopularity(-1);
				}
				tmfirmsettings.setPopularity(tmfirmsettings.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), TmFirmSettings.class)
							.setParameter("popularity", tmfirmsettings.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, TmFirmSettings.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<TmFirmSettings> namedFilter(ScrollableSettings settings) {
		List<TmFirmSettings> tmfirmsettingss = new ArrayList<TmFirmSettings>();
		
		try {
			tmfirmsettingss = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), TmFirmSettings.class), settings,
				TmFirmSettings.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return tmfirmsettingss;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettings> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<TmFirmSettings>();
		}
	
		FindByExample findByExample = DaoUtil.search(new TmFirmSettings(), settings.getFilter(), TmFirmSettings.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, TmFirmSettings.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(TmFirmSettings.class)), TmFirmSettings.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, TmFirmSettings.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettings> findByExample(TmFirmSettings example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TmFirmSettings.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, TmFirmSettings.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TmFirmSettings> findByExample2(TmFirmSettings example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, TmFirmSettings.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettings> findAll(ScrollableSettings settings) {
		List<TmFirmSettings> tmfirmsettingss = DaoUtil.sasQuery(selectClause, settings,
				TmFirmSettings.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmSettings item : tmfirmsettingss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmSettings item : tmfirmsettingss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsettingss;
	}

	@SuppressWarnings("unchecked")
	public List<TmFirmSettings> findAllScrollable(ScrollableSettings settings) {
		List<TmFirmSettings> tmfirmsettingss = DaoUtil
				.sasQuery(selectClause, settings, TmFirmSettings.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TmFirmSettings item : tmfirmsettingss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TmFirmSettings item : tmfirmsettingss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return tmfirmsettingss;
	}

	public TmFirmSettings findById(Object key, Boolean initAll) {
		TmFirmSettings item = em.find(TmFirmSettings.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public TmFirmSettings findById(ScrollableSettings settings) {
		TmFirmSettings item = em.find(TmFirmSettings.class, settings.getId());

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
			em.remove(em.getReference(TmFirmSettings.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
