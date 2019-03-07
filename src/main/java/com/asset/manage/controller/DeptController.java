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
import com.asset.manage.model.Dept;
import com.asset.manage.service.DeptService;

@RequestMapping("/depts")
@Controller
public class DeptController extends BaseController {

	@Autowired
	private DeptService deptService;

	/**
	 * 新增部门信息
	 * 
	 * @param dept
	 *            新增的部门信息
	 * @return 操作结果
	 */
	@PostMapping("")
	@Remarks("新增部门信息")
	@ResponseBody
	public AjaxResponse add(Dept dept) {

		deptService.add(dept);
		return new AjaxResponse();
	}

	/**
	 * 更新部门信息
	 * 
	 * @param dept
	 *            更新的部门信息
	 * @return 操作结果
	 */
	@PatchMapping("")
	@Remarks("更新部门信息")
	@ResponseBody
	public AjaxResponse update(Dept dept) {

		return new AjaxResponse();
	}

	/**
	 *  批量删除用户信息
	 * 
	 * @param ids
	 *            被删除的批量用户主键
	 * @param state
	 * @return
	 */
	@PatchMapping("/{ids}/{state}")
	@Remarks("批量更新状态")
	@ResponseBody
	public AjaxResponse updateMore(@PathVariable String ids, @PathVariable int state) {

		deptService.updateMore(ids, state);
		return new AjaxResponse();
	}

	/**
	 * 查找对应的部门列表
	 * 
	 * @param dept
	 *            查找的部门条件集合
	 * @return 对应的部门列表
	 */
	@GetMapping("")
	@Remarks("对应的部门列表")
	@ResponseBody
	public AjaxResponse list(Dept dept) {

		AjaxResponse response = new AjaxResponse();
		List<Dept> depts = deptService.list();
		response.setData(depts);
		return response;
	}
}
