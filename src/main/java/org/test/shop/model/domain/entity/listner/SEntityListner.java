/*
 * 
 */
package org.test.shop.model.domain.entity.listner;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.test.shop.model.domain.SEntity;

/**
 * The Class SEntityListner.
 */
public class SEntityListner {
/*
	@PrePersist
	public void prePersist(SEntity sEntity){
		if(sEntity.getCreateon() == null){
			sEntity.setCreateon(new Date());
		}
		if(sEntity.getModifyon() == null){
			sEntity.setModifyon(new Date());
		}
	}
	
	@PreUpdate
	public void preUpdate(SEntity sEntity){
		sEntity.setModifyon(new Date());
	}
	*/
}
