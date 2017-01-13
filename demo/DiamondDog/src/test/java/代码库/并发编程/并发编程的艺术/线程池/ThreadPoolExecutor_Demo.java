package 代码库.并发编程.并发编程的艺术.线程池;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import 代码库.并发编程.并发编程的艺术.并发编程基础.MillisProfiler;

public class ThreadPoolExecutor_Demo {

	@Test
	public void test_ThreadPoolExecutor() {
		ThreadPoolExecutor newFixThreadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
				Runtime.getRuntime().availableProcessors() + 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		ThreadPoolExecutor cacheThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		ThreadPoolExecutor singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	public static void main(String[] args) {
		// Cpu密集型 Ncpu + 1
		ThreadPoolExecutor pool = new MyThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, 1024, 60L,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 100; i++)
			pool.execute(new Runnable() {

				@Override
				public void run() {
					try {

						TimeUnit.SECONDS.sleep(3L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println(" ThreadName: " + Thread.currentThread().getName());
				}
			});
		// pool.setThreadFactory();
		System.err.println("线程池需要执行的任务的数量：" + pool.getTaskCount());
		System.err.println("线程池已完成任务的数量：" + pool.getCompletedTaskCount());
		System.err.println("线程池中曾经创建过最大线程数量：" + pool.getLargestPoolSize());
		System.err.println("线程池中线程数量" + pool.getPoolSize());
		System.err.println("线程池中活动线程数" + pool.getActiveCount());
	}

	static class MyThreadPoolExecutor extends ThreadPoolExecutor {

		public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void beforeExecute(Thread t, Runnable r) {
			super.beforeExecute(t, r);
		}

		@Override
		protected void afterExecute(Runnable r, Throwable t) {

			super.afterExecute(r, t);
			System.err.println(MillisProfiler.end());
		}

		@Override
		protected void terminated() {
			System.err.println("terminated");
			super.terminated();
		}

	}

}
