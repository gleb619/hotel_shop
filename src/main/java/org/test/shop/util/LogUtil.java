/*
 * 
 */
package org.test.shop.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.test.shop.config.debug.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class LogUtil.
 */
@Component
@Aspect
public class LogUtil {

	/** The debug. */
	private Boolean debug = Settings.LOG_UTIL.getValue();
	
	/** The start. */
	private Instant start;
	
	/** The end. */
	private Instant end;
	
	/** The message. */
	private String message = "";
	
	/**
	 * Method.
	 */
	@Pointcut("execution(* org.test.shop.controller..*(..))")
	public void controller() {
		
	}

	/**
	 * Before method.
	 *
	 * @param joinPoint the join point
	 */
	@Before("controller()")
	public void beforeMethod(JoinPoint joinPoint) {
		String beforeMessage = "";
		if (debug) {
			beforeMessage += joinPoint.getTarget().getClass().getName() + "{" + "\n";
			beforeMessage += "\t" + joinPoint.getSignature().toLongString() + "\n";
			beforeMessage += "\targs(" + joinPoint.getArgs().length + ") is: \n\t\t  " +
					Arrays.asList(joinPoint.getArgs());
//					readArray(joinPoint.getArgs());
			start = Instant.now();
			setMessage(beforeMessage);
		}
	}

	/**
	 * After method.
	 *
	 * @param joinPoint the join point
	 */
	@After("controller()")
	public void afterMethod(JoinPoint joinPoint) {
		String afterMessage = getMessage();
		if (debug) {
			end = Instant.now();
			System.out.println(
					afterMessage +
					"\n\n\tIt take: " + Duration.between(start, end).toMillis() + " ms" +
					"\n}\n"
			);
		}
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public synchronized String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public synchronized void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Read array.
	 *
	 * @param args the args
	 * @return the string
	 */
	private String readArray(Object[] args) {
		return StringUtils.join(args, "\n\t\t, ");
	}
	
}
