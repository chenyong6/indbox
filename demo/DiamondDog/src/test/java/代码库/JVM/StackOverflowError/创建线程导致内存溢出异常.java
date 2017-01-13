package 代码库.JVM.StackOverflowError;

public class 创建线程导致内存溢出异常 {
	private void dontStop() {
		while(true){
			
		}
	}
	public void stackLeakByThread(){
//		while(true){
//			Thread t = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					dontStop();
//				}
//			}).start();
//			//Thread thread = new Thread().start();
//		}
	}
}
