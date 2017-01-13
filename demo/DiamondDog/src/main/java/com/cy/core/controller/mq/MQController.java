package com.cy.core.controller.mq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.core.mq.producer.queue.QueueSender;
/**
 * 
 * @author chenyong6
 *
 */
@Controller
@RequestMapping("/mq")
public class MQController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	@Autowired
	private QueueSender queueSender;
	@Autowired
	private com.cy.core.mq.producer.topic.TopicSender topicSender;
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}
	/**
	 * 首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toIndexPage() {
		return "index";
	}
	@RequestMapping(value = "/queueSender", method = RequestMethod.GET)
	public @ResponseBody void queueSender(Model model) {
		queueSender.send("test.queue1", "queueSender_helloworld");
	}
	@RequestMapping(value = "/topicSender", method = RequestMethod.GET)
	public @ResponseBody void topicSender(Model model) {
		topicSender.send("test.topic", "topicSender_helloworld");
	}
	

}
