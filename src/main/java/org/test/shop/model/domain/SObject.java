/*
 * 
 */
package org.test.shop.model.domain;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.test.shop.model.domain.entity.listner.SObjectListner;

// TODO: Auto-generated Javadoc
/**
 * The Class SObject.
 */
@Audited
@MappedSuperclass
@EntityListeners( { AuditingEntityListener.class, SObjectListner.class } )
public abstract class SObject implements Serializable, Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4887202249349353197L;

	/** The firmid. */
	private Integer firmid;
	
	/** The version. */
	private Integer version;
	
	/** The serieskey. */
	private String serieskey;

	/** The createdby. */
	private String createdby;
	
	/** The lastmodifiedby. */
	private String lastmodifiedby;

	/** The createon. */
	private Date createon;
	
	/** The modifyon. */
	private Date modifyon;

	private Integer popularity;
	
	/**
	 * Instantiates a new s object.
	 */
	public SObject() {
		super();
		
	}

	/**
	 * Gets the firmid.
	 *
	 * @return the firmid
	 */
	@Column(updatable = false)
	public Integer getFirmid() {
		return firmid;
	}

	/**
	 * Sets the firmid.
	 *
	 * @param firmid the new firmid
	 */
	public void setFirmid(Integer firmid) {
		this.firmid = firmid;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	@Version
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Gets the createdby.
	 *
	 * @return the createdby
	 */
	@Column(updatable = false)
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * Sets the createdby.
	 *
	 * @param createdby the new createdby
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * Gets the lastmodifiedby.
	 *
	 * @return the lastmodifiedby
	 */
	public String getLastmodifiedby() {
		return lastmodifiedby;
	}

	/**
	 * Sets the lastmodifiedby.
	 *
	 * @param lastmodifiedby the new lastmodifiedby
	 */
	public void setLastmodifiedby(String lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	/**
	 * Gets the serieskey.
	 *
	 * @return the serieskey
	 */
	@Column(updatable = false)
	public String getSerieskey() {
		return serieskey;
	}

	/**
	 * Sets the serieskey.
	 *
	 * @param serieskey the new serieskey
	 */
	public void setSerieskey(String serieskey) {
		this.serieskey = serieskey;
	}

	/**
	 * Gets the createon.
	 *
	 * @return the createon
	 */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateon() {
		return createon;
	}

	/**
	 * Sets the createon.
	 *
	 * @param createon the new createon
	 */
	public void setCreateon(Date createon) {
		this.createon = createon;
	}

	/**
	 * Gets the modifyon.
	 *
	 * @return the modifyon
	 */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyon() {
		return modifyon;
	}

	/**
	 * Sets the modifyon.
	 *
	 * @param modifyon the new modifyon
	 */
	public void setModifyon(Date modifyon) {
		this.modifyon = modifyon;
	}

	/**
	 * Inits the lists.
	 *
	 * @param arg0 the arg0
	 * @return the boolean
	 */
	protected Boolean initLists(Collection<?> arg0) {
		for (Object arg1 : arg0) {
			initSObject(arg1);
		}

		return false;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	/**
	 * Inits the sentity.
	 *
	 * @param arg0 the arg0
	 * @return the boolean
	 */
	protected Boolean initSentity(Object arg0){
		return initSObject(arg0);
	}
	
	/**
	 * Inits the s object.
	 *
	 * @param arg0 the arg0
	 * @return the boolean
	 */
	protected Boolean initSObject(Object arg0) {
		Boolean debug = false;

		if (debug) {
			System.out.println("arg0: " + arg0);
		}

		if (arg0 instanceof SObject) {
			((SObject) arg0).getFirmid();

			if (debug) {
				System.out.println("((SEntity) arg0).getLabel(): "
						+ ((SObject) arg0).getFirmid());
			}

		}

		if (arg0 instanceof SEntity) {
			// ((SEntity) arg0).getLabel();
			((SEntity) arg0).initDicts();

			if (debug) {
				System.out.println("((SEntity) arg0).getLabel(): "
						+ ((SEntity) arg0).getLabel());
			}

			return true;
		} else if (arg0 instanceof SRequest) {
			// ((SRequest) arg0).getLabel();
			((SRequest) arg0).initDicts();
			return true;

		} else if (arg0 instanceof SDict) {
			((SDict) arg0).getLabel();
			return true;

		} else if (arg0 instanceof SView) {
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
				
				Object element = BeanUtils.getProperty(item, name);
				element = PropertyUtils.getProperty(item, name);
//				element.hashCode();
				
				if (debug) {
					System.out.println("\t" + name + "#" + element.getClass() + ": " + element);
				}
				
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
				
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				e.printStackTrace();
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
