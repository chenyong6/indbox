package 代码库.JVM.类加载器;

import java.io.InputStream;

public class ClassLoaderTest {
	public static void main(String[] args) throws Exception, IllegalAccessException {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			 public Class<?> loadClass(String name) throws ClassNotFoundException {
				try{
					//name -> path
					String filePath = name + ".class";
					//获取文件
					InputStream is = this.getResourceAsStream(filePath);
					//byte读取
					if(is != null){
						
					}
					//defineClass
				}catch(Exception e){
					
				}finally {
					
				}
			        return loadClass(name, false);
			    }
		};
		
		try {
			Object obj = myLoader.loadClass("代码库.JVM.虚拟机类加载机制.SuperClass").newInstance();
		
			System.err.println(obj instanceof 代码库.JVM.虚拟机类加载机制.SuperClass  );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
