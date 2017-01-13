package com.cy.core.service.codegenerator;

import java.util.List;

import com.cy.core.domain.codegenerator.GeneratorBO;
import com.cy.core.domain.codegenerator.Table;

public interface GeneratorService {

	List<Table> queryAllDataBaseTables(String dbName);

	
	

	void generateCode(GeneratorBO generatorBO);
}
