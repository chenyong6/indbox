package xstream.converter.impl;

import xstream.converter.BaseConverterBean;
import xstream.converter.BeanConverter;
import xstream.converter.XMLConverter;

/**
 * 转换器工厂
 * 
 * @author crawler
 * 
 */
public class ConverterFactory {
	/**
	 * 获得BeanToXMLConverter实例化对象
	 * 
	 * @param bean  实体Bean对象
	 *           
	 * @return BeanToXMLConverter 实例化对象
	 */
	public static XMLConverter getBeanToXMLConverterInstance(BaseConverterBean bean) {
		return new BeanToXMLConverter(bean);
	}
	
	public static BeanConverter getXMLToBeanConverterInstance(String xml) {
		return new XMLToBeanConverter(xml);
	}
}
