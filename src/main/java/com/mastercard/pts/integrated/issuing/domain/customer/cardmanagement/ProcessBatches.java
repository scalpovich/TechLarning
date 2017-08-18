package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ProcessBatches {
	
	private String batchType;
	
	private String batchName;
	
	private String productType;
	
	private String interchangeType;
	private String extractType;
	
	
	private static final String BATCH_TYPE = "UPLOAD [U]";
	
	private static final String BATCH_NAME = "Transaction Upload [TRANSACTION_UPLOAD]";
	
	public String getBatchType() {
		return batchType;
	}

	public static ProcessBatches createWithProvider(KeyValueProvider provider){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName(provider.getString(BATCH_NAME));
		batch.setBatchType(provider.getString(BATCH_TYPE));
		return batch;
	}
	
	public static ProcessBatches getBatchData(){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName((BATCH_NAME));
		batch.setBatchType((BATCH_TYPE));
		return batch;
	}
	
	public String getInterchangeType() {
		return interchangeType;
	}

	public void setInterchangeType(String interchangeType) {
		this.interchangeType = interchangeType;
	}

	public String getExtractType() {
		return extractType;
	}

	public void setExtractType(String extractType) {
		this.extractType = extractType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
