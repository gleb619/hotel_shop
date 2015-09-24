package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmFirmsDao;
import org.test.shop.model.domain.entity.TmFirms;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmFirmsService {

	@Autowired
	private TmFirmsDao tmfirmsDao;

	@Transactional
	public TmFirms create(TmFirms data) {
		return tmfirmsDao.create(data);
	}

	@Transactional
	public TmFirms update(TmFirms data) {
		return tmfirmsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmfirmsDao.delete(id);
	}

	@Transactional
	public void popularity(TmFirms data) {
		tmfirmsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmfirmsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmfirmsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmfirmsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirms> namedFilter(ScrollableSettings settings) {
		return tmfirmsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirms> search(ScrollableSettings settings){
		return  tmfirmsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirms> findByExample(TmFirms example, String delimitter, ScrollableSettings settings) {
		return tmfirmsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmFirms> findByExample2(TmFirms example, DateCompare type) {
		return tmfirmsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmFirms> findAll() {
		return tmfirmsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmFirms> findAll(ScrollableSettings settings) {
		return tmfirmsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirms> findAllScrollable(ScrollableSettings settings) {
		return tmfirmsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmFirms findById(ScrollableSettings scrollableSettings) {
		return tmfirmsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmFirms findById(Object key, Boolean initAll) {
		return tmfirmsDao.findById(key, initAll);
	}
	
	
}
