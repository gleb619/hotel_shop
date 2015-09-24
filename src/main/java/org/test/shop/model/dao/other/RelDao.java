package org.test.shop.model.dao.other;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.SRel;
import org.test.shop.util.DaoUtil;
import org.test.shop.util.data.types.FindByExample;

@Repository
public class RelDao {

	@PersistenceContext
	private EntityManager em;
	private String selectClauseTemplate = "SELECT %s FROM %s %s";
	private String selectClause = "";
	private String className = "";
	private String shortName;
	
	private void readSelectClause(Class<?> arg0){
		String name = arg0.getSimpleName();
		
		this.className = name;
		if (name.length() >= 3) {
			name = name.substring(0, 2).toLowerCase() + "0";
		}
		this.shortName = name;
		updateSelectClause();
	}
	
	private void updateSelectClause(){
		this.selectClause = String.format(selectClauseTemplate, shortName, className, shortName);
	}
	
	public <T extends SRel> T create(T arg0) {
		em.persist(arg0);
		return arg0;
	}

	public <T extends SRel> T update(T arg0) {
		return em.merge(arg0);
	}

	@SuppressWarnings("unchecked")
	public <T extends SRel> List<T> findByExample(T example, String delimitter, Class<T> clazz) {
		FindByExample findByExample = DaoUtil.findByExampleQueryRaw(example,
				clazz, em, delimitter);
		Query query = DaoUtil.sasQuery(findByExample.getSelectClause(),
				new ScrollableSettings(), clazz, em);
		for (String key : findByExample.getValues().keySet()) {
			query.setParameter(key, findByExample.getValues().get(key));
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T extends SRel> List<T> findAll(ScrollableSettings settings, Class<T> clazz) {
		readSelectClause(clazz);
		List<T> list = DaoUtil.sasQuery(selectClause, settings,
				clazz, em).getResultList();

		if (settings.getList().size() > 0) {
			for (T item : list) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (T item : list) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public <T extends SRel> List<T> findAllScrollable(ScrollableSettings settings, Class<T> clazz) {
		readSelectClause(clazz);
		List<T> list = DaoUtil
				.sasQuery(selectClause, settings, clazz, em)
				.setFirstResult((settings.getPageNumber() - 1) * settings.getPageSize())
				.setMaxResults(settings.getPageSize()).getResultList();

		if (settings.getList().size() > 0) {
			for (T item : list) {
				item.customInit(item, settings.getList());
			}
		}

		if (settings.getInitLists() || settings.getInitDicts()) {
			for (T item : list) {
				if (settings.getInitDicts()) {
					item.initDicts();
				}
				if (settings.getInitLists()) {
					item.initList();
				}
			}
		}

		return list;
	}

	public <T extends SRel> T findById(Object key, Boolean initAll, Class<T> clazz) {
		T item = em.find(clazz, key);
		
		if (initAll) {
			item.init();
		}
		
		return item;
	}

	public <T extends SRel> T findById(ScrollableSettings settings, Class<T> clazz) {
		T item = em.find(clazz, settings.getId());

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

	public Boolean delete(Object id, Class<?> clazz) {
		try {
			em.remove(em.getReference(clazz, id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
