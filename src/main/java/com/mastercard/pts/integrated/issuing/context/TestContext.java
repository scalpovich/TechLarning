package com.mastercard.pts.integrated.issuing.context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component("storyContext")
public class TestContext {

	@Deprecated
	private HashMap<String, String> currentStoryTestData;
	private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();
	
	private static final String KEY_STORY_NAME = "storyName";
	
	public static final String KEY_STORY_DATA = "storyData";

	/**
	 * We will write whatever is there in loggers at the end of execution. use
	 * for test data.
	 * 
	 */
	public static StringBuilder loggers = new StringBuilder();

	protected HashMap<String, HashMap<String, Object>> contextMap = new HashMap<String, HashMap<String, Object>>();
	
	public void initStoryContext(String storyName) {
		context.set(new HashMap<>());
		put(KEY_STORY_NAME, storyName.toUpperCase());
	}
	
	public String getStoryName() {
		return get(KEY_STORY_NAME);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String storyName, String key)
			throws IllegalArgumentException {

		HashMap<String, Object> eMap = contextMap.get(storyName);

		return (T) eMap.get(key);

	}
	public void put(String storyName, String key, Object value)
			throws IllegalArgumentException {
		if (contextMap.get(storyName) == null) {
			HashMap<String, Object> newMap = new HashMap<>();
			newMap.put(key, value);
			contextMap.put(storyName, newMap);

		} else {
			HashMap<String, Object> eMap = contextMap.get(storyName);
			eMap.put(key, value);
			contextMap.put(storyName, eMap);

		}

	}

	public void put(String storyName, HashMap<String, Object> hMap)
			throws IllegalArgumentException {

		if (contextMap.get(storyName) == null) {
			contextMap.put(storyName, hMap);

		} else {
			HashMap<String, Object> eMap = contextMap.get(storyName);

			for (String key : hMap.keySet()) {
				eMap.put(key, hMap.get(key));

			}
			contextMap.put(storyName, eMap);
		}

	}

	@SuppressWarnings("unchecked")
	public <T> T get(String storyName, String key)
			throws IllegalArgumentException {

		HashMap<String, Object> eMap = contextMap.get(storyName);

		return (T) eMap.get(key);

	}

	public HashMap<String, Object> get(String storyName)
			throws IllegalArgumentException {

		return contextMap.get(storyName);

	}

	public void clear() {
		contextMap.clear();
	}

	public HashMap<String, HashMap<String, Object>> getContextMap() {
		return contextMap;
	}
	public void dispose() {
		context.set(null);
	}
	
	/**
	 * Does some thing in old style.
	 *
	 * @deprecated.  
	 */
	@Deprecated
	public static WebDriver getDriver() {
		return (WebDriver) context.get().get("DRIVER");
	}

	public void setContextMap(
			HashMap<String, HashMap<String, Object>> contextMap) {
		this.contextMap = contextMap;
	}

	public void fnSetCurrentStoryTestData(
			HashMap<String, String> currentStoryTestData) {
		this.currentStoryTestData = currentStoryTestData;
	}

	public HashMap<String, String> fnGetCurrentStoryTestData() {
		return currentStoryTestData;
	}

}
