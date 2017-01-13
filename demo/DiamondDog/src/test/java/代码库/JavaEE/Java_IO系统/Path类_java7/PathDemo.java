package 代码库.JavaEE.Java_IO系统.Path类_java7;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathDemo {
	@Test
	public void path(){
		//Path path = Paths.get("/代码库/Java_IO系统");
		Path path = Paths.get("/代码库","/Java_IO系统");
		Path path2 = Paths.get("E:"+"\\workspace\\workspace_cy\\spring-springmvc-mybaits\\src\\test\\java\\代码库\\Java_IO系统");
		System.err.println( FileSystems.getDefault().getPath("/代码库") );
		System.err.println(System.getProperty("user.home"));
		System.err.println(path.getParent().getFileName());
		System.err.println(path2.getParent().getFileName());
		
	}
}
