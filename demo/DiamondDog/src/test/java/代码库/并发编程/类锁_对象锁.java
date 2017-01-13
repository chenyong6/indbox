package 代码库.并发编程;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class 类锁_对象锁 {
	
	@Test
	public void 类锁(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				类锁_对象锁.test_类锁();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
//				for(int i=0;i<10000;i++){
//					类锁_对象锁 x = new 类锁_对象锁();
//					System.err.println(x);
//				}
			}
		}).start();
	}
	
	public synchronized static void test_类锁(){
		try {
			System.err.println("线程开始等待");
			TimeUnit.SECONDS.sleep(3);;
			Thread.sleep(3L);
			System.err.println("等待结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
