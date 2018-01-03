package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class VisaTestCaseNameKeyValuePair {

	protected static final Map<String, String> visaTestCaseDetailsKeyValuePair = new HashMap<>();
	
	private void setVisaTestData() {
	visaTestCaseDetailsKeyValuePair.put("CASH_WITHDRAWAL", "1.1 Cash WDL");
	visaTestCaseDetailsKeyValuePair.put("CWDL", "1.1 Cash WDL");
	visaTestCaseDetailsKeyValuePair.put("REFUND_REVERSAL" ,  "Refund Reversal");
	visaTestCaseDetailsKeyValuePair.put("CASH_DISBURSEMENT_AND_FULL_REVERSAL" ,  "Case 4.1 Cash Disbursement and Full Reversal");
	visaTestCaseDetailsKeyValuePair.put("BAL_INQUIRY" ,   "Case 3.2 Balance Inquiry - Savings Account");
	visaTestCaseDetailsKeyValuePair.put("BAL_INQ" ,   "Case 3.2 Balance Inquiry - Savings Account");
	visaTestCaseDetailsKeyValuePair.put("CASH_DISBURSEMENT_AND_PARTIAL_REVERSAL " , "Case 5.1 Cash Disbursement and Partial Reversal (Under-Dispense)");
	visaTestCaseDetailsKeyValuePair.put("REQUEST_FOR_WITHDRAWAL_CASH_ADVANCE" , "D1 - Request For Withdrawal/Cash Advance");
	visaTestCaseDetailsKeyValuePair.put("PURCHASE_AND_REVERSAL" ,   "I1 - Purchase & Reversal");
	visaTestCaseDetailsKeyValuePair.put("CREDIT_WITHDRAWAL_CAH_ADVANCE_REVERSAL" ,  "I2 - Credit Withdrawal/Cash Advance & Reversal");
	visaTestCaseDetailsKeyValuePair.put("REQUEST_FOR_PURCHASE" ,   "B1 - Request For Purchase");
	visaTestCaseDetailsKeyValuePair.put("AUTH_WITH_CASHBACK" ,  "Case 2.10 - Authorisation with Cashback");
	visaTestCaseDetailsKeyValuePair.put("AUTH_WITH_CASHBACK_REVERSAL" ,  "Case 5.4 Authorisation with Cashback & 0400 Reversal");
	visaTestCaseDetailsKeyValuePair.put("PREAUTH_COMPLETION" ,   "7.9 - PAVD from NW3 - Pre-Auth and Completion Advice");
	visaTestCaseDetailsKeyValuePair.put("AUTH_LOAD" ,   "Case 1.1 - Authorization Load");
	visaTestCaseDetailsKeyValuePair.put("AUTH_ACTIVATION" ,  "Case 1.4 - Authorization Activation");
	visaTestCaseDetailsKeyValuePair.put("AUTH_REPEAT_REVERSAL" ,   "2.4 - Authorization, Repeat Authorization, Reversal");
	visaTestCaseDetailsKeyValuePair.put("CASH_AUTH" ,   "2.1 - Quasi-Cash Authorization");
	visaTestCaseDetailsKeyValuePair.put("PREAUTH" ,   "2.3 - Pre Auth");
	visaTestCaseDetailsKeyValuePair.put("ACCOUNT_FUNDING" ,   "2.2 Account funding");
	visaTestCaseDetailsKeyValuePair.put("STIP_ADVICE" ,   "2.4 STIP Advice");
	visaTestCaseDetailsKeyValuePair.put("RVMT_SENDING" ,  "2.2 Account funding- RVMT Sending");
	visaTestCaseDetailsKeyValuePair.put("RVMT_RECEIVING" ,  "4.11 - OCT - Velocity Checking Limits - RVMT Receiving");
	}

	public String getVisaTestCaseDetails(String key) {
		setVisaTestData();
		return visaTestCaseDetailsKeyValuePair.get(key.toUpperCase());
	}
}