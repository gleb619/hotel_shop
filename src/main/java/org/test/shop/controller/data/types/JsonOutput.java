/*
 * 
 */
package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.test.shop.model.domain.entity.secure.SasUser;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonOutput.
 */
public class JsonOutput implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6693350744724545446L;
	
	/** The debug. */
	public static Boolean debug = true;
	
	/** The exludes. */
	public static String[] exludes = {
			"serialVersionUID"
	};
	
	/**
	 * Read sas user.
	 *
	 * @param principal the principal
	 * @return the sas user
	 */
	public static SasUser readSasUser(Principal principal){
		SasUser sasUser = null;
		
		if (principal instanceof UsernamePasswordAuthenticationToken) {
			sasUser = (SasUser) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
		}
		
		return sasUser;
	}
	
	/**
	 * Map with header.
	 *
	 * @param item the item
	 * @param clazz the clazz
	 * @return the map
	 */
	public static Map<String, Object> mapWithHeader(List<?> item, Class<?> clazz) {
		List<String> list = new LinkedList<String>();
		for (Field f : clazz.getDeclaredFields()) {
			if(!Arrays.asList(exludes).contains(f.getName())){
				list.add(f.getName());
			}
		}
		
		Map<String, Object> modelMap = map(item);
		modelMap.put("headers", list);
		return modelMap;
	}
	
	/**
	 * Map.
	 *
	 * @param item the item
	 * @return the map
	 */
	public static Map<String, Object> map(List<?> item) {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", item.size());
		modelMap.put("data", item);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Map for operation result.
	 *
	 * @param operationResult the operation result
	 * @return the map
	 */
	public static Map<String, Object> mapForOperationResult(OperationResult operationResult) {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		Boolean success = true;
		if (operationResult != null && operationResult.getSuccess() != null) {
			success = operationResult.getSuccess();
		}
		
		modelMap.put("total", 1);
		modelMap.put("data", operationResult);
		modelMap.put("success", success);
		
		return modelMap;
	}
	
	/**
	 * Map success.
	 *
	 * @return the map
	 */
	public static Map<String, Object> mapSuccess() {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("success", true);

		return modelMap;
	}

	/**
	 * Map error.
	 *
	 * @param msg the msg
	 * @return the map
	 */
	public static Map<String, Object> mapError(String msg) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	}
	
	/**
	 * Map.
	 *
	 * @param success the success
	 * @return the map
	 */
	public static Map<String, Object> map(Boolean success) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("success", success);

		return modelMap;
	}

	/**
	 * Map.
	 *
	 * @param item the item
	 * @return the map
	 */
	public static Map<String, Object> map(final Object item) {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", 1);
		modelMap.put("data", new LinkedList<Object>() {
			private static final long serialVersionUID = -7969749703452916490L;

			{
				add(item);
			}
		});
		modelMap.put("success", true);

		return modelMap;
	}
	
	/**
	 * Gets the total.
	 *
	 * @param total the total
	 * @return the total
	 */
	public static Map<String, Object> getTotal(Integer total) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("total", total);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Map single.
	 *
	 * @param item the item
	 * @return the map
	 */
	public static Map<String, Object> mapSingle(final Object item) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("success", true);
		modelMap.put("data", item);
		return modelMap;
	}

	public static Map<String, Object> mapWarning(String msg) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("message", msg);
		modelMap.put("warning", true);
		modelMap.put("success", false);
		return modelMap;
	}
	
}
