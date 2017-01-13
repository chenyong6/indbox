package 代码库.设计模式.行为型模式.责任链模式.模拟Servlet的Filter;

public interface Filter {
	 void doFilter(Request request, Response response, FilterChain chain);
}
