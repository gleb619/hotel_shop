package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.UserRegistrationRequestViewDao;
import org.test.shop.model.domain.entity.view.UserRegistrationRequestView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class UserRegistrationRequestViewService {

	@Autowired
	private UserRegistrationRequestViewDao userregistrationrequestviewDao;

	@Transactional
	public UserRegistrationRequestView create(UserRegistrationRequestView data) {
		return userregistrationrequestviewDao.create(data);
	}

	@Transactional
	public UserRegistrationRequestView update(UserRegistrationRequestView data) {
		return userregistrationrequestviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return userregistrationrequestviewDao.delete(id);
	}

	@Transactional
	public void popularity(UserRegistrationRequestView data) {
		userregistrationrequestviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		userregistrationrequestviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return userregistrationrequestviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return userregistrationrequestviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> namedFilter(ScrollableSettings settings) {
		return userregistrationrequestviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> search(ScrollableSettings settings){
		return  userregistrationrequestviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> findByExample(UserRegistrationRequestView example, String delimitter, ScrollableSettings settings) {
		return userregistrationrequestviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> findByExample2(UserRegistrationRequestView example, DateCompare type) {
		return userregistrationrequestviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> findAll() {
		return userregistrationrequestviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> findAll(ScrollableSettings settings) {
		return userregistrationrequestviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<UserRegistrationRequestView> findAllScrollable(ScrollableSettings settings) {
		return userregistrationrequestviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public UserRegistrationRequestView findById(ScrollableSettings scrollableSettings) {
		return userregistrationrequestviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public UserRegistrationRequestView findById(Object key, Boolean initAll) {
		return userregistrationrequestviewDao.findById(key, initAll);
	}
	
	
}
