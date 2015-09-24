package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmUserInfoViewDao;
import org.test.shop.model.domain.entity.view.TmUserInfoView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmUserInfoViewService {

	@Autowired
	private TmUserInfoViewDao tmuserinfoviewDao;

	@Transactional
	public TmUserInfoView create(TmUserInfoView data) {
		return tmuserinfoviewDao.create(data);
	}

	@Transactional
	public TmUserInfoView update(TmUserInfoView data) {
		return tmuserinfoviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmuserinfoviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmUserInfoView data) {
		tmuserinfoviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmuserinfoviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmuserinfoviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmuserinfoviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> namedFilter(ScrollableSettings settings) {
		return tmuserinfoviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> search(ScrollableSettings settings){
		return  tmuserinfoviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> findByExample(TmUserInfoView example, String delimitter, ScrollableSettings settings) {
		return tmuserinfoviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmUserInfoView> findByExample2(TmUserInfoView example, DateCompare type) {
		return tmuserinfoviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> findAll() {
		return tmuserinfoviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> findAll(ScrollableSettings settings) {
		return tmuserinfoviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfoView> findAllScrollable(ScrollableSettings settings) {
		return tmuserinfoviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmUserInfoView findById(ScrollableSettings scrollableSettings) {
		return tmuserinfoviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmUserInfoView findById(Object key, Boolean initAll) {
		return tmuserinfoviewDao.findById(key, initAll);
	}
	
	
}
