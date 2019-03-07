package com.asset.manage.common.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解，用来补充说明
 * 
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Remarks {
	String value() default "";
	String module() default "";
	String type1() default "";
	String type2() default "";
	String type3() default "";
	String eventId() default "";
	String platform() default "";
	String operateType() default "";
}
