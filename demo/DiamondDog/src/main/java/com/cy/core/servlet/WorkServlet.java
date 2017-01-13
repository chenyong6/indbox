package com.cy.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.err.println("------------------------------");
				
				resp.setContentType("text/plain;charset=UTF-8");
				resp.setHeader("Cache-Control", "private");
				resp.setHeader("Pragma", "no-cache");
				final PrintWriter writer = resp.getWriter();
				
				writer.print("老板正在检查当前需要做的工作");
				writer.flush();
				
				List<String> jobs = new ArrayList<String>();
				
				for(int i=0;i<10;i++){
					jobs.add("Job:"+i);
				}
				//使用req.startAsync开启异步处理
				final AsyncContext ac = req.startAsync();
				//不阻塞当前线程
				doWork(ac,jobs);
				writer.println("老板布置完工作，走人。");
				writer.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}

	private void doWork(final AsyncContext ac,final List<String> jobs){
		ac.setTimeout(1*60*60*1000L);
		ac.start(new Runnable() {
			
			public void run() {
				try {
					final PrintWriter writer = ac.getResponse().getWriter();
					TimeUnit.SECONDS.sleep(2L);
					for(String job:jobs){
						writer.println(job+" 处理完成。。");
						System.err.println(job+" 处理中。。");
						writer.flush();
						TimeUnit.SECONDS.sleep(5L);
					}
					//发出处理完通知
					ac.complete();
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
