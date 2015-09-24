package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ReqServHotelOpenViewDao;
import org.test.shop.model.domain.entity.view.ReqServHotelOpenView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ReqServHotelOpenViewService {

	@Autowired
	private ReqServHotelOpenViewDao reqservhotelopenviewDao;

	@Transactional
	public ReqServHotelOpenView create(ReqServHotelOpenView data) {
		return reqservhotelopenviewDao.create(data);
	}

	@Transactional
	public ReqServHotelOpenView update(ReqServHotelOpenView data) {
		return reqservhotelopenviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reqservhotelopenviewDao.delete(id);
	}

	@Transactional
	public void popularity(ReqServHotelOpenView data) {
		reqservhotelopenviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reqservhotelopenviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reqservhotelopenviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reqservhotelopenviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> namedFilter(ScrollableSettings settings) {
		return reqservhotelopenviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> search(ScrollableSettings settings){
		return  reqservhotelopenviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> findByExample(ReqServHotelOpenView example, String delimitter, ScrollableSettings settings) {
		return reqservhotelopenviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> findByExample2(ReqServHotelOpenView example, DateCompare type) {
		return reqservhotelopenviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> findAll() {
		return reqservhotelopenviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> findAll(ScrollableSettings settings) {
		return reqservhotelopenviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelOpenView> findAllScrollable(ScrollableSettings settings) {
		return reqservhotelopenviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ReqServHotelOpenView findById(ScrollableSettings scrollableSettings) {
		return reqservhotelopenviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ReqServHotelOpenView findById(Object key, Boolean initAll) {
		return reqservhotelopenviewDao.findById(key, initAll);
	}
	
	
}
