package com.asset.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.BorrowMapper;
import com.asset.manage.model.Borrow;
import com.asset.manage.model.BorrowExample;

@Transactional
@Service
public class BorrowService {

	@Autowired
	private BorrowMapper borrowMapper;

	public void add(HttpServletRequest request, Borrow borrow) {

		borrow.setId(StringUtil.getUUID()).setCreateTime(DateUtil.getNowDate1());
		borrowMapper.insertSelective(borrow);
	}

	public void update(Borrow borrow) {

		borrowMapper.updateByPrimaryKeySelective(borrow);
	}
	
	public Borrow info(String id) {
		
		return borrowMapper.selectByPrimaryKey(id);
	}

	public List<Borrow> list(Borrow borrow) {

		BorrowExample example = new BorrowExample();
		example.setOrderByClause(" ");
		return borrowMapper.selectByExample(example);
	}
}
