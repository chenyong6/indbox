package 代码库.并发编程.并发编程的艺术.并发编程基础.线程应用实例;

public class 等待超时模式 {
	/**
	 * 等待持续时间：REMAINING=T
	 * 等待超时时间：FUTURE=NOW+T
	 * @throws InterruptedException 
	 */
	public  synchronized Object fetch(long mills) throws InterruptedException{
		long future = System.currentTimeMillis() + mills;
		long remaining = mills;
		Object pool = new Object();
		while((pool/*isEmpty*/ == null)&&remaining >0){
			super.wait(remaining);
			remaining = future - System.currentTimeMillis();
			
		}
		return future;
	}
	public static void main(String[] args) throws InterruptedException {
		System.err.println("--wait--");
		等待超时模式 等待超时模式 = new 等待超时模式();
		System.err.println(等待超时模式.fetch(1000L));
	}
}
