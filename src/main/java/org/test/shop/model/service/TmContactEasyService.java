package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.TmContactEasyDao;
import org.test.shop.model.domain.entity.TmContactEasy;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmContactEasyService {

	@Autowired
	private TmContactEasyDao tmcontacteasyDao;

	@Transactional
	public TmContactEasy create(TmContactEasy data) {
		return tmcontacteasyDao.create(data);
	}

	@Transactional
	public TmContactEasy update(TmContactEasy data) {
		return tmcontacteasyDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmcontacteasyDao.delete(id);
	}

	@Transactional
	public void popularity(TmContactEasy data) {
		tmcontacteasyDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmcontacteasyDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmcontacteasyDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmcontacteasyDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> namedFilter(ScrollableSettings settings) {
		return tmcontacteasyDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> search(ScrollableSettings settings){
		return  tmcontacteasyDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> findByExample(TmContactEasy example, String delimitter, ScrollableSettings settings) {
		return tmcontacteasyDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmContactEasy> findByExample2(TmContactEasy example, DateCompare type) {
		return tmcontacteasyDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> findAll() {
		return tmcontacteasyDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> findAll(ScrollableSettings settings) {
		return tmcontacteasyDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasy> findAllScrollable(ScrollableSettings settings) {
		return tmcontacteasyDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmContactEasy findById(ScrollableSettings scrollableSettings) {
		return tmcontacteasyDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmContactEasy findById(Object key, Boolean initAll) {
		return tmcontacteasyDao.findById(key, initAll);
	}
	
	
}
