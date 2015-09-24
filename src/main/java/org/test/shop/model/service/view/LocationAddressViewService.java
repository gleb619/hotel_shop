package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.LocationAddressViewDao;
import org.test.shop.model.domain.entity.view.LocationAddressView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class LocationAddressViewService {

	@Autowired
	private LocationAddressViewDao locationaddressviewDao;

	@Transactional
	public LocationAddressView create(LocationAddressView data) {
		return locationaddressviewDao.create(data);
	}

	@Transactional
	public LocationAddressView update(LocationAddressView data) {
		return locationaddressviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return locationaddressviewDao.delete(id);
	}

	@Transactional
	public void popularity(LocationAddressView data) {
		locationaddressviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		locationaddressviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return locationaddressviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return locationaddressviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> namedFilter(ScrollableSettings settings) {
		return locationaddressviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> search(ScrollableSettings settings){
		return  locationaddressviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> findByExample(LocationAddressView example, String delimitter, ScrollableSettings settings) {
		return locationaddressviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<LocationAddressView> findByExample2(LocationAddressView example, DateCompare type) {
		return locationaddressviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> findAll() {
		return locationaddressviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> findAll(ScrollableSettings settings) {
		return locationaddressviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<LocationAddressView> findAllScrollable(ScrollableSettings settings) {
		return locationaddressviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public LocationAddressView findById(ScrollableSettings scrollableSettings) {
		return locationaddressviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public LocationAddressView findById(Object key, Boolean initAll) {
		return locationaddressviewDao.findById(key, initAll);
	}
	
	
}
