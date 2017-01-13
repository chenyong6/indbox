package 代码库.设计模式.行为型模式.观察者模式;


public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyAllObservers();
}
