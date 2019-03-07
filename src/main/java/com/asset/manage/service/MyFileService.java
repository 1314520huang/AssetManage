package com.asset.manage.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asset.manage.common.exception.AIException;
import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.MyFileMapper;
import com.asset.manage.model.MyFile;

@Transactional
@Service
public class MyFileService {

	@Autowired
	private MyFileMapper myFileMapper;

	public void add(MyFile myFile) {

		myFile.setUploadTime(DateUtil.getNowDate1()).setState(1);
		myFileMapper.insertSelective(myFile);
	}

	public String upload(HttpServletRequest request, MultipartFile file) {

		if (file == null)
			throw new AIException("文件为空，请重新选择");
		String id = StringUtil.getUUID();
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.indexOf('.'));
		String url = request.getSession().getServletContext().getRealPath("/") + "/upload/" + id + suffix;
		String url1 = request.getContextPath() + "/upload/" + id + suffix;
		try {
			file.transferTo(new File(url));
			MyFile file2 = new MyFile();
			file2.setId(id);
			file2.setUrl(url);
			myFileMapper.insert(file2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url1;
	}

	public void show(HttpServletRequest request, HttpServletResponse response, String id) {

	}
}
