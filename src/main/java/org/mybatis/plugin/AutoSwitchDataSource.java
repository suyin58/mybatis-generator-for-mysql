package org.mybatis.plugin;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 代理一个或多个同构的数据源，在尝试从其中某个数据源获取数据库连接失败时，自动切换至其它数据源。
 * @author albert su suzy@wjs.com
 * @date 2015年9月15日 下午4:35:11 
 * 
 *
 */
public class AutoSwitchDataSource extends AbstractDataSource implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(AutoSwitchDataSource.class);

	private DriverManagerDataSource[] datasources;

	private String driverClassName;
	private String username;
	private String password;
	private String url;
	private String url2;
	// 共多少个可用数据源
	private int count = 0;
	// 某个数据源
	private volatile int inx;

	public Connection getConnection() throws SQLException {
		logger.debug("getConnection()");
		// 设置本地变量
		int inxlocal = inx;

		// 第一次尝试
		DriverManagerDataSource source = datasources[inxlocal];
		try {
			return source.getConnection();
		} catch (SQLException e) {
			logger.error("getConnection(), username={} url={} url2={} e=", username, url, url2, e);
			if (count < 2) {
				// 无数据源可切换
				throw new SQLException("No data source available.");
			}
			// 切换数据源
			inxlocal = switchDataSource(inxlocal);
		}

		source = datasources[inxlocal];
		Connection con = source.getConnection();
		// 更新inx的值
		inx = inxlocal;
		return con;
	}

	private int switchDataSource(int inxlocal) {
		logger.info("switch datasource, from=" + inxlocal);
		// 切换方式待兼容若需兼容>2数据源
		if (0 == inxlocal) {
			return 1;
		} else {
			return 0;
		}
	}

	public Connection getConnection(String username, String password) throws SQLException {
		logger.debug("getConnection(), username=" + username);
		// 设置本地变量
		int inxlocal = inx;

		// 第一次尝试
		DriverManagerDataSource source = datasources[inxlocal];
		try {
			return source.getConnection(username, password);
		} catch (SQLException e) {
			logger.error("getConnection(), e=", e);
			if (count < 2) {
				// 无数据源可切换
				throw new SQLException("No data source available.");
			}
			// 切换数据源
			inxlocal = switchDataSource(inxlocal);
		}

		source = datasources[inxlocal];
		Connection con = source.getConnection(username, password);
		// 更新inx的值
		inx = inxlocal;
		return con;
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		datasources[0].setLoginTimeout(seconds);
		datasources[1].setLoginTimeout(seconds);
	}

	public int getLoginTimeout() throws SQLException {
		return datasources[inx].getLoginTimeout();
	}

	// public synchronized void close() {
	// datasources[0].close();
	// datasources[1].close();
	// }

	public void afterPropertiesSet() throws Exception {
		datasources = new DriverManagerDataSource[2];

		datasources[0] = new DriverManagerDataSource();
		datasources[0].setUrl(url);
		setOtherPerties(datasources[0]);
		// 可用数据源+1
		count++;

		// applicationContext是否配置第二个
		if (url2 != null && url2.length() > 0) {
			datasources[1] = new DriverManagerDataSource();
			datasources[1].setUrl(url2);
			setOtherPerties(datasources[1]);
			// 可用数据源+1
			count++;
		}
		inx = 0;
		logger.info("afterPropertiesSet(), count=" + count);
	}

	private void setOtherPerties(DriverManagerDataSource datasources) {
		datasources.setDriverClassName(driverClassName);
		datasources.setUsername(username);
		datasources.setPassword(password);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	// =============

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

}
