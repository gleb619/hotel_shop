package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopRoomTarriffCorporateRateViewDao;
import org.test.shop.model.domain.entity.view.ShopRoomTarriffCorporateRateView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopRoomTarriffCorporateRateViewService {

	@Autowired
	private ShopRoomTarriffCorporateRateViewDao shoproomtarriffcorporaterateviewDao;

	@Transactional
	public ShopRoomTarriffCorporateRateView create(ShopRoomTarriffCorporateRateView data) {
		return shoproomtarriffcorporaterateviewDao.create(data);
	}

	@Transactional
	public ShopRoomTarriffCorporateRateView update(ShopRoomTarriffCorporateRateView data) {
		return shoproomtarriffcorporaterateviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shoproomtarriffcorporaterateviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopRoomTarriffCorporateRateView data) {
		shoproomtarriffcorporaterateviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shoproomtarriffcorporaterateviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shoproomtarriffcorporaterateviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shoproomtarriffcorporaterateviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> namedFilter(ScrollableSettings settings) {
		return shoproomtarriffcorporaterateviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> search(ScrollableSettings settings){
		return  shoproomtarriffcorporaterateviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> findByExample(ShopRoomTarriffCorporateRateView example, String delimitter, ScrollableSettings settings) {
		return shoproomtarriffcorporaterateviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> findByExample2(ShopRoomTarriffCorporateRateView example, DateCompare type) {
		return shoproomtarriffcorporaterateviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> findAll() {
		return shoproomtarriffcorporaterateviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> findAll(ScrollableSettings settings) {
		return shoproomtarriffcorporaterateviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopRoomTarriffCorporateRateView> findAllScrollable(ScrollableSettings settings) {
		return shoproomtarriffcorporaterateviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopRoomTarriffCorporateRateView findById(ScrollableSettings scrollableSettings) {
		return shoproomtarriffcorporaterateviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopRoomTarriffCorporateRateView findById(Object key, Boolean initAll) {
		return shoproomtarriffcorporaterateviewDao.findById(key, initAll);
	}
	
	
}
