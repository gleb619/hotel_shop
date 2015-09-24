/*
 * 
 */
package org.test.shop.controller.secure;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.test.shop.controller.data.types.JsonOutput;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandlerController.
 */
@ControllerAdvice
public class ExceptionHandlerController extends JsonOutput implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9010784011896549414L;
	
	/** The debug. */
	private Boolean debug = true;
	
	/**
	 * Default error handler.
	 *
	 * @param request the request
	 * @param e the e
	 * @return the model and view
	 */
	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ModelAndView defaultErrorHandler(HttpServletRequest request,
			Exception e) {
		ModelAndView mav = new ModelAndView("error");

		String stacktrace = "\n-----------------------------\n";
		
		stacktrace += "ERROR: " + 
				"from: \n\t" +
				request.getRequestURL() + 
				"\n\t, " +
				e.getLocalizedMessage() + 
				"\n\n";
		
		for (StackTraceElement element : e.getStackTrace()) {
			stacktrace += "\n\t" + element.toString();
		}
		
		if (debug) {
			System.err.println(stacktrace + "\n-----------------------------\n");
		}
		
		mav.addObject("datetime", new Date());
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}
	
}
