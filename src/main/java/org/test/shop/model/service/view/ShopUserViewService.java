package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopUserViewDao;
import org.test.shop.model.domain.entity.view.ShopUserView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopUserViewService {

	@Autowired
	private ShopUserViewDao shopuserviewDao;

	@Transactional
	public ShopUserView create(ShopUserView data) {
		return shopuserviewDao.create(data);
	}

	@Transactional
	public ShopUserView update(ShopUserView data) {
		return shopuserviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shopuserviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopUserView data) {
		shopuserviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shopuserviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shopuserviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shopuserviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> namedFilter(ScrollableSettings settings) {
		return shopuserviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> search(ScrollableSettings settings){
		return  shopuserviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> findByExample(ShopUserView example, String delimitter, ScrollableSettings settings) {
		return shopuserviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopUserView> findByExample2(ShopUserView example, DateCompare type) {
		return shopuserviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> findAll() {
		return shopuserviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> findAll(ScrollableSettings settings) {
		return shopuserviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopUserView> findAllScrollable(ScrollableSettings settings) {
		return shopuserviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopUserView findById(ScrollableSettings scrollableSettings) {
		return shopuserviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopUserView findById(Object key, Boolean initAll) {
		return shopuserviewDao.findById(key, initAll);
	}
	
	
}
