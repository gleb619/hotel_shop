package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.TmFirmsViewDao;
import org.test.shop.model.domain.entity.view.TmFirmsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class TmFirmsViewService {

	@Autowired
	private TmFirmsViewDao tmfirmsviewDao;

	@Transactional
	public TmFirmsView create(TmFirmsView data) {
		return tmfirmsviewDao.create(data);
	}

	@Transactional
	public TmFirmsView update(TmFirmsView data) {
		return tmfirmsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return tmfirmsviewDao.delete(id);
	}

	@Transactional
	public void popularity(TmFirmsView data) {
		tmfirmsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		tmfirmsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return tmfirmsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return tmfirmsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> namedFilter(ScrollableSettings settings) {
		return tmfirmsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> search(ScrollableSettings settings){
		return  tmfirmsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> findByExample(TmFirmsView example, String delimitter, ScrollableSettings settings) {
		return tmfirmsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<TmFirmsView> findByExample2(TmFirmsView example, DateCompare type) {
		return tmfirmsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> findAll() {
		return tmfirmsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> findAll(ScrollableSettings settings) {
		return tmfirmsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<TmFirmsView> findAllScrollable(ScrollableSettings settings) {
		return tmfirmsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public TmFirmsView findById(ScrollableSettings scrollableSettings) {
		return tmfirmsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public TmFirmsView findById(Object key, Boolean initAll) {
		return tmfirmsviewDao.findById(key, initAll);
	}
	
	
}
