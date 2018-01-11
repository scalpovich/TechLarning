package com.mastercard.pts.integrated.issuing.utils.simulator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class VisaTestCaseNameKeyValuePair {

	protected static final Map<String, String> visaTestCaseDetailsKeyValuePair = new HashMap<>();
	protected static final Map<String, String> visaTestDataFileToSelectKeyValuePair = new HashMap<>();

	private void setVisaTestData() {
		visaTestCaseDetailsKeyValuePair.put("LoadAndActivate", "Case 1.1 - Authorization Load");
	}

	private void setFileNameToUpload() {
		visaTestDataFileToSelectKeyValuePair.put("LoadAndActivate", "POS_Load_And_Activate");
	}

	public String getVisaTestCaseToSelect(String key) {
		setVisaTestData();
		return visaTestCaseDetailsKeyValuePair.get(key);
	}

	public String getVisaTestDataFileNameToUpload(String key) {
		setFileNameToUpload();
		return visaTestDataFileToSelectKeyValuePair.get(key);
	}
}