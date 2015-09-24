package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmImageDao;
import org.test.shop.model.domain.entity.TmImage;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmImageService {

	@Autowired
	private TmImageDao tmimageDao;

	@Transactional
	public TmImage create(TmImage data) {
		return tmimageDao.create(data);
	}

	@Transactional
	public TmImage update(TmImage data) {
		return tmimageDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmimageDao.delete(id);
	}

	@Transactional
	public void popularity(TmImage data) {
		tmimageDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmimageDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmimageDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmimageDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImage> namedFilter(ScrollableSettings settings) {
		return tmimageDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImage> search(ScrollableSettings settings){
		return  tmimageDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImage> findByExample(TmImage example, String delimitter, ScrollableSettings settings) {
		return tmimageDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmImage> findByExample2(TmImage example, DateCompare type) {
		return tmimageDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmImage> findAll() {
		return tmimageDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmImage> findAll(ScrollableSettings settings) {
		return tmimageDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImage> findAllScrollable(ScrollableSettings settings) {
		return tmimageDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmImage findById(ScrollableSettings scrollableSettings) {
		return tmimageDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmImage findById(Object key, Boolean initAll) {
		return tmimageDao.findById(key, initAll);
	}
	
	
}
