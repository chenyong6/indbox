package xstream.converter.modle.yunwei;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
@XStreamAlias("FaultType2L")
public class FaultType2L {
	@XStreamAsAttribute
	private String code;

	
	public FaultType2L(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
