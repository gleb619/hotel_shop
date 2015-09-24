package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.UserDetailViewDao;
import org.test.shop.model.domain.entity.view.UserDetailView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UserDetailViewService {

	@Autowired
	private UserDetailViewDao userdetailviewDao;

	@Transactional
	public UserDetailView create(UserDetailView data) {
		return userdetailviewDao.create(data);
	}

	@Transactional
	public UserDetailView update(UserDetailView data) {
		return userdetailviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return userdetailviewDao.delete(id);
	}

	@Transactional
	public void popularity(UserDetailView data) {
		userdetailviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		userdetailviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return userdetailviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return userdetailviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> namedFilter(ScrollableSettings settings) {
		return userdetailviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> search(ScrollableSettings settings){
		return  userdetailviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> findByExample(UserDetailView example, String delimitter, ScrollableSettings settings) {
		return userdetailviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UserDetailView> findByExample2(UserDetailView example, DateCompare type) {
		return userdetailviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> findAll() {
		return userdetailviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> findAll(ScrollableSettings settings) {
		return userdetailviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetailView> findAllScrollable(ScrollableSettings settings) {
		return userdetailviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UserDetailView findById(ScrollableSettings scrollableSettings) {
		return userdetailviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UserDetailView findById(Object key, Boolean initAll) {
		return userdetailviewDao.findById(key, initAll);
	}
	
	
}
