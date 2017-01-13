package com.cy.core.domain.codegenerator;

public class Property {
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 注释
	 */
	private String comment;
	/**
	 * 类型
	 */
	private String type;

	public Property(String name, String comment, String type) {
		super();
		this.name = name;
		this.comment = comment;
		this.type = type;
	}

	public Property() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
