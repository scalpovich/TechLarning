package com.mastercard.pts.integrated.issuing.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mastercard.testing.mtaf.jbehave.alm.AlmReportScenario;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.CreateRequest;
import com.rallydev.rest.request.GetRequest;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.response.CreateResponse;
import com.rallydev.rest.response.GetResponse;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.util.Fetch;
import com.rallydev.rest.util.QueryFilter;
import com.rallydev.rest.util.Ref;

public class CustomRallyReport {	
	protected final Logger log = Logger.getLogger(getClass());
	public Map<String, String> testStaticMap;
	private final String FORMATTED_ID = "FormattedID";
	private final String SUCCESSFUL= "Successful: %s";
	private final String RESPONSE_SIZE = "Size: %s";
	private final String TEST_FOLDER = "TestFolder.Name";
	private final String TESTSET_NAME ="TestSet.Name";
	private final String TEST_CASE ="Test Case";
	private final String VERDICT = "Verdict";	
	private URI host ;       
	private String applicationName;
	private String workspaceRef;
	private String wsapiVersion;
	private String rallyKey;
	private String user;
	private String buildnumber;
	private RallyRestApi restApi = null;
	private HashMap<String, String> testRefMap;
	private String userRef ;
	public String testSetRef;
	public CustomRallyReport()
	{
		try {			
			this.initialize();
			this.setUserRef();
			this.setTestSetRefByID( System.getProperty("testsetid"));			
		} catch (URISyntaxException e) {
			log.error(String.format("Exception occured : %s",e.getMessage()));
			MiscUtils.propagate(e);
		}    
	}
	
	public void initialize() throws URISyntaxException
	{

		if(System.getProperty("rallyurl") != null)
			this.host = new URI(System.getProperty("rallyurl"));
		else
			this.host = new URI("https://rally1.rallydev.com");	
		
		if(System.getProperty("rallyKey") != null)
			this.rallyKey = System.getProperty("rallyKey");
		else
			this.rallyKey = "_Bva1JF94QqaKTIoIpturGxDtZViMEXkmLkoRoYUN9I";
		
		if(System.getProperty("workspaceRef") != null)
			this.workspaceRef = "/workspace/"+System.getProperty("workspaceRef");
		else
			this.workspaceRef = "/workspace/140684057244";
		
		if(System.getProperty("user") != null)
			this.user = System.getProperty("user");
		else
			this.user = "e075211";		
		
		if(System.getProperty("buildnumber") != null)
			this.buildnumber = System.getProperty("buildnumber");
		else
			this.buildnumber = "defaultBuild";
		
		this.testStaticMap = new HashMap<>();	
		this.wsapiVersion = "v2.0";
		this.restApi = new RallyRestApi(host, this.rallyKey); 
		this.restApi.setWsapiVersion(wsapiVersion);
		this.restApi.setApplicationName(applicationName);   
		this.restApi.setWsapiVersion(wsapiVersion);		
	}

	public URI getHost() {
		return host;
	}


	public void setHost(URI host) {
		this.host = host;
	}


	public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	public String getWorkspaceRef() {
		return workspaceRef;
	}


	public void setWorkspaceRef(String workspaceRef) {
		this.workspaceRef = workspaceRef;
	}


	public String getWsapiVersion() {
		return wsapiVersion;
	}


	public void setWsapiVersion(String wsapiVersion) {
		this.wsapiVersion = wsapiVersion;
	}


	public RallyRestApi getRestApi() {
		return restApi;
	}


	public void setRestApi(RallyRestApi restApi) {
		this.restApi = restApi;
	}

	public Map<String, String> getTestRefMap() {
		return testRefMap;
	}



	public String getUserRef() {
		return userRef;
	}

	public Map<String, String> getTestStaticMap() {
		return testStaticMap;
	}

	

	public String getRallyKey() {
		return rallyKey;
	}

	public void setRallyKey(String rallyKey) {
		this.rallyKey = rallyKey;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Logger getLog() {
		return log;
	}

	public void setTestSetRef(String testSetRef) {
		this.testSetRef = testSetRef;
	}

	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}	

	public String getBuildnumber() {
		return buildnumber;
	}

	public void setBuildnumber(String buildnumber) {
		this.buildnumber = buildnumber;
	}

	public void setUserRef() 
	{
		try{
			QueryRequest userRequest = new QueryRequest("User");
			userRequest.setFetch(new Fetch("UserName", "Subscription", "DisplayName", "SubscriptionAdmin"));
			userRequest.setQueryFilter(new QueryFilter("UserName", "=", this.getUser()+"@mastercard.com"));
			QueryResponse userQueryResponse = restApi.query(userRequest);
			JsonArray userQueryResults = userQueryResponse.getResults();
			JsonElement userQueryElement = userQueryResults.get(0);
			JsonObject userQueryObject = userQueryElement.getAsJsonObject();
			this.userRef = resolveRef(userQueryObject.get("_ref").getAsString());  
			log.info(String.format("User Ref: %s])", userRef));
		}catch(IOException ex)
		{
			log.error(String.format("Exception occured : %s",ex.getMessage()));
			MiscUtils.propagate(ex);
		}
	}

	public ArrayList<String> getTestIDByTestSetName(String testSetName) 
	{
		ArrayList<String> testList = new ArrayList<String>();
		try
		{
			String testCaseRef ="";	
			log.info(String.format("%s","Fetching Test By Test Set Name"));
			QueryRequest testRequest = new QueryRequest(TEST_CASE);
			testRequest.setFetch(new Fetch("Name", TESTSET_NAME, FORMATTED_ID));
			testRequest.setQueryFilter(new QueryFilter(TESTSET_NAME, "=", testSetName));       
			testRequest.setPageSize(1000);
			QueryResponse testQueryResponse = restApi.query(testRequest);        
			log.info(String.format(SUCCESSFUL, testQueryResponse.wasSuccessful()));
			log.info(String.format(RESPONSE_SIZE,testQueryResponse.getTotalResultCount()));
			for (int iCount =0; iCount <testQueryResponse.getTotalResultCount();iCount++){
				JsonObject testSetJsonObject = testQueryResponse.getResults().get(iCount).getAsJsonObject();	       
				log.info(String.format(testSetJsonObject.get(FORMATTED_ID).toString()));  
				testCaseRef = resolveRef(testSetJsonObject.get("_ref").getAsString());
				testStaticMap.put(testSetJsonObject.get(FORMATTED_ID).toString(), testCaseRef);
				testList.add(testSetJsonObject.get(FORMATTED_ID).toString());
			}   
			return testList;
		}catch(IOException ex)
		{
			MiscUtils.propagate(ex);
		}
		return testList;
	}

	public ArrayList<String> getTestIDByTestSetID(String testSetID) 
	{
		MiscUtils.reportToConsole("Inside getTestIDByTestSetID");
		ArrayList<String> testList = new ArrayList<>();
		try
		{

			String testCaseRef ="";	  
			log.info(String.format("%s","Fetching Test By Test Set ID"));
			QueryRequest testRequest = new QueryRequest(TEST_CASE);
			testRequest.setFetch(new Fetch(new String[] {"Name", TESTSET_NAME, FORMATTED_ID}));
			testRequest.setQueryFilter(new QueryFilter("TestSet.FormattedID", "=", testSetID));       
			testRequest.setPageSize(1000);
			QueryResponse testQueryResponse = restApi.query(testRequest);        
			log.info(String.format(SUCCESSFUL, testQueryResponse.wasSuccessful()));
			log.info(String.format(RESPONSE_SIZE,testQueryResponse.getTotalResultCount()));
			for (int iCount =0; iCount <testQueryResponse.getTotalResultCount();iCount++){
				JsonObject testSetJsonObject = testQueryResponse.getResults().get(iCount).getAsJsonObject();
				log.info(String.format("Test ID %s",testSetJsonObject.get(FORMATTED_ID)));  	   
				testCaseRef = resolveRef(testSetJsonObject.get("_ref").getAsString());
				testStaticMap.put(testSetJsonObject.get(FORMATTED_ID).toString(), testCaseRef);
				testList.add(testSetJsonObject.get(FORMATTED_ID).toString());   

			}   
			return testList;
		}catch(IOException ex)
		{
			MiscUtils.propagate(ex);
		}
		return testList;
	}

	//Resolve test ref from json string
	public String resolveRef(String jsonString)	
	{
		log.info(String.format("Reference %s ",jsonString.substring(jsonString.lastIndexOf('/'))));
		return jsonString.substring(jsonString.lastIndexOf('/'));		
	}

	public ArrayList<String> getTestByFolderName(String testFolderName) throws IOException
	{
		log.info(String.format("%s","Fetch Test By Test Folder Name"));
		ArrayList<String>  testList = new ArrayList<>();
		// Fetch tests by test folder name
		//create new QueryRequest
		QueryRequest tests = new QueryRequest(TEST_CASE);
		//Gets the information from QueryFilter
		tests.setFetch(new Fetch(FORMATTED_ID,"Name","Owner","Test Folder"));       
		//checks to see if the test Case's test folder matches the given one
		QueryFilter testFolderFilter = new QueryFilter(TEST_FOLDER, "=", testFolderName);
		// set query filter
		tests.setQueryFilter(testFolderFilter);
		tests.setPageSize(1000);
		//Query Rally
		QueryResponse testFolderqueryResponse = restApi.query(tests);
		log.info(String.format(SUCCESSFUL,testFolderqueryResponse.wasSuccessful()));
		log.info(String.format(RESPONSE_SIZE, testFolderqueryResponse.getTotalResultCount()));
		for (int i=0; i<testFolderqueryResponse.getResults().size();i++){
			JsonObject testSetJsonObject = testFolderqueryResponse.getResults().get(i).getAsJsonObject();
			log.info(String.format("FormattedID: %s Name: %s ref: %s Test Folder: %s",testSetJsonObject.get(FORMATTED_ID) ,testSetJsonObject.get("Name") , testSetJsonObject.get("_ref").getAsString() , testSetJsonObject.get(TEST_FOLDER)));
			testList.add(testSetJsonObject.get(FORMATTED_ID).toString());
		}
		return testList;

	}

	public String getTestRefByID(String testID) 
	{
		String ref = "";
		try{
			log.info(String.format("%s","Fetch Test By Test Folder Name"));
			// Fetch tests by test folder name
			//create new QueryRequest
			QueryRequest tests = new QueryRequest(TEST_CASE);
			//Gets the information from QueryFilter
			tests.setFetch(new Fetch(FORMATTED_ID,"Name","Owner","Test Folder"));       
			//checks to see if the test Case's test folder matches the given one
			QueryFilter testFolderFilter = new QueryFilter(FORMATTED_ID, "=", testID);
			// set query filter
			tests.setQueryFilter(testFolderFilter);
			tests.setPageSize(1000);
			//Query Rally
			QueryResponse testFolderqueryResponse = restApi.query(tests);
			log.info(String.format(SUCCESSFUL,testFolderqueryResponse.wasSuccessful()));
			MiscUtils.reportToConsole(RESPONSE_SIZE + testFolderqueryResponse.getTotalResultCount());
			for (int i=0; i<testFolderqueryResponse.getResults().size();i++){
				JsonObject testSetJsonObject = testFolderqueryResponse.getResults().get(i).getAsJsonObject();
				log.info(String.format("FormattedID: %s Name: %s ref: %s Test Folder: %s",testSetJsonObject.get(FORMATTED_ID) ,testSetJsonObject.get("Name") , testSetJsonObject.get("_ref").getAsString() , testSetJsonObject.get(TEST_FOLDER)));
				ref = testSetJsonObject.get("_ref").getAsString();	           
			}
			return ref;
		}catch(IOException ex)
		{
			MiscUtils.propagate(ex);
		}
		return ref;

	}

	//get Test Set ID by Name
	public void getTestSetIDbyName(String testSetName) throws IOException
	{
		log.info(String.format("%s","Fetch Test Set ID By Test Set Name"));
		// Fetch tests by test set name
		QueryRequest testSetRequest = new QueryRequest("Test Set");
		testSetRequest.setFetch(new Fetch("Name", FORMATTED_ID));
		testSetRequest.setQueryFilter(new QueryFilter("Name", "=", testSetName)); 
		testSetRequest.setPageSize(1000);
		QueryResponse testSetQueryResponse = restApi.query(testSetRequest);        
		log.info(String.format("Successful: %s" ,testSetQueryResponse.wasSuccessful()));
		log.info(String.format("Size: %s" , testSetQueryResponse.getTotalResultCount()));
		for (int i=0; i<testSetQueryResponse.getTotalResultCount();i++){
			JsonObject testSetJsonObject = testSetQueryResponse.getResults().get(i).getAsJsonObject();	           
			log.info(String.format("%s",testSetJsonObject.get(FORMATTED_ID)));          
		}        
	}

	//Get Test Set Reference by Test Set Name 
	public void setTestSetRefByID(String testSetID)
	{
		try{
			log.info(String.format("%s","Fetch Test Set Ref By Test Set ID"));
			// Fetch tests by test set name
			QueryRequest testSetRequest = new QueryRequest("Test Set");
			testSetRequest.setFetch(new Fetch("Name", FORMATTED_ID));
			testSetRequest.setQueryFilter(new QueryFilter(FORMATTED_ID, "=", testSetID)); 
			testSetRequest.setPageSize(1000);
			QueryResponse testSetQueryResponse = restApi.query(testSetRequest);        
			log.info(String.format(SUCCESSFUL,testSetQueryResponse.wasSuccessful()));
			log.info(String.format(RESPONSE_SIZE , testSetQueryResponse.getTotalResultCount()));
			for (int i=0; i<testSetQueryResponse.getTotalResultCount();i++){
				JsonObject testSetJsonObject = testSetQueryResponse.getResults().get(i).getAsJsonObject();
				log.info(String.format("FormattedID: %s Name: %s ref: %s Test Set: %s",testSetJsonObject.get(FORMATTED_ID) ,testSetJsonObject.get("Name") , testSetJsonObject.get("_ref").getAsString() , testSetJsonObject.get("Name")));
				this.testSetRef = resolveRef(testSetJsonObject.get("_ref").getAsString());          
			}
		}catch(IOException ex)
		{
			MiscUtils.propagate(ex);
		}
	}

	//Update Test Results 
	public void updateTestResult(AlmReportScenario almScenario,String status)
	{		
		Date d = new Date();
		DateFormat iso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");		
		String dateStr =  iso.format(d);	
		log.info(String.format("<=== Updating result in Rally Test Case ID : %s with staus %s Execution Date %s", almScenario.getTestCaseID(), status,dateStr+"Z"));
		try {	
			log.info(String.format("%s","<=== Creating Test Case Result..."));
			JsonObject newTestCaseResult = new JsonObject();
			newTestCaseResult.addProperty(VERDICT, status);
			newTestCaseResult.addProperty("Date",iso.format(d)+"Z");
			newTestCaseResult.addProperty("Notes", "Automated Test Execution");
			newTestCaseResult.addProperty("Build", this.getBuildnumber());		  
			newTestCaseResult.addProperty("Tester", "user"+getUserRef());
			newTestCaseResult.addProperty("TestCase", "testcase"+getTestRefByID(almScenario.getTestCaseID()));
			newTestCaseResult.addProperty("TestSet", "testset"+getTestSetRef());	
			CreateRequest createRequest = new CreateRequest("testcaseresult", newTestCaseResult);
			CreateResponse createResponse = restApi.create(createRequest);  
			if (createResponse.wasSuccessful()) {	
				log.info(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));   
				//Read Test Case
				String ref = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
				log.info(String.format("Reading Test Case Result %s...", ref));
				GetRequest getRequest = new GetRequest(ref);
				getRequest.setFetch(new Fetch("Date", VERDICT));
				GetResponse getResponse = restApi.get(getRequest);
				JsonObject obj = getResponse.getObject();
				log.info(String.format("Read Test Case Result Date = %s, Verdict = %s",
						obj.get("Date").getAsString(), obj.get(VERDICT).getAsString()));                 
			} else {
				String[] createErrors;
				createErrors = createResponse.getErrors();
				log.info(String.format("%s","Error occurred creating Test Case Result: "));	                   
				for (int jCount=0; jCount < createErrors.length;jCount++) {
					log.info(String.format(createErrors[jCount]));
				}
			}
		} catch(IOException ex)
		{
			MiscUtils.propagate(ex);
		}
	}

	private String getTestSetRef() {
		return testSetRef;
	}   
}
