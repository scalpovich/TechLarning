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
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ManualAuthorizationWorkflow;

@Component
public class ManualAuthorizationSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private ManualAuthorizationWorkflow manualAuthorizationWorkflow;
	
	private String successMessage;
	private String errorMessage = "";
	private static final String INVALID_DEVICE_NO = "Invalid Device number";

	@Given("user raises an authorization request")
	@When("user raises an authorization request")
	@Then("user raises an authorization request")
	public void whenUserRaisesAnAuthorizationRequest(){
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		request.setDeviceNumber(device.getDeviceNumber());
		successMessage = manualAuthorizationWorkflow.authorizeDevice(request);
	}
	
	@When("user raises an authorization request for invalid device")
	public void raiseAuthRequestForInvalidCard() {
		AuthorizationRequest request = new AuthorizationRequest();
		request.setDeviceNumber(CustomUtils.randomNumbers(10));
		errorMessage = manualAuthorizationWorkflow.createInvalidRequest(request);
	}
	
	@Then("authorization should not be allowed")
	public void verifyThatManualAuthIsNotAllowed() {
		assertThat("Authorization is not allowed", errorMessage, containsString(INVALID_DEVICE_NO));
	}
	
	@Then("status of request is \"approved\"")
	public void thenStatusOfRequestIsapproved(){
		 assertThat("Authorization is successful", successMessage, containsString("Authorization is successful"));
	}
}
