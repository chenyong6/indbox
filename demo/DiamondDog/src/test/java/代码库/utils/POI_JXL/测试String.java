package 代码库.utils.POI_JXL;
import org.junit.Test;


public class 测试String {
	@Test
	public void StringStringBuilder (){
		long start = System.nanoTime();
		String str = "aaa"+"bbb"+"ccc";
		System.err.println("String："+(System.nanoTime() - start));
		start = System.nanoTime();
		StringBuilder strBld = new StringBuilder();
		strBld.append("ddd").append("eee").append("fff");
		System.err.println("StringBuilder："+(System.nanoTime() - start));
		start = System.nanoTime();
		StringBuilder strBld2 = new StringBuilder();
		strBld.append("ddd").append("eee").append("fff");
		System.err.println("StringBuilder："+(System.nanoTime() - start));
		String str2 = "aaa"+"bbb"+"ccc";
		System.err.println("String："+(System.nanoTime() - start));
	}
	@Test
	public void string (){
		long start = System.nanoTime();
		String str = "";
		for(int i = 0 ;i<Integer.MAX_VALUE/10000;i++){
			str+="1";
		}
		System.err.println("String："+(System.nanoTime() - start));
	}
	@Test
	public void stringBuilder (){
		long start = System.nanoTime();
		StringBuilder str = new StringBuilder(Integer.MAX_VALUE/10000+1);
		for(int i = 0 ;i<Integer.MAX_VALUE/10000;i++){
			str.append("1");
		}
		System.err.println("StringBuilder："+(System.nanoTime() - start));
	}
	@Test
	public void string01 (){
		long start = System.nanoTime();
		String str = "";
		int max = Integer.MAX_VALUE/10000;
		for(int i = 0 ;i<max;i++){
			str+="1";
		}
		System.err.println("String01："+(System.nanoTime() - start));
	}
	@Test
	public void stringBuilder01 (){
		long start = System.nanoTime();
		int max = Integer.MAX_VALUE/10000;
		StringBuilder str = new StringBuilder(max+1);
		for(int i = 0 ;i<max;i++){
			str.append("1");
		}
		System.err.println("StringBuilder01："+(System.nanoTime() - start));
	}
}
