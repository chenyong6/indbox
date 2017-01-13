package 代码库.Spring.rpc.rmi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiMain {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
"spring.rpc/"+"remote-service-context-2.xml");
    
  }
  public static String getPath(Class<?> clazz){
		try {
			return URLDecoder.decode(clazz.getResource("").getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
