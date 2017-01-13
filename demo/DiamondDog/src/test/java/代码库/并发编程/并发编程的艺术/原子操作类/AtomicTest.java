package 代码库.并发编程.并发编程的艺术.原子操作类;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicTest {
	@Test
	public void atomicBoolean_test(){
		AtomicBoolean ab = new AtomicBoolean();
		System.err.println(ab.getAndSet(true));
	}
	@Test
	public void atomicInteger_test(){
		AtomicInteger ai = new AtomicInteger();
		System.err.println(ai.incrementAndGet());
	}
}
