package com.mastercard.bdd.mpts;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Ignore
@Component
public class DBTest {

	// @Autowired
	// private Environment env;

	// Properties prop = new Properties();

	@Test
	public void runDb() {
		String code = "36";
		String name = "Auto";

		String instName = String.format("%s (%s)", name, code);
		System.out.println(instName);

	}

}

// InputStream input = null;
// input = new
// FileInputStream("C:\\git\\mi-iss-automation-issprint-develop\\src\\main\\resources\\config\\itf\\test.properties");
// prop.load(input);
// System.out.println(prop.getProperty("bdd.jdbc.tools.db.driverClassName"));
// JDBCTemplateImpl bf = new
// JDBCTemplateImpl(prop.getProperty("bdd.jdbc.tools.db.driverClassName"),prop.getProperty("bdd.jdbc.tools.db.connection.url"),(prop.getProperty("bdd.jdbc.tools.db.user")),
// (prop.getProperty("bdd.jdbc.tools.db.password")));
//
// bf.execute("Select * from user");