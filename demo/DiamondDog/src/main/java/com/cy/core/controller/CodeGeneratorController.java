package com.cy.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.core.constant.DataBaseConstant;
import com.cy.core.constant.SessionConstant;
import com.cy.core.domain.codegenerator.DataBaseInfo;
import com.cy.core.domain.codegenerator.Table;
import com.cy.core.domain.result.ResponseResult;
import com.cy.core.service.codegenerator.GeneratorService;
import com.cy.core.utils.DbUtil;

@Controller
@RequestMapping("/codegerator")
public class CodeGeneratorController extends BaseController {
	@Resource(name = "generatorService")
	private GeneratorService generatorService;

	/**
	 * 首页
	 */
	public String toIndexPage() {

		return "index";
	}

	/**
	 * 列表展示页面
	 */
	public String toTablesListPage() {

		return "tableList";
	}

	/**
	 * 初始化数据库信息
	 */
	@RequestMapping(value = "/initDataBaseInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult initDataBaseInfo(DataBaseInfo dataBaseInfo) {
		ResponseResult respResult = new ResponseResult();
		String ip = dataBaseInfo.getIp();
		String port = dataBaseInfo.getPort();
		String dbName = dataBaseInfo.getDbName();
		
		switch (dataBaseInfo.getDbType()) {
		
			case "oracle":
				dataBaseInfo.setUrl(DataBaseConstant.ORACLE.getDefaultDbUrl(ip, port, dbName));
				dataBaseInfo.setDriver(DataBaseConstant.ORACLE.getDriver());
				dataBaseInfo.setDbSchem("");
				break;
			case "mysql":
				dataBaseInfo.setUrl(DataBaseConstant.MYSQL.getDefaultDbUrl(ip, port, dbName));
				dataBaseInfo.setDriver(DataBaseConstant.MYSQL.getDriver());
				dataBaseInfo.setDbSchem(dbName);
				break;
			case "postgresql":
				dataBaseInfo.setUrl(DataBaseConstant.POSTGRESQL.getDefaultDbUrl(ip, port, dbName));
				dataBaseInfo.setDriver(DataBaseConstant.POSTGRESQL.getDriver());
				dataBaseInfo.setDbSchem("public");
				break;
			default:
				return respResult;
		}

		session.setAttribute(SessionConstant.DATABASE_INFO_KEY, dataBaseInfo);
	
		respResult.setSusseed(true).setData(dataBaseInfo);

		return respResult;
	}

	@RequestMapping(value = "/queryAllDataBaseTables", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult queryAllDataBaseTables() {
		ResponseResult respResult = new ResponseResult();
		DataBaseInfo dataBaseInfo = (DataBaseInfo) session.getAttribute(SessionConstant.DATABASE_INFO_KEY);

		DbUtil.initThreadDB(dataBaseInfo);

		List<Table> tables = generatorService.queryAllDataBaseTables(dataBaseInfo.getDbSchem());
		
		respResult.setData(tables);
		
		return respResult;
	}

	/**
	 * --<
	 */
	public void generatorCode(List<String> tables) {
		//generatorService.generateCode(generatorBO);
	}

}
