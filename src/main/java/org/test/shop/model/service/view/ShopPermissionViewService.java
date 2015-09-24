package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopPermissionViewDao;
import org.test.shop.model.domain.entity.view.ShopPermissionView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopPermissionViewService {

	@Autowired
	private ShopPermissionViewDao shoppermissionviewDao;

	@Transactional
	public ShopPermissionView create(ShopPermissionView data) {
		return shoppermissionviewDao.create(data);
	}

	@Transactional
	public ShopPermissionView update(ShopPermissionView data) {
		return shoppermissionviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoppermissionviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopPermissionView data) {
		shoppermissionviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoppermissionviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoppermissionviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoppermissionviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> namedFilter(ScrollableSettings settings) {
		return shoppermissionviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> search(ScrollableSettings settings){
		return  shoppermissionviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> findByExample(ShopPermissionView example, String delimitter, ScrollableSettings settings) {
		return shoppermissionviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopPermissionView> findByExample2(ShopPermissionView example, DateCompare type) {
		return shoppermissionviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> findAll() {
		return shoppermissionviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> findAll(ScrollableSettings settings) {
		return shoppermissionviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopPermissionView> findAllScrollable(ScrollableSettings settings) {
		return shoppermissionviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopPermissionView findById(ScrollableSettings scrollableSettings) {
		return shoppermissionviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopPermissionView findById(Object key, Boolean initAll) {
		return shoppermissionviewDao.findById(key, initAll);
	}
	
	
}
