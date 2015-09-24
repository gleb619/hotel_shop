/*
 * 
 */
package org.test.shop.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

public class VelocityConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public VelocityConfigurer velocityConfig() {
		VelocityConfigurer cfg = new VelocityConfigurer();
		cfg.setResourceLoaderPath("/WEB-INF/velocity/");
		cfg.setPreferFileSystemAccess(true);
//		cfg.setConfigLocation(context.getResource("/WEB-INF/velocity.properties"));
		Properties velocityProperties = new Properties();
//		velocityProperties.put("velocimacro.permissions.allow.inline", "true");
//		velocityProperties.put("velocimacro.permissions.allow.inline.to.replace.global", "true");
//		velocityProperties.put("velocimacro.permissions.allow.inline.local.scope", "true");
//		velocityProperties.put("input.encoding", "UTF-8");
//		velocityProperties.put("output.encoding", "UTF-8");
//		velocityProperties.put("resource.loader", "webapp, class");
//		velocityProperties.put("class.resource.loader.description", "Velocity Classpath Resource Loader");
//		velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader ");
//		velocityProperties.put("webapp.resource.loader.class", "org.apache.velocity.tools.view.WebappResourceLoader");
//		velocityProperties.put("webapp.resource.loader.path", "/WEB-INF/velocity/");
//		velocityProperties.put("webapp.resource.loader.cache", "true");
		cfg.setVelocityProperties(velocityProperties);
		
		return cfg;
	}
	
	@Bean
	public VelocityEngine velocityEngine(VelocityConfigurer configurer) throws VelocityException, IOException {
		return configurer.getVelocityEngine();
	}

//	@Bean
	public VelocityEngineFactoryBean velocityConfiguration() {
		VelocityEngineFactoryBean velocityEngineFactoryBean = new VelocityEngineFactoryBean();
		applyProperties(velocityEngineFactoryBean);
		return velocityEngineFactoryBean;
	}
	

	private void applyProperties(VelocityEngineFactory factory) {
		factory.setResourceLoaderPath("/WEB-INF/velocity/");
		factory.setPreferFileSystemAccess(false);
		Properties velocityProperties = new Properties();
//		velocityProperties.put("velocimacro.permissions.allow.inline", "true");
//		velocityProperties.put("velocimacro.permissions.allow.inline.to.replace.global", "true");
//		velocityProperties.put("velocimacro.permissions.allow.inline.local.scope", "true");
//		velocityProperties.put("input.encoding", "UTF-8");
//		velocityProperties.put("output.encoding", "UTF-8");
//		velocityProperties.put("resource.loader", "webapp, class");
//		velocityProperties.put("class.resource.loader.description", "Velocity Classpath Resource Loader");
//		velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader ");
//		velocityProperties.put("webapp.resource.loader.class", "org.apache.velocity.tools.view.WebappResourceLoader");
//		velocityProperties.put("webapp.resource.loader.path", "/WEB-INF/velocity/");
//		velocityProperties.put("webapp.resource.loader.cache", "true");
//		velocityProperties.put("webapp.resource.loader.cache", "false");
		factory.setVelocityProperties(velocityProperties);
	}
	
	
}
