package xstream.converter.modle;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import xstream.converter.BaseConverterBean;

@XStreamAlias("html")
public class HtmlBean implements BaseConverterBean {
	private HtmlBody body;

	public HtmlBody getBody() {
		return body;
	}

	public void setBody(HtmlBody body) {
		this.body = body;
	}

}
