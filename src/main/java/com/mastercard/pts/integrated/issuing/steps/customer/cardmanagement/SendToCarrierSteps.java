package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.io.File;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SendToCarrier;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SendToCarrierWorkflow;

public class SendToCarrierSteps {

	
	@Autowired
	private TestContext context;
	
	@Autowired
	private SendToCarrier sendToCarrier;
 
	@Autowired
	private SendToCarrierWorkflow sendToCarrierWorkflow;
	
	@When("$type processes Send To Carrier batch for $fileType File Type")
	@Then("$type processes Send To Carrier batch for $fileType File Type")
	public void whenProcessesSendToCarrierBatchForPin(String type, String fileType) {
			
			
			String batchFile = context.get("PIN_OFFSET_FILE");
			sendToCarrier.setProductType(ProductType.fromShortName(type));
			sendToCarrier.setFileType(fileType);
			sendToCarrier.setFileName((new File(batchFile)).getName());
			sendToCarrierWorkflow.ProcessSendToCarrierBatchForPin(sendToCarrier);
		}

	
}
