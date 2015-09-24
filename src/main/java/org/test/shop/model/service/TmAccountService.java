package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmAccountDao;
import org.test.shop.model.domain.entity.TmAccount;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmAccountService {

	@Autowired
	private TmAccountDao tmaccountDao;

	@Transactional
	public TmAccount create(TmAccount data) {
		return tmaccountDao.create(data);
	}

	@Transactional
	public TmAccount update(TmAccount data) {
		return tmaccountDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmaccountDao.delete(id);
	}

	@Transactional
	public void popularity(TmAccount data) {
		tmaccountDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmaccountDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmaccountDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmaccountDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccount> namedFilter(ScrollableSettings settings) {
		return tmaccountDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccount> search(ScrollableSettings settings){
		return  tmaccountDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccount> findByExample(TmAccount example, String delimitter, ScrollableSettings settings) {
		return tmaccountDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmAccount> findByExample2(TmAccount example, DateCompare type) {
		return tmaccountDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmAccount> findAll() {
		return tmaccountDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmAccount> findAll(ScrollableSettings settings) {
		return tmaccountDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccount> findAllScrollable(ScrollableSettings settings) {
		return tmaccountDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmAccount findById(ScrollableSettings scrollableSettings) {
		return tmaccountDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmAccount findById(Object key, Boolean initAll) {
		return tmaccountDao.findById(key, initAll);
	}
	
	
}
