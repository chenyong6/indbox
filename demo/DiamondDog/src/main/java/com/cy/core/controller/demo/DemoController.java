package com.cy.core.controller.demo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author chenyong6
 *
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}
	@ModelAttribute("test")
	public String setString(String param) {
		return "setString";
	}
	@InitBinder
	private void initBinder(WebDataBinder binder){
		
	}
//	@ModelAttribute("date")
//	public Date setDate(Date date) {
//		return date;
//	}
	/**
	 * 首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toIndexPage() {
		return "index";
	}
	@RequestMapping(value = "/handlebarsDemo", method = RequestMethod.GET)
	public String handlebars_demo(@RequestParam("alarmIds[]") List<Integer> alarmIds) {
		return "handlebars_demo";
	}
	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public String handlebars_demo_model(Model model) {
		return "handlebars_demo";
	}
	

}
