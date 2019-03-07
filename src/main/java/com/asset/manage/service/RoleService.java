package com.asset.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.dao.RoleMapper;
import com.asset.manage.model.Role;
import com.asset.manage.model.RoleExample;

/**
 * 处理角色相关的响应
 * 
 * @author Administrator
 *
 */
@Transactional
@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 添加新角色
	 * 
	 * @param role 新角色
	 */
	public void add(Role role) {

		role.setRemark("后台默认添加").setState(1);
		roleMapper.insertSelective(role);
	}

	/**
	 * 更新角色，或者角色伪删除操作
	 * 
	 * @param role 被更新的角色对象
	 */
	public void update(Role role) {

		roleMapper.updateByPrimaryKeySelective(role);
	}

	/**
	 * 删除多个角色
	 * 
	 * @param ids 角色主键集合
	 */
	public void updateMore(String ids, int state) {
		
		String[] idArr = ids.split(",");
		for(String id : idArr) {
			Role role = roleMapper.selectByPrimaryKey(id);
			role.setState(state);
			roleMapper.updateByPrimaryKeySelective(role);
		}
	}
	
	/**
	 * 获取角色列表
	 * 
	 * @return 当前所有的角色
	 */
	public List<Role> list() {

		RoleExample example = new RoleExample();
		example.setOrderByClause(" id asc ");
		return roleMapper.selectByExample(example);
	}
}
