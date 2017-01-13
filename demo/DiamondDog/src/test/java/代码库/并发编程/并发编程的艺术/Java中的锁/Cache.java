package 代码库.并发编程.并发编程的艺术.Java中的锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
	private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
	private static final Lock R = LOCK.readLock();
	private static final Lock W = LOCK.writeLock();
	private static final Map<String,Object> MAP = new HashMap<>();
	
	public static final void put(String key,Object value){
		W.lock();
		try{
			MAP.put(key, value);
		}finally{
			W.unlock();
		}
	}
	
	public static final Object get(String key){
		R.lock();
		Object v = null;
		try{
			v = MAP.get(key);
		}finally{
			R.unlock();
		}
		return v;
	}
	
}
