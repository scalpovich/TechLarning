package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

public class DisputeNav {

	public static final String TAB_DISPUTE = "Dispute";

	public static final String L1_SETUP = "CHS000";
	public static final String L1_REPORTS = "CHRE00";
	public static final String L2_DISPUTE_REASON_CODE = "DISSR";
	public static final String L3_RETRIEVAL_REQUEST_REASON_CODE = "DISSR1";
	public static final String L3_CHARGEBACK_REASON_CODE = "DISSR2";
	public static final String L3_RE_PRESENTMENT_REASON_CODE = "DISSR3";
	public static final String L3_ARBITRATION_TYPE = "DISSR4";

	public static final String L1_DISPUTE_ACTIVITY = "CHD000";
	public static final String L2_RETRIVAL_REQUEST = "DISA01";
	public static final String L2_RETRIVAL_RESPONSE = "DISA02";

	public static final String L2_CHARGEBACK = "CHG000";
	public static final String L3_CHARGEBACK_NEW = "DISA03";
	public static final String L3_CHARGEBACK_MODIFY = "DISA04";
	public static final String L3_CHARGEBACK_REVERSAL = "DISA05";
	public static final String L3_CHARGEBACK_CANCELLATION = "DISA12";

	public static final String L2_SECOND_CHARGEBACK = "CHGS00";
	public static final String L3_SECOND_CHARGEBACK_NEW = "DISA06";
	public static final String L3_SECOND_CHARGEBACK_MODIFY = "DISA07";
	public static final String L3_SECOND_CHARGEBACK_REVERSAL = "DISA08";
	public static final String L3_SECOND_CHARGEBACK_CANCELLATION = "DISA14";

	public static final String L2_DISPUTE_HISTORY = "DISA11";
	public static final String L2_ARBITRATION = "DISA10";
	public static final String L2_MANUAL_DISPUTE_POSTING = "DISA09";
	public static final String L2_DISPUTES_MANAGEMENT_REPORT = "CHRE02";
	
	
	private DisputeNav() {}
}
