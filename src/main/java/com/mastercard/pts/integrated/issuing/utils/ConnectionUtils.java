package com.mastercard.pts.integrated.issuing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.soap.XMLUtilities;

/**
 * @author E070234
 * @info Implement this class for DB Connection
 *
 */
@Component
public class ConnectionUtils {

	public static Connection con;
	private Statement stmt = null;
	private ResultSet rs = null;
	LinkedHashSet<String> allBINSet = new LinkedHashSet<String>();
	@Autowired
	public Environment env;
	final Logger logger = LoggerFactory.getLogger(XMLUtilities.class);

	/**
	 * Implement This function for connection to DB return type will be
	 * connection Class object pass parameter from config file
	 * 
	 */

	public Connection getConnection() {
		try {

			Class.forName(env.getProperty("bdd.jdbc.tools.db.driverClassName"));

			con = DriverManager.getConnection(
					env.getProperty("bdd.jdbc.tools.db.connection.url"),
					env.getProperty("bdd.jdbc.tools.db.user"),
					env.getProperty("bdd.jdbc.tools.db.password"));

		} catch (ClassNotFoundException | SQLException ex) {

			logger.info(": Exception found while connecting to the DB", ex);
		}

		return con;
	}

	/**
	 * Implement this function to execute the query Return type is resultset of
	 * result
	 * 
	 */

	public ResultSet executeQueryForBIN(String query) {

		con = getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

		} catch (SQLException | NullPointerException e) {
			logger.error(": Exception found while connection to DB", e);
		}
		return rs;

	}

	/**
	 * Implement this function to execute the query to get all rows of a given
	 * column. Return type is result set of result
	 * 
	 */
	public LinkedHashSet<String> getAllValuesOfAColumn(String query,
			String columnName) {

		con = getConnection();
		executeQueryForBIN(query);
		try {
			while (rs.next()) {
				allBINSet.add(rs.getString(columnName));

			}
		} catch (SQLException e) {
			logger.info(": Expxeption found while connection to DB", e);
		}
		closeConnection(con);
		return allBINSet;

	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			logger.info(": Exception found while closing the DB connection", e);
		}
	}

}