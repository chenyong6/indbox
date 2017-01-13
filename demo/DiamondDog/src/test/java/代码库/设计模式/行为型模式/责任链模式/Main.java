package 代码库.设计模式.行为型模式.责任链模式;

public class Main {
	public static void main(String[] args) {
		MsgProcessor msgProcessor = new MsgProcessor();
		FilterChain filterChain = new FilterChain();
		msgProcessor.setFc(filterChain);
		filterChain.addFileter(new FaceFilter()).addFileter(new SesitiveFilter());
		System.err.println(msgProcessor.process("aaxxxaadafafsf"));
	}
}
