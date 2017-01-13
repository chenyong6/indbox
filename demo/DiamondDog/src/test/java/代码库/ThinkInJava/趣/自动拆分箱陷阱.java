package 代码库.ThinkInJava.趣;

public class 自动拆分箱陷阱 {
	public static void main(String[] args) {
		/**
		 * -128~127 cache缓存 
		 * == 在不遇到预算符的情况下不会自动拆箱
		 * equals obj instanseOf xx
		 */
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Integer h = Integer.valueOf(2);
		Integer j = Integer.valueOf(2);
		Long g = 3L;
		System.err.println("c == d :"+(c==d)); 
		System.err.println("b == h :"+(b==h)); 
		System.err.println(h == j);
		System.err.println("e == f :"+(e==f));
		
		System.err.println("c == a+b :"+(c==(a+b)));
		System.err.println("c.equals(a+b) :"+(c.equals(a+b))); 
		System.err.println("g == a+b :"+(g==(a+b))); 
		System.err.println("g.equals(a+b) :"+(g.equals(a+b+0L))); 
	}
}
