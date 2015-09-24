package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.DocDocumentsViewDao;
import org.test.shop.model.domain.entity.view.DocDocumentsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class DocDocumentsViewService {

	@Autowired
	private DocDocumentsViewDao docdocumentsviewDao;

	@Transactional
	public DocDocumentsView create(DocDocumentsView data) {
		return docdocumentsviewDao.create(data);
	}

	@Transactional
	public DocDocumentsView update(DocDocumentsView data) {
		return docdocumentsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return docdocumentsviewDao.delete(id);
	}

	@Transactional
	public void popularity(DocDocumentsView data) {
		docdocumentsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		docdocumentsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return docdocumentsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return docdocumentsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> namedFilter(ScrollableSettings settings) {
		return docdocumentsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> search(ScrollableSettings settings){
		return  docdocumentsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> findByExample(DocDocumentsView example, String delimitter, ScrollableSettings settings) {
		return docdocumentsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<DocDocumentsView> findByExample2(DocDocumentsView example, DateCompare type) {
		return docdocumentsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> findAll() {
		return docdocumentsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> findAll(ScrollableSettings settings) {
		return docdocumentsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocumentsView> findAllScrollable(ScrollableSettings settings) {
		return docdocumentsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public DocDocumentsView findById(ScrollableSettings scrollableSettings) {
		return docdocumentsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public DocDocumentsView findById(Object key, Boolean initAll) {
		return docdocumentsviewDao.findById(key, initAll);
	}
	
	
}
