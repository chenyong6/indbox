package 代码库.并发编程.并发编程的艺术.Java中的锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.junit.Test;

public class Main {
	class Worker implements Runnable{
		
		private final Lock lock ;
		
		public Worker(Lock lock) {
			this.lock = lock;
		}
		
		@Override
		public void run() {
			lock.lock();
			try{
				try {
					TimeUnit.SECONDS.sleep(5L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}finally{
				lock.unlock();
			}
		}
	}
	
	@Test
	public void Mutex_test(){
		FIFOMutex mutex = new FIFOMutex();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Worker worker = new Worker(mutex);
		for(int i=0;i<10;i++)
		executor.submit(worker);
		
		
		try {
			TimeUnit.MINUTES.sleep(1L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void TwinLock_test(){
		TwinsLock lock = new TwinsLock();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Worker worker = new Worker(lock);
		for(int i=0;i<10;i++)
		executor.submit(worker);
		
		
		try {
			TimeUnit.MINUTES.sleep(1L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
