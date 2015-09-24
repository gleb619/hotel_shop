package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ServTransferRouteDao;
import org.test.shop.model.domain.entity.ServTransferRoute;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferRouteService {

	@Autowired
	private ServTransferRouteDao servtransferrouteDao;

	@Transactional
	public ServTransferRoute create(ServTransferRoute data) {
		return servtransferrouteDao.create(data);
	}

	@Transactional
	public ServTransferRoute update(ServTransferRoute data) {
		return servtransferrouteDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferrouteDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransferRoute data) {
		servtransferrouteDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferrouteDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferrouteDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferrouteDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> namedFilter(ScrollableSettings settings) {
		return servtransferrouteDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> search(ScrollableSettings settings){
		return  servtransferrouteDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> findByExample(ServTransferRoute example, String delimitter, ScrollableSettings settings) {
		return servtransferrouteDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransferRoute> findByExample2(ServTransferRoute example, DateCompare type) {
		return servtransferrouteDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> findAll() {
		return servtransferrouteDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> findAll(ScrollableSettings settings) {
		return servtransferrouteDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRoute> findAllScrollable(ScrollableSettings settings) {
		return servtransferrouteDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransferRoute findById(ScrollableSettings scrollableSettings) {
		return servtransferrouteDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransferRoute findById(Object key, Boolean initAll) {
		return servtransferrouteDao.findById(key, initAll);
	}
	
	
}
