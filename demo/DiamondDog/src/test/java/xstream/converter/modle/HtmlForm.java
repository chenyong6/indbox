package xstream.converter.modle;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import xstream.converter.BaseConverterBean;

@XStreamAlias("form")
public class HtmlForm implements BaseConverterBean {
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	private String h1;
	private String lable;
	private HtmlP p;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getH1() {
		return h1;
	}

	public void setH1(String h1) {
		this.h1 = h1;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public HtmlP getP() {
		return p;
	}

	public void setP(HtmlP p) {
		this.p = p;
	}

}
