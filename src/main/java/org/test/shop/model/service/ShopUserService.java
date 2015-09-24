package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ShopUserDao;
import org.test.shop.model.domain.entity.ShopUser;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopUserService {

	@Autowired
	private ShopUserDao shopuserDao;

	@Transactional
	public ShopUser create(ShopUser data) {
		return shopuserDao.create(data);
	}

	@Transactional
	public ShopUser update(ShopUser data) {
		return shopuserDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shopuserDao.delete(id);
	}

	@Transactional
	public void popularity(ShopUser data) {
		shopuserDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shopuserDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shopuserDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shopuserDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUser> namedFilter(ScrollableSettings settings) {
		return shopuserDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUser> search(ScrollableSettings settings){
		return  shopuserDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUser> findByExample(ShopUser example, String delimitter, ScrollableSettings settings) {
		return shopuserDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopUser> findByExample2(ShopUser example, DateCompare type) {
		return shopuserDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopUser> findAll() {
		return shopuserDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopUser> findAll(ScrollableSettings settings) {
		return shopuserDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUser> findAllScrollable(ScrollableSettings settings) {
		return shopuserDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopUser findById(ScrollableSettings scrollableSettings) {
		return shopuserDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopUser findById(Object key, Boolean initAll) {
		return shopuserDao.findById(key, initAll);
	}
	
	
}
