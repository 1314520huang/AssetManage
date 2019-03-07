package com.asset.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.asset.manage.common.beans.AjaxResponse;
import com.asset.manage.common.beans.BaseController;
import com.asset.manage.model.MyFile;
import com.asset.manage.service.MyFileService;

@RequestMapping("/files")
@Controller
public class MyFileController extends BaseController {

	@Autowired
	private MyFileService myFileService;

	public AjaxResponse add(MyFile myFile) {

		myFileService.add(myFile);
		return new AjaxResponse();
	}

	/**
	 * 
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	public AjaxResponse upload(HttpServletRequest request, MultipartFile file) {

		AjaxResponse response = new AjaxResponse();

		return response;
	}

	/**
	 * 查看对应的文件信息
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	public AjaxResponse show(HttpServletRequest request, HttpServletResponse response, String id) {

		
		return new AjaxResponse();
	}
}
