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

}
