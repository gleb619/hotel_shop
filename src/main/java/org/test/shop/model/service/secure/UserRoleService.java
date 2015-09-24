/*
 * 
 */
package org.test.shop.model.service.secure;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.model.dao.secure.UserRoleDao;
import org.test.shop.model.domain.entity.secure.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoleService.
 */
@Service
@Transactional
public class UserRoleService {

	/** The users dao. */
	@Autowired
	private UserRoleDao usersDao;

	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the user role
	 */
	@Transactional
	public UserRole create(UserRole data) {
		data = usersDao.create(data);
		return data;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@Transactional
	public Boolean delete(Integer id) {
		return usersDao.delete(id);
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Transactional(readOnly = true)
	public List<UserRole> findAll() {
		return usersDao.findAll();
	}
	
	/**
	 * Find all.
	 *
	 * @param start the start
	 * @param limit the limit
	 * @return the list
	 */
	@Transactional(readOnly = true)
	public List<UserRole> findAll(Integer start, Integer limit) {
		return usersDao.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user role
	 */
	@Transactional(readOnly = true)
	public UserRole findById(Integer id) {
		return usersDao.findById(id);
	}

	/**
	 * Update.
	 *
	 * @param data the data
	 * @return the user role
	 */
	@Transactional
	public UserRole update(UserRole data) {
		data = usersDao.update(data);
		return data;
	}
	
}
