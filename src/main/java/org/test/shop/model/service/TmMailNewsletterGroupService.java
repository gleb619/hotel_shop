package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmMailNewsletterGroupDao;
import org.test.shop.model.domain.entity.TmMailNewsletterGroup;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmMailNewsletterGroupService {

	@Autowired
	private TmMailNewsletterGroupDao tmmailnewslettergroupDao;

	@Transactional
	public TmMailNewsletterGroup create(TmMailNewsletterGroup data) {
		return tmmailnewslettergroupDao.create(data);
	}

	@Transactional
	public TmMailNewsletterGroup update(TmMailNewsletterGroup data) {
		return tmmailnewslettergroupDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmmailnewslettergroupDao.delete(id);
	}

	@Transactional
	public void popularity(TmMailNewsletterGroup data) {
		tmmailnewslettergroupDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmmailnewslettergroupDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmmailnewslettergroupDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmmailnewslettergroupDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> namedFilter(ScrollableSettings settings) {
		return tmmailnewslettergroupDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> search(ScrollableSettings settings){
		return  tmmailnewslettergroupDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> findByExample(TmMailNewsletterGroup example, String delimitter, ScrollableSettings settings) {
		return tmmailnewslettergroupDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> findByExample2(TmMailNewsletterGroup example, DateCompare type) {
		return tmmailnewslettergroupDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> findAll() {
		return tmmailnewslettergroupDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> findAll(ScrollableSettings settings) {
		return tmmailnewslettergroupDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroup> findAllScrollable(ScrollableSettings settings) {
		return tmmailnewslettergroupDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmMailNewsletterGroup findById(ScrollableSettings scrollableSettings) {
		return tmmailnewslettergroupDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmMailNewsletterGroup findById(Object key, Boolean initAll) {
		return tmmailnewslettergroupDao.findById(key, initAll);
	}
	
	
}
