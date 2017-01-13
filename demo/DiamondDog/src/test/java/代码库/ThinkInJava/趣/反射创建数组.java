package 代码库.ThinkInJava.趣;

public class 反射创建数组 {
//	public T[]
//	T[] r = a.length >= size ? a :
//        (T[])java.lang.reflect.Array
//        .newInstance(a.getClass().getComponentType(), size);
	public static void main(String[] args) {
		int[][][][] r = (int[][][][])java.lang.reflect.Array
				.newInstance(int[][][][].class.getComponentType(),266);
		System.err.println(r.length);
		System.err.println(Thread.getAllStackTraces());
	}
}
