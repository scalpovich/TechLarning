package com.mastercard.pts.integrated.issuing.utils;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateImpl {

	DataSource dataSource = new BasicDataSource();;
	JdbcTemplate jdbcTemplate = null;

	/**
	 * 
	 * @param driverClassName
	 * @param url
	 * @param username
	 * @param password
	 */
	public JDBCTemplateImpl(String driverClassName, String url,
			String username, String password) {
		createConnection(driverClassName, url, username, password);
	}

	/**
	 * 
	 * @param driverClassName
	 * @param url
	 * @param username
	 * @param password
	 */
	private void createConnection(String driverClassName, String url,
			String username, String password) {
		// Utils.logged("Initilizing jdbcTemplate for driverClassName
		// "+driverClassName);
		((BasicDataSource) dataSource).setDriverClassName(driverClassName);
		((BasicDataSource) dataSource).setUrl(url);

		((BasicDataSource) dataSource).setUsername((username));
		((BasicDataSource) dataSource).setPassword((password));

		jdbcTemplate = new JdbcTemplate(dataSource);
		Utils.logged("jdbcTemplate is Set for driverClassName "
				+ driverClassName, false);
	}

	/**
	 * Run a simple SQL query and return the results in a List of Maps. Each
	 * element in the returned list will represent a row in the query results.
	 * The element in the list will be a Map object with each element in the map
	 * representing a column in the table. The "key" of the Map element will be
	 * the table column name and the "value" of the element will be the table
	 * column value.
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> queryATable(String sql) {
		return jdbcTemplate.queryForList(sql);

	}

	public void execute(String sql) {
		jdbcTemplate.execute(sql);

	}

	/**
	 * Run a simple SQL query and return the results in a List of Maps. Each
	 * element in the returned list will represent a row in the query results.
	 * The element in the list will be a Map object with each element in the map
	 * representing a column in the table. The "key" of the Map element will be
	 * the table column name and the "value" of the element will be the table
	 * column value.
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<Map<String, Object>> queryATable(String sql, Object... params) {
		return jdbcTemplate.queryForList(sql, params);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean verifySingleRecordExists(String tableName,
			String selectColumns, List<String> fields, List<String> columns) {
		if (fields.size() != columns.size())
			AssertTypes.assertTrue("fields and columns size are not same ",
					false);

		String query = "Select " + selectColumns + " From " + tableName
				+ " where ";

		for (int i = 0; i < fields.size(); i++) {

			if (i == fields.size() - 1)
				query += " " + fields.get(i) + " = '" + columns.get(i) + "' ";
			else
				query += " " + fields.get(i) + " = '" + columns.get(i)
						+ "' and ";

		}
		Utils.logged(query);
		List<Map<String, Object>> results = this.queryATable(query);
		Utils.displayMap(results, true);

		return results.size() == 1;
	}

	public List<Map<String, Object>> getRecords(int noOfRecords,
			String tableName, String selectColumns, List<String> fields,
			List<String> columns) {
		if (fields.size() != columns.size())
			AssertTypes.assertTrue("fields and columns size are not same ",
					false);

		String query = "Select " + selectColumns + " From " + tableName
				+ " where ";

		for (int i = 0; i < fields.size(); i++) {

			if (i == fields.size() - 1)
				query += " " + fields.get(i) + " = '" + columns.get(i) + "' ";
			else
				query += " " + fields.get(i) + " = '" + columns.get(i)
						+ "' and ";

		}
		Utils.logged(query + Utils.addLine());
		List<Map<String, Object>> results = this.queryATable(query);
		Utils.displayMap(results, true);

		// if(noOfRecords!=-1 && results.size() != noOfRecords)
		// MDESAssert.assertTrue("record size not expected ",false);

		Utils.logged("Returning " + results.size() + " from Db2 table", false);
		return results;

	}

}
