package org.test.shop.model.service.secure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.util.TokenUtils;

@Service
public class RestAuthentication {

	private Map<String, SasUser> authenticatedUsers = new HashMap<String, SasUser>();
	private TokenUtils tokenUtils = new TokenUtils();
	
	@Autowired
	private TokenUserService tokenUserService;

	public SasUser readSasUser(String key) {
		SasUser sasUser = authenticatedUsers.get(key);
		if (sasUser == null) {
			try {
				sasUser = tokenUtils.readToken(key, tokenUserService);
				authenticatedUsers.put(key, sasUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sasUser;
	}

	public Map<String, SasUser> getAuthenticatedUsers() {
		return authenticatedUsers;
	}

	public void setAuthenticatedUsers(Map<String, SasUser> authenticatedUsers) {
		this.authenticatedUsers = authenticatedUsers;
	}

}
