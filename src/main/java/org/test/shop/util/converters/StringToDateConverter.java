/*
 * 
 */
package org.test.shop.util.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.util.StdConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class StringToDateConverter.
 */
public class StringToDateConverter extends StdConverter<String, Date> {

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.util.StdConverter#convert(java.lang.Object)
	 */
	@Override
	public Date convert(String arg0) {
		System.out.println("StringToDateConverter.convert()#arg0: " + arg0);
		
		Date simpleResult = null;
		Date complexResult = null;
		arg0 = arg0.replace("T", " ");
		
		try {
			simpleResult = parseSimple(arg0);
		} catch (Exception e) {
			System.err.println("Error while parsing simple date: " + arg0);
		}
		
		try {
			complexResult = parseComplex(arg0);
		} catch (Exception e) {
			System.err.println("Error while parsing complex date: " + arg0);
		}
		
		if(simpleResult == null){
			simpleResult = new Date();
		}
		
		if(complexResult != null){
			simpleResult = complexResult;
		}
		
		return simpleResult;
	}

	/**
	 * Parses the simple.
	 *
	 * @param input the input
	 * @return the date
	 * @throws Exception the exception
	 */
	private Date parseSimple(String input) throws Exception {
	    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	    Date result = df.parse(input);  
	    
	    return result;
	}
	
	/**
	 * Parses the complex.
	 *
	 * @param input the input
	 * @return the date
	 * @throws Exception the exception
	 */
	private Date parseComplex(String input) throws Exception {
	    DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	    Date result = df.parse(input);  
	    
	    return result;
	}
	
}
