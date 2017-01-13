package 代码库.utils.apache工具包.Configuration;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

public class ConfigurationDemo {
	@Test
	public void XMLConfigurationTest() {
		try {
			// Path path = Paths.get(first, more)
			URL url = Thread.currentThread().getContextClassLoader().getResource("代码库/apache工具包/Configuration/config.xml");
			XMLConfiguration config = new XMLConfiguration(url);
			// 对于单独元素的话，可以直接通过标签名获取值
			String str = config.getString("boy");
			System.out.println(str);
			// 对于循环出现的嵌套元素，可以通过父元素.子元素来获取集合值
			List<Object> names = config.getList("student.name");
			System.out.println(Arrays.toString(names.toArray()));
			// 对于一个单独元素包含的值有多个的话如：a,b,c,d 可以通过获取集合
			List<Object> titles = config.getList("title");
			System.out.println(Arrays.toString(titles.toArray()));
			// 对于标签元素的属性，可以通过 标签名[@属性名] 这样的方式获取
			String size = config.getString("ball[@size]");
			System.out.println(size);
			// 对于嵌套的标签的话，想获得某一项的话可以通过 标签名(索引名) 这样方式获取
			String id = config.getString("student(1)[@id]");
			System.out.println(id);

			String go = config.getString("student.name(0)[@go]");
			System.out.println(go);
			/**
			 * 依次输出结果为 tom [lily, lucy] [abc, cbc, bbc, bbs] 20 2 common1
			 * 
			 */
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProperties() {
		// 注意路径默认指向的是classpath的根目录
		Configuration config;
		try {
			
			URL url = Thread.currentThread().getContextClassLoader().getResource("代码库/apache工具包/Configuration/config.properties");
			config = new PropertiesConfiguration(url);
			String ip = config.getString("ip");
			int port = config.getInt("port");
			String title = config.getString("application.title");
			System.out.println(ip + "\n" + port + "\n" + title);
			// 再举个Configuration的比较实用的方法吧,在读取配置文件的时候有可能这个键值对应的值为空，那么在下面这个方法中
			// 你就可以为它设置默认值。比如下面这个例子就会在config.properties这个文件中找id的值，如果文件中没有配置id，就会给id设置值为123
			// 这样就保证了java的包装类不会返回空值。虽然功能很简单，但是很方便很实用。
			String id = config.getString("id", "defaultid");
			System.out.println(id);

			// 如果在properties
			// 文件中有如下属性keys=cn,com,org,uk,edu,jp,hk，这样的类似一个值含有多个元素值
			// 那么下面两种方法都可以
			String[] keys1 = config.getStringArray("keys");
			System.out.println(Arrays.toString(keys1));
			List keys2 = config.getList("keys");
			System.out.println(Arrays.toString(keys2.toArray()));
			// 接下来这两步加上的原因是，默认分割符号是逗号，而在配置文件中con的值中含有多个短横线分隔符，所以要重新设置分隔符读出来喽
			AbstractConfiguration.setDefaultListDelimiter('-');
			config = new PropertiesConfiguration(url);
			List cons = config.getList("con");
			System.out.println(Arrays.toString(cons.toArray()));
			/**
			 * 
			 * 依次输出结果如下 127.0.0.1 8080 Killer App 1.6.2 defaultid [cn, com, org,
			 * uk, edu, jp, hk] [cn, com, org, uk, edu, jp, hk] [cn, com, org,
			 * uk, edu, jp, hk]
			 */
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

}
