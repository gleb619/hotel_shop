package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.UsersViewDao;
import org.test.shop.model.domain.entity.view.UsersView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UsersViewService {

	@Autowired
	private UsersViewDao usersviewDao;

	@Transactional
	public UsersView create(UsersView data) {
		return usersviewDao.create(data);
	}

	@Transactional
	public UsersView update(UsersView data) {
		return usersviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return usersviewDao.delete(id);
	}

	@Transactional
	public void popularity(UsersView data) {
		usersviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		usersviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return usersviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return usersviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UsersView> namedFilter(ScrollableSettings settings) {
		return usersviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UsersView> search(ScrollableSettings settings){
		return  usersviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UsersView> findByExample(UsersView example, String delimitter, ScrollableSettings settings) {
		return usersviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UsersView> findByExample2(UsersView example, DateCompare type) {
		return usersviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UsersView> findAll() {
		return usersviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UsersView> findAll(ScrollableSettings settings) {
		return usersviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UsersView> findAllScrollable(ScrollableSettings settings) {
		return usersviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UsersView findById(ScrollableSettings scrollableSettings) {
		return usersviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UsersView findById(Object key, Boolean initAll) {
		return usersviewDao.findById(key, initAll);
	}
	
	
}
