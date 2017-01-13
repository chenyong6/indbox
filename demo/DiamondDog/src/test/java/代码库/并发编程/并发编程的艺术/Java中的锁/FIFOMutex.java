package 代码库.并发编程.并发编程的艺术.Java中的锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class FIFOMutex implements Lock {
	// 静态内部类，自定义同步器，同步器组合在类的内部 
	private static class Sync extends AbstractQueuedSynchronizer{

		// 状态为 0 的时候去获取锁
		@Override
		protected boolean tryAcquire(int arg) {
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				Thread thread = Thread.currentThread();
				System.err.println("thread : " + thread.getName()+" 获取到锁。");
				return true;
			}
			
			return false;
		}
		// 释放锁，将状态置为 0
		@Override
		protected boolean tryRelease(int arg) {
			if(getState() == 0){
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			Thread thread = Thread.currentThread();
			System.err.println("thread : " + thread.getName()+" 释放了锁。");
			return true;
		}
		// 是否处于占用状态
		@Override
		protected boolean isHeldExclusively() {
			// TODO Auto-generated method stub
			return super.isHeldExclusively();
		}
		/* (non-Javadoc)
		 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryAcquireShared(int)
		 */
		@Override
		protected int tryAcquireShared(int arg) {
			// TODO Auto-generated method stub
			return super.tryAcquireShared(arg);
		}

		/* (non-Javadoc)
		 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryReleaseShared(int)
		 */
		@Override
		protected boolean tryReleaseShared(int arg) {
			// TODO Auto-generated method stub
			return super.tryReleaseShared(arg);
		}
		
	}
	// 将操作代理到 Sync 上即可
	private final Sync sync = new Sync();
	
	@Override
	public void lock() {
		/**
		 * 独占的方式去获取同步状态 ，该方法对中断不敏感
		 * 逻辑：
		 *  1.调用自定义同步器实现的 tryAcquire(int arg)方法，
		 *  2.如果同步方法获取失败，则构造同步节点（独占式 node）将方法加入同步队列的尾部
		 *  3.调用acquireQueued()
		 */
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		
		sync.release(0);
	}

	@Override
	public Condition newCondition() {
		return null;
	}

}
