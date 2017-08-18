package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.CustomerCarePage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.DynamicQuizzingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.EscalationIIPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.EscalationIPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.ForwardedPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpDeskReportsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.ServiceCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.ServiceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class  UiVerificationHelpdeskWorkflow{

	@Autowired
	private Navigator navigator;

	public void traverseHelpDeskServiceCodePage(){
		ServiceCodePage page = navigator.navigateToPage(ServiceCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskDynamicQuizzingPage(){
		DynamicQuizzingPage page = navigator.navigateToPage(DynamicQuizzingPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskCustomerCarePage(){
		CustomerCarePage page = navigator.navigateToPage(CustomerCarePage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskGeneralPage(){
		HelpdeskGeneralPage page = navigator.navigateToPage(HelpdeskGeneralPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskForwardedPage(){
		ForwardedPage page = navigator.navigateToPage(ForwardedPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskServiceRequestPage(){
		ServiceRequestPage page = navigator.navigateToPage(ServiceRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskEscalationIPage(){
		EscalationIPage page = navigator.navigateToPage(EscalationIPage.class);
		page.verifyUiOperationStatus();
	}

	public void traverseHelpDeskEscalationIIPage(){
		EscalationIIPage page = navigator.navigateToPage(EscalationIIPage.class);
		page.verifyUiOperationStatus();
	}
	
	public void traverseHelpDeskReportsPage(){
		HelpDeskReportsPage page = navigator.navigateToPage(HelpDeskReportsPage.class);
		page.verifyUiOperationStatus();
	}

}
