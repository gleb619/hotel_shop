/*
 * 
 */
package org.test.shop.model.service.secure;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.model.dao.secure.UserDao;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.secure.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class MyUserDetailsService.
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	/** The user dao. */
	@Autowired
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.test.shop.model.domain.entity.secure.User user = null;
		try {
			user = userDao.findByUserName(username);
		} catch (DataAccessException  e) {
			throw new UsernameNotFoundException("Invalid login", e);
		}

		if (user == null) {
	        throw new UsernameNotFoundException("User not found.");
	    }
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
	}
	
	/**
	 * Builds the user authority.
	 *
	 * @param userRoles the user roles
	 * @return the list
	 */
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new LinkedHashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(setAuths);

		return grantedAuthorities;
	}

	/**
	 * Builds the user for authentication.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUserForAuthentication(org.test.shop.model.domain.entity.secure.User user,
			List<GrantedAuthority> authorities) {
		SasUser sasUser = new SasUser(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
		sasUser.setUser(user);
		
		return sasUser;
	}
	/*
	public List<User> getOnlineUsers() {
		List<User> users = new ArrayList<User>();
		List<Object> allPrincipals = sessionRegistry.getAllPrincipals();

        for(Object principal : allPrincipals) {
            SasUser user = (SasUser) principal;

            // Do something with user
//            System.out.println(user);
            users.add(user);
        }
        
        return users;
	}
	*/
	/*
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		org.test.shop.model.domain.entity.secure.User user = null;
		try {
			user = userDao.findByUserName(username);
		} catch (DataAccessException  e) {
			throw new UsernameNotFoundException("Invalid login", e);
		}

		if (user == null) {
	        throw new UsernameNotFoundException("User not found.");
	    }
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);

	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new LinkedHashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(org.test.shop.model.domain.entity.secure.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	*/
}