package 代码库.JVM.Finally;

public class X {
	public static void main(String[] args) {
		int a = 1;
		try{
			a = 2;
			return;
		}catch(Exception e){
			a = 3;
		}finally {
			a = 4;
		}
		System.err.println(a);
	}
}
