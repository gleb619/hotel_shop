/*
 * 
 */
package org.test.shop.controller.data.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class OperationResult.
 */
public class OperationResult implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2460612310765317780L;

	/** The operation. */
	private Operation operation;
	
	/** The result. */
	private String result;
	
	/** The history. */
	private String history;
	
	/** The status. */
	private Integer status;
	
	/** The success. */
	private Boolean success;

	/**
	 * Instantiates a new operation result.
	 */
	public OperationResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Gets the history.
	 *
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * Sets the history.
	 *
	 * @param history the new history
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the success.
	 *
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
