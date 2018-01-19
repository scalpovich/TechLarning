package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.VisaFeeCollectionWorkflow;

@Component
public class VisaFeeCollectionSteps {
	
	@Autowired
	VisaFeeCollectionWorkflow visaFeeCollectionWorkflow;
	@Autowired
	private KeyValueProvider keyProvider;
	@When("perform add visa fee Collection $transactionCode transaction")
	public void performAddVisaFeeTransactionForDispute(String transactionCode) {
		VisaFeeCollection visafeecollection=VisaFeeCollection.createWithProvider(keyProvider);
		visafeecollection.setTransactionCode(transactionCode);
		visaFeeCollectionWorkflow.addVisaFeeCollectionRecord(visafeecollection);
		
	}
}
