package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.nio.file.Path;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.LinuxUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
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
	private LinuxBox linuxBox;
	
	@Autowired
	private Path tempDirectory;
	
	private String successMessage;

	@Given("user raises an authorization request")
	@When("user raises an authorization request")
	@Then("user raises an authorization request")
	public void whenUserRaisesAnAuthorizationRequest(){
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		DevicePlan tempdevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		File batchFile =linuxBox.downloadFileThroughSCPByPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "DEVICE","proc");
		String[] fileData = LinuxUtils.getCardNumberAndExpiryDate(batchFile);
		MiscUtils.reportToConsole("File Data : " + fileData);
		request.setDeviceNumber(device.getDeviceNumber());
		request.setCvv2(fileData[2]);
		successMessage = manualAuthorizationWorkflow.authorizeDevice(request);
	}
	
	@Then("status of request is \"approved\"")
	public void thenStatusOfRequestIsapproved(){
		 assertThat("Authorization is successful", successMessage, containsString("Authorization is successful"));

	}
}
