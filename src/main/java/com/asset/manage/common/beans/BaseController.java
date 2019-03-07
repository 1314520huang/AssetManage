package com.asset.manage.common.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asset.manage.common.exception.AIException;
import com.asset.manage.common.exception.BusinessException;
import com.asset.manage.common.exception.SystemException;
import com.asset.manage.common.utils.ErrorCode;

/**
 * 公用的controller的实体类，包含了异常的处理，所有的controller层都继承这个类
 * 
 * @author Administrator
 *
 */
public abstract class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	public static final String ERROR_MESSAGE_DEF = "操作失败！";
	
	@ExceptionHandler
	@ResponseBody
    public AjaxResponse handleException(Exception e)throws Exception { 
		logger.error("", e);
		AjaxResponse msg = new AjaxResponse();
		if(e instanceof BusinessException || e instanceof SystemException){
			throw e;
		}
		else if(e instanceof AIException){
	        	AIException aiException = (AIException)e;
	        	msg.setCode(aiException.getErrorCode());
	        	msg.setMessage(aiException.getErrorMessage());
        }
        else{
	        	msg.setCode(ErrorCode.ERROR_DEF);
	        	msg.setMessage(ERROR_MESSAGE_DEF);
        }
        
        return msg;
    }
	
	@InitBinder 
	public void initBinder(WebDataBinder binder) {    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        dateFormat.setLenient(false);    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	}  
}
