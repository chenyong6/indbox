package com.cy.core.domain.codegenerator;

public class Column {
	/**
	 * 字段名称
	 */
	private String columnName;
	/**
	 * 注释
	 */
	private String remarks;
	/**
	 * 类型
	 */
	private String typeName;

	public Column() {
		super();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
