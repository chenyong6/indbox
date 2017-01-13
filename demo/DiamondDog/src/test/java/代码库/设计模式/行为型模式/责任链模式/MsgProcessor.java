package 代码库.设计模式.行为型模式.责任链模式;

public class MsgProcessor {
	private String msg;
	private FilterChain fc;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public FilterChain getFc() {
		return fc;
	}
	public void setFc(FilterChain fc) {
		this.fc = fc;
	}
	public String process(String msg){
		return fc.doFilter(msg);
	}
}
