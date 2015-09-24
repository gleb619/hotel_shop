package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmContactViewDao;
import org.test.shop.model.domain.entity.view.TmContactView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmContactViewService {

	@Autowired
	private TmContactViewDao tmcontactviewDao;

	@Transactional
	public TmContactView create(TmContactView data) {
		return tmcontactviewDao.create(data);
	}

	@Transactional
	public TmContactView update(TmContactView data) {
		return tmcontactviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmcontactviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmContactView data) {
		tmcontactviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmcontactviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmcontactviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmcontactviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactView> namedFilter(ScrollableSettings settings) {
		return tmcontactviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactView> search(ScrollableSettings settings){
		return  tmcontactviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactView> findByExample(TmContactView example, String delimitter, ScrollableSettings settings) {
		return tmcontactviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmContactView> findByExample2(TmContactView example, DateCompare type) {
		return tmcontactviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmContactView> findAll() {
		return tmcontactviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmContactView> findAll(ScrollableSettings settings) {
		return tmcontactviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactView> findAllScrollable(ScrollableSettings settings) {
		return tmcontactviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmContactView findById(ScrollableSettings scrollableSettings) {
		return tmcontactviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmContactView findById(Object key, Boolean initAll) {
		return tmcontactviewDao.findById(key, initAll);
	}
	
	
}
