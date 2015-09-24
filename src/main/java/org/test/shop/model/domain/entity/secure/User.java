/*
 * 
 */
package org.test.shop.model.domain.entity.secure;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.test.shop.model.domain.SObject;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonIgnoreProperties({
	  "firmid"
	, "firm"
	, "serieskey"
	, "password"
	, "activationkey"
	, "email" 
})
@Entity
@Table(name = "users")
public class User extends SObject implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7052213915765939755L;

	/** The id. */
	private Integer id;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The email. */
	private String email;
	
	/** The enabled. */
	private Boolean enabled = false;
	
	/** The activated. */
	private Boolean activated = false;
	
	/** The lang key. */
	private String langKey;
	
	/** The activation key. */
	private String activationKey;
	
	private String landingPage;
	
	/** The user role. */
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 */
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param userRole the user role
	 */
	public User(String username, String password, boolean enabled,
			Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USERS")
	@SequenceGenerator(name = "SQ_USERS", sequenceName = "SQ_USERS", initialValue = 10, allocationSize = 1)
	@Id
	@Column(nullable = false, unique = true)
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Email
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the activated.
	 *
	 * @return the activated
	 */
	public Boolean getActivated() {
		return activated;
	}

	/**
	 * Sets the activated.
	 *
	 * @param activated the new activated
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	/**
	 * Gets the lang key.
	 *
	 * @return the lang key
	 */
	public String getLangKey() {
		return langKey;
	}

	/**
	 * Sets the lang key.
	 *
	 * @param langKey the new lang key
	 */
	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	/**
	 * Gets the activation key.
	 *
	 * @return the activation key
	 */
	public String getActivationKey() {
		return activationKey;
	}

	/**
	 * Sets the activation key.
	 *
	 * @param activationKey the new activation key
	 */
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	/**
	 * Gets the enabled.
	 *
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Column(name = "username", unique = true, nullable = false)
	public String getUsername() {
		return this.username;
	}

	public String getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

	// @Fetch(FetchMode.JOIN)
	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return the boolean
	 */
	@Column(name = "enabled")
	public Boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activated == null) ? 0 : activated.hashCode());
		result = prime * result
				+ ((activationKey == null) ? 0 : activationKey.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((langKey == null) ? 0 : langKey.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (activated == null) {
			if (other.activated != null)
				return false;
		} else if (!activated.equals(other.activated))
			return false;
		if (activationKey == null) {
			if (other.activationKey != null)
				return false;
		} else if (!activationKey.equals(other.activationKey))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (langKey == null) {
			if (other.langKey != null)
				return false;
		} else if (!langKey.equals(other.langKey))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// ------------------ Logic part ------------------

	/**
	 * Inits the.
	 *
	 * @return the user
	 */
	public User init() {
		initList();
		initDicts();

		return this;
	}

	/**
	 * Pre init list.
	 *
	 * @return the user
	 */
	public User preInitList() {
		for (UserRole arg0 : getUserRole()) {
			arg0.setUser(this);
		}

		return this;
	}

	/**
	 * Inits the list.
	 *
	 * @return the user
	 */
	public User initList() {
		initLists(userRole);

		return this;
	}

	/**
	 * Inits the dicts.
	 *
	 * @return the user
	 */
	public User initDicts() {

		return this;
	}

}
