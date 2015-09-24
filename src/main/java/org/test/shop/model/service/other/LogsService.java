/*
 * 
 */
package org.test.shop.model.service.other;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.shop.model.dao.other.LogsDao;
import org.test.shop.model.domain.entity.other.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class LogsService.
 */
@Service
public class LogsService {

	/** The Log dao. */
	@Autowired
	private LogsDao LogDao;

	
	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the log
	 */
	public Log create(Log data) {
		return LogDao.create(data);
	}

	/**
	 * Delete.
	 *
	 * @param data the data
	 * @return the boolean
	 */
	public Boolean delete(Log data) {
		return LogDao.delete(0);
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean delete(Integer id) {
		return LogDao.delete(id);
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Log> findAll() {
		return LogDao.findAll();
	}
	
	/**
	 * Find all.
	 *
	 * @param start the start
	 * @param limit the limit
	 * @return the list
	 */
	public List<Log> findAll(Integer start, Integer limit) {
		return LogDao.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the log
	 */
	public Log findById(Integer id) {
		return LogDao.findById(id);
	}

	/**
	 * Update.
	 *
	 * @param data the data
	 * @return the log
	 */
	public Log update(Log data) {
		return LogDao.update(data);
	}
}
