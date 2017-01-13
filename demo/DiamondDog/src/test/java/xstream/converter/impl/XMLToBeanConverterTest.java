package xstream.converter.impl;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import xstream.converter.modle.HtmlBean;
import xstream.converter.util.XstreamUtil;

public class XMLToBeanConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToBean() {
		HtmlBean bean = null;
		XStream xstream = XstreamUtil.getDriverInstace();
		String xml = getResourceFileContent(XMLToBeanConverterTest.class, "html.xml");
		if(xml!=null && !"".equals(xml)){
			bean = (HtmlBean)ConverterFactory.getXMLToBeanConverterInstance(xml).stringToBean(xstream, HtmlBean.class, true);
		}
		String divid = bean.getBody().getDiv().getId();
		String expected = "div1";
		assertEquals(expected, divid);
	}
	
    @SuppressWarnings("unchecked")
	public static String getResourceFileContent(Class c,String name){
    	StringBuffer sb = new StringBuffer();
    	try {
    		InputStream input = c.getClassLoader().getResourceAsStream(name);
    		BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
    		String line = null;
    		while ((line = reader.readLine()) != null) {
    			sb.append(line);
    		}
    		reader.close();
    		input.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return sb.toString();
    }
}
