package com.hikvision.vqd.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;
import org.springframework.util.Assert;

import com.hikvision.vqd.XML2Object;
import com.hikvision.vqd.exception.VqdConnectException;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-1 下午01:54:14
 * @describe：vqd连接时的socket
 */
public class VqdSocketClient {

	/**
	 * 连接的vqdIp
	 */
	private static String ip;

	/**
	 * 连接的vqd 端口
	 */
	private static int port;

//	private static TelnetClient telnet = new TelnetClient();
//
//	static {
//		// 设置2秒超时
//		telnet.setConnectTimeout(2 * 1000);
//	}

	/**
	 * Description:设置连接的ip和端口
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-1 下午01:58:57
	 * @param ip
	 * @param port
	 * 
	 */
	public static void testConnected(String ip, int port)
			throws VqdConnectException {
		Assert.hasLength(ip, "the ip can not be null when testConnect");
		Assert.notNull(port, "the port can not be null when testConnect");
		VqdSocketClient.ip = ip;
		VqdSocketClient.port = port;
		// 判断网络是否连通
//		try {
//			//telnet.connect(ip, port);
//		} catch (SocketException e) {
//			throw new VqdConnectException(VqdConstants.NOT_CONNET);
//		} catch (IOException e) {
//			throw new VqdConnectException(VqdConstants.NOT_CONNET);
//		}
	}

	/**
	 * Description:发送消息
	 * 
	 * @author: sunxiaobo
	 * @Date: 2013-3-1 下午02:03:49
	 * @param requestXML
	 * @param timeOut
	 * @return
	 * 
	 */
	public static Object sendMessage(String requestXML, Object response,
			int timeOut) {
		Object result = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			socket = new Socket(ip, port);
			socket.setSoTimeout(timeOut * 1000);
			in = socket.getInputStream();
			out = socket.getOutputStream();
			// 发送数据
			write(requestXML, out);
			// 接收数据
			BufferedReader br = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			StringBuffer resultBuffer = new StringBuffer();
			String xml;
			// 是否添加到resultBuffer中
			boolean flag = false;
			while ((xml = br.readLine()) != null) {
				if (xml.indexOf("<ReplyInfo") != -1
						|| xml.indexOf("<StatusInfo") != -1
						|| xml.indexOf("<RecordInfo") != -1) {
					flag = true;
				}
				if (flag) {
					resultBuffer.append(xml);
				}
			}
			if (resultBuffer.length() == 0) {
				return result;
			}
			result = XML2Object.parseObject(resultBuffer.toString(), response);
			flag = false;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
			try {
				if (socket != null) {
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	/**
	 * 向out中输出字符串str
	 * 
	 * @param str
	 * @param out
	 * @return
	 */
	private static boolean write(String str, OutputStream out) {
		boolean result = true;
		try {
			byte[] data = str.getBytes("UTF-8");
			int len = data.length;
			out.write(data, 0, len);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		VqdSocketClient.ip = ip;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		VqdSocketClient.port = port;
	}

}
