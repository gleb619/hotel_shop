/*
 * 
 */
package org.test.shop.model.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class SERequest.
 */
@MappedSuperclass
@JsonIgnoreProperties({
	    "firmid"
	  , "userid"
	  , "version"
	  , "createby"
	  , "createon"
	  , "modifyby"
	  , "modifyon"
})
public class SERequest extends SEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -779977714384530020L;
	
	/** The exist. */
	private Boolean exist;
	
	/** The collapsed. */
	private Boolean collapsed = true;

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

	/**
	 * Gets the collapsed.
	 *
	 * @return the collapsed
	 */
	@Transient
	public Boolean getCollapsed() {
		return collapsed;
	}

	/**
	 * Sets the collapsed.
	 *
	 * @param collapsed the new collapsed
	 */
	public void setCollapsed(Boolean collapsed) {
		this.collapsed = collapsed;
	}
	
	

}
