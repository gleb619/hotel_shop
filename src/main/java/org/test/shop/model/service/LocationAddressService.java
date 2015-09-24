package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.LocationAddressDao;
import org.test.shop.model.domain.entity.LocationAddress;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationAddressService {

	@Autowired
	private LocationAddressDao locationaddressDao;

	@Transactional
	public LocationAddress create(LocationAddress data) {
		return locationaddressDao.create(data);
	}

	@Transactional
	public LocationAddress update(LocationAddress data) {
		return locationaddressDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationaddressDao.delete(id);
	}

	@Transactional
	public void popularity(LocationAddress data) {
		locationaddressDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationaddressDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationaddressDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationaddressDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> namedFilter(ScrollableSettings settings) {
		return locationaddressDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> search(ScrollableSettings settings){
		return  locationaddressDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> findByExample(LocationAddress example, String delimitter, ScrollableSettings settings) {
		return locationaddressDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationAddress> findByExample2(LocationAddress example, DateCompare type) {
		return locationaddressDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> findAll() {
		return locationaddressDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> findAll(ScrollableSettings settings) {
		return locationaddressDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddress> findAllScrollable(ScrollableSettings settings) {
		return locationaddressDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationAddress findById(ScrollableSettings scrollableSettings) {
		return locationaddressDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationAddress findById(Object key, Boolean initAll) {
		return locationaddressDao.findById(key, initAll);
	}
	
	
}
