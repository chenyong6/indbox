/**
 * 
 */
package com.hikvision.vqd.entity;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-7 下午06:09:24
 * @describe：
 */
public class PlanTime {

	private String planId;

	/**
	 * 周几，7表示每天
	 */
	private int day;

	private String startDate;

	private String endDate;

	public String getDayName() {
		String[] dayNames = {"周日", "周一", "周二", "周三", "周四", "周五", "周六", ""};
		return dayNames[day];
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getStartDate() {
		return startDate.length() == 4 ?  startDate.substring(0, 2)+":"+startDate.substring(2, 4) : startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate.length() == 4 ? endDate.substring(0, 2)+":"+endDate.substring(2, 4) : endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
