package org.test.shop.util.data.types;

public class SingleDateQuery implements DateQuery {

	private String parametr;
	private String value;
	private String query = " %s = CAST('%s' as DATE)";

	public SingleDateQuery(String parametr, String value) {
		super();
		this.parametr = parametr;
		this.value = value;
	}

	public String getParametr() {
		return parametr;
	}

	public void setParametr(String parametr) {
		this.parametr = parametr;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	@Override
	public SingleDateQuery formatQuery() {
		query = String.format(query, parametr, value);
		return this;
	}

}
