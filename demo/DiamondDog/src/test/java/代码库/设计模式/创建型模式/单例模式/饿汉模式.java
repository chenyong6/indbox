package 代码库.设计模式.创建型模式.单例模式;

public class 饿汉模式 {
	private final static MyObject MYOBJ = new MyObject();
	public static MyObject getInstance(){
		//此版本代码立即加载（看类加载时候是否选择初始化）
		return MYOBJ;
	}
}
