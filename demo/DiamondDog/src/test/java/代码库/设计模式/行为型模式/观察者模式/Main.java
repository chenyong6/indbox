package 代码库.设计模式.行为型模式.观察者模式;

public class Main {
	public static void main(String[] args) {
		HeadCounter headCounter = new HeadCounter();
        //注册订阅者
		headCounter.registerObserver(new JobSeeker("Mike"));
		headCounter.registerObserver(new JobSeeker("Chris"));
		headCounter.registerObserver(new JobSeeker("Jeff"));
		//通知所有订阅者有新的工作机会
		headCounter.addJob("Google Job");
		headCounter.addJob("Yahoo Job");
		
	}
}