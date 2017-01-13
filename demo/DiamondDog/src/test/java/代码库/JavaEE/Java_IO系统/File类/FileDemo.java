package 代码库.JavaEE.Java_IO系统.File类;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

import org.junit.Test;

public class FileDemo {
	@SuppressWarnings("unused")
	@Test
	public void testFilenameFilter() throws Exception{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = classLoader.getResources("代码库.Java_IO系统.File类".replace('.', '/'));
		while(urls.hasMoreElements()){
			String path = urls.nextElement().getPath();
			path = URLDecoder.decode(path, "UTF-8");//UTF-8解码
			File[] files = new File(path).listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					
					if(name.endsWith(".class")){
						System.err.println("保留文件:"+name);
						return true;
					}else{
						System.err.println("过滤文件：" +name);
					}
					return false;
				}
			});
		}
	}
	@Test
	public void testFileFilter() throws Exception{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = classLoader.getResources("代码库.Java_IO系统.File类".replace('.', '/'));
		while(urls.hasMoreElements()){
			String path = urls.nextElement().getPath();
			path = URLDecoder.decode(path, "UTF-8");
			@SuppressWarnings("unused")
			File[] files = new File(path).listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					System.err.println(pathname);
					return false;
				}
			});
		}
	}
	
	
	
}
