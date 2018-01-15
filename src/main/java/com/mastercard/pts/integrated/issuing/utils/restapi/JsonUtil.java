package com.mastercard.pts.integrated.issuing.utils.restapi;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jbehave.core.model.ExamplesTable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.mastercard.pts.integrated.issuing.domain.restapi.DeviceDetails;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

@Component
public class JsonUtil extends AbstractBaseSteps {
	final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	public static final String REQ_JSON_FILE_PATH = "src\\main\\resources\\webServiceRequestJsons\\";
	public static final String DN_KEY = "X-Client-DN";
	public static final String DEMO_CARDACTIVATION_DN_VALUE = "CN=virgo01.mi.dev.mastercard.int,OU=Server 00,O=Mastercard Worldwide,L=St Louis,S=Missouri,C=US";
	public static final String STAGE_CARDACTIVATION_DN_VALUE = "CN=Airtel-Stage,OU=sa-stage-internalclient,O=MasterCard Worldwide - Corp Netw Infra,L=Saint Louis,ST=Missouri,C=US";
	public static final String CARD_ACTIVATION_END_POINT = "/cardactivation";
	public static final String CARD_LINK_END_POINT = "/wallet?action=link";
	public static final String CARD_DELINK_END_POINT = "/wallet?action=delink";
	public static final int STATUS_CODE_SUCCESS = 200;
	public static final String STATUS_CODELINE_SUCCESS = "ok";
	File jsonFile;
	ObjectMapper mapper;
	ArrayList<Map<String, Object>> reqMapObject;
	ArrayList<Map<String, Object>> resMapObject;

	Map<String, Object> reqMapObject1;
	ArrayList<Map<String, Object>> resMapObject1;
	Response response;
	JSONObject jsonObject;
	JSONParser parser;
	Object obj;

	@Autowired
	DeviceDetails deviceDetails;
	@Autowired
	RestAssuredConfiguration restAssuredConfiguration;

	public List<Map<String, Object>> parseToListMap(String jsonFilePath) {
		mapper = new ObjectMapper();
		jsonFile = new File(jsonFilePath);
		try {
			reqMapObject = mapper.readValue(jsonFile,
					new TypeReference<ArrayList<Map<String, Object>>>() {
					});
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return reqMapObject;

	}

	public Map<String, Object> parseToMap(String jsonFilePath) {
		mapper = new ObjectMapper();
		jsonFile = new File(jsonFilePath);
		try {
			reqMapObject = mapper.readValue(jsonFile,
					new TypeReference<Map<String, Object>>() {
					});
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return reqMapObject1;

	}

	public List<Map<String, Object>> parseResponseToListMap(
			String responseContent) {
		mapper = new ObjectMapper();
		try {
			reqMapObject = mapper.readValue(responseContent,
					new TypeReference<ArrayList<Map<String, Object>>>() {
					});
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return reqMapObject;

	}

	public Response postRequest(String reqObject) {
		RestAssured.baseURI = env.getProperty("api.base.uri");
		response = given().body(reqObject).when().contentType(ContentType.JSON)
				.post(CARD_ACTIVATION_END_POINT);
		logger.info("**********Request String:" + reqObject.toString());
		logger.info("**********Response String:"
				+ response.asString().toString());
		return response;

	}

	public Response putRequest(String reqObject) {
		RestAssured.config = restAssuredConfiguration.getRestAssuredConfig();
		RestAssured.baseURI = restAssuredConfiguration.getbaseUrl();

		response = given().header(DN_KEY, STAGE_CARDACTIVATION_DN_VALUE)
				.body(reqObject).when().contentType(ContentType.JSON).put("");
		logger.info("**********Request String:" + reqObject.toString());
		logger.info("**********Response String:"
				+ response.asString().toString());
		return response;

	}

	public Response putRequest(String reqObject, String parameter) {
		RestAssured.config = restAssuredConfiguration.getRestAssuredConfig();
		RestAssured.baseURI = restAssuredConfiguration.getbaseUrl();
		response = given().header(DN_KEY, STAGE_CARDACTIVATION_DN_VALUE)
				.parameters("action", parameter).body(reqObject).when()
				.contentType(ContentType.JSON).put("");
		logger.info("**********Request String:" + reqObject.toString());
		logger.info("**********Response String:"
				+ response.asString().toString());
		return response;

	}

	public void validateResponse(ExamplesTable attributeTable, Response response) {
		for (int row = 0; row < attributeTable.getRows().size(); row++) {
			String input = attributeTable.getRow(row).get(
					attributeTable.getHeaders().get(0));
			String actualData = input.split("=")[0];
			String expectedData = input.split("=")[1];
			response.then().body(actualData, equalTo(expectedData));
			logger.info("Status Code" + response.getStatusCode());
			logger.info("Status Line" + response.getStatusLine());

		}

	}

	public void validateStatusCode(int statusCode, Response response) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}

	public void validateResponse(Response response, String input) {
		String actualData = input.split("=")[0];
		String expectedData = input.split("=")[1];
		response.then().body(actualData, equalTo(expectedData));

	}

	public List<Map<String, Object>> updateJsonWithAttributes(
			ExamplesTable attributeTable) {

		for (int row = 0; row < attributeTable.getRows().size(); row++) {
			for (int attr = 0; attr < attributeTable.getHeaders().size(); attr++) {
				String attrKey = attributeTable.getHeaders().get(attr);
				String attrValue = attributeTable.getRow(row).get(
						attributeTable.getHeaders().get(attr));

				reqMapObject.get(row).put(attrKey, attrValue);
			}
		}

		return reqMapObject;

	}

	public String updateJasonFileWithUserInput(String filepath, String input) {

		return updateJasonFile(REQ_JSON_FILE_PATH + filepath, input);
	}

	public String updateJasonFileWithUserInputs(String filepath,
			ExamplesTable attributeTable) {

		return updateJasonFileWithAttributes(REQ_JSON_FILE_PATH + filepath,
				attributeTable);
	}

	public String updateJasonFile(String filepath, String input) {
		LinkedList<JSONObject> tempJdata = new LinkedList<>();
		parser = new JSONParser();
		String[] params = null;
		String updateKey = null;
		String updateValue = null;

		if (input.contains(":")) {
			String[] inputArray = input.split(":");
			params = inputArray[0].split(",");
			String[] expectedKeyValue = inputArray[1].split("=");
			updateKey = expectedKeyValue[0];
			updateValue = getData(expectedKeyValue.length > 1 ? expectedKeyValue[1]
					: null);

		} else {
			String[] expectedKeyValue = input.split("=");
			updateKey = expectedKeyValue[0];
			updateValue = getData(expectedKeyValue.length > 1 ? expectedKeyValue[1]
					: null);

		}

		try {
			obj = parser.parse(new FileReader(filepath));

			jsonObject = (JSONObject) obj;

			Map jData = null;

			if (null != params) {
				tempJdata.add(jsonObject);
				int size = params.length;
				for (int i = 0; i < size; i++) {
					jData = (Map) jsonObject.get(params[i]);

					if (size - 1 == i) {
						jData.put(updateKey, updateValue);
						jsonObject = (JSONObject) jData;
					} else {
						jsonObject = (JSONObject) jData;
					}
					tempJdata.add(jsonObject);
				}

			} else {

				jData = (Map) jsonObject;
				jData.put(updateKey, updateValue);
				jsonObject = (JSONObject) jData;
				tempJdata.add(jsonObject);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return tempJdata.get(0).toString();

	}

	// To get the data From DB based on key passed from story file
	public String getData(String value) {
		String valueToUpdate = value;
		switch (valueToUpdate) {
		case "ActivateCPI":
			deviceDetails.getCPICRDDataFromDB();
			valueToUpdate = deviceDetails.getCardPackID();
			break;
		case "ActivateCRD":
			deviceDetails.getCPICRDDataFromDB();
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "ActivatedCRD":
			deviceDetails
					.getCardStatusFromDB(DeviceDetails.GETACTIVATEDCARDQUERY);
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "Cancelled":
			deviceDetails
					.getCardStatusFromDB(DeviceDetails.GETCANCELLEDCARDQUERY);
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "Expired":
			deviceDetails
					.getCardStatusFromDB(DeviceDetails.GETEXPIREDCARDQUERY);
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "Stoplisted":
			deviceDetails
					.getCardStatusFromDB(DeviceDetails.GETSTOPLISTEDCARDQUERY);
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "GetDevice":
			valueToUpdate = deviceDetails.getDataFromDB(
					DeviceDetails.GETDEVICE, DeviceDetails.DEVICENUMBERCOLUMN);
			deviceDetails.setDeviceNumber(valueToUpdate);
			break;
		case "GenrateDefaultWalletNum":
			valueToUpdate = CustomUtils.randomNumbers(Integer
					.parseInt(deviceDetails.getDataFromDB(
							DeviceDetails.GETCLIENTLENGTH,
							DeviceDetails.CLIENTLENGTHCOLUMN)));
			deviceDetails.setDefaultWallet(valueToUpdate);
			break;
		case "GenrateCustomWalletNum":
			valueToUpdate = CustomUtils.randomNumbers(Integer
					.parseInt(deviceDetails.getDataFromDB(
							DeviceDetails.GETCLIENTLENGTH,
							DeviceDetails.CLIENTLENGTHCOLUMN)));
			deviceDetails.setCustomWallet(valueToUpdate);
			break;
		case "GetDeviceDOM":
			valueToUpdate = deviceDetails.getDeviceNumber();
			break;
		case "GetDefaultWalletDOM":
			valueToUpdate = deviceDetails.getDefaultWallet();
			break;
		case "GetCustomWalletDOM":
			valueToUpdate = deviceDetails.getCustomWallet();
			break;
		default:

		}

		return valueToUpdate;
	}

	public String updateJasonFileWithAttributes(String filepath,
			ExamplesTable attributeTable) {
		LinkedList<JSONObject> tempJdata = new LinkedList<>();
		parser = new JSONParser();
		String updatedString = null;
		String[] params = null;
		String updateKey = null;
		String updateValue = null;
		try {
			obj = parser.parse(new FileReader(filepath));
		} catch (Exception e) {

			logger.error(e.toString());
		}
		for (int r = 0; r < attributeTable.getRowCount(); r++) {
			String input = attributeTable.getRow(r).get(
					attributeTable.getHeaders().get(0));
			if (input.contains(":")) {
				String[] inputArray = input.split(":");
				params = inputArray[0].split(",");
				String[] expectedKeyValue = inputArray[1].split("=");
				updateKey = expectedKeyValue[0];
				updateValue = getData(expectedKeyValue.length > 1 ? expectedKeyValue[1]
						: null);

			} else {
				String[] expectedKeyValue = input.split("=");
				updateKey = expectedKeyValue[0];
				updateValue = getData(expectedKeyValue.length > 1 ? expectedKeyValue[1]
						: null);

			}

			jsonObject = (JSONObject) obj;

			Map jData = null;

			if (null != params) {
				tempJdata.add(jsonObject);
				int size = params.length;
				for (int i = 0; i < size; i++) {
					jData = (Map) jsonObject.get(params[i]);

					if (size - 1 == i) {
						jData.put(updateKey, updateValue);
						jsonObject = (JSONObject) jData;
					} else {
						jsonObject = (JSONObject) jData;
					}
					tempJdata.add(jsonObject);
				}

			} else {

				jData = (Map) jsonObject;
				jData.put(updateKey, updateValue);
				jsonObject = (JSONObject) jData;
				tempJdata.add(jsonObject);
			}
			updatedString = tempJdata.get(0).toString();
		}
		return updatedString;
	}
}
