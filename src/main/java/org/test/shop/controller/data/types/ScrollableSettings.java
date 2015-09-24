/*
 * 
 */
package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.test.shop.model.domain.entity.secure.SasUser;

// TODO: Auto-generated Javadoc
/**
 * The Class ScrollableSettings.
 */
public class ScrollableSettings implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2792614173000202885L;

	/** The id. */
	private Object id = new Integer(-1);
	
	/** The init dicts. */
	private Boolean initDicts = false;
	
	/** The init lists. */
	private Boolean initLists = false;
	
	/** The only user data. */
	private Boolean onlyUserData = false;
	
	/** The page number. */
	private Integer pageNumber = 1;
	
	/** The page size. */
	private Integer pageSize = 10;
	
	/** The sas user. */
	private SasUser sasUser = null;
	
	/** The list. */
	private List<String> list = new ArrayList<String>();
	
	private List<Parametr> parametrs = new ArrayList<Parametr>();
	
	private String filter;
	private String date;
	
	private String namedfilter;
	private Boolean popularity = false;
	private Boolean sync = true;
	private String type;
	

	/**
	 * Instantiates a new scrollable settings.
	 */
	public ScrollableSettings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new scrollable settings.
	 *
	 * @param sasUser the sas user
	 */
	public ScrollableSettings(SasUser sasUser) {
		super();
		this.sasUser = sasUser;
	}

	/**
	 * Instantiates a new scrollable settings.
	 *
	 * @param initDicts the init dicts
	 * @param initLists the init lists
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @param list the list
	 */
	public ScrollableSettings(Boolean initDicts, Boolean initLists,
			Integer pageNumber, Integer pageSize, List<String> list) {
		super();
		this.initDicts = initDicts;
		this.initLists = initLists;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.list = list;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Object getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * Gets the inits the dicts.
	 *
	 * @return the inits the dicts
	 */
	public Boolean getInitDicts() {
		return initDicts;
	}

	/**
	 * Sets the inits the dicts.
	 *
	 * @param initDicts the new inits the dicts
	 */
	public void setInitDicts(Boolean initDicts) {
		this.initDicts = initDicts;
	}

	/**
	 * Gets the inits the lists.
	 *
	 * @return the inits the lists
	 */
	public Boolean getInitLists() {
		return initLists;
	}

	/**
	 * Sets the inits the lists.
	 *
	 * @param initLists the new inits the lists
	 */
	public void setInitLists(Boolean initLists) {
		this.initLists = initLists;
	}

	/**
	 * Gets the only user data.
	 *
	 * @return the only user data
	 */
	public Boolean getOnlyUserData() {
		return onlyUserData;
	}

	/**
	 * Sets the only user data.
	 *
	 * @param onlyUserData the new only user data
	 */
	public void setOnlyUserData(Boolean onlyUserData) {
		this.onlyUserData = onlyUserData;
	}

	/**
	 * Gets the page number.
	 *
	 * @return the page number
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * Sets the page number.
	 *
	 * @param pageNumber the new page number
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the sas user.
	 *
	 * @return the sas user
	 */
	public SasUser getSasUser() {
		return sasUser;
	}

	/**
	 * Sets the sas user.
	 *
	 * @param sasUser the new sas user
	 */
	public void setSasUser(SasUser sasUser) {
		this.sasUser = sasUser;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * Sets the list.
	 *
	 * @param list the new list
	 */
	public void setList(List<String> list) {
		this.list = list;
	}

	
	
	public Boolean getSync() {
		return sync;
	}

	public void setSync(Boolean sync) {
		this.sync = sync;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Parametr> getParametrs() {
		return parametrs;
	}

	public void setParametrs(List<Parametr> parametrs) {
		this.parametrs = parametrs;
	}
	
	
	

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNamedfilter() {
		return namedfilter;
	}

	public void setNamedfilter(String namedfilter) {
		this.namedfilter = namedfilter;
	}

	public Boolean getPopularity() {
		return popularity;
	}

	public void setPopularity(Boolean popularity) {
		this.popularity = popularity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDicts == null) ? 0 : initDicts.hashCode());
		result = prime * result
				+ ((initLists == null) ? 0 : initLists.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result
				+ ((onlyUserData == null) ? 0 : onlyUserData.hashCode());
		result = prime * result
				+ ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result
				+ ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((sasUser == null) ? 0 : sasUser.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScrollableSettings other = (ScrollableSettings) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initDicts == null) {
			if (other.initDicts != null)
				return false;
		} else if (!initDicts.equals(other.initDicts))
			return false;
		if (initLists == null) {
			if (other.initLists != null)
				return false;
		} else if (!initLists.equals(other.initLists))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (onlyUserData == null) {
			if (other.onlyUserData != null)
				return false;
		} else if (!onlyUserData.equals(other.onlyUserData))
			return false;
		if (pageNumber == null) {
			if (other.pageNumber != null)
				return false;
		} else if (!pageNumber.equals(other.pageNumber))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (sasUser == null) {
			if (other.sasUser != null)
				return false;
		} else if (!sasUser.equals(other.sasUser))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SIMPLE_STYLE);
	}

}
