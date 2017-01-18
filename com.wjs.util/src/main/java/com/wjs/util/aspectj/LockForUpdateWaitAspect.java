package com.wjs.util.aspectj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.wjs.util.annotation.LockForUpdateWait;
/**
 * mysql的for update no wait 实现
 * 参考资料：http://blog.itpub.net/7591490/viewspace-1033495/
 * @author Silver
 * @date 2017年1月15日 下午6:22:03 
 * 
 *
 */
@Aspect
@Component
public class LockForUpdateWaitAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LockForUpdateWaitAspect.class);

	@Around("@annotation(lock)")
	public Object lockWait(ProceedingJoinPoint pjp, LockForUpdateWait lock) throws Throwable {

		//		Thread t = Thread.currentThread();
		//取得当前线程的ThreadLocalMap实例
		//      ThreadLocalMap map = getMap(t);
		//		SqlSessionHolder holder = (SqlSessionHolder) TransactionSynchronizationManager.getCurrentTransactionName();
		org.springframework.jdbc.datasource.ConnectionHolder connHolder = null;
		Map<Object, Object> map = TransactionSynchronizationManager.getResourceMap();

		for (Iterator<Entry<Object, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<Object, Object> entry = it.next();
			if (entry.getValue() instanceof org.springframework.jdbc.datasource.ConnectionHolder) {
				// 获得数据库连接
				connHolder = (org.springframework.jdbc.datasource.ConnectionHolder) entry.getValue();
				break;
			}
		}
		if (connHolder != null) {

			Connection conn = connHolder.getConnection();
			Statement stmtShow = null;
			ResultSet rsShow = null;
			Statement stmtSet = null;
			Statement stmtDefault = null;
			int defWaitTime = 50;
			//执行监控的方法
			try {
				try {
					// 获得默认会话超时时间  : show variables like 'innodb_lock_wait_timeout';	
					String sqlShow = "show variables like 'innodb_lock_wait_timeout'";
					stmtShow = conn.createStatement();
					rsShow = stmtShow.executeQuery(sqlShow);
					if (rsShow.next()) {
						defWaitTime = rsShow.getInt(2);
					}
					String sqlSet = "set session innodb_lock_wait_timeout=" + lock.waitTime();
					stmtSet = conn.createStatement();
					stmtSet.execute(sqlSet);
				} catch (Exception e) {
					LOGGER.error("SQL 设置默认LockWaitTime报错", e);
				}

				return pjp.proceed();

			} catch (Throwable t) {
				throw t;
			} finally {

				// 执行完成恢复默认lockwaittimeout
				String sqlDefault = "set session innodb_lock_wait_timeout=" + defWaitTime;
				try {
					stmtDefault = conn.createStatement();
					stmtDefault.execute(sqlDefault);
				} catch (Exception e) {
					LOGGER.error("SQL 设置默认LockWaitTime报错", e);
				}

				if (stmtShow != null) {
					try {
						stmtShow.close();
					} catch (Exception e) {
						LOGGER.error("会话关闭异常", e);
					}
				}
				if (stmtSet != null) {
					try {
						stmtSet.close();
					} catch (Exception e) {
						LOGGER.error("会话关闭异常", e);
					}
				}
				if (stmtDefault != null) {
					try {
						stmtDefault.close();
					} catch (Exception e) {
						LOGGER.error("会话关闭异常", e);
					}
				}

				if (rsShow != null) {
					try {
						rsShow.close();
					} catch (Exception e) {
						LOGGER.error("结果集关闭异常", e);
					}
				}
			}

		} else {
			// throw new Throwable("使用了@LockForUpdateWait注解，但是没有在线程中开启数据连接。(可以通过@Transactional进行开启)");
			LOGGER.error("使用了@LockForUpdateWait注解，但是没有在线程中开启数据连接。(可以通过@Transactional进行开启)");
			return pjp.proceed();
		}
	}
}
