package com.wjs.mybatis.demo.service;

public interface LockTestService {
	
	/**
	 * oracle for update nowait，在mysql中通过设置session lockwaittime 实现
	 * @param id
	 */
	public void lockForUpdateNoWait(Long id);

	/**
	 * 默认锁等待时间
	 * @param id
	 */
	public void lockForUpdateWait(Long id);

}
