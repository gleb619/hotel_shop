/*
 * 
 */
package org.test.shop.config.debug;

// TODO: Auto-generated Javadoc
/**
 * The Enum Settings.
 */
public enum Settings {

	/** The data config. */
	DATA_CONFIG(true),
	/** The security config. */
	SECURITY_CONFIG(false),
	/** The web mvc configurer adapter config. */
	WEB_MVC_CONFIGURER_ADAPTER_CONFIG(true),
	/** The log util. */
	LOG_UTIL(true),
	/** The cors filter. */
	CORS_FILTER(true),
	/** The cache config. */
	CACHE_CONFIG(true),
	/** The main controller. */
	MAIN_CONTROLLER(true),
	/** The login. */
	LOGIN(true),
	/** The client js controller. */
	CLIENT_JS_CONTROLLER(false);
	
	/** The value. */
	private final Boolean value;
	
	/** The production. */
	private Boolean production = false;

	/**
	 * Instantiates a new settings.
	 *
	 * @param value the value
	 */
	private Settings(Boolean value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Boolean getValue() {
		if (production) {
			return false;
		}
		
		return value;
	}
	
}
