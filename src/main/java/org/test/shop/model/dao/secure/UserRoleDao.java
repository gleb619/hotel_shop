/*
 * 
 */
package org.test.shop.model.dao.secure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import org.springframework.stereotype.Repository;
import org.test.shop.model.domain.entity.secure.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoleDao.
 */
@Repository
public class UserRoleDao {

	/** The em. */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Creates the.
	 *
	 * @param users the users
	 * @return the user role
	 */
	public UserRole create(UserRole users) {
		em.persist(users);
		return users;
	}

	/**
	 * Update.
	 *
	 * @param users the users
	 * @return the user role
	 */
	public UserRole update(UserRole users) {
		return em.merge(users);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<UserRole> findAll() {
		return em.createQuery("SELECT use0 FROM UserRole use0"
				, UserRole.class).getResultList();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user role
	 */
	public UserRole findById(Integer id) {
		UserRole users = em.createQuery("SELECT use0 FROM UserRole use0 where use0.id = :id"
				, UserRole.class)
				.setParameter("id", id)
				.getSingleResult();
		//return em.find(UserRole.class, id);
		return users;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean delete(Integer id) {
		try {
			em.remove(em.getReference(UserRole.class, id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}