package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.LocationCountriesViewDao;
import org.test.shop.model.domain.entity.view.LocationCountriesView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationCountriesViewService {

	@Autowired
	private LocationCountriesViewDao locationcountriesviewDao;

	@Transactional
	public LocationCountriesView create(LocationCountriesView data) {
		return locationcountriesviewDao.create(data);
	}

	@Transactional
	public LocationCountriesView update(LocationCountriesView data) {
		return locationcountriesviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationcountriesviewDao.delete(id);
	}

	@Transactional
	public void popularity(LocationCountriesView data) {
		locationcountriesviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationcountriesviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationcountriesviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationcountriesviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> namedFilter(ScrollableSettings settings) {
		return locationcountriesviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> search(ScrollableSettings settings){
		return  locationcountriesviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> findByExample(LocationCountriesView example, String delimitter, ScrollableSettings settings) {
		return locationcountriesviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationCountriesView> findByExample2(LocationCountriesView example, DateCompare type) {
		return locationcountriesviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> findAll() {
		return locationcountriesviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> findAll(ScrollableSettings settings) {
		return locationcountriesviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCountriesView> findAllScrollable(ScrollableSettings settings) {
		return locationcountriesviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationCountriesView findById(ScrollableSettings scrollableSettings) {
		return locationcountriesviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationCountriesView findById(Object key, Boolean initAll) {
		return locationcountriesviewDao.findById(key, initAll);
	}
	
	
}
