package com.cy.core.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/rest")
public class RestController {
	@RequestMapping(value = "/{spitterName}/spittles", method = RequestMethod.GET)
	public @ResponseBody String spittlesForSpitter(@PathVariable("spitterName") String spitterName) {
		return "helloworld";
	}
}
