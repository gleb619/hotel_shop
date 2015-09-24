/*
 * 
 */
package org.test.shop.model.domain.entity.other;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Log.
 */
public class Log implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2885972009083896026L;
	
	/** The level. */
	private String level;
	
	/** The time. */
	private String time;
	
	/** The thread. */
	private String thread;
	
	/** The logger. */
	private String logger;
	
	/** The method. */
	private String method;
	
	/** The msg. */
	private String msg;

	/**
	 * Instantiates a new log.
	 */
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Gets the thread.
	 *
	 * @return the thread
	 */
	public String getThread() {
		return thread;
	}

	/**
	 * Sets the thread.
	 *
	 * @param thread the new thread
	 */
	public void setThread(String thread) {
		this.thread = thread;
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public String getLogger() {
		return logger;
	}

	/**
	 * Sets the logger.
	 *
	 * @param logger the new logger
	 */
	public void setLogger(String logger) {
		this.logger = logger;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets the method.
	 *
	 * @param method the new method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg.
	 *
	 * @param msg the new msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Log [level=" + level + ", time=" + time + ", thread=" + thread
				+ ", logger=" + logger + ", method=" + method + ", msg=" + msg
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((logger == null) ? 0 : logger.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((thread == null) ? 0 : thread.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (logger == null) {
			if (other.logger != null)
				return false;
		} else if (!logger.equals(other.logger))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (thread == null) {
			if (other.thread != null)
				return false;
		} else if (!thread.equals(other.thread))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

}
