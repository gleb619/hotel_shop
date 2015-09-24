package org.test.shop.util;

import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.secure.TokenUserService;

public class TokenUtils {

	public SasUser readToken(String token, TokenUserService tokenUserService) throws Exception {
		SasUser sasUser = null;
		
		try {
			sasUser = (SasUser) tokenUserService.loadUserByToken(token);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return sasUser;
	}
	
}
