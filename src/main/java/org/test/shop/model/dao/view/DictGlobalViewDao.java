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
import org.test.shop.model.domain.entity.view.DictGlobalView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class DictGlobalViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT dic0 FROM DictGlobalView dic0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "dic0";
	private String className = "DictGlobalView";
	private String tableName = "dict_global_view";

	public DictGlobalView create(DictGlobalView dictglobalview) {
		em.persist(dictglobalview);
		return dictglobalview;
	}

	public DictGlobalView update(DictGlobalView dictglobalview) {
		return em.merge(dictglobalview);
	}
	
	public void popularityByKey(Object key) {
		DictGlobalView dictglobalview = findById(key, false);
		
		if(dictglobalview != null){
			if (SObject.class.isAssignableFrom(DictGlobalView.class)) {
				if (dictglobalview.getPopularity() == null) {
					dictglobalview.setPopularity(-1);
				}
				dictglobalview.setPopularity(dictglobalview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DictGlobalView.class)
							.setParameter("popularity", dictglobalview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(DictGlobalView item) {
		DictGlobalView dictglobalview = null;
		if(item != null){
			dictglobalview = findById(item.getId(), false);
		}
		
		if(dictglobalview != null){
			if (SObject.class.isAssignableFrom(DictGlobalView.class)) {
				if (dictglobalview.getPopularity() == null) {
					dictglobalview.setPopularity(-1);
				}
				dictglobalview.setPopularity(dictglobalview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DictGlobalView.class)
							.setParameter("popularity", dictglobalview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, DictGlobalView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<DictGlobalView> namedFilter(ScrollableSettings settings) {
		List<DictGlobalView> dictglobalviews = new ArrayList<DictGlobalView>();
		
		try {
			dictglobalviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), DictGlobalView.class), settings,
				DictGlobalView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return dictglobalviews;
	}

	@SuppressWarnings("unchecked")
	public List<DictGlobalView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<DictGlobalView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new DictGlobalView(), settings.getFilter(), DictGlobalView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, DictGlobalView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(DictGlobalView.class)), DictGlobalView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, DictGlobalView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DictGlobalView> findByExample(DictGlobalView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				DictGlobalView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, DictGlobalView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DictGlobalView> findByExample2(DictGlobalView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, DictGlobalView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DictGlobalView> findAll(ScrollableSettings settings) {
		List<DictGlobalView> dictglobalviews = DaoUtil.sasQuery(selectClause, settings,
				DictGlobalView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (DictGlobalView item : dictglobalviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DictGlobalView item : dictglobalviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return dictglobalviews;
	}

	@SuppressWarnings("unchecked")
	public List<DictGlobalView> findAllScrollable(ScrollableSettings settings) {
		List<DictGlobalView> dictglobalviews = DaoUtil
				.sasQuery(selectClause, settings, DictGlobalView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (DictGlobalView item : dictglobalviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DictGlobalView item : dictglobalviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return dictglobalviews;
	}

	public DictGlobalView findById(Object key, Boolean initAll) {
		DictGlobalView item = em.find(DictGlobalView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public DictGlobalView findById(ScrollableSettings settings) {
		DictGlobalView item = em.find(DictGlobalView.class, settings.getId());

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
			em.remove(em.getReference(DictGlobalView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
