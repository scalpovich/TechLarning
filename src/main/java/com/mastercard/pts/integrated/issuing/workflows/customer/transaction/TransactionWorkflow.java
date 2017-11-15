package com.mastercard.pts.integrated.issuing.workflows.customer.transaction;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.configuration.MasSimulator;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReversalTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.SimulatorConstantsData;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;

@Workflow
public class TransactionWorkflow extends SimulatorUtilities {
	private static final Logger logger = LoggerFactory.getLogger(TransactionWorkflow.class);
	private static final String EDIT_DE_VALUE = "Edit DE Value";
	private static final String SET_VALUE = "Set Value";
	private static final String CLOSE = "Close";
	private static final String MESSAGE_TYPE_INDICATOR = "Message Type Indicator";
	private static final String MIDDLE_PRESENTMENT = "Middle Presentment";
	private static final String PATH_BUILDER =  "\" \"";
	private static final String ISSUER_TEST = 	"IssuerTest";
	private static final String SELECT_IPS_HOST_TESTMODE = "SelectIPSHostTestMode.exe";
	private static final String RESELECT_IPS_HOST_TESTMODE = "ReSelectIPSHostTestMode.exe";
	private static final String SCROLL_UP_ON_TESTCASES = "ActivateMASandScrollUpOnTestCases.exe";
	private static final String SCROLL_UP_ON_TESTRESULTS = "ActivateMASandScrollUpOnTestResults.exe";
	private static final String ACTIVATE_MAS = "ActivateMAS.exe";
	private static final String CLICK_TEST_OPTIONS = "ClickTestOptions.exe";
	private static final String CLICK_TEST_MONITOR = "ClickTestMonitor.exe";
	private static final String CLICK_TEST_MODE = "ClickTestMode.exe";
	private static final String CLICK_TEST_PREPARATION = "ClickTestPreparation.exe";
	private static final String CLICK_TEST_RESULTS = "ClickTestResults.exe";
	private static final String SET_MAS_IP= "SetMASIP.exe ";
	
	@Autowired
	private MasSimulator simulator;

	@Autowired
	private FinSimSimulator finSimSimulator;

	@Autowired
	private Navigator navigator;

	private WiniumDriver winiumDriver;

	@Autowired
	private TestContext context;
	
	public BigDecimal getTransactionReversalAmount(ReversalTransaction rt) {
			ReversalTransactionPage page = navigator.navigateToPage(ReversalTransactionPage.class);
			return page.getTransactionReversalAmount(rt);
	}
	
	public void addAndmodify0025MessageReversalIndicator() {
        try {
        	
        			activateMcps();
                    winiumDriver.findElementByName("1240/200 First Presentment").click();
                    winiumDriver.findElementByName("Add a field to the current message").click();
                    searchForImageAndPerformDoubleClick("messageReversalIndicator");
                    activateEditField();
                    performClickOperation("AddRemove");
                    wait(2000);
                    searchForImageAndPerformDoubleClick("messageReversalIndicator");
                    wait(3000);
                    executeAutoITExe("ActivateEditSubfieldValueScreen.exe");
                    winiumDriver.findElementByName("Central Site Processing Date Of Original Message").click();
                    winiumDriver.findElementByName("Edit Subfield Value - Format: n(6) [YYMMDD] ").sendKeys("");
            		wait(2000);
            		pressTab();
                    setText("");
                    setText(DateUtils.currentDateYYMMDD());
                    wait(2000);
                    executeAutoITExe("ActivateEditSubfieldAndClickOK.exe");
                    wait(2000);
                    winiumDriver.findElementByName("Set Value").click();
                    winiumDriver.findElementByName(CLOSE).click();
                    //saving this file after modifications
                    performClickOperation("Save");
            		performClickOperation("OK");
            		wait(2000);
        	} catch (Exception e) {
        }
	}

	public void performOptimizedMasTransaction(String transaction, Transaction transactionData, Boolean sameCard)
	{
		handleDialogs();

		addBinRangeAndCurrencyDetailsBasedOnCardNumber(transactionData, transaction, sameCard);

		importAndLoadCardProfile(transactionData.getCardProfile());
		
		//filling Chip details for EMV cards
		if(transaction.toLowerCase().contains("emv")) {
			activateMas();
			performClickOperationOnImages("AUTOMATION CARD");
			performRightClickOperation("AUTOMATION CARD_Selected");
			wait(1000);
			performClickOperation("Edit Node");
			wait(4000);
			
			fillEmvChipKeySetDetails();
		}
		
		importAndLoadTestCase(transactionData.getTestCase(), transaction);

		performExecution(transaction);
	}

	public String getCurrencyToBeUsed(String currency)
	{
		List<String> theList = Arrays.asList(currency.split(""));
		String currencyTemp = "356";
		if(!theList.isEmpty())
		{
			currencyTemp = currency;
		}
		return currencyTemp;
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

	public String verifyTestResults()
	{
		return verifyResults();
	}

	public void launchWiniumAndSimulator(String simulator) {
		MiscUtils.killProcessFromTaskManager("WINIUM");		
		MiscUtils.killProcessFromTaskManager(simulator);

		try {
			startWiniumDriverWithSimulator(simulator);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}

		if(simulator.toUpperCase().contains("FINSIM")) {
			launchAndConnectToFinSim();

		} else if(simulator.toUpperCase().contains("MAS")) {
			selectLicenseAndConfigure("Credit - Professional", "MAS16.4");
			wait(4000);
			connect2IPSHostModeAndConfigureIP(); 	

			//clicking click Test Preparation
			clickTestPreparations();
			performClickTestCases();

			//clicking click Test Monitor
			clickTestMonitor();
			performClickTestCases();

		} else if(simulator.toUpperCase().contains("MCPS")) {
			launchAndConnectToMCPS();
		} else if(simulator.toUpperCase().contains("MDFS")) {
			selectLicenseAndConfigure("Debit - Professional", "MDFS16.4");
			wait(4000);
			connect2IPSHostModeAndConfigureIPOnMdfs(); 	

			//clicking click Test Preparation
			clickTestPreparationsOnMdfs();
			performClickTestCases();

			//clicking click Test Monitor
			clickTestMonitorOnMdfs();
			performClickTestCases();
		}
	}

	public void startWiniumDriverWithSimulator(String serviceName) {
		try
		{
			DesktopOptions options = launchSimulator(serviceName);
			String path = getResourceFolderPath() + SimulatorConstantsData.WINIUM_DRIVER_EXE_PATH.replace("\\", "\\\\");
			Runtime.getRuntime().exec(path, null, new File( path.replace("Winium.Desktop.Driver.exe", ""))) ;
			wait(3000);
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			wait(8000);
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
		else if(serviceName.toUpperCase().contains("MDFS"))
		{
			option =  launchMDFS();
		}
		return option;
	}

	private DesktopOptions launchMAS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT   + SimulatorConstantsData.MAS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MAS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchFinSim() {
		DesktopOptions options = new DesktopOptions();
		String path = getResourceFolderPath() + SimulatorConstantsData.FINSIM_EXE_PATH.replace("\\", "\\\\");
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + path);
		options.setApplicationPath(path);
		wait(3000);
		return options;
	}

	private DesktopOptions launchMCPS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + SimulatorConstantsData.MCPS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MCPS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchMDFS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + SimulatorConstantsData.MDFS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MDFS_EXE_PATH);
		return options;
	}

	public void importAndLoadTestCase(String filePath, String transaction)
	{
		MiscUtils.reportToConsole("******************** importAndLoadTestCase Started ******************");
		//navigating to "Test Preparation" section
		clickTestPreparations();
		importTestCaseFile(filePath);

		selectTestCaseFromImportedCases(transaction);
	}

	private void importTestCaseFile(String fileName)
	{
		activateMas();
		if(isImagePresent("importFile")) {
		}
		else {
			clickTestPreparations();
			activateMas();
			performClickTestCases();
			performClickCardProfiles();
		}
		activateMas();
		performClickOperation("importFile");
		wait(4000);
		executeAutoITExe("ImportTestCase.exe "+ fileName );
	}

	public void importAndLoadCardProfile(String filePath)
	{				
		MiscUtils.reportToConsole("******************** importAndLoadCardProfile Started ******************");
		clickTestPreparations();
		importCardProfileFile(filePath);
		pressPageDown(5);
		pressTab();
		pressPageDown(5);
		pressUpArrow();
	}

	private void importCardProfileFile(String filePath)
	{
		activateMas();
		performClickCardProfiles();
		performClickOperation("ImportCardProfile");
		wait(4000);
		executeAutoITExe("ImportCardProfile.exe "+ filePath );
	}

	public void removeLastEntry()
	{
		clickTestPreparations();
		activateMas();
		performClickOperation("Imported");
		pressPageDown();
		pressDelete();
		wait(5000);
	}

	private void selectTestCaseFromImportedCases(String testcaseName)
	{
		MiscUtils.reportToConsole("******************** selectTestCaseFromImportedCases Started ******************");
		MiscUtils.reportToConsole("******************** TRANSACTION to SELECT : " + testcaseName + " ******************");

		scrollUpToSelectTest();
		activateMas();
		performClickOperationOnImages(ISSUER_TEST);
		pressLeftArrow();
		performClickOperation("Imported");
		pressRightArrow(4);
		pressPageDown();
	}


	private void performExecution(String transaction) {
		MiscUtils.reportToConsole("******************** performExecution Started ******************");
		//clicking click Test Monitor
		clickTestMonitor();
		wait(3000);
		selectTestCaseFromImportedCases(transaction);
		activateMas();
		performDoubleClickOperation("RunTest");
		wait(5000);
		executeAutoITExe("ActivateStartTestDialogAndClose.exe");
	}

	public String verifyResults()
	{
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResults();
		wait(8000);

		winiumDriver.findElementByName("Sequential View").click();
		scrollUpToSelectTestResults();
		pressPageDown(2);
		return getResult();
	}

	private String getResult() {
		List<WebElement> lst = winiumDriver.findElements(By.name("0110 : NTW to APS Rcvd (ACQUIRERSTREAM1)"));
		lst.get(lst.size()-1).click();
		wait(5000);
		pressDownArrow(3);
		wait(2000);
		WebElement tempElement = winiumDriver.findElementByXPath("//*[contains(@AutomationId,'DescriptionTextBox')]");
		String tempText = tempElement.getText();
		MiscUtils.reportToConsole("Fetching PassResult : " + tempText);
		return tempText;
	}

	public String loadAuthFileToMCPS(String fullFileNameAndPath) {
		loadAuthFileIntoMCPS(fullFileNameAndPath);
		return editFieldsAndProcess();
	}

	public void loadFile(String fileName) {
		wait(5000);
		try {
			wait(2000);
			executeAutoITExe("ActivateMCPSImportSuccessMessageDialog.exe");
			handleDialogs();
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}
	}

	public void loadIPMFileIntoMCPS(String fileName)
	{
		clickTDG();
		performClickOperation("folder");
		executeAutoITExe("ActivateOpenExistingFileScreen.exe");
		loadFile(fileName);
	}

	private void loadAuthFileIntoMCPS(String fileName)
	{
		clickTDG();
		performClickOperation("Down Arrow");
		performClickOperation("Import Auth file");
		executeAutoITExe("LoadAuthFile.exe " + fileName );
		loadFile(fileName);
	}

	private void clickMiddlePresentmentAndMessageTypeIndicator() {
		clickMiddlePresentment();
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
	}

	private void clickMiddlePresentment() {
		performClickOperationOnImages(MIDDLE_PRESENTMENT);
	}

	private String editFieldsAndProcess(){
		String aRN = "";
		try{
			wait(2000);
			activateMcps();
			clickMiddlePresentmentAndMessageTypeIndicator();
			searchForImageAndPerformDoubleClick("Retrieval Reference Number");
			wait(2000);
			activateEditField();
			String rRN = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			String trimmedRrn = rRN.substring(1, rRN.length());
			winiumDriver.findElementByName(CLOSE).click();
			aRN = addAcquirerReferenceData(trimmedRrn);
			MiscUtils.reportToConsole("rRN :  trimmedRrn : aRN  -  " + rRN  + " : - : "  + trimmedRrn  + " : - :"  + aRN  );
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
			pressPageUp();
			clickMiddlePresentmentAndMessageTypeIndicator();
			searchForImageAndPerformDoubleClick("Forwarding Institution Identification Code");
			activateEditField();
			winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			setText("");
			setText("999684");
			wait(2000);
			performClickOperation(SET_VALUE);
			wait(2000);
			winiumDriver.findElementByName(CLOSE).click();
			addField();
			loadIpmFile(getIpmFileName());
			assignUniqueFileId();
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields", e);
			MiscUtils.propagate(e);
		}
		return aRN;
	}

	public String assignUniqueARN(){
		String rRN = MiscUtils.generateRandomNumberAsString(12);
		String arnNumber = "";
		try{
			wait(2000);
			activateMcps();
			clickMiddlePresentmentAndMessageTypeIndicator();
			searchForImageAndPerformDoubleClick("Retrieval Reference Number");
			wait(2000);
			activateEditField();
			wait(2000);
			setText("");
			setText(rRN);
			performClickOperation(SET_VALUE);
			winiumDriver.findElementByName(CLOSE).click();
			String trimmedRrn = rRN.substring(1, rRN.length());
			arnNumber = addAcquirerReferenceData(trimmedRrn);
			performClickOperation("Save");
			performClickOperation("OK");
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields", e);
			MiscUtils.propagate(e);
		}
	 return arnNumber;
	}
	
	private void activateEditField()
	{
		executeAutoITExe("ActivateEditFieldValueScreen.exe");
	}

	private String addAcquirerReferenceData(String rRN) throws AWTException {
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		pressPageUp();
		clickMiddlePresentment();
		searchForImageAndPerformDoubleClick("Acquirer Reference Data");
		executeAutoITExe("ActivateEditSubfieldValueScreen.exe");
		performClickOperation("Acquirer Sequence Number");
		wait(2000);
		pressTab();
		setText("");
		setText(rRN);
		winiumDriver.findElementByName("OK").click();
		wait(2000);
		performClickOperation(SET_VALUE);
		String aRN = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
		return aRN;
	}

	private void addField() throws AWTException {
		winiumDriver.findElementByName("Add a field to the current message").click();
		wait(3000);
		searchForImageAndPerformDoubleClick("Transaction Originator Institution ID Code");
		activateEditField();
		performClickOperation("AddRemove");
		wait(2000);
		performClickOperation("Bit Map Secondary");
		wait(2000);
		searchForImageAndPerformDoubleClick("093 Transaction Destination");
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText("999684");
		wait(2000);
		performClickOperation(SET_VALUE);
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
		performClickOperation("Add file to CEE");
		wait(2000);
		winiumDriver.findElementByName("Process File(s)").click();
		executeAutoITExe("GetCEEData.exe");				
	}

	private String getIpmFileName() throws IOException{
		String fileData = getFileData("CEEData.txt");
		String [] splitString = fileData.split("\\s+");
		logger.info("CEEData Text Data : ", splitString[5]);
		return splitString[5];	
	}

	public void loadIpmFile(String fileName) {
		try {
			clickTDG();
			performClickOperation("folder"); //open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName );
			wait(5000);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}
	}

	public void loadDownloadedIpmFileAndProcess(String fileName) {
		try {
		activateMcps();
			clickTDG();
			performClickOperation("folder"); //open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName );
			wait(5000);
			performClickOperation("Add file to CEE");
			wait(2000);
    		performClickOperation("processFiles");
    		performClickOperation("OK");

		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS", e);
			MiscUtils.propagate(e);
		}
	}

	public void assignUniqueFileId() throws AWTException{
		activateMcps();
		String fileId = RandomStringUtils.randomNumeric(5);
		//step to ensure that File Header is not already selecdted
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		winiumDriver.findElementByName("1644/697 File Header").click();
		fillFileId(fileId);
		winiumDriver.findElementByName("1644/695 File Trailer").click();
		fillFileId(fileId);		
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
	}

	private void fillFileId(String value) throws AWTException{
		activateMcps();
		performDoubleClickOperation("File ID");
		performClickOperation("Processor ID");
		wait(2000);
		pressTab();
		setText("");
		setText(value);
		winiumDriver.findElementByName("OK").click();
		wait(2000);
		performClickOperation(SET_VALUE);		
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
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
		try (FileInputStream fis = new FileInputStream(getTempDirectoryLocationForSimulatorResults() + "//" + filePath);) {
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String fileName = br.readLine();
			fis.close();
			return fileName;
		}
	}

	private void generateAuthFileFromMas() throws AWTException
	{
		wait(5000);
		clickTestResults();
		winiumDriver.findElementByName("Sequential View").click();
		activateMas();
		performClickOperation("Generate Auth File");
		performClickOperation("Select Auth File");
		wait(5000);
		executeAutoITExe("ActivateImportAuthFileScreen.exe");
		setText(String.valueOf("AuthFileName"));
		pressTab(2);
		pressEnter();
		wait(3000);
		handleDialogs();
		pressEscape();
	}

	private void selectMCPSLicense(){
		wait(5000);
		executeAutoITExe("ActivateLicenseProfiles.exe");
		performClickOperation("License profiles");
		performClickOperation("Select");
		wait(5000);
	}

	public void selectLicenseAndConfigure(String licenseTypeToSelect, String licenseFor)
	{
		try
		{
			String licenseForSelection = null;
			if(licenseFor.toUpperCase().contains("MAS16.4"))
				licenseForSelection = SimulatorConstantsData.MAS_LICENSE_TYPE_16X;
			else if(licenseFor.toUpperCase().contains("MAS17.4"))
				licenseForSelection = SimulatorConstantsData.MAS_LICENSE_TYPE_17X;
			else if(licenseFor.toUpperCase().contains("MDFS16.4"))
				licenseForSelection = SimulatorConstantsData.MDFS_LICENSE_TYPE_16X;
			else if(licenseFor.toUpperCase().contains("MDFS17.4"))
				licenseForSelection = SimulatorConstantsData.MDFS_LICENSE_TYPE_17X;
			
			if(getCountOfLicenseScreen() == 0) {
				wait(1000);
			}

			executeAutoITExe("ActivateLicenseProfiles.exe");
			performDoubleClickOperationOnImages(licenseTypeToSelect);
			wait(15000);

			if(getLoadServicesScreen() > 0)	{
				executeAutoITExe("ActivateSelectServices.exe");
				wait(2000);
				winiumClickOperation(licenseForSelection);
				pressSpaceBar();
				winiumClickOperation("Load the services");
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

	public void connect2IPSHostModeAndConfigureIP()
	{
		try {
			connect2IpsHostTestMode();

			//change ip and reselefct IPS Host Test Mode
			configureTestOptionsHostAndIP();
			reconnect2IpsHostTestMode();
		} catch (FindFailed e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	public void connect2IPSHostModeAndConfigureIPOnMdfs()
	{
		try {
			connect2IpsHostTestModeOnMdfs();

			//change ip and reselefct IPS Host Test Mode
			configureTestOptionsHostAndIPOnMdfs();
			reconnect2IpsHostTestModeOnMdfs();
		} catch (FindFailed e) {
			throw MiscUtils.propagate(e);
		}
	}

	private void reconnect2IpsHostTestMode() {
		clickTestMode();		
		reSelectLicense();
		wait(10000);

		while(getWindowButtonCount() > 0) {
			winiumDriver.findElementByName("OK").click();
			selectLicense();
			wait(5000);
		}
	}
	
	private void reconnect2IpsHostTestModeOnMdfs() {
		clickTestModeOnMdfs();		
		reSelectLicenseOnMdfs();
		wait(10000);

		while(getWindowButtonCount() > 0) {
			winiumDriver.findElementByName("OK").click();
			selectLicense();
			wait(5000);
		}
	}

	private void connect2IpsHostTestMode() throws FindFailed {
		wait(5000);
		clickTestMode();
		selectLicense();
		wait(15000);
		waitForImageToAppear("CONNECTED");
		wait(15000);
	}
	
	private void connect2IpsHostTestModeOnMdfs() throws FindFailed {
		wait(5000);
		clickTestModeOnMdfs();
		selectLicenseOnMdfs();
		wait(15000);
		waitForImageToAppear("CONNECTED");
		wait(15000);
	}

	public void addBinRangeAndCurrencyDetailsBasedOnCardNumber(Transaction transactionData, String transaction, Boolean sameCard)
	{
		//we do not have to perform this step if it same card on which operations are being performed
		if(!sameCard) {
			configureBinRange(transactionData, transaction);
		}
	}

	private void configureBinRange(Transaction transactionData, String transaction)
	{
		String bin = transactionData.getCardNumber();
		String issuerCountryCode = transactionData.getIssuerCountryCode() ; //"356"; // transactionData.getCurrency(); //356
		String issuerCurrencyCode =  transactionData.getIssuerCurrencyCode();  //value from DE Element 49
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency(); //value from DE Element 61_13

		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";

		try
		{
			clickTestOptions();

			activateMas();	
			winiumClickOperation("BIN Table");
			performClickOperation("Add New");
			wait(10000);
			if(isImagePresent("Add BIN Range")) {
			}
			else {
				performClickOperationOnImages("BIN Table");
				performClickOperation("Add New");
				wait(10000);
			}
			waitForImageToAppear("Add BIN Range");
			winiumClickOperation("General");
			executeAutoITExe("ActivateAddBINrange.exe");
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
			setText(issuerCountryCode);
			pressTab();
			setText(issuerCurrencyCode);
			pressTab();
			setText(cardHolderBillingCurrency);
			winiumClickOperation("OK");
			wait(2000);
			if(isImagePresent("OK"))
			{
				performClickOperation("OK");
				wait(2000);
			}
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void fillEmvChipKeySetDetails() {
		executeAutoITExe("ActivateEditCardProfile.exe");
		winiumClickOperationWithoutActiviate("ICC Related Data");
		performClickOperation("MChipKeySetDropDown");
		wait(1000);
		winiumClickOperationWithoutActiviate("00999 - Example ETEC1 - 0213");	
		wait(1000);
		winiumClickOperationWithoutActiviate("OK");
		wait(1000);
	}

	public void closeSimulator(String name) 
	{
		winiumDriver = null;
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP()
	{
		try {
			clickTestOptions();

			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");              
			
			setMasIp(ip);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}
		
	private void setMasIp(String[] ip) {
		String parameters;
		//for keying ip and port on MAS 16.x if present
		parameters =   "\"" + SimulatorConstantsData.MAS_16_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
				+  PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
		//for keying ip and port on MAS 17.x if present
		parameters =   "\"" + SimulatorConstantsData.MAS_17_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
				+  PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
	}
	
	private void configureTestOptionsHostAndIPOnMdfs()
	{
		try {
			clickTestOptionsOnMdfs();

			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");              
			
			setMasIpOnMdfs(ip);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}
	
	private void setMasIpOnMdfs(String[] ip) {
		String parameters;
		//for keying ip and port on MAS 16.x if present
		parameters =   "\"" + SimulatorConstantsData.MDFS_16_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
				+  PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
		//for keying ip and port on MAS 17.x if present
		parameters =   "\"" + SimulatorConstantsData.MDFS_17_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
				+  PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
	}
	
	private void setMasIpAddress(String parameter) {
		executeAutoITExe(SET_MAS_IP + parameter );
		MiscUtils.reportToConsole(" ******* Parameter for setMasIp : ******"  + parameter );     
	}

	private String getValue(String val) {
		return stringleftPadWith0(val, 3);
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
			executeAutoITExe("HandleFinSimLicenseValidationProblem.exe");
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
			setText(finSimSimulator.getPassword());
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
			//			Ex: SelectValuesFromPinOffsetCalculator.exe "5877650150876119" "EE9A8BACEE127B4B2DC900D8EEA9221D" "1234567890123456" "4" "12" "F" "7782" "4"
			//NO SONAR... 
			String parameters =   "\"" + transactionData.getCardNumber() + PATH_BUILDER +  transactionData.getPinKey() + PATH_BUILDER  + transactionData.getDecimalisationTable() +  PATH_BUILDER + transactionData.getValidationDataStart()
					+  PATH_BUILDER + transactionData.getCardLength() + PATH_BUILDER + transactionData.getPad() +  PATH_BUILDER + transactionData.getOffSetForCard() +  PATH_BUILDER + transactionData.getPinLength() + "\"";
			MiscUtils.reportToConsole(" ******* Parameter for SelectValuesFromPinOffsetCalculator : ******"  + parameters );
			executeAutoITExe("SelectValuesFromPinOffsetCalculator.exe " + parameters );
			wait(7000);

			return getPinText();
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
			return null;
		}
	}

	private Boolean performWiniumOperationIsObjectDisplayed(String clickOn)
	{
		wait(1000);
		return winiumDriver.findElementByName(clickOn).isDisplayed();
	}

	public String getAuthorizationStatus(String arnNumber, TransactionSearch ts){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithARN(arnNumber, ts);
	}

	public String getFeePostingStatus(String arnNumber, TransactionSearch ts){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithArnAndGetFee(arnNumber, ts);
	}
	
	public String searchTransactionWithArnAndGetStatus(String arnNumber, TransactionSearch ts){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithArnAndGetStatus(arnNumber, ts);
	} 

	public String getDecimalisationTableValue(String text)
	{
		return text.toUpperCase().replace("A","0").replace("B", "1").replace("C","2").replace("D","3").replace("E", "4").replace("F", "5").replace("G","6").replace("H", "7").replace("I","8").replace("J","9");
	}

	public void verifychargeBackOutgoingMsg() {
		performClickOperation("firstChargeBack");
		performDoubleClickOperation("cardIssuerReferenceData");
		wait(10000);
		String text=winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		context.put("IssuerCardReference", text);

		winiumClickOperation(CLOSE);
		performDoubleClickOperation("messageReversalIndicator");
		executeAutoITExe("GetVauleFromMessageReversalIndicator.exe"); 
		winiumClickOperation("OK");
		wait(1000);
		winiumClickOperation(CLOSE);
	}



	private void winiumClickOperation(String locator) {
		activateMas();
		winiumClickOperationWithoutActiviate(locator);
	}

	private void winiumClickOperationWithoutActiviate(String locator) {
		logger.info(" *****  winiumClick Operation is being performed :  ", locator);
		winiumDriver.findElementByName(locator).click();
	}

	@SuppressWarnings("unused")
	private void winiumSetTextOperation(String locator, String text) {
		logger.info("***** winiumSetText Operation performed : locator/text : ",  locator + " / " + text);
		activateMas();
		winiumDriver.findElementByName(locator).sendKeys(text);
	}

	private void performClickTestCases() {
		activateMas();
		performClickOperationOnImages("Test Cases (Issuer Testing)");
	} 

	private void performClickCardProfiles() {
		performClickOperationOnImages("Card Profiles");
	} 

	private void selectLicense() {
		executeAutoITExe(SELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(SELECT_IPS_HOST_TESTMODE  + "\"" +SimulatorConstantsData.MAS_17_X + "\"");
	}
	
	private void selectLicenseOnMdfs() {
		executeAutoITExe(SELECT_IPS_HOST_TESTMODE  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(SELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MDFS_17_X + "\"");
	}

	private void reSelectLicense() {
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MAS_17_X + "\"");
	}

	private void reSelectLicenseOnMdfs() {
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + "\"" +SimulatorConstantsData.MDFS_17_X + "\"");
	}
	
	private void scrollUpToSelectTest() {
		executeAutoITExe(SCROLL_UP_ON_TESTCASES  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(SCROLL_UP_ON_TESTCASES  + "\"" +SimulatorConstantsData.MAS_17_X + "\"");
	}
	
	private void scrollUpToSelectTestOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTCASES  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(SCROLL_UP_ON_TESTCASES  + "\"" +SimulatorConstantsData.MDFS_17_X + "\"");
	}
	
	private void scrollUpToSelectTestResults() {
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS  + "\"" +SimulatorConstantsData.MAS_17_X + "\"");
	}
	
	private void scrollUpToSelectTestResultsOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS  + "\"" +SimulatorConstantsData.MDFS_17_X + "\"");
	}
	
	private void handleDialogs() { 
		executeAutoITExe("HandleUnhandlesDialogs.exe");
	}
	
	private void activateMas()
	{
		executeAutoITExe(ACTIVATE_MAS  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(ACTIVATE_MAS  + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
		wait(1000);
		activateMdfs();
	}
	
	public void activateMdfs()
	{
		executeAutoITExe(ACTIVATE_MAS + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(ACTIVATE_MAS + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
		wait(1000);
	}

	private void activateMcps()
	{
		executeAutoITExe("ActivateMCPS.exe" + "\"" +SimulatorConstantsData.MCPS_16_X + "\"" );
		executeAutoITExe("ActivateMCPS.exe" + "\"" +SimulatorConstantsData.MCPS_17_X + "\"" );
		wait(1000);
	}

	private void clickTDG()
	{
		executeAutoITExe("ClickTDG.exe" + "\"" +SimulatorConstantsData.MCPS_16_X + "\"" );
		executeAutoITExe("ClickTDG.exe" + "\"" +SimulatorConstantsData.MCPS_17_X + "\"" );
	}
	
	public void clickTestOptions()
	{
		executeAutoITExe(CLICK_TEST_OPTIONS  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_OPTIONS  + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
	}

	public void clickTestOptionsOnMdfs()
	{
		executeAutoITExe(CLICK_TEST_OPTIONS + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_OPTIONS  + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
	}
	
	public void clickTestMonitor()
	{
		executeAutoITExe( CLICK_TEST_MONITOR  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_MONITOR  + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
	}
	
	public void clickTestMonitorOnMdfs()
	{
		executeAutoITExe(CLICK_TEST_MONITOR  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_MONITOR  + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
	}

	public void clickTestMode()
	{
		executeAutoITExe(CLICK_TEST_MODE  + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_MODE  + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
	}
	
	public void clickTestModeOnMdfs()
	{
		executeAutoITExe(CLICK_TEST_MODE + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_MODE + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
	}

	public void clickTestPreparations()
	{
		executeAutoITExe(CLICK_TEST_PREPARATION + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_PREPARATION + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
		wait(5000);
	}
	
	public void clickTestPreparationsOnMdfs()
	{
		executeAutoITExe(CLICK_TEST_PREPARATION  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_PREPARATION + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
		wait(5000);
	}

	public void clickTestResults()
	{
		executeAutoITExe(CLICK_TEST_RESULTS + "\"" +SimulatorConstantsData.MAS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_RESULTS  + "\"" +SimulatorConstantsData.MAS_17_X + "\"" );
	}
	
	public void clickTestResultsOnMdfs()
	{
		executeAutoITExe(CLICK_TEST_RESULTS  + "\"" +SimulatorConstantsData.MDFS_16_X + "\"" );
		executeAutoITExe(CLICK_TEST_RESULTS  + "\"" +SimulatorConstantsData.MDFS_17_X + "\"" );
	}
	
	public void testAutoItWithPsExec() {
		executeAutoITExe("TestExe.exe");
	}
}
