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
import com.asset.manage.common.utils.Remarks;
import com.asset.manage.model.Asset;
import com.asset.manage.service.AssetService;

/**
 * 物资管理
 * 
 * @author Administrator
 *
 */
@RequestMapping("/assets")
@Controller
public class AssetController extends BaseController {

	@Autowired
	private AssetService assetService;

	/**
	 * 新增物资
	 * 
	 * @param asset 新增的物资对象
	 * @return 返回操作结果
	 */
	@PostMapping("")
	@Remarks("新增物资")
	@ResponseBody
	public AjaxResponse add(HttpServletRequest request, Asset asset) {

		assetService.add(request, asset);
		return new AjaxResponse();
	}

	/**
	 * 更新物资
	 * 
	 * @param asset 更新后的物资信息
	 * @return  返回操作结果
	 */
	@PatchMapping("")
	@Remarks("更新物资")
	@ResponseBody
	public AjaxResponse update(Asset asset) {

		assetService.update(asset);
		return new AjaxResponse();
	}

	/**
	 * 根据对应主键找到物资详情信息
	 * 
	 * @param id 物资主键
	 * @return   物资详情
	 */
	@GetMapping("/{id}")
	@Remarks("根据对应主键找到物资详情信息")
	@ResponseBody
	public AjaxResponse info(@PathVariable String id) {

		AjaxResponse response = new AjaxResponse();
		Asset asset = assetService.info(id);
		response.setData(asset);
		return response;
	}

	/**
	 * 物资列表
	 * 
	 * @param asset  物资条件集合
	 * @return       返回符合条件的物资详情列表信息
	 */
	@GetMapping("")
	@Remarks("返回对应的资产列表")
	@ResponseBody
	public AjaxResponse list(Asset asset) {

		AjaxResponse response = new AjaxResponse();
		List<Asset> assets = assetService.list(asset);
		response.setData(assets);
		return response;
	}
}
