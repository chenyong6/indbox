package xstream.converter.modle.yunwei;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("FaultType1L")
public class FaultType1L {
	@XStreamAsAttribute
	private String code;
	@XStreamImplicit
	List<FaultType2L> FaultType2L = new ArrayList<FaultType2L>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<FaultType2L> getFaultType2L() {
		return FaultType2L;
	}

	public void setFaultType2L(List<FaultType2L> faultType2L) {
		FaultType2L = faultType2L;
	}

	
}
