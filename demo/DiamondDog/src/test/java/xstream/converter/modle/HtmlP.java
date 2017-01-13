package xstream.converter.modle;

import java.util.List;

import xstream.converter.BaseConverterBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("p")
public class HtmlP implements BaseConverterBean {
	
	@XStreamImplicit
	private List<HtmlInput> input;

	public List<HtmlInput> getInput() {
		return input;
	}

	public void setInput(List<HtmlInput> input) {
		this.input = input;
	}

}
