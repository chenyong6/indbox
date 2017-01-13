package 代码库.设计模式.行为型模式.观察者模式;

public class JobSeeker implements Observer {
	private String name;

	public JobSeeker(String name){
		this.name = name;
	}

	@Override
	public void update(Subject subject) {
		System.out.println(this.name + " got notified!");
		System.out.println(subject);
	}
}