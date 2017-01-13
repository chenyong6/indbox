package 代码库.设计模式.创建型模式.单例模式;
/**
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，
 * 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
 * 但是不能实现懒加载
 */
public enum 枚举单例 {
	INSTANCE;
	
	private 枚举单例(){
		System.err.println("init");
	}
	
	public void whateverMethod() {
		
	}

}
