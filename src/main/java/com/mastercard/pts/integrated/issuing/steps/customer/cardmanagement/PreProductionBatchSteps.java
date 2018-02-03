package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.PreProductionFlows;

@Component
public class PreProductionBatchSteps {

	@Autowired
	BulkDeviceRequestbatch bulkdevicerequestbatch;

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	PreProductionFlows preproductionflows;

	@When("user runs the pre production batch for product $product")
	public void runBulkDeviceGenerationBatch(String product) {
		String JobId = "";
		bulkdevicerequestbatch.BulkDeviceRequestDataProvider();
		devicecreation.setProduct(ProductType.fromShortName(product));
		bulkdevicerequestbatch.setPreProductionSourceJobid(bulkdevicerequestbatch.getJobId());
		JobId = preproductionflows.createPreProductionBatch(devicecreation, bulkdevicerequestbatch);
		bulkdevicerequestbatch.setPreProductionSourceJobid(JobId);
	}

}
