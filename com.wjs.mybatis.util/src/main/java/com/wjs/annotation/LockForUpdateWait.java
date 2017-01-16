package com.wjs.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * mysql的for update no wait 实现注解
 * PS: 使用是需要确保Spring将com.wjs.common.aspectj.LockForUpdateWaitAspect注入到了环境中
 *     可以通过：<context:component-scan base-package="com.wjs.common.aspectj" /> 自动扫描注入
 * @author Silver
 * @date 2017年1月15日 下午6:22:52 
 * 
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LockForUpdateWait {

	/**
	 * 锁等待时间(秒:等待超时则报数据库异常)
	 * @return
	 * @author Silver 
	 * @date 2017年1月15日 下午5:00:22
	 */
    long waitTime() default 1;
}
