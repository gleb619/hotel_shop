/*
 * 
 */
package org.test.shop.controller.filter.cors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.shop.config.debug.Settings;

import org.springframework.web.filter.OncePerRequestFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class CORSFilter.
 */
public class CORSFilter extends OncePerRequestFilter {

	/** The debug. */
	private Boolean debug = Settings.CORS_FILTER.getValue(); 
	
	/** The _system. */
	private static List<String> _system = new ArrayList<String>();
	
	/** The is filterable. */
	private Boolean isFilterable = false;
    
    /** The Constant CACHE_PERIOD. */
    private final static long CACHE_PERIOD = TimeUnit.DAYS.toMillis(1L);
    
    /** The Constant LAST_MODIFIED. */
    private final static long LAST_MODIFIED = System.currentTimeMillis();
	
	static {
		_system.add("login");
		_system.add("index");
		_system.add("index2");
	}
    
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		
		List<String> excepts = Arrays.asList(request.getRequestURI().split("/"));
		isFilterable = true;
		Boolean isData = false;
		
		excepts.parallelStream().forEach(it -> {
			if (_system.contains(it)) {
				isFilterable = false;
			}
		});
		
		if (excepts.contains("data")) {
			isData = true;
		}
		
		response.setCharacterEncoding("UTF-8");
		
		if (isFilterable) {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
				response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
				response.addHeader("Access-Control-Allow-Headers",
						"Content-Encoding, Cache-Control, Pragma, Origin, Authorization, X-Requested-With, Content-Type, Accept");
			}
			
			if (isData) {
				response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate, max-age=0"); 
				response.setHeader("Pragma", "no-cache"); 
				response.setDateHeader("Last-Modified", LAST_MODIFIED); 
				response.setDateHeader("Expires", 0); 
			}
			else {
				if (debug) {
					response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate, max-age=0"); 
					response.setHeader("Pragma", "no-cache"); 
					response.setDateHeader("Last-Modified", LAST_MODIFIED); 
					response.setDateHeader("Expires", 0); 
				}
				else {
					response.setHeader("Cache-Control", "private, no-transform, max-age=" + CACHE_PERIOD); 
					response.setHeader("Pragma", "cache"); 
					response.setDateHeader("Last-Modified", LAST_MODIFIED); 
					response.setDateHeader("Expires", CACHE_PERIOD + System.currentTimeMillis());	
				}
			}
			
		}
		
		filterChain.doFilter(request, response);
	}
}
