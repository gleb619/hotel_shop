package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.LocationCountriesDao;
import org.test.shop.model.domain.entity.LocationCountries;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationCountriesService {

	@Autowired
	private LocationCountriesDao locationcountriesDao;

	@Transactional
	public LocationCountries create(LocationCountries data) {
		return locationcountriesDao.create(data);
	}

	@Transactional
	public LocationCountries update(LocationCountries data) {
		return locationcountriesDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationcountriesDao.delete(id);
	}

	@Transactional
	public void popularity(LocationCountries data) {
		locationcountriesDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationcountriesDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationcountriesDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationcountriesDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> namedFilter(ScrollableSettings settings) {
		return locationcountriesDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> search(ScrollableSettings settings){
		return  locationcountriesDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> findByExample(LocationCountries example, String delimitter, ScrollableSettings settings) {
		return locationcountriesDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationCountries> findByExample2(LocationCountries example, DateCompare type) {
		return locationcountriesDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> findAll() {
		return locationcountriesDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> findAll(ScrollableSettings settings) {
		return locationcountriesDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountries> findAllScrollable(ScrollableSettings settings) {
		return locationcountriesDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationCountries findById(ScrollableSettings scrollableSettings) {
		return locationcountriesDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationCountries findById(Object key, Boolean initAll) {
		return locationcountriesDao.findById(key, initAll);
	}
	
	
}
