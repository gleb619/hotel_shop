package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.InfoPermissionViewDao;
import org.test.shop.model.domain.entity.view.InfoPermissionView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class InfoPermissionViewService {

	@Autowired
	private InfoPermissionViewDao infopermissionviewDao;

	@Transactional
	public InfoPermissionView create(InfoPermissionView data) {
		return infopermissionviewDao.create(data);
	}

	@Transactional
	public InfoPermissionView update(InfoPermissionView data) {
		return infopermissionviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return infopermissionviewDao.delete(id);
	}

	@Transactional
	public void popularity(InfoPermissionView data) {
		infopermissionviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		infopermissionviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return infopermissionviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return infopermissionviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> namedFilter(ScrollableSettings settings) {
		return infopermissionviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> search(ScrollableSettings settings){
		return  infopermissionviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> findByExample(InfoPermissionView example, String delimitter, ScrollableSettings settings) {
		return infopermissionviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<InfoPermissionView> findByExample2(InfoPermissionView example, DateCompare type) {
		return infopermissionviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> findAll() {
		return infopermissionviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> findAll(ScrollableSettings settings) {
		return infopermissionviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoPermissionView> findAllScrollable(ScrollableSettings settings) {
		return infopermissionviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public InfoPermissionView findById(ScrollableSettings scrollableSettings) {
		return infopermissionviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public InfoPermissionView findById(Object key, Boolean initAll) {
		return infopermissionviewDao.findById(key, initAll);
	}
	
	
}
