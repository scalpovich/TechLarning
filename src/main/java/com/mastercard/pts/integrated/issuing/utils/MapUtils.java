package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapUtils {

	final static Logger logger = LoggerFactory.getLogger(MapUtils.class);

	public static void fnAddValueToMap(
			HashMap<String, HashMap<String, String>> hashMapObject,
			String strKey, HashMap<String, String> hashMapValue) {
		HashMap<String, String> tempMap = hashMapValue;
		hashMapObject.put(strKey, tempMap);
		hashMapValue = null;
	}

	public static String fnGetInputDataFromMap(String strKey) {
		Map<String, String> storyTestData = ThreadLocalWorker
				.getTestContext().fnGetCurrentStoryTestData();
		if (!storyTestData.containsKey(strKey)) {
			logger.info("Unable to read test data for the Key :" + strKey);
			return null;
		} else {
			logger.info(storyTestData.get(strKey));
			return storyTestData.get(strKey);
		}
	}
	
	public static String getIterativeDataFromDatamap(String strKey) {
		Map<String, String> storyTestData = ThreadLocalWorker
				.getTestContext().getIteratedTestData();
		if (!storyTestData.containsKey(strKey)) {
			logger.info("Unable to read test data for the Key :" + strKey);
			return null;
		} else {
			return storyTestData.get(strKey);
		}
	}

	public static boolean fnIsKeyExists(String strKey) {
		Map<String, String> storyTestData = ThreadLocalWorker
				.getTestContext().fnGetCurrentStoryTestData();
		return storyTestData.containsKey(strKey);
	}

	public static void fnSetInputDataToInputMap(String strkey, String strValue) {
		Map<String, String> storyTestData = ThreadLocalWorker
				.getTestContext().fnGetCurrentStoryTestData();
		if(storyTestData != null){
			logger.info("Data is here");
		}else{
			logger.info("Data not present");
		}
		if (storyTestData.containsKey(strkey)) {
			storyTestData.remove(strkey);
			storyTestData.put(strkey, strValue);
		} else {
			storyTestData.put(strkey, strValue);
		}
	}

}
