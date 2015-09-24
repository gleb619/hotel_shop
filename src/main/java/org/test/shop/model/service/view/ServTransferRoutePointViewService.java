package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServTransferRoutePointViewDao;
import org.test.shop.model.domain.entity.view.ServTransferRoutePointView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferRoutePointViewService {

	@Autowired
	private ServTransferRoutePointViewDao servtransferroutepointviewDao;

	@Transactional
	public ServTransferRoutePointView create(ServTransferRoutePointView data) {
		return servtransferroutepointviewDao.create(data);
	}

	@Transactional
	public ServTransferRoutePointView update(ServTransferRoutePointView data) {
		return servtransferroutepointviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferroutepointviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransferRoutePointView data) {
		servtransferroutepointviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferroutepointviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferroutepointviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferroutepointviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> namedFilter(ScrollableSettings settings) {
		return servtransferroutepointviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> search(ScrollableSettings settings){
		return  servtransferroutepointviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> findByExample(ServTransferRoutePointView example, String delimitter, ScrollableSettings settings) {
		return servtransferroutepointviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> findByExample2(ServTransferRoutePointView example, DateCompare type) {
		return servtransferroutepointviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> findAll() {
		return servtransferroutepointviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> findAll(ScrollableSettings settings) {
		return servtransferroutepointviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoutePointView> findAllScrollable(ScrollableSettings settings) {
		return servtransferroutepointviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransferRoutePointView findById(ScrollableSettings scrollableSettings) {
		return servtransferroutepointviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransferRoutePointView findById(Object key, Boolean initAll) {
		return servtransferroutepointviewDao.findById(key, initAll);
	}
	
	
}
