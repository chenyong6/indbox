package xstream.converter;

import com.thoughtworks.xstream.XStream;




/**
 * 将其他形式的对象转换为实体Bean对象
 * 
 * @author crawler
 * 
 */
public interface BeanConverter extends Converter {
	/**
	 * 
	 * 转换为单实体Bean对象
	 * 
	 * @xstream XStream实例化的对象
	 * 
	 * @type  欲得到的BaseConverterBean的Class对象
	 * 
	 * @param isAttribute xml类型：true为带属性的xml格式
	 * 
	 * @return 返回实体Bean
	 */
	@SuppressWarnings("unchecked")
	public BaseConverterBean stringToBean(XStream xstream,Class type,boolean isAttribute);
}
