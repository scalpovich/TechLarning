/**
 * @author e076168
 */
package com.mastercard.pts.integrated.issuing.domain.cardholder.transactions;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class MastercardMoneySend {

	private static final String BENEFICIARY_CARD_NUMBER = "BENEFICIARY_CARD_NUMBER";

	private static final String TRANSFER_AMOUNT = "TRANSFER_AMOUNT";

	private static final String CURRENCY_OF_TRANSFER = "CURRENCY_OF_TRANSFER";

	private static final String MEMO = "MEMO";

	private static final String NAME = "NAME";

	private static final String CONTACT_NUMBER = "CONTACT_NUMBER";

	private static final String CHP_NEW_PASSWORD = "CHP_NEW_PASSWORD";

	private static final String TRANSACTION_REMARKS = "TRANSACTION_REMARKS";

	private String beneficiaryCardNumber;

	private String transferAmount;

	private String currencyOfTransfer;

	private String contactNumber;

	private String name;

	private String memo;
	
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public static MastercardMoneySend createWithProvider(KeyValueProvider provider) {
		MastercardMoneySend mms = new MastercardMoneySend();
		mms.setBeneficiaryCardNumber(provider.getString(BENEFICIARY_CARD_NUMBER));
		mms.setTransferAmount(provider.getString(TRANSFER_AMOUNT));
		mms.setCurrencyOfTransfer(provider.getString(CURRENCY_OF_TRANSFER));
		mms.setMemo(provider.getString(MEMO));
		mms.setName(provider.getString(NAME));
		mms.setContactNumber(provider.getString(CONTACT_NUMBER));
		mms.setTransactionPassword(provider.getString(CHP_NEW_PASSWORD));
		mms.setTransactionRemarks(provider.getString(TRANSACTION_REMARKS, "Test"));
		return mms;
	}
}
