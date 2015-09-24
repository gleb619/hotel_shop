package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmFirmSettingsDao;
import org.test.shop.model.domain.entity.TmFirmSettings;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmFirmSettingsService {

	@Autowired
	private TmFirmSettingsDao tmfirmsettingsDao;

	@Transactional
	public TmFirmSettings create(TmFirmSettings data) {
		return tmfirmsettingsDao.create(data);
	}

	@Transactional
	public TmFirmSettings update(TmFirmSettings data) {
		return tmfirmsettingsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmfirmsettingsDao.delete(id);
	}

	@Transactional
	public void popularity(TmFirmSettings data) {
		tmfirmsettingsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmfirmsettingsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmfirmsettingsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmfirmsettingsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> namedFilter(ScrollableSettings settings) {
		return tmfirmsettingsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> search(ScrollableSettings settings){
		return  tmfirmsettingsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> findByExample(TmFirmSettings example, String delimitter, ScrollableSettings settings) {
		return tmfirmsettingsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmFirmSettings> findByExample2(TmFirmSettings example, DateCompare type) {
		return tmfirmsettingsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> findAll() {
		return tmfirmsettingsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> findAll(ScrollableSettings settings) {
		return tmfirmsettingsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettings> findAllScrollable(ScrollableSettings settings) {
		return tmfirmsettingsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmFirmSettings findById(ScrollableSettings scrollableSettings) {
		return tmfirmsettingsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmFirmSettings findById(Object key, Boolean initAll) {
		return tmfirmsettingsDao.findById(key, initAll);
	}
	
	
}
