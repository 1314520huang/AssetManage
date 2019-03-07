package com.asset.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asset.manage.common.utils.DateUtil;
import com.asset.manage.common.utils.StringUtil;
import com.asset.manage.dao.RecordMapper;
import com.asset.manage.model.Record;
import com.asset.manage.model.RecordExample;

@Transactional
@Service
public class RecordService {

	@Autowired
	private RecordMapper recordMapper;

	public void add(HttpServletRequest request, Record record) {

		record.setId(StringUtil.getUUID()).setCreateTime(DateUtil.getNowDate1()).setState(0);
		recordMapper.insertSelective(record);
	}

	public void update(HttpServletRequest request, Record record) {

		recordMapper.updateByPrimaryKeySelective(record);
	}

	public Record info(String id) {

		return recordMapper.selectByPrimaryKey(id);
	}

	public List<Record> list(Record record) {

		RecordExample example = new RecordExample();

		return recordMapper.selectByExample(example);
	}
}
