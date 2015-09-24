package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ReqServHotelProcessedViewDao;
import org.test.shop.model.domain.entity.view.ReqServHotelProcessedView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ReqServHotelProcessedViewService {

	@Autowired
	private ReqServHotelProcessedViewDao reqservhotelprocessedviewDao;

	@Transactional
	public ReqServHotelProcessedView create(ReqServHotelProcessedView data) {
		return reqservhotelprocessedviewDao.create(data);
	}

	@Transactional
	public ReqServHotelProcessedView update(ReqServHotelProcessedView data) {
		return reqservhotelprocessedviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reqservhotelprocessedviewDao.delete(id);
	}

	@Transactional
	public void popularity(ReqServHotelProcessedView data) {
		reqservhotelprocessedviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reqservhotelprocessedviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reqservhotelprocessedviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reqservhotelprocessedviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> namedFilter(ScrollableSettings settings) {
		return reqservhotelprocessedviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> search(ScrollableSettings settings){
		return  reqservhotelprocessedviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> findByExample(ReqServHotelProcessedView example, String delimitter, ScrollableSettings settings) {
		return reqservhotelprocessedviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> findByExample2(ReqServHotelProcessedView example, DateCompare type) {
		return reqservhotelprocessedviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> findAll() {
		return reqservhotelprocessedviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> findAll(ScrollableSettings settings) {
		return reqservhotelprocessedviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelProcessedView> findAllScrollable(ScrollableSettings settings) {
		return reqservhotelprocessedviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ReqServHotelProcessedView findById(ScrollableSettings scrollableSettings) {
		return reqservhotelprocessedviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ReqServHotelProcessedView findById(Object key, Boolean initAll) {
		return reqservhotelprocessedviewDao.findById(key, initAll);
	}
	
	
}
