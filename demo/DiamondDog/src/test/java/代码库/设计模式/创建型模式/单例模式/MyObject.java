package 代码库.设计模式.创建型模式.单例模式;

public class MyObject {
//	public static int i = 1;
	static{
		System.err.println("static{} initialize ");
	}
	{
		System.err.println("{} initialize ");
	}
	public MyObject(){
		System.err.println(Thread.currentThread().getName()+" : MyObject initialize");
	}
	@Override
	public String toString() {
		return Thread.currentThread().getName()+":MyObject";
	}
	
}
