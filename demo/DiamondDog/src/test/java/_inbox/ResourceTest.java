package _inbox;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceTest {
	/**
	 * http:－该前缀用于访问基于 HTTP 协议的网络资源。 ftp:－该前缀用于访问基于 FTP 协议的网络资源。 file:
	 */
	@Test
	public void UrlResource() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"helloworld.xml");
			Resource resHttp = new org.springframework.core.io.UrlResource(
					"http://www.ibm.com/developerworks/cn/java/j-lo-spring-resource/index.html");
			Resource resFile = context.getResource(
					"file:helloworld.xml");
			System.err.println(resFile.exists());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		// 通过搜索类加载路径中的资源文件创建 ApplicationContext
		// 而是通过指定 classpath: 前缀强制搜索类加载路径
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"classpath:helloworld.xml");
		System.out.println(ctx);
		// 使用 ApplicationContext 加载资源，
		// 通过 classpath: 前缀指定访问策略
		Resource resFile = null;
		try {
			resFile = new org.springframework.core.io.UrlResource(
					"file:helloworld.xml");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.err.println(resFile.exists());
		Resource r = ctx.getResource("classpath:helloworld.xml");
		// 输出 Resource 描述
		System.out.println(r.exists());
	}

	@Test
	public void ClassPathResource() {
		Resource res = new org.springframework.core.io.ClassPathResource("co",
				Thread.currentThread().getContextClassLoader());
	}

	@Test
	public void getResource() {
		URL url = Thread.currentThread().getContextClassLoader()
				.getSystemResource("helloworld.xml");
		System.err.println(url.getFile());
	}
}
