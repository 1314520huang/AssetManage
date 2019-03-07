package com.asset.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.TypeMapper;
import com.asset.manage.model.Type;
import com.asset.manage.model.TypeExample;

/**
 * 处理分类信息，比如用户分类信息，物品分类信息的整合
 * 
 * @author Administrator
 *
 */
@Transactional
@Service
public class TypeService {

	@Autowired
	private TypeMapper typeMapper;

	/**
	 * 添加新的分类信息
	 * 
	 * @param type 新的分类信息 
	 */
	public void add(Type type) {

		type.setId(StringUtil.getUUID()).setCreateTime(DateUtil.getNowDate1()).setState("1");
		typeMapper.insertSelective(type);
	}

	/**
	 * 更新分类信息
	 * 
	 * @param type 更新后的分类
	 */
	public void update(Type type) {

		typeMapper.updateByPrimaryKeySelective(type);
	}
	
	/**
	 * 
	 * @param ids
	 * @param state
	 */
	public void updateMore(String ids, String state) {
		
		String[] idArr = ids.split(",");
		for(String id : idArr) {
			Type type = typeMapper.selectByPrimaryKey(id);
			type.setState(state);
			typeMapper.updateByPrimaryKeySelective(type);
		}
	}

	/**
	 * 查找对应分类下的所有子分类
	 * 
	 * @param pid  主分类主键
	 * @return     当前分类下的所有子分类
	 */
	public List<Type> list() {

		TypeExample example = new TypeExample();
		example.setOrderByClause(" name desc, id desc");
		return typeMapper.selectByExample(example);
	}
}
