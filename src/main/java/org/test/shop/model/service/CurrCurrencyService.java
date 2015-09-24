package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.CurrCurrencyDao;
import org.test.shop.model.domain.entity.CurrCurrency;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class CurrCurrencyService {

	@Autowired
	private CurrCurrencyDao currcurrencyDao;

	@Transactional
	public CurrCurrency create(CurrCurrency data) {
		return currcurrencyDao.create(data);
	}

	@Transactional
	public CurrCurrency update(CurrCurrency data) {
		return currcurrencyDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return currcurrencyDao.delete(id);
	}

	@Transactional
	public void popularity(CurrCurrency data) {
		currcurrencyDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		currcurrencyDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return currcurrencyDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return currcurrencyDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> namedFilter(ScrollableSettings settings) {
		return currcurrencyDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> search(ScrollableSettings settings){
		return  currcurrencyDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> findByExample(CurrCurrency example, String delimitter, ScrollableSettings settings) {
		return currcurrencyDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<CurrCurrency> findByExample2(CurrCurrency example, DateCompare type) {
		return currcurrencyDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> findAll() {
		return currcurrencyDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> findAll(ScrollableSettings settings) {
		return currcurrencyDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrency> findAllScrollable(ScrollableSettings settings) {
		return currcurrencyDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public CurrCurrency findById(ScrollableSettings scrollableSettings) {
		return currcurrencyDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public CurrCurrency findById(Object key, Boolean initAll) {
		return currcurrencyDao.findById(key, initAll);
	}
	
	
}
