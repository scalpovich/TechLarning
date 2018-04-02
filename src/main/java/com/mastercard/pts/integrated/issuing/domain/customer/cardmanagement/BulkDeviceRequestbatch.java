package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class BulkDeviceRequestbatch {

	public String batchNumber;

	public String branch;

	public String program;

	public String devicePlan;

	public String quantityRequested;

	public String jobId;

	public String preProductionSourceJobid;

	public String deviceProductionJobId;

	public String batchNumberForDeviceProduction;

	public String deviceNumberFromBulkDevice;

	public String deviceNumber;

	public String actionCode;

	public String batchNumberForDeviceGeneration;

	public String batchType;

	public String product;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getDevicePlan() {
		return devicePlan;
	}

	public void setDevicePlan(String devicePlan) {
		this.devicePlan = devicePlan;
	}

	public String getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(String quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getPreProductionSourceJobid() {
		return preProductionSourceJobid;
	}

	public void setPreProductionSourceJobid(String preProductionSourceJobid) {
		this.preProductionSourceJobid = preProductionSourceJobid;
	}

	public String getDeviceProductionJobId() {
		return deviceProductionJobId;
	}

	public void setDeviceProductionJobId(String deviceProductionJobId) {
		this.deviceProductionJobId = deviceProductionJobId;
	}

	public String getBatchNumberForDeviceProduction() {
		return batchNumberForDeviceProduction;
	}

	public void setBatchNumberForDeviceProduction(String batchNumberForDeviceProduction) {
		this.batchNumberForDeviceProduction = batchNumberForDeviceProduction;
	}

	public String getDeviceNumberFromBulkDevice() {
		return deviceNumberFromBulkDevice;
	}

	public void setDeviceNumberFromBulkDevice(String deviceNumberFromBulkDevice) {
		this.deviceNumberFromBulkDevice = deviceNumberFromBulkDevice;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getBatchNumberForDeviceGeneration() {
		return batchNumberForDeviceGeneration;
	}

	public void setBatchNumberForDeviceGeneration(String batchNumberForDeviceGeneration) {
		this.batchNumberForDeviceGeneration = batchNumberForDeviceGeneration;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public void BulkDeviceRequestDataProvider() {
		// Program program = new Program();
		setQuantityRequested(MapUtils.fnGetInputDataFromMap("QuantityType"));
		setBatchType(MapUtils.fnGetInputDataFromMap("BatchType"));
		setActionCode(MapUtils.fnGetInputDataFromMap("ActionCode"));
	}
}