package com.mastercard.pts.integrated.issuing.rest.api.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.rest.api.domain.DeviceDetails;
import com.mastercard.pts.integrated.issuing.rest.api.domain.JsonRequestResponseParameters;
import com.mastercard.pts.integrated.issuing.rest.api.utils.JsonUtil;
@Component
public class RestStepDefinitions {

	@Autowired
	JsonUtil jsonutil;
	@Autowired
	JsonRequestResponseParameters reqResParams;
	@Autowired
	DeviceDetails deviceDetails;

	final Logger logger = LoggerFactory.getLogger(RestStepDefinitions.class);

	@Given("user update $jsonFile with <field>")
	public void userCallService(@Named("jsonFile") String jsonFile,
			@Named("field") String field) {
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInput(
				jsonFile, field));
	}

	@When("user send post request")
	public void sendPostRequest() {

		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq()));

	}

	@Then("Validate Response for <validate>")
	public void validateResponse(@Named("validate") String value) {
		jsonutil.validateResponse(reqResParams.getResponse(), value);
	}

	@Given("user update $jsonFile with below Attributes:$attributeTable")
	public void userUpdateJsonWithMultipleAttributes(
			@Named("jsonFile") String jsonFile,
			@Named("attributeTable") ExamplesTable attributeTable) {
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInputs(
				jsonFile, attributeTable));
	}

	@When("user send post request with updateded attributes")
	public void sendPostRequestWithMultipleAttributes() {
		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq()));
	}

	@Then("Validate Response for below Attributes:$attributeTable")
	public void validateResponseWithMultipleAttributes(
			@Named("attributeTable") ExamplesTable attributeTable) {
		jsonutil.validateResponse(attributeTable, reqResParams.getResponse());
	}

	@Then("store $transactionId for fetchAvailableDevicesAPI")
	public void storeTransactionIdForFetchAvailableDevicesAPI(
			String transactionId) {
		deviceDetails.setTransactionId(reqResParams.getResponse().path(
				transactionId));
	}

}