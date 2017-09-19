package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ProcessBatches {

	private String joBID;
	private String BatchName;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String batchType;
	
	private String batchName;
	private String fileType;

	public static final String UPLOAD = "UPLOAD [U]";
	public static final String CURRENCY_EXCHANGE_RATE = "Currency Exchange Rate File Upload [CURRENCY_EXC_RATE_UPLOAD]";
	
	private String productType;
	
	private String interchangeType;
	private String extractType;
	
	
	private static final String BATCH_TYPE = "UPLOAD [U]";
	
	
	private static final String BATCH_TYPE = "UPLOAD [U]";


	private static final String BATCH_NAME = "Transaction Upload [TRANSACTION_UPLOAD]";
	public String getBatchName() {
		return BatchName;
		
	}
	
	public void setBatchName(String batchName) {
		BatchName = batchName;
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
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(
				ProcessBatches.class, name);
	}
	
}
