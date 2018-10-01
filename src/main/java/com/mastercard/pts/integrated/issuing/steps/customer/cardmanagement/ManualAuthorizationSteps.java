package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ManualAuthorizationWorkflow;

@Component
public class ManualAuthorizationSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private ManualAuthorizationWorkflow manualAuthorizationWorkflow;
	
	private String statusMessage;

	@Given("user raises an authorization request")
	@When("user raises an authorization request")
	@Then("user raises an authorization request")
	public void whenUserRaisesAnAuthorizationRequest(){
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		request.setDeviceNumber(device.getDeviceNumber());
		statusMessage = manualAuthorizationWorkflow.authorizeDevice(request);
	}
	
	@Then("status of request is \"approved\"")
	public void thenStatusOfRequestIsapproved(){
		assertThat("Authorization is successful", statusMessage,
				containsString("Authorization is successful"));

	}

	@Then("status of request is declined with reason $declineReason")
	@When("status of request is declined with reason $declineReason")
	public void thenVerifyDeclineStatusCode(String declineReason) {
		assertThat("Authorization is declined", statusMessage,
				containsString(manualAuthorizationWorkflow
						.getDeclineReasonMessage(declineReason)));
	}
}
