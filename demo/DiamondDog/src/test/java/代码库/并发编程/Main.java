package 代码库.并发编程;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(11L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("---over---");
	}
}
