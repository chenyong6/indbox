package 代码库.JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * 
 *
 */
public class JConsole {
	static class OOMObject{
		public byte[] placeholder = new byte[64*1024];
	}
	public static void fillHeap(int num) throws Exception{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i=0;i<num;i++){
			TimeUnit.SECONDS.sleep(1L);
			list.add(new OOMObject());
		}
		System.gc();
	}
	public static void main(String[] args) throws Exception {
		fillHeap(60);
	}
}
