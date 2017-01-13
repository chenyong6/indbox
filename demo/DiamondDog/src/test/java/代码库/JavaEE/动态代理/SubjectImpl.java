package 代码库.JavaEE.动态代理;

public class SubjectImpl implements ISubject {

	@Override
	public void action(String str) {
		System.err.println("hello world!");
	}
	public static void main(String[] args) {
		ISubject subject = new SubjectImpl();
		subject.action("Hello");
	}
}
