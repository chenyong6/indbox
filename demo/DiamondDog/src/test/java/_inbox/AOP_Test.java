package _inbox;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.cy.core.service.aop.楼主able;
import com.cy.core.test.IHelloService;

/**
 * 测试
 * 
 * @author 林计钦
 * @version 1.0 2013-11-4 下午10:56:04
 */
public class AOP_Test {
	@Test
	public void testHelloWorld() {
		// 1、读取配置文件实例化一个IOC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		楼主able 楼主 = context.getBean("楼主", 楼主able.class);
		// 3、执行业务逻辑
		楼主.play("sb");
	}
}