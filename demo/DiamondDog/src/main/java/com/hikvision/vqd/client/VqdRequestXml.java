/**
 * 
 */
package com.hikvision.vqd.client;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.hikvision.vqd.entity.Channel;
import com.hikvision.vqd.entity.PlanTime;
import com.hikvision.vqd.entity.VqdPlan;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-1 下午02:27:50
 * @describe：对请求参数进行处理的工具类
 */
public class VqdRequestXml {

	private static final int LOCALPORT = 7820;

	private static final Logger LOG = LoggerFactory.getLogger(VqdRequestXml.class);
	
	public static void main(String[] args) {
		String str = creatAddDataServerRequestXML("uri", "id", "localIp", "targetIp", 2181);
		System.err.println(str);
	}
	public static String creatAddDataServerRequestXML2(String uri, String id,
			String localIp, String targetIp, int targetPort) {
		String header = createHeader("PUT", uri, targetIp, targetPort);
		StringBuffer body = new StringBuffer();

		String result = header + body.toString().length() + "\r\n\r\n" + body;
		LOG.info("vqd protocol,addDataServer:" + result);
		return result;
	}
	
	/**
	 * Description:创建添加数据服务器的协议体传输的参数
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-1 下午02:36:55
	 * @param uri
	 * @return
	 * 
	 */
	public static String creatAddDataServerRequestXML(String uri, String id,
			String localIp, String targetIp, int targetPort) {
		String header = createHeader("PUT", uri, targetIp, targetPort);
		StringBuffer body = new StringBuffer();
		body.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		body.append("<DataServer version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
		body.append("<id>");
		body.append(id);
		body.append("</id>\t\n");
		body.append("<ip>");
		body.append(localIp);
		body.append("</ip>\t\n");
		body.append("<port>");
		body.append(LOCALPORT);
		body.append("</port>\t\n");
		body.append("<alarmFlag>");
		body.append(0);
		body.append("</alarmFlag>\t\n");
		body.append("</DataServer>\r\n");

		String result = header + body.toString().length() + "\r\n\r\n" + body;
		LOG.info("vqd protocol,addDataServer:" + result);
		return result;
	}

	/**
	 * Description:创建添加数据服务器的协议体传输的参数
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-4 下午04:42:54
	 * @param uri
	 * @return
	 * 
	 */
	public static String creatdelDataServerRequestXML(String uri, String id,
			String ip, int port) {
		String header = createHeader("DELETE", uri, id, ip, port);
		String result = header + "0\r\n\r\n";
		LOG.info("vqd protocol,deleteDataServer:" + result);
		return result;
	}

	/**
	 * Description:添加通道的请求
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-5 下午01:45:06
	 * @param uri
	 * @param ChannelDTOs
	 * @return
	 * 
	 */
	public static String createAddChannelRequestXML(String uri,
			List<Channel> channels, String ip, int port) {
		String header = createHeader("PUT", uri, ip, port);
		StringBuffer body = new StringBuffer();
		body.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		body.append("<ChannelList version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
		for (Channel channel : channels) {
			body.append("<Channel version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
			body.append("<id>");
			body.append(channel.getId());
			body.append("</id>\t\n");
			body.append("<checkFlag>");
			body.append(1);
			body.append("</checkFlag>\t\n");
			body.append("<ip>");
			body.append(channel.getIp());
			body.append("</ip>\t\n");
			body.append("<port>");
			body.append(channel.getPort());
			body.append("</port>\t\n");
			body.append("<chanIndex>");
			body.append(channel.getChannelNo());
			body.append("</chanIndex>\t\n");
			body.append("<userName>");
			body.append(channel.getUserName());
			body.append("</userName>\t\n");
			body.append("<userPwd>");
			body.append(channel.getPassWord());
			body.append("</userPwd>\t\n");
			body.append("<signalPoint>");
			body.append(channel.getSignal());
			body.append("</signalPoint>\t\n");
			body.append("<blurPoint>");
			body.append(channel.getBlur());
			body.append("</blurPoint>\t\n");
			body.append("<contrastPoint>");
			body.append(channel.getContrast());
			body.append("</contrastPoint>\t\n");
			body.append("<brightPoint>");
			body.append(channel.getBright());
			body.append("</brightPoint>\t\n");
			body.append("<darkPoint>");
			body.append(channel.getDark());
			body.append("</darkPoint>\t\n");
			body.append("<chromaPoint>");
			body.append(channel.getChroma());
			body.append("</chromaPoint>\t\n");
			body.append("<monoPoint>");
			body.append(channel.getMono());
			body.append("</monoPoint>\t\n");
			body.append("<noisePoint>");
			body.append(channel.getNoise());
			body.append("</noisePoint>\t\n");
			body.append("<streakPoint>");
			body.append(channel.getStreak());
			body.append("</streakPoint>\t\n");
			body.append("<freezePoint>");
			body.append(channel.getFreeze());
			body.append("</freezePoint>\t\n");
			body.append("<shakePoint>");
			body.append(channel.getShake());
			body.append("</shakePoint>\t\n");
			body.append("<flashPoint>");
			body.append(channel.getFlash());
			body.append("</flashPoint>\t\n");
			body.append("<scenePoint>");
			body.append(channel.getScene());
			body.append("</scenePoint>\t\n");
			body.append("<coverPoint>");
			body.append(channel.getCover());
			body.append("</coverPoint>\t\n");
			body.append("<ptzPoint>");
			body.append(channel.getPtz());
			body.append("</ptzPoint>\t\n");
			body.append("<streamType>");
			body.append(channel.getStreamType());
			body.append("</streamType>\t\n");
			body.append("<protocol>");
			body.append(channel.getProtocol());
			body.append("</protocol>\t\n");
			body.append("<devType>");
			body.append(channel.getDevType());
			body.append("</devType>\t\n");
			body.append("<devBrand>");
			body.append(channel.getDevBrand());
			body.append("</devBrand>\t\n");
			body.append("<streamServerPath>");
			body.append(channel.getStreamServerPath());
			body.append("</streamServerPath>\t\n");
			body.append("</Channel>\r\n");
		}
		body.append("</ChannelList>\r\n");
		String result = header + body.toString().length() + "\r\n\r\n" + body;
		LOG.info("vqd protocol,addChannel:" + result);
		return result;
	}

	/**
	 * Description:删除通道的请求
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-5 下午01:44:44
	 * @param uri
	 * @param ChannelDTOs
	 * @return
	 * 
	 */
	public static String createDelChannelRequestXML(String uri, String id,
			String ip, int port) {
		String header = createHeader("DELETE", uri, id, ip, port);
		String result = header + "0\r\n\r\n";
		LOG.info("vqd protocol,deleteChannel:" + result);
		return result;
	}

	public static String createDelAllChannelRequestXML(String uri, String ip,
			int port) {
		String header = createHeader("DELETE", uri, ip, port);
		String result = header + "0\r\n\r\n";
		LOG.info("vqd protocol,deleteAllChannel:" + result);
		return result;
	}

	/**
	 * Description:新增计划的psia协议
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-6 上午10:38:29
	 * @param addplan
	 * @param vqdPlan
	 * 
	 * VQD里面1-6分别代表周一到周6，0代表周日
	 * 运维前台组件中传递的参数1-7分表代表周一到周日
	 * 
	 */
	public static String creatAddPlanRequestXML(String uri, VqdPlan vqdPlan,
			List<Channel> channels, String ip, int port) {
		String header = createHeader("PUT", uri, ip, port);
		StringBuffer body = new StringBuffer();
		body.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		body.append("<PlanInfo version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
		body.append("<id>");
		body.append(vqdPlan.getId());
		body.append("</id>\t\n");
		body.append("<checkFlag>1</checkFlag>\t\n");
		int period = -2;
		// 一次计划
		if (Integer.parseInt(vqdPlan.getPlanType()) == 0) {
			period = -1;
		} else if (Integer.parseInt(vqdPlan.getPlanType()) == 1) {
			period = 0;
		} else {
			period = 0;
		}
		body.append("<period>");
		body.append(period);
		body.append("</period>\t\n");
		// 星期模式
		if (period == 0) {
			// 计算每个星期的时间
			List<PlanTime> time0 = new ArrayList<PlanTime>();
			List<PlanTime> time1 = new ArrayList<PlanTime>();
			List<PlanTime> time2 = new ArrayList<PlanTime>();
			List<PlanTime> time3 = new ArrayList<PlanTime>();
			List<PlanTime> time4 = new ArrayList<PlanTime>();
			List<PlanTime> time5 = new ArrayList<PlanTime>();
			List<PlanTime> time6 = new ArrayList<PlanTime>();
			for (PlanTime planTime : vqdPlan.getPlanTimes()) {
				if (planTime.getDay() == 1) {
					time1.add(planTime);
				} else if (planTime.getDay() == 2) {
					time2.add(planTime);
				} else if (planTime.getDay() == 3) {
					time3.add(planTime);
				} else if (planTime.getDay() == 4) {
					time4.add(planTime);
				} else if (planTime.getDay() == 5) {
					time5.add(planTime);
				} else if (planTime.getDay() == 6) {
					time6.add(planTime);
				} else if (planTime.getDay() == 7) {
					time0.add(planTime);
				} else {
					time0.add(planTime);
					time1.add(planTime);
					time2.add(planTime);
					time3.add(planTime);
					time4.add(planTime);
					time5.add(planTime);
					time6.add(planTime);
				}
			}
			body.append("<week>\t\n");
			// 周一
			if (time1.size() > 0) {
				body.append("<mon>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time1) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</mon>\t\n");
			}
			// 周二
			if (time2.size() > 0) {
				body.append("<tues>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time2) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</tues>\t\n");
			}
			// 周三
			if (time3.size() > 0) {
				body.append("<wed>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time3) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</wed>\t\n");
			}
			// 周四
			if (time4.size() > 0) {
				body.append("<thur>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time4) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</thur>\t\n");
			}
			// 周五
			if (time5.size() > 0) {
				body.append("<fri>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time5) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</fri>\t\n");
			}
			// 周六
			if (time6.size() > 0) {
				body.append("<sat>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time6) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</sat>\t\n");
			}
			// 周日
			if (time0.size() > 0) {
				body.append("<sun>\t\n");
				body.append("<DiagnoseTime>\t\n");
				for (PlanTime planTime : time0) {
					body.append("<Time>\t\n");
					body.append("<startTime>");
					body.append(planTime.getStartDate());
					body.append("</startTime>\t\n");
					body.append("<endTime>");
					body.append(planTime.getEndDate());
					body.append("</endTime>\t\n");
					body.append("</Time>\t\n");
				}
				body.append("</DiagnoseTime>\t\n");
				body.append("</sun>\t\n");
			}
			body.append("</week>\t\n");
			body.append("<repeat>");
			body.append(vqdPlan.getFeedBackTime());
			body.append("</repeat>\t\n");
		}
		body.append("<CheckItems>\t\n");
		body.append("<signal>");
		body.append(convertChecked(vqdPlan.getCheckType().isSignal()));
		body.append("</signal>\t\n");
		body.append("<blur>");
		body.append(convertChecked(vqdPlan.getCheckType().isBlur()));
		body.append("</blur>\t\n");
		body.append("<contrast>");
		body.append(convertChecked(vqdPlan.getCheckType().isContrast()));
		body.append("</contrast>\t\n");
		body.append("<bright>");
		body.append(convertChecked(vqdPlan.getCheckType().isBright()));
		body.append("</bright>\t\n");
		body.append("<dark>");
		body.append(convertChecked(vqdPlan.getCheckType().isDark()));
		body.append("</dark>\t\n");
		body.append("<chroma>");
		body.append(convertChecked(vqdPlan.getCheckType().isChroma()));
		body.append("</chroma>\t\n");
		body.append("<mono>");
		body.append(convertChecked(vqdPlan.getCheckType().isMono()));
		body.append("</mono>\t\n");
		body.append("<noise>");
		body.append(convertChecked(vqdPlan.getCheckType().isNoise()));
		body.append("</noise>\t\n");
		body.append("<streak>");
		body.append(convertChecked(vqdPlan.getCheckType().isStreak()));
		body.append("</streak>\t\n");
		body.append("<freeze>");
		body.append(convertChecked(vqdPlan.getCheckType().isFreeze()));
		body.append("</freeze>\t\n");
		body.append("<shake>");
		body.append(convertChecked(vqdPlan.getCheckType().isShake()));
		body.append("</shake>\t\n");
		body.append("<flash>");
		body.append(convertChecked(vqdPlan.getCheckType().isFlash()));
		body.append("</flash>\t\n");
		body.append("<scene>");
		body.append(convertChecked(vqdPlan.getCheckType().isScene()));
		body.append("</scene>\t\n");
		body.append("<cover>");
		body.append(convertChecked(vqdPlan.getCheckType().isCover()));
		body.append("</cover>\t\n");
		body.append("<ptz>");
		body.append(convertChecked(vqdPlan.getCheckType().isPtz()));
		body.append("</ptz>\t\n");
		body.append("</CheckItems>\t\n");
		if (!CollectionUtils.isEmpty(channels)) {
			body.append("<TaskList version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
			for (Channel channel : channels) {
				body.append("<taskID>");
				body.append(channel.getId());
				body.append("</taskID>\t\n");
			}
			body.append("</TaskList>\r\n");
		}
		body.append("</PlanInfo>\r\n");
		String result = header + body.toString().length() + "\r\n\r\n" + body;
		LOG.info("vqd protocol,addPlan:" + result);
		return result;
	}

	/**
	 * Description:删除计划的psia协议
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-9 下午01:46:32
	 * @param plan
	 * @param id
	 * @return
	 * 
	 */
	public static String creatDelPlanRequestXML(String uri, String id,
			String ip, int port) {
		String header = createHeader("DELETE", uri, id, ip, port);
		String result = header + "0\r\n\r\n";
		LOG.info("vqd protocol,deletePlan:" + result);
		return result;
	}

	/**
	 * Description:新增计划任务的psia协议
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-9 下午01:59:21
	 * @param plan
	 * @param planId
	 * @param channels
	 * @return
	 * 
	 */
	public static String creatAddTaskRequestXML(String uri, String planId,
			List<String> channels, String ip, int port) {
		String header = createTaskHeader("PUT", uri, planId, ip, port);
		StringBuffer body = new StringBuffer();
		body.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		body.append("<TaskList version=\"1.0\" xmlns=\"urn:selfextension:psiaext-ver10-xsd\">\r\n");
		for (String channel : channels) {
			body.append("<taskID>");
			body.append(channel);
			body.append("</taskID>\t\n");
		}
		body.append("</TaskList>\r\n");
		String result = header + body.toString().length() + "\r\n\r\n" + body;
		LOG.info("vqd protocol,addTask:" + result);
		return result;
	}

	/**
	 * Description:删除任务的psia协议
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-11 上午09:13:22
	 * @param uri
	 * @param planId
	 * @param taskId
	 * @return
	 * 
	 */
	public static String creatdelTaskRequestXML(String uri, String planId,
			String taskId, String ip, int port) {
		String header = createTaskHeader("DELETE", uri, planId, taskId, ip,
				port);
		String result = header + "0\r\n\r\n";
		LOG.info("vqd protocol,deleteTask:" + result);
		return result;
	}

	/**
	 * Description：创建删除任务的协议头
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-11 上午09:15:22
	 * @param string
	 * @param uri
	 * @param id
	 * @param id2
	 * @return
	 * 
	 */
	private static String createTaskHeader(String method, String uri,
			String planId, String taskId, String ip, int port) {
		StringBuffer header = new StringBuffer();
		header.append(method.toUpperCase() + " " + uri + "/" + planId
				+ "/TaskList/" + taskId + " HTTP/1.1\r\n");
		header.append("Host: " + ip + ":" + port + "\r\n");
		header.append("Content-Type: text/xml\r\n");
		header.append("Content-length: ");
		return header.toString();
	}

	/**
	 * Description:根据协议需要转化是否勾选
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-6 上午11:13:05
	 * @param checked
	 * @return
	 * 
	 */
	private static int convertChecked(boolean checked) {
		if (checked) {
			return 1;
		}
		return 0;
	}

	/**
	 * Description:创建方法的协议头
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-1 下午02:37:31
	 * @param uri
	 * @return
	 * 
	 */
	private static String createHeader(String method, String uri, String ip,
			int port) {
		StringBuffer header = new StringBuffer();
		header.append(method.toUpperCase() + " " + uri + " HTTP/1.1\r\n");
		header.append("Host: " + ip + ":" + port + "\r\n");
		header.append("Content-Type: text/xml\r\n");
		header.append("Content-length: ");
		return header.toString();
	}

	/**
	 * Description:新增任务的协议头
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-9 下午02:00:19
	 * @param string
	 * @param uri
	 * @param id
	 * @param channels
	 * @return
	 * 
	 */
	private static String createTaskHeader(String method, String uri,
			String id, String ip, int port) {
		StringBuffer header = new StringBuffer();
		header.append(method.toUpperCase() + " " + uri + "/" + id
				+ "/TaskList HTTP/1.1\r\n");
		header.append("Host: " + ip + ":" + port + "\r\n");
		header.append("Content-Type: text/xml\r\n");
		header.append("Content-length: ");
		return header.toString();
	}

	/**
	 * Description:根据参数组装uri的协议头
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-4 下午04:50:47
	 * @param method
	 * @param uri
	 * @param id
	 * @return
	 * 
	 */
	private static String createHeader(String method, String uri, String id,
			String ip, int port) {
		StringBuffer header = new StringBuffer();
		header.append(method.toUpperCase() + " " + uri + "/" + id
				+ " HTTP/1.1\r\n");
		header.append("Host: " + ip + ":" + port + "\r\n");
		header.append("Content-Type: text/xml\r\n");
		header.append("Content-length: ");
		return header.toString();
	}

}
