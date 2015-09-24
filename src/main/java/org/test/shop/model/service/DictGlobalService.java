package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.DictGlobalDao;
import org.test.shop.model.domain.entity.DictGlobal;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class DictGlobalService {

	@Autowired
	private DictGlobalDao dictglobalDao;

	@Transactional
	public DictGlobal create(DictGlobal data) {
		return dictglobalDao.create(data);
	}

	@Transactional
	public DictGlobal update(DictGlobal data) {
		return dictglobalDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return dictglobalDao.delete(id);
	}

	@Transactional
	public void popularity(DictGlobal data) {
		dictglobalDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		dictglobalDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return dictglobalDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return dictglobalDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> namedFilter(ScrollableSettings settings) {
		return dictglobalDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> search(ScrollableSettings settings){
		return  dictglobalDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> findByExample(DictGlobal example, String delimitter, ScrollableSettings settings) {
		return dictglobalDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<DictGlobal> findByExample2(DictGlobal example, DateCompare type) {
		return dictglobalDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> findAll() {
		return dictglobalDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> findAll(ScrollableSettings settings) {
		return dictglobalDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<DictGlobal> findAllScrollable(ScrollableSettings settings) {
		return dictglobalDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public DictGlobal findById(ScrollableSettings scrollableSettings) {
		return dictglobalDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public DictGlobal findById(Object key, Boolean initAll) {
		return dictglobalDao.findById(key, initAll);
	}
	
	
}
