/**
 * 
 */
package com.hikvision.vqd.entity;

import org.apache.commons.lang.StringUtils;

import com.hikvision.vqd.VqdConstants;
import com.hikvision.vqd.exception.VqdConnectException;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-4 下午05:22:17
 * @describe：vqd返回的结果
 */
public class ReplyInfo {

	/**
	 * 0-成功,1- 无权限,2-数据有误，3-用户不在线， 4-用户已存在， 5-超过最大用户数，6-超过最大任务数
	 */
	private String status;

	public int getStatus() {
		if (StringUtils.isBlank(status)) {
			return -1;
		}
		return Integer.parseInt(status);
	}

	public boolean hasSuccessed() throws VqdConnectException {
		if (getStatus() != 0) {
			throw new VqdConnectException(getFailReason());
		}
		return true;
	}

	private String getFailReason() {
		String result = null;
		switch (getStatus()) {
		case -1:
			result = VqdConstants.REPLY_TYPE_NULL;
			break;
		case 1:
			result = VqdConstants.REPLY_TYPE_ONE;
			break;
		case 2:
			result = VqdConstants.REPLY_TYPE_TWO;
			break;
		case 3:
			result = VqdConstants.REPLY_TYPE_THREE;
			break;
		case 4:
			result = VqdConstants.REPLY_TYPE_FOUR;
			break;
		case 5:
			result = VqdConstants.REPLY_TYPE_FIVE;
			break;
		case 6:
			result = VqdConstants.REPLY_TYPE_SIX;
			break;
		default:
			result = VqdConstants.REPLY_ERROR_TYPE + status;
			break;
		}
		return result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
