package 代码库.JavaEE.动态代理.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.CallbackFilter;

public class MyProxyFilter implements CallbackFilter {
	@Override
	public int accept(Method arg0) {
		if (!"query".equalsIgnoreCase(arg0.getName()))
			return 0;
		return 1;
	}
}