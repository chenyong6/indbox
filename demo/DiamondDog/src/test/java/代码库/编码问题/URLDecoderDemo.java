package 代码库.编码问题;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

import org.junit.Test;

public class URLDecoderDemo {
	@Test
	public void 中文路径() throws Exception{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = classLoader.getResources("代码库.编码问题".replace('.', '/'));
		while(urls.hasMoreElements()){
			String path = urls.nextElement().getPath();
			System.err.println("解码前："+path+'\n'+"解码后："+
			URLDecoder.decode(path, "UTF-8"));
			path = URLDecoder.decode(path, "UTF-8");
			File[] files = new File(path).listFiles();
			for(File file : files){
				System.err.println(file.getName());
			}
		}
	}
}
