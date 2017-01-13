package 代码库.JVM.类与接口初始化区别cint;

public class InterfaceImpl implements Interface{
	public static int CONSTANT_SUB = 1;
	public final static int CONSTANT_FINAL_SUB = 1;
	static{
		System.err.println("i am haha");
		
	}
}
