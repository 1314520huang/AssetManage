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
import com.asset.manage.model.Record;
import com.asset.manage.service.RecordService;

@RequestMapping("/records")
@Controller
public class RecordController extends BaseController {

	@Autowired
	private RecordService recordService;

	/**
	 * 新增操作记录，比如新增资产
	 * 
	 * @param request
	 *            请求参数
	 * @param record
	 *            操作记录
	 * @return 操作结果
	 */
	@PostMapping("")
	public AjaxResponse add(HttpServletRequest request, Record record) {

		recordService.add(request, record);
		return new AjaxResponse();
	}

	/**
	 * 对应的操作记录
	 * 
	 * @param id
	 *            操作记录主键
	 * @return
	 */
	@GetMapping("/{id}")
	@Remarks("操作记录")
	@ResponseBody
	public AjaxResponse info(@PathVariable String id) {

		AjaxResponse response = new AjaxResponse();
		Record record = recordService.info(id);
		response.setData(record);
		return response;
	}

	/**
	 * 
	 * @param request
	 * @param record
	 * @return
	 */
	@PatchMapping("")
	public AjaxResponse update(HttpServletRequest request, Record record) {

		recordService.update(request, record);
		return new AjaxResponse();
	}

	/**
	 * 操作记录的列表
	 * 
	 * @param record
	 *            操作记录条件集合
	 * @return
	 */
	@GetMapping("")
	@Remarks("操作记录列表")
	@ResponseBody
	public AjaxResponse list(Record record) {

		AjaxResponse response = new AjaxResponse();
		List<Record> records = recordService.list(record);
		response.setData(records);
		return response;
	}
}
