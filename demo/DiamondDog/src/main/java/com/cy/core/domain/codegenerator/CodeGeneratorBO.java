package com.cy.core.domain.codegenerator;

import java.util.List;


public class CodeGeneratorBO {
	/**
	 * 项目路径
	 */
	private String packagePath;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 数据库端口
	 */
	private String port;
	/**
	 * 数据库用户名
	 */
	private String userName;
	/**
	 * 数据库密码
	 */
	private String password;
	/**
	 * 数据库类型
	 */
	private String databaseType;
	/**
	 * 数据库名
	 */
	private String databaseName;
	/**
	 * 创造者
	 */
	private String author;
	

	
	private List<String> tables;

	
	public List<String> getTableName() {
		return tables;
	}

	public void setTableName(List<String> tables) {
		this.tables = tables;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getTables() {
		return tables;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
	}
}
