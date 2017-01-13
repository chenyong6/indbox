package 代码库.并发编程.并发编程的艺术.并发容器和框架;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class Java里的阻塞队列 {
	@Test
	public void test_ArrayBlockingQueue(){
		ArrayBlockingQueue<Object> abq = new ArrayBlockingQueue<>(10, false);
		abq.offer("");
	}
	/**
	 * 默认初始容量Integer.MAX
	 * ReentrantLock
	 */
	@Test
	public void test_LinkedBlockintQueue(){
		LinkedBlockingQueue<Object> abq = new LinkedBlockingQueue<>();
		abq.offer("");
	}
	
	@Test
	public void test_PriorityBlockingQueue(){
		
	}
}
