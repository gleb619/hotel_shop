/*
 * 
 */
package org.test.shop.model.domain;

import java.util.Collection;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.test.shop.model.domain.entity.listner.SEntityListner;

// TODO: Auto-generated Javadoc
/**
 * The Class SEntity.
 */
@MappedSuperclass
@EntityListeners({ SEntityListner.class })
public class SEntity extends SObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5366429587777894184L;

	/** The label. */
	private String label;
	private Boolean sync = true;

	/**
	 * Instantiates a new s entity.
	 */
	public SEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	@Transient
	public Boolean getSync() {
		return sync;
	}

	public void setSync(Boolean sync) {
		this.sync = sync;
	}

	/* (non-Javadoc)
	 * @see org.test.shop.model.domain.SObject#initLists(java.util.Collection)
	 */
	protected Boolean initLists(Collection<?> arg0) {
		for (Object arg1 : arg0) {
			initSentity(arg1);
		}

		return false;
	}

	/**
	 * Inits the dicts.
	 *
	 * @return the s entity
	 */
	protected SEntity initDicts() {

		return this;
	}

	/* (non-Javadoc)
	 * @see org.test.shop.model.domain.SObject#initSentity(java.lang.Object)
	 */
	protected Boolean initSentity(Object arg0) {
		return initSObject(arg0);
	}

}
