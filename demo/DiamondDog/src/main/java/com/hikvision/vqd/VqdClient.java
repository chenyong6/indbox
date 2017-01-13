package com.hikvision.vqd;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.hikvision.vqd.client.VqdRequestXml;
import com.hikvision.vqd.client.VqdSocketClient;
import com.hikvision.vqd.entity.Channel;
import com.hikvision.vqd.entity.ReplyInfo;
import com.hikvision.vqd.entity.VqdPlan;
import com.hikvision.vqd.exception.VqdConnectException;

/**
 * vqd客户端调用，用于和VQD交互
 * 
 * @author sunxiaobo
 * 
 */
public class VqdClient {

	/**
	 * 默认端口
	 */
	private static final int DEFAULTPORT = 8000;

	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(VqdClient.class);

	private static final int TIMEOUT = 60;

	private static final int SIZEPERSEND = 200;
	
	
	public static void main(String[] args) {
		//XStream 
	}
	/**
	 * 添加数据服务器
	 * 
	 * @param targetIp
	 * @param id
	 * @throws VqdConnectException
	 */
	public static ReplyInfo addDataServer(String targetIp, String id)
			throws VqdConnectException {
		return addDataServer(targetIp, DEFAULTPORT, id);
	}

	/**
	 * 添加数据服务器
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param id
	 * @throws VqdConnectException
	 */
	public static ReplyInfo addDataServer(String targetIp, int targetPort,
			String id) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when addDataServer");
		Assert.hasLength(id, "the id can not be null when addDataServer");
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = null;
		try {
			requestXML = VqdRequestXml.creatAddDataServerRequestXML(
					VqdConstants.DATASERVICES, id, getLocalIp(), targetIp,
					targetPort);
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage(), e.getCause());
			e.printStackTrace();
			throw new VqdConnectException(e.getMessage());
		}
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 删除数据服务器
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param id
	 * @throws VqdConnectException
	 */
	public static ReplyInfo deleteDataServer(String targetIp, int targetPort,
			String id) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when deleteDataServer");
		if (StringUtils.isBlank(id)) {
			LOGGER.error("the dataServerId can not be null when deleteDataServer");
			return null;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.creatdelDataServerRequestXML(
				VqdConstants.DATASERVICESFORDEL, id, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);

	}

	/**
	 * 删除数据服务器
	 * 
	 * @param targetIp
	 * @param id
	 * @throws VqdConnectException
	 */
	public static ReplyInfo deleteDataServer(String targetIp, String id)
			throws VqdConnectException {
		return deleteDataServer(targetIp, DEFAULTPORT, id);

	}

	/**
	 * 发送监控点明细
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param channels
	 * @return
	 */
	public static void addChannelDetail(String targetIp, int targetPort,
			List<Channel> channels) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when addChannelDetail");
		if (CollectionUtils.isEmpty(channels)) {
			LOGGER.error("the channelList can not be null when addChannelDetail");
			return;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		int size = (channels.size() % SIZEPERSEND == 0) ? (channels.size() / SIZEPERSEND)
				: (channels.size() / SIZEPERSEND) + 1;
		for (int i = 0; i < size; i++) {
			List<Channel> sendList = new ArrayList<Channel>();
			int largeSize = (i + 1 == size) ? (channels.size() % SIZEPERSEND == 0 ? SIZEPERSEND
					: channels.size() % SIZEPERSEND)
					: SIZEPERSEND;
			for (int j = 0; j < largeSize; j++) {
				sendList.add(channels.get(i * SIZEPERSEND + j));
			}
			String requestXML = VqdRequestXml.createAddChannelRequestXML(
					VqdConstants.CHANNELS, sendList, targetIp, targetPort);
			VqdSocketClient.sendMessage(requestXML, new ReplyInfo(), TIMEOUT);
		}
	}

	/**
	 * 发送监控点明细
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param channels
	 * @return
	 */
	public static void addChannelDetail(String targetIp, List<Channel> channels)
			throws VqdConnectException {
		addChannelDetail(targetIp, DEFAULTPORT, channels);
	}

	/**
	 * 删除指定监控点明细
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param id
	 * @return
	 */
	public static ReplyInfo deleteChannelDetail(String targetIp,
			int targetPort, String id) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when deleteChannelDetail");
		if (StringUtils.isBlank(id)) {
			LOGGER.error("the channelId can not be null when deleteChannelDetail");
			return null;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.createDelChannelRequestXML(
				VqdConstants.CHANNELS, id, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 删除指定监控点明细
	 * 
	 * @param targetIp
	 * @param id
	 * @return
	 */
	public static ReplyInfo deleteChannelDetail(String targetIp, String id)
			throws VqdConnectException {
		return deleteChannelDetail(targetIp, DEFAULTPORT, id);
	}

	/**
	 * 删除所有监控点明细
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @return
	 */
	public static ReplyInfo deleteAllChannelDetail(String targetIp,
			int targetPort) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when deleteAllChannelDetail");
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.createDelAllChannelRequestXML(
				VqdConstants.CHANNELS, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 删除所有监控点明细
	 * 
	 * @param targetIp
	 * @return
	 */
	public static ReplyInfo deleteAllChannelDetail(String targetIp)
			throws VqdConnectException {
		return deleteAllChannelDetail(targetIp, DEFAULTPORT);
	}

	/**
	 * 发送计划明细
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param vqdPlan
	 * @param channels
	 * @return
	 * @throws VqdConnectException
	 */
	public static ReplyInfo addPlanDetail(String targetIp, int targetPort,
			VqdPlan vqdPlan, List<Channel> channels) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when addPlanDetail");
		Assert.notNull(vqdPlan,
				"the vqdPlan can not be null when addPlanDetail");
		if (CollectionUtils.isEmpty(channels)) {
			LOGGER.error("the channelList can not be null when addPlanDetail");
			return null;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.creatAddPlanRequestXML(
				VqdConstants.PLAN, vqdPlan, channels, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 发送计划明细
	 * 
	 * @param targetIp
	 * @param vqdPlan
	 * @param channels
	 * @return
	 * @throws VqdConnectException
	 */
	public static ReplyInfo addPlanDetail(String targetIp, VqdPlan vqdPlan,
			List<Channel> channels) throws VqdConnectException {
		return addPlanDetail(targetIp, DEFAULTPORT, vqdPlan, channels);
	}

	/**
	 * 删除计划
	 * 
	 * @param targetIp
	 * @param id
	 * @return
	 */
	public static ReplyInfo deletePlanDetail(String targetIp, int targetPort,
			String planId) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when deletePlanDetail");
		if (StringUtils.isBlank(planId)) {
			LOGGER.error("the planId can not be null when deletePlanDetail");
			return null;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.creatDelPlanRequestXML(
				VqdConstants.PLANFORDEL, planId, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 删除计划
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param planId
	 * @return
	 */
	public static ReplyInfo deletePlanDetail(String targetIp, String planId)
			throws VqdConnectException {
		return deletePlanDetail(targetIp, DEFAULTPORT, planId);
	}

	/**
	 * 对计划增加监控点
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param uri
	 * @param planId
	 * @param channels
	 * @return
	 */
	public static ReplyInfo addTaskDetail(String targetIp, int targetPort,
			String planId, List<String> channels) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when addTaskDetail");
		Assert.hasLength(planId,
				"the planId can not be null when addTaskDetail");
		if (CollectionUtils.isEmpty(channels)) {
			LOGGER.error("the channelList can not be null when addTaskDetail");
			return null;
		}
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.creatAddTaskRequestXML(
				VqdConstants.ADDPLAN, planId, channels, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 对计划增加监控点
	 * 
	 * @param targetIp
	 * @param uri
	 * @param planId
	 * @param channels
	 * @return
	 */
	public static ReplyInfo addTaskDetail(String targetIp, String planId,
			List<String> channels) throws VqdConnectException {
		return addTaskDetail(targetIp, DEFAULTPORT, planId, channels);
	}

	/**
	 * 删除计划的指定监控点
	 * 
	 * @param targetIp
	 * @param targetPort
	 * @param uri
	 * @param planId
	 * @param channels
	 * @return
	 */
	public static ReplyInfo deleteTaskDetail(String targetIp, int targetPort,
			String planId, String taskId) throws VqdConnectException {
		Assert.hasLength(targetIp,
				"the targetIp can not be null when deleteTaskDetail");
		Assert.hasLength(planId,
				"the planId can not be null when deleteTaskDetail");
		Assert.hasLength(taskId,
				"the taskId can not be null when deleteTaskDetail");
		VqdSocketClient.testConnected(targetIp, targetPort);
		String requestXML = VqdRequestXml.creatdelTaskRequestXML(
				VqdConstants.PLAN, planId, taskId, targetIp, targetPort);
		return (ReplyInfo) VqdSocketClient.sendMessage(requestXML,
				new ReplyInfo(), TIMEOUT);
	}

	/**
	 * 删除计划的指定监控点
	 * 
	 * @param targetIp
	 * @param uri
	 * @param planId
	 * @param taskId
	 * @return
	 */
	public static ReplyInfo deleteTaskDetail(String targetIp, String planId,
			String taskId) throws VqdConnectException {
		return deleteTaskDetail(targetIp, DEFAULTPORT, planId, taskId);
	}

	/**
	 * 获取本地IP
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	private static String getLocalIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}
}
