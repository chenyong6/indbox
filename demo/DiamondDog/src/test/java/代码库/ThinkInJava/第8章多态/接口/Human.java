package 代码库.ThinkInJava.第8章多态.接口;

public class Human implements IHuman {

	@Override
	public void say() {
		System.err.println("内存地址："+this);

	}
	public static void main(String[] args) {
		Human human = new Human();
		human.say();
		human.
		IHuman human2 = human;
		human2.say();
	}
}
