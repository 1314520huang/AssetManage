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
import com.asset.manage.model.Borrow;
import com.asset.manage.service.BorrowService;

/**
 * 管理物资的借出与归还的信息
 * 
 * @author Administrator
 *
 */
@RequestMapping("/borrows")
@Controller
public class BorrowController extends BaseController {

	@Autowired
	private BorrowService borrowService;

	/**
	 * 物资借出记录
	 * 
	 * @param request
	 *            对应参数
	 * @param borrow
	 *            借出物资的信息与借出人信息
	 * @return 操作结果
	 */
	@PostMapping("")
	@Remarks("新增借出信息")
	@ResponseBody
	public AjaxResponse add(HttpServletRequest request, Borrow borrow) {

		borrowService.add(request, borrow);
		return new AjaxResponse();
	}

	/**
	 * 更新借出信息，比如归还或者删除此信息
	 * 
	 * @param borrow
	 *            借出信息更新
	 * @return 操作结果
	 */
	@PatchMapping("")
	@Remarks("更新借出信息，比如归还或者删除此信息")
	@ResponseBody
	public AjaxResponse update(Borrow borrow) {

		borrowService.update(borrow);
		return new AjaxResponse();
	}

	/**
	 * 借出的物资信息
	 * 
	 * @param id
	 *            对应的物资主键
	 * @return 返回当前物资的借出信息
	 */
	@GetMapping("/{id}")
	@Remarks("借出的物资信息")
	@ResponseBody
	public AjaxResponse info(@PathVariable String id) {

		AjaxResponse response = new AjaxResponse();
		Borrow borrow = borrowService.info(id);
		response.setData(borrow);
		return response;
	}

	/**
	 * 返回满足的借出信息列表
	 * 
	 * @param borrow
	 *            借出信息整合
	 * @return 满足条件的借出信息的整合
	 */
	@GetMapping("")
	@Remarks("返回满足的借出信息列表")
	@ResponseBody
	public AjaxResponse list(Borrow borrow) {

		AjaxResponse response = new AjaxResponse();
		List<Borrow> borrows = borrowService.list(borrow);
		response.setData(borrows);
		return response;
	}
}
