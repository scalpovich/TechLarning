package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;

public class TestContext {
	public String data;
	private HashMap<String, String> currentStoryTestData;
	private HashMap<String, String> iteratedTestData;
	private HashMap<String, String> applicationUploadData;

	public void fnSetCurrentStoryTestData(
			HashMap<String, String> currentStoryTestData) {
		this.currentStoryTestData = currentStoryTestData;
	}

	public HashMap<String, String> fnGetCurrentStoryTestData() {
		return currentStoryTestData;
	}

	public HashMap<String, String> getIteratedTestData() {
		return iteratedTestData;
	}

	public void setIteratedTestData(HashMap<String, String> iteratedTestData) {
		this.iteratedTestData = iteratedTestData;
	}

	public HashMap<String, String> getApplicationUploadData() {
		return applicationUploadData;
	}

	public void setApplicationUploadData(
			HashMap<String, String> applicationUploadData) {
		this.applicationUploadData = applicationUploadData;
	}
	

}
