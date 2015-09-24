/*
 * 
 */
package org.test.shop.model.service.data.types;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MailSetting.
 */
public class MailSetting implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3947413293824055695L;

	/** The to. */
	private String to;
	
	/** The from. */
	private String from;
	
	/** The subject. */
	private String subject;
	
	/** The content. */
	private String content;
	
	/** The is multipart. */
	private Boolean isMultipart;
	
	/** The is html. */
	private Boolean isHtml;
	
	private Map<String, File> files = new HashMap<String, File>();
	
	/**
	 * Instantiates a new mail setting.
	 */
	public MailSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MailSetting(String to, String from, String subject, String content,
			Boolean isMultipart, Boolean isHtml, Map<String, File> files) {
		super();
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.content = content;
		this.isMultipart = isMultipart;
		this.isHtml = isHtml;
		this.files = files;
	}



	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the checks if is multipart.
	 *
	 * @return the checks if is multipart
	 */
	public Boolean getIsMultipart() {
		return isMultipart;
	}

	/**
	 * Sets the checks if is multipart.
	 *
	 * @param isMultipart the new checks if is multipart
	 */
	public void setIsMultipart(Boolean isMultipart) {
		this.isMultipart = isMultipart;
	}

	/**
	 * Gets the checks if is html.
	 *
	 * @return the checks if is html
	 */
	public Boolean getIsHtml() {
		return isHtml;
	}

	/**
	 * Sets the checks if is html.
	 *
	 * @param isHtml the new checks if is html
	 */
	public void setIsHtml(Boolean isHtml) {
		this.isHtml = isHtml;
	}

	public Map<String, File> getFiles() {
		return files;
	}

	public void setFiles(Map<String, File> files) {
		this.files = files;
	}

	

}
