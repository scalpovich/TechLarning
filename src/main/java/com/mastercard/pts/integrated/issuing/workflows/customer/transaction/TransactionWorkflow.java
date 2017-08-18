package com.mastercard.pts.integrated.issuing.workflows.customer.transaction;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.configuration.MasSimulator;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.SimulatorConstantsData;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;

@Workflow
public class TransactionWorkflow extends SimulatorUtilities {
	private static final Logger logger = LoggerFactory.getLogger(TransactionWorkflow.class);

	@Autowired
	private MasSimulator simulator;

	@Autowired
	private FinSimSimulator finSimSimulator;

	@Autowired
	private Navigator navigator;

	private WiniumDriver winiumDriver;
	
	@Autowired
	private TestContext context;

	public void performMASTransaction(Transaction transaction)
	{
		
		selectIPSHostTestModeAndConfigureBinAndHost(transaction);
		performTransaction(transaction);
	}

	public void launchAndConnectToFinSim()
	{
		connectToFINSim();
	}

	public void launchAndConnectToMCPS(){
		selectMCPSLicense();
		wait(5000);
		while(getLoadingMCPSSimulatorWindowCount() > 0) {
			wait(500);
		}
	}

	public Boolean verifyTestResults()
	{
		return verifyResults();
	}

	public void startWiniumDriverWithSimulator(String serviceName) {
		try
		{
			wait(3000);
			DesktopOptions options = launchSimulator(serviceName);
			String path = getResourceFolderPath() + SimulatorConstantsData.WINIUM_DRIVER_EXE_PATH.replace("\\", "\\\\");
			Runtime.getRuntime().exec(path, null, new File( path.replace("Winium.Desktop.Driver.exe", ""))) ;
			//			handleDriverCloseProgramWindow();
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			wait(5000);
		}
		catch(Exception e)
		{
			logger.debug("Exception occurred while starting Winium", e);
			MiscUtils.propagate(e);
		}
	}

	private DesktopOptions launchSimulator(String serviceName) {
		DesktopOptions option = new DesktopOptions();
		if(serviceName.toUpperCase().contains("MAS"))
		{
			option =  launchMAS();
		}
		else if(serviceName.toUpperCase().contains("FINSIM"))
		{
			option =  launchFinSim();
		}
		else if(serviceName.toUpperCase().contains("MCPS"))
		{
			option =  launchMCPS();
		}
		else if(serviceName.toUpperCase().contains("EXPRESSMAP"))
		{
			option =  launchExpressMap();
		}
		return option;
	}

	private DesktopOptions launchMAS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole("Simulator path being set :  " + SimulatorConstantsData.MAS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MAS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchFinSim() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole("Simulator path being set :  " + SimulatorConstantsData.FINSIM_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.FINSIM_EXE_PATH);
		return options;
	}

	private DesktopOptions launchMCPS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole("Simulator path being set :  " + SimulatorConstantsData.MCPS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MCPS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchExpressMap() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole("Simulator path being set :  " + SimulatorConstantsData.EXPRESSMAP_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.EXPRESSMAP_EXE_PATH);
		return options;
	}

	public void performTransaction(Transaction transaction)
	{
		try
		{
			selectTestCaseAndCardType(transaction.getTestCaseToSelect());
			selectCardProfile(transaction.getCardForTransaction());
			editCardProfileDetails(transaction);
			attachCardToTestCase(transaction.getCardForTransaction()); 
			addDataElementsFromDataElementsSubSection(transaction);

			executeAutoITExe("ActivateMASandScrollUpOnCardSection.exe");

			for (Map.Entry<String, String> entry : transaction.getDeKeyValuePair().entrySet()) {
				wait(1000);
				MiscUtils.reportToConsole("DE Element Values : " , entry.getKey() + " ::: " +  entry.getValue());
				//PIN value when BLANK, we do not want to go ahead and make a entry in Data Elements
				if(entry.getValue().toUpperCase() != "BLANK")
				{
					changeDataElement(entry.getKey(), entry.getValue());
					pressPageUp(5);
				}
			}

			String[] caseToSelect = transaction.getTestCaseToSelect().split(">>");
			runTransaction(caseToSelect[caseToSelect.length-1]);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}
	
	public void importCsvFiles(String fileName)
	{
		performClickOperation("importFile");
		wait(2000);
		executeAutoITExe("ImportTestSuite.exe "+ fileName );
	}

	private void addDataElementsFromDataElementsSubSection(Transaction transaction)
	{
		performClickOperation("Data Elements");
		pressTab();
		wait(2000);
		pressPageUp(10);
		performClickOperation("Fields");
		pressRightArrow();	
		for (Map.Entry<String, String> entry : transaction.getDeKeyValuePair().entrySet()) {
			wait(1000);
			MiscUtils.reportToConsole("DE Element being added from Data Elements section : " , entry.getKey());
			String val = entry.getKey()+"_DataElement";
			findDataElementToAdd(val);
		}
		performClickOperation("Card Profiles");
	}

	private void navigateToTestCases(String treePath)
	{
		String[] path = treePath.split(">>");
		for(int i = 0; i< path.length - 1; i++)
		{
			path[i] = path[i].trim().replace(">", "");
			performClickOperation(path[i]);
			pressRightArrow();
		}
		//014
		int finalVal = Integer.parseInt(path[path.length-1]);
		//clicking on 009 so that there is no issue clickin on 014 .. as there is an issue with 004 and 014
		if(finalVal > 10)
		{
			searchForImageAndPerformClick("009");
			pressDownArrow(5);
		}
		//clicking on 009 so that there is no issue clickin on 014 .. as there is an issue with 004 and 014
		if(finalVal > 15)
		{
			pressDownArrow(5);
		}
		searchForImageAndPerformClick(path[path.length-1]);
		wait(2000);
		performClickOperation(path[path.length-1]);
	}

	public void selectTestCaseAndCardType(String treePath)
	{
		//navigating to "Test Preparation" section
		executeAutoITExe("ClickTestPreparation.exe");
		winiumDriver.findElementByName("Allows preparing the test cases").click();
		wait(5000);

		performClickOperation("Test Cases (Issuer Testing)");
		//scrolling page up
		executeAutoITExe("ActivateMASandScrollUpOnTestCases.exe");
		performClickOperation("MAS_16.Q4");
		pressRightArrow();
		performClickOperation("Test Cases");
		pressRightArrow();
		performClickOperation("IssuerTest");
		pressRightArrow();
		navigateToTestCases(treePath);
		wait(7000);
	}
	
	public void importAndLoadTest(String fileName)
	{
		importCsvFiles(fileName);
		selectTestCaseFromImportedCases(fileName);
	}
	
	private void selectTestCaseFromImportedCases(String testcaseName)
	{
		//navigating to "Test Preparation" section
		executeAutoITExe("ClickTestPreparation.exe");
		winiumDriver.findElementByName("Allows preparing the test cases").click();
		wait(5000);

		performClickOperation("Test Cases (Issuer Testing)");
		//scrolling page up
		executeAutoITExe("ActivateMASandScrollUpOnTestCases.exe");
		performClickOperation("MAS_16.Q4");
		pressRightArrow();
		performClickOperation("Test Cases");
		pressRightArrow();
		performClickOperation("Imported");
		pressRightArrow();
		performClickOperation("MyGroup");
		pressRightArrow();
		performClickOperation(testcaseName);
	}


	private void selectCard(String testCase) 
	{
		searchForImageAndPerformClick(testCase);
	}

	private void findDataElementToAdd(String testCase) 
	{
		searchForImageAndPerformDoubleClickforDataElements(testCase);
		executeAutoITExe("ClickYesOnAddSubfields.exe");
		pressPageUp(20);
	}

	private void attachCardToTestCase(String testCase)
	{
		searchForImageAndPerformDoubleClick(testCase);
		pressPageUp(5);
	}

	private void runTransaction(String testCase)
	{
		executeAutoITExe("ActivateMAS.exe");
		performDoubleClickOperation(testCase);
		performDoubleClickOperation("ClearResults");
		executeAutoITExe("HandleClearTestResultsWindow.exe");
		pressEnter();
		performDoubleClickOperation("RunTest");
		wait(5000);
		executeAutoITExe("ActivateStartTestDialogAndClose.exe");
	}

	private Boolean verifyResults()
	{
		executeAutoITExe("ActivateMAS.exe");
		wait(5000);
		winiumDriver.findElementByName("Allows analysing the results").click();
		winiumDriver.findElementByName("Sequential View").click();
		if(isImagePresent("0110_NTW to APS Rcvd"))
		{
			performDoubleClickOperation("0110_NTW to APS Rcvd");
			if(isImagePresent("0110_Response_Approved"))
			{
				performClickOperation("0110_Response_Approved");
				return true;
			}
		}
		return false;
	}

	public String loadAuthFileToMCPS(String fileName)
	{
		loadAuthFileIntoMCPS(fileName);
		return editFieldsAndProcess();
	}

	public void loadIPMFileIntoMCPS(String fileName)
	{

		executeAutoITExe("ActivateMCPS");
		winiumDriver.findElementByName("TDG").click();
		performClickOperation("folder");
		executeAutoITExe("ActivateOpenExistingFileScreen");
		wait(5000);
		try {
			setText(fileName);
			performClickOperation("Open");
			wait(3000);
			performClickOperation("OK");
			wait(2000);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}
	}
	
	
	private void loadAuthFileIntoMCPS(String fileName)
	{

		executeAutoITExe("ActivateMCPS");
		winiumDriver.findElementByName("TDG").click();
		performClickOperation("Down Arrow");
		performClickOperation("Import Auth file");
		executeAutoITExe("ActivateImportAuthFileScreen");
		wait(5000);
		try {
			setText(fileName);
			performClickOperation("Open");
			wait(3000);
			performClickOperation("OK");
			wait(2000);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}
	}

	private String editFieldsAndProcess(){
		String aRN = "";
		try{
			wait(2000);
			executeAutoITExe("ActivateMCPS");
			performClickOperation("Middle Presentment");
			performClickOperation("Message Type Indicator"); // selecting the table
			searchForImageAndPerformDoubleClick("Retrieval Reference Number");
			wait(2000);
			executeAutoITExe("ActivateEditFieldValueScreen");
			String rRN = winiumDriver.findElementByName("Edit DE Value").getText();
			String trimmedRrn = rRN.substring(1, rRN.length());
			winiumDriver.findElementByName("Close").click();

			aRN = addAcquirerReferenceData(trimmedRrn);

			performClickOperation("Message Type Indicator"); // selecting the table
			pressPageUp();
			performClickOperation("Middle Presentment");
			performClickOperation("Message Type Indicator"); // selecting the table
			searchForImageAndPerformDoubleClick("Forwarding Institution Identification Code");
			executeAutoITExe("ActivateEditFieldValueScreen");
			winiumDriver.findElementByName("Edit DE Value").getText();
			setText("");
			setText("999684");
			wait(2000);
			performClickOperation("Set Value");
			wait(2000);
			winiumDriver.findElementByName("Close").click();
			addField();
			loadIpmFile(getIpmFileName());
			assignUniqueFileId();
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields", e);
			MiscUtils.propagate(e);
		}

		return aRN;
	}

	private String addAcquirerReferenceData(String rRN) throws AWTException {
		performClickOperation("Message Type Indicator"); // selecting the table
		pressPageUp();
		performClickOperation("Middle Presentment");
		searchForImageAndPerformDoubleClick("Acquirer Reference Data");
		executeAutoITExe("ActivateEditSubfieldValueScreen");
		performClickOperation("Acquirer Sequence Number");
		wait(2000);
		pressTab(1);
		setText("");
		setText(rRN);
		winiumDriver.findElementByName("OK").click();
		wait(2000);
		performClickOperation("Set Value");
		String aRN = winiumDriver.findElementByName("Edit DE Value").getText();
		wait(2000);
		winiumDriver.findElementByName("Close").click();
		return aRN;
	}

	private void addField() throws AWTException {
		winiumDriver.findElementByName("Add a field to the current message").click();
		wait(3000);
		searchForImageAndPerformDoubleClick("Transaction Originator Institution ID Code");
		executeAutoITExe("ActivateEditFieldValueScreen");
		performClickOperation("AddRemove");
		wait(2000);
		performClickOperation("Bit Map Secondary");
		wait(2000);
		searchForImageAndPerformDoubleClick("093 Transaction Destination");
		winiumDriver.findElementByName("Edit DE Value").getText();
		setText("");
		setText("999684");
		wait(2000);
		performClickOperation("Set Value");
		wait(2000);
		winiumDriver.findElementByName("Close").click();
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
		performClickOperation("Add file to CEE");
		wait(2000);
		winiumDriver.findElementByName("Process File(s)").click();
		executeAutoITExe("GetCEEData");
	}

	private String getIpmFileName() throws IOException{
		String fileData = getFileData("CEEData.txt");
		String [] splitString = fileData.split("\\s+");
		return splitString[5];	
	}

	private void loadIpmFile(String fileName) throws IOException{
		executeAutoITExe("ActivateMCPS");
		winiumDriver.findElementByName("TDG").click();
		performClickOperation("folder"); //open ipm file
		executeAutoITExe("ActivateOpenIPMFileScreen");
		wait(5000);
		try {
			setText(fileName);
			performClickOperation("Open");
			wait(3000);
			performClickOperation("OK");
			wait(2000);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}				
	}

	private void assignUniqueFileId() throws AWTException{
		String fileId = RandomStringUtils.randomNumeric(11);
		performClickOperation("File Header"); // selecting header
		fillFileId(fileId);
		performClickOperation("File Trailer"); // selecting trailer
		fillFileId(fileId);		
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
	}

	private void fillFileId(String value) throws AWTException{
		performDoubleClickOperation("File ID");
		performClickOperation("Processor ID");
		wait(2000);
		pressTab(1);
		setText("");
		setText(value);
		winiumDriver.findElementByName("OK").click();
		wait(2000);
		performClickOperation("Set Value");		
		wait(2000);
		winiumDriver.findElementByName("Close").click();
	}

	public void authFileGeneration()
	{
		try {
			generateAuthFileFromMas();
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public String getFileData(String filePath) throws IOException{
		FileInputStream fis = new FileInputStream(getTempDirectoryLocationForSimulatorResults() + "//" + filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String fileName = br.readLine();
		fis.close();
		return fileName;
	}

	private void generateAuthFileFromMas() throws AWTException
	{
		wait(5000);
		executeAutoITExe("ClickTestResults.exe");
		winiumDriver.findElementByName("Allows analysing the results").click();
		winiumDriver.findElementByName("Sequential View").click();

		performClickOperation("Generate Auth File");
		performClickOperation("Select Auth File");
		wait(5000);
		executeAutoITExe("ActivateImportAuthFileScreen");
		setText(String.valueOf("AuthFileName"));
		pressTab(2);
		pressEnter();
		wait(3000);
	}

	public void selectCardProfile(String cardProfileName)
	{
		executeAutoITExe("ActivateMAS");
		performClickOperation("Card Profiles");
		performClickOperation("CardProfiles_Reference");
		pressLeftArrow();
		performClickOperation("CardProfiles_User");
		pressRightArrow();
		selectCard(cardProfileName); 
		wait(3000);
	}

	private void editCardProfileDetails(Transaction transaction)
	{
		try
		{
			executeAutoITExe("ActivateMAS.exe");
			performClickOperation(transaction.getCardForTransaction());
			//clicking the edit icon ("pen sysmbol")
			performRightClickOperation(transaction.getCardForTransaction());
			wait(1000);
			performClickOperation("Edit Node");
			wait(10000);
			winiumDriver.findElementByName("Typical Data").click();
			wait(2000);
			pressTab();
			setText(transaction.getCardNumber());
			pressTab();
			setText(StringUtils.leftPad(transaction.getTransactionAmount(), 12, "0"));
			pressTab();
			setText(MiscUtils.convertToYYMM(transaction.getExpirationYear()));
			pressTab();
			setText(transaction.getCardSequenceNumber());
			pressTab();
			if(isNotNullAndEmpty(transaction.getPinForTransaction()))
			{
				setText(transaction.getPinForTransaction());
			}
			if(	isNotNullAndEmpty(transaction.getCvvData()))
			{
				winiumDriver.findElementByName("Track Data").click();
				pressTab(6);
				setText("000"+transaction.getCvvData());
				wait(1000);
			}
			winiumDriver.findElementByName("OK").click();
			wait(1000);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void changeDataElement(String dataElement, String value){
		try
		{
			clickDataElements(dataElement);
			executeAutoITExe("ClickEnterValueInDataElementScreen.exe");
			pressTab();
			setText(value);
			executeAutoITExe("ClickOkOnDataElementScreen.exe");
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void selectMCPSLicense(){
		wait(5000);
		executeAutoITExe("ActivateLicenseProfiles.exe");
		performClickOperation("License profiles");
		performClickOperation("Select");
		wait(5000);
	}

	public void selectMASLicenseAndConfigure(String licenseTypeToSelect)
	{
		try
		{
			if(getCountOfLicenseScreen() == 0) {
				wait(1000);
			}

			executeAutoITExe("ActivateLicenseProfiles.exe");
			performDoubleClickOperation(licenseTypeToSelect);
			wait(15000);

			if(getLoadServicesScreen() > 0)	{
				executeAutoITExe("ActivateSelectServices");
				performClickOperation("MAS 16.4");
				pressSpaceBar();
				winiumDriver.findElementByName("Load the services").click();
			}

			wait(5000);
			while(getLoadingSimulatorWindowCount() > 0) {
				wait(500);
			}
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void selectIPSHostTestModeAndConfigureBinAndHost(Transaction transaction) 
	{
		try
		{
			wait(5000);
			executeAutoITExe("ActivateMAS.exe");
			winiumDriver.findElementByName("Allows setting the test mode").click();
			executeAutoITExe("SelectIPSHostTestMode.exe");
			wait(15000);
			waitForImageToAppear("CONNECTED");

			configureBinRange(transaction);

			//change ip and reselefct IPS Host Test Mode
			configureTestOptionsHostAndIP(winiumDriver);
			winiumDriver.findElementByName("Allows setting the test mode").click();
			executeAutoITExe("ReSelectIPSHostTestMode.exe");
			wait(10000);
			winiumDriver.findElementByName("Allows preparing the test cases").click();

			while(getWindowButtonCount() > 0) {
				winiumDriver.findElementByName("OK").click();
				executeAutoITExe("SelectIPSHostTestMode.exe");
				wait(5000);
			}
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void configureBinRange(Transaction transaction)
	{
		String bin = transaction.getCardNumber();
		String currency = transaction.getCurrency();
		try
		{
			if(!isImagePresent("BIN Table"))
			{
				winiumDriver.findElementByName("Allows configuring the options").click();
				wait(2000);
			}
			String binBinMinRange = bin.substring(0, 9) + "00";
			String binMaxBinRange = bin.substring(0, 9) + "99";
			performClickOperation("BIN Table");
			performClickOperation("BIN Table User");
			pressTab(3);
			performClickOperation("Add New");
			wait(10000);
			waitForImageToAppear("Add BIN Range");
			winiumDriver.findElementByName("General").click();
			//			executeAutoITExe("ActivateAddBINrange.exe");
			pressTab();
			setText(binBinMinRange);
			pressTab();
			setText(binMaxBinRange);
			wait(1000);
			pressTab();
			wait(1000);
			pressTab();
			wait(1000);
			pressTab();
			wait(1000);
			setText(currency);
			pressTab();
			setText(currency);
			pressTab();
			setText(currency);
			winiumDriver.findElementByName("OK").click();
			wait(2000);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void closeSimulator(String name) 
	{
		if(name.toUpperCase().contains("MAS"))
		{
			executeAutoITExe("CloseMAS.exe");
		}
		else if(name.toUpperCase().contains("FINSIM"))
		{
			for(int i = 0; i<2; i++)
			{
				performClickOperation("CLOSE");
			}
		}
		winiumDriver = null;
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP(WiniumDriver driver)
	{
		try
		{
			String tempVariable;
			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");

			if(!isImagePresent("TCP_IP"))
			{
				driver.findElementByName("Allows configuring the options").click();
				wait(2000);
			}
			performClickOperation("TCP_IP");
			driver.findElementByName("Client").click();
			driver.findElementByName("Port :").sendKeys(simulator.getPort());
			pressTab();
			for (int i = 0; i<  ip.length; i++)
			{
				tempVariable = stringleftPadWith0(ip[i], 3);
				setText(tempVariable);
				wait(1000);
			}
			pressTab();
			driver.findElementByName("Apply").click();
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private int getLoadingSimulatorWindowCount() {
		List<WebElement> lst = winiumDriver.findElements(By.name("Loading MasterCard Simulator..."));
		MiscUtils.reportToConsole("Waiting for Simulator to Launch");
		return lst.size();
	}

	private int getLoadingMCPSSimulatorWindowCount() {
		List<WebElement> lst = winiumDriver.findElements(By.name("MCPS - MasterCard Clearing Presentment Simulator"));
		MiscUtils.reportToConsole("MCPS Simulator Loading");
		return lst.size();
	}

	private int getWindowButtonCount() {
		List<WebElement> lst = winiumDriver.findElements(By.name("OK"));
		return lst.size();
	}

	private int getLoadServicesScreen() {
		List<WebElement> lst = winiumDriver.findElements(By.name("Close the Platform"));
		MiscUtils.reportToConsole("Wating for Select the services screen to come up");
		return lst.size();
	}

	private int getCountOfLicenseScreen() {
		List<WebElement> lst = winiumDriver.findElements(By.name("License profiles"));
		MiscUtils.reportToConsole("Wating for License Screen to come up");
		return lst.size();
	}

	private void connectToFINSim()
	{		
		try
		{
			wait(2000);
			if(performWiniumOperationIsObjectDisplayed("Password :"))
			{
				executeAutoITExe("ClickCancelOnFINSimPasswordScreen.exe");
			}
			executeAutoITExe("ActivateFINSimConnectScreen.exe");

			pressTab();
			setText(finSimSimulator.getIpAddress());
			pressTab(2);
			setText(finSimSimulator.getPort());
			pressTab();
			pressEnter();
			wait(5000);
			executeAutoITExe("ActivateFINSimPasswordScreen.exe");
			//			setText(finSimSimulator.getPassword());
			setText("master@987");
			wait(5000);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public String getPinNumber(Transaction transactionData) {
		try
		{
			launchPinCalculator();
			executeAutoITExe("ActivatePinOffsetScreen.exe");
			setText(String.valueOf(transactionData.getCardNumber()));
			pressTab();
			setText(String.valueOf(transactionData.getPinKey()));
			pressTab();
			setText(String.valueOf(transactionData.getDecimalisationTable()));
			pressTab();
			setValueInCombo(String.valueOf(transactionData.getValidationDataStart()));
			pressTab();
			setValueInCombo(String.valueOf(transactionData.getCardLength()));
			pressTab();
			setValueInCombo(String.valueOf(transactionData.getPad()));
			pressTab();
			setText(String.valueOf(transactionData.getOffSetForCard()));
			pressTab(2);
			setValueInCombo(String.valueOf(transactionData.getPinLength()));
			pressTab();

			return getPinText();
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
			return null;
		}
	}

	private void launchPinCalculator() {
		executeAutoITExe("LaunchPinCalculatorScreen");
	}

	private Boolean performWiniumOperationIsObjectDisplayed(String clickOn)
	{
		wait(1000);
		return winiumDriver.findElementByName(clickOn).isDisplayed();
	}

	public String getAuthorizationStatus(String arnNumber){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithARN(arnNumber);
	}

	public String getFeePostingStatus(String arnNumber){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithArnAndGetFee(arnNumber);
	}

	public String getDecimalisationTableValue(String text)
	{
		return text.toUpperCase().replace("A","0").replace("B", "1").replace("C","2").replace("D","3").replace("E", "4").replace("F", "5").replace("G","6").replace("H", "7").replace("I","8").replace("J","9");
	}
	
	public void verifychargeBackOutgoingMsg() {
		performClickOperation("firstChargeBack");
		performDoubleClickOperation("cardIssuerReferenceData");
		wait(10000);
		String text=winiumDriver.findElementByName("Edit DE Value").getText();
		context.put("IssuerCardReference",
				text);
		
		winiumDriver.findElementByName("Close").click();

		performDoubleClickOperation("messageReversalIndicator");

		executeAutoITExe("GetVauleFromMessageReversalIndicator.exe"); 
			
        winiumDriver.findElementByName("OK").click();
        wait(1000);
        winiumDriver.findElementByName("Close").click();

	}
}