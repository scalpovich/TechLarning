package com.mastercard.pts.integrated.issuing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

@Component
public class DBUtility {
	private static final Logger logger = LoggerFactory
			.getLogger(DBUtility.class);
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;
	private String recordColumnValue = null;
	

	@Value("${db.host}")
	private String dbHost;

	@Value("${db.port}")
	private String dbPort;

	@Value("${db.serviceName}")
	private String dbServiceName;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;
	

	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			MiscUtils.propagate(e);
		}
	}
	
	/*
	 * This method returns the value of the columnName in the DB
	 * @param queryString takes the SQL query
	 * @param columnName takes the columnName for which the value has to be fetched
	 */
	public String getSingleRecordColumnValueFromDB(String queryString, String columnName) {
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				if (rs.getString(columnName) == null) {
					recordColumnValue = null;
				} else {
					recordColumnValue = rs.getString(columnName);
					logger.info("value returned from database ", recordColumnValue);
					break;

				}
			}
		} catch (Exception e) {
			MiscUtils.propagate(e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				MiscUtils.propagate(e);
			}
		}
		return recordColumnValue;
	}
	
	/*
	 * This method activates agency through DB
	 */
	public void activateAgencyThroughDB(String queryString) {
		try {
			stmt = getConnection().createStatement();
		      stmt.executeUpdate(queryString);
		      conn.commit();
		} catch (Exception e) {
			MiscUtils.propagate(e);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				MiscUtils.propagate(e);
			}
		}
	}
	
	public void runSQLScript(Resource sqlFile)
	{
			ScriptUtils.executeSqlScript(getConnection(), sqlFile);
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("Exception: {}", e);
				MiscUtils.propagate(e);
			}
	}
	
	/*
	 * This method executes update query
	 */
	public void executeUpdate(String queryString) {
		logger.info("** executing update query ** : {}",queryString);
		try {
			stmt = getConnection().createStatement();
		      stmt.executeUpdate(queryString);
		      conn.commit();
		} catch (Exception e) {
			MiscUtils.propagate(e);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				MiscUtils.propagate(e);
			}
		}
	}
	
	public Connection getConnection()
	{
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + dbHost
					+ ":" + dbPort + "/" + dbServiceName, dbUsername,
					dbPassword);
			return conn;
		} catch (SQLException e) {
			logger.error("Error: unable to load driver class!");
			MiscUtils.propagate(e);
		}
		return null;
	}
}
