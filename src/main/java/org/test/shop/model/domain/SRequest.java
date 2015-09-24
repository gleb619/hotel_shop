/*
 * 
 */
package org.test.shop.model.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


// TODO: Auto-generated Javadoc
/**
 * The Class SRequest.
 */
@MappedSuperclass
public class SRequest extends SObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4530890758114654720L;
	
	/** The label. */
	private String label;
	
	/** The exist. */
	private Boolean exist;

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

	/**
	 * Gets the exist.
	 *
	 * @return the exist
	 */
	@Transient
	public Boolean getExist() {
		return exist;
	}

	/**
	 * Sets the exist.
	 *
	 * @param exist the new exist
	 */
	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	/* (non-Javadoc)
	 * @see org.test.shop.model.domain.SObject#initSentity(java.lang.Object)
	 */
	protected Boolean initSentity(Object arg0) {
		return initSObject(arg0);
	}
	
	/**
	 * Inits the dicts.
	 *
	 * @return the s request
	 */
	protected SRequest initDicts() {
		
		return this;
	}

}
