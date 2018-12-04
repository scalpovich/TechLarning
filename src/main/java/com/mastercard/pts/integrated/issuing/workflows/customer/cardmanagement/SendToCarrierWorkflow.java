package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SendToCarrier;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SendToCarrierPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class SendToCarrierWorkflow 
{
	@Autowired
	private Navigator navigator;
	
	public void processSendToCarrierBatch(SendToCarrier sendToCarrier) {
		SendToCarrierPage page = navigator.navigateToPage(SendToCarrierPage.class);
		page.processSendToCarrierBatch(sendToCarrier);
	}
}
