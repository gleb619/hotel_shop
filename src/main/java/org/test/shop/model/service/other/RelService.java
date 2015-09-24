package org.test.shop.model.service.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.other.RelDao;
import org.test.shop.model.domain.SRel;

@Service
@Transactional
public class RelService {

	@Autowired
	private RelDao relDao;

	@Transactional
	public <T extends SRel> T create(T data) {
		return relDao.create(data);
	}

	@Transactional
	public <T extends SRel> T update(T data) {
		return relDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id, Class<?> clazz) {
		return relDao.delete(id, clazz);
	}

	@Transactional(readOnly = true)
	public <T extends SRel> List<T> findByExample(T example, String delimitter, Class<T> clazz) {
		return relDao.findByExample(example, delimitter, clazz);
	}

	@Transactional(readOnly = true)
	public <T extends SRel> List<T> findAll(Class<T> clazz) {
		return relDao.findAll(new ScrollableSettings(), clazz);
	}

	@Transactional(readOnly = true)
	public <T extends SRel> List<T> findAll(ScrollableSettings settings, Class<T> clazz) {
		return relDao.findAll(settings, clazz);
	}

	@Transactional(readOnly = true)
	public <T extends SRel> List<T> findAllScrollable(ScrollableSettings settings, Class<T> clazz) {
		return relDao.findAllScrollable(settings, clazz);
	}

	@Transactional(readOnly = true)
	public <T extends SRel> T findById(ScrollableSettings scrollableSettings, Class<T> clazz) {
		return relDao.findById(scrollableSettings, clazz);
	}
	
	@Transactional(readOnly = true)
	public <T extends SRel> T findById(Object key, Boolean initAll, Class<T> clazz) {
		return relDao.findById(key, initAll, clazz);
	}
	
	
}
