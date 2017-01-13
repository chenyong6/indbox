package 代码库.并发编程.并发编程的艺术.并发编程基础;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {

	public static void main(String[] args) {
		Thread preThread = Thread.currentThread();
		System.err.println(preThread.getName());
		for(int i = 0;i<1 ;i++){
			Thread t = new Thread(new ThreadJoin.Fox(preThread));
			t.setName("Thread-"+i+"_t");
			t.start();
		}
		try {
			TimeUnit.SECONDS.sleep(8L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("main terminate");
		
	}
	static class Fox implements Runnable{
		private  Thread preThread;
		
		public Fox(Thread previous){
			preThread = previous;
		}
		
		@Override
		public void run() {
			
			System.err.println("Thread Name:"+Thread.currentThread().getName()+" I'am running !");
			try {
				TimeUnit.SECONDS.sleep(3L);
				System.err.println("Thread Name:"+preThread.getName() +" wait ");
				//等待 preThread 完成
				preThread.join();
				System.err.println("Thread Name:"+Thread.currentThread().getName() +" go on ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

