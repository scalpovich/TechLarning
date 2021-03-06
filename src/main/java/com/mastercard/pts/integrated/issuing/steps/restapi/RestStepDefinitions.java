package com.mastercard.pts.integrated.issuing.steps.restapi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
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

	@Given("user updates $jsonFile with <field>")
	public void userCallService(@Named("jsonFile") String jsonFile,
			@Named("field") String field) {
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInput(
				jsonFile, field));
	}

	@When("user sends post request")
	public void sendPostRequest() {

		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq()));

	}

	@When("user sends put request")
	public void sendPutRequest() {
		reqResParams.setResponse(jsonutil.putRequest(reqResParams
				.getUpdatedReq()));

	}

	@Then("Validate Response for <validate>")
	public void validateResponse(@Named("validate") String value) {
		jsonutil.validateResponse(reqResParams.getResponse(), value);
	}
	@Given("user updates $jsonFile with below Attributes:$attributeTable")
	@Then("user updates $jsonFile with below Attributes:$attributeTable")
	public void userUpdateJsonWithMultipleAttributes(
			@Named("jsonFile") String jsonFile,
			@Named("attributeTable") ExamplesTable attributeTable) {
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInputs(
				jsonFile, attributeTable));
	}
	@Given("user updates $jsonFile file")
	public void userUpdateJsonWithExcelData(@Named("jsonFile") String jsonfile,@Named("datasheet") String datasheet) {
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithExcel(
				jsonfile, reqMap));
	}
	@Given("user creates json request")
	public void userCreateJsonWithExcelData(@Named("datasheet") String datasheet) {
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		reqResParams.setUpdatedReq(jsonutil.createJsonFileWithExcel(reqMap));
	}
	@When("user sends post request with updateded attributes")
	@Then("user sends post request with updateded attributes")
	public void sendPostRequestWithMultipleAttributes() {
		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq()));
	}
	@When("user sends post request at $endPoint")
	@Then("user sends post request at $endPoint")
	public void sendPostRequestAtEndPoint(String endPoint) {
		reqResParams.setResponse(jsonutil.postRequest(reqResParams
				.getUpdatedReq(),endPoint));
	}
	@Then("user sends put request with updateded attributes")
	@When("user sends put request with updateded attributes")
	public void sendPutRequestWithMultipleAttributes() {
		reqResParams.setResponse(jsonutil.putRequest(reqResParams
				.getUpdatedReq()));
	}
	
	@Then("user sends put request having parametr as $parameter with updateded attributes")
	@When("user sends put request having parametr as $parameter with updateded attributes")
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
	@Given("store $transactionId for furtheruse")
	@When("store $transactionId for furtheruse")
	@Then("store $transactionId for furtheruse")
	public void storeTransactionIdForFetchAvailableDevicesAPI(
			String transactionId) {
		deviceDetails.setTransactionId(reqResParams.getResponse().path(
				transactionId));
	}
	@Given("user update $jsonFile file to send post request at $endPoint and validate data")
	public void userUpdateJsonAndValidateDataDriven(@Named("jsonFile") String jsonfile,@Named("datasheet") String datasheet,@Named("endPoint") String endPoint) {
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		for(Entry<String, String> entry: reqMap.entrySet()){
			reqResParams.setUpdatedReq(jsonutil.updateJasonFileWithUserInput(
					jsonfile, entry.getKey()));
			reqResParams.setResponse(jsonutil.postRequest(reqResParams
					.getUpdatedReq(),endPoint));
			jsonutil.validateResponse(reqResParams.getResponse(), entry.getValue());
			
		}
	}

}