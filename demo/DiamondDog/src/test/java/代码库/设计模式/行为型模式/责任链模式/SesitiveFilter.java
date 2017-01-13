package 代码库.设计模式.行为型模式.责任链模式;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("xx", "aa");
	}

}
