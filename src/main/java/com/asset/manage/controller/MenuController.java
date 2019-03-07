package com.asset.manage.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asset.manage.common.beans.AjaxResponse;
import com.asset.manage.common.beans.BaseController;
import com.asset.manage.common.utils.Remarks;
import com.asset.manage.service.MenuService;

/**
 * 下拉框映射
 * 
 * @author Administrator
 *
 */
@RequestMapping("/menus")
@Controller
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/user")
	@Remarks("获取搜索下拉列表数据")
	@ResponseBody
	public AjaxResponse getForUser(HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		Map<String, Object> map = menuService.getForUser();
		response.setData(map);
		return response;
	}

	@GetMapping("/asset")
	@Remarks("获取搜索下拉列表数据")
	@ResponseBody
	public AjaxResponse getForAsset(HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		Map<String, Object> map = menuService.getForAsset(request);
		response.setData(map);
		return response;
	}

	@GetMapping("/assetType")
	@Remarks("获取搜索下拉列表数据")
	@ResponseBody
	public AjaxResponse getForAssetType(HttpServletRequest request) {

		AjaxResponse response = new AjaxResponse();
		Map<String, Object> map = menuService.getForAssetType();
		response.setData(map);
		return response;
	}
}
