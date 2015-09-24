package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServTransferRouteViewDao;
import org.test.shop.model.domain.entity.view.ServTransferRouteView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServTransferRouteViewService {

	@Autowired
	private ServTransferRouteViewDao servtransferrouteviewDao;

	@Transactional
	public ServTransferRouteView create(ServTransferRouteView data) {
		return servtransferrouteviewDao.create(data);
	}

	@Transactional
	public ServTransferRouteView update(ServTransferRouteView data) {
		return servtransferrouteviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servtransferrouteviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServTransferRouteView data) {
		servtransferrouteviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servtransferrouteviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servtransferrouteviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servtransferrouteviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> namedFilter(ScrollableSettings settings) {
		return servtransferrouteviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> search(ScrollableSettings settings){
		return  servtransferrouteviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> findByExample(ServTransferRouteView example, String delimitter, ScrollableSettings settings) {
		return servtransferrouteviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServTransferRouteView> findByExample2(ServTransferRouteView example, DateCompare type) {
		return servtransferrouteviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> findAll() {
		return servtransferrouteviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> findAll(ScrollableSettings settings) {
		return servtransferrouteviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServTransferRouteView> findAllScrollable(ScrollableSettings settings) {
		return servtransferrouteviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServTransferRouteView findById(ScrollableSettings scrollableSettings) {
		return servtransferrouteviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServTransferRouteView findById(Object key, Boolean initAll) {
		return servtransferrouteviewDao.findById(key, initAll);
	}
	
	
}
