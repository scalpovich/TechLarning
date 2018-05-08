package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class BatchDefinition implements HasCodeAndDescription {

	private String batchType;
	private String productType;
	private String inputFilePath;
	private String rejectedFilePath;
	private String processedFilePath;
	private String batchDetails;

	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	public String getRejectedFilePath() {
		return rejectedFilePath;
	}

	public void setRejectedFilePath(String rejectedFilePath) {
		this.rejectedFilePath = rejectedFilePath;
	}

	public String getProcessedFilePath() {
		return processedFilePath;
	}

	public void setProcessedFilePath(String processedFilePath) {
		this.processedFilePath = processedFilePath;
	}

	public String getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(String batchDetails) {
		this.batchDetails = batchDetails;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public static BatchDefinition createWithProvider() {
		BatchDefinition batchDefinition = new BatchDefinition();
		String uploadPath = "UPLOAD_PATH_CER";
		batchDefinition.setInputFilePath(MapUtils
				.fnGetInputDataFromMap(uploadPath) + "/INPUT");
		batchDefinition.setProcessedFilePath(MapUtils
				.fnGetInputDataFromMap(uploadPath) + "/PROC");
		batchDefinition.setRejectedFilePath(MapUtils
				.fnGetInputDataFromMap(uploadPath) + "/OUTPUT");
		return batchDefinition;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getCode() {
		return null;
	}

}
