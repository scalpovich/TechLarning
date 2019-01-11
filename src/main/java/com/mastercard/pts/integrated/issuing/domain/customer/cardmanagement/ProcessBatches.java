package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
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
	private String methodToGenerateFile;
	private String vendorName;
	private LocalDate businessDate;
	private String status;
	
	private String accountAdminStatus;
	private String accountBalanceStatus;
	private String accountUnpaidStatus;
	
	private static final String BATCH_TYPE = "BATCH_TYPE";
	private static final String BATCH_NAME = "BATCH_NAME";
	private static String fileName;

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
	
	public static ProcessBatches getBatchDataForDownload(KeyValueProvider provider){
		ProcessBatches batch = new ProcessBatches();
		batch.setBatchType("DOWNLOAD [D]");
		batch.setVendorName(provider.getString("COURIER_VENDOR"));
		return batch;
	}
	
	
	public static void setBatchFileName(String sFileName){
		fileName = sFileName;
	}
	
	public static String getFileName() {
		return fileName;
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

	public String getMethodToGenerateFile() {
		return methodToGenerateFile;
	}

	public void setMethodToGenerateFile(String methodToGenerateFile) {
		this.methodToGenerateFile = methodToGenerateFile;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public void setBusinessDate(LocalDate businessDate) {
		this.businessDate = businessDate;
	}

	public LocalDate getBusinessDate() {
		return businessDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAccountAdminStatus() {
		return accountAdminStatus;
	}

	public void setAccountAdminStatus(String accountAdminStatus) {
		this.accountAdminStatus = accountAdminStatus;
	}

	public String getAccountBalanceStatus() {
		return accountBalanceStatus;
	}

	public void setAccountBalanceStatus(String accountBalanceStatus) {
		this.accountBalanceStatus = accountBalanceStatus;
	}

	public String getAccountUnpaidStatus() {
		return accountUnpaidStatus;
	}

	public void setAccountUnpaidStatus(String accountUnpaidStatus) {
		this.accountUnpaidStatus = accountUnpaidStatus;
	}
}