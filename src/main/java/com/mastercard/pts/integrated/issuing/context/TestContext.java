package com.mastercard.pts.integrated.issuing.context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component("storyContext")
public class TestContext {

	private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();
	
	private static final String KEY_STORY_NAME = "storyName";
	
	public static final String KEY_STORY_DATA = "storyData";
	
	public void initStoryContext(String storyName) {
		context.set(new HashMap<>());
		put(KEY_STORY_NAME, storyName.toUpperCase());
	}
	
	public String getStoryName() {
		return get(KEY_STORY_NAME);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) context.get().get(key);
	}
	
	public void put(String key, Object value) {
		context.get().put(key, value);
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
}
