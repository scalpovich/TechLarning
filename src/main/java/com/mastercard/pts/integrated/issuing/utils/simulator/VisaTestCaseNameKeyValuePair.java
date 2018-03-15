package com.mastercard.pts.integrated.issuing.utils.simulator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class VisaTestCaseNameKeyValuePair {

	protected static final Map<String, String> visaTestCaseDetailsKeyValuePair = new HashMap<>();
	protected static final Map<String, String> visaTestDataFileToSelectKeyValuePair = new HashMap<>();
	private static final String RVMT_RECEIVING_CERTIFICATION = "RVMT_Receiving_Certification";

	private void setVisaTestData() {
		visaTestCaseDetailsKeyValuePair.put("LoadAndActivate", "Case 1.1 - Authorization Load");
		visaTestCaseDetailsKeyValuePair.put("LoadAndActivate_with_pin", "Case 1.1 - Authorization Load");
		visaTestCaseDetailsKeyValuePair.put("Rvmt_Receiving", "4.11 - OCT - Velocity Checking Limits");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_1", "Case 1 - 0100/0110 Original Credit (TAG 57, 5F & 71)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_2", "Case 2 - 0100/0110 Original Credit STIP Response 91 (TAG 57, 5F & 71)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_3", "Case 3 - 0100/0110 Original Credit (TAG 57, 5F &71)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_4", "Case 4 - 0100/0110 Original Credit (TAG 57, 5F & 71)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_5", "Case 5 - 0100/0110. 0400/0410 Original Credit & Reversal (TAGs 57, 5F & 71)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_6", "Case 6 - 0100/0110 Original Credit (VSEC Transaction)");
		visaTestCaseDetailsKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_7", "Case 7 - 0100/0110 Original Credit (VSEC Transaction)");
	}

	private void setFileNameToUpload() {
		visaTestDataFileToSelectKeyValuePair.put("LoadAndActivate", "POS_Load_And_Activate_without_Pin");
		visaTestDataFileToSelectKeyValuePair.put("LoadAndActivate_with_pin", "POS_Load_And_Activate_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("Rvmt_Receiving", "RVMT_Receiving_without_Pin");
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_1", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_2", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_3", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_4", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_5", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_6", RVMT_RECEIVING_CERTIFICATION);
		visaTestDataFileToSelectKeyValuePair.put(RVMT_RECEIVING_CERTIFICATION + "_7", RVMT_RECEIVING_CERTIFICATION);
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