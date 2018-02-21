package com.mastercard.pts.integrated.issuing.steps.restapi;

import java.util.Map;
import java.util.Optional;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;
import com.mastercard.pts.integrated.issuing.domain.restapi.DeviceDetails;
import com.mastercard.pts.integrated.issuing.domain.restapi.JsonRequestResponseParameters;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.pts.integrated.issuing.utils.restapi.JsonUtil;

@Component
public class RestStepDefinitions {

	@Autowired
	JsonUtil jsonutil;
	@Autowired
	JsonRequestResponseParameters reqResParams;
	@Autowired
	DeviceDetails deviceDetails;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private DataLoader dataLoader;

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

	@When("user send put request")
	public void sendPutRequest() {
		reqResParams.setResponse(jsonutil.putRequest(reqResParams
				.getUpdatedReq()));

	}

	@Then("Validate Response for <validate>")
	public void validateResponse(@Named("validate") String value) {
		jsonutil.validateResponse(reqResParams.getResponse(), value);
	}
	@Given("user update $jsonFile with below Attributes:$attributeTable")
	@Then("user update $jsonFile with below Attributes:$attributeTable")
	public void userUpdateJsonWithMultipleAttributes(
			@Named("jsonFile") String jsonFile,
			@Named("attributeTable") ExamplesTable attributeTable) {
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInputs(
				jsonFile, attributeTable));
	}
	@Given("user update $jsonFile file")
	public void userUpdateJsonWithExcelData(@Named("jsonFile") String jsonfile,@Named("datasheet") String datasheet) {
       //  Map<String, String> reqMap=context.get(TestContext.KEY_STORY_DATA);
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithExcel(
				jsonfile, reqMap));
	}
	@When("user send post request with updateded attributes")
	@Then("user send post request with updateded attributes")
	public void sendPostRequestWithMultipleAttributes() {
		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq()));
	}
	@When("user send post request at $endPoint")
	@Then("user send post request at $endPoint")
	public void sendPostRequestAtEndPoint(String endPoint) {
		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq(),endPoint));
	}
	@Then("user send put request with updateded attributes")
	@When("user send put request with updateded attributes")
	public void sendPutRequestWithMultipleAttributes() {
		reqResParams.setResponse(jsonutil.putRequest(reqResParams
				.getUpdatedReq()));
	}
	
	@Then("user send put request having parametr as $parameter with updateded attributes")
	@When("user send put request having parametr as $parameter with updateded attributes")
	public void sendPutRequestWithMultipleAttributesHavingParameter(@Named("parameter") String parameter) {
		reqResParams.setResponse(jsonutil.putRequest(reqResParams
				.getUpdatedReq(), parameter));
	}

	@Then("Validate Response for below Attributes:$attributeTable")
	public void validateResponseWithMultipleAttributes(
			@Named("attributeTable") ExamplesTable attributeTable) {
		jsonutil.validateResponse(attributeTable, reqResParams.getResponse());
	}
	
	@Then("Validate Status code as $statusCode")
	public void validateStatusCode(@Named("parameter") int statusCode) {
		jsonutil.validateStatusCode(statusCode, reqResParams.getResponse());
	}

	@Then("check link status")
	public void checkWalletLinkStatus() {
		deviceDetails.checkWalletLinkStatus();
	}
	@Then("check Delink status")
	public void checkWalletDelinkStatus() {
		deviceDetails.checkWalletDelinkStatus();
	}
	@Then("store $transactionId for furtheruse")
	public void storeTransactionIdForFetchAvailableDevicesAPI(
			String transactionId) {
		deviceDetails.setTransactionId(reqResParams.getResponse().path(
				transactionId));
	}

}