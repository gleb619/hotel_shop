package org.test.shop.config.evaluator;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.secure.RestAuthentication;

@Component
public class ApiPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private RestAuthentication restAuthentication;
	
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    	Boolean result = false;
    	
    	try {
			result = processPermission(targetDomainObject);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
    	
        return result;
    }

	private Boolean processPermission(Object targetDomainObject) throws NullPointerException {
		if(targetDomainObject == null){
			return false;
		}
		
		try {
			String key = targetDomainObject.toString().replaceAll("\\s+", "").toLowerCase();
			SasUser sasUser = restAuthentication.readSasUser(key);
			if (sasUser != null) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        return false;
	}

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String string, Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
