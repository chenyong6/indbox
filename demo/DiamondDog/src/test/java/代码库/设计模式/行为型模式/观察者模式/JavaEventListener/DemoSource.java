package 代码库.设计模式.行为型模式.观察者模式.JavaEventListener;

import java.util.Enumeration;
import java.util.Vector;

public class DemoSource {
    private Vector repository = new Vector();//监听自己的监听器队列
    public DemoSource(){}
    public void addDemoListener(IDemoListener dl) {
           repository.addElement(dl);
    }
    public void notifyDemoEvent() {//通知所有的监听器
           Enumeration enum1 = repository.elements();
           while(enum1.hasMoreElements()) {
        	   IDemoListener dl = (IDemoListener)enum1.nextElement();
                 dl.handleEvent(new DemoEvent(this));
           }
    }
}
