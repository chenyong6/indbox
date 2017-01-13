package com.cy.core.domain.codegenerator;

import java.util.List;


public class GeneratorBO {
	/**
	 * 项目路径
	 */
	private String packagePath;

	/**
	 * 密码
	 */
	private List<String> tables;

	
	public List<String> getTableName() {
		return tables;
	}

	public void setTableName(List<String> tables) {
		this.tables = tables;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}
}
