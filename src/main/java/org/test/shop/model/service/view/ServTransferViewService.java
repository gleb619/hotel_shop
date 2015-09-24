package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServTransferViewDao;
import org.test.shop.model.domain.entity.view.ServTransferView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferViewService {

	@Autowired
	private ServTransferViewDao servtransferviewDao;

	@Transactional
	public ServTransferView create(ServTransferView data) {
		return servtransferviewDao.create(data);
	}

	@Transactional
	public ServTransferView update(ServTransferView data) {
		return servtransferviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransferView data) {
		servtransferviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> namedFilter(ScrollableSettings settings) {
		return servtransferviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> search(ScrollableSettings settings){
		return  servtransferviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> findByExample(ServTransferView example, String delimitter, ScrollableSettings settings) {
		return servtransferviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransferView> findByExample2(ServTransferView example, DateCompare type) {
		return servtransferviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> findAll() {
		return servtransferviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> findAll(ScrollableSettings settings) {
		return servtransferviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferView> findAllScrollable(ScrollableSettings settings) {
		return servtransferviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransferView findById(ScrollableSettings scrollableSettings) {
		return servtransferviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransferView findById(Object key, Boolean initAll) {
		return servtransferviewDao.findById(key, initAll);
	}
	
	
}
