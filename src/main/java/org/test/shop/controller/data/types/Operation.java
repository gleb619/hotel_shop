/*
 * 
 */
package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Operation.
 */
public class Operation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8756880244934724246L;

	/** The name. */
	private String name = "";
	
	/** The version. */
	private Integer version = 0;
	
	/** The entity. */
	private String entity = "";
	
	/** The id. */
	private Integer id = -1;
	
	private Boolean isInit = true;

	/**
	 * Instantiates a new operation.
	 */
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new operation.
	 *
	 * @param name the name
	 * @param version the version
	 * @param entity the entity
	 * @param id the id
	 */
	public Operation(String name, Integer version, String entity, Integer id) {
		super();
		this.name = name;
		this.version = version;
		this.entity = entity;
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Gets the entity.
	 *
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * Sets the entity.
	 *
	 * @param entity the new entity
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsInit() {
		return isInit;
	}

	public void setIsInit(Boolean isInit) {
		this.isInit = isInit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [name=" + name + ", version=" + version + ", entity="
				+ entity + ", id=" + id + "]";
	}

}
