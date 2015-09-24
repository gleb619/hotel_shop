package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelServHotelImageDao;
import org.test.shop.model.domain.entity.RelServHotelImage;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelImageService {

	@Autowired
	private RelServHotelImageDao relservhotelimageDao;

	@Transactional
	public RelServHotelImage create(RelServHotelImage data) {
		return relservhotelimageDao.create(data);
	}

	@Transactional
	public RelServHotelImage update(RelServHotelImage data) {
		return relservhotelimageDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelimageDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelImage data) {
		relservhotelimageDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelimageDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelimageDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelimageDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> namedFilter(ScrollableSettings settings) {
		return relservhotelimageDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> search(ScrollableSettings settings){
		return  relservhotelimageDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> findByExample(RelServHotelImage example, String delimitter, ScrollableSettings settings) {
		return relservhotelimageDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelImage> findByExample2(RelServHotelImage example, DateCompare type) {
		return relservhotelimageDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> findAll() {
		return relservhotelimageDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> findAll(ScrollableSettings settings) {
		return relservhotelimageDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImage> findAllScrollable(ScrollableSettings settings) {
		return relservhotelimageDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelImage findById(ScrollableSettings scrollableSettings) {
		return relservhotelimageDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelImage findById(Object key, Boolean initAll) {
		return relservhotelimageDao.findById(key, initAll);
	}
	
	
}
