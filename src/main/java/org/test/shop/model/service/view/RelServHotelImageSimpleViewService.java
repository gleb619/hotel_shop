package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServHotelImageSimpleViewDao;
import org.test.shop.model.domain.entity.view.RelServHotelImageSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelImageSimpleViewService {

	@Autowired
	private RelServHotelImageSimpleViewDao relservhotelimagesimpleviewDao;

	@Transactional
	public RelServHotelImageSimpleView create(RelServHotelImageSimpleView data) {
		return relservhotelimagesimpleviewDao.create(data);
	}

	@Transactional
	public RelServHotelImageSimpleView update(RelServHotelImageSimpleView data) {
		return relservhotelimagesimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelimagesimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelImageSimpleView data) {
		relservhotelimagesimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelimagesimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelimagesimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelimagesimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> namedFilter(ScrollableSettings settings) {
		return relservhotelimagesimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> search(ScrollableSettings settings){
		return  relservhotelimagesimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> findByExample(RelServHotelImageSimpleView example, String delimitter, ScrollableSettings settings) {
		return relservhotelimagesimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> findByExample2(RelServHotelImageSimpleView example, DateCompare type) {
		return relservhotelimagesimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> findAll() {
		return relservhotelimagesimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> findAll(ScrollableSettings settings) {
		return relservhotelimagesimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageSimpleView> findAllScrollable(ScrollableSettings settings) {
		return relservhotelimagesimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelImageSimpleView findById(ScrollableSettings scrollableSettings) {
		return relservhotelimagesimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelImageSimpleView findById(Object key, Boolean initAll) {
		return relservhotelimagesimpleviewDao.findById(key, initAll);
	}
	
	
}
