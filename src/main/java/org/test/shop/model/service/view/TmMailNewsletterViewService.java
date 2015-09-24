package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmMailNewsletterViewDao;
import org.test.shop.model.domain.entity.view.TmMailNewsletterView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmMailNewsletterViewService {

	@Autowired
	private TmMailNewsletterViewDao tmmailnewsletterviewDao;

	@Transactional
	public TmMailNewsletterView create(TmMailNewsletterView data) {
		return tmmailnewsletterviewDao.create(data);
	}

	@Transactional
	public TmMailNewsletterView update(TmMailNewsletterView data) {
		return tmmailnewsletterviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmmailnewsletterviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmMailNewsletterView data) {
		tmmailnewsletterviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmmailnewsletterviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmmailnewsletterviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmmailnewsletterviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> namedFilter(ScrollableSettings settings) {
		return tmmailnewsletterviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> search(ScrollableSettings settings){
		return  tmmailnewsletterviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> findByExample(TmMailNewsletterView example, String delimitter, ScrollableSettings settings) {
		return tmmailnewsletterviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> findByExample2(TmMailNewsletterView example, DateCompare type) {
		return tmmailnewsletterviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> findAll() {
		return tmmailnewsletterviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> findAll(ScrollableSettings settings) {
		return tmmailnewsletterviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterView> findAllScrollable(ScrollableSettings settings) {
		return tmmailnewsletterviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmMailNewsletterView findById(ScrollableSettings scrollableSettings) {
		return tmmailnewsletterviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmMailNewsletterView findById(Object key, Boolean initAll) {
		return tmmailnewsletterviewDao.findById(key, initAll);
	}
	
	
}
