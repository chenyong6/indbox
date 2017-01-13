package com.cy.core.controller.jpa;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.core.service.jpa.JpaTest;
/**
 * 
 * @author chenyong6
 *
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	@Resource(name="jpaTest")
	private JpaTest jpaTest;
	
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
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody void insert(Model model) {
		jpaTest.insert();
	}
	@RequestMapping(value = "/insert2", method = RequestMethod.GET)
	public @ResponseBody void insert2(Model model) {
		jpaTest.insert();
	}

}
