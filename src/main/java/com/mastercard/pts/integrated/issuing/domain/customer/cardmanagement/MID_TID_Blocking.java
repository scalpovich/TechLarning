package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class MID_TID_Blocking {
	
	
	
	private final static String NETWORK 						= "NETWORK";
	private final static String PRODUCT_TYPE 					= "PRODUCT_TYPE";
	private final static String TERMINAL_ID 					= "TERMINAL_ID";
	private final static String MERCHANT_ID 					= "MERCHANT_ID";
	private final static String MCC_CODE_VALUE 					= "MCC_CODE_VALUE";
	private final static String ACQUIRING_COUNTRY_CODE 			= "ACQUIRING_COUNTRY_CODE";
	private final static String ACQUIRER_ID 				    = "ACQUIRER_ID";
	private final static String TRASACTION_CURRENCY 			= "TRANSACTION_CURRENCY";
	private final static String CARD_HOLDER_PRESENCE_INDICATOR 	= "CARD_HOLDER_PRESENCE_INDICATOR";
	private final static String CARD_PRESENCE_INDICATOR 		= "CARD_PRESENCE_INDICATOR";
	private final static String POS_ENTRY_MODE 					= "POS_ENTRY_MODE";

	private String network;
	private String productType;
	private String terminalID;
	private String merchantID;
	private String mcc;
	private String acquiringCountryCode;
	private String acquirerID;
	private String transactionCurrency;
	private String cardholderPresenceIndicator;
	private String cardPresenceIndicator;
	private String posEntryMode;
	
	
	public static MID_TID_Blocking createWithProvider(KeyValueProvider provider){
		MID_TID_Blocking plan = new MID_TID_Blocking();
		plan.setNetwork(provider.getString(NETWORK));
		plan.setProductType(provider.getString(PRODUCT_TYPE));
		plan.setTerminalID(provider.getString(TERMINAL_ID));
		plan.setMerchantID(String.valueOf(MiscUtils.randomNumber(16)));
		plan.setMcc(provider.getString(MCC_CODE_VALUE));
		plan.setAcquiringCountryCode(provider.getString(ACQUIRING_COUNTRY_CODE));
		plan.setAcquirerID(provider.getString(ACQUIRER_ID));
		plan.setTransactionCurrency(provider.getString(TRASACTION_CURRENCY));
		plan.setCardholderPresenceIndicator(provider.getString(CARD_HOLDER_PRESENCE_INDICATOR));
		plan.setCardPresenceIndicator(provider.getString(CARD_PRESENCE_INDICATOR));
		plan.setPosEntryMode(provider.getString(POS_ENTRY_MODE));
		return plan;
	}
	
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTerminalID() {
		return terminalID;
	}
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getAcquiringCountryCode() {
		return acquiringCountryCode;
	}
	public void setAcquiringCountryCode(String acquiringCountryCode) {
		this.acquiringCountryCode = acquiringCountryCode;
	}
	public String getAcquirerID() {
		return acquirerID;
	}
	public void setAcquirerID(String acquirerID) {
		this.acquirerID = acquirerID;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getCardholderPresenceIndicator() {
		return cardholderPresenceIndicator;
	}
	public void setCardholderPresenceIndicator(String cardholderPresenceIndicator) {
		this.cardholderPresenceIndicator = cardholderPresenceIndicator;
	}
	public String getCardPresenceIndicator() {
		return cardPresenceIndicator;
	}
	public void setCardPresenceIndicator(String cardPresenceIndicator) {
		this.cardPresenceIndicator = cardPresenceIndicator;
	}
	public String getPosEntryMode() {
		return posEntryMode;
	}
	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}
	
}
