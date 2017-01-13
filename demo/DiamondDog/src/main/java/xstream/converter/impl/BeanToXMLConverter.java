package xstream.converter.impl;


import xstream.converter.BaseConverterBean;
import xstream.converter.XMLConverter;

import com.thoughtworks.xstream.XStream;

/**
 * 将bean对象转换为xml形式的转换器
 * 
 * @author crawler
 * 
 */
public class BeanToXMLConverter implements XMLConverter {
	private BaseConverterBean bean;

	public BeanToXMLConverter(BaseConverterBean bean) {
		this.bean = bean;
	}

	@SuppressWarnings("unchecked")
	public String toXml(XStream xstream,Class type,boolean isAttribute) {
		if(isAttribute){
			xstream.processAnnotations(type);
		}
		return xstream.toXML(bean);
	}

	@Override
	public String replaceTag(String xml,String tag) {
		
		
		return xml.replace("<"+tag+">", "").replace("</"+tag+">", "");
	}
}
