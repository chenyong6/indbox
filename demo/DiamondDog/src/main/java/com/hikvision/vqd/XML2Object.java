/**
 * 
 */
package com.hikvision.vqd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-11 下午04:30:26
 * @describe：把xml转化为对象
 */
public class XML2Object {

	/**
	 * Description:把XML转化为对象， 对象必须满足javabean规范 ， 暂时只支持string的转化
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-11 下午04:33:05
	 * @param xml
	 * @param obj
	 * @return
	 * 
	 */
	public static Object parseObject(String xml, Object obj) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if (doc == null) {
			return new Object();
		}
		Element root = doc.getRootElement();
		Method[] methods = obj.getClass().getDeclaredMethods();
		try {
			for (Method method : methods) {
				// 不是set方法则跳过
				if (!method.getName().startsWith("set")) {
					continue;
				}
				// 获取属性名
				String attrName = method.getName().substring(3, 4)
						.toLowerCase()
						+ method.getName().substring(4);
				method.invoke(
						obj,
						(root.element(attrName) == null) ? root
								.element(attrName) : root.element(attrName)
								.getText());
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
