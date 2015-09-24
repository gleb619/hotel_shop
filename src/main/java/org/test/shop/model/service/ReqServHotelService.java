package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.ReqServHotelDao;
import org.test.shop.model.domain.entity.ReqServHotel;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ReqServHotelService {

	@Autowired
	private ReqServHotelDao reqservhotelDao;

	@Transactional
	public ReqServHotel create(ReqServHotel data) {
		return reqservhotelDao.create(data);
	}

	@Transactional
	public ReqServHotel update(ReqServHotel data) {
		return reqservhotelDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reqservhotelDao.delete(id);
	}

	@Transactional
	public void popularity(ReqServHotel data) {
		reqservhotelDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reqservhotelDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reqservhotelDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reqservhotelDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> namedFilter(ScrollableSettings settings) {
		return reqservhotelDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> search(ScrollableSettings settings){
		return  reqservhotelDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> findByExample(ReqServHotel example, String delimitter, ScrollableSettings settings) {
		return reqservhotelDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ReqServHotel> findByExample2(ReqServHotel example, DateCompare type) {
		return reqservhotelDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> findAll() {
		return reqservhotelDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> findAll(ScrollableSettings settings) {
		return reqservhotelDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotel> findAllScrollable(ScrollableSettings settings) {
		return reqservhotelDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ReqServHotel findById(ScrollableSettings scrollableSettings) {
		return reqservhotelDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ReqServHotel findById(Object key, Boolean initAll) {
		return reqservhotelDao.findById(key, initAll);
	}
	
	
}
