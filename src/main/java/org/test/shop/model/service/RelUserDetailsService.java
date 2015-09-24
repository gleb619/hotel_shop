package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelUserDetailsDao;
import org.test.shop.model.domain.entity.RelUserDetails;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelUserDetailsService {

	@Autowired
	private RelUserDetailsDao reluserdetailsDao;

	@Transactional
	public RelUserDetails create(RelUserDetails data) {
		return reluserdetailsDao.create(data);
	}

	@Transactional
	public RelUserDetails update(RelUserDetails data) {
		return reluserdetailsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return reluserdetailsDao.delete(id);
	}

	@Transactional
	public void popularity(RelUserDetails data) {
		reluserdetailsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		reluserdetailsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return reluserdetailsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return reluserdetailsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> namedFilter(ScrollableSettings settings) {
		return reluserdetailsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> search(ScrollableSettings settings){
		return  reluserdetailsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> findByExample(RelUserDetails example, String delimitter, ScrollableSettings settings) {
		return reluserdetailsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelUserDetails> findByExample2(RelUserDetails example, DateCompare type) {
		return reluserdetailsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> findAll() {
		return reluserdetailsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> findAll(ScrollableSettings settings) {
		return reluserdetailsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelUserDetails> findAllScrollable(ScrollableSettings settings) {
		return reluserdetailsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelUserDetails findById(ScrollableSettings scrollableSettings) {
		return reluserdetailsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelUserDetails findById(Object key, Boolean initAll) {
		return reluserdetailsDao.findById(key, initAll);
	}
	
	
}
