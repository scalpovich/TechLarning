package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApproveRejectPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
public class ApproveRejectApplicationFlows {
	@Autowired
	Navigator navigator;
	
	public String approveRejectCreditApplication()
	{
		ApproveRejectPage approveRejectPage = navigator.navigateToPage(ApproveRejectPage.class);
		approveRejectPage.enterApplicationNumber();
		approveRejectPage.selectFromAndToDate();
		approveRejectPage.clickEditImageForTheRecordDisplayed();
		approveRejectPage.approveButtonClick();
		SimulatorUtilities.wait(5000);
		String message=approveRejectPage.getApplicationNumber();
		return message;
	}
	
	public void approveRejectCreditApplication_FileUpload()
	{
		ApproveRejectPage approveRejectPage = navigator.navigateToPage(ApproveRejectPage.class);
		approveRejectPage.approveApplicationFileUpload();
	}
}
