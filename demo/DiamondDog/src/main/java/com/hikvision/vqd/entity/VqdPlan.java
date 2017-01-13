package com.hikvision.vqd.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-2-19 上午10:28:05
 * @describe：
 */
public class VqdPlan {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 计划名称
	 */
	private String planName;

	/**
	 * 计划类型
	 */
	private String planType;

	/**
	 * 是否循环
	 */
	private String feedBackTime = "0";

	/**
	 * 检测类型
	 */
	private CheckType checkType = new CheckType();

	/**
	 * 检测时间
	 */
	private List<PlanTime> planTimes = new ArrayList<PlanTime>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getFeedBackTime() {
		return feedBackTime;
	}

	public void setFeedBackTime(String feedBackTime) {
		this.feedBackTime = feedBackTime;
	}

	public CheckType getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckType checkType) {
		this.checkType = checkType;
	}

	public List<PlanTime> getPlanTimes() {
		return planTimes;
	}

	public void setPlanTimes(List<PlanTime> planTimes) {
		this.planTimes = planTimes;
	}

}
