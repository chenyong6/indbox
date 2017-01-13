package 代码库.JVM.OutOfMemoryError异常;

import java.util.ArrayList;
import java.util.List;
/**
 * VM Agrs: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		//使用List保持着常量池引用，避免Full GC 回收常量池行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
