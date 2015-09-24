/*
 * 
 */
package org.test.shop.model.domain.entity.secure;

import java.util.Collection;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

// TODO: Auto-generated Javadoc
/**
 * The Class SasUser.
 */
public class SasUser extends User implements UserDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1319268745933502233L;

	/** The user. */
	private org.test.shop.model.domain.entity.secure.User user;

	/**
	 * Instantiates a new sas user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param authorities the authorities
	 */
	public SasUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	}

	/**
	 * Instantiates a new sas user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param accountNonExpired the account non expired
	 * @param credentialsNonExpired the credentials non expired
	 * @param accountNonLocked the account non locked
	 * @param authorities the authorities
	 */
	public SasUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);

	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public org.test.shop.model.domain.entity.secure.User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(org.test.shop.model.domain.entity.secure.User user) {
		this.user = user;
	}

}
