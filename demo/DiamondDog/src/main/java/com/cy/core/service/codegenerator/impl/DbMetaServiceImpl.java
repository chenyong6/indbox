package com.cy.core.service.codegenerator.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.cy.core.constant.DataBaseConstant;
import com.cy.core.constant.SqlTypeMap;
import com.cy.core.domain.codegenerator.BeanTemplate;
import com.cy.core.domain.codegenerator.Column;
import com.cy.core.domain.codegenerator.Property;
import com.cy.core.domain.codegenerator.Table;
import com.cy.core.service.codegenerator.DbMetaService;
import com.cy.core.utils.DbUtil;

@Service("dbMetaServiceImpl")
public class DbMetaServiceImpl implements DbMetaService {

	public DbMetaServiceImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.f1.core.service.impl.DbMetaService#selecAllTableInfosByDbName(java.lang.String)
	 */
	@Override
	public List<Table> selecAllTableInfosByDbName(String dbName) {

		List<Table> tables = new ArrayList<Table>();
		try {
			// 类型()
			//String[] types = { "TABLE", "VIEW" };
			String[] types = { "TABLE" };
			// ResultSet DatabaseMetaData.getTables(String catalog,String
			// schema,String tableName,String []type)
			// 此方法可返回结果集合ResultSet ，结果集中有5列， 超出会报越界异常
			// 功能描述：得到指定参数的表信息
			// 参数说明：
			// 参数:catalog:目录名称，一般都为空.
			// 参数：schema:数据库名，对于oracle来说就用户名
			// 参数：tablename:表名称
			// 参数：type :表的类型(TABLE | VIEW)
			ResultSet rs = DbUtil.getMetaData().getTables(null, dbName, "%", types);
			while (rs.next()) {
				Table table = new Table();
				tables.add(table);
				table.setTableCat(rs.getString("table_cat"));
				table.setTableName(rs.getString("table_name"));
				table.setTableSchem(rs.getString("table_schem"));
				table.setTableType(rs.getString("table_type"));
				table.setRemarks(rs.getString("remarks"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.f1.core.service.impl.DbMetaService#selecTableInfo(org.f1.core.domain.Table)
	 */
	@Override
	public Table selecTableInfo(Table table) {
		List<Column> columns = new ArrayList<Column>();
		try {
			table.setColumns(columns);
			ResultSet rs = DbUtil.getMetaData().getColumns(table.getTableCat(), table.getTableSchem(), table.getTableName(), "%");
			while (rs.next()) {
				Column column = new Column();
				column.setColumnName(rs.getString("COLUMN_NAME"));
				column.setRemarks(rs.getString("REMARKS"));
				column.setTypeName(rs.getString("TYPE_NAME"));
				columns.add(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public void CodeGenerate(List<Table> tables,DataBaseConstant dataBaseConstant){
		/**
		 * 1.包名
		 * 2.模板路径名
		 * --〉获取数据源
		 * --》根据 路径 数据源 生成文件
		 * --》打包
		 */
		
	}

	public static List<BeanTemplate> transferTable2BeanTemplate(DataBaseConstant dataBaseConstant, List<Table> tables) {

		Map<String, SqlTypeMap> typeMap = getTypeMapByDbTpe(dataBaseConstant);

		List<BeanTemplate> beanTemplates = new ArrayList<BeanTemplate>();

		for (Table table : tables) {
			BeanTemplate beanTemplate = new BeanTemplate();
			List<Property> properties = new ArrayList<Property>();
			Set<String> importPaths = new HashSet<String>();

			beanTemplate.setImportPath(importPaths);
			beanTemplate.setProperties(properties);
			beanTemplates.add(beanTemplate);

			beanTemplate.setClassName(table2Class(table.getTableName()));
			beanTemplate.setLowerClassName(column2prop(table.getTableName()));

			for (Column column : table.getColumns()) {
				Property property = new Property();
				SqlTypeMap sqlTypeMap = typeMap.get(column.getTypeName().toUpperCase());
				
				property.setName(column2prop(column.getColumnName()));
				property.setComment(column.getRemarks());
				property.setType(sqlTypeMap.getJavaType());
				
				if (StringUtils.isNotBlank(sqlTypeMap.getJavaImport())) {
					importPaths.add(sqlTypeMap.getJavaImport());
				}
			}

		}

		return beanTemplates;
	}
	
	private static Map<String, SqlTypeMap> getTypeMapByDbTpe(DataBaseConstant dataBaseConstant) {
		Map<String, SqlTypeMap> typeMap = null;
		switch (dataBaseConstant) {
		case ORACLE:
			typeMap = SqlTypeMap.OracleTypeMap;
			break;
		case MYSQL:
			typeMap = SqlTypeMap.MySqlTypeMap;
			break;
		case POSTGRESQL:
			typeMap = SqlTypeMap.PostGreSqlTypeMap;
			break;
		default:
			typeMap = new HashMap<String, SqlTypeMap>();
			break;
		}
		return typeMap;
	}

	/**
	 * 首字母转小写
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 首字母转大写
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String column2prop(String columnName) {
		if (columnName != null) {
			String[] strs = columnName.split("_");
			StringBuilder sb = new StringBuilder();
			for (String str : strs) {
				sb.append(toUpperCaseFirstOne(str));
			}
			return toLowerCaseFirstOne(sb.toString());
		} else {
			return null;
		}
	}

	public static String table2Class(String columnName) {
		if (columnName != null) {
			String[] strs = columnName.split("_");
			StringBuilder sb = new StringBuilder();
			for (String str : strs) {
				sb.append(toUpperCaseFirstOne(str));
			}
			return toUpperCaseFirstOne(sb.toString());
		} else {
			return null;
		}
	}
}
