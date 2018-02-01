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
		visaTestCaseDetailsKeyValuePair.put("LoadAndActivate_with_pin", "Case 1.1 - Authorization Load");
		visaTestCaseDetailsKeyValuePair.put("Rvmt_Receiving", "4.11 - OCT - Velocity Checking Limits");
	}

	private void setFileNameToUpload() {
		visaTestDataFileToSelectKeyValuePair.put("LoadAndActivate", "POS_Load_And_Activate_without_Pin");
		visaTestDataFileToSelectKeyValuePair.put("LoadAndActivate_with_pin", "POS_Load_And_Activate_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("Rvmt_Receiving", "RVMT_Receiving_without_Pin");
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