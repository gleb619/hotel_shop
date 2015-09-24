/*
 * 
 */
package org.test.shop.util.converters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.test.shop.util.FileUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TxtToHtmlConverter.
 */
public class TxtToHtmlConverter {

	/**
	 * Convert.
	 *
	 * @param fileFrom the file from
	 * @return the string
	 */
	public static String convert(String fileFrom) {
		System.out.println("TxtToHtmlConverter.convert()");
		
		try {
			return work(fileFrom, FileUtils.randomHtmlTempFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Convert2.
	 *
	 * @param text the text
	 * @return the string
	 */
	public static String convert2(String text) {
		System.out.println("TxtToHtmlConverter.convert2()");
		
		try {
			return work2(text, System.getProperty("java.io.tmpdir")
					+ UUID.randomUUID().toString().replace("-", "_") + ".html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Work.
	 *
	 * @param fileFrom the file from
	 * @param fileTo the file to
	 * @return the string
	 * @throws Exception the exception
	 */
	private static String work(String fileFrom, String fileTo) throws Exception {
		System.out.println("TxtToHtmlConverter.work()");
		
		ExecutorService executor = Executors.newWorkStealingPool(2);
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() {
				String template = "";
				try {
					template = prepareText(txtToHtml(new String(Files.readAllBytes(Paths.get(fileFrom)), "UTF-8")));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					Files.write(Paths.get(fileTo), template.getBytes("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return fileTo;
			}
		};
		Future<String> future = executor.submit(callable);
		executor.shutdown();

		return future.get();
	}
	
	/**
	 * Work2.
	 *
	 * @param text the text
	 * @param fileTo the file to
	 * @return the string
	 * @throws Exception the exception
	 */
	private static String work2(String text, String fileTo) throws Exception {
		System.out.println("TxtToHtmlConverter.work2()");
		
		ExecutorService executor = Executors.newWorkStealingPool(2);
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() {
				String template = prepareText(txtToHtml(text));
				
				try {
					Files.write(Paths.get(fileTo), template.getBytes("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return fileTo;
			}
		};
		Future<String> future = executor.submit(callable);
		executor.shutdown();

		return future.get();
	}
	
	/**
	 * Prepare text.
	 *
	 * @param text the text
	 * @return the string
	 */
	private static String prepareText(String text) {
		if (text.indexOf("<body>") == -1) {
			text = String.format("<body>%s</body>", text);
		}
		
		if (text.indexOf("<html>") == -1) {
			text = String.format("<html>%s</html>", text);
			
		}
		
		return text;
	}
	
	/**
	 * Txt to html.
	 *
	 * @param s the s
	 * @return the string
	 */
	private static String txtToHtml(String s) {
		StringBuilder builder = new StringBuilder();
		Boolean previousWasASpace = false;
		
		if (s == null || s.length() <= 0) {
			return "<html><body></body></html>";
		}
		
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				if (previousWasASpace) {
					builder.append("&nbsp;");
					previousWasASpace = false;
					continue;
				}
				previousWasASpace = true;
			} else {
				previousWasASpace = false;
			}
			switch (c) {
			case '<':
				builder.append("&lt;");
				break;
			case '>':
				builder.append("&gt;");
				break;
			case '&':
				builder.append("&amp;");
				break;
			case '"':
				builder.append("&quot;");
				break;
			case '\n':
				builder.append("<br>");
				break;
			case '\t':
				builder.append("&nbsp; &nbsp; &nbsp;");
				break;
			default:
				builder.append(c);

			}
		}
		String converted = builder.toString();
		String str = "(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>?«»“”‘’]))";
		Pattern patt = Pattern.compile(str);
		Matcher matcher = patt.matcher(converted);
		converted = matcher.replaceAll("<a href=\"$1\">$1</a>");
		
		return converted;
	}
	
}
