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
import com.asset.manage.model.Type;
import com.asset.manage.service.TypeService;

@RequestMapping("/types")
@Controller
public class TypeController extends BaseController {

	@Autowired
	private TypeService typeService;

	/**
	 * 新增类别
	 * 
	 * @param   type新增类别
	 * @return  操作结果
	 */
	@PostMapping("")
	@Remarks("新增类别")
	@ResponseBody
	public AjaxResponse add(Type type) {

		typeService.add(type);
		return new AjaxResponse();
	}

	/**
	 * 更新类别信息
	 * 
	 * @param type  更新后的类别
	 * @return      操作结果
	 */
	@PatchMapping("")
	@Remarks("更新类别信息")
	@ResponseBody
	public AjaxResponse update(Type type) {

		typeService.update(type);
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
	public AjaxResponse updateMore(@PathVariable String ids, @PathVariable String state) {

		typeService.updateMore(ids, state);
		return new AjaxResponse();
	}

	/**
	 * 获取父类下的所有分类
	 * 
	 * @param pid  父类主键
	 * @return     父类下的所有分类
	 */
	@GetMapping("")
	@Remarks("父类下的所有分类")
	@ResponseBody
	public AjaxResponse list() {

		AjaxResponse response = new AjaxResponse();
		List<Type> types = typeService.list();
		response.setData(types);
		return response;
	}
}
