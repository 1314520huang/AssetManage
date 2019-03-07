package com.asset.manage.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.asset.manage.model.User;

/**
 * 常见的操作方法，包含用户的登录退出操作
 * 
 * @author Administrator
 *
 */
public class CommonUtil {

	public static User isLogin(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("usr");
		return user;
	}

	public static void login(HttpServletRequest request, User user) {

		request.getSession().setAttribute("usr", user);
	}

	public static void logout(HttpServletRequest request) {

		request.getSession().removeAttribute("usr");
	}
}
