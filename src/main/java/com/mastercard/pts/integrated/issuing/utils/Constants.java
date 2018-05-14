package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final String Record_Added_Successfully = "Record Added Successfully.";

	public static final String Record_Cannot_Be_Added_NetworkMemberShip = "Network Membership already exists for selected network with logged in Institution.";

	public static final String Record_Updated_Successfully = "Record Updated Successfully.";

	public static final String Record_SAVED_Successfully = "Records saved successfully.";

	public static final String Record_Cannot_Be_deleted = "Plan is attached to Device Range. Cannot delete record";
	public static final String ADD_USER = "Add User";
	public static final String ADD_LOYALTY_PROMOTION_MAPPING = "Add Loyalty Plan & Promotion Mapping";
	public static final String EDIT_PROGRAM_FRAME = "Edit Program";

	public static final String EDIT_DEVICE_RANGE_FRAME = "Edit Device Range";
	public static String BATCH_NAME = "Device Production";

	public static String EDIT_BATCH_DEFINITION = "Edit Batch Definition";

	public static String Balance_Inquiry_String = "Balance Inquiry";

	public static String Balance_Inquiry_Code = "31";

	public static String Purchase_Auth_String = "Purchase/Auth Completion";

	public static String Purchase_Auth_Code = "01";

	public static String Product_Type_Debit = "Debit [D]";

	public static String Product_Type_Prepaid = "Prepaid [P]";

	public static String Legal_Id_String = "LEGAL_ID [LEGAL_ID]";

	public static String ADD_DEVICE_PRIORITYPASS_CARDPACKID_TEMPLATE_FRAME = "Add Device, Priority Pass ID, Card Pack ID Template";

	public static String Filler_String = "FILLER";

	public static String Delimiter_String = "DELIMITER LINE [DELIMITER]";

	public static String StaticVirtualCard_String = "Static Virtual Card [7]";

	public static String LimitedValidityVirtualCard_String = "Limited Validity Virtual Card [8]";

	public static String EmvCard_String = "EMV Card [2]";

	public static String ADD_CUTOVER_PROFILE_FRAME = "Add Cutover Profile";

	public static String ADD_NETWORK_MEMBERSHIP_FRAME = "Add Network Membership";

	public static String EDIT_NETWORK_MEMBERSHIP_FRAME = "Edit Network Membership";

	public static String EDIT_NETWORK_FRAME = "Edit Network";

	public static String ADD_EMBOSS_TEMPLATE_FRAME = "Add Embossing, PIN and Priority Pass File Template";

	public static String ADD_RECORD_FIELD_FORMAT_FRAME = "Add Record Field Format";

	public static String ADD_ORDER_FIELD_FORMAT_FRAME = "Add Order Field Format";

	public static String EDIT_EMBOSS_TEMPLATE_FRAME = "Edit Embossing, PIN and Priority Pass File Template";

	public static String ADD_EMBOSS_PRIORITY_PASS_FRAME = "Add Embossing ,PIN & Priority Pass File Name Parameter";

	public static String ADD_VENDOR_MASTER_FRAME = "Add Vendor Master";

	public static String ADD_DEVICE_PLAN_FRAME = "Add Device Plan";

	public static String EDIT_DEVICE_PLAN_FRAME = "Edit Device BIN";

	public static String EDIT_DEVICE_PLAN = "Edit Device Plan";

	public static String ADD_PROGRAM_FRAME = "Add Program";

	public static String ADD_DEVICE_RANGE_FRAME = "Add Device Range";

	public static String ADD_BULK_DEVICE_REQUEST_FRAME = "Add Bulk Device Request";

	public static String ADD_NEW_DEVICE_FRAME = "Add Device";

	public static String ADD_DEVICE_BIN_FRAME = "Add Device BIN";

	public static String ADD_MCG_FRAME = "Add MCG";

	public static String ADD_DEDUPE_PLAN_FRAME = "Add Dedupe Plan";

	public static String ADD_STATEMENT_MESSAGE_PLAN_FRAME = "Add Statement Message Plan";

	public static String ADD_STATEMENT_MESSAGE_DETAILS_FRAME = "Add Statement Message Details";

	public static String ADD_MARKETING_MESSAGE_PLAN_FRAME = "Add Marketing Message Plan";

	public static String ADD_MARKETING_MESSAGE_DETAILS_FRAME = "Add Marketing Message Details";

	public static String ADD_PREPAID_STATEMENT_FRAME = "Add Prepaid Statement Plan";

	public static String ADD_PREPAID_STATEMENT_PLAN_FRAME = "Add Prepaid Statement Plan Details";

	public static String ADD_TRANSACTION_PLAN_FRAME = "Add Transaction Plan";

	public static String ADD_TRANSACTION_LIMIT_PLAN_FRAME = "Add Transaction Limit Plan";

	public static String ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME = "Add Transaction Limit Plan Detail";

	public static String ADD_DOCUMENT_CHECKLIST_FRAME = "Add Document Checklist";

	public static String ADD_DOCUMENT_CHECKLIST_DETAILS_FRAME = "Add Document Checklist Details";

	public static String ADD_BUSINESS_MANDATORY_FRAME = "Add Business Mandatory Fields";

	public static String ADD_BUSINESS_MANDATORY_DETAILS_FRAME = "Add Business Mandatory Fields Details";

	public static String ADD_DEVICE_JOINING_PLAN_FRAME = "Add Device Joining Or Membership Fee Plan";

	public static String ADD_DEVICE_JOINING_PLAN_DETAILS_FRAME = "Add Device Joining And Membership Fee Plan Details";

	public static String ADD_DEVICE_EVENT_BASED_FEE_FRAME = "Add Device Event Based Fee Plan";

	public static String ADD_DEVICE_EVENT_BASED_FEE_DETAILS_FRAME = "Add Device Event Based Fee Plan Details";

	public static String ADD_WALLET_PLAN_FRAME = "Add Wallet Plan";

	public static String ADD_FEE_WALLET_PLAN_FRAME = "Add Wallet Fee Plan";

	public static String ADD_WALLET_FEE_PLAN_DETAILS_FRAME = "Add Wallet Fee Plan Details";

	public static Map<String, String> variable = new HashMap<>();

	public static String VIEW_TRANSACTION_TYPE_FRAME = "View Transaction Type";

	public static String ADD_ADD_INSTITUTION_FRAME = "Add Institution";
	
	public static final String EDIT_INSTITUTION_FRAME = "Edit Institution";

	public static String ADD_ACCOUNT_MASTER_FRAME = "Add Account Master";

	public static String EDIT_ACCOUNT_MASTER_FRAME = "Edit Account Master";

	public static String ADD_ACCOUNT_HEAD_FRAME = "Add Account Head";

	public static String EDIT_ACCOUNT_HEAD_FRAME = "Edit Account Head";

	public static String ADD_ACCOUNT_HEAD_MAPPING_FRAME = "Add Account Head Mapping";

	public static String EDIT_ACCOUNT_HEAD_MAPPING_FRAME = "Edit Account Head Mapping";

	public static String EmbossingPriorityPass_fileType = "Priority Pass Template [P]";

	public static String ADD_INSTITUTION_CURRENCY_FRAME = "Add Institution Currency";

	public static String ADD_OFFICE_FRAME = "Add Office";

	public static String ADD_PLASTIC_CODE_FRAME = "Add Plastic Code";

	public static String ADD_PICTURE_CODE_FRAME = "Add Picture Code";

	public static String CCSVALUE_MANDATORY_FIELD = "border-left-color";

	public static String RBGVALUE_RED = "rgba(255, 0, 0, 1)";

	private static String instituteName;

	public static String getInstituteName() {
		return instituteName;
	}

	public static void setInstituteName(String instituteName) {
		Constants.instituteName = instituteName;
	}

	public static String CARD_HOLDER_ACTIVITY_AND_ISSUER_BIN = "I. Cardholder Activity Issuer Bin";

	public static String CHARGED_OFF_LOSSES = "II. Charged-Off Losses";

	public static String CARD_FEATURE_DETAILS = "III. Card Feature Details";

	public static String PURCHASE_TRANSACTIONS_VOLUME = "A. Purchases Transactions Volume";

	public static String CASH_DISBERSEMENTS = "B. Cash Disbursements";

	public static String REFUND_RETURN_CREDITS = "C. Refunds / Returns / Credits";

	public static String ACCOUNT_CARDS_OPEN_BLOCKED_TOTAL = "D. Accounts/ Cards Open Blocked Total";

	public static String CREDIT_LOSSES = "A. Credit Losses (excluding bankruptcy losses)";

	public static String BANKRUPTCY_LOSSES = "B. Bankruptcy Losses";

	public static String FRAUD_LOSSES = "C. Fraud Losses (including counterfeit losses)";

	public static String OTHER_LOSSES = "D. Other Losses";

	public static String TOTAL_CHARGED_OFF_LOSSES = "E. Total Charged-Off Losses";

	public static String CASH_DISBURSEMENT_BREAKDOWN = "Breakdown of Cash Disbursements";

	public static String DOMESTIC_ONUS_1 = "1. Domestic On-us";

	public static String DOMESTIC_OTHER_BRAND_1 = "2. Domestic Other Brand / Non-MasterCard Processed";

	public static String DOMESTIC_INTERCHANGE_1 = "3. Domestic Interchange";

	public static String INTERNATIONAL_1 = "4. International";

	public static String TOTAL_1 = "5. Total (A1+A2+A3+A4)";

	public static String DOMESTIC_ONUS_2 = "1. Domestic On-us";

	public static String DOMESTIC_OTHER_BRAND_2 = "2. Domestic Other Brand / Non-MasterCard Processed";

	public static String DOMESTIC_INTERCHANGE_2 = "3. Domestic Interchange";

	public static String INTERNATIONAL_2 = "4. International";

	public static String TOTAL_2 = "5. Total (B1+B2+B3+B4)";

	public static String DOMESTIC_ONUS_3 = "1. Domestic On-us";

	public static String DOMESTIC_OTHER_BRAND_3 = "2. Domestic Other Brand / Non-MasterCard Processed";

	public static String DOMESTIC_INTERCHANGE_3 = "3. Domestic Interchange";

	public static String INTERNATIONAL_3 = "4. International";

	public static String TOTAL_3 = "5. Total (C1+C2+C3+C4)";

	public static String ACCOUNT_AT_QUARTER_BEGINING = "1. Accounts at beginning of quarter";

	public static String NEW_ACCOUNTS_DURING_QUARTER = "2. New accounts obtained during quarter";

	public static String ACCOUNTS_TERMINATED_DURING_QUARTER = "3.Accounts terminated during quarter";

	public static String ACCOUNTS_AT_END_OF_QUARTER = "4. Accounts at end of quarter";

	public static String ACCOUNTS_WITH_ATLEAST_ONE_TRN_DURING_QUARTER = "5. Accounts with at least one transaction during quarter";

	public static String CARDS_AT_QUARTER_BEGINNING = "6. Cards at beginning of quarter";

	public static String NEW_CARDS = "7. New Cards";

	public static String CARDS_AT_QUARTER_END = "8. Cards at end of quarter";

	public static String CARDS_WITH_CURRUS_LOGO_AT_QUARTER_END = "9. Cards with Cirrus logo at end of quarter";

	public static String CARDS_WITH_MAESTRO_LOGO = "10. Cards with Maestro logo";

	public static String CARDS_WITH_ATLEAST_ONE_TRANS_PER_QUARTER = "11. Cards with at least one transaction during quarter";

	public static String CARDS_IN_REWARDS_PROGRAM = "12. Cards participating in a rewards program";

	public static String GROSS_CREDIT_LOSSES = "1. Gross Credit Losses";

	public static String RECOVERY_OF_CREDIT_LOSSES = "2. Recovery of Credit Losses";

	public static String NET_CREDIT_LOSSES = "3. Net Credit Losses (A1-A2)";

	public static String GROSS_BANKRUPTCY_LOSSES = "1. Gross Bankruptcy Losses";

	public static String RECOVERY_OF_BANKRUPTCY_CHARGES = "2. Recovery of Bankruptcy Losses";

	public static String NET_BANKRUPTCY_CHARGES = "3. Net Bankruptcy Losses (B1-B2)";

	public static String GROSS_FRAUD_LOSSES = "1. Gross Fraud Losses";

	public static String RECOVERY_OF_FRAUD_LOSSES = "2. Recovery of Fraud Losses";

	public static String NET_FRAUD_LOSSES = "3. Net Fraud Losses (C1-C2)";

	public static String GROSS_OTHER_LOSSES = "1. Gross Other Losses";

	public static String RECOVERY_OF_OTHER_LOSES = "2. Recovery of Other Losses";

	public static String NET_OTHER_LOSSES = "3. Net Other Losses (D1-D2)";

	public static String TOTAL_GROSS_CHARGED_OFF_LOSSES = "1. Total Gross Charged-Off Losses (A1+B1+C1+D1)";

	public static String TOTAL_RECOVERY_OF_CHARGED_OFF_LOSSES = "2. Total Recovery of Charged-Off Losses (A2+B2+C2+D2)";

	public static String TOTAL_NET_CHARGED_OFF_LOSSES = "3. Total Net Charged-Off Losses (E1-E2)";

	public static String BREAKOUT_OF_EMV_COMPLIANT_CHIPS = "1. Breakout of EMV-compliant Chip-enabled Cards";

	public static String OFFLINE_PIN_CAPABILITY = "1a. Of which there is offline PIN capability";

	public static String PAYPASS_ENABLED = "1b. Of which are PayPass-enabled";

	public static String DIPPED_TRANSACTIONS = "2. DIPPED Transactions / Volume on EMV-compliant Chip-enabled Cards";

	public static String TOTAL_MASTERCARD_CONTACTLESS_CARDS = "3.Total MasterCard contactless Cards issued (physical plastic cards only)";

	public static String ATM_CASH_DISBURSEMENTS = "a. ATM Cash Disbursements";

	public static String TELLER_CASH_DISBURSEMENTS = "b. Teller Cash Disbursements";

	public static String CONVENIENCE_CHECKS = "c. Convenience Checks";

	public static String BALANCE_TRANSFERS = "d. Balance Transfers";

	public static String VIEW_BATCH_DETAILS_FRAME = "View Batch Details";

	public static String TRANSACTION_AMOUNT = "Transaction Amount";

	public static String TRANSACTION_COUNT = "Transaction Count";

	public static String OPEN = "Open";

	public static String TEMPORARILY_BLOCKED = "Temporarily Blocked";

	public static String TOTAL = "Total";

	public static String ACCOUNTS = "Accounts";

	public static String BALANCES = "Balances";

	public static String CARDS = "Cards";

	// Events and Alerts

	public static String ACTIVATE_DEVICE = "108 - Activate Device";

	public static String EMAIL_SMS_ACTIVE_DEACTIVE = "477 - Email/SMS Alert Change Request";

	public static String LINK_CARD_QUERY = "203 - Link Card Query";

	public static String DO_NOT_CALL_REGISTER = "106 - Do Not Call Register Request";

	public static String ADD_CALL_NOTES = "456 - Add Call Notes";

	public static String ADD_ON_CARD = "102 - Add-on Card Request";

	public static String CHANGE_ADDRESS_REQUEST = "104 - Change Address Request";

	public static String E_COMMERCE_ACTIVATE_DEACTIVATE = "304 - E-commerce Activation/Deactivation";

	final public static String RETURN_OPERATION = "return";

	final public static String APPROVE_OPERATION = "approve";

	final public static String RETURN_MAKER_OPERATION = "return_maker";

	final public static String APPROVE_MAKER_OPERATION = "approve_maker";

	final public static String COMPARE_RETURN_OPERATION = "compare_return";

	final public static String BOTH_PRIVILEGE_OPERATION = "both_privilege";

	final public static String DELETE_PRODUCTION_OPERATION = "delete_production";

	public static String EDIT_RUPAY_SETTLEMENT_BIN = "Edit RuPay Settlement BIN";

	public static String APPROVE_FROM_CHECKER = "Approve from Checker";

	public static String VIEW_FIELD_DIFFERENCE = "View Field Difference";

	public static String ADD_MEMBER_FUND_FRAME = "Add Member Fund Collection and Fund Disbursement";

	public static String ADD_DEVICE_KEYS_FRAME = "Add Device Keys";

	public static String ADD_NETWORK_KEYS_FRAME = "Add Network Key";

	public static String ADD_MDK_KEY_FRAME = "Add MDK Key";

	public static final String UPLOAD_FILE_PATH = "/home/dc-user/integrated/elt_bo/data/102030/RUPAY_INCOMING";

	public static final String APPLICATION_UPLOAD_PREPAID_FILE_PATH = "/home/dc-user/integrated/elt_bo/data/121212/input";

	public static final String APPLICATION_UPLOAD_CREDIT_FILE_PATH = "/home/dc-user/integrated/elt_bo/data/554466/INPUT";

	public static final String GENERIC_DESCRIPTION = "AUTOMATION";

	public static final String SUCCESS_MESSAGE = "rgba(0, 128, 0, 1)";

	public static final String CREDIT = "credit";

	public static final String PREPAID = "prepaid";

	public static final String DEBIT = "debit";

	public static final String ALL = "All";

	public static String ADD_APPLICATION_SCREEN = "Add Application";

	public static String CURRENCY_SETUP_FRAME = "312 - Currency Setup";

	public static String FromDevice = "0000";

	public static String ToDevice = "9999";

	public static final String ADD_CURRENCY_EXCHANGE_RATE_FRAME = "Add Currency Exchange Rate";
	public static final String ADD_SURCHARGE_WAIVER_FEE_PLAN = "Add Surcharge Waiver Plan ";

	public static final String ADD_CURRENCY_EXCHANGE_RATE_MAPPING_FRAME = "Add Currency Exchange Rates Mapping";

	public static final String UPLOAD_FILE_PATH_EXCHANGE_RATE = "/home/dc-user/integrated/elt_bo/data/123456/CURRENCY_EXC_RATE_UPLOAD/INPUT";

	public static final String UPLOAD_FILE_PATH_EXCHANGE_RATE_MC = "/home/dc-user/integrated/elt_bo/data/123456/MASTER_CURR_EXC_RATE/INPUT";

	public static final String VIEW_BATCH_DETAILS = "View Batch Details";

	public static final String TROUBLESHOOTING_TRACES = "Troubleshooting Traces";

	public static final String ADD_GROUPS = "Add Groups";

	public static final String EDIT_GROUPS = "Edit Groups";

	public static final String ASSIGN_PRODUCT = "Add Assign Product";

	public static final String ADD_SERVICE_CODE = "Add User Service Code";

	public static final String ADD_IPK_FRAME = "Add Ipk Certificate Information";

	public static final String PERSON_NAME = "Murari";

	public static final String PHONE_NUMBER = "123654799";

	public static final String JOINING_ISSUANCE_FEE = "Joining/Issuance";

	public static final String MEMBERSHIP_FEE = "Membership";

	public static final String ACCOUNTTYPE_SAVINGS = "Saving Account";
	public static final String STATEMENT_PLAN = "Statement Plan";
	public static final String ADD_SURCHARGE_WAIVER_PLAN_DETAIL = "Add Surcharge Waiver Plan Detail";
	public static final String MARKETING_PLAN = "Marketing Message Plan";
	public static final String WAIVERPLAN_CODE_ERRMSG = "[A-Z 0-9] and underscore are allowed and must start and end with an alphanumeric character.";
	public static final String WAIVERPLAN_DESC_ERRMSG = "[a-z A-Z 0-9], SPACES and special characters [.,&#:*()-] are allowed and must start with an alphanumeric.";

	public static String DATA_DRIVEN_CARD_BOARDING = "NO";
	public static final String ENVIRONMENT = "automation";
	public static final String COLUMN_NAME = "Status";
	public static final int TABLE_ROW_NUM = 1;
	public static final String ADD_ALLOWED_LOAD_CURRENCY = "Add Allowed Load Currency";
	public static final String ADD_MANUAL_ALERTS = "Add Manual Alert";
	public static final String ADD_MANUAL_RECIPIENT = "Add Manual Recipient";
	public static final String ADD_TRANSACTION_ROUTING = "Add Transaction Routing";
	public static final String ADD_CHANNEL_ROUTING = "Add Channel Routing Plan";
	public static final String ADD_CHANNEL_ROUTING_DETAILS = "Add Channel Routing Plan Detail";
	public static final String ADD_ACCOUNT_ROUTING_PLAN = "Add Account Range Routing";
	public static final String ADD_LINK_API = "Add Link API to institution";
	public static final String ADD_AGGREGATE_LOAD_LIMIT = "Add Aggregate Load Limits";
	public static final String ADD_EASY_PAY_PLAN_RULE= "Add Easy Pay Plan Rule";
	public static final String ADD_RULE= "Add Rules";
	
	public static final String BLOCK_DEVICE = "Blocking the device";
	public static final String UNBLOCK_DEVICE = "Unblocking the device";
	

}