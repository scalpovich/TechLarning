package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceProductionFlows;

@Component
public class DeviceProductionBatchSteps {

	@Autowired
	BulkDeviceRequestbatch bulkdevicerequestbatch;

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DeviceProductionFlows deviceproductionflows;

	@When("user runs the device production batch for product $productType")
	@Then("user runs the device production batch for product $productType")
	public void createDeviceProductionbatch(@Named("productType") String productType) {
		String JobId = "";
		bulkdevicerequestbatch.BulkDeviceRequestDataProvider();
		devicecreation.setProduct(productType);
		bulkdevicerequestbatch
				.setBatchNumberForDeviceProduction(bulkdevicerequestbatch.getBatchNumberForDeviceGeneration());
		JobId = deviceproductionflows.createDeviceProductionBatch(devicecreation, bulkdevicerequestbatch);
		bulkdevicerequestbatch.setDeviceProductionJobId(JobId);
	}

	@When("user processes all the devices and runs the device production batch for product $productType")
	@Then("user processes all the devices and runs the device production batch for product $productType")
	public void createDeviceProductionbatchProcessAllDevices(@Named("productType") String productType) {
		String JobId = "";
		bulkdevicerequestbatch.BulkDeviceRequestDataProvider();
		devicecreation.setProduct(productType);
		bulkdevicerequestbatch
				.setBatchNumberForDeviceProduction(bulkdevicerequestbatch.getBatchNumberForDeviceGeneration());
		JobId = deviceproductionflows.createDeviceProductionBatchProcessAll(devicecreation, bulkdevicerequestbatch);
		bulkdevicerequestbatch.setDeviceProductionJobId(JobId);
	}
}
