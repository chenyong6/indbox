package 代码库.设计模式.行为型模式.责任链模式.模拟Servlet的Filter;

public class Main {

    /**
     * 模拟Servlet中Request和Response的调用过程
     */
    public static void main(String[] args) {
        String msg = "大家好:)，<script>，敏感，被就业，网络授课没感觉，因为看不见大家伙儿";
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter())
          .addFilter(new SesitiveFilter())
          ;
        
        fc.doFilter(request, response, fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }

}