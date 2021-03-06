package com.malam.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjs.mybatis.demo.dao.access.AccessIpControlConfigMapper;
import com.wjs.mybatis.demo.domain.access.AccessIpControlConfigCriteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/test-spring-demo-dao.xml"})
public class DemoTestBase{

	@Autowired
	AccessIpControlConfigMapper mapper;
	
	@Test
	public void testOrm(){
		System.out.println(mapper.selectByExample(new AccessIpControlConfigCriteria()));
	}
	
	
	
}
