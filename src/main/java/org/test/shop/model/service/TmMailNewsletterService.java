package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmMailNewsletterDao;
import org.test.shop.model.domain.entity.TmMailNewsletter;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmMailNewsletterService {

	@Autowired
	private TmMailNewsletterDao tmmailnewsletterDao;

	@Transactional
	public TmMailNewsletter create(TmMailNewsletter data) {
		return tmmailnewsletterDao.create(data);
	}

	@Transactional
	public TmMailNewsletter update(TmMailNewsletter data) {
		return tmmailnewsletterDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmmailnewsletterDao.delete(id);
	}

	@Transactional
	public void popularity(TmMailNewsletter data) {
		tmmailnewsletterDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmmailnewsletterDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmmailnewsletterDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmmailnewsletterDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> namedFilter(ScrollableSettings settings) {
		return tmmailnewsletterDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> search(ScrollableSettings settings){
		return  tmmailnewsletterDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> findByExample(TmMailNewsletter example, String delimitter, ScrollableSettings settings) {
		return tmmailnewsletterDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmMailNewsletter> findByExample2(TmMailNewsletter example, DateCompare type) {
		return tmmailnewsletterDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> findAll() {
		return tmmailnewsletterDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> findAll(ScrollableSettings settings) {
		return tmmailnewsletterDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletter> findAllScrollable(ScrollableSettings settings) {
		return tmmailnewsletterDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmMailNewsletter findById(ScrollableSettings scrollableSettings) {
		return tmmailnewsletterDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmMailNewsletter findById(Object key, Boolean initAll) {
		return tmmailnewsletterDao.findById(key, initAll);
	}
	
	
}
