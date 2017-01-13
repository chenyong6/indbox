package 代码库.并发编程;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;



public class SingleThreadExecutor {
	private static final BlockingQueue<Integer> intQueue ;
	private static Executor executor;
	static{
		 intQueue = new LinkedBlockingQueue<Integer>();
		 for(Integer i=0;i<1000000;i++){
			 intQueue.add(Integer.valueOf(i));
		 }
		 executor = Executors.newSingleThreadExecutor();
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("---1---");
				System.err.println("---1---");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("---2---");
				System.err.println("---2---");
			}
		});
		executor.execute(t1);
		executor.execute(t2);
	}
	
}
