package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class MoneySend {
	
	private static final String	MONEY_SEND_CURRENCY	 		 = 	"CURRENCY";
	private static final String	MONEY_SEND_AMOUNT	 = 	"MONEY_SEND_AMOUNT";

	private String beneficiaryDeviceNumber;
	private String currency;
	private String amount;
	private String contactNumber;
	private String name;
	private String memo;

	public static MoneySend createWithProvider(KeyValueProvider provider){
		MoneySend moneySend = new MoneySend();
		moneySend.setCurrency(provider.getString(MONEY_SEND_CURRENCY));
		moneySend.setAmount(provider.getString(MONEY_SEND_AMOUNT));
		moneySend.setContactNumber(RandomStringUtils.randomNumeric(10));
		moneySend.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return moneySend;
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

	

}
