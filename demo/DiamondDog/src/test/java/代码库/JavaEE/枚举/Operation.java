package 代码库.JavaEE.枚举;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
	
	PLUS("+") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return 0;
		}
	},MINUS("-") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return 0;
		}
	},TIMES("*") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return 0;
		}
	},DIVIDE("/") {
		@Override
		double apply(double x, double y) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	private final String symbol;
	
	private static final Map<String,Operation> strToEnum
		= new HashMap<String, Operation>();
	static {
		for(Operation op : values()){
			strToEnum.put(op.toString(), op);
		}
	}
	Operation(String symbol){
		this.symbol = symbol;
	}
	@Override
	public String toString(){
		return symbol;
	}
	abstract double apply(double x,double y);
	
}
