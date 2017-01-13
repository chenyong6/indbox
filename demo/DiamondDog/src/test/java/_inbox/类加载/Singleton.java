package _inbox.类加载;

public class Singleton {
	static{
		System.err.println("静态代码块初始化-----------");
	}
	
	public static final int counter0 = 0;
	
	private static Singleton singleton = new Singleton();
	
	public static int counter1 ;
	
	public static int counter2 = 0;
	
	public int counter3 = 1;
	
	public Singleton(){
		counter1++;
		counter2++;
		counter3++;
	}
	
	public static Singleton getSingleton(){
		return singleton;
	}
}
