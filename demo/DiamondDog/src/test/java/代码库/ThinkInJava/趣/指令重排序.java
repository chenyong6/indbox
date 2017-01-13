package 代码库.ThinkInJava.趣;

public class 指令重排序 {
	public static int flag;

	public static void test() {
		System.err.println(++flag);
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
				指令重排序.test();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
				指令重排序.test();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
				指令重排序.test();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
				指令重排序.test();
			}
		}).start();
	}
}
