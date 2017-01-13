package 代码库.设计模式.行为型模式.责任链模式;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	List<Filter> filters = new ArrayList<Filter>();
	@Override
	public String doFilter(String msg) {
		for(Filter filter:filters){
			msg = filter.doFilter(msg);
		}
		return msg;
	}
	public FilterChain addFileter(Filter filter){
		filters.add(filter);
		return this;
	}

}
