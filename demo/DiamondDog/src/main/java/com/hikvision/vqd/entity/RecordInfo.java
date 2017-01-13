package com.hikvision.vqd.entity;
/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-20 上午10:34:07
 * @describe：诊断截图信息
 */
public class RecordInfo {

	/**
	 * 通道ID
	 */
	private String chanID;

	/**
	 * 状态 ：0-成功,1-数据有误， 2-图片不存在，3-获取图片失败
	 */
	private String status;

	/**
	 * 诊断截图
	 */
	private String snapshot;

	public String getChanID() {
		return chanID;
	}

	public void setChanID(String chanID) {
		this.chanID = chanID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

}
