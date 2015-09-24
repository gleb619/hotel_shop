/*
 * 
 */
package org.test.shop.util.data.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;

import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.util.DaoUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FindByExample.
 */
public class FindByDateExample implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9197747270092349622L;

	/** The select clause. */
	private String selectClause = "";
	
	/** The values. */
	private Map<String, Object> values = new HashMap<String, Object>();
	
	/** The query. */
	private Query query;

	/**
	 * Instantiates a new find by example.
	 *
	 * @param selectClause the select clause
	 * @param values the values
	 * @param query the query
	 */
	public FindByDateExample(String selectClause, Map<String, Object> values,
			Query query) {
		super();
		this.selectClause = selectClause;
		this.values = values;
		this.query = query;
	}

	/**
	 * Gets the select clause.
	 *
	 * @return the select clause
	 */
	public String getSelectClause() {
		return selectClause;
	}

	/**
	 * Sets the select clause.
	 *
	 * @param selectClause the new select clause
	 */
	public void setSelectClause(String selectClause) {
		this.selectClause = selectClause;
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	public Map<String, Object> getValues() {
		return values;
	}

	/**
	 * Sets the values.
	 *
	 * @param values the values
	 */
	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	/**
	 * Gets the query.
	 *
	 * @return the query
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * Sets the query.
	 *
	 * @param query the new query
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	public FindByDateExample init() {
		values.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		
		return this;
	}
	
}
