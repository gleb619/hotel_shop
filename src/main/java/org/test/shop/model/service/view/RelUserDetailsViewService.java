package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelUserDetailsViewDao;
import org.test.shop.model.domain.entity.view.RelUserDetailsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelUserDetailsViewService {

	@Autowired
	private RelUserDetailsViewDao reluserdetailsviewDao;

	@Transactional
	public RelUserDetailsView create(RelUserDetailsView data) {
		return reluserdetailsviewDao.create(data);
	}

	@Transactional
	public RelUserDetailsView update(RelUserDetailsView data) {
		return reluserdetailsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reluserdetailsviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelUserDetailsView data) {
		reluserdetailsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reluserdetailsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reluserdetailsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reluserdetailsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> namedFilter(ScrollableSettings settings) {
		return reluserdetailsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> search(ScrollableSettings settings){
		return  reluserdetailsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> findByExample(RelUserDetailsView example, String delimitter, ScrollableSettings settings) {
		return reluserdetailsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelUserDetailsView> findByExample2(RelUserDetailsView example, DateCompare type) {
		return reluserdetailsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> findAll() {
		return reluserdetailsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> findAll(ScrollableSettings settings) {
		return reluserdetailsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetailsView> findAllScrollable(ScrollableSettings settings) {
		return reluserdetailsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelUserDetailsView findById(ScrollableSettings scrollableSettings) {
		return reluserdetailsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelUserDetailsView findById(Object key, Boolean initAll) {
		return reluserdetailsviewDao.findById(key, initAll);
	}
	
	
}
