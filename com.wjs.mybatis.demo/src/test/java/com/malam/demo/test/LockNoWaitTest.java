package com.malam.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.malam.demo.DemoTestBase;
import com.wjs.mybatis.demo.service.LockTestService;

public class LockNoWaitTest  extends DemoTestBase{
	
	@Autowired
	LockTestService lockTestService;
	
	@Test
	@Transactional
	public void testLockWait(){
		lockTestService.lockForUpdateWait(1L);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	public void testLockNoWait(){
		lockTestService.lockForUpdateNoWait(1L);
	}

}
