package 代码库.JavaEE.反射.对象拷贝.domain;

import net.sf.cglib.core.Converter;


public class ConverterDiffType implements Converter{
	// value 源对象属性，target 目标对象属性类，context 目标对象setter方法名  
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Object value, Class target, Object context) {
		System.err.println(value +" : " + target + " : " + context);
		if("setId".equals(context)){
			
			return (Integer)value;  
		}
		return null;
	}

}
