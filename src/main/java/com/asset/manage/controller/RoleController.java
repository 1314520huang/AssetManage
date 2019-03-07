package com.asset.manage.controller;

import java.util.List;

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
import com.asset.manage.common.utils.Remarks;
import com.asset.manage.model.Role;
import com.asset.manage.service.RoleService;

@RequestMapping("/roles")
@Controller
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	/**
	 * 新增角色
	 * 
	 * @param role
	 *            新增的角色
	 * @return 操作结果
	 */
	@PostMapping("")
	@Remarks("新增角色")
	@ResponseBody
	public AjaxResponse add(Role role) {

		roleService.add(role);
		return new AjaxResponse();
	}

	/**
	 * 更新对应的角色
	 * 
	 * @param role
	 *            被更新的角色对象
	 * @return 操作结果
	 */
	@PatchMapping("")
	@Remarks("更新角色")
	@ResponseBody
	public AjaxResponse update(Role role) {

		roleService.update(role);
		return new AjaxResponse();
	}

	/**
	 * 
	 * @param ids
	 * @param state
	 * @return
	 */
	@PatchMapping("/{ids}/{state}")
	@Remarks("批量更新角色")
	@ResponseBody
	public AjaxResponse updateMore(@PathVariable String ids, @PathVariable int state) {

		roleService.updateMore(ids, state);
		return new AjaxResponse();
	}

	/**
	 * 返回所有的角色列表
	 * 
	 * @return 操作结果
	 */
	@GetMapping("")
	@Remarks("获取所有角色")
	@ResponseBody
	public AjaxResponse list() {

		AjaxResponse response = new AjaxResponse();
		List<Role> roles = roleService.list();
		response.setData(roles);
		return response;
	}
}
