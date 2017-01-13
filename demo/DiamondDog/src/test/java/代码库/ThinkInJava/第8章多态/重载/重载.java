package 代码库.ThinkInJava.第8章多态.重载;


public class 重载 {
	
	public void 参数顺序不同(String str1,int x){
		System.err.println("参数类型不同可以区分两个方法，会使类难以维护");
	}
	public void 参数顺序不同(int x ,String str1){
		
	}
	/**
	 * 基本类型的重载
	 * 
	 */
	public void inputNum(char c){
		System.out.println("重载.inputNum(char c)"+c);
	}
	public void inputNum(int c){
		System.out.println("重载.inputNum(int c)"+c);
	}
	
	
	public static void main(String[] args) {
		重载 重载 = new 重载();
		重载.inputNum('c');
	}
}
