package 代码库.并发编程.Volatile;

public class 开销较低的_写锁 {
	private volatile int value = 0;

	public int getValue() {
		return value;
	}
	public synchronized void increase(){
		value++;
	}
}
