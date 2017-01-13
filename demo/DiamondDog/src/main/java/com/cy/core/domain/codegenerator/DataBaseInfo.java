package com.cy.core.domain.codegenerator;

public class DataBaseInfo {
	
	private String driver;
	private String port;
	
	private String ip;
	private String url;
	private String userName;
	private String password;
	/**
	 * 数据库名称
	 */
	private String dbName;
	
	private String dbSchem;
	/**
	 * 数据库类型
	 */
	private String dbType;

	public DataBaseInfo() {
		super();
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbSchem() {
		return dbSchem;
	}

	public void setDbSchem(String dbSchem) {
		this.dbSchem = dbSchem;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	@Override
	public String toString() {
		return "DataBaseInfo [driver=" + driver + ", port=" + port + ", ip=" + ip + ", url=" + url + ", userName="
				+ userName + ", password=" + password + ", dbName=" + dbName + ", dbSchem=" + dbSchem + ", dbType="
				+ dbType + "]";
	}



}
