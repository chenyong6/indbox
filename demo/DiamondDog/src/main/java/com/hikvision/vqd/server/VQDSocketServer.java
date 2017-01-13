package com.hikvision.vqd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hikvision.vqd.entity.ChanResult;

public class VQDSocketServer extends Thread {

	private int maxConnections = 10;

//	@Resource
//	private IModuleRetrieval moduleRetrieval;
	// 线程池
	private ExecutorService pool = Executors.newFixedThreadPool(maxConnections);
	
	private static final Logger log = LoggerFactory.getLogger(VQDSocketServer.class);


	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(7820);
			while (true) {
				Socket socket = server.accept();
				invoke(socket, new ChanResult());
			}
		} catch (IOException e) {
			log.error("socket客户端启动失败，7820端口已被占用，请检查！",e);
		}
	}

	private void invoke(final Socket socket, final ChanResult chanResult)
			throws IOException {
		pool.execute(new ChanResultProcess(socket));
	}

}