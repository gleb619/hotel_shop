/*
 * 
 */
package org.test.shop.model.service.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.shop.model.dao.other.LocalizationDao;
import org.test.shop.model.domain.entity.other.Localization;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalizationService.
 */
@Service
public class LocalizationService {

	/** The localization dao. */
	@Autowired
	private LocalizationDao localizationDao;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Localization> findAll() {
		return localizationDao.findAll();
	}
	
	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the boolean
	 */
	public Boolean create(List<Localization> data) {
		return localizationDao.create(data);
	}
	/*

	public Boolean delete(Localization data) {
		return LocalizationDao.delete(0);
	}
	
	public Boolean delete(Integer id) {
		return LocalizationDao.delete(id);
	}
	
	
	
	public List<Localization> findAll(Integer start, Integer limit) {
		return LocalizationDao.findAll();
	}

	public Localization findById(Integer id) {
		return LocalizationDao.findById(id);
	}

	public Localization update(Localization data) {
		return LocalizationDao.update(data);
	}
	*/
}
