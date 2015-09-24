package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.UserDetailDao;
import org.test.shop.model.domain.entity.UserDetail;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UserDetailService {

	@Autowired
	private UserDetailDao userdetailDao;

	@Transactional
	public UserDetail create(UserDetail data) {
		return userdetailDao.create(data);
	}

	@Transactional
	public UserDetail update(UserDetail data) {
		return userdetailDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return userdetailDao.delete(id);
	}

	@Transactional
	public void popularity(UserDetail data) {
		userdetailDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		userdetailDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return userdetailDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return userdetailDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetail> namedFilter(ScrollableSettings settings) {
		return userdetailDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetail> search(ScrollableSettings settings){
		return  userdetailDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetail> findByExample(UserDetail example, String delimitter, ScrollableSettings settings) {
		return userdetailDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UserDetail> findByExample2(UserDetail example, DateCompare type) {
		return userdetailDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UserDetail> findAll() {
		return userdetailDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UserDetail> findAll(ScrollableSettings settings) {
		return userdetailDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UserDetail> findAllScrollable(ScrollableSettings settings) {
		return userdetailDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UserDetail findById(ScrollableSettings scrollableSettings) {
		return userdetailDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UserDetail findById(Object key, Boolean initAll) {
		return userdetailDao.findById(key, initAll);
	}
	
	
}
