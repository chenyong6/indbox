package com.cy.core.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cy.core.domain.codegenerator.DataBaseInfo;

public class DbUtil {
	private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();
	public static void initThreadDB(DataBaseInfo dataBaseInfo){
		if(connContainer.get() == null){
    		Connection conn = null;
    		try {
    			Class.forName(dataBaseInfo.getDriver());
    			conn = DriverManager.getConnection(dataBaseInfo.getUrl(), dataBaseInfo.getUserName(), dataBaseInfo.getPassword());
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}finally {
    			connContainer.set(conn);
			}
		}
	}
	public static Connection getConnection(){
		return connContainer.get();
    }
    public static void close(){
    	if(connContainer.get() != null){
    		try {
    			connContainer.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				connContainer.remove();
			}
    	}
    }
    public static String getDriverName(){
    	String driverName = "";
    	try {
    		driverName =  connContainer.get().getMetaData().getDriverName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return driverName;
    	
    }
    public static DatabaseMetaData getMetaData(){
    	try {
			return connContainer.get().getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static void main(String[] args) throws Exception {
//    	DataBaseInfo dataBaseInfo = new DataBaseInfo();
//    	dataBaseInfo.setDriver(DataBaseConstant.POSTGRESQL.getDriver());
//    	dataBaseInfo.setDburl("jdbc:postgresql://10.33.27.131:5432/coms_1.2?useUnicode=true&characterEncoding=utf-8");
//    	dataBaseInfo.setDbuser("postgres");
//    	dataBaseInfo.setDbpassword("123456");
	}
}
