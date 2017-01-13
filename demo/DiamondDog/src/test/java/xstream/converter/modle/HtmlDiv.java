package xstream.converter.modle;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import xstream.converter.BaseConverterBean;

@XStreamAlias("div")
public class HtmlDiv implements BaseConverterBean {
	@XStreamAsAttribute
	private String id;
	@XStreamAsAttribute
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
