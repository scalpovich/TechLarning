package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ReversalTransaction {
	private String arn;
	private String amount;
	private String existingDevice;
	
	public String getExistingDevice() {
		return existingDevice;
	}

	public void setExistingDevice(String existingDevice) {
		this.existingDevice = existingDevice;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getArn() {
		return arn;
	}

	public void setArn(String arn) {
		this.arn = arn;
	}
	
	public static ReversalTransaction getProviderData(KeyValueProvider provider)
	{
		ReversalTransaction rt=new ReversalTransaction();
		rt.setAmount(provider.getString("AMOUNT"));
		rt.setExistingDevice(provider.getString("EXISTING_DEVICE"));
		return rt;
	}

}
