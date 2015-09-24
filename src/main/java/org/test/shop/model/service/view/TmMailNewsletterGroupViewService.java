package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmMailNewsletterGroupViewDao;
import org.test.shop.model.domain.entity.view.TmMailNewsletterGroupView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmMailNewsletterGroupViewService {

	@Autowired
	private TmMailNewsletterGroupViewDao tmmailnewslettergroupviewDao;

	@Transactional
	public TmMailNewsletterGroupView create(TmMailNewsletterGroupView data) {
		return tmmailnewslettergroupviewDao.create(data);
	}

	@Transactional
	public TmMailNewsletterGroupView update(TmMailNewsletterGroupView data) {
		return tmmailnewslettergroupviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmmailnewslettergroupviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmMailNewsletterGroupView data) {
		tmmailnewslettergroupviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmmailnewslettergroupviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmmailnewslettergroupviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmmailnewslettergroupviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> namedFilter(ScrollableSettings settings) {
		return tmmailnewslettergroupviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> search(ScrollableSettings settings){
		return  tmmailnewslettergroupviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> findByExample(TmMailNewsletterGroupView example, String delimitter, ScrollableSettings settings) {
		return tmmailnewslettergroupviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> findByExample2(TmMailNewsletterGroupView example, DateCompare type) {
		return tmmailnewslettergroupviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> findAll() {
		return tmmailnewslettergroupviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> findAll(ScrollableSettings settings) {
		return tmmailnewslettergroupviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmMailNewsletterGroupView> findAllScrollable(ScrollableSettings settings) {
		return tmmailnewslettergroupviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmMailNewsletterGroupView findById(ScrollableSettings scrollableSettings) {
		return tmmailnewslettergroupviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmMailNewsletterGroupView findById(Object key, Boolean initAll) {
		return tmmailnewslettergroupviewDao.findById(key, initAll);
	}
	
	
}
