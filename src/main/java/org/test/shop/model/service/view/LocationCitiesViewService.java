package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.LocationCitiesViewDao;
import org.test.shop.model.domain.entity.view.LocationCitiesView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationCitiesViewService {

	@Autowired
	private LocationCitiesViewDao locationcitiesviewDao;

	@Transactional
	public LocationCitiesView create(LocationCitiesView data) {
		return locationcitiesviewDao.create(data);
	}

	@Transactional
	public LocationCitiesView update(LocationCitiesView data) {
		return locationcitiesviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationcitiesviewDao.delete(id);
	}

	@Transactional
	public void popularity(LocationCitiesView data) {
		locationcitiesviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationcitiesviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationcitiesviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationcitiesviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> namedFilter(ScrollableSettings settings) {
		return locationcitiesviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> search(ScrollableSettings settings){
		return  locationcitiesviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> findByExample(LocationCitiesView example, String delimitter, ScrollableSettings settings) {
		return locationcitiesviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationCitiesView> findByExample2(LocationCitiesView example, DateCompare type) {
		return locationcitiesviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> findAll() {
		return locationcitiesviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> findAll(ScrollableSettings settings) {
		return locationcitiesviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationCitiesView> findAllScrollable(ScrollableSettings settings) {
		return locationcitiesviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationCitiesView findById(ScrollableSettings scrollableSettings) {
		return locationcitiesviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationCitiesView findById(Object key, Boolean initAll) {
		return locationcitiesviewDao.findById(key, initAll);
	}
	
	
}
