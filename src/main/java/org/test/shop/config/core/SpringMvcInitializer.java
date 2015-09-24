/*
 * 
 */
package org.test.shop.config.core;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.test.shop.config.AppConfig;
import org.test.shop.config.listner.SessionListener;
import org.test.shop.controller.filter.cors.CORSFilter;
import org.test.shop.controller.filter.gzip.GZipServletFilter;


// TODO: Auto-generated Javadoc
/**
 * The Class SpringMvcInitializer.
 */
public class SpringMvcInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		servletContext.addListener(new SessionListener());
	}

	/* (non-Javadoc)
 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
 */
@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new GZipServletFilter(), new CORSFilter() };
//		return new Filter[] { new CORSFilter(), new GZipServletFilter() };
//		return new Filter[] { new CORSFilter() };
//		return new Filter[] { };
		
	}

}