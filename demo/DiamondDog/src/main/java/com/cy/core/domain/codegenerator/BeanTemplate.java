package com.cy.core.domain.codegenerator;

import java.util.List;
import java.util.Set;

public class BeanTemplate {
	/**
	 * 包名
	 */
	private String packagePath;
	/**
	 * 引入包名
	 */
	private Set<String> importPath;
	/**
	 * 类名
	 */
	private String className;
	
	private String lowerClassName;
	/**
	 * 属性
	 */
	private List<Property> Properties;

	public BeanTemplate() {
		super();
	}

	public BeanTemplate(String packagePath, String className, List<Property> properties) {
		super();
		this.packagePath = packagePath;
		this.className = className;
		Properties = properties;
	}

	public BeanTemplate(String packagePath, Set<String> importPath, String className, List<Property> properties) {
		super();
		this.packagePath = packagePath;
		this.importPath = importPath;
		this.className = className;
		Properties = properties;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public Set<String> getImportPath() {
		return importPath;
	}

	public void setImportPath(Set<String> importPath) {
		this.importPath = importPath;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Property> getProperties() {
		return Properties;
	}

	public void setProperties(List<Property> properties) {
		Properties = properties;
	}

	public String getLowerClassName() {
		return lowerClassName;
	}

	public void setLowerClassName(String lowerClassName) {
		this.lowerClassName = lowerClassName;
	}
	
}
