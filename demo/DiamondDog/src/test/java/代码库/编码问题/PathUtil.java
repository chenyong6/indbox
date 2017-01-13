package 代码库.编码问题;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class PathUtil {
	public static String getPath(Class<?> clazz){
		try {
			return URLDecoder.decode(clazz.getResource("").getPath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
