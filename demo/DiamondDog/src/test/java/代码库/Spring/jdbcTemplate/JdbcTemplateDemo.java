package 代码库.Spring.jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:application-context-jdbcTemplate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTemplateDemo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testSave() {
		System.err.println(jdbcTemplate);
	}

	/**
	 * 预编译语句及存储过程创建回调、自定义功能回调使用：
	 */
	@Test
	public void testPpreparedStatementSelect() {

		int count = jdbcTemplate.execute(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)

			throws SQLException {

				return conn.prepareStatement("select count(*) from t_user");

			}
		}, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement pstmt)

			throws SQLException, DataAccessException {

				pstmt.execute();

				ResultSet rs = pstmt.getResultSet();

				rs.next();

				return rs.getInt(1);

			}
		});

		Assert.assertEquals(0, count);

	}

	/**
	 * 预编译语句设值回调使用：
	 */
	@Test
	public void testPreparedStatementUpdate() {

		String insertSql = "insert into t_user(u_name) values (?)";

		int count = jdbcTemplate.update(insertSql,
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pstmt)
							throws SQLException {

						pstmt.setObject(1, "u_name4");

					}
				});

		Assert.assertEquals(1, count);

		String deleteSql = "delete from t_user where u_name=?";

		count = jdbcTemplate.update(deleteSql, new Object[] { "u_name4" });

		Assert.assertEquals(1, count);

	}

	/**
	 * 结果集处理回调
	 * RowMapper接口提供mapRow(ResultSet rs, int rowNum)方法将结果集的每一行转换为一个Map，当然可以转换为其他类，如表的对象画形式。
	 */
	@Test
	public void testResultSet1() {

		jdbcTemplate.update("insert into t_user(u_name) values('name5')");

		String listSql = "select * from test";

		List result = jdbcTemplate.query(listSql, new RowMapper<Map>() {

			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {

				Map row = new HashMap();

				row.put(rs.getInt("id"), rs.getString("name"));

				return row;

			}
		});

		Assert.assertEquals(1, result.size());

		jdbcTemplate.update("delete from t_user where name='name5'");

	}
	@Test
	public void testResultSet2() {  

		  jdbcTemplate.update("insert into test(name) values('name5')");  

		  String listSql = "select * from test";  

		  final List result = new ArrayList();  

		  jdbcTemplate.query(listSql, new RowCallbackHandler() {  

		      @Override  

		      public void processRow(ResultSet rs) throws SQLException {  

		          Map row = new HashMap();  

		          row.put(rs.getInt("id"), rs.getString("name"));  

		          result.add(row);  

		  }});  

		  Assert.assertEquals(1, result.size());  

		  jdbcTemplate.update("delete from test where name='name5'");  

		}  
	
}
