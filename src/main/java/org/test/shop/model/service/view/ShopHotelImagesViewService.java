package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopHotelImagesViewDao;
import org.test.shop.model.domain.entity.view.ShopHotelImagesView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopHotelImagesViewService {

	@Autowired
	private ShopHotelImagesViewDao shophotelimagesviewDao;

	@Transactional
	public ShopHotelImagesView create(ShopHotelImagesView data) {
		return shophotelimagesviewDao.create(data);
	}

	@Transactional
	public ShopHotelImagesView update(ShopHotelImagesView data) {
		return shophotelimagesviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shophotelimagesviewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopHotelImagesView data) {
		shophotelimagesviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shophotelimagesviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shophotelimagesviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shophotelimagesviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> namedFilter(ScrollableSettings settings) {
		return shophotelimagesviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> search(ScrollableSettings settings){
		return  shophotelimagesviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> findByExample(ShopHotelImagesView example, String delimitter, ScrollableSettings settings) {
		return shophotelimagesviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> findByExample2(ShopHotelImagesView example, DateCompare type) {
		return shophotelimagesviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> findAll() {
		return shophotelimagesviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> findAll(ScrollableSettings settings) {
		return shophotelimagesviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopHotelImagesView> findAllScrollable(ScrollableSettings settings) {
		return shophotelimagesviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopHotelImagesView findById(ScrollableSettings scrollableSettings) {
		return shophotelimagesviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopHotelImagesView findById(Object key, Boolean initAll) {
		return shophotelimagesviewDao.findById(key, initAll);
	}
	
	
}
