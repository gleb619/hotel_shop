package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelServHotelDocDocumentsDao;
import org.test.shop.model.domain.entity.RelServHotelDocDocuments;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelDocDocumentsService {

	@Autowired
	private RelServHotelDocDocumentsDao relservhoteldocdocumentsDao;

	@Transactional
	public RelServHotelDocDocuments create(RelServHotelDocDocuments data) {
		return relservhoteldocdocumentsDao.create(data);
	}

	@Transactional
	public RelServHotelDocDocuments update(RelServHotelDocDocuments data) {
		return relservhoteldocdocumentsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhoteldocdocumentsDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelDocDocuments data) {
		relservhoteldocdocumentsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhoteldocdocumentsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhoteldocdocumentsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhoteldocdocumentsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> namedFilter(ScrollableSettings settings) {
		return relservhoteldocdocumentsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> search(ScrollableSettings settings){
		return  relservhoteldocdocumentsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> findByExample(RelServHotelDocDocuments example, String delimitter, ScrollableSettings settings) {
		return relservhoteldocdocumentsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> findByExample2(RelServHotelDocDocuments example, DateCompare type) {
		return relservhoteldocdocumentsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> findAll() {
		return relservhoteldocdocumentsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> findAll(ScrollableSettings settings) {
		return relservhoteldocdocumentsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocuments> findAllScrollable(ScrollableSettings settings) {
		return relservhoteldocdocumentsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelDocDocuments findById(ScrollableSettings scrollableSettings) {
		return relservhoteldocdocumentsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelDocDocuments findById(Object key, Boolean initAll) {
		return relservhoteldocdocumentsDao.findById(key, initAll);
	}
	
	
}
