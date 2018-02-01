package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class BulkDeviceRequestbatch {

	public String BatchNumber;

	public String Branch;

	public String Program;

	public String DevicePlan;

	public String QuantityRequested;

	public String JobId;

	public String PreProductionSourceJobid;

	public String DeviceProductionJobId;

	public String BatchNumberForDeviceProduction;

	public String DeviceNumberFromBulkDevice;

	public String getDeviceNumberFromBulkDevice() {
		return DeviceNumberFromBulkDevice;
	}

	public void setDeviceNumberFromBulkDevice(String deviceNumberFromBulkDevice) {
		DeviceNumberFromBulkDevice = deviceNumberFromBulkDevice;
	}

	public String getBatchNumberForDeviceProduction() {
		return BatchNumberForDeviceProduction;
	}

	public void setBatchNumberForDeviceProduction(String batchNumberForDeviceProduction) {
		BatchNumberForDeviceProduction = batchNumberForDeviceProduction;
	}

	public String getDeviceProductionJobId() {
		return DeviceProductionJobId;
	}

	public void setDeviceProductionJobId(String deviceProductionJobId) {
		DeviceProductionJobId = deviceProductionJobId;
	}

	public String DeviceNumber;

	public String ActionCode;

	public String getActionCode() {
		return ActionCode;
	}

	public void setActionCode(String actionCode) {
		ActionCode = actionCode;
	}

	public String getDeviceNumber() {
		return DeviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		DeviceNumber = deviceNumber;
	}

	public String getPreProductionSourceJobid() {
		return PreProductionSourceJobid;
	}

	public void setPreProductionSourceJobid(String preProductionSourceJobid) {
		PreProductionSourceJobid = preProductionSourceJobid;
	}

	public String getBatchType() {
		return BatchType;
	}

	public void setBatchType(String batchType) {
		BatchType = batchType;
	}

	public String BatchNumberForDeviceGeneration;

	public String BatchType;

	public String getBatchNumberForDeviceGeneration() {
		return BatchNumberForDeviceGeneration;
	}

	public void setBatchNumberForDeviceGeneration(String batchNumberForDeviceGeneration) {
		BatchNumberForDeviceGeneration = batchNumberForDeviceGeneration;
	}

	public String getJobId() {
		return JobId;
	}

	public void setJobId(String jobId) {
		JobId = jobId;
	}

	public String getQuantityRequested() {
		return QuantityRequested;
	}

	public void setQuantityRequested(String quantityRequested) {
		QuantityRequested = quantityRequested;
	}

	public String getDevicePlan() {
		return DevicePlan;
	}

	public void setDevicePlan(String devicePlan) {
		DevicePlan = devicePlan;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getProgram() {
		return Program;
	}

	public void setProgram(String program) {
		Program = program;
	}

	public String getBatchNumber() {
		return BatchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		BatchNumber = batchNumber;
	}

	public void BulkDeviceRequestDataProvider() {
		// Program program = new Program();
		setQuantityRequested(MapUtils.fnGetInputDataFromMap("QuantityType"));
		setBatchType(MapUtils.fnGetInputDataFromMap("BatchType"));
		setActionCode(MapUtils.fnGetInputDataFromMap("ActionCode"));
	}
}
