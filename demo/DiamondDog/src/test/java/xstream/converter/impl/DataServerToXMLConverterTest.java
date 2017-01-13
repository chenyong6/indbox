package xstream.converter.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xstream.converter.XMLConverter;
import xstream.converter.modle.HtmlBean;
import xstream.converter.modle.HtmlBody;
import xstream.converter.modle.HtmlDiv;
import xstream.converter.modle.HtmlForm;
import xstream.converter.modle.HtmlInput;
import xstream.converter.modle.HtmlP;
import xstream.converter.util.XstreamUtil;

import com.hikvision.vqd.entity.xml.DataServer;
import com.thoughtworks.xstream.XStream;

public class DataServerToXMLConverterTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToXml() {
		DataServer dataServer = new DataServer("1.0","urn:selfextension:psiaext-ver10-xsd");
		dataServer.setId(UUID.randomUUID().toString());
		dataServer.setIp("127.0.0.1");
		dataServer.setPort("7820");
		dataServer.setAlarmFlag("0");
		XMLConverter converter = ConverterFactory.getBeanToXMLConverterInstance(dataServer);
		XStream xstream = XstreamUtil.getInstance();
		// 将对象转换为xml文件
		String xml = converter.toXml(xstream, dataServer.getClass(), true);
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if(doc!=null){
			xml = doc.asXML();
		}
		System.out.println(xml);		
	}

}
