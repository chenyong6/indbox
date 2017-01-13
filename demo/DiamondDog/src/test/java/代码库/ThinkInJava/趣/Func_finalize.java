package 代码库.ThinkInJava.趣;

import java.util.concurrent.TimeUnit;

public class Func_finalize {
	/**
	 * finalize方法只会被调用一次
	 */
	public static Func_finalize func_finalize = null;
	public void alive(){
		final int x ;
		int c;
		System.err.println("ye ye ~");
	}
	@Override
	protected void finalize() throws Throwable {
		
		System.err.println("i'am dead");
		func_finalize = this;
		
	};
	public static void main(String[] args) {
		Func_finalize.func_finalize  = new Func_finalize();
		Func_finalize.func_finalize.alive();
		Func_finalize.func_finalize = null;
		System.gc();
		
		try {
			TimeUnit.SECONDS.sleep(3L);
			System.err.println("等待复活");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Func_finalize.func_finalize.alive();
		Func_finalize.func_finalize = null;
		System.gc();
	}
}
