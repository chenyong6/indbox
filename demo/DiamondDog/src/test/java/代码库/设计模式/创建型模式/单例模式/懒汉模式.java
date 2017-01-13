package 代码库.设计模式.创建型模式.单例模式;

import java.util.concurrent.TimeUnit;

public class 懒汉模式 {
	private static MyObject MYOBJECT;
	public static MyObject getInstance(){
		if(MYOBJECT == null){
			try {
				System.err.println(Thread.currentThread().getName()+": sleep");
				TimeUnit.SECONDS.sleep(3L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MYOBJECT = new MyObject();
		}
		return MYOBJECT;
	}
}
