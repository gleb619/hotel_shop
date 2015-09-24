package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmFirmSettingsViewDao;
import org.test.shop.model.domain.entity.view.TmFirmSettingsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmFirmSettingsViewService {

	@Autowired
	private TmFirmSettingsViewDao tmfirmsettingsviewDao;

	@Transactional
	public TmFirmSettingsView create(TmFirmSettingsView data) {
		return tmfirmsettingsviewDao.create(data);
	}

	@Transactional
	public TmFirmSettingsView update(TmFirmSettingsView data) {
		return tmfirmsettingsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmfirmsettingsviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmFirmSettingsView data) {
		tmfirmsettingsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmfirmsettingsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmfirmsettingsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmfirmsettingsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> namedFilter(ScrollableSettings settings) {
		return tmfirmsettingsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> search(ScrollableSettings settings){
		return  tmfirmsettingsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> findByExample(TmFirmSettingsView example, String delimitter, ScrollableSettings settings) {
		return tmfirmsettingsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> findByExample2(TmFirmSettingsView example, DateCompare type) {
		return tmfirmsettingsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> findAll() {
		return tmfirmsettingsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> findAll(ScrollableSettings settings) {
		return tmfirmsettingsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmSettingsView> findAllScrollable(ScrollableSettings settings) {
		return tmfirmsettingsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmFirmSettingsView findById(ScrollableSettings scrollableSettings) {
		return tmfirmsettingsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmFirmSettingsView findById(Object key, Boolean initAll) {
		return tmfirmsettingsviewDao.findById(key, initAll);
	}
	
	
}
