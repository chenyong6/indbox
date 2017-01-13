package com.cy.core.domain.codegenerator;

import java.util.List;

/**
 * 表
 * 
 * @author chenyong6
 */
public class Table {

	private String tableCat;

	private String tableSchem;
	
	private String tableName;

	private String tableType;
	
	private String remarks;
	
	private List<Column> columns;

	public Table() {
		super();
	}

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Table [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName
				+ ", tableType=" + tableType + ", remarks=" + remarks + ", columns=" + columns + "]";
	}
	
}
