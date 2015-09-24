package org.test.shop.controller.data.types;

import java.io.Serializable;

import org.test.shop.model.domain.entity.view.ShopServHotel2View;

public class ShopRequest implements Serializable {

	private static final long serialVersionUID = -7861474030221345998L;

	private String name;
	private Integer startCount;
	private String text;
	private String dellimitter;
	private String countryname;
	private String cityname;
	private Boolean freesale;

	public ShopRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopRequest(String name, Integer startCount, String text,
			String dellimitter) {
		super();
		this.name = name;
		this.startCount = startCount;
		this.text = text;
		this.dellimitter = dellimitter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartCount() {
		return startCount;
	}

	public void setStartCount(Integer startCount) {
		this.startCount = startCount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDellimitter() {
		return dellimitter;
	}

	public void setDellimitter(String dellimitter) {
		this.dellimitter = dellimitter;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Boolean getFreesale() {
		return freesale;
	}

	public void setFreesale(Boolean freesale) {
		this.freesale = freesale;
	}

	public String formattedDellimitter() {
		if (dellimitter == null) {
			dellimitter = "OR";
		}
		return " " + dellimitter.replaceAll("\\s+", "") + " ";
	}
	
	public ShopServHotel2View validate() {
		ShopServHotel2View hotelView = new ShopServHotel2View();
		
		if (cityname != null) {
			hotelView.setCityname(cityname);
		}
		
		if (countryname != null) {
			hotelView.setCountryname(countryname);
		}
		
		if (text != null) {
			hotelView.setDescr(text);
		}
		
		if (freesale != null) {
			hotelView.setFreesale(freesale);
		}
		
		if (name != null) {
			hotelView.setLabel(name);
		}
		
		if (startCount != null) {
			hotelView.setStarcount(startCount);
		}
		
		return hotelView;
	}
	
}
