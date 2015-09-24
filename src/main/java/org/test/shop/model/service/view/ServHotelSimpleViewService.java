package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ServHotelSimpleViewDao;
import org.test.shop.model.domain.entity.view.ServHotelSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ServHotelSimpleViewService {

	@Autowired
	private ServHotelSimpleViewDao servhotelsimpleviewDao;

	@Transactional
	public ServHotelSimpleView create(ServHotelSimpleView data) {
		return servhotelsimpleviewDao.create(data);
	}

	@Transactional
	public ServHotelSimpleView update(ServHotelSimpleView data) {
		return servhotelsimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return servhotelsimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(ServHotelSimpleView data) {
		servhotelsimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		servhotelsimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return servhotelsimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return servhotelsimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> namedFilter(ScrollableSettings settings) {
		return servhotelsimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> search(ScrollableSettings settings){
		return  servhotelsimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> findByExample(ServHotelSimpleView example, String delimitter, ScrollableSettings settings) {
		return servhotelsimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> findByExample2(ServHotelSimpleView example, DateCompare type) {
		return servhotelsimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> findAll() {
		return servhotelsimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> findAll(ScrollableSettings settings) {
		return servhotelsimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ServHotelSimpleView> findAllScrollable(ScrollableSettings settings) {
		return servhotelsimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ServHotelSimpleView findById(ScrollableSettings scrollableSettings) {
		return servhotelsimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ServHotelSimpleView findById(Object key, Boolean initAll) {
		return servhotelsimpleviewDao.findById(key, initAll);
	}
	
	
}
