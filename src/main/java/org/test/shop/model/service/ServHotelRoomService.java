package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ServHotelRoomDao;
import org.test.shop.model.domain.entity.ServHotelRoom;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServHotelRoomService {

	@Autowired
	private ServHotelRoomDao servhotelroomDao;

	@Transactional
	public ServHotelRoom create(ServHotelRoom data) {
		return servhotelroomDao.create(data);
	}

	@Transactional
	public ServHotelRoom update(ServHotelRoom data) {
		return servhotelroomDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servhotelroomDao.delete(id);
	}

	@Transactional
	public void popularity(ServHotelRoom data) {
		servhotelroomDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servhotelroomDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servhotelroomDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servhotelroomDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> namedFilter(ScrollableSettings settings) {
		return servhotelroomDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> search(ScrollableSettings settings){
		return  servhotelroomDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> findByExample(ServHotelRoom example, String delimitter, ScrollableSettings settings) {
		return servhotelroomDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServHotelRoom> findByExample2(ServHotelRoom example, DateCompare type) {
		return servhotelroomDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> findAll() {
		return servhotelroomDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> findAll(ScrollableSettings settings) {
		return servhotelroomDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelRoom> findAllScrollable(ScrollableSettings settings) {
		return servhotelroomDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServHotelRoom findById(ScrollableSettings scrollableSettings) {
		return servhotelroomDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServHotelRoom findById(Object key, Boolean initAll) {
		return servhotelroomDao.findById(key, initAll);
	}
	
	
}
