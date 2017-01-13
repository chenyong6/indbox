package xstream.converter.modle.yunwei;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import xstream.converter.Converter;

@XStreamAlias("FilePath")
public class FilePath {
	//图片 1 视频 2
	@XStreamAsAttribute
	private String type ;
	@XStreamAlias(Converter.PLACEHOLDER)
	private String value;
	
	public static String TYPE_PIC = "1";
	
	public static String TYPE_VIDEO = "2";
	
	public FilePath(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void set$value(String value) {
		this.value = value;
	}
	
	
}
