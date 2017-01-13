/**
 * 
 */
package com.hikvision.vqd.entity;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-4 上午11:21:12
 * @describe：通道的参数bean
 */
public class Channel {

	/**
	 * 监控点ID
	 */
	private String id;

	/**
	 * 是否检测
	 */
	private int checkFlag;

	/**
	 * ip地址
	 */
	private String ip;

	/**
	 * 端口
	 */
	private String port;

	/**
	 * 通道号
	 */
	private String channelNo;

	/**
	 * 登录用户名
	 */
	private String userName;

	/**
	 * 登录密码
	 */
	private String passWord;

	/**
	 * 码流类型：0-主码流，1-子码流
	 */
	private int streamType = 0;

	/**
	 * 网络协议：0-TCP,1-UDP,2-RTP,3-multi
	 */
	private int protocol = 0;

	/**
	 * 设备类型：0-枪机，1-球机，2-带云台枪机
	 * 
	 */
	private int devType = 0;

	/**
	 * 品牌代号：0-海康设备；1-大华设备；2-爱普视达；3-艾立克；4-东方网力+AV摄像头；5-长虹一体机；6-汉邦高科
	 */
	private String devBrand = "0";

	/**
	 * 流媒体服务器路径
	 */
	private String streamServerPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(int checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
//		if(StringUtils.isNotEmpty(passWord)){
//			try {
//				return AESUtils.decryptWithBase64(passWord,Constants.AES_ENCRYPT_KEY, Constants.AES_ENCRYPT_VECTOR);
//			} catch (AESErrorException e) {
//				LoggerFactory.getLogger(Channel.class).info("解析密码失败",e);
//			}
//		}
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getStreamType() {
		return streamType;
	}

	public void setStreamType(int streamType) {
		this.streamType = streamType;
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getDevType() {
		return devType;
	}

	public void setDevType(int devType) {
		this.devType = devType;
	}

	public String getDevBrand() {
		return devBrand;
	}

	public void setDevBrand(String devBrand) {
		this.devBrand = devBrand;
	}

	public String getStreamServerPath() {
		return streamServerPath;
	}

	public void setStreamServerPath(String streamServerPath) {
		this.streamServerPath = streamServerPath;
	}

	public int getSignal() {
		return PointConfigure.getAsInteger("signal", 90);
	}

	public int getBlur() {
		return PointConfigure.getAsInteger("blur", 65);
	}

	public int getContrast() {
		return PointConfigure.getAsInteger("contrast", 75);
	}

	public int getBright() {
		return PointConfigure.getAsInteger("bright", 55);
	}

	public int getDark() {
		return PointConfigure.getAsInteger("dark", 55);
	}

	public int getChroma() {
		return PointConfigure.getAsInteger("chroma", 25);
	}

	public int getMono() {
		return PointConfigure.getAsInteger("mono", 90);
	}

	public int getNoise() {
		return PointConfigure.getAsInteger("noise", 60);
	}

	public int getStreak() {
		return PointConfigure.getAsInteger("streak", 25);
	}

	public int getFreeze() {
		return PointConfigure.getAsInteger("freeze", 90);
	}

	public int getShake() {
		return PointConfigure.getAsInteger("shake", 10);
	}

	public int getFlash() {
		return PointConfigure.getAsInteger("flash", 40);
	}

	public int getScene() {
		return PointConfigure.getAsInteger("scene", 10);
	}

	public int getCover() {
		return PointConfigure.getAsInteger("cover", 80);
	}

	public int getPtz() {
		return PointConfigure.getAsInteger("ptz", 0);
	}

}
