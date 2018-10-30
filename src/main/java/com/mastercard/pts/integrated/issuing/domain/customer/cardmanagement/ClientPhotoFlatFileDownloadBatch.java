package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class ClientPhotoFlatFileDownloadBatch {
	
	private String productType;
	
	private String deviceNumber;

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String batchNumber) {
		this.deviceNumber = batchNumber;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
