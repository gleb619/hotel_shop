package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.InfoContactInformationViewDao;
import org.test.shop.model.domain.entity.view.InfoContactInformationView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class InfoContactInformationViewService {

	@Autowired
	private InfoContactInformationViewDao infocontactinformationviewDao;

	@Transactional
	public InfoContactInformationView create(InfoContactInformationView data) {
		return infocontactinformationviewDao.create(data);
	}

	@Transactional
	public InfoContactInformationView update(InfoContactInformationView data) {
		return infocontactinformationviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return infocontactinformationviewDao.delete(id);
	}

	@Transactional
	public void popularity(InfoContactInformationView data) {
		infocontactinformationviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		infocontactinformationviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return infocontactinformationviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return infocontactinformationviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> namedFilter(ScrollableSettings settings) {
		return infocontactinformationviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> search(ScrollableSettings settings){
		return  infocontactinformationviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> findByExample(InfoContactInformationView example, String delimitter, ScrollableSettings settings) {
		return infocontactinformationviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<InfoContactInformationView> findByExample2(InfoContactInformationView example, DateCompare type) {
		return infocontactinformationviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> findAll() {
		return infocontactinformationviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> findAll(ScrollableSettings settings) {
		return infocontactinformationviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<InfoContactInformationView> findAllScrollable(ScrollableSettings settings) {
		return infocontactinformationviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public InfoContactInformationView findById(ScrollableSettings scrollableSettings) {
		return infocontactinformationviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public InfoContactInformationView findById(Object key, Boolean initAll) {
		return infocontactinformationviewDao.findById(key, initAll);
	}
	
	
}
