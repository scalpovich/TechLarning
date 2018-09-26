package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class ResendPinRequest {
	
	private String deviceNumber;
	private String productType;
	
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	

}
