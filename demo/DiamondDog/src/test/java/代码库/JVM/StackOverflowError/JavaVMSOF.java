package 代码库.JVM.StackOverflowError;
/**
 * VM Args: -Xss128k
 */
public class JavaVMSOF {
	public int stackLength = 1;
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	public static void main(String[] args) {
		JavaVMSOF javaVMSOF = new JavaVMSOF();
		try{
			javaVMSOF.stackLeak();
		}catch(Throwable e){
			System.err.println("stack length:"+ javaVMSOF.stackLength);
			throw e;
		}
		
	}
}
