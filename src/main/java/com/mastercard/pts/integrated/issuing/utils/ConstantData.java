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
	public static final String RECORD_PROCESSED_SUCCESSFULLY = "Request processed succesfully.";
	public static final String FIELD_ALREADY_EXISTS = "Field already exists";
	public static final String GENERIC_ALREADY_EXISTS = "already exists";
	public static final String SAME_TRANSACTION_EXISTS = "Information with same Transaction Rule Plan Code already exists.";
	public static final String SAME_CREDIT_PLAN_EXISTS = "Information with same Credit Plan Code already exists.";
	public static final String GENERIC_DESCRIPTION = "AUTOMATION";
	public static final String REQUIRED_FIELD_VALIDATION_MESSAGE = "This field is required.";
	public static final String TRANSACTION_UPLOAD_FILE_PATH = "/home/dc-user/integrated/elt_bo/data/TRANSACTION_UPLOAD/INPUT";
	public static final String IPM_UPLOAD_FILE_PATH = "/mptshome/STAGE2/integrated/elt_bo/data/AUTOMATION_1/IPM_INCOMING/input"; // "/home/dc-user/integrated/elt_bo/data/IPM_INCOMING/INPUT"
																																	// "/mptshome/STAGE2/integrated/elt_bo/data/IPM_INCOMING/input"
																																	// ;

	public static final String VENDOR_MASTER_ADDRESS = "PUNE";
	public static final String VENDOR_MASTER_COUNTRY = "INDIA [356]";
	public static final String VENDOR_MASTER_CONTACT_PERSON = "TESTTTRE";
	public static final String VENDOR_MASTER_MOBILE_COUNTRY_CODE = "IND [+91]";
	public static final String VENDOR_MASTER_MOBILE_NUMBER = "67890765";
	public static final String VENDOR_MASTER_PHONE_NO = "656789765";
	public static final String VENDOR_MASTER_EMAIL = "a@c.com";
	public static final String VENDOR_MASTER_BRANCH = "auto branch [1000]";
	public static final String POSTAL_CODE = "411006";
	public static final String ARN_NUMBER = "ARN_NUMBER";
	public static final String PROCESSING_INSTITUTION = "BNK [000000]";

	public static final String EXCEPTION = "Exception occurred :: {}";

	public static final String SIKUKI_EXCEPTION = "Image could not be clicked";
	public static final String MESSAGE_CONSTANT = "Simulator path being set :  ";
	public static final String IS_PIN_REQUIRED = "TRUE";
	public static final String TRANSACTION_NAME = "transaction";
	public static final String DATAELEMENT_037 = "data037";

	public static final String VISA_OUT_GOING_FILE_NAME = "filename";
	public static final String VISA_FEE_COLLECTION_TRANSACTIONCODE = "10";
	public static final String VISA_FUND_DISBURSEMENT_TRANSACTIONCODE = "20";
	public static final String VISA_BASEII_LINUX_DIRECTORY = "VISA";

	public static final String AUTHORIZATION_REPORT_FILE_NAME = "Authorization.pdf";
	public static final String AUTHORIZATION_REPORT_NAME = "Authorization";
	public static final String AUTHORIZATION_REPORT_FILE_KEY = "Auto";
	public static final String AUTHORIZATION_CODE = "authCode";
	public static final String TRANSACTION_AMOUNT = "transactionAmount";
	public static final String BILLING_AMOUNT = "billingAmount";
	public static final String TRANSACTION_AMOUNT_BD = "transactionAmountbd";
	public static final String INTERNATIONAL_ALLOW_DISALLOW = "International Use Allow/Disallow [400]";
	public static final String ECCOMERCE_ALLOW_DISALLOW= "E-commerce Activation/Deactivation [304]";

	public static final String OPTION_SELECT_ONE = "Select One";

	public static final String API_NAME = "API_NAME";
	public static final String MSR_CARD = "magnetic stripe card";
	public static final String NFC_MSR_CARD = "mag stripe";
	public static final String MSR_NFC_PURCHASE = "MSR_NFC_PURCHASE";
	public static final String DEBIT_DEVICE = "Debitdevice";
	public static final String PREPAID_DEVICE = "Prepaiddevice";
	
	public static final String HIGH_RISK_COUNTRY = "HighRiskCountry";
	public static final String LOAN_TYPE_OBJECT = "LoanTypeObject";
	public static final String START_RANGE_DIGITS = "0000000000";
	public static final String END_RANGE_DIGITS = "9999999999";
	public static final String RRN_NUMBER = "rrnumber";
	
	public static final String THREE_D_SECURE_NO_CVV2 = "3D_SECURE_NO_CVV2";
	public static final String THREE_D_SECURE_TRANSACTION = "3D_SECURE_CAVV";
	public static final String DATA_ELEMENT_CAVV = "048.TLV.43";
	
	public static final String DEVICE_RANGE_DATA = "DeviceRangeData";
	public static final String INSTITUTION_KEY = "institution";
	public static final String PRODUCT_IDENTITY = "productIdentity";
	public static final String INSTITUTION_CODE_KEY = "code";
	
	public static final String PIN_REQUIRED_FALSE = "false";
	public static final String JSON_DATA_DRIVEN_EXECUTION = "dataDrivenExecution";
	public static final String VIRTUAL_DEVICE_TYPE = "virtual";


	public static final String INVALID_CVV = "123";	
	public static final String INVALID_CVV2 = "123";	
	public static final String INVALID_ICVV = "123";	
	public static final String INVALID_PVKI = "123";
	public static final String INVALID_PIN = "1234";
	
	public static final int STATIC_WAIT_FOR_PRESCREENING = 3900000;
	
	
	public static final String OPEN_BATCH = "Open [O]";

	
	public static final String EXISTING = "Existing";
	public static final String PIN_REQUIRED_YES = "YES";
	public static final String WORNG_EXPIRY = "1809";
	public static final String ACTIVATION_VALUE ="Immediate Activation for n Hrs [Immediate Activation for n Hrs]";
	
	public static final String ZERO_ZERO = "00";
	public static final String NINE_NINE = "99";
	

	public static final String CLIENT_LIMIT = "Client";
	public static final String AVAIL_CLIENT_LIMIT = "Avail Client";
	
	
	public static final String ACCOUNT_LIMIT = "Account";
	public static final String AVAIL_ACCOUNT_LIMIT = "Avail Account";
	
	public static final String CARD_LIMIT = "Card";
	public static final String AVAIL_CARD_LIMIT = "Avail Card";	
	
	public static final String TEMPORARY_LIMIT = "Temporary [T]";
	public static final String PERMANENT_LIMIT = "Permanent [P]";	
	
	public static final String CREDIT_LIMIT_CHANGE_REQUEST = "226 - Credit limit Change Request";
	public static final String CREDIT_LIMIT_CHANGE_COMMERCIAL_CARDS = 	"227 - Credit limit Change Commercial Cards";
	
	public static final String DAILY = "Daily";
	public static final String PERIODIC = "Periodic";
	public static final String YEARLY = "Yearly";
	public static final String PERIODICITY = "Month [9]";
	public static final String PERIODICITY_MONTH = "12";
	public static final String TX_SUCESSFUL_MESSAGE = "000-Successful";
	public static final String PRE_AUTH = "Pre-Auth Completion";
	public static final String LIMIT_VALIDATION_PARAMETER = "Daily Velocity Utilized;Daily Amount Utilized;Periodic Velocity Utilized;Periodic Amount Utilized;Yearly Velocity Utilized;Yearly Amount Utilized";
	
	private ConstantData() {
	}

	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(ConstantData.class, name);
	}
}
