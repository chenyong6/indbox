package 代码库.设计模式.行为型模式.观察者模式.JavaEventListener;

public class Main {
	DemoSource ds;

	public Main() {
		try {
			ds = new DemoSource();

			// 将监听器在事件源对象中登记：
			DemoListenerImpl l1 = new DemoListenerImpl();
			ds.addDemoListener(l1);
			ds.addDemoListener(new IDemoListener() {
				public void handleEvent(DemoEvent event) {
					System.out.println("Method come from 匿名类...");
				}
			});

			ds.notifyDemoEvent();// 触发事件、通知监听器

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new Main();
	}
}
