package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BulkDeviceGenerationFlows;

@Component
public class BulkDeviceGenerationSteps {

	@Autowired
	BulkDeviceGenerationFlows bulkdevicegenerationflows;

	@Autowired
	BulkDeviceRequestbatch bulkdevicerequestbatch;

	@Autowired
	DeviceCreation devicecreation;

	@When("user runs the bulk device generation batch for product $product")
	public void runBulkDeviceGenerationBatch(String product) {
		String JobId = "";
		devicecreation.setProduct(ProductType.fromShortName(product));
		bulkdevicerequestbatch.setBatchNumberForDeviceGeneration(bulkdevicerequestbatch.getBatchNumber());
		// bulkdevicerequestbatch.setBatchNumberForDeviceGeneration("29465248");
		JobId = bulkdevicegenerationflows.createBulkdeviceGeneration(devicecreation, bulkdevicerequestbatch);
		bulkdevicerequestbatch.setJobId(JobId);
	}

}
