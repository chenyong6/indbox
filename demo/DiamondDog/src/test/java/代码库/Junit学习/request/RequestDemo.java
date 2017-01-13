package 代码库.Junit学习.request;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

import 代码库.Junit学习.LifeCycleTest;

public class RequestDemo {
	public static void test()throws Exception{  
        Request rqst = Request.method(LifeCycleTest.class,"testMethod1");  
        Result r = new JUnitCore().run(rqst);    
        System.out.println(r.wasSuccessful() );  
    }  
	public static void main(String[] args) throws Exception {
		String str = String.format("%s(%s)", "testMethod1", LifeCycleTest.class.getName());
		System.err.println(str);
		RequestDemo.test();
	}
}
