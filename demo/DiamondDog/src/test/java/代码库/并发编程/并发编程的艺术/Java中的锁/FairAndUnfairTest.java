package 代码库.并发编程.并发编程的艺术.Java中的锁;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class FairAndUnfairTest {

	private Lock fairLock = new ReentrantLock2(true);

	private Lock unnfairLock = new ReentrantLock2(false);

	@Test
	public void fairLock_test() {
		lockTest(fairLock);
	}

	@Test
	public void unfairLock_test() {
		lockTest(unnfairLock);
		
	}

	private void lockTest(Lock lock) {
		for(int i=0;i<10;i++)
			new Job(lock,i).start();
		try {
			TimeUnit.SECONDS.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class Job extends Thread {
		private final Lock lock;
		public Job(Lock lock,int i) {
			super();
			this.lock = lock;
			super.setName(String.valueOf(i));
		}

		@Override
		public void run() {
//			try {
//				TimeUnit.SECONDS.sleep(1L);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ReentrantLock2 rtLock = (ReentrantLock2)lock;
			for(int i=0;i<1000;i++){
				lock.lock();
				try{
					Collection<Thread> threads = rtLock.getQueuedThreads();
					List<String> threadNames = new ArrayList<String>();
					for(Thread thread:threads){
						threadNames.add(thread.getName());
					}
					System.err.println("Locked by ["+Thread.currentThread().getName()+"] Waiting by "+threadNames);
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}

	}

	private static class ReentrantLock2 extends ReentrantLock {
		private static final long serialVersionUID = 4331936052095239305L;

		public ReentrantLock2(boolean isFair) {
			super(isFair);
		}

		public Collection<Thread> getQueuedThreads() {
			List<Thread> threads = new ArrayList<>(super.getQueuedThreads());
			
			return threads;
		}

	}
}
