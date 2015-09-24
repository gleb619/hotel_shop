package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.DocDocumentsDao;
import org.test.shop.model.domain.entity.DocDocuments;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class DocDocumentsService {

	@Autowired
	private DocDocumentsDao docdocumentsDao;

	@Transactional
	public DocDocuments create(DocDocuments data) {
		return docdocumentsDao.create(data);
	}

	@Transactional
	public DocDocuments update(DocDocuments data) {
		return docdocumentsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return docdocumentsDao.delete(id);
	}

	@Transactional
	public void popularity(DocDocuments data) {
		docdocumentsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		docdocumentsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return docdocumentsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return docdocumentsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> namedFilter(ScrollableSettings settings) {
		return docdocumentsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> search(ScrollableSettings settings){
		return  docdocumentsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> findByExample(DocDocuments example, String delimitter, ScrollableSettings settings) {
		return docdocumentsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<DocDocuments> findByExample2(DocDocuments example, DateCompare type) {
		return docdocumentsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> findAll() {
		return docdocumentsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> findAll(ScrollableSettings settings) {
		return docdocumentsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<DocDocuments> findAllScrollable(ScrollableSettings settings) {
		return docdocumentsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public DocDocuments findById(ScrollableSettings scrollableSettings) {
		return docdocumentsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public DocDocuments findById(Object key, Boolean initAll) {
		return docdocumentsDao.findById(key, initAll);
	}
	
	
}
