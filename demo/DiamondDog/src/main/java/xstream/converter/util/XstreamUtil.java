package xstream.converter.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * xstream工具类
 * 
 * @author crawler
 * 
 */
public class XstreamUtil {
	/**
	 * 构造XStream对象
	 * @return 实例化的XStream对象
	 */
	public static XStream getInstance() {
		//return  new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		return  new XStream();
	}

	/**
	 * 构造带DomDriver的XStream对象 
	 * 用于将xml转换为实体bean对象的时候使用
	 * @return 实例化的XStream对象
	 */
	public static XStream getDriverInstace() {
		return new XStream(new DomDriver());
	}
	
	/**
	 * 将对象中的自定义对象替换成对应的昵称
	 * @param xstream XStream实例化对象
	 * @param classes 存放Class：alias的Map对象
	 * @return 更换昵称后的XStream对象
	 */
	@SuppressWarnings("unchecked")
	public static XStream aliasClasses(XStream xstream,Map classes){
		Iterator iterator = classes.keySet().iterator();
		if(iterator!=null && iterator.hasNext()){
			Class c = null;
			for(;iterator.hasNext();){
				c = (Class)iterator.next();
				xstream.alias((String)classes.get(c), c);
			}
		}
		return xstream;
	}

	/**
	 * 将对象中的属性替换成对应的昵称
	 * @param xstream	XStream实例化对象
	 * @param bean		自定义对象的Class
	 * @param fields	属性名与昵称对应的Map对象
	 * @return 			更换昵称规则后的XStream对象
	 */
	@SuppressWarnings("unchecked")
	public static XStream aliasFields(XStream xstream, Class bean, Map fields) {
		Iterator iterator = fields.keySet().iterator();
		if(iterator!=null && iterator.hasNext()){
			String fieldName = "";
			for(;iterator.hasNext();){
				fieldName = (String)iterator.next();
				xstream.aliasField((String)fields.get(fieldName),bean,fieldName);
			}
		}
		return xstream;
	}
	
	@SuppressWarnings("unchecked")
	public static XStream xx(XStream xstream,Class bean,List<String> fields){
		for(String field:fields){
			xstream.useAttributeFor(bean, field);
		}
		return xstream;
	}
}
