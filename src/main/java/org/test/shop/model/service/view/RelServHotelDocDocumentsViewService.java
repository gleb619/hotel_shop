package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServHotelDocDocumentsViewDao;
import org.test.shop.model.domain.entity.view.RelServHotelDocDocumentsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelDocDocumentsViewService {

	@Autowired
	private RelServHotelDocDocumentsViewDao relservhoteldocdocumentsviewDao;

	@Transactional
	public RelServHotelDocDocumentsView create(RelServHotelDocDocumentsView data) {
		return relservhoteldocdocumentsviewDao.create(data);
	}

	@Transactional
	public RelServHotelDocDocumentsView update(RelServHotelDocDocumentsView data) {
		return relservhoteldocdocumentsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhoteldocdocumentsviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelDocDocumentsView data) {
		relservhoteldocdocumentsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhoteldocdocumentsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhoteldocdocumentsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhoteldocdocumentsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> namedFilter(ScrollableSettings settings) {
		return relservhoteldocdocumentsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> search(ScrollableSettings settings){
		return  relservhoteldocdocumentsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> findByExample(RelServHotelDocDocumentsView example, String delimitter, ScrollableSettings settings) {
		return relservhoteldocdocumentsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> findByExample2(RelServHotelDocDocumentsView example, DateCompare type) {
		return relservhoteldocdocumentsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> findAll() {
		return relservhoteldocdocumentsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> findAll(ScrollableSettings settings) {
		return relservhoteldocdocumentsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelDocDocumentsView> findAllScrollable(ScrollableSettings settings) {
		return relservhoteldocdocumentsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelDocDocumentsView findById(ScrollableSettings scrollableSettings) {
		return relservhoteldocdocumentsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelDocDocumentsView findById(Object key, Boolean initAll) {
		return relservhoteldocdocumentsviewDao.findById(key, initAll);
	}
	
	
}
