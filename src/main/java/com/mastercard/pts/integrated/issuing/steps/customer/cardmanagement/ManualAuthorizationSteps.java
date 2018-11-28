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
import com.mastercard.pts.integrated.issuing.workflows.LoginWorkflow;
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
	
	private String statusMessage;

	@Given("user raises an authorization request")
	@When("user raises an authorization request")
	@Then("user raises an authorization request")
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
	
	@Then("user raises an authorization request")
	@When("user raises an authorization request")
	@Composite(steps = {"When embossing file batch was generated in correct format","When user raises an authorization request only"})
	public void manualAuthComposite(){
		
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

