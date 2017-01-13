package 代码库.设计模式.创建型模式.单例模式;

public class 双重校验锁 {
	private static  volatile MyObject MYOBJ;
	
	public static final MyObject getInstance(){
		if(MYOBJ == null){
			//快速返回
			synchronized (双重校验锁.class) {
				if(MYOBJ == null){
					//加锁判断
					MYOBJ = new MyObject();
				}
			}
		}
		return MYOBJ;
	}
}
