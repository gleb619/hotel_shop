/*
 * 
 */
package org.test.shop.model.domain;

import javax.persistence.MappedSuperclass;


// TODO: Auto-generated Javadoc
/**
 * The Class SRel.
 */
@MappedSuperclass
public class SRel extends SView {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8848489045099182845L;

	public SRel init() {
		return this;
	}
	
	public SRel preInitList() {
		return this;
	}
	
	public SRel initList() {
		return this;
	}
	
	public SRel initDicts() {
		return this;
	}
	
}
