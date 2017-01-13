package com.cy.core.constant;

public enum DataBaseConstant {
	ORACLE("oracle","",""),
	MYSQL("mysql","3306","com.mysql.jdbc.Driver"),
	POSTGRESQL("postgresql","5432","org.postgresql.Driver");
	private String driver;
	private String database;
	private String dbPort;
	private DataBaseConstant(String database,String port,String driver) {
		this.driver = driver;
		this.database = database;
		this.dbPort = port;
	}

	public String getDriver() {
		return driver;
	}
	
	public String getDatabase() {
		return database;
	}

	public String getDbPort() {
		return dbPort;
	}


	public String getDefaultDbUrl(String ip,String port,String dbName){
		return "jdbc:"+getDatabase()+"://"+ip+":"+port+"/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
	}
}
