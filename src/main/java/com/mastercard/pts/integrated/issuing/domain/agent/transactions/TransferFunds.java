package com.mastercard.pts.integrated.issuing.domain.agent.transactions;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class TransferFunds {

	private static final String TRANSFER_DETAILS="TRANSFER_DETAILS";
	private static final String TRANSFER_AMOUNT = "TRANSFER_AMOUNT";
	private static final String MOBILE_NUMBER = "MOBILE_NUMBER";
	private static final String BENEFICIERY_NAME = "BENEFICIERY_NAME";
	private static final String CURRENCY = "CURRENCY";
	private static final String MEMO = "MEMO";
			
	private String transactionAmount;
	private String selectedWalletCurrencyCode;
	private String beneficiaryName;
	private String contactNumber;
	private String memo;
	private String transaferThrough;
	private String transferDetails;	
	
	public static TransferFunds createWithProvider(KeyValueProvider provider) {
		TransferFunds transaferFund = new TransferFunds();
		transaferFund.setTransferDetails(provider.getString(TRANSFER_DETAILS));
		transaferFund.setContactNumber(""+MiscUtils.randomNumber(5)+""+MiscUtils.randomNumber(5));
		return transaferFund;
	}
	
		
	public String getTransferDetails() {
		return transferDetails;
	}

	public void setTransferDetails(String transferDetails) {
		this.transferDetails = transferDetails;
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getSelectedWalletCurrencyCode() {
		return selectedWalletCurrencyCode;
	}

	public void setSelectedWalletCurrencyCode(String selectedWalletCurrencyCode) {
		this.selectedWalletCurrencyCode = selectedWalletCurrencyCode;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getTransaferThrough() {
		return transaferThrough;
	}

	public void setTransaferThrough(String transaferThrough) {
		this.transaferThrough = transaferThrough;
	}		
	
	
	
}
