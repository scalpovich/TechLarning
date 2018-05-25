package com.mastercard.pts.integrated.issuing.domain.provider;

import java.util.Map;
import java.util.Optional;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.ThreadLocalWorker;

public interface DataLoader {
	
	Optional<Map<String, String>> loadData(String storyName);
	
	Optional<Map<String, String>> loadDataByKey(String storyName, String keyName, String keyValue);
	
	//TODO get rid of utils.TestContext
	default void updateTestContextWithTestData(String sheetName, String testcaseName) {
		Optional<Map<String, String>> data = loadDataByKey(sheetName, Constants.KEY_TCNAME, testcaseName);
		if (data.isPresent()) {
			ThreadLocalWorker.getTestContext().fnSetCurrentStoryTestData(data.get());
		}
	}
}
