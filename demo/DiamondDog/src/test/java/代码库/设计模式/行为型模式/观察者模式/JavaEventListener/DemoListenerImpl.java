package 代码库.设计模式.行为型模式.观察者模式.JavaEventListener;

public class DemoListenerImpl implements IDemoListener {  
    public void handleEvent(DemoEvent de) {  
           System.out.println("Inside listener1...");  
           de.say();//回调  
    }  
}
