package 代码库.JavaEE.反射.getClass;

public class Main {
	
	public static void test(IClass clazz){
		System.err.println(clazz.getClass());
	}
	
	public static void main(String[] args) {
		ClassImpl ClassImpl = new ClassImpl();
		System.err.println(ClassImpl.getClass());
		test(ClassImpl);
		
	}
}
