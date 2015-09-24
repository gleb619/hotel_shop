package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.util.List;

public class DividedResult implements Serializable {

	private static final long serialVersionUID = -7168756964950973802L;
	private String name;
	private List data;

	public DividedResult(String name, List data) {
		super();
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
