package 代码库.ThinkInJava.趣;

public class HashMap计算数组下标 {
	public static void main(String[] args) {
		/**
		 * 当且仅当length=2^n时 ，且h>0时  h & (length-1) 等价于 h %(	取模) length
		 */
		int h = -127;
		int length = 8;
		System.err.println(" h & (length-1) :" + ( h & (length-1)));
		System.err.println(" h % length :" + (h % length));
//		for(;h<10000;h++){
//			System.err.println("--------- ---------- ----------");
//			System.err.println(" h & (length-1) :" + ( h & (length-1)));
//			System.err.println(" h % length :" + (h % length));
//			System.err.println("h & (length-1)== h % length ： "+length+" "+(( h & (length-1))==(h % length)));
//		}
		
		
	}
}
