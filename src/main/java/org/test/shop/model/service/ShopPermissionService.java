package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ShopPermissionDao;
import org.test.shop.model.domain.entity.ShopPermission;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopPermissionService {

	@Autowired
	private ShopPermissionDao shoppermissionDao;

	@Transactional
	public ShopPermission create(ShopPermission data) {
		return shoppermissionDao.create(data);
	}

	@Transactional
	public ShopPermission update(ShopPermission data) {
		return shoppermissionDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoppermissionDao.delete(id);
	}

	@Transactional
	public void popularity(ShopPermission data) {
		shoppermissionDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoppermissionDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoppermissionDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoppermissionDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> namedFilter(ScrollableSettings settings) {
		return shoppermissionDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> search(ScrollableSettings settings){
		return  shoppermissionDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> findByExample(ShopPermission example, String delimitter, ScrollableSettings settings) {
		return shoppermissionDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopPermission> findByExample2(ShopPermission example, DateCompare type) {
		return shoppermissionDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> findAll() {
		return shoppermissionDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> findAll(ScrollableSettings settings) {
		return shoppermissionDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermission> findAllScrollable(ScrollableSettings settings) {
		return shoppermissionDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopPermission findById(ScrollableSettings scrollableSettings) {
		return shoppermissionDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopPermission findById(Object key, Boolean initAll) {
		return shoppermissionDao.findById(key, initAll);
	}
	
	
}
