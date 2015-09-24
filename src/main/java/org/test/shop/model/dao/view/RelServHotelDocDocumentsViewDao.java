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
import org.test.shop.model.domain.entity.view.RelServHotelDocDocumentsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServHotelDocDocumentsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServHotelDocDocumentsView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServHotelDocDocumentsView";
	private String tableName = "rel_serv_hotel_doc_documents_view";

	public RelServHotelDocDocumentsView create(RelServHotelDocDocumentsView relservhoteldocdocumentsview) {
		em.persist(relservhoteldocdocumentsview);
		return relservhoteldocdocumentsview;
	}

	public RelServHotelDocDocumentsView update(RelServHotelDocDocumentsView relservhoteldocdocumentsview) {
		return em.merge(relservhoteldocdocumentsview);
	}
	
	public void popularityByKey(Object key) {
		RelServHotelDocDocumentsView relservhoteldocdocumentsview = findById(key, false);
		
		if(relservhoteldocdocumentsview != null){
			if (SObject.class.isAssignableFrom(RelServHotelDocDocumentsView.class)) {
				if (relservhoteldocdocumentsview.getPopularity() == null) {
					relservhoteldocdocumentsview.setPopularity(-1);
				}
				relservhoteldocdocumentsview.setPopularity(relservhoteldocdocumentsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelDocDocumentsView.class)
							.setParameter("popularity", relservhoteldocdocumentsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServHotelDocDocumentsView item) {
		RelServHotelDocDocumentsView relservhoteldocdocumentsview = null;
		if(item != null){
			relservhoteldocdocumentsview = findById(item.getId(), false);
		}
		
		if(relservhoteldocdocumentsview != null){
			if (SObject.class.isAssignableFrom(RelServHotelDocDocumentsView.class)) {
				if (relservhoteldocdocumentsview.getPopularity() == null) {
					relservhoteldocdocumentsview.setPopularity(-1);
				}
				relservhoteldocdocumentsview.setPopularity(relservhoteldocdocumentsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServHotelDocDocumentsView.class)
							.setParameter("popularity", relservhoteldocdocumentsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServHotelDocDocumentsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServHotelDocDocumentsView> namedFilter(ScrollableSettings settings) {
		List<RelServHotelDocDocumentsView> relservhoteldocdocumentsviews = new ArrayList<RelServHotelDocDocumentsView>();
		
		try {
			relservhoteldocdocumentsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServHotelDocDocumentsView.class), settings,
				RelServHotelDocDocumentsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservhoteldocdocumentsviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelDocDocumentsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServHotelDocDocumentsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServHotelDocDocumentsView(), settings.getFilter(), RelServHotelDocDocumentsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServHotelDocDocumentsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServHotelDocDocumentsView.class)), RelServHotelDocDocumentsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServHotelDocDocumentsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelDocDocumentsView> findByExample(RelServHotelDocDocumentsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServHotelDocDocumentsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServHotelDocDocumentsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServHotelDocDocumentsView> findByExample2(RelServHotelDocDocumentsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServHotelDocDocumentsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelDocDocumentsView> findAll(ScrollableSettings settings) {
		List<RelServHotelDocDocumentsView> relservhoteldocdocumentsviews = DaoUtil.sasQuery(selectClause, settings,
				RelServHotelDocDocumentsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelDocDocumentsView item : relservhoteldocdocumentsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelDocDocumentsView item : relservhoteldocdocumentsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhoteldocdocumentsviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServHotelDocDocumentsView> findAllScrollable(ScrollableSettings settings) {
		List<RelServHotelDocDocumentsView> relservhoteldocdocumentsviews = DaoUtil
				.sasQuery(selectClause, settings, RelServHotelDocDocumentsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServHotelDocDocumentsView item : relservhoteldocdocumentsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServHotelDocDocumentsView item : relservhoteldocdocumentsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservhoteldocdocumentsviews;
	}

	public RelServHotelDocDocumentsView findById(Object key, Boolean initAll) {
		RelServHotelDocDocumentsView item = em.find(RelServHotelDocDocumentsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServHotelDocDocumentsView findById(ScrollableSettings settings) {
		RelServHotelDocDocumentsView item = em.find(RelServHotelDocDocumentsView.class, settings.getId());

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
			em.remove(em.getReference(RelServHotelDocDocumentsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
