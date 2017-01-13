package xstream.converter.modle.yunwei;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import xstream.converter.BaseConverterBean;

@XStreamAlias("Message")
public class CameraInfo implements BaseConverterBean {
	// 消息ID(默认使用UUID)
	private String MsgID;
	// 消息类型(EQUIPMENT/SERVER消息类型,前端设备/中心服务)
	//EQUIPMENT
	private String MsgType = "EQUIPMENT";
	// 协议版本(当前默认2.0)
	private String Version = "2.0";
	// 厂商编码
	/**
	 *  0001	海信
		0002	大华
		0003	中盟
		0004	展祥
		0005	东方红海
		0006	海康
		0007	海博
		0008	宇航时代
		0009	松下
		0010	华通志远
		0011	依鲁光电
		0012	南京金晓
		0013	迪爱斯
		0014	信路威
		0015	曼德克
		0016	宇视科技
		0017	博达伟业
		0018	研华
		0019	华飞
		0020	华三
		0021	佛山航标
		0022	西安诺瓦
		0023	西安翔迅
	 */
	private String Provider = "0006";
	// 设备类型
	//13	视频监控
	private String EquipType = "13";
	// 设备编码
	private String EquipID;
	// 设备IP或服务所在服务器IP
	private String EquipIP;
	// 设备端口号或服务端口号(默认80)
	private String EquipPort = "80";
	// 上报设备名称
	private String EquipName;
	// 故障等级
	private String FaultLevel = "2";
	//故障类型
	@XStreamImplicit
	private List<FaultType1L> FaultType1L;
	//故障描述
	private String FaultDesc;
	//
	private FilePathes FilePathes;
	// 设备检测时间(格式:YYYY-MM-DD HH24:MM:SS)
	private String ChectTime;
	// 故障发生时间(格式:YYYY-MM-DD HH24:MM:SS)
	private String FaultTime;
	// 数据上传时间(格式:YYYY-MM-DD HH24:MM:SS)
	private String UploadTime;
	
	
	public static final String FAULTLEVEL_EQUIPMENT_UP = "2";
	
	
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getProvider() {
		return Provider;
	}
	public void setProvider(String provider) {
		Provider = provider;
	}
	public String getEquipType() {
		return EquipType;
	}
	public void setEquipType(String equipType) {
		EquipType = equipType;
	}
	public String getEquipID() {
		return EquipID;
	}
	public void setEquipID(String equipID) {
		EquipID = equipID;
	}
	public String getEquipIP() {
		return EquipIP;
	}
	public void setEquipIP(String equipIP) {
		EquipIP = equipIP;
	}
	public String getEquipPort() {
		return EquipPort;
	}
	public void setEquipPort(String equipPort) {
		EquipPort = equipPort;
	}
	public String getEquipName() {
		return EquipName;
	}
	public void setEquipName(String equipName) {
		EquipName = equipName;
	}
	public String getFaultLevel() {
		return FaultLevel;
	}
	public void setFaultLevel(String faultLevel) {
		FaultLevel = faultLevel;
	}
	public String getFaultDesc() {
		return FaultDesc;
	}
	public void setFaultDesc(String faultDesc) {
		FaultDesc = faultDesc;
	}
	public FilePathes getFilePathes() {
		return FilePathes;
	}
	public void setFilePathes(FilePathes filePathes) {
		FilePathes = filePathes;
	}
	public String getChectTime() {
		return ChectTime;
	}
	public void setChectTime(String chectTime) {
		ChectTime = chectTime;
	}
	public String getFaultTime() {
		return FaultTime;
	}
	public void setFaultTime(String faultTime) {
		FaultTime = faultTime;
	}
	public String getUploadTime() {
		return UploadTime;
	}
	public void setUploadTime(String uploadTime) {
		UploadTime = uploadTime;
	}
	public List<FaultType1L> getFaultType1L() {
		return FaultType1L;
	}
	public void setFaultType1L(List<FaultType1L> faultType1L) {
		FaultType1L = faultType1L;
	}

}
