package xstream.converter.impl;


import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xstream.converter.Converter;
import xstream.converter.XMLConverter;
import xstream.converter.modle.HtmlBean;
import xstream.converter.modle.HtmlBody;
import xstream.converter.modle.HtmlDiv;
import xstream.converter.modle.HtmlForm;
import xstream.converter.modle.HtmlInput;
import xstream.converter.modle.HtmlP;
import xstream.converter.modle.yunwei.CameraInfo;
import xstream.converter.modle.yunwei.FaultType1L;
import xstream.converter.modle.yunwei.FaultType2L;
import xstream.converter.modle.yunwei.FilePath;
import xstream.converter.modle.yunwei.FilePathes;
import xstream.converter.util.XstreamUtil;

import com.thoughtworks.xstream.XStream;

public class BeanToXMLConverterTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToXml() {
		HtmlBean bean = new HtmlBean();
		HtmlBody body = new HtmlBody();
		HtmlDiv div = new HtmlDiv();
		HtmlForm form = new HtmlForm();
		HtmlP p = new HtmlP();
		List<HtmlInput> inputs = new ArrayList<HtmlInput>();
		
		HtmlInput input = new HtmlInput();
		input.setId("btn_sub");
		input.setType("submit");
		input.setName("btn_sub");
		input.setValue("Submit");
		
		HtmlInput input2 = new HtmlInput();
		input2.setId("btn_res");
		input2.setType("reset");
		input2.setName("btn_res");
		input2.setValue("Reset");
		
		inputs.add(input);
		inputs.add(input2);
		
		p.setInput(inputs);
		
		div.setId("div1");
		div.setName("div");
		
		form.setAction("saveForm.asp");
		form.setH1("请输入您的联系信息：");
		form.setLable("名字:");
		form.setMethod("post");
		form.setP(p);
		
		body.setDiv(div);
		body.setForm(form);
		
		bean.setBody(body);
		
		XMLConverter converter = ConverterFactory.getBeanToXMLConverterInstance(bean);
		XStream xstream = XstreamUtil.getInstance();
		// 将对象转换为xml文件
		String xml = converter.toXml(xstream, bean.getClass(), true);
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
	@Test
	public void testToXml2() {
		CameraInfo bean = new CameraInfo();
		//bean.setMsgID("7f200a68f11e45a69ae7d3f8b63b5f5a");
		bean.setMsgType("ActiveMQ");
		bean.setVersion("11");
		List<FaultType1L> FaultType1Ls = new ArrayList<>();
		FaultType1L FaultType1L = new FaultType1L();
		FaultType1L FaultType1L2 = new FaultType1L();
		FaultType1Ls.add(FaultType1L);
		FaultType1L.setCode("1");
		List<FaultType2L> faultType2L = new ArrayList<>();
		FaultType1L.setFaultType2L(faultType2L);
		faultType2L.add(new FaultType2L("1"));
		faultType2L.add(new FaultType2L("2"));
		bean.setFaultType1L(FaultType1Ls);
		FaultType1Ls.add(FaultType1L2);
		FilePathes filePathes = new FilePathes();
		List<FilePath> filePaths = new ArrayList<>();
		filePaths.add(new FilePath(FilePath.TYPE_PIC,"testPath"));
		filePathes.setFilePath(filePaths);
		bean.setFilePathes(filePathes);
		XMLConverter converter = ConverterFactory.getBeanToXMLConverterInstance(bean);
		XStream xstream = XstreamUtil.getInstance();
		// 将对象转换为xml文件
		String xml = converter.toXml(xstream, bean.getClass(), true);
		xml = converter.replaceTag(xml, Converter.PLACEHOLDER);
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
