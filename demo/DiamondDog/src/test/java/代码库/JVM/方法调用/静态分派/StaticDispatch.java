package 代码库.JVM.方法调用.静态分派;

public class StaticDispatch {
	static abstract class Human{
		
	}
	static class Man extends Human{
		
	}
	static class Woman extends Human{
		
	}
	public void sayHello(Human human){
		System.err.println(" hello human ");
	}
	public void sayHello(Man man){
		System.err.println(" hello man ");
	}
	public void sayHello(Woman woman){
		System.err.println(" hello woman ");
	}
	public static void main(String[] args) {
		StaticDispatch sd = new StaticDispatch();
		Human man = new Man();
		Human woman = new Woman();
		sd.sayHello(man);
		sd.sayHello(woman);
	}
}
