package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelReqServHotelTmContactEasyViewDao;
import org.test.shop.model.domain.entity.view.RelReqServHotelTmContactEasyView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelReqServHotelTmContactEasyViewService {

	@Autowired
	private RelReqServHotelTmContactEasyViewDao relreqservhoteltmcontacteasyviewDao;

	@Transactional
	public RelReqServHotelTmContactEasyView create(RelReqServHotelTmContactEasyView data) {
		return relreqservhoteltmcontacteasyviewDao.create(data);
	}

	@Transactional
	public RelReqServHotelTmContactEasyView update(RelReqServHotelTmContactEasyView data) {
		return relreqservhoteltmcontacteasyviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relreqservhoteltmcontacteasyviewDao.delete(id);
	}

	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relreqservhoteltmcontacteasyviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relreqservhoteltmcontacteasyviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> search(ScrollableSettings settings){
		return  relreqservhoteltmcontacteasyviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> findByExample(RelReqServHotelTmContactEasyView example, String delimitter, ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> findByExample2(RelReqServHotelTmContactEasyView example, DateCompare type) {
		return relreqservhoteltmcontacteasyviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> findAll() {
		return relreqservhoteltmcontacteasyviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> findAll(ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelReqServHotelTmContactEasyView> findAllScrollable(ScrollableSettings settings) {
		return relreqservhoteltmcontacteasyviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelReqServHotelTmContactEasyView findById(ScrollableSettings scrollableSettings) {
		return relreqservhoteltmcontacteasyviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelReqServHotelTmContactEasyView findById(Object key, Boolean initAll) {
		return relreqservhoteltmcontacteasyviewDao.findById(key, initAll);
	}
	
	
}
