package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.CurrCourseDao;
import org.test.shop.model.domain.entity.CurrCourse;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class CurrCourseService {

	@Autowired
	private CurrCourseDao currcourseDao;

	@Transactional
	public CurrCourse create(CurrCourse data) {
		return currcourseDao.create(data);
	}

	@Transactional
	public CurrCourse update(CurrCourse data) {
		return currcourseDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return currcourseDao.delete(id);
	}

	@Transactional
	public void popularity(CurrCourse data) {
		currcourseDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		currcourseDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return currcourseDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return currcourseDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> namedFilter(ScrollableSettings settings) {
		return currcourseDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> search(ScrollableSettings settings){
		return  currcourseDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> findByExample(CurrCourse example, String delimitter, ScrollableSettings settings) {
		return currcourseDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<CurrCourse> findByExample2(CurrCourse example, DateCompare type) {
		return currcourseDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> findAll() {
		return currcourseDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> findAll(ScrollableSettings settings) {
		return currcourseDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourse> findAllScrollable(ScrollableSettings settings) {
		return currcourseDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public CurrCourse findById(ScrollableSettings scrollableSettings) {
		return currcourseDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public CurrCourse findById(Object key, Boolean initAll) {
		return currcourseDao.findById(key, initAll);
	}
	
	
}
