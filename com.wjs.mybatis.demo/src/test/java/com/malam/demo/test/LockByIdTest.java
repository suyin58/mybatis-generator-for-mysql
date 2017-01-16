package com.malam.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.malam.demo.DemoTestBase;
import com.wjs.mybatis.demo.dao.access.AccessIpControlConfigMapper;

public class LockByIdTest extends DemoTestBase{

	@Autowired
	AccessIpControlConfigMapper mapper;
	@Test
	@Transactional(rollbackFor=Exception.class)
	public void testLock(){
		
		System.out.println(mapper.lockByPrimaryKey(1L));
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
		}
	}
	
	@Test
	public void testLock1(){
		System.out.println(mapper.lockByPrimaryKey(1L));;
	}
}

