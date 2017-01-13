package _inbox.类加载;

public class Test1 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		/**
		 *  调用 static fianl 变量不会引起类初始化
		 * 
		 */
		System.err.println("counter0 = " + Singleton.counter0);
		Singleton s = Singleton.getSingleton();
		System.out.println("counter1 = " + s.counter1);
		System.out.println("counter2 = " + s.counter2);
		System.out.println("counter3 = " + s.counter3);
	}
}