package com.asset.manage.common.exception;

import java.io.Serializable;

public class SystemException extends RuntimeException implements Serializable {   

	private static final long serialVersionUID = 1L;
	protected String errcode;
    
    public SystemException(String errcode, String errmsg){ 
    	super(errmsg);
        this.errcode = errcode;
    }
    
    public SystemException(String errmsg){ 
    	super(errmsg);
        this.errcode = "999999";        
    }
    
    public SystemException(String errcode, String errmsg, Throwable cause){ 
    	super(errmsg, cause);
        this.errcode = errcode;
    }

	public String getErrcode() {
		return errcode;
	}
}
