package com.asset.manage.common.beans;

import java.io.Serializable;

import com.asset.manage.common.utils.ErrorCode;

/**
 * 请求的返回体
 * 包含了响应码，响应信息和相应主体
 * 
 * @author Administrator
 *
 */
public class AjaxResponse implements Serializable {
	
	private static final long serialVersionUID = -228336292076840249L;
	private int code = ErrorCode.SUCCESS;
	private String message = "操作成功！";
	
	private Object data;
	
	public AjaxResponse() {
		super();
	}
	public AjaxResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public AjaxResponse(Object data) {
		super();
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
