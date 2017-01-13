package 代码库.设计模式.创建型模式.单例模式;

import com.jcraft.jsch.jce.Random;

/**
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，
 * 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
 * 但是不能实现懒加载
 */
public class 枚举单例2 {
	
	private 枚举单例2(){}
	
	enum SingletonHolder{
		INSTANCE1,INSTANCE2;
		private final 枚举单例2 xx = new 枚举单例2();
		static int i =0;
		private final int x = new java.util.Random(2).nextInt(10);
		SingletonHolder(){
			System.err.println(x);
		}
	}
	public static void main(String[] args) {
		System.err.println(SingletonHolder.INSTANCE1.x);
		System.err.println(SingletonHolder.INSTANCE2.x);
	}
	public static 枚举单例2 getInstance(){
		return SingletonHolder.INSTANCE1.xx;
	}

}
