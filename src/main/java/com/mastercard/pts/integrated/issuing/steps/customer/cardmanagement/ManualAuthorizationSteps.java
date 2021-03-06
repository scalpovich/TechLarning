package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.workflows.LoginWorkflow;
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
	
	@Autowired
	private LoginWorkflow loginWorkflow;
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessBatchesPage.class);
	private String errorMessage = "";
	private static final String INVALID_DEVICE_NO = "Invalid Device number";
	
	private String statusMessage;

	@Given("user raises an authorization request only")
	@When("user raises an authorization request only")
	@Then("user raises an authorization request only")
	public void whenUserRaisesAnAuthorizationRequest(){
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		request.setDeviceNumber(device.getDeviceNumber());
		String trxDate=loginWorkflow.getInstitutionDateLogin();
		logger.info("Transaction Date->"+loginWorkflow.getInstitutionDateLogin());
		context.put("transaction_date",trxDate);
		request.setCvv2(device.getCvv2Data());
		statusMessage = manualAuthorizationWorkflow.authorizeDevice(request);
	}

	@Given("user raises an authorization request with invalid MCC")
	@When("user raises an authorization request with invalid MCC")
	@Then("user raises an authorization request with invalid MCC")
	public void whenUserRaisesAnAuthorizationRequestInvalidMCC() {
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		request.setDeviceNumber(device.getDeviceNumber());
		request.setMcc(provider.getString(Constants.MCC_CODE_INVALID));
		statusMessage = manualAuthorizationWorkflow.authorizeDevice(request);
	}


	
	@Then("user raises an authorization request")
	@When("user raises an authorization request")
	@Composite(steps = {"When embossing file batch was generated in correct format","When user raises an authorization request only"})
	public void manualAuthComposite(){
		
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
	
	@When("status of request is \"approved\"")
	@Then("status of request is \"approved\"")
	public void thenStatusOfRequestIsapproved(){
		assertThat("Authorization is successful", statusMessage,
				containsString("Authorization is successful"));
	}

	@Then("status of request is declined with reason $declineReason")
	@When("status of request is declined with reason $declineReason")
	public void thenVerifyDeclineStatusCode(String declineReason) {
		assertThat("Authorization is declined ", statusMessage,
				containsString(manualAuthorizationWorkflow
						.getDeclineReasonMessage(declineReason)));
	}
}

