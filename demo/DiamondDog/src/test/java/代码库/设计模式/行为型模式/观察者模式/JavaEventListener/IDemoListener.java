package 代码库.设计模式.行为型模式.观察者模式.JavaEventListener;

public interface IDemoListener extends java.util.EventListener {
    //EventListener是所有事件侦听器接口必须扩展的标记接口、因为它是无内容的标记接口、
    //所以事件处理方法由我们自己声明如下：
    public void handleEvent(DemoEvent dm);
}
