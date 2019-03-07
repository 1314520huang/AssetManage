package com.asset.manage.common.utils;

/**
 * 操作码集合
 * 
 * @author Administrator
 *
 */
public class ErrorCode {	
	public static final int SUCCESS = 0;
	public static final int ERROR_DEF = -1;
	public static final int UNKNOWN_INTERNAL_ERROR = 1;
	public static final int DB_ERROR = 2;
	public static final int NULL_INPUT = 3;
	public static final int ILLEGAL_REQUEST = 4;
	public static final int CHARACTER_ENCODE = 5;
	public static final int CHARACTER_DENCODE = 6;
	public static final int JSON_ERROR = 7;
	public static final int NULL_OUTPUT = 8;
	public static final int OTHER_ERROR = 9;
	public static final int CHECK_CODE_ERROR = 10;
	
	public static final int USER_INVALID_USER = 50001;
	public static final int USER_INVALID_PASSWORD = 50003;
}