package xstream.converter.impl;

import xstream.converter.BaseConverterBean;
import xstream.converter.BeanConverter;

import com.thoughtworks.xstream.XStream;






/**
 * xml转换为对应的实体bean对象
 * 
 * @author crawler
 * 
 */
public class XMLToBeanConverter implements BeanConverter {
	private String xml;
	public XMLToBeanConverter(String xml){
		this.xml = xml;
	}
	@SuppressWarnings("unchecked")
	public BaseConverterBean stringToBean(XStream xstream,Class type,boolean isAttribute) {
		if(isAttribute){
			xstream.processAnnotations(type);
		}
		return (BaseConverterBean)xstream.fromXML(xml);
	}
}
