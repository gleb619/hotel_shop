package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.RelServTransferTmContactViewDao;
import org.test.shop.model.domain.entity.view.RelServTransferTmContactView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class RelServTransferTmContactViewService {

	@Autowired
	private RelServTransferTmContactViewDao relservtransfertmcontactviewDao;

	@Transactional
	public RelServTransferTmContactView create(RelServTransferTmContactView data) {
		return relservtransfertmcontactviewDao.create(data);
	}

	@Transactional
	public RelServTransferTmContactView update(RelServTransferTmContactView data) {
		return relservtransfertmcontactviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return relservtransfertmcontactviewDao.delete(id);
	}

	@Transactional
	public void popularity(RelServTransferTmContactView data) {
		relservtransfertmcontactviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		relservtransfertmcontactviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return relservtransfertmcontactviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return relservtransfertmcontactviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> namedFilter(ScrollableSettings settings) {
		return relservtransfertmcontactviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> search(ScrollableSettings settings){
		return  relservtransfertmcontactviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> findByExample(RelServTransferTmContactView example, String delimitter, ScrollableSettings settings) {
		return relservtransfertmcontactviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> findByExample2(RelServTransferTmContactView example, DateCompare type) {
		return relservtransfertmcontactviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> findAll() {
		return relservtransfertmcontactviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> findAll(ScrollableSettings settings) {
		return relservtransfertmcontactviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<RelServTransferTmContactView> findAllScrollable(ScrollableSettings settings) {
		return relservtransfertmcontactviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public RelServTransferTmContactView findById(ScrollableSettings scrollableSettings) {
		return relservtransfertmcontactviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public RelServTransferTmContactView findById(Object key, Boolean initAll) {
		return relservtransfertmcontactviewDao.findById(key, initAll);
	}
	
	
}
