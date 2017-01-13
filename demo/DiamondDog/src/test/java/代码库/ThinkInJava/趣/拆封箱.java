package 代码库.ThinkInJava.趣;

public class 拆封箱 {
	Integer a = 1;
	Integer b = Integer.valueOf(1);
	
	
	public void testAdd(){
		System.err.println(a == b);
	}
	public static void main(String[] args) {
		拆封箱  拆封箱  = new 拆封箱 ();
		拆封箱 .testAdd();
	}
}
