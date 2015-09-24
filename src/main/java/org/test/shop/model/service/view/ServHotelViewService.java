package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServHotelViewDao;
import org.test.shop.model.domain.entity.view.ServHotelView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServHotelViewService {

	@Autowired
	private ServHotelViewDao servhotelviewDao;

	@Transactional
	public ServHotelView create(ServHotelView data) {
		return servhotelviewDao.create(data);
	}

	@Transactional
	public ServHotelView update(ServHotelView data) {
		return servhotelviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servhotelviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServHotelView data) {
		servhotelviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servhotelviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servhotelviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servhotelviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> namedFilter(ScrollableSettings settings) {
		return servhotelviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> search(ScrollableSettings settings){
		return  servhotelviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> findByExample(ServHotelView example, String delimitter, ScrollableSettings settings) {
		return servhotelviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServHotelView> findByExample2(ServHotelView example, DateCompare type) {
		return servhotelviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> findAll() {
		return servhotelviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> findAll(ScrollableSettings settings) {
		return servhotelviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelView> findAllScrollable(ScrollableSettings settings) {
		return servhotelviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServHotelView findById(ScrollableSettings scrollableSettings) {
		return servhotelviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServHotelView findById(Object key, Boolean initAll) {
		return servhotelviewDao.findById(key, initAll);
	}
	
	
}
