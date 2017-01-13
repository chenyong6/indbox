package 代码库.JVM.虚拟机类加载机制;
/**
 * 被动使用类字段演示一：
 *	通过子类引用父类的静态字段，不会导致子类初始化
 */
public class SuperClass {
	static {
		System.err.println("SuperClass initialization");
	}

	public static Integer value = 1;

	public static final Integer intgValue = 1;
}

class SubClass extends SuperClass {
	public static int SUBCLASS = 1;
	static {
		System.err.println("SubClass initialization");
	}
}
