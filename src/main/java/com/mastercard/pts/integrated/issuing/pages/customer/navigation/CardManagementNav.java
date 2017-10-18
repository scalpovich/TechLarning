package com.mastercard.pts.integrated.issuing.pages.customer.navigation;

public class CardManagementNav {

	public static final String TAB_CARD_MANAGEMENT = "Card Management";

	public static final String L1_INSTITUTION_PARAMETER_SETUP = "ISR000";
	public static final String L1PROGRAM_SETUP = "ISS000";
	public static final String L1_ACTIVITY = "ISA000";
	public static final String L1_OPERATION = "ISO000";
	public static final String L1_SEARCH = "ISE000";
	public static final String L1_REPORTS = "ISRE00";

	public static final String L2_STATEMENT_MESSAGE_PLAN = "STMSG001";
	public static final String L2_MARKETING_MESSAGE_PLAN = "MKMSG001";
	public static final String L2_ACCOUNT_TYPE = "ISSS12";
	public static final String L2_EMBOSSING_PARAMETERS = "ISSM00";
	public static final String L2_BATCH_PROCESSING = "ISRC01";

	public static final String L2_PREPAID_STATEMENT_PLAN = "STPLN001";
	public static final String L2_TRANSACTION_PLAN = "TXP001";
	public static final String L2_TRANSACTION_LIMIT_PLAN = "TXLP001";
	public static final String L2_IPK_CERTIFICATE_INFORMATION = "ISSE02";

	public static final String L2_DEDUPE_PLAN = "DDPLN001";

	public static final String L2_MCC_RULES = "ISSD03";

	public static final String L2_WALLET_CONFIGURATION = "ISSW00";
	public static final String L2_PROGRAM = "PRMG001";
	public static final String L2_DEVICE_RANGE = "DVRNG001";

	public static final String L2_CUTOVERPROFILE = "ISSS03";
	public static final String L2_NETWORKMEMBERSHIP = "ISSS04";
	public static final String L2_TRANSACTIONREGISTRATION = "ISSS25";
	public static final String L2_INSTITUTIONCURRENCY = "ISSS05";
	public static final String L2_OFFICE = "ISSS06";
	public static final String L2_PLASTICCODE = "ISSS07";
	public static final String L2_PICTURECODE = "ISSS08";
	public static final String L2_DEVICEBIN = "ISSS09";
	public static final String L2_MCG = "ISS022";
	public static final String L2_VENDOR = "ISS023";
	public static final String L2_EVENTS = "ISSEA0";

	public static final String L3_WALLET_FEE_PLAN = "WLFEP001";

	public static final String L3_WALLET_PLAN = "WALLP001";

	public static final String L2_APPLICATION = "ISSC00";
	public static final String L3_DOCUMENT_CHECKLIST = "ISSADC";
	public static final String L3_BUSINESS_MANDATORY_FIELDS = "ISSBMF";

	public static final String L2_CREDIT_CARD = "ISSB00";
	public static final String L3_CREDIT_CARD_BILLING_CYCLE = "ISSBB0";
	public static final String L3_CREDIT_CARD_PAYMENT_PRIORITY = "ISSBPP";
	public static final String L3_CREDIT_CARD_PAYMENT_BOUNCE_REASON = "ISSBPB";
	public static final String L3_CREDIT_CARD_TRANSACTION_RULE_PLAN = "ISSBTR";
	public static final String L3_CREDIT_CARD_CREDIT_PLAN = "ISSBCP";
	public static final String L3_EVENTS_AND_ALERTS = "ISSEA1";

	// Device Configuration Tree Details
	public static final String L2_DEVICE_CONFIGURATION = "ISSD00";
	public static final String L3_DEVICE_JOINING_AND_MEMBERSHIP_FEE_PLAN = "ISW008";
	public static final String L3_DEVICE_EVENT_BASED_FEE_PLAN = "IS0005";
	public static final String L3_DEVICE_PRIORITYPASSID_CARDPACKID_TEMPLATE_PLAN = "ISS001";
	public static final String L3_DEVICE_PLAN = "ISW009";
	public static final String L3_EMBOSSING_TEMPLATE = "ISW013";
	// end

	// Activity --> Device
	public static final String L2_DEVICE = "ISAC00";
	public static final String L3_NEW_DEVICE = "ISAD0N";
	public static final String L3_DEVICE_PRODUCTION_BULK_DEVICE_REQUEST = "BLKDRQ01";
	public static final String L2_AUTHORIZATION = "ISAA00";
	public static final String L3REQUEST = "ISAA01";

	// Activity --> Transaction Management
	public static final String L2T_RANSACTION_MANAGEMENT = "ISATM0";
	public static final String L3_TRANSACTION = "ISAT00";
	public static final String L4_ADJUSTMENT_TRANSACTION = "ISATO1";

	// Operation -->Processing Batches
	public static final String L2_PROCESSING_BATCHES = "ISOPB0";
	public static final String L3_BULK_DEVICE_GENERATION_BATCH = "BLKDGN01";
	public static final String L3_PRE_PRODUCTION_BATCH = "PREPRD01";
	public static final String L3_DEVICE_PRODUCTION_BATCH = "DEVPRD01";
	public static final String L3_PIN_GENERATION_BATCH = "PINPRD01";
	public static final String L3PROCESS_BATCHES = "BATPRO01";

	// Search
	public static final String L2BATCH_TRACE_HISTORY = "SERA03";
	public static final String L2SEARCHAPPLICATION= "ISEAP0";
	

	// Host Accounting
	public static final String L2HOST_ACCOUNTING = "ISSHA01";
	public static final String L3ACCOUNT_HEAD = "ISSHA1";
	public static final String L3ACCOUNT_HEAD_MAPPING = "ISSHA3";
	public static final String L3ACCOUNT_MASTER = "ISSHA2";

	// Institution Parameter Setup --> HSM Keys
	public static final String L2HSM_KEYS = "ISSH00";
	public static final String L3DEVICE_KEYS = "ISSH01";
	public static final String L3NETWORK_KEYS = "ISSH02";

	// Institution Parameter Setup --> EMV
	public static final String L2EMV = "ISSE00";
	public static final String L3IPK_CERTIFICATE_INFORMATION = "ISSE02";
	public static final String L3MDK = "ISSE01";
	public static final String L3_MASTER_DERIVATION_KEYS_MDK = "ISSE01";

	
	//serach-->Application -->
	public static final String L3APPLICATIONDETAILS="ISEAPS";

	// Currency Exchange Rates
	public static final String L2CURRENCY_EXCHANGE_RATES = "ISS019";

	// Currency Exchange Rates
	public static final String L2CURRENCY_EXCHANGE_RATES_MAPPING = "ISS018";

	//Application 
		public static final String L2ACTIVITY_APPLICATION = "ISAP00";
		public static final String L3NEWDEVICE = "ISAP0N";
		public static final String L3_NEW_APPLCIATION = "ISAP0N";

	private CardManagementNav() {
	}

}
