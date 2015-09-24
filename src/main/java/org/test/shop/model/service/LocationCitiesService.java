package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.LocationCitiesDao;
import org.test.shop.model.domain.entity.LocationCities;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationCitiesService {

	@Autowired
	private LocationCitiesDao locationcitiesDao;

	@Transactional
	public LocationCities create(LocationCities data) {
		return locationcitiesDao.create(data);
	}

	@Transactional
	public LocationCities update(LocationCities data) {
		return locationcitiesDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationcitiesDao.delete(id);
	}

	@Transactional
	public void popularity(LocationCities data) {
		locationcitiesDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationcitiesDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationcitiesDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationcitiesDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCities> namedFilter(ScrollableSettings settings) {
		return locationcitiesDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCities> search(ScrollableSettings settings){
		return  locationcitiesDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCities> findByExample(LocationCities example, String delimitter, ScrollableSettings settings) {
		return locationcitiesDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationCities> findByExample2(LocationCities example, DateCompare type) {
		return locationcitiesDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationCities> findAll() {
		return locationcitiesDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationCities> findAll(ScrollableSettings settings) {
		return locationcitiesDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCities> findAllScrollable(ScrollableSettings settings) {
		return locationcitiesDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationCities findById(ScrollableSettings scrollableSettings) {
		return locationcitiesDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationCities findById(Object key, Boolean initAll) {
		return locationcitiesDao.findById(key, initAll);
	}
	
	
}
