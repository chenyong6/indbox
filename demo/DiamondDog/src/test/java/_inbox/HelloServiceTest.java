package _inbox;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.cy.core.test.IHelloService;

/**
 * 测试
 * 
 * @author 林计钦
 * @version 1.0 2013-11-4 下午10:56:04
 */
public class HelloServiceTest {
    @Test
    public void testHelloWorld() {
        // 1、读取配置文件实例化一个IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("helloworld.xml");
        Resource res = context.getResource("file:helloworld.xml");
        System.err.println(res.getFilename());
        // 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        IHelloService helloService = context.getBean("helloService", IHelloService.class);
        // 3、执行业务逻辑
        helloService.say();
    }
}