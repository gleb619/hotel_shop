package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.StaticGeoLocationViewDao;
import org.test.shop.model.domain.entity.view.StaticGeoLocationView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class StaticGeoLocationViewService {

	@Autowired
	private StaticGeoLocationViewDao staticgeolocationviewDao;

	@Transactional
	public StaticGeoLocationView create(StaticGeoLocationView data) {
		return staticgeolocationviewDao.create(data);
	}

	@Transactional
	public StaticGeoLocationView update(StaticGeoLocationView data) {
		return staticgeolocationviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return staticgeolocationviewDao.delete(id);
	}

	@Transactional
	public void popularity(StaticGeoLocationView data) {
		staticgeolocationviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		staticgeolocationviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return staticgeolocationviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return staticgeolocationviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> namedFilter(ScrollableSettings settings) {
		return staticgeolocationviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> search(ScrollableSettings settings){
		return  staticgeolocationviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> findByExample(StaticGeoLocationView example, String delimitter, ScrollableSettings settings) {
		return staticgeolocationviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> findByExample2(StaticGeoLocationView example, DateCompare type) {
		return staticgeolocationviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> findAll() {
		return staticgeolocationviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> findAll(ScrollableSettings settings) {
		return staticgeolocationviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<StaticGeoLocationView> findAllScrollable(ScrollableSettings settings) {
		return staticgeolocationviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public StaticGeoLocationView findById(ScrollableSettings scrollableSettings) {
		return staticgeolocationviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public StaticGeoLocationView findById(Object key, Boolean initAll) {
		return staticgeolocationviewDao.findById(key, initAll);
	}
	
	
}
