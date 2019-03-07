package com.asset.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asset.manage.common.beans.BaseController;
import com.asset.manage.common.utils.CommonUtil;
import com.asset.manage.common.utils.ManageVals;
import com.asset.manage.common.utils.Remarks;
import com.asset.manage.model.User;
import com.asset.manage.service.MenuService;

/**
 * 负责管理页面跳转的路由转发
 * 
 * @author Administrator
 *
 */
@RequestMapping("")
@Controller
public class PageController extends BaseController {

	@Autowired
	private MenuService menuService;
	
	/**
	 * 默认主页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	@Remarks("默认主页")
	public String index1(HttpServletRequest request) {

		return index(request);
	}

	/**
	 * 默认主页
	 * 
	 * @return
	 */
	@RequestMapping("")
	@Remarks("默认主页")
	public String index2(HttpServletRequest request) {

		return index(request);
	}

	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	@Remarks("跳转到登录界面")
	public String login() {

		return "login";
	}

	/**
	 * 退出登录，返回到登录界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	@Remarks("退出登录")
	public String logout(HttpServletRequest request) {

		CommonUtil.logout(request);
		return "login";
	}

	/**
	 * 管理员控制功能
	 * 
	 * @param request
	 * @param manage
	 * @return
	 */
	@RequestMapping("/{type}/{manage}")
	@Remarks("管理员管控功能")
	public String admin(HttpServletRequest request, @PathVariable String type, @PathVariable String manage) {

		if(ManageVals.USER.equals(manage))	request.setAttribute("menu", menuService.getForUser());
		else if(ManageVals.SEARCH.equals(manage))	request.setAttribute("menu", menuService.getForAsset(request));
		else if(ManageVals.PURCHASE.equals(manage))	request.setAttribute("menu", menuService.getForAsset(request));
		return type + "/" + manage;
	}

	@RequestMapping("/info")
	@Remarks("个人主页")
	public String info(HttpServletRequest request) {

		if(CommonUtil.isLogin(request) == null) 
			return "login";
		return "self/info";
	}

	private String index(HttpServletRequest request) {

		User user = CommonUtil.isLogin(request);
		if (user == null)
			return "login";
		request.setAttribute("", true);
		return "index";
	}
}
