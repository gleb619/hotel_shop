package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.CurrCourseViewDao;
import org.test.shop.model.domain.entity.view.CurrCourseView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class CurrCourseViewService {

	@Autowired
	private CurrCourseViewDao currcourseviewDao;

	@Transactional
	public CurrCourseView create(CurrCourseView data) {
		return currcourseviewDao.create(data);
	}

	@Transactional
	public CurrCourseView update(CurrCourseView data) {
		return currcourseviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return currcourseviewDao.delete(id);
	}

	@Transactional
	public void popularity(CurrCourseView data) {
		currcourseviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		currcourseviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return currcourseviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return currcourseviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> namedFilter(ScrollableSettings settings) {
		return currcourseviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> search(ScrollableSettings settings){
		return  currcourseviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> findByExample(CurrCourseView example, String delimitter, ScrollableSettings settings) {
		return currcourseviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<CurrCourseView> findByExample2(CurrCourseView example, DateCompare type) {
		return currcourseviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> findAll() {
		return currcourseviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> findAll(ScrollableSettings settings) {
		return currcourseviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCourseView> findAllScrollable(ScrollableSettings settings) {
		return currcourseviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public CurrCourseView findById(ScrollableSettings scrollableSettings) {
		return currcourseviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public CurrCourseView findById(Object key, Boolean initAll) {
		return currcourseviewDao.findById(key, initAll);
	}
	
	
}
