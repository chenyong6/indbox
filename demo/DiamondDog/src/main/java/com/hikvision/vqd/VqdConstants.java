package com.hikvision.vqd;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2014-1-16 下午04:11:14
 * @describe：常量描述
 */
public class VqdConstants {

	public static final String NOT_CONNET = "VQD系统当前无法连接";
	public static final String IP_IS_NULL = "ip为空";
	public static final String PORT_IS_NULL = "端口为空";
	public static final String REPLY_TYPE_NULL = "VQD系统返回为空";
	public static final String REPLY_TYPE_ONE = "无VQD系统权限。错误编码:1";
	public static final String REPLY_TYPE_TWO = "发送给VQD系统的数据有误。错误编码:2";
	public static final String REPLY_TYPE_THREE = "用户不在线(VQD)。错误编码:3";
	public static final String REPLY_TYPE_FOUR = "用户已存在(VQD)。错误编码:4";
	public static final String REPLY_TYPE_FIVE = "超过最大用户数(VQD)。错误编码:5";
	public static final String REPLY_TYPE_SIX = "超过最大任务数(VQD)。错误编码:6";
	public static final String REPLY_ERROR_TYPE = "VQD系统返回编码错误：";
	public static final String ANALYSER_IS_NOT_EXIST = "未找到相应的VQD分析仪";
	public static final String OUTOF_REMAINABILITY = "计划监测点数超过VQD剩余能力集";
	public static final String PLAN_HAS_EXISTS = "计划名称已被使用";
	public static final String SAVECHECKITEMS_ERROR = "保存检测项失败";
	public static final String EMPTY_STARTTIME = "存在开始时间为空";
	public static final String EMPTY_ENDTIME = "存在结束时间为空";
	public static final String STARTTIME_EQUALS_ENDTIME = "存在开始时间等于结束时间";
	public static final String STARTTIME_AFTER_ENDTIME = "存在开始时间大于结束时间";
	public static final String TIME_COINCIDE = "时间存在重合";
	public static final String ACTION_FAILED = "操作失败";
	public static final String SAVE_SUCCESSED = "保存成功";
	public static final String ALARM_TYPE_WARN = "5";
	public static final String ALARM_TYPE_ERROR = "1";
	public static final String ANALYSER_NAME_EXIST = "分析仪名称已被使用";
	public static final String ANALYSER_HAS_EXIST = "该分析仪已经存在,\n请检查IP设置";
	public static final String ANALYSER_NOT_FOUND = "分析仪未找到,\n请重新打开设备管理页面";

	public static final int STATE_NORMAL = 0;
	public static final int STATE_ERROR = 1;

	public static final String SINGLEDATASERVICE = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/dataServers/ID";
	public static final String DATASERVICES = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/dataServers/";
	public static final String DATASERVICESFORDEL = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/dataServers";
	public static final String CHANNELS = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/channels";
	public static final String ADDPLAN = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/plans/ID";
	public static final String PLAN = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/plans/";
	public static final String PLANFORDEL = "/PSIA/Custom/SelfExt/AS/VQDDiagnose/plans";

}
