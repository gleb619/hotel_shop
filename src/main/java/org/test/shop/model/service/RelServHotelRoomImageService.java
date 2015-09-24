package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelServHotelRoomImageDao;
import org.test.shop.model.domain.entity.RelServHotelRoomImage;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelRoomImageService {

	@Autowired
	private RelServHotelRoomImageDao relservhotelroomimageDao;

	@Transactional
	public RelServHotelRoomImage create(RelServHotelRoomImage data) {
		return relservhotelroomimageDao.create(data);
	}

	@Transactional
	public RelServHotelRoomImage update(RelServHotelRoomImage data) {
		return relservhotelroomimageDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelroomimageDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelRoomImage data) {
		relservhotelroomimageDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelroomimageDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelroomimageDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelroomimageDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> namedFilter(ScrollableSettings settings) {
		return relservhotelroomimageDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> search(ScrollableSettings settings){
		return  relservhotelroomimageDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> findByExample(RelServHotelRoomImage example, String delimitter, ScrollableSettings settings) {
		return relservhotelroomimageDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> findByExample2(RelServHotelRoomImage example, DateCompare type) {
		return relservhotelroomimageDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> findAll() {
		return relservhotelroomimageDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> findAll(ScrollableSettings settings) {
		return relservhotelroomimageDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImage> findAllScrollable(ScrollableSettings settings) {
		return relservhotelroomimageDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelRoomImage findById(ScrollableSettings scrollableSettings) {
		return relservhotelroomimageDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelRoomImage findById(Object key, Boolean initAll) {
		return relservhotelroomimageDao.findById(key, initAll);
	}
	
	
}
