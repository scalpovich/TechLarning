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
		visaTestCaseDetailsKeyValuePair.put("POS_Retail_Magstripe_cash_withdrawal_with_Pin", "Case 1: Cash Withdrawal");	
		visaTestCaseDetailsKeyValuePair.put("POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin", "Case 1: Balance Inquiry");
		visaTestCaseDetailsKeyValuePair.put("POS-Magstripe-QuasiCash_with_Pin", "2 - Authorization - Quasi Cash");				
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Magstripe-purchase_with_Pin", "Case 1-Purchase Transaction With Pin");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Magstripe-returns-of-goods_with_Pin", "Case 1- Returns Of Goods");
		visaTestCaseDetailsKeyValuePair.put("POS-Magstripe-CashAdvance_with_Pin", "1 - Authorization - Cash Advance");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Magstripe-cashRev_with_Pin", "Case 2: Cashwithdrawal Reversal");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Magstripe-cashPrev_with_Pin", "Case 3: Cashwithdrawl Partial Reversal");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Magstripe-purchaseRev_with_Pin", "Case 4- Purchase Reversal Without Pin");	
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-ECOM", "ECOM");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-STIP_with_Pin", "STIP");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-PreAuth_with_Pin", "PREAUTH");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-Refund_with_Pin", "Refund");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-RefundReversal_with_Pin", "RefundReversal");	
		visaTestCaseDetailsKeyValuePair.put("POS-Magstripe-egilibility-Inquiry_with_Pin", "Case 2: Eligibility Inquiry");
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-AccountFund", "AccountFunding");	
		visaTestCaseDetailsKeyValuePair.put("POS-Retail-PreAuthCompletion_with_Pin", "PREAUTHCOMPLETION");	
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
		visaTestDataFileToSelectKeyValuePair.put("POS_Retail_Magstripe_cash_withdrawal_with_Pin", "POS_Retail_Magstripe_cash_withdrawal_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin", "POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Magstripe-QuasiCash_with_Pin", "POS-Magstripe-QuasiCash_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Magstripe-purchase_with_Pin", "POS-Retail-Magstripe-purchase_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Magstripe-returns-of-goods_with_Pin", "POS-Retail-Magstripe-returns-of-goods_with_Pin");			
		visaTestDataFileToSelectKeyValuePair.put("POS-Magstripe-CashAdvance_with_Pin", "POS-Magstripe-CashAdvance_with_Pin");	
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Magstripe-cashRev_with_Pin", "POS-Retail-Magstripe-cashRev_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Magstripe-cashPrev_with_Pin", "POS-Retail-Magstripe-cashPrev_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Magstripe-purchaseRev_with_Pin", "POS-Retail-Magstripe-purchaseRev_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-ECOM", "POS-Retail-ECOM");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-STIP_with_Pin", "POS-Retail-STIP_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-PreAuth_with_Pin", "POS-Retail-PreAuth_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-Refund_with_Pin", "POS-Retail-Refund_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-RefundReversal_with_Pin", "POS-Retail-RefundReversal_with_Pin");
		visaTestDataFileToSelectKeyValuePair.put("POS-Magstripe-egilibility-Inquiry_with_Pin", "POS-Magstripe-egilibility-Inquiry_with_Pin");		
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-AccountFund", "POS-Retail-AccountFund");
		visaTestDataFileToSelectKeyValuePair.put("POS-Retail-PreAuthCompletion_with_Pin", "POS-Retail-PreAuthCompletion_with_Pin");
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