package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServHotelRoomImageViewDao;
import org.test.shop.model.domain.entity.view.RelServHotelRoomImageView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelRoomImageViewService {

	@Autowired
	private RelServHotelRoomImageViewDao relservhotelroomimageviewDao;

	@Transactional
	public RelServHotelRoomImageView create(RelServHotelRoomImageView data) {
		return relservhotelroomimageviewDao.create(data);
	}

	@Transactional
	public RelServHotelRoomImageView update(RelServHotelRoomImageView data) {
		return relservhotelroomimageviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelroomimageviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelRoomImageView data) {
		relservhotelroomimageviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelroomimageviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelroomimageviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelroomimageviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> namedFilter(ScrollableSettings settings) {
		return relservhotelroomimageviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> search(ScrollableSettings settings){
		return  relservhotelroomimageviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> findByExample(RelServHotelRoomImageView example, String delimitter, ScrollableSettings settings) {
		return relservhotelroomimageviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> findByExample2(RelServHotelRoomImageView example, DateCompare type) {
		return relservhotelroomimageviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> findAll() {
		return relservhotelroomimageviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> findAll(ScrollableSettings settings) {
		return relservhotelroomimageviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelRoomImageView> findAllScrollable(ScrollableSettings settings) {
		return relservhotelroomimageviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelRoomImageView findById(ScrollableSettings scrollableSettings) {
		return relservhotelroomimageviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelRoomImageView findById(Object key, Boolean initAll) {
		return relservhotelroomimageviewDao.findById(key, initAll);
	}
	
	
}
