package com.hikvision.vqd.entity.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import xstream.converter.BaseConverterBean;

@XStreamAlias("DataServer")
public class DataServer implements BaseConverterBean{
	@XStreamAsAttribute
	private String version;
	@XStreamAsAttribute
	private String xmlns;
	
	private String id;
	
	private String ip;
	
	private String port;
	
	private String alarmFlag;
	
	public DataServer(String version,String xmlns){
		this.version = version;
		this.xmlns = xmlns;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAlarmFlag() {
		return alarmFlag;
	}

	public void setAlarmFlag(String alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
}
