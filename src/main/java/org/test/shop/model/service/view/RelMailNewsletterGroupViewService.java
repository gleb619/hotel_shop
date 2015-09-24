package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelMailNewsletterGroupViewDao;
import org.test.shop.model.domain.entity.view.RelMailNewsletterGroupView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelMailNewsletterGroupViewService {

	@Autowired
	private RelMailNewsletterGroupViewDao relmailnewslettergroupviewDao;

	@Transactional
	public RelMailNewsletterGroupView create(RelMailNewsletterGroupView data) {
		return relmailnewslettergroupviewDao.create(data);
	}

	@Transactional
	public RelMailNewsletterGroupView update(RelMailNewsletterGroupView data) {
		return relmailnewslettergroupviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relmailnewslettergroupviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelMailNewsletterGroupView data) {
		relmailnewslettergroupviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relmailnewslettergroupviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relmailnewslettergroupviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relmailnewslettergroupviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> namedFilter(ScrollableSettings settings) {
		return relmailnewslettergroupviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> search(ScrollableSettings settings){
		return  relmailnewslettergroupviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> findByExample(RelMailNewsletterGroupView example, String delimitter, ScrollableSettings settings) {
		return relmailnewslettergroupviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> findByExample2(RelMailNewsletterGroupView example, DateCompare type) {
		return relmailnewslettergroupviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> findAll() {
		return relmailnewslettergroupviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> findAll(ScrollableSettings settings) {
		return relmailnewslettergroupviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelMailNewsletterGroupView> findAllScrollable(ScrollableSettings settings) {
		return relmailnewslettergroupviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelMailNewsletterGroupView findById(ScrollableSettings scrollableSettings) {
		return relmailnewslettergroupviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelMailNewsletterGroupView findById(Object key, Boolean initAll) {
		return relmailnewslettergroupviewDao.findById(key, initAll);
	}
	
	
}
