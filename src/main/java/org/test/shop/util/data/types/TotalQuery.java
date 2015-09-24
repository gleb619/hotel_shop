package org.test.shop.util.data.types;

import javax.persistence.Query;

public class TotalQuery {

	private String clause;
	private Query query;

	public TotalQuery() {
		super();
		
	}
	
	public TotalQuery(String clause, Query query) {
		super();
		this.clause = clause;
		this.query = query;
	}

	public String getClause() {
		return clause;
	}

	public void setClause(String clause) {
		this.clause = clause;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

}
