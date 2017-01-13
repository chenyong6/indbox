package 代码库.设计模式.行为型模式.责任链模式.模拟Servlet的Filter;

public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //process the html tag <>
        request.requestStr = request.requestStr.replace('<', '[')
                   .replace('>', ']') + "---HTMLFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---HTMLFilter()";
    }

}