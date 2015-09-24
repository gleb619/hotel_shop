package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.UserRolesViewDao;
import org.test.shop.model.domain.entity.view.UserRolesView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UserRolesViewService {

	@Autowired
	private UserRolesViewDao userrolesviewDao;

	@Transactional
	public UserRolesView create(UserRolesView data) {
		return userrolesviewDao.create(data);
	}

	@Transactional
	public UserRolesView update(UserRolesView data) {
		return userrolesviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return userrolesviewDao.delete(id);
	}

	@Transactional
	public void popularity(UserRolesView data) {
		userrolesviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		userrolesviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return userrolesviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return userrolesviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> namedFilter(ScrollableSettings settings) {
		return userrolesviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> search(ScrollableSettings settings){
		return  userrolesviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> findByExample(UserRolesView example, String delimitter, ScrollableSettings settings) {
		return userrolesviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UserRolesView> findByExample2(UserRolesView example, DateCompare type) {
		return userrolesviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> findAll() {
		return userrolesviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> findAll(ScrollableSettings settings) {
		return userrolesviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRolesView> findAllScrollable(ScrollableSettings settings) {
		return userrolesviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UserRolesView findById(ScrollableSettings scrollableSettings) {
		return userrolesviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UserRolesView findById(Object key, Boolean initAll) {
		return userrolesviewDao.findById(key, initAll);
	}
	
	
}
