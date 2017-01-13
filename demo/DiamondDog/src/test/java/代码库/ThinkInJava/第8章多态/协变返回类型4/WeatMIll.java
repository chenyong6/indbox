package 代码库.ThinkInJava.第8章多态.协变返回类型4;

public class WeatMIll extends Mill {
	@Override
	Wheat process(){
		return new Wheat();
	}

}
