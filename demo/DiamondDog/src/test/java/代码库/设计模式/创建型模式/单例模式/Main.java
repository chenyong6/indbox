package 代码库.设计模式.创建型模式.单例模式;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class Main {
	private List<Thread> threads = new ArrayList();
	@Before
	public void init(){
		System.err.println("-----start-----");
	}
	@Test
	public void 饿汉模式_test() throws ClassNotFoundException{
		//Class.forName("代码库.设计模式.创建型模式.单例模式.饿汉模式",true,Thread.currentThread().getContextClassLoader());
		//System.err.println(代码库.设计模式.创建型模式.单例模式.饿汉模式.class);
		//System.err.println(饿汉模式.MYOBJ.hashCode());
	}
	@Test
	public void 懒汉模式_test() throws InterruptedException{
		for(int i=0;i<10;i++)
			threads.add(new Thread(new Runnable() {
				public void run() {
					懒汉模式.getInstance();
				}
			}));
		
		for(Thread thread:threads){
			thread.join();
			thread.start();
			
		}
		//TimeUnit.SECONDS.sleep(5L);
		System.err.println("懒汉模式_test"+"--over");
	}
	@Test
	public void 静态内部类单例_test() throws ClassNotFoundException{
		Class.forName("代码库.设计模式.创建型模式.单例模式.静态内部类单例",true,Thread.currentThread().getContextClassLoader());
		//System.err.println(代码库.设计模式.创建型模式.单例模式.饿汉模式.class);
		//System.err.println(饿汉模式.MYOBJ.hashCode());
	}
	@Test
	public void 枚举单例_test() throws ClassNotFoundException{
		Class.forName("代码库.设计模式.创建型模式.单例模式.枚举单例",true,Thread.currentThread().getContextClassLoader());
		//System.err.println(代码库.设计模式.创建型模式.单例模式.饿汉模式.class);
		//System.err.println(饿汉模式.MYOBJ.hashCode());
	}
}
