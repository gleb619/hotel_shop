package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelShopPermissionViewDao;
import org.test.shop.model.domain.entity.view.RelShopPermissionView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelShopPermissionViewService {

	@Autowired
	private RelShopPermissionViewDao relshoppermissionviewDao;

	@Transactional
	public RelShopPermissionView create(RelShopPermissionView data) {
		return relshoppermissionviewDao.create(data);
	}

	@Transactional
	public RelShopPermissionView update(RelShopPermissionView data) {
		return relshoppermissionviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relshoppermissionviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelShopPermissionView data) {
		relshoppermissionviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relshoppermissionviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relshoppermissionviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relshoppermissionviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> namedFilter(ScrollableSettings settings) {
		return relshoppermissionviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> search(ScrollableSettings settings){
		return  relshoppermissionviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> findByExample(RelShopPermissionView example, String delimitter, ScrollableSettings settings) {
		return relshoppermissionviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelShopPermissionView> findByExample2(RelShopPermissionView example, DateCompare type) {
		return relshoppermissionviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> findAll() {
		return relshoppermissionviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> findAll(ScrollableSettings settings) {
		return relshoppermissionviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelShopPermissionView> findAllScrollable(ScrollableSettings settings) {
		return relshoppermissionviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelShopPermissionView findById(ScrollableSettings scrollableSettings) {
		return relshoppermissionviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelShopPermissionView findById(Object key, Boolean initAll) {
		return relshoppermissionviewDao.findById(key, initAll);
	}
	
	
}
