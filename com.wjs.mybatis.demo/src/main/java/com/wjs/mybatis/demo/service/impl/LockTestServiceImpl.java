package com.wjs.mybatis.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjs.mybatis.demo.dao.access.AccessIpControlConfigMapper;
import com.wjs.mybatis.demo.service.LockTestService;
import com.wjs.util.annotation.LockForUpdateWait;

@Service("lockTestService")
public class LockTestServiceImpl implements LockTestService{

	@Autowired
	AccessIpControlConfigMapper mapper;
	
	@LockForUpdateWait // 需要在开启事物的环境中有用，否则没有效果
	public void lockForUpdateNoWait(Long id) {
		mapper.lockByPrimaryKey(id);
	}

	public void lockForUpdateWait(Long id) {
		mapper.lockByPrimaryKey(id);
	}

}
