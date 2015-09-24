package org.test.shop.util.data.types;

public class RangeDateQuery implements DateQuery {

	private String parametr;
	private String valueStart;
	private String valueEnd;
	private String query = "(CAST(%s as DATE) >= CAST('%s' as DATE) AND CAST(%s as DATE) <= CAST('%s' as DATE))";

	public RangeDateQuery(String parametr, String valueStart, String valueEnd) {
		super();
		this.parametr = parametr;
		this.valueStart = valueStart;
		this.valueEnd = valueEnd;
	}

	public String getParametr() {
		return parametr;
	}

	public void setParametr(String parametr) {
		this.parametr = parametr;
	}

	public String getValueStart() {
		return valueStart;
	}

	public void setValueStart(String valueStart) {
		this.valueStart = valueStart;
	}

	public String getValueEnd() {
		return valueEnd;
	}

	public void setValueEnd(String valueEnd) {
		this.valueEnd = valueEnd;
	}

	@Override
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public RangeDateQuery formatQuery() {
		query = String.format(query, parametr, valueStart, parametr, valueEnd);
		return this;
	}
	
}
