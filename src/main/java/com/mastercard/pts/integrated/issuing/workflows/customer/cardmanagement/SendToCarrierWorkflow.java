package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SendToCarrier;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SendToCarrierPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

public class SendToCarrierWorkflow 
{
	@Autowired
	private Navigator navigator;


	public void ProcessSendToCarrierBatchForPin(SendToCarrier sendToCarrier) {
		SendToCarrierPage page = navigator.navigateToPage(SendToCarrierPage.class);
		page.ProcessSendToCarrierBatchForPin(sendToCarrier);
	}

}
