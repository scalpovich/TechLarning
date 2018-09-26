package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CarrierAcknowledgement;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CarrierAcknowledgementPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class CarrierAcknowledgementWorkflow {

	
	@Autowired
	private Navigator navigator;


	public void processCarrierAcknowledgementBatch(CarrierAcknowledgement carrierAcknowledgement) {
		CarrierAcknowledgementPage page = navigator.navigateToPage(CarrierAcknowledgementPage.class);
		page.processCarrierAcknowledgementBatch(carrierAcknowledgement);
	}

	
}
