package com.asset.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.dao.DeptMapper;
import com.asset.manage.model.Dept;
import com.asset.manage.model.DeptExample;

@Transactional
@Service
public class DeptService {

	@Autowired
	private DeptMapper deptMapper;

	public void add(Dept dept) {

		dept.setCreateTime(DateUtil.getNowDate1()).setState(1);
		deptMapper.insertSelective(dept);
	}

	public void update(Dept dept) {

		deptMapper.updateByPrimaryKeySelective(dept);
	}

	public void updateMore(String ids, int state) {

		String[] idArr = ids.split(",");
		for (String id : idArr) {
			Dept dept = deptMapper.selectByPrimaryKey(id);
			dept.setState(state);
			deptMapper.updateByPrimaryKeySelective(dept);
		}
	}

	public List<Dept> list() {

		DeptExample example = new DeptExample();
		example.setOrderByClause(" id asc ");
		return deptMapper.selectByExample(example);
	}
}
