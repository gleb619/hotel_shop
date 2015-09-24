package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ServHotelDao;
import org.test.shop.model.domain.entity.ServHotel;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServHotelService {

	@Autowired
	private ServHotelDao servhotelDao;

	@Transactional
	public ServHotel create(ServHotel data) {
		return servhotelDao.create(data);
	}

	@Transactional
	public ServHotel update(ServHotel data) {
		return servhotelDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servhotelDao.delete(id);
	}

	@Transactional
	public void popularity(ServHotel data) {
		servhotelDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servhotelDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servhotelDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servhotelDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotel> namedFilter(ScrollableSettings settings) {
		return servhotelDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotel> search(ScrollableSettings settings){
		return  servhotelDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotel> findByExample(ServHotel example, String delimitter, ScrollableSettings settings) {
		return servhotelDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServHotel> findByExample2(ServHotel example, DateCompare type) {
		return servhotelDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServHotel> findAll() {
		return servhotelDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServHotel> findAll(ScrollableSettings settings) {
		return servhotelDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotel> findAllScrollable(ScrollableSettings settings) {
		return servhotelDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServHotel findById(ScrollableSettings scrollableSettings) {
		return servhotelDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServHotel findById(Object key, Boolean initAll) {
		return servhotelDao.findById(key, initAll);
	}
	
	
}
