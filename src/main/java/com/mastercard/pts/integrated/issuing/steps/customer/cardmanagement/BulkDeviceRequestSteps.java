package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BulkDeviceRequestFlows;

@Component
public class BulkDeviceRequestSteps {

	@Autowired
	BulkDeviceRequestbatch bulkrequestBatch;

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	Program program;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	BulkDeviceRequestFlows bulkdevicerequestflows;

	@When("user creates a bulk device request for product $productType")
	public void createBulkDeviceRequest(@Named("productType") String productType) {
		String BatchNumber;
		bulkrequestBatch.BulkDeviceRequestDataProvider();
		bulkrequestBatch.setProgram(program.getProgram());
		bulkrequestBatch.setDevicePlan(deviceplan.getDevicePlan());
		devicecreation.setProduct(productType);
		BatchNumber = bulkdevicerequestflows.createBulkdeviceRequest(devicecreation, bulkrequestBatch);
		bulkrequestBatch.setBatchNumber(BatchNumber);
	}

}
