package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmUserInfoDao;
import org.test.shop.model.domain.entity.TmUserInfo;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmUserInfoService {

	@Autowired
	private TmUserInfoDao tmuserinfoDao;

	@Transactional
	public TmUserInfo create(TmUserInfo data) {
		return tmuserinfoDao.create(data);
	}

	@Transactional
	public TmUserInfo update(TmUserInfo data) {
		return tmuserinfoDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmuserinfoDao.delete(id);
	}

	@Transactional
	public void popularity(TmUserInfo data) {
		tmuserinfoDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmuserinfoDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmuserinfoDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmuserinfoDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> namedFilter(ScrollableSettings settings) {
		return tmuserinfoDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> search(ScrollableSettings settings){
		return  tmuserinfoDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> findByExample(TmUserInfo example, String delimitter, ScrollableSettings settings) {
		return tmuserinfoDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmUserInfo> findByExample2(TmUserInfo example, DateCompare type) {
		return tmuserinfoDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> findAll() {
		return tmuserinfoDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> findAll(ScrollableSettings settings) {
		return tmuserinfoDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmUserInfo> findAllScrollable(ScrollableSettings settings) {
		return tmuserinfoDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmUserInfo findById(ScrollableSettings scrollableSettings) {
		return tmuserinfoDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmUserInfo findById(Object key, Boolean initAll) {
		return tmuserinfoDao.findById(key, initAll);
	}
	
	
}
