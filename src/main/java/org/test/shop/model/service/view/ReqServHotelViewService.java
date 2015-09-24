package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ReqServHotelViewDao;
import org.test.shop.model.domain.entity.view.ReqServHotelView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ReqServHotelViewService {

	@Autowired
	private ReqServHotelViewDao reqservhotelviewDao;

	@Transactional
	public ReqServHotelView create(ReqServHotelView data) {
		return reqservhotelviewDao.create(data);
	}

	@Transactional
	public ReqServHotelView update(ReqServHotelView data) {
		return reqservhotelviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reqservhotelviewDao.delete(id);
	}

	@Transactional
	public void popularity(ReqServHotelView data) {
		reqservhotelviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reqservhotelviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reqservhotelviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reqservhotelviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> namedFilter(ScrollableSettings settings) {
		return reqservhotelviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> search(ScrollableSettings settings){
		return  reqservhotelviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> findByExample(ReqServHotelView example, String delimitter, ScrollableSettings settings) {
		return reqservhotelviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ReqServHotelView> findByExample2(ReqServHotelView example, DateCompare type) {
		return reqservhotelviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> findAll() {
		return reqservhotelviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> findAll(ScrollableSettings settings) {
		return reqservhotelviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelView> findAllScrollable(ScrollableSettings settings) {
		return reqservhotelviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ReqServHotelView findById(ScrollableSettings scrollableSettings) {
		return reqservhotelviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ReqServHotelView findById(Object key, Boolean initAll) {
		return reqservhotelviewDao.findById(key, initAll);
	}
	
	
}
