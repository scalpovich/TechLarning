package com.mastercard.pts.integrated.issuing.utils;

public class DBQueryConstant {

	public static String BIN_QUERY = "Select ISSUER_BIN from Bin_mgmt where BANK_CODE = '100000'and product_type = 'D'";

	public static String BIN_COLUMN = "ISSUER_BIN";

	public static String NEWCARDS_COUNT = "ISSUER_BIN";

	public static String FIRSTQUATERSTARTDATE = "1-Jan-2017";

	public static String FIRSTQUATERENDDATE = "31-March-2017";

	public static String SECONDQUATERSTARTDATE = "1-April-2017";

	public static String SECONDQUATERENDDATE = "30-June-2017";

	public static String THIRDQUATERSTARTDATE = "1-July-2017";

	public static String THIRDQUATERENDDATE = "30-Sep-2017";

	public static String FOURTHQUATERSTARTDATE = "1-Oct-2017";

	public static String FOURTHQUATERENDDATE = "31-Dec-2017";

	public static String DEVICENUMBER_COLUMN = "DEVICE_NUMBER";

	public static String CARDPACKID_COLUMN = "CARD_PACK_ID";

	public static String PREGENERATEDFLAG_COLUMN = "PRE_GENERATED_CARD";

	public static String JOBID_EVENTSALERTS_COLUMN = "JOB_ID";

	public static String DEVICENUMBER_QUERY = "select * from device  where DEVICE_NUMBER like";

	public static String DEVICE_QUERY = "select * from device where DEVICE_NUMBER =";

	public static String CARDPACKID_QUERY = "Select CARD_PACK_ID from DEVICE where DEVICE_NUMBER =";

	public static String PREGENERATEDFLAG_QUERY = "select PRE_GENERATED_CARD from DEVICE where DEVICE_NUMBER =";

	public static String EVENTSALERTS_SMS_QUERY = "select max(job_id) from alert_queue where event_code = 'OTPG0A0001'";

	public static String EVENTSALERTS_EMAIL_QUERY = "select max(job_id) from alert_queue where event_code = 'OTPG0A0002'";

}
