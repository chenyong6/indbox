package 代码库.JavaEE.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
	
	private Object proxied;
	 
    public DynamicProxyHandler(Object proxied) {
       this.proxied = proxied;
    }
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**** proxy: ****\n" + proxy.getClass()
	              + "\nmethod: " + method + "\nargs: " + args);
	       if (args != null)
	           for (Object arg : args)
	              System.out.println("  " + arg);
	       System.err.println("方法执行前--〉");
	       Object o = method.invoke(proxied, args);
	       System.err.println("方法执行后--〉");
	       return o;
	}

}
