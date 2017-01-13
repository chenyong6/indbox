package 代码库.并发编程.并发编程的艺术.并发工具类;

import java.util.concurrent.CountDownLatch;

public class Driver {
	public static void main() throws InterruptedException {
		int N = 5;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);

		for (int i = 0; i < N; ++i) // create and start threads
			new Thread(new Worker(startSignal, doneSignal)).start();

		// doSomethingElse(); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		// doSomethingElse();
		doneSignal.await(); // wait for all to finish
	}

	static class Worker implements Runnable {
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;

		Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (InterruptedException ex) {
			} // return;
		}

		void doWork() {
			System.err.println("---");
		}
	}
}
