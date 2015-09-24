/*
 * 
 */
package org.test.shop.model.domain.entity.secure;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonIgnoreProperties({
	  "user"
})
@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -454455213086939804L;

	/** The id. */
	private Integer id;
	
	/** The user. */
	private User user;
	
	/** The role. */
	private String role;

	/**
	 * Instantiates a new user role.
	 */
	public UserRole() {
	}

	/**
	 * Instantiates a new user role.
	 *
	 * @param user the user
	 * @param role the role
	 */
	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USERROLES")
	@SequenceGenerator(name = "SQ_USERROLES", sequenceName = "SQ_USERROLES", initialValue = 10, allocationSize = 1)
	@Id
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	@Column(name = "role")
	public String getRole() {
		return this.role;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}