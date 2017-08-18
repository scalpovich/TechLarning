package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class PinGenerationBatch {
	
	private String productType;
	
	private String batchNumber;

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductType() {
		return productType;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

}
