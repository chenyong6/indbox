package 代码库.并发编程.并发编程的艺术.并发编程基础.线程应用实例.简单数据库连接池;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class ConnectionDriver {
	static class ConnectionHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("commit")){
				TimeUnit.MILLISECONDS.sleep(100L);
				System.err.println("invoke commit");
				System.err.println("proxy:"+proxy+" Method:"+method+" args:"+args);
			}
			
			return null;
		}
		
	}
	public static final Connection createConnection(){
		
		return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class<?>[]{Connection.class}, new ConnectionHandler());
		 
	}
	public static void main(String[] args) {
		try {
			Connection connection =  ConnectionDriver.createConnection();
			System.err.println("connection : "+connection);
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
