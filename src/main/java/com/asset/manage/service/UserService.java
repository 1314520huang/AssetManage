package com.asset.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.exception.AIException;
import com.asset.manage.common.utils.CommonUtil;
import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.PasswordUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.UserMapper;
import com.asset.manage.model.User;
import com.asset.manage.model.UserExample;
import com.asset.manage.model.UserExample.Criteria;

/**
 * 处理用户相关的数据操作
 * 
 * @author Administrator
 *
 */
@Transactional
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据账号密码给出对应的提示 用户存在： 密码正确： 则返回对应的用户，同时将对应的用户信息保存在session当中，同时保存最后一次成功登录的时间
	 * 密码不正确：给出对应的提示 用户不存在： 给出对应的提示
	 * 
	 * @param request
	 *            请求参数
	 * @param loginName
	 *            登录名
	 * @param password
	 *            密码
	 * @return 返回对应的结果集
	 */
	public User login(HttpServletRequest request, String loginName, String password) {

		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<User> users = userMapper.selectByExample(example);
		User user = null;
		if (users != null && users.size() != 0) {
			user = users.get(0);
			if (!PasswordUtil.decode(password, user.getSalt(), user.getPassword())) {
				throw new AIException("账号或密码不正确");
			} else {
				/*
				 * if(user.getLevel() == 0) { throw new
				 * AIException("当前账号被禁用，请联系管理员恢复使用"); }
				 */
				user.setLastLoginTime(DateUtil.getNowDate1());
				userMapper.updateByPrimaryKeySelective(user);
				CommonUtil.login(request, user);
			}
		} else {
			throw new AIException("当前用户尚未注册");
		}
		return user;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            被更新的用户
	 */
	public void update(HttpServletRequest request, User user) {

		if (StringUtil.isNotNull(user.getPassword())) {
			String id = user.getId();
			String salt = userMapper.selectByPrimaryKey(id).getSalt();
			String password = PasswordUtil.encode(user.getPassword(), salt);
			user.setPassword(password);
		}
		userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            注册的用户信息
	 */
	public void register(User user) {

		if (isExists(user.getLoginName())) {
			throw new AIException("当前用户已存在");
		}
		String salt = StringUtil.getSalt();
		user.setId(StringUtil.getUUID()).setSalt(salt).setPassword(PasswordUtil.encode(user.getPassword(), salt))
				.setCreateTime(DateUtil.getNowDate1()).setState("1");
		userMapper.insertSelective(user);
	}

	/**
	 * 用户信息
	 * 
	 * @param id
	 *            用户主键
	 * @return 返回对应的用户信息
	 */
	public User info(String id) {

		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查找对应的用户
	 * 
	 * @param user
	 *            用户查找条件
	 * @return 返回符合条件的用户集
	 */
	public List<User> search(User user) {

		UserExample example = new UserExample();
		example.setOrderByClause(" level asc, login_name asc, id asc ");
		Criteria criteria = example.createCriteria();
		if (user != null) {
			if (StringUtil.isNotNull(user.getUserName()))
				criteria.andUserNameLike("%" + user.getUserName() + "%");
			if (StringUtil.isNotNull(user.getLevel()))
				criteria.andLevelEqualTo(user.getLevel());
			if (StringUtil.isNotNull(user.getDeptId()))
				criteria.andDeptIdEqualTo(user.getDeptId());
			if (StringUtil.isNotNull(user.getState()))
				criteria.andStateEqualTo(user.getState());
		}
		return userMapper.selectByExample(example);
	}

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 *            被删除的用户主键集合
	 */
	public void updateMore(String ids, String state) {

		String[] idArr = ids.split(",");
		for (String id : idArr) {
			User user = userMapper.selectByPrimaryKey(id);
			user.setState(state);
			userMapper.updateByPrimaryKeySelective(user);
		}
	}

	/**
	 * 判断当前登录名是否已经被使用了
	 * 
	 * @param loginName
	 *            登录名称
	 * @return 但钱用户是否已经注册
	 */
	private boolean isExists(String loginName) {

		UserExample example = new UserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		int cnt = userMapper.countByExample(example);
		return cnt == 0 ? false : true;
	}
}
