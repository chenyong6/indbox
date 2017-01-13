package xstream.converter.modle;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import xstream.converter.BaseConverterBean;

@XStreamAlias("body")
public class HtmlBody implements BaseConverterBean {
	private HtmlDiv div;
	private HtmlForm form;

	public HtmlForm getForm() {
		return form;
	}

	public void setForm(HtmlForm form) {
		this.form = form;
	}

	public HtmlDiv getDiv() {
		return div;
	}

	public void setDiv(HtmlDiv div) {
		this.div = div;
	}

}
