package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopHotelRoomImagesViewDao;
import org.test.shop.model.domain.entity.view.ShopHotelRoomImagesView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopHotelRoomImagesViewService {

	@Autowired
	private ShopHotelRoomImagesViewDao shophotelroomimagesviewDao;

	@Transactional
	public ShopHotelRoomImagesView create(ShopHotelRoomImagesView data) {
		return shophotelroomimagesviewDao.create(data);
	}

	@Transactional
	public ShopHotelRoomImagesView update(ShopHotelRoomImagesView data) {
		return shophotelroomimagesviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shophotelroomimagesviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopHotelRoomImagesView data) {
		shophotelroomimagesviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shophotelroomimagesviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shophotelroomimagesviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shophotelroomimagesviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> namedFilter(ScrollableSettings settings) {
		return shophotelroomimagesviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> search(ScrollableSettings settings){
		return  shophotelroomimagesviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> findByExample(ShopHotelRoomImagesView example, String delimitter, ScrollableSettings settings) {
		return shophotelroomimagesviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> findByExample2(ShopHotelRoomImagesView example, DateCompare type) {
		return shophotelroomimagesviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> findAll() {
		return shophotelroomimagesviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> findAll(ScrollableSettings settings) {
		return shophotelroomimagesviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelRoomImagesView> findAllScrollable(ScrollableSettings settings) {
		return shophotelroomimagesviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopHotelRoomImagesView findById(ScrollableSettings scrollableSettings) {
		return shophotelroomimagesviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopHotelRoomImagesView findById(Object key, Boolean initAll) {
		return shophotelroomimagesviewDao.findById(key, initAll);
	}
	
	
}
