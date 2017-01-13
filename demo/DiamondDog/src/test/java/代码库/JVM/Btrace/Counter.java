package 代码库.JVM.Btrace;

import java.util.concurrent.TimeUnit;

public class Counter {
	 // 总数  
    private static long totalCount = 0;  
  
    public long add(int num) throws Exception {  
        totalCount += num;  
        sleep();  
        return totalCount;  
    }  
      
    public void sleep() throws Exception {  
        TimeUnit.SECONDS.sleep(1L);
    }  
}
