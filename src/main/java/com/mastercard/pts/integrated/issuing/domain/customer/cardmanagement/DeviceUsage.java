package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class DeviceUsage {

	private String transactionAmount;
	private String walletMCGCode;
	private String velocity;
	
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	
	public static DeviceUsage getDeviceUsageDetails(KeyValueProvider provider){
		DeviceUsage plan = new DeviceUsage();
		plan.setTransactionAmount(provider.getString(TRANSACTION_AMOUNT));
		return plan;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getWalletMCGCode() {
		return walletMCGCode;
	}

	public void setWalletMCGCode(String walletMCGCode) {
		this.walletMCGCode = walletMCGCode;
	}

	public String getVelocity() {
		return velocity;
	}

	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}
	
	

}
