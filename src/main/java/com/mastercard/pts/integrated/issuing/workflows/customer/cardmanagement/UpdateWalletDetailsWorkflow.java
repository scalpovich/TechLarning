package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;


import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.UpdateWalletDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class UpdateWalletDetailsWorkflow {
	
	@Autowired
	private Navigator navigator;
	
    @Autowired
    private TestContext context;
    
    public void updateDeviceDetails(WalletDetails updateWalletDetails) {
    	UpdateWalletDetailsPage page = navigator.navigateToPage(UpdateWalletDetailsPage.class);
    	page.searchWalletUsingWalletNumber(updateWalletDetails);
    	page.updateWalletAdminStatus(updateWalletDetails);
    }
   
}
