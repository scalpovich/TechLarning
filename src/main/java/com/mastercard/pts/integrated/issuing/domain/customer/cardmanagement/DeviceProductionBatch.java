package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class DeviceProductionBatch {
	
	private String productType;
	
	private String batchNumber;

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
