package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ReqServHotelArchivedViewDao;
import org.test.shop.model.domain.entity.view.ReqServHotelArchivedView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ReqServHotelArchivedViewService {

	@Autowired
	private ReqServHotelArchivedViewDao reqservhotelarchivedviewDao;

	@Transactional
	public ReqServHotelArchivedView create(ReqServHotelArchivedView data) {
		return reqservhotelarchivedviewDao.create(data);
	}

	@Transactional
	public ReqServHotelArchivedView update(ReqServHotelArchivedView data) {
		return reqservhotelarchivedviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reqservhotelarchivedviewDao.delete(id);
	}

	@Transactional
	public void popularity(ReqServHotelArchivedView data) {
		reqservhotelarchivedviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reqservhotelarchivedviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reqservhotelarchivedviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reqservhotelarchivedviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> namedFilter(ScrollableSettings settings) {
		return reqservhotelarchivedviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> search(ScrollableSettings settings){
		return  reqservhotelarchivedviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> findByExample(ReqServHotelArchivedView example, String delimitter, ScrollableSettings settings) {
		return reqservhotelarchivedviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> findByExample2(ReqServHotelArchivedView example, DateCompare type) {
		return reqservhotelarchivedviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> findAll() {
		return reqservhotelarchivedviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> findAll(ScrollableSettings settings) {
		return reqservhotelarchivedviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ReqServHotelArchivedView> findAllScrollable(ScrollableSettings settings) {
		return reqservhotelarchivedviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ReqServHotelArchivedView findById(ScrollableSettings scrollableSettings) {
		return reqservhotelarchivedviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ReqServHotelArchivedView findById(Object key, Boolean initAll) {
		return reqservhotelarchivedviewDao.findById(key, initAll);
	}
	
	
}
