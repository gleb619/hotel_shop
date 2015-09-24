package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopRoomTarriffOriginalRateViewDao;
import org.test.shop.model.domain.entity.view.ShopRoomTarriffOriginalRateView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopRoomTarriffOriginalRateViewService {

	@Autowired
	private ShopRoomTarriffOriginalRateViewDao shoproomtarrifforiginalrateviewDao;

	@Transactional
	public ShopRoomTarriffOriginalRateView create(ShopRoomTarriffOriginalRateView data) {
		return shoproomtarrifforiginalrateviewDao.create(data);
	}

	@Transactional
	public ShopRoomTarriffOriginalRateView update(ShopRoomTarriffOriginalRateView data) {
		return shoproomtarrifforiginalrateviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoproomtarrifforiginalrateviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopRoomTarriffOriginalRateView data) {
		shoproomtarrifforiginalrateviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoproomtarrifforiginalrateviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoproomtarrifforiginalrateviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoproomtarrifforiginalrateviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> namedFilter(ScrollableSettings settings) {
		return shoproomtarrifforiginalrateviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> search(ScrollableSettings settings){
		return  shoproomtarrifforiginalrateviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> findByExample(ShopRoomTarriffOriginalRateView example, String delimitter, ScrollableSettings settings) {
		return shoproomtarrifforiginalrateviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> findByExample2(ShopRoomTarriffOriginalRateView example, DateCompare type) {
		return shoproomtarrifforiginalrateviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> findAll() {
		return shoproomtarrifforiginalrateviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> findAll(ScrollableSettings settings) {
		return shoproomtarrifforiginalrateviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffOriginalRateView> findAllScrollable(ScrollableSettings settings) {
		return shoproomtarrifforiginalrateviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopRoomTarriffOriginalRateView findById(ScrollableSettings scrollableSettings) {
		return shoproomtarrifforiginalrateviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopRoomTarriffOriginalRateView findById(Object key, Boolean initAll) {
		return shoproomtarrifforiginalrateviewDao.findById(key, initAll);
	}
	
	
}
