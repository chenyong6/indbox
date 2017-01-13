package 代码库.并发编程.并发编程的艺术.并发编程基础;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class NanoProfiler {
	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){

		@Override
		protected Long initialValue() {
			return System.nanoTime();
		}
		
	};
	public static final void begin(){
		TIME_THREADLOCAL.set(System.nanoTime());
	}
	public static final Long end(){
		return System.nanoTime() - TIME_THREADLOCAL.get();
	}
	
	public static void main(String[] args) {
		NanoProfiler.begin();
		MillisProfiler.begin();
		try {
			TimeUnit.SECONDS.sleep(2L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#,###"); 
		System.err.println("Cost: "+df.format(NanoProfiler.end())+" nano");
		System.err.println("Cost: "+df.format(MillisProfiler.end())+" millis");
		
	
	}
}
