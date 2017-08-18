package com.mastercard.pts.integrated.issuing.domain.provider;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;

@Component
public class TestContextKeyValueProvider implements KeyValueProvider {

	@Autowired
	private TestContext testContext;
	
	@Override
	public String getString(String key) {
		Map<String, String> data = testContext.get(TestContext.KEY_STORY_DATA);
		return data.getOrDefault(key, null);
	}
}
