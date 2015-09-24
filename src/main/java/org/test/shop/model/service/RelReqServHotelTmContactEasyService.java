package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelReqServHotelTmContactEasyDao;
import org.test.shop.model.domain.entity.RelReqServHotelTmContactEasy;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelReqServHotelTmContactEasyService {

	@Autowired
	private RelReqServHotelTmContactEasyDao relreqservhoteltmcontacteasyDao;

	@Transactional
	public RelReqServHotelTmContactEasy create(RelReqServHotelTmContactEasy data) {
		return relreqservhoteltmcontacteasyDao.create(data);
	}

	@Transactional
	public RelReqServHotelTmContactEasy update(RelReqServHotelTmContactEasy data) {
		return relreqservhoteltmcontacteasyDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relreqservhoteltmcontacteasyDao.delete(id);
	}

	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relreqservhoteltmcontacteasyDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relreqservhoteltmcontacteasyDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> search(ScrollableSettings settings){
		return  relreqservhoteltmcontacteasyDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> findByExample(RelReqServHotelTmContactEasy example, String delimitter, ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> findByExample2(RelReqServHotelTmContactEasy example, DateCompare type) {
		return relreqservhoteltmcontacteasyDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> findAll() {
		return relreqservhoteltmcontacteasyDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> findAll(ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasy> findAllScrollable(ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelReqServHotelTmContactEasy findById(ScrollableSettings scrollableSettings) {
		return relreqservhoteltmcontacteasyDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelReqServHotelTmContactEasy findById(Object key, Boolean initAll) {
		return relreqservhoteltmcontacteasyDao.findById(key, initAll);
	}
	
	
}
