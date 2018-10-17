package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.UpdateClientDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class UpdateClientDetailsFlows {
	
	@Autowired
	private Navigator navigator;
	
	private UpdateClientDetailsPage page;
	
	public void updateClientDetails(ClientDetails clientDetails) {
		page = navigator.navigateToPage(UpdateClientDetailsPage.class);
		page.editClient(clientDetails);
	}

}
