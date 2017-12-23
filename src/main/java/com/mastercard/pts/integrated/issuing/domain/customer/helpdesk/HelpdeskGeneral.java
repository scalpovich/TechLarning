package com.mastercard.pts.integrated.issuing.domain.customer.helpdesk;

import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class HelpdeskGeneral {
	private static final String CS_SERVICE_CODE = "CS_SERVICE_CODE";
	private static final String CURRENCY_SETUP_SERVICE_CODE = "CURRENCY_SETUP_SERVICE_CODE";
	private static final String HD_CURRENCY_WITH_PRIORITY = "HD_CURRENCY_WITH_PRIORITY";
	private static final String TRANSACTION_DETAILS = "TRANSACTION_DETAILS";
	private static final String INITIAL_LOAD_TXN_DETAILS = "INITIAL_LOAD_TXN_DETAILS";
	private static final String TRANSACTION_NOTE ="TRANSACTION_NOTE";
	private String transactionNote;
	private String initialLoadTxnDetails;
	private String transactionDetails;
	private String productType;
	private String cardPackId;
	private String serviceCode;
	private String notes;
	private String deviceNumber;
	private String currencySetupServiceCode;
	private String currencyWithPriority;
	private String newWalletNumber;
	
	public static HelpdeskGeneral createWithProvider(KeyValueProvider provider) {
		HelpdeskGeneral plan = new HelpdeskGeneral();
		plan.setServiceCode(provider.getString(CS_SERVICE_CODE));
		plan.setCurrencySetupServiceCode(provider.getString(CURRENCY_SETUP_SERVICE_CODE));
		plan.setCurrencyWithPriority(provider.getString(HD_CURRENCY_WITH_PRIORITY));
		plan.setTransactionDetails(provider.getString(TRANSACTION_DETAILS));
		plan.setInitialLoadTxnDetails(provider.getString(INITIAL_LOAD_TXN_DETAILS));
		plan.setNotes(ConstantData.GENERIC_DESCRIPTION);
		plan.setProductType(ProductType.PREPAID);
		plan.setProductType(provider.getString(TRANSACTION_NOTE));		
		return plan;
	}
	
	public String getNewWalletNumber() {
		return newWalletNumber;
	}
	
	public void setNewWalletNumber(String newWalletNumber) {
		this.newWalletNumber = newWalletNumber;
	}
	
	public String getInitialLoadTxnDetails() {
		return initialLoadTxnDetails;
	}

	public void setInitialLoadTxnDetails(String initialLoadTxnDetails) {
		this.initialLoadTxnDetails = initialLoadTxnDetails;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	
	public String getTransactionNote() {
		return transactionNote;
	}

	public void setTransactionNote(String transactionNote) {
		this.transactionNote = transactionNote;
	}
	
	public String getCurrencySetupServiceCode() {
		return currencySetupServiceCode;
	}

	public void setCurrencySetupServiceCode(String currencySetupServiceCode) {
		this.currencySetupServiceCode = currencySetupServiceCode;
	}

	public String getCurrencyWithPriority() {
		return currencyWithPriority;
	}

	public void setCurrencyWithPriority(String currencyWithPriority) {
		this.currencyWithPriority = currencyWithPriority;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCardPackId() {
		return cardPackId;
	}

	public void setCardPackId(String lastCardPackId) {
		this.cardPackId = lastCardPackId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Override
	public String toString() {
		return "HelpdeskGeneral [productType=" + productType + ", cardPackId="
				+ cardPackId + ", serviceCode=" + serviceCode + ", notes="
				+ notes + ", deviceNumber=" + deviceNumber + "]";
	}
}
