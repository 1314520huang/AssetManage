package com.asset.manage.common.utils;

import java.util.UUID;

/**
 * 字符串工具类
 * 
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * 获取随机主键
	 * 
	 * @return
	 */
	public static String getUUID() {

		return getStr(32);
	}

	/**
	 * 获取加盐参数
	 * 
	 * @return
	 */
	public static String getSalt() {

		return getStr(6);
	}

	/**
	 * 判断当前传递过来的可变长数据是否存在空字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static boolean isNotNull(String... strs) {

		for (String str : strs) {
			if (str == null || str.length() == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断两个字符串是否一致
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isSame(String str1, String str2) {
		
		return str1.compareTo(str2) == 0;
	}
	
	public static int[] getInt(String index, String size) {
		
		int pageIndex = 1, pageSize = 10;
		if(StringUtil.isNotNull(index))	{pageIndex = Integer.parseInt(index);}
		if(StringUtil.isNotNull(size))	{pageSize = Integer.parseInt(size);}
		int[] value = new int[2];
		value[0] = pageIndex;
		value[1] = pageSize;
		return value;
	}
	
	/**
	 * 获取指定长度的字符串
	 * 
	 * @param len 指定随机字符串长度
	 * @return
	 */
	private static String getStr(int len) {

		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, len);
	}

	public static void main(String[] args) {

		System.out.println(getUUID());/*
		String salt = getSalt();
		System.out.println("Salt = " + salt);
		System.out.println("Passwd = " + PasswordUtil.encode("123456", salt));*/
		System.out.println(DateUtil.getNowTime());
	}
}
