package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.InfoContactInformationDao;
import org.test.shop.model.domain.entity.InfoContactInformation;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class InfoContactInformationService {

	@Autowired
	private InfoContactInformationDao infocontactinformationDao;

	@Transactional
	public InfoContactInformation create(InfoContactInformation data) {
		return infocontactinformationDao.create(data);
	}

	@Transactional
	public InfoContactInformation update(InfoContactInformation data) {
		return infocontactinformationDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return infocontactinformationDao.delete(id);
	}

	@Transactional
	public void popularity(InfoContactInformation data) {
		infocontactinformationDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		infocontactinformationDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return infocontactinformationDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return infocontactinformationDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> namedFilter(ScrollableSettings settings) {
		return infocontactinformationDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> search(ScrollableSettings settings){
		return  infocontactinformationDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> findByExample(InfoContactInformation example, String delimitter, ScrollableSettings settings) {
		return infocontactinformationDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<InfoContactInformation> findByExample2(InfoContactInformation example, DateCompare type) {
		return infocontactinformationDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> findAll() {
		return infocontactinformationDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> findAll(ScrollableSettings settings) {
		return infocontactinformationDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformation> findAllScrollable(ScrollableSettings settings) {
		return infocontactinformationDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public InfoContactInformation findById(ScrollableSettings scrollableSettings) {
		return infocontactinformationDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public InfoContactInformation findById(Object key, Boolean initAll) {
		return infocontactinformationDao.findById(key, initAll);
	}
	
	
}
