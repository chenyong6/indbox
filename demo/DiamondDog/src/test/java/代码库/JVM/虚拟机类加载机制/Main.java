package 代码库.JVM.虚拟机类加载机制;

import org.junit.Test;

class Main {
	@Test
	public void notInitialization01(){
		/**
		 * 被动使用类字段演示一：
		 *	通过子类引用父类的静态字段，不会导致子类初始化
		 */
		System.err.println(SubClass.value);
	}
	@Test
	public void notInitialization02(){
		/**
		 * 被动使用类字段演示二：
		 * 通过数组定义来引用类，不会触发此类初始化
		 */
		SuperClass[] scaArray = new SuperClass[10];
	}
	@Test
	public void notInitialization03(){
		/**
		 * 被动使用类字段演示三：
		 * 常量在变异阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
		 */
		System.err.println(SubClass.intgValue);
	}
	@Test
	public void notInitialization04(){
		/**
		 * 主动使用类字段演示三：
		 */
		System.err.println(SubClass.SUBCLASS);
	}
	public static void main(String[] args) {
		System.err.println(SubClass.SUBCLASS);
	}
}
