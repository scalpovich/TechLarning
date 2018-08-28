package com.mastercard.pts.integrated.issuing.domain.customer.helpdesk;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

@Component
public class HelpdeskGeneral {
	private static final String CS_SERVICE_CODE = "CS_SERVICE_CODE";
	private static final String CS_SERVICE_DESCRIPTION = "CS_SERVICE_DESCRIPTION";
	private static final String CURRENCY_SETUP_SERVICE_CODE = "CURRENCY_SETUP_SERVICE_CODE";
	private static final String HD_CURRENCY_WITH_PRIORITY = "HD_CURRENCY_WITH_PRIORITY";
	private static final String TRANSACTION_DETAILS = "TRANSACTION_DETAILS";
	private static final String INITIAL_LOAD_TXN_DETAILS = "INITIAL_LOAD_TXN_DETAILS";
	private static final String NEW_EMAIL_ID = "NEW_EMAIL_ID";
	private static final String NEW_MOBILE_NO = "NEW_MOBILE_NO";
	private static final String NEW_MOBILE_ISD = "NEW_MOBILE_ISD";
	private static final String DEVICE_NUMBER = "DEVICE_NUMBER";
	private static final String PRODUCT_TYPE = "PRODUCT_TYPE";
	private static final String LIMIT_TYPE = "LIMIT_TYPE";
	private static final String CLIENT_CREDIT_LIMIT = "CLIENT_CREDIT_LIMIT";
	private static final String ACCOUNT_CREDIT_LIMIT = "ACCOUNT_CREDIT_LIMIT";
	private static final String NEW_CREDIT_LIMIT = "NEW_CREDIT_LIMIT";
	private static final String LIMIT_TYPE_STATUS="LIMIT_TYPE_STATUS";
	private static final String AVAILABLE_BALANCE="AVAILABLE_BALANCE";

	private String availableBalance;
	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	private String transactionNote;
	private String initialLoadTxnDetails;
	private String transactionDetails;
	private String productType;
	private String cardPackId;
	private String serviceCode;
	private String serviceDescription;
	private String notes;
	private String deviceNumber;
	private String currencySetupServiceCode;
	private String currencyWithPriority;
	private String newWalletNumber;
	private String newEmailID;
	private String newMobileNo;
	private String newMobileISD;
	private String defaultWalletNumber;
	private String limitType;
	private String limitTypeStatus;
	private String clientCreditLimit;
	private String accountCreditLimit; 
	private String newCreditLimit;


	public String getLimittypestatus() {
		return limitTypeStatus;
	}

	public void setLimittypestatus(String limittypestatus) {
		this.limitTypeStatus = limitTypeStatus;
	}

	public String getClientCreditLimit() {
		return clientCreditLimit;
	}

	public void setClientCreditLimit(String clientCreditLimit) {
		this.clientCreditLimit = clientCreditLimit;
	}

	public String getAccountCreditLimit() {
		return accountCreditLimit;
	}

	public void setAccountCreditLimit(String accountCreditLimit) {
		this.accountCreditLimit = accountCreditLimit;
	}

	public String getNewCreditLimit() {
		return newCreditLimit;
	}

	public void setNewCreditLimit(String newCreditLimit) {
		this.newCreditLimit = newCreditLimit;
	}

	public static HelpdeskGeneral createWithProvider(KeyValueProvider provider) {
		HelpdeskGeneral plan = new HelpdeskGeneral();
		plan.setServiceCode(provider.getString(CS_SERVICE_CODE));
		plan.setCurrencySetupServiceCode(provider.getString(CURRENCY_SETUP_SERVICE_CODE));
		plan.setCurrencyWithPriority(provider.getString(HD_CURRENCY_WITH_PRIORITY));
		plan.setTransactionDetails(provider.getString(TRANSACTION_DETAILS));
		plan.setInitialLoadTxnDetails(provider.getString(INITIAL_LOAD_TXN_DETAILS));
		plan.setNotes(ConstantData.GENERIC_DESCRIPTION);
		if (provider.getString(PRODUCT_TYPE).equals(ProductType.CREDIT)) {
			plan.setProductType(provider.getString(PRODUCT_TYPE));
		} else {
			plan.setProductType(ProductType.PREPAID);
		}
		plan.setLimitType(provider.getString(LIMIT_TYPE));
		plan.setLimittypestatus(provider.getString(LIMIT_TYPE_STATUS));
		plan.setClientCreditLimit(provider.getString(CLIENT_CREDIT_LIMIT));
		plan.setAccountCreditLimit(provider.getString(ACCOUNT_CREDIT_LIMIT));
		plan.setNewCreditLimit(provider.getString(NEW_CREDIT_LIMIT));
		plan.setNewEmailID(provider.getString(NEW_EMAIL_ID));
		plan.setNewMobileNo(provider.getString(NEW_MOBILE_NO));
		plan.setNewMobileISD(provider.getString(NEW_MOBILE_ISD));
		plan.setDeviceNumber(provider.getString(DEVICE_NUMBER));
		plan.setAvailableBalance(provider.getString(AVAILABLE_BALANCE));
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

	public String getDefaultWalletNumber() {
		return defaultWalletNumber;
	}

	public void setDefaultWalletNumber(String defaultWalletNumber) {
		this.defaultWalletNumber = defaultWalletNumber;
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

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public String getNewEmailID() {
		return newEmailID;
	}

	public void setNewEmailID(String newEmailID) {
		this.newEmailID = newEmailID;
	}

	public String getNewMobileNo() {
		return newMobileNo;
	}

	public void setNewMobileNo(String newMobileNo) {
		this.newMobileNo = newMobileNo;
	}

	public String getNewMobileISD() {
		return newMobileISD;
	}

	public void setNewMobileISD(String newMobileISD) {
		this.newMobileISD = newMobileISD;
	}

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	@Override
	public String toString() {
		return "HelpdeskGeneral [productType=" + productType + ", cardPackId=" + cardPackId + ", serviceCode=" + serviceCode + ", notes=" + notes + ", deviceNumber=" + deviceNumber + "]";
	}
}
