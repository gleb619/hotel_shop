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
import org.test.shop.model.domain.entity.ServTransfer;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.DateCompare;
import org.test.shop.util.data.types.FindByDateExample;
import org.test.shop.util.data.types.FindByExample;
import org.test.shop.util.data.types.TotalQuery;

@Repository
public class ServTransferDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClause = "SELECT ser0 FROM ServTransfer ser0";
	private String updatePopularityClause = "UPDATE %s SET popularity = :popularity WHERE id = :id";
	private String shortName = "ser0";
	private String className = "ServTransfer";
	private String tableName = "serv_transfer";

	public ServTransfer create(ServTransfer servtransfer) {
		em.persist(servtransfer);
		return servtransfer;
	}

	public ServTransfer update(ServTransfer servtransfer) {
		return em.merge(servtransfer);
	}
	
	public void popularityByKey(Object key) {
		ServTransfer servtransfer = findById(key, false);
		
		if(servtransfer != null){
			if (SObject.class.isAssignableFrom(ServTransfer.class)) {
				if (servtransfer.getPopularity() == null) {
					servtransfer.setPopularity(-1);
				}
				servtransfer.setPopularity(servtransfer.getPopularity() + 1);
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransfer.class)
							.setParameter("popularity", servtransfer.getPopularity())
							.setParameter("id", key)
							.executeUpdate();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void popularity(ServTransfer item) {
		ServTransfer servtransfer = null;
		if(item != null){
			servtransfer = findById(item.getId(), false);
		}
		
		if(servtransfer != null){
			if (SObject.class.isAssignableFrom(ServTransfer.class)) {
				if (servtransfer.getPopularity() == null) {
					servtransfer.setPopularity(-1);
				}
				servtransfer.setPopularity(servtransfer.getPopularity() + 1);
				
				try {
					em.createNativeQuery(String.format(updatePopularityClause, tableName), ServTransfer.class)
							.setParameter("popularity", servtransfer.getPopularity())
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
		TotalQuery totalQuery = DaoUtil.total(settings, ServTransfer.class, em);
		
		return ((BigInteger) totalQuery.getQuery().getSingleResult()).intValue();
	}
	
	public List<ServTransfer> namedFilter(ScrollableSettings settings) {
		List<ServTransfer> servtransfers = new ArrayList<ServTransfer>();
		
		try {
			servtransfers = DaoUtil.sasQueryByNamedFilter(NamedFilter.Items.byName(settings.getNamedfilter(), ServTransfer.class), settings,
				ServTransfer.class, em).getResultList();
		} catch (Exception e){
			e.printStackTrace();
		}
				
		return servtransfers;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransfer> search(ScrollableSettings settings){
		if(settings.getFilter() == null || settings.getFilter().replaceAll("\\s+", "").length() == 0){
			return new ArrayList<ServTransfer>();
		}
	
		FindByExample findByExample = DaoUtil.search(new ServTransfer(), settings.getFilter(), ServTransfer.class, em);
		Query query = null;
		
		if (findByExample.getIsNativeQuery()) {
			String queryString = DaoUtil.sasQueryRaw(findByExample.getSelectClause(), settings, ServTransfer.class, em);
			query = em.createNativeQuery(queryString.replace("SELECT " + shortName, "SELECT *").replace(className, DaoUtil.readTableName(ServTransfer.class)), ServTransfer.class);
			
			if(queryString.contains(":firmid")){
				query.setParameter("firmid", settings.getSasUser().getUser().getFirmid());
			}
			else if(queryString.contains(":firm")){
				query.setParameter("firm", settings.getSasUser().getUser().getFirmid());
			}
			
		}
		else {
			query = DaoUtil.sasQuery(findByExample.getSelectClause(), settings, ServTransfer.class, em);
		}
		
		query.setParameter("filter", findByExample.getFilter());
		if(findByExample.getSelectClause().contains("filterForInteger")){
			query.setParameter("filterForInteger", findByExample.getFilterForInteger());
		}
		
		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransfer> findByExample(ServTransfer example, String delimitter, ScrollableSettings settings) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				ServTransfer.class, em, " " + delimitter + " ");
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				settings, ServTransfer.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.setMaxResults(100).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServTransfer> findByExample2(ServTransfer example, DateCompare type) {
		FindByDateExample findByExample = DaoUtil.findByExample2(example, ServTransfer.class, em, type).init();
		return findByExample.getQuery().setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ServTransfer> findAll(ScrollableSettings settings) {
		List<ServTransfer> servtransfers = DaoUtil.sasQuery(selectClause, settings,
				ServTransfer.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransfer item : servtransfers) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransfer item : servtransfers) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransfers;
	}

	@SuppressWarnings("unchecked")
	public List<ServTransfer> findAllScrollable(ScrollableSettings settings) {
		List<ServTransfer> servtransfers = DaoUtil
				.sasQuery(selectClause, settings, ServTransfer.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (ServTransfer item : servtransfers) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (ServTransfer item : servtransfers) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return servtransfers;
	}

	public ServTransfer findById(Object key, Boolean initAll) {
		ServTransfer item = em.find(ServTransfer.class, key);
		
		if(item != null){
			if (initAll) {
				item.init();
			}
		}
		
		return item;
	}

	public ServTransfer findById(ScrollableSettings settings) {
		ServTransfer item = em.find(ServTransfer.class, settings.getId());

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
			em.remove(em.getReference(ServTransfer.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
