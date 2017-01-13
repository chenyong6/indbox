package com.hikvision.vqd.entity;

import org.apache.commons.lang3.StringUtils;

public class StatusInfo {

	private String remainAbility;

	public int getRemainAbility() {
		if (StringUtils.isBlank(remainAbility)) {
			return -1;
		}
		return Integer.parseInt(remainAbility);
	}
	public void setRemainAbility(String remainAbility) {
		this.remainAbility = remainAbility;
	}

}
