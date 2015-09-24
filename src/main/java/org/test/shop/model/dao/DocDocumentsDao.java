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
import org.test.shop.model.domain.entity.DocDocuments;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class DocDocumentsDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT doc0 FROM DocDocuments doc0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "doc0";
	private String className = "DocDocuments";
	private String tableName = "doc_documents";

	public DocDocuments create(DocDocuments docdocuments) {
		em.persist(docdocuments);
		return docdocuments;
	}

	public DocDocuments update(DocDocuments docdocuments) {
		return em.merge(docdocuments);
	}
	
	public void popularityByKey(Object key) {
		DocDocuments docdocuments = findById(key, false);
		
		if(docdocuments != null){
			if (SObject.class.isAssignableFrom(DocDocuments.class)) {
				if (docdocuments.getPopularity() == null) {
					docdocuments.setPopularity(-1);
				}
				docdocuments.setPopularity(docdocuments.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DocDocuments.class)
							.setParameter("popularity", docdocuments.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(DocDocuments item) {
		DocDocuments docdocuments = null;
		if(item != null){
			docdocuments = findById(item.getId(), false);
		}
		
		if(docdocuments != null){
			if (SObject.class.isAssignableFrom(DocDocuments.class)) {
				if (docdocuments.getPopularity() == null) {
					docdocuments.setPopularity(-1);
				}
				docdocuments.setPopularity(docdocuments.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), DocDocuments.class)
							.setParameter("popularity", docdocuments.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, DocDocuments.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<DocDocuments> namedFilter(ScrollableSettings settings) {
		List<DocDocuments> docdocumentss = new ArrayList<DocDocuments>();
		
		try {
			docdocumentss = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), DocDocuments.class), settings,
				DocDocuments.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return docdocumentss;
	}

	@SuppressWarnings("unchecked")
	public List<DocDocuments> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<DocDocuments>();
		}
	
		FindByExample findByExample = DaoUtil.search(new DocDocuments(), settings.getFilter(), DocDocuments.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, DocDocuments.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(DocDocuments.class)), DocDocuments.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, DocDocuments.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DocDocuments> findByExample(DocDocuments example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				DocDocuments.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, DocDocuments.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<DocDocuments> findByExample2(DocDocuments example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, DocDocuments.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DocDocuments> findAll(ScrollableSettings settings) {
		List<DocDocuments> docdocumentss = DaoUtil.sasQuery(selectClause, settings,
				DocDocuments.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (DocDocuments item : docdocumentss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DocDocuments item : docdocumentss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return docdocumentss;
	}

	@SuppressWarnings("unchecked")
	public List<DocDocuments> findAllScrollable(ScrollableSettings settings) {
		List<DocDocuments> docdocumentss = DaoUtil
				.sasQuery(selectClause, settings, DocDocuments.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (DocDocuments item : docdocumentss) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (DocDocuments item : docdocumentss) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return docdocumentss;
	}

	public DocDocuments findById(Object key, Boolean initAll) {
		DocDocuments item = em.find(DocDocuments.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public DocDocuments findById(ScrollableSettings settings) {
		DocDocuments item = em.find(DocDocuments.class, settings.getId());

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
			em.remove(em.getReference(DocDocuments.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
