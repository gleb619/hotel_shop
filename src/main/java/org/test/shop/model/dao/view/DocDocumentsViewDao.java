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
import org.test.shop.model.domain.entity.view.DocDocumentsView;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class DocDocumentsViewDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT doc0 FROM DocDocumentsView doc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "doc0";
	private String className = "DocDocumentsView";
	private String tableName = "doc_documents_view";

	public DocDocumentsView create(DocDocumentsView docdocumentsview) {
		em.persist(docdocumentsview);
		return docdocumentsview;
	}

	public DocDocumentsView update(DocDocumentsView docdocumentsview) {
		return em.merge(docdocumentsview);
	}
	
	public void popularityByKey(Object key) {
		DocDocumentsView docdocumentsview = findById(key, false);
		
		if(docdocumentsview != null){
			if (SObject.class.isAssignableFrom(DocDocumentsView.class)) {
				if (docdocumentsview.getPopularity() == null) {
					docdocumentsview.setPopularity(-1);
				}
				docdocumentsview.setPopularity(docdocumentsview.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DocDocumentsView.class)
							.setParameter("popularity", docdocumentsview.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(DocDocumentsView item) {
		DocDocumentsView docdocumentsview = null;
		if(item != null){
			docdocumentsview = findById(item.getId(), false);
		}
		
		if(docdocumentsview != null){
			if (SObject.class.isAssignableFrom(DocDocumentsView.class)) {
				if (docdocumentsview.getPopularity() == null) {
					docdocumentsview.setPopularity(-1);
				}
				docdocumentsview.setPopularity(docdocumentsview.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DocDocumentsView.class)
							.setParameter("popularity", docdocumentsview.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, DocDocumentsView.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<DocDocumentsView> namedFilter(ScrollableSettings settings) {
		List<DocDocumentsView> docdocumentsviews = new ArrayList<DocDocumentsView>();
		
		try {
			docdocumentsviews = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), DocDocumentsView.class), settings,
				DocDocumentsView.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return docdocumentsviews;
	}

	@SuppressWarnings("unchecked")
	public List<DocDocumentsView> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<DocDocumentsView>();
		}
	
		FindByExample findByExample = DaoUtil.search(new DocDocumentsView(), settings.getFilter(), DocDocumentsView.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, DocDocumentsView.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(DocDocumentsView.class)), DocDocumentsView.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, DocDocumentsView.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DocDocumentsView> findByExample(DocDocumentsView example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				DocDocumentsView.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, DocDocumentsView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DocDocumentsView> findByExample2(DocDocumentsView example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, DocDocumentsView.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DocDocumentsView> findAll(ScrollableSettings settings) {
		List<DocDocumentsView> docdocumentsviews = DaoUtil.sasQuery(selectClause, settings,
				DocDocumentsView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (DocDocumentsView item : docdocumentsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DocDocumentsView item : docdocumentsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return docdocumentsviews;
	}

	@SuppressWarnings("unchecked")
	public List<DocDocumentsView> findAllScrollable(ScrollableSettings settings) {
		List<DocDocumentsView> docdocumentsviews = DaoUtil
				.sasQuery(selectClause, settings, DocDocumentsView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (DocDocumentsView item : docdocumentsviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DocDocumentsView item : docdocumentsviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return docdocumentsviews;
	}

	public DocDocumentsView findById(Object key, Boolean initAll) {
		DocDocumentsView item = em.find(DocDocumentsView.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public DocDocumentsView findById(ScrollableSettings settings) {
		DocDocumentsView item = em.find(DocDocumentsView.class, settings.getId());

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
			em.remove(em.getReference(DocDocumentsView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
