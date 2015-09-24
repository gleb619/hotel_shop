/*
 * 
 */
package org.test.shop.model.dao.secure;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.test.shop.model.domain.entity.secure.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDao.
 */
@Repository
public class UserDao {

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	public User findByActivationKey(String activationKey) {
		List<User> users = em.createQuery("SELECT u FROM User u where u.activationKey = :activationKey", User.class)
				.setParameter("activationKey", activationKey)
				.setMaxResults(1)
				.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
		
	}
	
	public User findByToken(String token) {
		List<User> users = em.createQuery("SELECT u FROM User u where u.token = :token", User.class)
				.setParameter("token", token)
				.setMaxResults(1)
				.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
		
	}
	
	/**
	 * Find by user name.
	 *
	 * @param username the username
	 * @return the user
	 * @throws DataAccessException the data access exception
	 */
	public User findByUserName(String username) throws DataAccessException {
		List<User> user = new ArrayList<User>();
		user = em.createQuery("SELECT u FROM User u where u.username = :username", User.class)
				.setParameter("username", username)
				.setMaxResults(1)
				.getResultList();

		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}

	}
	
	/**
	 * Creates the.
	 *
	 * @param User the user
	 * @return the user
	 */
	public User create(User User) {
		em.persist(User);
		return User;
	}

	/**
	 * Update.
	 *
	 * @param User the user
	 * @return the user
	 */
	public User update(User User) {
		return em.merge(User);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll() {
		return em.createQuery("SELECT use0 FROM User use0"
				, User.class).getResultList();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findById(Integer id) {
		User User = em.createQuery("SELECT use0 FROM User use0 where use0.id = :id"
				, User.class)
				.setParameter("id", id)
				.getSingleResult();
		//return em.find(User.class, id);
		return User;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean delete(Integer id) {
		try {
			em.remove(em.getReference(User.class, id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
//	----------------------------------
	
	/**
 * Find all.
 *
 * @param initDicts the init dicts
 * @return the list
 */
public List<User> findAll(Boolean initDicts) {
		List<User> User = em.createQuery("SELECT use0 FROM User use0"
				, User.class).getResultList();
		
		if (initDicts) {
			for (User item : User) {
				item.initDicts();
			}
		}
		
		return User;
	}
	
	/**
	 * Find all.
	 *
	 * @param initDicts the init dicts
	 * @param firmid the firmid
	 * @return the list
	 */
	public List<User> findAll(Boolean initDicts, Integer firmid) {
		List<User> User = em.createQuery("SELECT use0 FROM User use0 WHERE use0.firmid = :firmid"
				, User.class)
				.setParameter("firmid", firmid)
				.getResultList();
		
		if (initDicts) {
			for (User item : User) {
				item.initDicts();
			}
		}
		
		return User;
	}
	
	/**
	 * Find all scrollable.
	 *
	 * @param initDicts the init dicts
	 * @param initLists the init lists
	 * @param firmid the firmid
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the list
	 */
	public List<User> findAllScrollable(Boolean initDicts, Boolean initLists, Integer firmid, Integer pageNumber, Integer pageSize) {
		List<User> User = em.createQuery("SELECT use0 FROM User use0 WHERE use0.firmid = :firmid"
				, User.class)
				.setParameter("firmid", firmid)
				.setFirstResult((pageNumber - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		
		Boolean check = false;
		
		if(initLists || initDicts){
			check = true;
		}
		
		if (check) {
			for (User item : User) {
				if (initDicts) {
					item.initDicts();
				}
				if (initLists) {
					item.initList();
				}
			}
		}
		
		return User;
	}
	
	/**
	 * Find all scrollable.
	 *
	 * @param initDicts the init dicts
	 * @param initLists the init lists
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the list
	 */
	public List<User> findAllScrollable(Boolean initDicts, Boolean initLists, Integer pageNumber, Integer pageSize) {
		List<User> User = em.createQuery("SELECT use0 FROM User use0"
				, User.class)
				.setFirstResult((pageNumber - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		
		Boolean check = false;
		
		if(initLists || initDicts){
			check = true;
		}
		
		if (check) {
			for (User item : User) {
				if (initDicts) {
					item.initDicts();
				}
				if (initLists) {
					item.initList();
				}
			}
		}
		
		return User;
	}
	
}