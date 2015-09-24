package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServHotelRoomViewDao;
import org.test.shop.model.domain.entity.view.ServHotelRoomView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServHotelRoomViewService {

	@Autowired
	private ServHotelRoomViewDao servhotelroomviewDao;

	@Transactional
	public ServHotelRoomView create(ServHotelRoomView data) {
		return servhotelroomviewDao.create(data);
	}

	@Transactional
	public ServHotelRoomView update(ServHotelRoomView data) {
		return servhotelroomviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servhotelroomviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServHotelRoomView data) {
		servhotelroomviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servhotelroomviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servhotelroomviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servhotelroomviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> namedFilter(ScrollableSettings settings) {
		return servhotelroomviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> search(ScrollableSettings settings){
		return  servhotelroomviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> findByExample(ServHotelRoomView example, String delimitter, ScrollableSettings settings) {
		return servhotelroomviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServHotelRoomView> findByExample2(ServHotelRoomView example, DateCompare type) {
		return servhotelroomviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> findAll() {
		return servhotelroomviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> findAll(ScrollableSettings settings) {
		return servhotelroomviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoomView> findAllScrollable(ScrollableSettings settings) {
		return servhotelroomviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServHotelRoomView findById(ScrollableSettings scrollableSettings) {
		return servhotelroomviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServHotelRoomView findById(Object key, Boolean initAll) {
		return servhotelroomviewDao.findById(key, initAll);
	}
	
	
}
