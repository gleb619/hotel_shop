package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServHotelImageViewDao;
import org.test.shop.model.domain.entity.view.RelServHotelImageView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServHotelImageViewService {

	@Autowired
	private RelServHotelImageViewDao relservhotelimageviewDao;

	@Transactional
	public RelServHotelImageView create(RelServHotelImageView data) {
		return relservhotelimageviewDao.create(data);
	}

	@Transactional
	public RelServHotelImageView update(RelServHotelImageView data) {
		return relservhotelimageviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservhotelimageviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServHotelImageView data) {
		relservhotelimageviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservhotelimageviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservhotelimageviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservhotelimageviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> namedFilter(ScrollableSettings settings) {
		return relservhotelimageviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> search(ScrollableSettings settings){
		return  relservhotelimageviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> findByExample(RelServHotelImageView example, String delimitter, ScrollableSettings settings) {
		return relservhotelimageviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServHotelImageView> findByExample2(RelServHotelImageView example, DateCompare type) {
		return relservhotelimageviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> findAll() {
		return relservhotelimageviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> findAll(ScrollableSettings settings) {
		return relservhotelimageviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServHotelImageView> findAllScrollable(ScrollableSettings settings) {
		return relservhotelimageviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServHotelImageView findById(ScrollableSettings scrollableSettings) {
		return relservhotelimageviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServHotelImageView findById(Object key, Boolean initAll) {
		return relservhotelimageviewDao.findById(key, initAll);
	}
	
	
}
