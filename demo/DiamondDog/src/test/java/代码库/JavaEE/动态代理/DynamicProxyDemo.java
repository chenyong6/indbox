package 代码库.JavaEE.动态代理;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
//	 public static void consumer(Subject subject) {
//	       subject.operation1();
//	       subject.operation2("ZJ");
//	    }
//	   
	    public static void main(String[] args) {
	       ISubject real = new SubjectImpl();
	       System.out.println("===Without Proxy===");
	       //consumer(real);
	       System.out.println("===Use Proxy===");
	       ISubject proxy = (ISubject) Proxy.newProxyInstance(ISubject.class
	              .getClassLoader(), new Class[] { ISubject.class },
	              new DynamicProxyHandler(real));
	       proxy.action("Hello");
	       
	       //consumer(proxy);
	    }
}
