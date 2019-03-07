package com.asset.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asset.manage.common.beans.AjaxResponse;
import com.asset.manage.common.beans.BaseController;
import com.asset.manage.common.utils.CommonUtil;
import com.asset.manage.common.utils.Remarks;
import com.asset.manage.model.User;
import com.asset.manage.service.UserService;

@RequestMapping("/users")
@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 用户登录操作
	 * 
	 * @param request
	 *            参数请求
	 * @param loginName
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return 操作结果
	 */
	@PostMapping("/login")
	@Remarks("用户登录")
	@ResponseBody
	public AjaxResponse login(HttpServletRequest request, String loginName, String password) {

		AjaxResponse response = new AjaxResponse();
		User user = userService.login(request, loginName, password);
		response.setData(user);
		return response;
	}

	/**
	 * 注册新用户
	 * 
	 * @param user
	 *            注册的用户信息
	 * @return 操作结果
	 */
	@PostMapping("")
	@Remarks("注册新用户")
	@ResponseBody
	public AjaxResponse register(User user) {

		userService.register(user);
		return new AjaxResponse();
	}

	/**
	 * 查找用户信息
	 * 
	 * @param id
	 *            用户主键
	 * @return 对应的用户信息
	 */
	@GetMapping("/{id}")
	@Remarks("查找用户信息")
	@ResponseBody
	public AjaxResponse info(@PathVariable String id) {

		AjaxResponse response = new AjaxResponse();
		User user = userService.info(id);
		response.setData(user);
		return response;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            更新的用户信息
	 * @return 操作结果
	 */
	@PostMapping("/update")
	@Remarks("更新用户信息")
	@ResponseBody
	public AjaxResponse update(HttpServletRequest request, User user) {

		userService.update(request, user);
		return new AjaxResponse();
	}

	/**
	 * 批量更新用户
	 * 
	 * @param ids
	 *            被删除的用户主键的集合
	 * @param state
	 * 			  被更新的状态
	 * @return
	 */
	@PatchMapping("/{ids}/{state}")
	@Remarks("批量删除用户")
	@ResponseBody
	public AjaxResponse updateMore(@PathVariable String ids, @PathVariable String state) {
		
		userService.updateMore(ids, state);
		return new AjaxResponse();
	}

	/**
	 * 获取当前登录的用户信息
	 * 
	 * @param request
	 *            请求参数
	 * @return 执行结果
	 */
	@GetMapping("/info")
	@Remarks("当前登录的用户信息")
	@ResponseBody
	public AjaxResponse info(HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		User user = CommonUtil.isLogin(request);
		response.setData(user);
		return response;
	}

	/**
	 * 查找对应的用户列表
	 * 
	 * @param user
	 *            需要查找的用户集合
	 * @return
	 */
	@GetMapping("")
	@Remarks("对应的用户列表")
	@ResponseBody
	public AjaxResponse list(User user) {

		AjaxResponse response = new AjaxResponse();
		List<User> users = userService.search(user);
		response.setData(users);
		return response;
	}
}
