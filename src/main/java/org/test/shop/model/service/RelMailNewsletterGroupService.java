package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelMailNewsletterGroupDao;
import org.test.shop.model.domain.entity.RelMailNewsletterGroup;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelMailNewsletterGroupService {

	@Autowired
	private RelMailNewsletterGroupDao relmailnewslettergroupDao;

	@Transactional
	public RelMailNewsletterGroup create(RelMailNewsletterGroup data) {
		return relmailnewslettergroupDao.create(data);
	}

	@Transactional
	public RelMailNewsletterGroup update(RelMailNewsletterGroup data) {
		return relmailnewslettergroupDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relmailnewslettergroupDao.delete(id);
	}

	@Transactional
	public void popularity(RelMailNewsletterGroup data) {
		relmailnewslettergroupDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relmailnewslettergroupDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relmailnewslettergroupDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relmailnewslettergroupDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> namedFilter(ScrollableSettings settings) {
		return relmailnewslettergroupDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> search(ScrollableSettings settings){
		return  relmailnewslettergroupDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> findByExample(RelMailNewsletterGroup example, String delimitter, ScrollableSettings settings) {
		return relmailnewslettergroupDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> findByExample2(RelMailNewsletterGroup example, DateCompare type) {
		return relmailnewslettergroupDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> findAll() {
		return relmailnewslettergroupDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> findAll(ScrollableSettings settings) {
		return relmailnewslettergroupDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroup> findAllScrollable(ScrollableSettings settings) {
		return relmailnewslettergroupDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelMailNewsletterGroup findById(ScrollableSettings scrollableSettings) {
		return relmailnewslettergroupDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelMailNewsletterGroup findById(Object key, Boolean initAll) {
		return relmailnewslettergroupDao.findById(key, initAll);
	}
	
	
}
