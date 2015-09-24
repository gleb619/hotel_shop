package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.RelServTransferTmContactDao;
import org.test.shop.model.domain.entity.RelServTransferTmContact;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServTransferTmContactService {

	@Autowired
	private RelServTransferTmContactDao relservtransfertmcontactDao;

	@Transactional
	public RelServTransferTmContact create(RelServTransferTmContact data) {
		return relservtransfertmcontactDao.create(data);
	}

	@Transactional
	public RelServTransferTmContact update(RelServTransferTmContact data) {
		return relservtransfertmcontactDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservtransfertmcontactDao.delete(id);
	}

	@Transactional
	public void popularity(RelServTransferTmContact data) {
		relservtransfertmcontactDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservtransfertmcontactDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservtransfertmcontactDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservtransfertmcontactDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> namedFilter(ScrollableSettings settings) {
		return relservtransfertmcontactDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> search(ScrollableSettings settings){
		return  relservtransfertmcontactDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> findByExample(RelServTransferTmContact example, String delimitter, ScrollableSettings settings) {
		return relservtransfertmcontactDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> findByExample2(RelServTransferTmContact example, DateCompare type) {
		return relservtransfertmcontactDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> findAll() {
		return relservtransfertmcontactDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> findAll(ScrollableSettings settings) {
		return relservtransfertmcontactDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContact> findAllScrollable(ScrollableSettings settings) {
		return relservtransfertmcontactDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServTransferTmContact findById(ScrollableSettings scrollableSettings) {
		return relservtransfertmcontactDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServTransferTmContact findById(Object key, Boolean initAll) {
		return relservtransfertmcontactDao.findById(key, initAll);
	}
	
	
}
