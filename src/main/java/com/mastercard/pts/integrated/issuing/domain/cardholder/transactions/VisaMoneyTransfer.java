package com.mastercard.pts.integrated.issuing.domain.cardholder.transactions;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class VisaMoneyTransfer {

	private static final String BENEFICIARY_CARD_NUMBER = "BENEFICIARY_CARD_NUMBER";

	private static final String TRANSFER_AMOUNT = "TRANSFER_AMOUNT";

	private static final String CURRENCY_OF_TRANSFER = "CURRENCY_OF_TRANSFER";

	private static final String CHP_NEW_PASSWORD = "CHP_NEW_PASSWORD";

	private static final String TRANSACTION_REMARKS = "TRANSACTION_REMARKS";

	private String beneficiaryCardNumber;

	private String transferAmount;

	private String currencyOfTransfer;
	
	private String transactionPassword;
	
	private String transactionRemarks;
	
	
	public String getBeneficiaryCardNumber() {
		return beneficiaryCardNumber;
	}

	public void setBeneficiaryCardNumber(String beneficiaryCardNumber) {
		this.beneficiaryCardNumber = beneficiaryCardNumber;
	}

	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getCurrencyOfTransfer() {
		return currencyOfTransfer;
	}

	public void setCurrencyOfTransfer(String currencyOfTransfer) {
		this.currencyOfTransfer = currencyOfTransfer;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	public static VisaMoneyTransfer createWithProvider(KeyValueProvider provider) {
		VisaMoneyTransfer vmt = new VisaMoneyTransfer();
		vmt.setBeneficiaryCardNumber(provider.getString(BENEFICIARY_CARD_NUMBER));
		vmt.setTransferAmount(provider.getString(TRANSFER_AMOUNT));
		vmt.setCurrencyOfTransfer(provider.getString(CURRENCY_OF_TRANSFER));
		vmt.setTransactionPassword(provider.getString(CHP_NEW_PASSWORD));
		vmt.setTransactionRemarks(provider.getString(TRANSACTION_REMARKS, "Test"));
		return vmt;
	}
}