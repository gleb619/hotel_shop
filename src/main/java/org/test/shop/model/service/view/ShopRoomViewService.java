package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopRoomViewDao;
import org.test.shop.model.domain.entity.view.ShopRoomView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopRoomViewService {

	@Autowired
	private ShopRoomViewDao shoproomviewDao;

	@Transactional
	public ShopRoomView create(ShopRoomView data) {
		return shoproomviewDao.create(data);
	}

	@Transactional
	public ShopRoomView update(ShopRoomView data) {
		return shoproomviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoproomviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopRoomView data) {
		shoproomviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoproomviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoproomviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoproomviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> namedFilter(ScrollableSettings settings) {
		return shoproomviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> search(ScrollableSettings settings){
		return  shoproomviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> findByExample(ShopRoomView example, String delimitter, ScrollableSettings settings) {
		return shoproomviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopRoomView> findByExample2(ShopRoomView example, DateCompare type) {
		return shoproomviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> findAll() {
		return shoproomviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> findAll(ScrollableSettings settings) {
		return shoproomviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomView> findAllScrollable(ScrollableSettings settings) {
		return shoproomviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopRoomView findById(ScrollableSettings scrollableSettings) {
		return shoproomviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopRoomView findById(Object key, Boolean initAll) {
		return shoproomviewDao.findById(key, initAll);
	}
	
	
}
