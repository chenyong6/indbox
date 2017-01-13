package _inbox;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.junit.Test;

public class 类加载Test {
	
	@Test
	public void xxTest() throws Exception{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = classLoader.getResources("代码库");
		while(urls.hasMoreElements()){
			URL url = urls.nextElement();
			String protocol = url.getProtocol();
			if("file".equals(protocol)){
				String path = url.getPath();
				path = URLDecoder.decode(path,"UTF-8");
				List<File> files = new ArrayList<File>();
				files = traverseFile(files,new File(path));
				URLClassLoader rcld = new URLClassLoader(new URL[]{url}, classLoader);
				for(File file : files){
					System.err.println(file.getName());
					 String className = file.getName().substring(0, file.getName().lastIndexOf("."));
					 System.err.println(className);
				}
			}
		}
	}
	private List<File> traverseFile(final List<File> filesList,File file){
		File[] files = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".class")||dir.isDirectory()){
					return true;
				}else{
					return false;
				}
			}
		});
		for(File fileLocal : files){
			if(fileLocal.getName().endsWith(".class")){
				filesList.add(fileLocal);
			}else if(fileLocal.isDirectory()){
				traverseFile(filesList,fileLocal);
			}
		}
		return filesList;
	}
}
