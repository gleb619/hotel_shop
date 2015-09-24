/*
 * 
 */
package org.test.shop.model.service.secure;

import java.util.ArrayList;
import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.model.dao.secure.UserDao;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.secure.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service
@Transactional
public class UserService {

	/** The users dao. */
	@Autowired
	private UserDao usersDao;
	
	/** The session registry. */
	@Autowired
	private SessionRegistry sessionRegistry;

	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the user
	 */
	@Transactional(noRollbackFor = Exception.class)
	public User create(User data) {
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
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) {
		return usersDao.findByUserName(username);
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Transactional(readOnly = true)
	public List<User> findAll() {
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
	public List<User> findAll(Integer start, Integer limit) {
		return usersDao.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	@Transactional(readOnly = true)
	public User findById(Integer id) {
		return usersDao.findById(id);
	}
	
	@Transactional(readOnly = true)
	public User findByActivationKey(String activationKey) {
		return usersDao.findByActivationKey(activationKey);
	}

	/**
	 * Update.
	 *
	 * @param data the data
	 * @return the user
	 */
	@Transactional
	public User update(User data) {
		data = usersDao.update(data);
		return data;
	}
	
	/**
	 * Gets the online users.
	 *
	 * @return the online users
	 */
	public List<SasUser> getOnlineUsers() {
		List<SasUser> users = new ArrayList<SasUser>();
		List<Object> allPrincipals = sessionRegistry.getAllPrincipals();

		for (Object principal : allPrincipals) {
			SasUser user = (SasUser) principal;
			users.add(user);
		}

		return users;
	}
}
