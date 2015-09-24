package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopRoomTarriffGeneralRateViewDao;
import org.test.shop.model.domain.entity.view.ShopRoomTarriffGeneralRateView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopRoomTarriffGeneralRateViewService {

	@Autowired
	private ShopRoomTarriffGeneralRateViewDao shoproomtarriffgeneralrateviewDao;

	@Transactional
	public ShopRoomTarriffGeneralRateView create(ShopRoomTarriffGeneralRateView data) {
		return shoproomtarriffgeneralrateviewDao.create(data);
	}

	@Transactional
	public ShopRoomTarriffGeneralRateView update(ShopRoomTarriffGeneralRateView data) {
		return shoproomtarriffgeneralrateviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoproomtarriffgeneralrateviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopRoomTarriffGeneralRateView data) {
		shoproomtarriffgeneralrateviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoproomtarriffgeneralrateviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoproomtarriffgeneralrateviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoproomtarriffgeneralrateviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> namedFilter(ScrollableSettings settings) {
		return shoproomtarriffgeneralrateviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> search(ScrollableSettings settings){
		return  shoproomtarriffgeneralrateviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> findByExample(ShopRoomTarriffGeneralRateView example, String delimitter, ScrollableSettings settings) {
		return shoproomtarriffgeneralrateviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> findByExample2(ShopRoomTarriffGeneralRateView example, DateCompare type) {
		return shoproomtarriffgeneralrateviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> findAll() {
		return shoproomtarriffgeneralrateviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> findAll(ScrollableSettings settings) {
		return shoproomtarriffgeneralrateviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffGeneralRateView> findAllScrollable(ScrollableSettings settings) {
		return shoproomtarriffgeneralrateviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopRoomTarriffGeneralRateView findById(ScrollableSettings scrollableSettings) {
		return shoproomtarriffgeneralrateviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopRoomTarriffGeneralRateView findById(Object key, Boolean initAll) {
		return shoproomtarriffgeneralrateviewDao.findById(key, initAll);
	}
	
	
}
