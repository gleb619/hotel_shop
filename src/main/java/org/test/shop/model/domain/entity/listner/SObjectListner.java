/*
 * 
 */
package org.test.shop.model.domain.entity.listner;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.test.shop.model.domain.SObject;

/**
 * The Class SObjectListner.
 */
public class SObjectListner {

	@PrePersist
	public void prePersist(SObject object){
		if(object.getCreateon() == null){
			object.setCreateon(new Date());
		}
		if(object.getModifyon() == null){
			object.setModifyon(new Date());
		}
	}
	
	@PreUpdate
	public void preUpdate(SObject object){
		object.setModifyon(new Date());
	}
	
}
