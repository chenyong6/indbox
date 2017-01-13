package 代码库.设计模式.行为型模式.责任链模式.模拟Servlet的Filter;

public class SesitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace("被就业", "就业")
         .replace("敏感", "") + "---SesitiveFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---SesitiveFilter()";
    }    
    
}