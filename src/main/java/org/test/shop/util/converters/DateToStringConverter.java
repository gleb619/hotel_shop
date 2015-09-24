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
 * The Class DateToStringConverter.
 */
public class DateToStringConverter extends StdConverter<Date, String> {

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.util.StdConverter#convert(java.lang.Object)
	 */
	@Override
	public String convert(Date value) {
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
		String result = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		
		try {
			result = df.format(value);
		} catch (Exception e) {
			System.err.println("Error while parsing date: " + value + " to " + df);
		}
		
		return result;
	}

}
