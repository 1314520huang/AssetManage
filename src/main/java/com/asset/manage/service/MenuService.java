package com.asset.manage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.CommonUtil;
import com.asset.manage.model.Dept;
import com.asset.manage.model.Role;
import com.asset.manage.model.Type;
import com.asset.manage.model.User;

@Transactional
@Service
public class MenuService {

	@Autowired
	private RoleService roleService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private TypeService typeService;

	/**
	 * 关于角色和部门的下拉框
	 * 
	 * @return
	 */
	public Map<String, Object> getForUser() {

		Map<String, Object> map = new HashMap<>();
		List<Role> roles = roleService.list();
		List<Dept> depts = deptService.list();
		map.put("roles", roles);
		map.put("depts", depts);
		return map;
	}

	/**
	 * 关于分类和部门的下拉框
	 *
	 * @return
	 */
	public Map<String, Object> getForAsset(HttpServletRequest request) {

		Map<String, Object> map = new HashMap<>();
		List<Type> types = typeService.list();
		List<Dept> depts = deptService.list();
		User user = CommonUtil.isLogin(request);
		map.put("types", types);
		map.put("depts", depts);
		map.put("user", user);
		return map;
	}
	

	/**
	 * 关于分类的下拉框
	 *
	 * @return
	 */
	public Map<String, Object> getForAssetType() {

		Map<String, Object> map = new HashMap<>();
		List<Type> types = typeService.list();
		map.put("types", types);
		return map;
	}
}
