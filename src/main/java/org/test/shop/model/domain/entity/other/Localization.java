/*
 * 
 */
package org.test.shop.model.domain.entity.other;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Localization.
 */
public class Localization implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2885972009083896026L;

	/** The key. */
	private String key;
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new localization.
	 */
	public Localization() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new localization.
	 *
	 * @param key the key
	 */
	public Localization(String key) {
		super();
		this.key = key;
	}

	/**
	 * Instantiates a new localization.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public Localization(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
