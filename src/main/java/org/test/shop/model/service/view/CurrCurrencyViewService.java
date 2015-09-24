package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.CurrCurrencyViewDao;
import org.test.shop.model.domain.entity.view.CurrCurrencyView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class CurrCurrencyViewService {

	@Autowired
	private CurrCurrencyViewDao currcurrencyviewDao;

	@Transactional
	public CurrCurrencyView create(CurrCurrencyView data) {
		return currcurrencyviewDao.create(data);
	}

	@Transactional
	public CurrCurrencyView update(CurrCurrencyView data) {
		return currcurrencyviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return currcurrencyviewDao.delete(id);
	}

	@Transactional
	public void popularity(CurrCurrencyView data) {
		currcurrencyviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		currcurrencyviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return currcurrencyviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return currcurrencyviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> namedFilter(ScrollableSettings settings) {
		return currcurrencyviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> search(ScrollableSettings settings){
		return  currcurrencyviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> findByExample(CurrCurrencyView example, String delimitter, ScrollableSettings settings) {
		return currcurrencyviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<CurrCurrencyView> findByExample2(CurrCurrencyView example, DateCompare type) {
		return currcurrencyviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> findAll() {
		return currcurrencyviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> findAll(ScrollableSettings settings) {
		return currcurrencyviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<CurrCurrencyView> findAllScrollable(ScrollableSettings settings) {
		return currcurrencyviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public CurrCurrencyView findById(ScrollableSettings scrollableSettings) {
		return currcurrencyviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public CurrCurrencyView findById(Object key, Boolean initAll) {
		return currcurrencyviewDao.findById(key, initAll);
	}
	
	
}
