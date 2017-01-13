package xstream.converter;
import com.thoughtworks.xstream.XStream;




/**
 * 将其他形式的对象转换为xml形式的接口
 * 
 * @author crawler
 * 
 */
public interface XMLConverter extends Converter {

	/**
	 * 转换为xml形式的字符串
	 * @param xstream  		XStream实例化的对象
	 * @param type     		欲得到的BaseConverterBean的Class对象
	 * @param isAttribute 	xml类型：true为带属性的xml格式
	 * @return 				xml形式的字符串
	 */
	@SuppressWarnings("unchecked")
	public String toXml(XStream xstream, Class type, boolean isAttribute);

	public String replaceTag(String xml,String tag);
}
