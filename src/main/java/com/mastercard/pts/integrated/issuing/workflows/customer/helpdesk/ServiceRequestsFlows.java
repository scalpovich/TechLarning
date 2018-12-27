package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.ServiceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ServiceRequestsFlows {
 
	@Autowired
	Device device;
	
	@Autowired
	Navigator navigate;
	
	public String  serviceRquestFlow(Device device){
		ServiceRequestPage page = navigate.navigateToPage(ServiceRequestPage.class);		
		return page.verifyServiceRequest(device);
	}	
}