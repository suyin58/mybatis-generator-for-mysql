package com.malam.demo.test;

import org.junit.Test;
import org.mybatis.plugin.PageDataList;
import org.springframework.beans.factory.annotation.Autowired;

import com.malam.demo.DemoTestBase;
import com.malam.demo.dao.access.AccessIpControlConfigMapper;
import com.malam.demo.domain.access.AccessIpControlConfig;
import com.malam.demo.domain.access.AccessIpControlConfigCriteria;

public class PageTest extends DemoTestBase{

	@Autowired
	AccessIpControlConfigMapper mapper;
	
	@Test
	public void pageTest(){
		try {
			AccessIpControlConfigCriteria crt  = new AccessIpControlConfigCriteria();
			crt.setStart(4);
			crt.setLimit(2);
			PageDataList<AccessIpControlConfig> page = mapper.pageByExample(crt);
			System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

