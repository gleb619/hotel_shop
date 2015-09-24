/*
 * 
 */
package org.test.shop.model.dao.other;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;
import org.test.shop.model.domain.entity.other.Localization;


// TODO: Auto-generated Javadoc
/**
 * The Class LocalizationDao.
 */
@Repository
public class LocalizationDao {


	/**
	 * Update.
	 *
	 * @param Localization the localization
	 * @return the localization
	 */
	public Localization update(Localization Localization) {
		return Localization;
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Localization> findAll() {
		List<Localization> list = new LinkedList<Localization>();
		
		try {
			InputStream in = null;
			try {
				in = (InputStream) loadLocalizationFile().get("inputstream");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String properties = IOUtils.toString(in, "UTF-8");
			list = convertStringToList(properties);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	/**
	 * Creates the.
	 *
	 * @param list the list
	 * @return the boolean
	 */
	public Boolean create(List<Localization> list) {
		Map<String, Object> map = null;
		try {
			map = loadLocalizationFile();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String source = convertListToString(list);
		try {
			Files.write(Paths.get((URI) map.get("path")), source.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Load localization file.
	 *
	 * @return the map
	 * @throws URISyntaxException the URI syntax exception
	 */
	public Map<String, Object> loadLocalizationFile() throws URISyntaxException {
		Map<String, Object> output = new LinkedHashMap<String, Object>();
		InputStream in = this.getClass().getClassLoader()
		        .getResourceAsStream("messages_ru.properties");
		
		URI path = this.getClass().getClassLoader().getResource("messages_ru.properties").toURI();
		output.put("inputstream", in);
		output.put("path", path);
		/*
		System.out.println("path: " +
				path
		);
		*/
		return output;
	}
	
	/**
	 * Convert string to list.
	 *
	 * @param source the source
	 * @return the list
	 */
	public List<Localization> convertStringToList(String source) {
		List<Localization> output = new LinkedList<Localization>();
		String[] array_ = source.split("\\R");
		for (String string : array_) {
			if(string.contains("=")){
				String[] row = string.split("=");
				if (row.length == 2) {
					output.add(new Localization(row[0], row[1]));
				}
			}
			else {
				if (string.length() > 0) {
					output.add(new Localization(string));
				}
			}
		}
		
		return output;
	}
	
	/**
	 * Convert list to string.
	 *
	 * @param list the list
	 * @return the string
	 */
	public String convertListToString(List<Localization> list) {
		String output = "";
		
		for (Localization localization : list) {
			if (localization.getValue() != null && localization.getValue().length() > 0) {
				output += localization.getKey() + "=" + localization.getValue() + "\r\n";
			}
			else {
				output += localization.getKey() + "\r\n";
			}
		}
		
		return output;
	}
	
}
