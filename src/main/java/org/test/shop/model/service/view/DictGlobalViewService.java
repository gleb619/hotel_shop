package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.DictGlobalViewDao;
import org.test.shop.model.domain.entity.view.DictGlobalView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class DictGlobalViewService {

	@Autowired
	private DictGlobalViewDao dictglobalviewDao;

	@Transactional
	public DictGlobalView create(DictGlobalView data) {
		return dictglobalviewDao.create(data);
	}

	@Transactional
	public DictGlobalView update(DictGlobalView data) {
		return dictglobalviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return dictglobalviewDao.delete(id);
	}

	@Transactional
	public void popularity(DictGlobalView data) {
		dictglobalviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		dictglobalviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return dictglobalviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return dictglobalviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> namedFilter(ScrollableSettings settings) {
		return dictglobalviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> search(ScrollableSettings settings){
		return  dictglobalviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> findByExample(DictGlobalView example, String delimitter, ScrollableSettings settings) {
		return dictglobalviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<DictGlobalView> findByExample2(DictGlobalView example, DateCompare type) {
		return dictglobalviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> findAll() {
		return dictglobalviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> findAll(ScrollableSettings settings) {
		return dictglobalviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobalView> findAllScrollable(ScrollableSettings settings) {
		return dictglobalviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public DictGlobalView findById(ScrollableSettings scrollableSettings) {
		return dictglobalviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public DictGlobalView findById(Object key, Boolean initAll) {
		return dictglobalviewDao.findById(key, initAll);
	}
	
	
}
