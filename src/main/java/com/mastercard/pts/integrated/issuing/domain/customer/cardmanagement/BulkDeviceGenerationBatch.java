package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class BulkDeviceGenerationBatch {
	
	private String batchNumber;
	
    private String productType;
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

}
