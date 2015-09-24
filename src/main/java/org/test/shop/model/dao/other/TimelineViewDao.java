/*
 * 
 */
package org.test.shop.model.dao.other;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.controller.data.types.TimelineRequest;
import org.test.shop.model.domain.entity.other.TimelineView;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.FindByExample;

// TODO: Auto-generated Javadoc
/**
 * The Class TimelineViewDao.
 */
@Repository
public class TimelineViewDao {

	/** The em. */
	@PersistenceContext
	private EntityManager em;
//	private String selectClause = "SELECT DISTINCT tim0.hashid FROM TimelineView tim0";
	/** The select clause. */
private String selectClause = "SELECT tim0 FROM TimelineView tim0";

	/**
	 * Creates the.
	 *
	 * @param timelineview the timelineview
	 * @return the timeline view
	 */
	public TimelineView create(TimelineView timelineview) {
		em.persist(timelineview);
		return timelineview;
	}

	/**
	 * Update.
	 *
	 * @param timelineview the timelineview
	 * @return the timeline view
	 */
	public TimelineView update(TimelineView timelineview) {
		return em.merge(timelineview);
	}

	/**
	 * Find by example.
	 *
	 * @param example the example
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<TimelineView> findByExample(TimelineView example) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				TimelineView.class, em);
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				new ScrollableSettings(), TimelineView.class, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.getResultList();
	}

	/**
	 * Find all.
	 *
	 * @param settings the settings
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<TimelineView> findAll(ScrollableSettings settings) {
		List<TimelineView> timelineviews = DaoUtil.sasQuery(selectClause, settings,
				TimelineView.class, em).getResultList();

		if (settings.getList().size() > 0) {
			for (TimelineView item : timelineviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TimelineView item : timelineviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return timelineviews;
	}

	/**
	 * Find all scrollable.
	 *
	 * @param settings the settings
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<TimelineView> findAllScrollable(ScrollableSettings settings) {
		List<TimelineView> timelineviews = DaoUtil
				.sasQuery(selectClause, settings, TimelineView.class, em)
				.setFirstResult(
						(settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (TimelineView item : timelineviews) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (TimelineView item : timelineviews) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return timelineviews;
	}

	/**
	 * Find by date.
	 *
	 * @param formatedDate the formated date
	 * @param sasUser the sas user
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<TimelineView> findByDate(String formatedDate, SasUser sasUser) {
		String innerSelectClause = "SELECT distinct on (hashid) * FROM public.timeline_view tim0 " + "WHERE tim0.firmid = :firmid AND ("
				+ " CAST(tim0.createon as TEXT) LIKE '" + formatedDate + "'"
				+ " OR CAST(tim0.modifyon as TEXT) LIKE '" + formatedDate + "' )" ;
//				" AND tim0.createon IS NOT NULL AND tim0.modifyon IS NOT NULL";
		
		List<TimelineView> timelineviews = em.createNativeQuery(innerSelectClause, TimelineView.class)
											.setParameter("firmid", sasUser.getUser().getFirmid())
											.setMaxResults(50)
											.getResultList();
		
		return timelineviews;
	}
	
	/**
	 * Find by date range.
	 *
	 * @param timelineRequest the timeline request
	 * @param sasUser the sas user
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<TimelineView> findByDateRange(TimelineRequest timelineRequest, SasUser sasUser) {
//		String start = timelineRequest.getFormattedR`angeStart() + "'::timestamp";
//		String end = timelineRequest.getFormattedRangeEnd() + "'::timestamp";
		
		String start = "CAST('" + timelineRequest.getFormattedRangeStart() + "' as TIMESTAMP) ";
		String end = "CAST('" + timelineRequest.getFormattedRangeEnd() + "' as TIMESTAMP) ";
		
		String innerSelectClause = "SELECT distinct on (hashid) * FROM public.timeline_view tim0 " + "WHERE tim0.firmid = :firmid AND "
				+ "(   tim0.createon BETWEEN " + start + " AND " + end + " "
				+ " OR tim0.modifyon BETWEEN " + start + " AND " + end + " )";
//				+ " AND tim0.createon IS NOT NULL AND tim0.modifyon IS NOT NULL";
		
		List<TimelineView> timelineviews = em.createNativeQuery(innerSelectClause, TimelineView.class)
				.setParameter("firmid", sasUser.getUser().getFirmid())
//				.setParameter("start", timelineRequest.getFormattedRangeStart() + "::timestamp")
//				.setParameter("end", timelineRequest.getFormattedRangeEnd() + "::timestamp")
				.setMaxResults(50)
				.getResultList();
		
		return timelineviews;
	}
	
	/**
	 * Find by integer range.
	 *
	 * @param timelineRequest the timeline request
	 * @param sasUser the sas user
	 * @return the list
	 */
	public List<TimelineView> findByIntegerRange(TimelineRequest timelineRequest, SasUser sasUser) {
//		TypedQuery<TimelineView> typedQuery = em.createQuery(selectClause + " WHERE tim0.firmid = :firmid AND tim0.modifyon IS NOT NULL ORDER BY tim0.modifyon DESC", TimelineView.class)
		TypedQuery<TimelineView> typedQuery = em.createQuery(selectClause + " WHERE tim0.firmid = :firmid ORDER BY tim0.modifyon DESC", TimelineView.class)
				.setParameter("firmid", sasUser.getUser().getFirmid())
				.setMaxResults(timelineRequest.getNumberRange());
		
		List<TimelineView> timelineviews = typedQuery.getResultList();
		
//		List<TimelineView> timelineviews = em.createQuery(selectClause + " WHERE tim0.firmid = :firmid AND tim0.modifyon IS NOT NULL ORDER BY tim0.modifyon DESC", TimelineView.class)
//				.setParameter("firmid", sasUser.getUser().getFirmid())
//				.setMaxResults(timelineRequest.getNumberRange())
//				.getResultList();
		
		return timelineviews;
	}
	
	/**
	 * Find by id.
	 *
	 * @param key the key
	 * @param initAll the init all
	 * @return the timeline view
	 */
	public TimelineView findById(Object key, Boolean initAll) {
		TimelineView item = em.find(TimelineView.class, key);
		
		if (initAll) {
			item.init();
		}
		
		return item;
	}

	/**
	 * Find by id.
	 *
	 * @param settings the settings
	 * @return the timeline view
	 */
	public TimelineView findById(ScrollableSettings settings) {
		TimelineView item = em.find(TimelineView.class, settings.getId());

		if (settings.getList().size() > 0) {
			item.customInit(item, settings.getList());
		}

		if (settings.getInitDicts()) {
			item.initDicts();
		}

		if (settings.getInitLists()) {
			item.initList();
		}

		return item;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean delete(Object id) {
		try {
			em.remove(em.getReference(TimelineView.class, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
