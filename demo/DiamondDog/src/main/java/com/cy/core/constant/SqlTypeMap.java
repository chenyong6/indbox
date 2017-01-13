package com.cy.core.constant;

import java.util.HashMap;
import java.util.Map;

public enum SqlTypeMap {
	/**
	 * MySql 
	 */
	MYSQL_STRING(Type.MYSQL,"CHAR","String"), 
	MYSQL_VARCHAR(Type.MYSQL,"VARCHAR", "String"), 
	MYSQL_LONGVARCHAR(Type.MYSQL,"LONGVARCHAR", "String"),
	MYSQL_NUMERIC(Type.MYSQL,"NUMERIC","BigDecimal","java.math.BigDecimal"),
	MYSQL_DECIMAL(Type.MYSQL,"DECIMAL","BigDecimal", "java.math.BigDecimal"),
	MYSQL_BIT(Type.MYSQL,"BIT","Boolean"), 
	MYSQL_TINYINT(Type.MYSQL,"TINYINT", "Integer"), // Byte
	MYSQL_SMALLINT(Type.MYSQL,"SMALLINT", "Integer"), // Short
	MYSQL_INT(Type.MYSQL,"INT", "Integer"), 
	MYSQL_INTEGER(Type.MYSQL,"INTEGER", "Integer"), 
	MYSQL_BIGINT(Type.MYSQL,"BIGINT", "Long"), 
	MYSQL_REAL(Type.MYSQL,"REAL","Float"),
	MYSQL_FLOAT(Type.MYSQL,"FLOAT", "Double"),
	MYSQL_DOUBLE(Type.MYSQL,"DOUBLE", "Double"),
	MYSQL_DATE(Type.MYSQL,"DATE", "Date","java.util.Date"), // java.util.Date
	MYSQL_TIME(Type.MYSQL,"TIME", "Date","java.util.Date"), 
	MYSQL_DATETIME(Type.MYSQL,"DATETIME", "Date","java.util.Date"),
	MYSQL_TIMESTAMP(Type.MYSQL,"TIMESTAMP","Timestamp","java.sql.Timestamp"), 
	MYSQL_DEFAUlT(Type.MYSQL,"NULL", "Object"),

	
	/**
	 * PostgerSql
	 */
	PG_SERIAL(Type.POSTGRESQL,"SERIAL","Long"),
	PG_TRING(Type.POSTGRESQL,"CHAR","String"),
	PG_BPCHAR(Type.POSTGRESQL,"BPCHAR","String"),
	PG_VARCHAR(Type.POSTGRESQL,"VARCHAR","String"),
	PG_LONGVARCHAR(Type.POSTGRESQL,"LONGVARCHAR","String"),
	PG_NUMERIC(Type.POSTGRESQL,"NUMERIC","BigDecimal","java.math.BigDecimal"),
	PG_DECIMAL(Type.POSTGRESQL,"DECIMAL","BigDecimal","java.math.BigDecimal"),
	PG_BIT(Type.POSTGRESQL,"BIT","Boolean"),
	PG_TINYINT(Type.POSTGRESQL,"TINYINT","Integer"),//Byte
	PG_SMALLINT(Type.POSTGRESQL,"SMALLINT","Integer"),//Short
	PG_INT(Type.POSTGRESQL,"INT","Integer"),
	PG_INT2(Type.POSTGRESQL,"INT2","Integer"),
	PG_INT4(Type.POSTGRESQL,"INT4","Integer"),
	PG_INTEGER(Type.POSTGRESQL,"INTEGER","Integer"),
	PG_BIGINT(Type.POSTGRESQL,"INT8","Long"),
	PG_REAL(Type.POSTGRESQL,"REAL","Float"),
	PG_FLOAT(Type.POSTGRESQL,"FLOAT","Double"),
	PG_DOUBLE(Type.POSTGRESQL,"DOUBLE","Double"),
	PG_TIMESTAMP(Type.POSTGRESQL,"TIMESTAMP","Date","java.util.Date"),
	PG_TIMESTAMPZ(Type.POSTGRESQL,"TIMESTAMPZ","Date","java.util.Date"),
	PG_DEFAUlT(Type.POSTGRESQL,"NULL","Object");
	/**
	 * 工单类型属性Map
	 */
	public static final Map<String, SqlTypeMap> MySqlTypeMap = new HashMap<String, SqlTypeMap>();

	public static final Map<String, SqlTypeMap> PostGreSqlTypeMap = new HashMap<String, SqlTypeMap>();

	public static final Map<String, SqlTypeMap> OracleTypeMap = new HashMap<String, SqlTypeMap>();
	static {
		for (SqlTypeMap oe : values()) {
			switch (oe.dbType) {
			case MYSQL:
				MySqlTypeMap.put(oe.sqlType, oe);
				break;
			case ORACLE:
				OracleTypeMap.put(oe.sqlType, oe);
				break;
			case POSTGRESQL:
				PostGreSqlTypeMap.put(oe.sqlType, oe);
				break;
			default:
				break;
			}
			
		}
	}

	private String sqlType;
	private String javaType;
	private Type dbType;
	private String javaImport;
	private SqlTypeMap(Type dbType,String sqlType, String javaType,  String javaImport) {
		this.sqlType = sqlType;
		this.javaType = javaType;
		this.dbType = dbType;
		this.javaImport = javaImport;
	}
	

	private SqlTypeMap(Type dbType,String sqlType, String javaType) {
		this.sqlType = sqlType;
		this.javaType = javaType;
		this.dbType = dbType;
	}
	public String getSqlType() {
		return sqlType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaImport() {
		return javaImport;
	}

	public void setJavaImport(String javaImport) {
		this.javaImport = javaImport;
	}

	private enum Type {
		ORACLE, MYSQL,POSTGRESQL;
	}


}
