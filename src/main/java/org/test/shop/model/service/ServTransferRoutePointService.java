package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ServTransferRoutePointDao;
import org.test.shop.model.domain.entity.ServTransferRoutePoint;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferRoutePointService {

	@Autowired
	private ServTransferRoutePointDao servtransferroutepointDao;

	@Transactional
	public ServTransferRoutePoint create(ServTransferRoutePoint data) {
		return servtransferroutepointDao.create(data);
	}

	@Transactional
	public ServTransferRoutePoint update(ServTransferRoutePoint data) {
		return servtransferroutepointDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferroutepointDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransferRoutePoint data) {
		servtransferroutepointDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferroutepointDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferroutepointDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferroutepointDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> namedFilter(ScrollableSettings settings) {
		return servtransferroutepointDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> search(ScrollableSettings settings){
		return  servtransferroutepointDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> findByExample(ServTransferRoutePoint example, String delimitter, ScrollableSettings settings) {
		return servtransferroutepointDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> findByExample2(ServTransferRoutePoint example, DateCompare type) {
		return servtransferroutepointDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> findAll() {
		return servtransferroutepointDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> findAll(ScrollableSettings settings) {
		return servtransferroutepointDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePoint> findAllScrollable(ScrollableSettings settings) {
		return servtransferroutepointDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransferRoutePoint findById(ScrollableSettings scrollableSettings) {
		return servtransferroutepointDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransferRoutePoint findById(Object key, Boolean initAll) {
		return servtransferroutepointDao.findById(key, initAll);
	}
	
	
}
