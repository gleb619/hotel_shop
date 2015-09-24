package org.test.shop.util.data.types;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ConvertResult {

	private String query;
	private List<Integer> numberOfParametrs = new ArrayList<Integer>();
	private String filter;
	public ConvertResult(String query, List<Integer> numberOfParametrs,
			String filter) {
		super();
		this.query = query;
		this.numberOfParametrs = numberOfParametrs;
		this.filter = filter;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public List<Integer> getNumberOfParametrs() {
		return numberOfParametrs;
	}
	public void setNumberOfParametrs(List<Integer> numberOfParametrs) {
		this.numberOfParametrs = numberOfParametrs;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public Query query(EntityManager em, Class<?> clazz) {
		Query sqlQuery = em.createNativeQuery(query, clazz);
		for (Integer parametr : numberOfParametrs) {
			sqlQuery.setParameter(parametr, filter);
		}
		
		return sqlQuery;
	}
	
}
