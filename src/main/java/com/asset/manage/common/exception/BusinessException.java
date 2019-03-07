package com.asset.manage.common.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	protected String errcode;
    
    public BusinessException(String errcode, String errmsg){ 
    	super(errmsg);
        this.errcode = errcode;
    }
    
    public BusinessException(String errcode, String errmsg, Throwable cause){ 
    	super(errmsg, cause);
        this.errcode = errcode;
    }

	public String getErrcode() {
		return errcode;
	}
}
