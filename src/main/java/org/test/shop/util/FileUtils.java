/*
 * 
 */
package org.test.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.IOUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtils.
 */
public class FileUtils {

	/**
	 * Creates the temp html file.
	 *
	 * @param text the text
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String createTempHtmlFile(String text) throws IOException {
    	return createTempFile(text, "html");
	}
	
	/**
	 * Creates the temp file.
	 *
	 * @param text the text
	 * @param extension the extension
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String createTempFile(String text, String extension) throws IOException {
		String path = System.getProperty("java.io.tmpdir") + UUID.randomUUID().toString().replace("-", "_") + "_temp." + extension;
		Files.write(Paths.get(path), text.getBytes("UTF-8"));
		
		return path;
	}
	
	/**
	 * Random html temp filename.
	 *
	 * @return the string
	 */
	public static String randomHtmlTempFilename() {
		return randomTempFilename("html");
	}
	
	/**
	 * Random pdf temp filename.
	 *
	 * @return the string
	 */
	public static String randomPdfTempFilename() {
		return randomTempFilename("pdf");
	}
	
	/**
	 * Random temp filename.
	 *
	 * @param extension the extension
	 * @return the string
	 */
	public static String randomTempFilename(String extension) {
		return "" + System.getProperty("java.io.tmpdir") + UUID.randomUUID().toString().replace("-", "_") + "_temp." + extension;
	}
	
	public static String readFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get("test.txt")), "UTF-8");
	}
	
	public static String readFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		String content = "";

        try {
        	content = IOUtils.toString(is, "UTF-8");
        } finally {
            IOUtils.closeQuietly(is);
        }
		
		return content;
	}
	
}
