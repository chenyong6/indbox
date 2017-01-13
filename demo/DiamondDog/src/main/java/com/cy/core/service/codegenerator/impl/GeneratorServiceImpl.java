package com.cy.core.service.codegenerator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.core.constant.DataBaseConstant;
import com.cy.core.domain.codegenerator.BeanTemplate;
import com.cy.core.domain.codegenerator.GeneratorBO;
import com.cy.core.domain.codegenerator.Table;
import com.cy.core.service.codegenerator.DbMetaService;
import com.cy.core.service.codegenerator.GeneratorService;
@Service("generatorService")
public class GeneratorServiceImpl implements GeneratorService {
	DbMetaService dbMetaService = new DbMetaServiceImpl();

	public void generateCode(GeneratorBO generatorBO) {
		 List<BeanTemplate> bts = DbMetaServiceImpl.transferTable2BeanTemplate(DataBaseConstant.POSTGRESQL,fillDataInfos(generatorBO.getTableName(),"public"));
		 System.err.println(bts);
	}

	public List<Table> queryAllDataBaseTables(String dbName) {
		return dbMetaService.selecAllTableInfosByDbName(dbName);
	}

	
	
	
	public List<Table> fillDataInfos(List<String> tbNames, String dbName) {
		List<Table> tables = filterTableByNames(tbNames, dbName);
		for (Table table : tables) {
			table = dbMetaService.selecTableInfo(table);
		}
		return tables;
	}

	private List<Table> filterTableByNames(List<String> tbNames, String dbName) {
		List<Table> tables = dbMetaService.selecAllTableInfosByDbName(dbName);

		List<Table> targetTables = new ArrayList<Table>();

		for (Table table : tables) {
			if (tbNames.contains(table.getTableName())) {
				targetTables.add(table);
			}

		}
		return targetTables;
	}

}
