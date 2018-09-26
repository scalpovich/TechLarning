package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CarrierAcknowledgement;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CarrierAcknowledgementWorkflow;

@Component
public class CarrierAcknowledgementSteps {
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private CarrierAcknowledgementWorkflow carrierAcknowledgementWorkflow;
	

	
//	@When("$type processes Carrier Acknowledgement batch for $fileType File Type")
//	@Then("$type processes Carrier Acknowledgement batch for $fileType File Type")
//	public void thenProcessesCarrierAcknowledgementBatch(String type, String fileType)
//	{
//		CarrierAcknowledgement carrierAcknowledgement = CarrierAcknowledgement.createWithProvider(provider);
//		carrierAcknowledgement.setProductType(ProductType.fromShortName(type));
//		carrierAcknowledgement.setFileType(fileType);
//		carrierAcknowledgement.setFileName(context.get("DAT_FILE_NAME"));
//		carrierAcknowledgementWorkflow.processCarrierAcknowledgementBatch(carrierAcknowledgement);}
	}


