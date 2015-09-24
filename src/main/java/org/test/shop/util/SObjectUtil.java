/*
 * 
 */
package org.test.shop.util;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.shop.model.domain.SObject;
import org.test.shop.model.domain.entity.secure.SasUser;

// TODO: Auto-generated Javadoc
/**
 * The Class SObjectUtil.
 */
@Component
public class SObjectUtil {

	/**
	 * Creates the.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T create(SasUser sasUser, T object){
		if (sasUser == null) {
			return object;
		}
		
		if (object instanceof SObject) {
//			SObject sObject = (SObject) object;
			((SObject) object).setFirmid(sasUser.getUser().getFirmid());
			((SObject) object).setCreatedby(sasUser.getUsername());
			((SObject) object).setLastmodifiedby(sasUser.getUsername());
			((SObject) object).setCreateon(new Date());
		}
		
		return (T) object;
	}
	
	/**
	 * Update.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	public <T> T update(SasUser sasUser, T object){
		if (object instanceof SObject) {
			((SObject) object).setLastmodifiedby(sasUser.getUsername());
			((SObject) object).setModifyon(new Date());
		}
		
		return (T) object;
	}
	
	/**
	 * Delete.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	public <T> T delete(SasUser sasUser, T object){
		
		return (T) object;
	}
	
	/**
	 * View by id.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	public <T> T viewById(SasUser sasUser, T object){
		
		return (T) object;
	}
	
	/**
	 * View.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the list
	 */
	public <T> List<T> view(SasUser sasUser, List<T> object){
		
		return (List<T>) object;
	}
	
	/**
	 * View scrollable.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the list
	 */
	public <T> List<T> viewScrollable(SasUser sasUser, List<T> object){
		
		return (List<T>) object;
	}
	
}
