package com.mastercard.pts.integrated.issuing.utils;

/**
 * Issuing Team
 * 
 * @author e071201
 *
 *         Class contains the constant variable which used for Test Data.
 *
 */

public class ConstantData {

	public static final String SUCCESS_MESSAGE = "Record Added Successfully";
	public static final String RECORD_EXISTS = "Record already exists";
	public static final String RECORD_ADDED_SUCCESSFULLY = "Record Added Successfully.";
	public static final String FIELD_ALREADY_EXISTS = "Field already exists";
	public static final String GENERIC_ALREADY_EXISTS = "already exists";
	public static final String SAME_TRANSACTION_EXISTS = "Information with same Transaction Rule Plan Code already exists.";
	public static final String SAME_CREDIT_PLAN_EXISTS = "Information with same Credit Plan Code already exists.";
	public static final String GENERIC_DESCRIPTION = "AUTOMATION";
	public static final String TRANSACTION_UPLOAD_FILE_PATH = "/home/dc-user/integrated/elt_bo/data/TRANSACTION_UPLOAD/INPUT";
	public static final String IPM_UPLOAD_FILE_PATH =  "/home/dc-user/integrated/elt_bo/data/IPM_INCOMING/INPUT"; 	// "/home/dc-user/integrated/elt_bo/data/IPM_INCOMING/INPUT" "/mptshome/STAGE2/integrated/elt_bo/data/IPM_INCOMING/input" ;

	public static final String VENDOR_MASTER_ADDRESS="PUNE";
	public static final String VENDOR_MASTER_COUNTRY="INDIA [356]";
	public static final String VENDOR_MASTER_CONTACT_PERSON="TESTTTRE";
	public static final String VENDOR_MASTER_MOBILE_COUNTRY_CODE="IND [+91]";
	public static final String VENDOR_MASTER_MOBILE_NUMBER="67890765";
	public static final String VENDOR_MASTER_PHONE_NO="656789765";
	public static final String VENDOR_MASTER_EMAIL="a@c.com";
	public static final String VENDOR_MASTER_BRANCH="auto branch [1000]";
	public static final String POSTAL_CODE="411006";
	public static final String ARN_NUMBER="ARN_NUMBER";
	public static final String PROCESSING_INSTITUTION="BNK [000000]";
	
	public static final String EXCEPTION = "Exception occurred :: {}";
	public static final String SIKUKI_EXCEPTION = "Image could not be clicked";
	public static final String MESSAGE_CONSTANT = "Simulator path being set :  ";
	public static final String IS_PIN_REQUIRED = "TRUE";
	
	public static final String  TRANSACTION_NAME = "transaction";
	public static final String  DATAELEMENT_037 = "data037";
	
	public static final String  VISA_OUT_GOING_FILE_NAME = "filename";
	public static final String  VISA_FEE_COLLECTION_TRANSACTIONCODE = "10";
	public static final String  VISA_FUND_DISBURSEMENT_TRANSACTIONCODE = "20";
	public static final String  VISA_BASEII_LINUX_DIRECTORY= "VISA";
	
	public static final String  AUTHORIZATION_REPORT_FILE_NAME = "Authorization.pdf";
	public static final String  AUTHORIZATION_REPORT_NAME = "Authorization";
	public static final String  AUTHORIZATION_REPORT_FILE_KEY = "Auto";
	public static final String  AUTHORIZATION_CODE = "authCode";
	public static final String  TRANSACTION_AMOUNT = "transactionAmount";
	
	public static final String OPTION_SELECT_ONE = "Select One";
	
	public static final String API_NAME = "API_NAME";

	public static final String  MSR_CARD = "magnetic stripe card";
	public static final String  DEBIT_DEVICE = "Debitdevice";
	public static final String  PREPAID_DEVICE = "Prepaiddevice";
	
	
	
	private ConstantData() {}
}
