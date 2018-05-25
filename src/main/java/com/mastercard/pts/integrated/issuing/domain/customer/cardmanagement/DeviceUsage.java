package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class DeviceUsage {

	private String nextTransactionAmount;
	private String walletMCGCode;
	private int velocity;
	private String deviceNumber;
	
	private static final String NEXT_TRANSACTION_AMOUNT = "NEXT_TRANSACTION_AMOUNT";
	
	public static DeviceUsage getDeviceUsageDetails(KeyValueProvider provider){
		DeviceUsage plan = new DeviceUsage();
		plan.setTransactionAmount(provider.getString(NEXT_TRANSACTION_AMOUNT));
		return plan;
	}
	
	public DeviceUsage(){
		this.velocity = 1;
	}

	public String getNextTransactionAmount() {
		return nextTransactionAmount;
	}

	public void setTransactionAmount(String nextTransactionAmount) {
		this.nextTransactionAmount = nextTransactionAmount;
	}

	public String getWalletMCGCode() {
		return walletMCGCode;
	}

	public void setWalletMCGCode(String walletMCGCode) {
		this.walletMCGCode = walletMCGCode;
	}

	public String getVelocity() {
		return String.valueOf(velocity);
	}

	public void setVelocity() {
		++velocity;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

}
