package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmAccountViewDao;
import org.test.shop.model.domain.entity.view.TmAccountView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmAccountViewService {

	@Autowired
	private TmAccountViewDao tmaccountviewDao;

	@Transactional
	public TmAccountView create(TmAccountView data) {
		return tmaccountviewDao.create(data);
	}

	@Transactional
	public TmAccountView update(TmAccountView data) {
		return tmaccountviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmaccountviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmAccountView data) {
		tmaccountviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmaccountviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmaccountviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmaccountviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> namedFilter(ScrollableSettings settings) {
		return tmaccountviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> search(ScrollableSettings settings){
		return  tmaccountviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> findByExample(TmAccountView example, String delimitter, ScrollableSettings settings) {
		return tmaccountviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmAccountView> findByExample2(TmAccountView example, DateCompare type) {
		return tmaccountviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> findAll() {
		return tmaccountviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> findAll(ScrollableSettings settings) {
		return tmaccountviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmAccountView> findAllScrollable(ScrollableSettings settings) {
		return tmaccountviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmAccountView findById(ScrollableSettings scrollableSettings) {
		return tmaccountviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmAccountView findById(Object key, Boolean initAll) {
		return tmaccountviewDao.findById(key, initAll);
	}
	
	
}
