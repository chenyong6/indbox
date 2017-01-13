package com.cy.core.service.codegenerator.impl;

import java.util.List;

import com.cy.core.domain.codegenerator.Table;

public interface DbMetaService {

	List<Table> selecAllTableInfosByDbName(String dbName);

	Table selecTableInfo(Table table);

}