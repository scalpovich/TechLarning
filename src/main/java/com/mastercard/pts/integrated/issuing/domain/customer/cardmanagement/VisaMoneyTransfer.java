package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class VisaMoneyTransfer {

	private static final String	VISA_TRANSFER_CURRENCY	 = 	"CURRENCY";
	private static final String	VISA_TRANSFER_AMOUNT	 = 	"VISA_TRANSFER_AMOUNT";
	
	private String beneficiaryDeviceNumber;
	private String currency;
	private String amount;
	private String memo;
	private String vmt;
	
	public static VisaMoneyTransfer createWithProvider(KeyValueProvider provider){
		VisaMoneyTransfer transfer = new VisaMoneyTransfer();
		transfer.setCurrency(provider.getString(VISA_TRANSFER_CURRENCY));
		transfer.setAmount(provider.getString(VISA_TRANSFER_AMOUNT));
		transfer.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return transfer;
	}

	public String getVmt() {
		return vmt;
	}

	public void setVmt(String vmt) {
		this.vmt = vmt;
	}

	public String getBeneficiaryDeviceNumber() {
		return beneficiaryDeviceNumber;
	}
	public void setBeneficiaryDeviceNumber(String beneficiaryDeviceNumber) {
		this.beneficiaryDeviceNumber = beneficiaryDeviceNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
