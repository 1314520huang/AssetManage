package com.asset.manage.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码相关的工具类
 * 
 * @author Administrator
 *
 */
public class PasswordUtil {

	/**
	 * 对密码进行加密
	 * 
	 * @param password
	 *            前台传递的密码
	 * @param salt
	 *            该密码的加盐参数
	 * @return
	 */
	public static String encode(String password, String salt) {

		return blend(password + " - " + salt);
	}

	/**
	 * 将传过来的密码加密进行和数据当中的密码进行比对
	 * 
	 * @param password
	 *            前台传递的密码
	 * @param salt
	 *            当前密码对应的加密参数
	 * @param datapass
	 *            数据库存放的加密密文
	 * @return
	 */
	public static boolean decode(String password, String salt, String datapass) {

		String nowPassword = blend(password + " - " + salt);
		return StringUtil.isSame(nowPassword, datapass);
	}

	public static String blend(String text) {

		// 密码多次MD5 加密
		for (int i = 0; i < 8; i++) {
			text = DigestUtils.md5Hex(text);
		}
		return text;
	}

	public static void main(String[] args) {

		System.out.println(encode("123456", "5d3914"));
	}
}
