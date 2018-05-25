package com.mastercard.pts.integrated.issuing.utils;

import java.util.Map;

public class TestContext {
	public String data;
	private Map<String, String> currentStoryTestData;
	private Map<String, String> iteratedTestData;
	private Map<String, String> applicationUploadData;

	public void fnSetCurrentStoryTestData(
			Map<String, String> currentStoryTestData) {
		this.currentStoryTestData = currentStoryTestData;
	}

	public Map<String, String> fnGetCurrentStoryTestData() {
		return currentStoryTestData;
	}

	public Map<String, String> getIteratedTestData() {
		return iteratedTestData;
	}

	public void setIteratedTestData(Map<String, String> iteratedTestData) {
		this.iteratedTestData = iteratedTestData;
	}

	public Map<String, String> getApplicationUploadData() {
		return applicationUploadData;
	}

	public void setApplicationUploadData(
			Map<String, String> applicationUploadData) {
		this.applicationUploadData = applicationUploadData;
	}
	

}
