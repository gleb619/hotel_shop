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
import org.test.shop.model.domain.entity.view.RelServTransferTmContactView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class RelServTransferTmContactViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT rel0 FROM RelServTransferTmContactView rel0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "rel0";
	private String className = "RelServTransferTmContactView";
	private String tableName = "rel_serv_transfer_tm_contact_view";

	public RelServTransferTmContactView create(RelServTransferTmContactView relservtransfertmcontactview) {
		em.persist(relservtransfertmcontactview);
		return relservtransfertmcontactview;
	}

	public RelServTransferTmContactView update(RelServTransferTmContactView relservtransfertmcontactview) {
		return em.merge(relservtransfertmcontactview);
	}
	
	public void popularityByKey(Object key) {
		RelServTransferTmContactView relservtransfertmcontactview = findById(key, false);
		
		if(relservtransfertmcontactview != null){
			if (SObject.class.isAssignableFrom(RelServTransferTmContactView.class)) {
				if (relservtransfertmcontactview.getPopularity() == null) {
					relservtransfertmcontactview.setPopularity(-1);
				}
				relservtransfertmcontactview.setPopularity(relservtransfertmcontactview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServTransferTmContactView.class)
							.setParameter("popularity", relservtransfertmcontactview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(RelServTransferTmContactView item) {
		RelServTransferTmContactView relservtransfertmcontactview = null;
		if(item != null){
			relservtransfertmcontactview = findById(item.getId(), false);
		}
		
		if(relservtransfertmcontactview != null){
			if (SObject.class.isAssignableFrom(RelServTransferTmContactView.class)) {
				if (relservtransfertmcontactview.getPopularity() == null) {
					relservtransfertmcontactview.setPopularity(-1);
				}
				relservtransfertmcontactview.setPopularity(relservtransfertmcontactview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), RelServTransferTmContactView.class)
							.setParameter("popularity", relservtransfertmcontactview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, RelServTransferTmContactView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<RelServTransferTmContactView> namedFilter(ScrollableSettings settings) {
		List<RelServTransferTmContactView> relservtransfertmcontactviews = new ArrayList<RelServTransferTmContactView>();
		
		try {
			relservtransfertmcontactviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), RelServTransferTmContactView.class), settings,
				RelServTransferTmContactView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return relservtransfertmcontactviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServTransferTmContactView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<RelServTransferTmContactView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new RelServTransferTmContactView(), settings.getFilter(), RelServTransferTmContactView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, RelServTransferTmContactView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(RelServTransferTmContactView.class)), RelServTransferTmContactView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, RelServTransferTmContactView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServTransferTmContactView> findByExample(RelServTransferTmContactView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				RelServTransferTmContactView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, RelServTransferTmContactView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelServTransferTmContactView> findByExample2(RelServTransferTmContactView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, RelServTransferTmContactView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<RelServTransferTmContactView> findAll(ScrollableSettings settings) {
		List<RelServTransferTmContactView> relservtransfertmcontactviews = DaoUtil.sasQuery(selectClause, settings,
				RelServTransferTmContactView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServTransferTmContactView item : relservtransfertmcontactviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServTransferTmContactView item : relservtransfertmcontactviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservtransfertmcontactviews;
	}

	@SuppressWarnings("unchecked")
	public List<RelServTransferTmContactView> findAllScrollable(ScrollableSettings settings) {
		List<RelServTransferTmContactView> relservtransfertmcontactviews = DaoUtil
				.sasQuery(selectClause, settings, RelServTransferTmContactView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (RelServTransferTmContactView item : relservtransfertmcontactviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (RelServTransferTmContactView item : relservtransfertmcontactviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return relservtransfertmcontactviews;
	}

	public RelServTransferTmContactView findById(Object key, Boolean initAll) {
		RelServTransferTmContactView item = em.find(RelServTransferTmContactView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public RelServTransferTmContactView findById(ScrollableSettings settings) {
		RelServTransferTmContactView item = em.find(RelServTransferTmContactView.class, settings.getId());

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
			em.remove(em.getReference(RelServTransferTmContactView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
