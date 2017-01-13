package 代码库.JVM.内存溢出;

import java.util.HashMap;
import java.util.Map;

/**
* 堆内存溢出
*
* jvm参数：-Xms5m -Xmx5m -Xmn2m -XX:NewSize=1m
*
*/
public class MemoryLeak    {
	private String[] s = new String[Integer.MAX_VALUE];  
    public static void main(String[] args) throws InterruptedException {
        Map<String,Object> m =new HashMap<String,Object>();
        int i =0;
        int j=Integer.MAX_VALUE;
        while(true){
            for(;i<j;i++){
            	MemoryLeak memoryLeak = new MemoryLeak();
                m.put(String.valueOf(i), memoryLeak);
                System.err.println("--"+i+"--");
            }
        }
    }
}