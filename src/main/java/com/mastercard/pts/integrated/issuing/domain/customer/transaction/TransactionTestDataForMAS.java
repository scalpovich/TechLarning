package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class TransactionTestDataForMAS {

	public static final String MSR_PURCHASE = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800001 All Business Transactions>>002|Kapil MSR";
	
	public static final String MSR_CASH_WITHDRAWAL = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800001 All Business Transactions>>001|Kapil MSR"; 

	public static final String MSR_ATM_BALANCE_INQUIRY = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>009|Kapil MSR"; 
	
	public static final String MSR_POS_BALANCE_INQUIRY = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>019|Kapil MSR"; 
	
//	E-COMM transaction (DE 48.92 – CVV2)
	public static final String MSR_ECOMMERCE = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>014|Kapil MSR";
	
	public static final String MSR_CASH_ADVANCE = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>001|Kapil MSR"; 

	public static final String EMV_PURCHASE = "CITR>>Issuer MasterCard and Debit MasterCard>>ICC Base>>Table 850001 All Business Transactions>>002|Kapil EMV";
	
	public static final String EMV_CASH_WITHDRAWAL = "CITR>>Issuer MasterCard and Debit MasterCard>>ICC Base>>Table 850001 All Business Transactions>>001|Kapil EMV"; 

	public static final String EMV_ATM_BALANCE_INQUIRY= "CITR>>Issuer MasterCard and Debit MasterCard>>ICC Product and Services>>Table 850101 Balance Inquiry>>001|Kapil EMV"; 

	public static final String EMV_POS_BALANCE_INQUIRY = "CITR>>Issuer MasterCard and Debit MasterCard>>ICC Product and Services>>Table 850101 Balance Inquiry>>002|Kapil EMV"; 

//	E-COMM transaction (DE 48.92 – CVV2)
	public static final String EMV_ECOMMERCE = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>014|Kapil EMV"; 

	public static final String EMV_CASH_ADVANCE = "CITR>>Issuer MasterCard and Debit MasterCard>>MSR Base>>Table 0800000 MasterCard 2 Series BIN Range>>001|Kapil EMV"; 


	private TransactionTestDataForMAS() {}

	public static String getTestCase(String name) {
		try
		{
			return (String) TransactionTestDataForMAS.class.getField(name).get(null);
		}
		catch(Exception e)
		{
			MiscUtils.propagate(e);
			return null;
		}
	}
}
