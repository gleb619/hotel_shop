package org.test.shop.controller.data.types;

import java.io.Serializable;

public class Parametr implements Serializable {

	private static final long serialVersionUID = -755342063553087318L;

	private String name;
	private String value;

	public Parametr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parametr(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("Parametr [name=%s, value=%s]", name, value);
	}

}
