/*
 * 
 */
package org.test.shop.model.domain;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class SView.
 */
@MappedSuperclass
public class SView implements Serializable, Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7036352003135077022L;

	/** The checked. */
	private Boolean checked = false;

	/**
	 * Instantiates a new s view.
	 */
	public SView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the checked.
	 *
	 * @return the checked
	 */
	@Transient
	public Boolean getChecked() {
		return checked;
	}

	/**
	 * Sets the checked.
	 *
	 * @param checked the new checked
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
	@Transient
	public Integer getPopularity() {
		return 0;
	}

	public void setPopularity(Integer popularity) {
		
	}
	
	/**
	 * Inits the lists.
	 *
	 * @param arg0 the arg0
	 * @return the boolean
	 */
	protected Boolean initLists(Collection<?> arg0) {
		arg0.size();

		return false;
	}
	
	/**
	 * Inits the sentity.
	 *
	 * @param arg0 the arg0
	 * @return the boolean
	 */
	protected Boolean initSentity(Object arg0) {
		Boolean debug = false;
		
		if (debug) {
			System.out.println("arg0: " +
				arg0
			);
		}
		
		if (arg0 instanceof SObject) {
			((SObject) arg0).getFirmid();
			
			if (debug) {
				System.out.println("((SEntity) arg0).getLabel(): " +
						((SObject) arg0).getFirmid()
				);
			}
			
		}
		
		if (arg0 instanceof SEntity) {
			((SEntity) arg0).getLabel();
			
			if (debug) {
				System.out.println("((SEntity) arg0).getLabel(): " +
						((SEntity) arg0).getLabel()
				);
			}
			
			return true;
		}
		else if (arg0 instanceof SRequest){
			((SRequest) arg0).getLabel();
			return true;
			
		}
		else if (arg0 instanceof SDict){
			((SDict) arg0).getLabel();
			return true;
			
		}
		else if (arg0 instanceof SView){
			((SView) arg0).getChecked();
			return true;
		}
		
		return false;
	}
	
	/**
	 * Read level list.
	 *
	 * @param arg the arg
	 * @return the list
	 */
	private List<String> readLevelList(String arg){
		List<String> levelList = new LinkedList<String>();
		
		List<String> current = Arrays.asList(arg.split("\\."));
		
		if (current.size() >= 1) {
			String level = "";
			for (int i = 1; i < current.size(); i++) {
				level += current.get(i) + ".";
			}
			
			if (level.length() >= 1) {
				levelList.add(level.substring(0, level.length() - 1));
			}
		}
		
		return levelList;
	}
	
	/**
	 * Read current.
	 *
	 * @param arg the arg
	 * @return the string
	 */
	private String readCurrent(String arg){
		List<String> current = Arrays.asList(arg.split("\\."));
		
		if (current.size() >= 1) {
			return current.get(0);
		}
		
		return null;
	}
	
	/**
	 * Custom init list.
	 *
	 * @param arg0 the arg0
	 * @param manifest the manifest
	 * @return the list
	 */
	protected List<?> customInitList(List<?> arg0, List<String> manifest) {
		for (Object object : arg0) {
			customInit(object, manifest);
		}
		
		return arg0;
	}
	
	/**
	 * Custom init.
	 *
	 * @param <T> the generic type
	 * @param item the item
	 * @param manifest the manifest
	 * @return the t
	 */
	public <T> T customInit(T item, List<String> manifest) {
		Boolean debug = false;
		
		if (debug) {
			System.out.println("SObject.customInit()#[" +
					"\n\t  item: " + item +
					"\n\t, manifest: " + manifest +
					"\n]" + 
					"\n===============START==============\n"
			);
		}
		
		for (String string : manifest) {
			String name = readCurrent(string);
			List<String> levelList = readLevelList(string);
			
			if (debug) {
					System.out.println("\t[string: " + name + "::list(" + levelList.size() + ")#" + levelList + "]");
			}
			try {
				
				Object element = PropertyUtils.getProperty(item, name);
				
				if (debug) {
					System.out.println("\t" + name + "#" + element.getClass() + ": " + element);
				}
				
				if (element instanceof List) {
					((List<?>) element).size();
					customInitList((List<?>) element, levelList);
				}
				else if (element instanceof SObject) {
					((SObject) item).getFirmid();
					((SObject) item).customInit(element, levelList);
				}
				else if (element instanceof SView) {
					((SView) item).getChecked();
					((SView) item).customInit(element, levelList);
				}
				
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				System.err.println("SView.customInit()#ERROR: " + e.getMessage());
			}
		}
		
		if (debug) {
			System.out.println(
					"\n=============END================\n"
			);
		}
		
		return item;
	}

}
