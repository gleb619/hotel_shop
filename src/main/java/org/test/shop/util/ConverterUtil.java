/*
 * 
 */
package org.test.shop.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.test.shop.model.domain.SEntity;
import org.test.shop.model.domain.SObject;
import org.test.shop.util.converters.TxtToHtmlConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class ConverterUtil.
 */
public class ConverterUtil {

	/**
	 * Convert.
	 *
	 * @param entity the entity
	 * @return the map
	 */
	public static Map<String, File> convert(Object entity) {
		System.out.println("ConverterUtil.convert()");
		Map<String, File> files = new HashMap<String, File>();
		
		
		return files;
	}
	
	/*
	private static Map<String, File> reqServHotelConverter(ReqServHotel entity) throws Exception {
//		System.out.println("ConverterUtil.convert()#entity: " + ((ReqServHotel) entity).getLabel());
		Map<String, String> files = new HashMap<String, String>();
		Map<String, String> values = readEntity(entity);
		
		for (RelReqServHotelDocDocuments relDocument : ((ReqServHotel) entity).getRelReqServHotelDocDocumentses()) {
//			System.out.println("ConverterUtil.convert()#relDocument: " + relDocument);
			
			String htmlTextPath = "";
			try {
				htmlTextPath = convertDocumentToHtml(relDocument.getDocDocuments());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String htmlTextFormatedText = fillTemplate(values, text(htmlTextPath));
			String extension = FilenameUtils.getExtension(relDocument.getDocDocuments().getLabel());
			String originalname = relDocument.getDocDocuments().getLabel();
			
			if (relDocument.getDocDocuments().getRealfile()) {
				originalname = relDocument.getDocDocuments().getOriginalfilename();
			}
			
			String name = originalname + ".pdf";
			String htmlTempFile = "";
			try {
				htmlTempFile = FileUtils.createTempHtmlFile(htmlTextFormatedText);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (extension != "") {
				name = originalname.replaceAll("." + extension, ".pdf");
			}
			
			System.out.println("ConverterUtil.convert()#" + 
					"\n\textension: " + extension + 
					"\n\told name: " + relDocument.getDocDocuments().getLabel() + 
					"\n\tnew name: " + name +
					"\n\thtmlTextPath: " + htmlTextPath + 
					"\n\thtmlTextFormatedText.length: " + htmlTextFormatedText.length() + 
					"\n\thtmlTextFormatedTextPath: " + htmlTempFile + 
					"\n----------\n"
			);
			
			files.put(name, htmlTempFile);
		}
		
		return convertDocumentToPdf(files);
	}
	*/
	
	
	/**
	 * Text.
	 *
	 * @param path the path
	 * @return the string
	 */
	private static String text(String path) {
		String result = null;
		try {
			result = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Read entity.
	 *
	 * @param entity the entity
	 * @return the map
	 */
	public static Map<String, String> readEntity(Object entity) {
		Class<?> clazz = entity.getClass();
		Map<String, String> map = new HashMap<String, String>();
		
		for (Field field : readAllFields(new LinkedList<Field>(), clazz)) {
			field.setAccessible(true);
			try {
				Object value = field.get(entity);
				String textValue = "";
//				Object fieldType = field.getType();
				
				if (value instanceof List) {
					
				}
				else if (value == null){
					
				}
				else {
					if (value instanceof SEntity) {
						textValue = ((SEntity) value).getLabel();
					}
					else {
						textValue = value.toString();
					}
					
					map.put(field.getName().toLowerCase().replaceAll("\\s+", ""), textValue);
				}
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	/**
	 * Read all fields.
	 *
	 * @param fields the fields
	 * @param type the type
	 * @return the list
	 */
	public static List<Field> readAllFields(List<Field> fields, Class<?> type) {
	    fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        fields = readAllFields(fields, type.getSuperclass());
	    }

	    return fields;
	}
	
	/**
	 * Fill template.
	 *
	 * @param values the values
	 * @param templateText the template text
	 * @return the string
	 */
	public static String fillTemplate(Map<String, String> values, String templateText) {
//		System.out.println("ConverterUtil.fillTemplate()#templateText: " + templateText.length());
		List<String> varibles = readTemplate(templateText);
		
//		System.out.println("ConverterUtil.fillTemplate()#\n\nvaribles: " + varibles + "\n--------\n" + "values: " + values);
		
		templateText = variblesToLowerCase(templateText)
							.replaceAll("\\R<meta.*>", "")
							.replaceAll("\\R<META.*>", "")
							.replaceAll("\\R<meta.*>$", "")
							.replaceAll("\\R<META.*>$", "");
//	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		for (String it : varibles) {
//			System.out.println("templateEngine#it: " + it + ", value: " + values.get(it));
			templateText = templateText.replaceAll("#" + it, values.getOrDefault(it, it));
		}
		
		return templateText;
	}
	
	/**
	 * Read template.
	 *
	 * @param template the template
	 * @return the list
	 */
	public static List<String> readTemplate(String template) {
		List<String> varibles = new ArrayList<String>();
//		^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3});$
		template = template.replaceAll("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3});$", "%%HEX_COLOR$1");
		
		Pattern pattern = Pattern.compile("#(.*)\\s");
		Matcher matcher = pattern.matcher(template);
		
		while (matcher.find()) {
			varibles.add(matcher.group()
						.replaceAll("</span>", "")
						.replaceAll("\\s+", "")
						.replaceAll("#", "")
						.toLowerCase()
			);
		}
		
		return varibles;
	}
	
	/**
	 * Varibles to lower case.
	 *
	 * @param template the template
	 * @return the string
	 */
	public static String variblesToLowerCase(String template) {
		Pattern pattern = Pattern.compile("#(.*)\\s");
		Matcher matcher = pattern.matcher(template);
		
		while (matcher.find()) {
			template = template.replaceAll(matcher.group(), matcher.group().toLowerCase());
		}
		
		return template;
	}
	
}
