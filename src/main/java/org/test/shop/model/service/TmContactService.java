package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmContactDao;
import org.test.shop.model.domain.entity.TmContact;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmContactService {

	@Autowired
	private TmContactDao tmcontactDao;

	@Transactional
	public TmContact create(TmContact data) {
		return tmcontactDao.create(data);
	}

	@Transactional
	public TmContact update(TmContact data) {
		return tmcontactDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmcontactDao.delete(id);
	}

	@Transactional
	public void popularity(TmContact data) {
		tmcontactDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmcontactDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmcontactDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmcontactDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContact> namedFilter(ScrollableSettings settings) {
		return tmcontactDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContact> search(ScrollableSettings settings){
		return  tmcontactDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContact> findByExample(TmContact example, String delimitter, ScrollableSettings settings) {
		return tmcontactDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmContact> findByExample2(TmContact example, DateCompare type) {
		return tmcontactDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmContact> findAll() {
		return tmcontactDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmContact> findAll(ScrollableSettings settings) {
		return tmcontactDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContact> findAllScrollable(ScrollableSettings settings) {
		return tmcontactDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmContact findById(ScrollableSettings scrollableSettings) {
		return tmcontactDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmContact findById(Object key, Boolean initAll) {
		return tmcontactDao.findById(key, initAll);
	}
	
	
}
