package 代码库.JVM.OutOfMemoryError异常;

import java.util.ArrayList;
import java.util.List;
/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
	static class OOMObject{
	}
	public static void main(String[] args) throws Exception {
		Thread.currentThread().setName("Test01");
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
