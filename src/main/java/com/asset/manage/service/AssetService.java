package com.asset.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.CommonUtil;
import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.AssetMapper;
import com.asset.manage.model.Asset;
import com.asset.manage.model.AssetExample;
import com.asset.manage.model.AssetExample.Criteria;
import com.asset.manage.model.User;

@Transactional
@Service
public class AssetService {

	@Autowired
	private AssetMapper assetMapper;

	public void add(HttpServletRequest request, Asset asset) {

		User user = CommonUtil.isLogin(request);
		asset.setId(StringUtil.getUUID()).setJoinTime(DateUtil.getNowDate1()).setJoinId(user.getId()).setJoinName(user.getUserName());
		assetMapper.insertSelective(asset);
	}

	public void update(Asset asset) {

		assetMapper.updateByPrimaryKeySelective(asset);
	}

	public Asset info(String id) {

		return assetMapper.selectByPrimaryKey(id);
	}

	public List<Asset> list(Asset asset) {

		AssetExample example = new AssetExample();
		example.setOrderByClause(" sum_num desc, name asc ");
		if(asset != null) {
			Criteria criteria = example.createCriteria();
			if(StringUtil.isNotNull(asset.getName())) {criteria.andNameLike("%" + asset.getName() + "%");}
			if(StringUtil.isNotNull(asset.getDeptId())) {criteria.andDeptIdEqualTo(asset.getDeptId());}
			if(StringUtil.isNotNull(asset.getTypeId())) {criteria.andTypeIdEqualTo(asset.getTypeId());}
		}
		return assetMapper.selectByExample(example);
	}
}
