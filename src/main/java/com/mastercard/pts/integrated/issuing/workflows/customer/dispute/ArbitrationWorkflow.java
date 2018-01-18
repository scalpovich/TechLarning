package com.mastercard.pts.integrated.issuing.workflows.customer.dispute;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ArbitrationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Workflow
public class ArbitrationWorkflow extends SimulatorUtilities {
	
	@Autowired
	ArbitrationPage arbitrationPage;
	
	@Autowired
	Navigator navigator;
	
	public void createArbitration(RetrievalRequest rr){
		ArbitrationPage page = navigator.navigateToPage(ArbitrationPage.class);
		page.createArbitration(rr);
	}
}
