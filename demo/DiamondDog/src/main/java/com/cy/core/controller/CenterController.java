package com.cy.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.core.constant.DataBaseConstant;
import com.cy.core.domain.codegenerator.DataBaseInfo;
import com.cy.core.domain.codegenerator.GeneratorBO;
import com.cy.core.domain.codegenerator.Table;
import com.cy.core.service.TestTbService;
import com.cy.core.service.codegenerator.GeneratorService;
import com.cy.core.utils.DbUtil;
/**
 * 后台管理 测试
 *
 */
@Controller
@RequestMapping("/test")
public class CenterController extends BaseController{
	@Resource(name = "generatorService")
	private GeneratorService generatorService;

	@Resource(name = "testTbService")
	private TestTbService testTbService;
	
	@RequestMapping(value = "/test22", method = RequestMethod.GET)
	public void test() {
		testTbService.selectTestTb();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public List<Table>  test1() {
		DataBaseInfo dataBaseInfo = new DataBaseInfo();
		dataBaseInfo.setDriver(DataBaseConstant.POSTGRESQL.getDriver());
		dataBaseInfo.setUrl("jdbc:postgresql://10.33.27.131:5432/coms_1.2?useUnicode=true&characterEncoding=utf-8");
		dataBaseInfo.setUserName("postgres");
		dataBaseInfo.setPassword("123456");

		DbUtil.initThreadDB(dataBaseInfo);
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("alarm_info");
		tableNames.add("urm_resource_navigation");
		GeneratorBO generatorBO = new GeneratorBO();
		generatorBO.setTableName(tableNames);
		
		return generatorService.queryAllDataBaseTables("public");
	}
	@RequestMapping(value = "/test02", method = RequestMethod.GET)
	public String goIndex(){
		System.err.println(request+" "+response);
		return "index";
	}
	
	@RequestMapping(value = "/test03", method = RequestMethod.GET)
	@ResponseBody
	public List<String> goIndex3(List<String> strs){
		System.err.println(strs);
		return strs;
	}
	@RequestMapping(value = "/test04", method = RequestMethod.GET)
	@ResponseBody
	public String goIndex4(String data){
		System.err.println(data);
		return data+"_test";
	}
}
