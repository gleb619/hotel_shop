package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.InfoPermissionDao;
import org.test.shop.model.domain.entity.InfoPermission;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class InfoPermissionService {

	@Autowired
	private InfoPermissionDao infopermissionDao;

	@Transactional
	public InfoPermission create(InfoPermission data) {
		return infopermissionDao.create(data);
	}

	@Transactional
	public InfoPermission update(InfoPermission data) {
		return infopermissionDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return infopermissionDao.delete(id);
	}

	@Transactional
	public void popularity(InfoPermission data) {
		infopermissionDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		infopermissionDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return infopermissionDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return infopermissionDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> namedFilter(ScrollableSettings settings) {
		return infopermissionDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> search(ScrollableSettings settings){
		return  infopermissionDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> findByExample(InfoPermission example, String delimitter, ScrollableSettings settings) {
		return infopermissionDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<InfoPermission> findByExample2(InfoPermission example, DateCompare type) {
		return infopermissionDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> findAll() {
		return infopermissionDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> findAll(ScrollableSettings settings) {
		return infopermissionDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermission> findAllScrollable(ScrollableSettings settings) {
		return infopermissionDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public InfoPermission findById(ScrollableSettings scrollableSettings) {
		return infopermissionDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public InfoPermission findById(Object key, Boolean initAll) {
		return infopermissionDao.findById(key, initAll);
	}
	
	
}
