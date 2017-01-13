/**
 * 
 */
package com.hikvision.vqd.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hikvision.vqd.entity.ChanResult;

/**
 * Copyright: Copyright (c) 2012-2014 Company:
 * Hikvision(http://www.hikvision.com)
 * 
 * @author：sunxiaobo
 * @Date: 2013-3-12 下午03:13:17
 * @describe：VQD诊断结果处理线程
 */
public class ChanResultProcess implements
		Runnable {

	private Socket socket;

	private static final Logger LOG = LoggerFactory.getLogger(ChanResultProcess.class);
//	private IModuleRetrieval moduleRetrieval;
	
//	private ICollectDataService collectDataService = NmsServiceLocator.findService("collectDataService",ICollectDataService.class);
	
	public ChanResultProcess(Socket socket) {
		this.socket = socket;
		//this.moduleRetrieval = moduleRetrieval;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			StringBuffer resultBuffer = new StringBuffer();
			String xml;
			// 是否添加到resultBuffer中
			boolean flag = false;
			while ((xml = in.readLine()) != null) {
				if (xml.indexOf("<ChanResult") != -1) {
					flag = true;
				}
				if (flag) {
					resultBuffer.append(xml);
				}
			}
			LOG.debug("from vqd results:"+resultBuffer.toString());
			ChanResult result = (ChanResult) com.hikvision.vqd.XML2Object
					.parseObject(resultBuffer.toString(), new ChanResult());
			LOG.debug("VQD反馈监控点"+result.getId()+"信息成功");
			proceessSignalFailed(result);
			try {
				insertResultToDB(result);
			} catch (Exception e) {
				LOG.error(e.getMessage(),e.getCause());
				e.printStackTrace();
			}
			flag = false;
		} catch (IOException ex) {
			LOG.error("读取VQD诊断信息时发生IO错误");
		} finally {
			try {
				if(in != null){
				in.close();
				}
			} catch (Exception e) {
				LOG.error("关闭与VQD系统连接的输入流时出错");
			}
			try {
				if(out != null){
				out.close();
				}
			} catch (Exception e) {
				LOG.error("关闭与VQD系统连接的输出流时出错");
			}
			try {
				if(socket!= null){
				socket.close();
				}
			} catch (Exception e) {
				LOG.error("关闭与VQD系统连接的socket连接时出错");
			}
		}
	}

	private void insertResultToDB(ChanResult result) throws Exception {
		System.err.println("insert to db");
	}

	/**
	 * 如果图像丢失，则把其他的检测项目都设置为未检测 Description:
	 * 
	 * @author: jiangyue3
	 * @Date: 2014年11月19日 下午8:39:13
	 * @param chanResult
	 * 
	 */
	private void proceessSignalFailed(ChanResult chanResult) {

	}
	
	/**
	 * 根据vqd诊断结果返回级联点位在线状态
	 * @param vqdState
	 * @return
	 */
	private String getCasCasdCameraOnlineStateByVqdState(String vqdState){
		String result = null;
		return result;
	}

}
