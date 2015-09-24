package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmImageViewDao;
import org.test.shop.model.domain.entity.view.TmImageView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmImageViewService {

	@Autowired
	private TmImageViewDao tmimageviewDao;

	@Transactional
	public TmImageView create(TmImageView data) {
		return tmimageviewDao.create(data);
	}

	@Transactional
	public TmImageView update(TmImageView data) {
		return tmimageviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmimageviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmImageView data) {
		tmimageviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmimageviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmimageviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmimageviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImageView> namedFilter(ScrollableSettings settings) {
		return tmimageviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImageView> search(ScrollableSettings settings){
		return  tmimageviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImageView> findByExample(TmImageView example, String delimitter, ScrollableSettings settings) {
		return tmimageviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmImageView> findByExample2(TmImageView example, DateCompare type) {
		return tmimageviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmImageView> findAll() {
		return tmimageviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmImageView> findAll(ScrollableSettings settings) {
		return tmimageviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmImageView> findAllScrollable(ScrollableSettings settings) {
		return tmimageviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmImageView findById(ScrollableSettings scrollableSettings) {
		return tmimageviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmImageView findById(Object key, Boolean initAll) {
		return tmimageviewDao.findById(key, initAll);
	}
	
	
}
