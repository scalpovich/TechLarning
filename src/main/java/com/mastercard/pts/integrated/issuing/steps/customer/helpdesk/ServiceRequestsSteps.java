package com.mastercard.pts.integrated.issuing.steps.customer.helpdesk;

import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.ServiceRequestsFlows;


@Component
public class ServiceRequestsSteps {

	@Autowired
	private ServiceRequestsFlows serviceRequestflow;
	
	@Autowired
	private TestContext context; 
	
	@Autowired
	private KeyValueProvider provider;
		
	@Then ("verify \"$requestName\" service request  status")
	public void verifyServiceRequestStatus(String requestName){
		Device device = context.get(ContextConstants.DEVICE);
		Assert.assertEquals("Service request is not created", requestName, serviceRequestflow.serviceRquestFlow(device));		
	}
}
