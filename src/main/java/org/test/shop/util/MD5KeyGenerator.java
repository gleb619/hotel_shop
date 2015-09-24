/*
 * 
 */
package org.test.shop.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.springframework.cache.interceptor.KeyGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class MD5KeyGenerator.
 */
public class MD5KeyGenerator implements KeyGenerator {

	/* (non-Javadoc)
	 * @see org.springframework.cache.interceptor.KeyGenerator#generate(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object generate(Object target, Method method, Object... params) {
		System.out.println(
				"\n\t  target: " + target +
				"\n\t  method: " + method +
				"\n\t  params: " + Arrays.asList(params)
		);
		
		String output = "";
		
		try {
			output = generateMD5(target.toString()) + ".";
			output += generateMD5(method.toString()) + ".";
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Object object : params) {
			try {
				output += generateMD5(params.toString());
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			return generateMD5(output);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	/**
	 * Generate m d5.
	 *
	 * @param input the input
	 * @return the string
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private String generateMD5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		byte[] bytesOfMessage = input.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(bytesOfMessage);
		
		return new String(digest, "UTF-8");
	}

}
