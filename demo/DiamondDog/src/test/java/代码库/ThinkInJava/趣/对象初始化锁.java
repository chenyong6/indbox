package 代码库.ThinkInJava.趣;

import java.util.concurrent.TimeUnit;

public class 对象初始化锁 {
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Obj obj = new Obj(5);
			}
		}).start();
		
	new Thread(new Runnable() {
				
				@Override
				public void run() {
					Obj obj = new Obj(3);
				}
			}).start();
		
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			Obj obj = new Obj(4);
		}
	}).start();

	}
}
class Obj{
	static{
		try {
			System.err.println(Thread.currentThread().getName()+" 开始初始化Obj");
			TimeUnit.SECONDS.sleep(10);
			System.err.println(Thread.currentThread().getName()+" 开始实例化Obj");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Obj(long l){
		try {
			
			System.err.println(Thread.currentThread().getName()+" 开始实例化Obj");
			TimeUnit.SECONDS.sleep(l);
			System.err.println(Thread.currentThread().getName()+" 完成实例化Obj");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}