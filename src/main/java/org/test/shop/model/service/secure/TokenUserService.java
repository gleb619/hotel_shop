package org.test.shop.model.service.secure;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.model.dao.secure.UserDao;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.secure.UserRole;

@Service
public class TokenUserService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		org.test.shop.model.domain.entity.secure.User user = userDao
				.findByUserName(username);

		if (user != null) {
			List<GrantedAuthority> authorities = buildUserAuthority(user
					.getUserRole());

			return buildUserForAuthentication(user, authorities);
		}

		throw new UsernameNotFoundException("Cannot find user");
	}
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByToken(final String token) throws UsernameNotFoundException {
		org.test.shop.model.domain.entity.secure.User user = userDao.findByToken(token);
		if (user != null) {
			List<GrantedAuthority> authorities = buildUserAuthority(user
					.getUserRole());
			
			return buildUserForAuthentication(user, authorities);
		}
		
		return null;
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new LinkedHashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(
				setAuths);

		return grantedAuthorities;
	}

	private User buildUserForAuthentication(
			org.test.shop.model.domain.entity.secure.User user,
			List<GrantedAuthority> authorities) {
		SasUser sasUser = new SasUser(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);

		sasUser.setUser(user);

		return sasUser;
		/*
		 * new User(user.getUsername(), user.getPassword(), user.isEnabled(),
		 * true, true, true, authorities);
		 */
	}

}