package com.malam.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.malam.demo.DemoTestBase;
import com.wjs.mybatis.demo.dao.access.AccessIpControlConfigMapper;
import com.wjs.mybatis.demo.domain.access.AccessIpControlConfigCriteria;

public class LockByExampleTest extends DemoTestBase{

	@Autowired
	AccessIpControlConfigMapper mapper;
	@Test
	@Transactional(rollbackFor=Exception.class)
	public void testLock(){
		
		AccessIpControlConfigCriteria crt = new AccessIpControlConfigCriteria();
		crt.createCriteria().andIdEqualTo(1L);
		System.out.println(mapper.lockByExample(crt));
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
		}
	}
	
	@Test
	public void testLock1(){
		
		AccessIpControlConfigCriteria crt = new AccessIpControlConfigCriteria();
		crt.createCriteria().andIdEqualTo(1L);
		System.out.println(mapper.lockByExample(crt));
	}
}

