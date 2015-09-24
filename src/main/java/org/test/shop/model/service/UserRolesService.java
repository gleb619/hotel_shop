package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.UserRolesDao;
import org.test.shop.model.domain.entity.UserRoles;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UserRolesService {

	@Autowired
	private UserRolesDao userrolesDao;

	@Transactional
	public UserRoles create(UserRoles data) {
		return userrolesDao.create(data);
	}

	@Transactional
	public UserRoles update(UserRoles data) {
		return userrolesDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return userrolesDao.delete(id);
	}

	@Transactional
	public void popularity(UserRoles data) {
		userrolesDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		userrolesDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return userrolesDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return userrolesDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRoles> namedFilter(ScrollableSettings settings) {
		return userrolesDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRoles> search(ScrollableSettings settings){
		return  userrolesDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRoles> findByExample(UserRoles example, String delimitter, ScrollableSettings settings) {
		return userrolesDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UserRoles> findByExample2(UserRoles example, DateCompare type) {
		return userrolesDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UserRoles> findAll() {
		return userrolesDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UserRoles> findAll(ScrollableSettings settings) {
		return userrolesDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRoles> findAllScrollable(ScrollableSettings settings) {
		return userrolesDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UserRoles findById(ScrollableSettings scrollableSettings) {
		return userrolesDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UserRoles findById(Object key, Boolean initAll) {
		return userrolesDao.findById(key, initAll);
	}
	
	
}
