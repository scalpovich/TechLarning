package com.mastercard.pts.integrated.issuing.steps;

import java.util.HashMap;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.CustomTestContextProvider;

@Component
public class AbstractBaseSteps {

	final Logger LOG = LoggerFactory.getLogger("StepsLogger");

/*	@Autowired
	JDBCTemplateImpl oracleInstance;*/

	@Autowired
	protected Environment env;

	/*public boolean validateinstitutioncode(String strinstcode) {
		List<Map<String, Object>> list = oracleInstance
				.queryATable("select * from INSTITUTION where BANK_CODE = "
						+ strinstcode + ";");

		return list.size() == 0;
	}*/

	/*public boolean validateinstitutionname(String strinstname) {
		List<Map<String, Object>> list = oracleInstance
				.queryATable("select * from INSTITUTION where BANK_NAME = '"
						+ strinstname + "';");

		return list.size() == 0;
	}*/

	/**
	 * Context is nothing but when we execute our program in that we can store
	 * and reuse value according to our requirement
	 * 
	 * @param StoryName
	 * @param key
	 * @return
	 */
	protected <T> T getFromContext(String StoryName, String key) {
		if (key == null || key.length() == 0) {
			LOG.info("Either key is null or StoryName is null");
		}
		T t = CustomTestContextProvider.get().get(StoryName, key);
		if (t == null)
			Assert.assertTrue("For Story " + StoryName + " Key " + key
					+ " Not found in context", false);
		return t;
	}

	/**
	 * Context is nothing but when we execute our program in that we can store
	 * and reuse value according to our requirement
	 * 
	 * @param StoryName
	 * @param key
	 * @return as a String
	 */
	protected String getAsStringFromContext(String StoryName, String key) {
		return getFromContext(StoryName, key).toString();
	}

	/**
	 * for single story if you want all stored value we can use this function
	 * 
	 * @param StoryName
	 * @return
	 */
	protected HashMap<String, Object> getFromContext(String StoryName) {

		return CustomTestContextProvider.get().get(StoryName);
	}

	/**
	 * during execution we are setting one value in our execution context
	 * 
	 * @param StoryName
	 * @param key
	 * @param value
	 */
	protected void setInContext(String StoryName, String key, Object value) {
		// LOG.info("value.getClass().isInstance(String.class):"+value.getClass().isInstance(String.class),false);
		if (value == null) {
			LOG.info("Passed value in context is null check what we are passing in it ");
			Assert.assertTrue(false);
		}
		if (value.getClass().isInstance(String.class))
			LOG.info("Setting in " + StoryName + " Context : " + key + "="
					+ value, false);
		CustomTestContextProvider.get().put(StoryName, key, value);
	}

	/**
	 * during execution we can set more then one value in our execution context
	 * 
	 * @param StoryName
	 * @param hMap
	 */
	protected void setInContext(String StoryName, HashMap<String, Object> hMap) {
		CustomTestContextProvider.get().put(StoryName, hMap);
	}

	/**
	 * directly call this if we has some properties in property file
	 * 
	 * @param property
	 * @return
	 */
	protected String getProperty(String property) {
		return env.getProperty(property);
	}

}
