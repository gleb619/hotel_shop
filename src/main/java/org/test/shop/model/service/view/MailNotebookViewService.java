package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.MailNotebookViewDao;
import org.test.shop.model.domain.entity.view.MailNotebookView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class MailNotebookViewService {

	@Autowired
	private MailNotebookViewDao mailnotebookviewDao;

	@Transactional
	public MailNotebookView create(MailNotebookView data) {
		return mailnotebookviewDao.create(data);
	}

	@Transactional
	public MailNotebookView update(MailNotebookView data) {
		return mailnotebookviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return mailnotebookviewDao.delete(id);
	}

	@Transactional
	public void popularity(MailNotebookView data) {
		mailnotebookviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		mailnotebookviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return mailnotebookviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return mailnotebookviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> namedFilter(ScrollableSettings settings) {
		return mailnotebookviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> search(ScrollableSettings settings){
		return  mailnotebookviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> findByExample(MailNotebookView example, String delimitter, ScrollableSettings settings) {
		return mailnotebookviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<MailNotebookView> findByExample2(MailNotebookView example, DateCompare type) {
		return mailnotebookviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> findAll() {
		return mailnotebookviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> findAll(ScrollableSettings settings) {
		return mailnotebookviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<MailNotebookView> findAllScrollable(ScrollableSettings settings) {
		return mailnotebookviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public MailNotebookView findById(ScrollableSettings scrollableSettings) {
		return mailnotebookviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public MailNotebookView findById(Object key, Boolean initAll) {
		return mailnotebookviewDao.findById(key, initAll);
	}
	
	
}
