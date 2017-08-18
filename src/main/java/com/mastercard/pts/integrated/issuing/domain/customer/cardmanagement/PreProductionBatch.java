package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class PreProductionBatch {
	
	private String productType;
	
	private String batchNumber;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

}
