package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelShopPermissionDao;
import org.test.shop.model.domain.entity.RelShopPermission;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelShopPermissionService {

	@Autowired
	private RelShopPermissionDao relshoppermissionDao;

	@Transactional
	public RelShopPermission create(RelShopPermission data) {
		return relshoppermissionDao.create(data);
	}

	@Transactional
	public RelShopPermission update(RelShopPermission data) {
		return relshoppermissionDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relshoppermissionDao.delete(id);
	}

	@Transactional
	public void popularity(RelShopPermission data) {
		relshoppermissionDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relshoppermissionDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relshoppermissionDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relshoppermissionDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> namedFilter(ScrollableSettings settings) {
		return relshoppermissionDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> search(ScrollableSettings settings){
		return  relshoppermissionDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> findByExample(RelShopPermission example, String delimitter, ScrollableSettings settings) {
		return relshoppermissionDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelShopPermission> findByExample2(RelShopPermission example, DateCompare type) {
		return relshoppermissionDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> findAll() {
		return relshoppermissionDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> findAll(ScrollableSettings settings) {
		return relshoppermissionDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermission> findAllScrollable(ScrollableSettings settings) {
		return relshoppermissionDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelShopPermission findById(ScrollableSettings scrollableSettings) {
		return relshoppermissionDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelShopPermission findById(Object key, Boolean initAll) {
		return relshoppermissionDao.findById(key, initAll);
	}
	
	
}
