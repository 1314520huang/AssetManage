package com.asset.manage.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AIException extends RuntimeException {
	private static final long serialVersionUID = -8798278124229763202L;
	private static Log log = LogFactory.getLog(AIException.class);
	
	private int errorCode = 0;
	
	public AIException(String errorString) {
		this(9, errorString);
	}
	
	public AIException(int errorCode, String errorString) {
		super(errorString);
		this.errorCode = errorCode;
		
		log.error("ServiceException: errorCode=" + errorCode + ", errorMessage=" + errorString, this);
	}
	
	public AIException(String errorString, Throwable cause) {
		this(9, errorString, cause);
	}
	public AIException(int errorCode, String errorString, Throwable cause) {
		super(errorString, cause);
		this.errorCode = errorCode;
		
		log.error("ServiceException: errorCode=" + errorCode + ", errorMessage=" + errorString, this);
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.getMessage();
	}
}
