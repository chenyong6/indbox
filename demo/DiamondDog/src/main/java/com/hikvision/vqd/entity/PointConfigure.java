package com.hikvision.vqd.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

public final class PointConfigure {

	private static Properties pro = new Properties();

	static {
		ClassPathResource resource = new ClassPathResource(
				"vqdPointConf.properties");
		InputStream is = null;
		try {
			is = resource.getInputStream();
			pro.load(is);
			if(is!= null){
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is!= null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static final String get(String key) {
		if (key == null) {
			return null;
		}
		return pro.getProperty(key);
	}

	public static final Integer getAsInteger(String key) {
		if (key == null || pro.get(key) == null) {
			return null;
		}
		return Integer.parseInt(pro.getProperty(key));
	}

	public static final Integer getAsInteger(String key, int defaultValue) {
		if (key == null || StringUtils.isBlank(pro.getProperty(key))) {
			return defaultValue;
		}
		return Integer.parseInt(pro.getProperty(key));
	}
}
