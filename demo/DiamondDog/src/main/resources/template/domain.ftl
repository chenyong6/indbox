package ${modelBean.packageUrl}.domain;
<#if modelBean.importUrls??>
	<#list modelBean.importUrls as importUrl>
	import ${importUrl};
	</#list>
</#if>


public class ${modelBean.className} {
	<#list modelBean.properties as property>
	/**
	 * ${property.comment}
	 */
	private ${property.popType} ${property.popName};
	</#list>
	<#list modelBean.properties as property>
	public ${property.popType} get${property.popName?cap_first}() {
		return ${property.popName};
	}
	public void set${property.popName?cap_first} (${property.popType} ${property.popName}) {
		this.${property.popName} = ${property.popName};
	}
	</#list>
}
