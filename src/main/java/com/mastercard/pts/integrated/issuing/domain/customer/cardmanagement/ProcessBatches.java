package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
@Component
public class ProcessBatches {
	
	private String joBID;
	private String batchType;
	
	private String batchName;
	private String fileType;
	private String productType;
	private String generatedFilename;
	private String interchangeType;
	private String extractType;
	
	
	private static final String BATCH_TYPE = "UPLOAD [U]";
	
//	private static final String BATCH_NAME = "Transaction Upload [TRANSACTION_UPLOAD]";
	private static final String BATCH_NAME = "Load IPM Incoming File [IPM_INCOMING]";
	


	public static ProcessBatches createWithProvider(KeyValueProvider provider){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName(provider.getString(BATCH_NAME));
		batch.setBatchType(provider.getString(BATCH_TYPE));
		return batch;
	}
	
	public static ProcessBatches getBatchData(){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchName(BATCH_NAME);
		batch.setBatchType(BATCH_TYPE);
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


	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getJoBID() {
		return joBID;
	}

	public void setJoBID(String joBID) {
		this.joBID = joBID;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getGeneratedFilename() {
		return generatedFilename;
	}

	public void setGeneratedFilename(String generatedFilename) {
		this.generatedFilename = generatedFilename;
	}

	public static String getProgramDataValuefromExcel() {
		return MapUtils.fnGetInputDataFromMap("Program");
	}

}
