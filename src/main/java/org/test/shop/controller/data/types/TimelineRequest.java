/*
 * 
 */
package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class TimelineRequest.
 */
public class TimelineRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8961567067316679113L;

	/** The is range. */
	private Boolean isRange;
	
	/** The date. */
	private String date;
	
	/** The range start. */
	private String rangeStart;
	
	/** The range end. */
	private String rangeEnd;
	
	/** The is number range. */
	private Boolean isNumberRange;
	
	/** The number range. */
	private Integer numberRange;

	/**
	 * Instantiates a new timeline request.
	 */
	public TimelineRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the checks if is range.
	 *
	 * @return the checks if is range
	 */
	public Boolean getIsRange() {
		return isRange;
	}

	/**
	 * Sets the checks if is range.
	 *
	 * @param isRange the new checks if is range
	 */
	public void setIsRange(Boolean isRange) {
		this.isRange = isRange;
	}

	/**
	 * Gets the range start.
	 *
	 * @return the range start
	 */
	public String getRangeStart() {
		return rangeStart;
	}

	/**
	 * Sets the range start.
	 *
	 * @param rangeStart the new range start
	 */
	public void setRangeStart(String rangeStart) {
		this.rangeStart = rangeStart;
	}

	/**
	 * Gets the range end.
	 *
	 * @return the range end
	 */
	public String getRangeEnd() {
		return rangeEnd;
	}

	/**
	 * Sets the range end.
	 *
	 * @param rangeEnd the new range end
	 */
	public void setRangeEnd(String rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	/**
	 * Gets the checks if is number range.
	 *
	 * @return the checks if is number range
	 */
	public Boolean getIsNumberRange() {
		return isNumberRange;
	}

	/**
	 * Sets the checks if is number range.
	 *
	 * @param isNumberRange the new checks if is number range
	 */
	public void setIsNumberRange(Boolean isNumberRange) {
		this.isNumberRange = isNumberRange;
	}

	/**
	 * Gets the number range.
	 *
	 * @return the number range
	 */
	public Integer getNumberRange() {
		return numberRange;
	}

	/**
	 * Sets the number range.
	 *
	 * @param numberRange the new number range
	 */
	public void setNumberRange(Integer numberRange) {
		this.numberRange = numberRange;
	}

	/**
	 * Gets the formatted date.
	 *
	 * @return the formatted date
	 */
	public String getFormattedDate() {
		String result = "";

		if (date == null) {
			date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		}
		if (date.indexOf(" ") == -1) {
			result = date + "%";
		} else {
			result = date.substring(0, date.indexOf(" ")) + "%";
		}

		return result;
	}
	
	/**
	 * Gets the formatted range start.
	 *
	 * @return the formatted range start
	 */
	public String getFormattedRangeStart() {
		String result = "";
		
		if (date == null) {
			date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		}
		if (date.indexOf(" ") == -1) {
			result = rangeStart + " 00:00:00";
		} else {
			result = rangeStart;
		}
		
		return result;
	}
	
	/**
	 * Gets the formatted range end.
	 *
	 * @return the formatted range end
	 */
	public String getFormattedRangeEnd() {
		String result = "";
		
		if (date == null) {
			date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		}
		if (date.indexOf(" ") == -1) {
			result = rangeEnd + " 00:00:00";
		} else {
			result = rangeEnd;
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimelineRequest [isRange=" + isRange + ", date=" + date
				+ ", rangeStart=" + rangeStart + ", rangeEnd=" + rangeEnd
				+ ", isNumberRange=" + isNumberRange + ", numberRange="
				+ numberRange + "]";
	}

}
