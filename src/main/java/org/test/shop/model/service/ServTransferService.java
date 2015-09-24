package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ServTransferDao;
import org.test.shop.model.domain.entity.ServTransfer;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferService {

	@Autowired
	private ServTransferDao servtransferDao;

	@Transactional
	public ServTransfer create(ServTransfer data) {
		return servtransferDao.create(data);
	}

	@Transactional
	public ServTransfer update(ServTransfer data) {
		return servtransferDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransfer data) {
		servtransferDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> namedFilter(ScrollableSettings settings) {
		return servtransferDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> search(ScrollableSettings settings){
		return  servtransferDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> findByExample(ServTransfer example, String delimitter, ScrollableSettings settings) {
		return servtransferDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransfer> findByExample2(ServTransfer example, DateCompare type) {
		return servtransferDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> findAll() {
		return servtransferDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> findAll(ScrollableSettings settings) {
		return servtransferDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransfer> findAllScrollable(ScrollableSettings settings) {
		return servtransferDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransfer findById(ScrollableSettings scrollableSettings) {
		return servtransferDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransfer findById(Object key, Boolean initAll) {
		return servtransferDao.findById(key, initAll);
	}
	
	
}
