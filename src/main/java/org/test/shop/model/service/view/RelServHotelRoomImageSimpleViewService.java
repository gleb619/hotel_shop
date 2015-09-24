package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServHotelRoomImageSimpleViewDao;
import org.test.shop.model.domain.entity.view.RelServHotelRoomImageSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelRoomImageSimpleViewService {

	@Autowired
	private RelServHotelRoomImageSimpleViewDao relservhotelroomimagesimpleviewDao;

	@Transactional
	public RelServHotelRoomImageSimpleView create(RelServHotelRoomImageSimpleView data) {
		return relservhotelroomimagesimpleviewDao.create(data);
	}

	@Transactional
	public RelServHotelRoomImageSimpleView update(RelServHotelRoomImageSimpleView data) {
		return relservhotelroomimagesimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelroomimagesimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelRoomImageSimpleView data) {
		relservhotelroomimagesimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelroomimagesimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelroomimagesimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelroomimagesimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> namedFilter(ScrollableSettings settings) {
		return relservhotelroomimagesimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> search(ScrollableSettings settings){
		return  relservhotelroomimagesimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> findByExample(RelServHotelRoomImageSimpleView example, String delimitter, ScrollableSettings settings) {
		return relservhotelroomimagesimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> findByExample2(RelServHotelRoomImageSimpleView example, DateCompare type) {
		return relservhotelroomimagesimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> findAll() {
		return relservhotelroomimagesimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> findAll(ScrollableSettings settings) {
		return relservhotelroomimagesimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageSimpleView> findAllScrollable(ScrollableSettings settings) {
		return relservhotelroomimagesimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelRoomImageSimpleView findById(ScrollableSettings scrollableSettings) {
		return relservhotelroomimagesimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelRoomImageSimpleView findById(Object key, Boolean initAll) {
		return relservhotelroomimagesimpleviewDao.findById(key, initAll);
	}
	
	
}
