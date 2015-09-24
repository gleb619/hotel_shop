package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmContactEasyViewDao;
import org.test.shop.model.domain.entity.view.TmContactEasyView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmContactEasyViewService {

	@Autowired
	private TmContactEasyViewDao tmcontacteasyviewDao;

	@Transactional
	public TmContactEasyView create(TmContactEasyView data) {
		return tmcontacteasyviewDao.create(data);
	}

	@Transactional
	public TmContactEasyView update(TmContactEasyView data) {
		return tmcontacteasyviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmcontacteasyviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmContactEasyView data) {
		tmcontacteasyviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmcontacteasyviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmcontacteasyviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmcontacteasyviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> namedFilter(ScrollableSettings settings) {
		return tmcontacteasyviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> search(ScrollableSettings settings){
		return  tmcontacteasyviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> findByExample(TmContactEasyView example, String delimitter, ScrollableSettings settings) {
		return tmcontacteasyviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmContactEasyView> findByExample2(TmContactEasyView example, DateCompare type) {
		return tmcontacteasyviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> findAll() {
		return tmcontacteasyviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> findAll(ScrollableSettings settings) {
		return tmcontacteasyviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmContactEasyView> findAllScrollable(ScrollableSettings settings) {
		return tmcontacteasyviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmContactEasyView findById(ScrollableSettings scrollableSettings) {
		return tmcontacteasyviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmContactEasyView findById(Object key, Boolean initAll) {
		return tmcontacteasyviewDao.findById(key, initAll);
	}
	
	
}
