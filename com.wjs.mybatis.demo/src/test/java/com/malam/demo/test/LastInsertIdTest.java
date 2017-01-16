package com.malam.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.malam.demo.DemoTestBase;
import com.wjs.mybatis.demo.dao.access.AccessIpControlConfigMapper;
import com.wjs.mybatis.demo.domain.access.AccessIpControlConfig;

public class LastInsertIdTest extends DemoTestBase{

	@Autowired
	AccessIpControlConfigMapper mapper;
	
	@Test
	@Transactional
	public void lastInsertIdTest(){
		AccessIpControlConfig config = new AccessIpControlConfig();
		config.setAccessCountDuration(1000L);
		config.setAccessCountMax(100);
		config.setIp("127.0.0.1");
		config.setUri(System.currentTimeMillis() + "");
		mapper.insertSelective(config);
		System.out.println(mapper.lastInsertId());
	}

}

