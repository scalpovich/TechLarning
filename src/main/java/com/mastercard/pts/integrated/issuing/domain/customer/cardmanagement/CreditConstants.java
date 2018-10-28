package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditConstants {

    public static final String CREDIT_PLAN_CODE_ERROR_STATUS="CREDIT_PLAN_CODE_ERROR_STATUS";
	
	public static final String BILLING_CYCLE_CODE_ERROR_STATUS="BILLING_CYCLE_CODE_ERROR_STATUS";
	
	public static final String TRANSACTION_PLAN_ERROR_STATUS="TRANSACTION_PLAN_ERROR_STATUS";
	
	public static final String PAYMENT_PRIORITY_STATUS="PAYMENT_PRIORITY_STATUS";
	
	public static final String CREDIT_PLAN="CREDIT_PLAN";
	
	public static final String BILLING_CYCLE="BILLING_CYCLE";
	
	public static final String PAYMENT_PRIORITY="PAYMENT_PRIORITY";
	
	public static final String TRANSACTION_RULE="TRANSACTION_RULE";
	
	public static final String PAYMENT_BOUNCE_STATUS="PAYMENT_BOUNCE_STATUS";
	
	public static final String APPLICATION = "APPLICATION";
	
	public static final String NEW_APPLICATION_BATCH="NEW_APPLICATION_BATCH";
	
	public static final String WALLET_TYPE="WALLET_TYPE";
	
	public static final String USAGE_TYPE="USAGE_TYPE";
	
	public static final String CREDIT_BRANCH="CREDIT_BRANCH";
	
	public static final String DEVICE_BIN="DEVICE_BIN";
	
	public static final String DEVICE_NUMBERS="DEVICE_NUMBERS";
	
	public static final String DEVICE_NUMBER="DEVICE_NUMBER";
	
	public static final String EXCEL_VALUES="EXCEL_VALUES";
	
	public static final String JSON_VALUES="JSON_VALUES";
	
	public static final String DEVICE_NUMBER_ADDON="DEVICE_NUMBER_ADDON";
	
	public static final String QUANTITY_REQUESTED = "QUANTITY_REQUESTED";
	
	public static final String VENDOR_BRANCH="VENDOR_BRANCH";
	
	public static final String PRIMARY_BATCH_NUMBER="PRIMARY_BATCH_NUMBER";
	
	public static final String EXISTING_DEVICE_NUMBER="EXISTING_DEVICE_NUMBER";
	
	public static final String SUPPLEMENTARY_DEVICE_NUMBER="SUPPLEMENTARY_DEVICE_NUMBER";
	
	public static final String HELPDESK_FILEUPLOAD="HELPDESK_FILEUPLOAD";
	
	public static final String HELPDESK_FILEUPLOAD_MULTIPLEDEVICES="HELPDESK_FILEUPLOAD_MULTIPLEDEVICES";
	
	public static final String FORM_NUMBER="FORM_NUMBER";
	
	public static final String BATCH_NUMBER_FILEUPLOAD="BATCH_NUMBER_FILEUPLOAD";
	
	public static final String APPLICATION_NUMBER_FILEUPLOAD="APPLICATION_NUMBER_FILEUPLOAD";
	
	public static final String FILEUPLOAD_IN_BULK="FILEUPLOAD_IN_BULK";
	
	public static final String ALL_APPLICATION_NUMBERS="ALL_APPLICATION_NUMBERS";
	
	public static final String ALL_BATCH_NUMBERS="ALL_BATCH_NUMBERS";
	
	public static final String ALL_BATCH_NUMBERS_PREPRODUCTION="ALL_BATCH_NUMBERS_PREPRODUCTION";
	
	public static final String JOB_ID="JOB_ID";

	public static final String PARTNER_MEMBERSHIP_NUMBER = "PARTNER_MEMBERSHIP_NUMBER";
	
	public static final String CREDIT_LIMIT_GREATER_THAN_MAXIMUM = "CREDIT_LIMIT_GREATER_THAN_MAXIMUM";

	public static final String EXISTING_BATCH="EXISTING_BATCH";

	private CreditConstants() {
	}
	
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(ConstantData.class, name);
	}
}
