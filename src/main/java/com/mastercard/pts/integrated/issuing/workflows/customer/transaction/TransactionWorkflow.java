package com.mastercard.pts.integrated.issuing.workflows.customer.transaction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import winium.elements.desktop.ComboBox;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.configuration.MasSimulator;
import com.mastercard.pts.integrated.issuing.configuration.MdfsSimulator;
import com.mastercard.pts.integrated.issuing.configuration.VtsSimulator;
import com.mastercard.pts.integrated.issuing.configuration.WhichSimulatorVersionToChoose;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.LoadBalanceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.pages.ValidationException;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.InitiateSettlementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceApprovePage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReversalTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.MasDetailsKeyValuePair;
import com.mastercard.pts.integrated.issuing.utils.simulator.MdfsDetailsKeyValuePair;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorConstantsData;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.simulator.VisaTestCaseNameKeyValuePair;

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
	private static final String SEPERATOR= " \"";
	private static final String MESSAGE_REVERSAL_INDICATOR = "messageReversalIndicator";
	private static final String BIN_TABLE = "BIN Table";
	private static final String TEST_CASES =	"Test Cases (Issuer Testing)";
	private static final String ADD_BIN_RANGE_SCROLL = "AddBinRangeScrolling.exe";
	private static final String ADD_BIN_RANGE_MAKE_OK_VISIBLE = "AddBinRangeMakeOkVisible.exe";
	private LoadBalanceRequestPage lbrpage;
	private LoadBalanceApprovePage lbapage;
	private InitiateSettlementPage ispage;
	private static final String VTS_COMM_HANDLER = "VTS Communications Handler (1)";
	private static final String SET_VTS_IP= "SetVTSIP.exe ";
	private static final String WINIUM_LOG_COMMENT = " *****  winiumClick Operation is being performed :  ";
	private String vtsTestGroupInputFilePath = getResourceFolderPath().replace("\\\\", "\\") + SimulatorConstantsData.VISA_EXCEL_TEMPLATE_FILE_PATH ;
	private static final String RESULT_IDENTIFIER = "Refresh";
	private static final String VISA_FAILURE_MESSAGE = "Visa Incomming Message for transaction did not come";

	@Autowired
	private WebDriverProvider webProvider;

	@Autowired
	private MasSimulator simulator;

	@Autowired
	private MdfsSimulator mdfsSimulator;

	@Autowired
	private VtsSimulator vtsSimulator;

	@Autowired
	private FinSimSimulator finSimSimulator;

	@Autowired
	private WhichSimulatorVersionToChoose simulatorVersion;

	@Autowired
	private Navigator navigator;

	private WiniumDriver winiumDriver;

	@Autowired
	private TestContext context;

	@Autowired
	private VisaTestCaseNameKeyValuePair visaTestCaseNameKeyValuePair;

	public void initiateSettlementForAgency(String branchID, String programCode) {
		ispage = navigator.navigateToPage(InitiateSettlementPage.class);
		ispage.initiateSettlementForAgency(branchID, programCode);
	}

	public String getSettlementInitiativeSuccessMessage() {
		return ispage.getSettlementInitiativeSuccessMessage();
	}

	public String performLoadBalanceRequestAndGetRequestReferenceNumber(Device device, LoadBalanceRequest details) {
		lbrpage = navigator.navigateToPage(LoadBalanceRequestPage.class);
		return lbrpage.performLoadBalanceRequestAndGetRequestReferenceNumber(device, details);
	}

	public String getLoadBalanceRequestSuccessMessage() {
		return lbrpage.getLoadBalanceRequestSuccessMessage();
	}

	public void performLoadBalanceApprove(Device device, LoadBalanceRequest details) {
		lbapage = navigator.navigateToPage(LoadBalanceApprovePage.class);
		lbapage.performLoadBalanceApprove(device, details);
	}

	public String getLoadBalanceApproveSuccessMessage() {
		return lbapage.getLoadBalanceApproveSuccessMessage();
	}

	public BigDecimal getTransactionReversalAmount(ReversalTransaction rt) {
		ReversalTransactionPage page = navigator.navigateToPage(ReversalTransactionPage.class);
		return page.getTransactionReversalAmount(rt);
	}

	public void addAndmodify0025MessageReversalIndicator() {
		try {

			activateMcps();
			winiumClickOperation("1240/200 First Presentment");
			winiumClickOperation("Add a field to the current message");
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
			activateEditField();
			performClickOperation("AddRemove");
			wait(2000);
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
			wait(3000);
			executeAutoITExe("ActivateEditSubfieldValueScreen.exe");
			winiumClickOperation("Central Site Processing Date Of Original Message");
			winiumDriver.findElementByName("Edit Subfield Value - Format: n(6) [YYMMDD] ").sendKeys("");
			wait(2000);
			pressTab();
			setText("");
			setText(DateUtils.currentDateYYMMDD());
			wait(2000);
			executeAutoITExe("ActivateEditSubfieldAndClickOK.exe");
			wait(2000);
			winiumClickOperation("Set Value");
			winiumClickOperation(CLOSE);
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

		importAndLoadCardProfile(transactionData.getCardProfile(), transaction);

		//filling Chip details for EMV cards
		if(isContains(transaction, "emv")) {
			activateMas(transaction);
			performClickOperationOnImages("AUTOMATION CARD");
			performRightClickOperation("AUTOMATION CARD_Selected");
			wait(1000);
			performClickOperation("Edit Node");
			wait(4000);

			fillEmvChipKeySetDetails();
		}
		/*		
		//filling CVV data for PREAUTH and COMPLETION
		if(isContains(transaction, "PREAUTH")) {// ideally CVV number gets added to card profile until and unless it validation is unchecked from device plan
			activateMas(transaction);
			performClickOperationOnImages("AUTOMATION CARD");
			performRightClickOperation("AUTOMATION CARD_Selected");
			wait(1000);
			performClickOperation("Edit Node");
			wait(4000);

			fillCvvData(transactionData.getCvvData()); // Prabhu
		}
		 */		
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

	public String verifyTestResultsOnMdfs()
	{
		return verifyResultsOnMdfs();
	}

	public void launchWiniumAndSimulator(String simulator) {
		//to fetch required Simulator installed on the machine or read value from WhichSimulatorVersionToChoose.java
		launchRequiredSimulatorSession(simulator);
		// close older session of simulator if open 
		closeSimulator(simulator);

		try {
			startWiniumDriverWithSimulator(simulator);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}

		if(simulator.toUpperCase().contains("FINSIM")) {
			launchAndConnectToFinSim();

		} else if(simulator.toUpperCase().contains("MAS")) {
			selectLicenseAndConfigure(SimulatorConstantsData.SELECT_MAS_LICENSE, SimulatorConstantsData.MAS_LICENSE_TYPE);
			wait(4000);
			connect2IPSHostModeAndConfigureIP("MAS"); 	
		} else if(simulator.toUpperCase().contains("MCPS")) {
			launchAndConnectToMCPS();

		} else if(simulator.toUpperCase().contains("MDFS")) {
			selectLicenseAndConfigure(SimulatorConstantsData.SELECT_MDFS_LICENSE, SimulatorConstantsData.MDFS_LICENSE_TYPE);
			wait(4000);
			connect2IPSHostModeAndConfigureIPOnMdfs(); 	
		} else if(simulator.toUpperCase().contains("VISA")) {
			connectAndStartVtsCommunication();
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
		if(serviceName.toUpperCase().contains("MAS")) {
			option =  launchMAS();
		} else if(serviceName.toUpperCase().contains("FINSIM")) {
			option =  launchFinSim();
		} else if(serviceName.toUpperCase().contains("MCPS")) {
			option =  launchMCPS();
		} else if(serviceName.toUpperCase().contains("MDFS")) {
			option =  launchMDFS();
		} else if(serviceName.toUpperCase().contains("VISA")) {
			option =  launchVISA();
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
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + SimulatorConstantsData.MAS_EXE_PATH );
		options.setApplicationPath(SimulatorConstantsData.MAS_EXE_PATH );
		return options;
	}

	private DesktopOptions launchVISA() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + SimulatorConstantsData.VISA_EXE_PATH );
		options.setApplicationPath(SimulatorConstantsData.VISA_EXE_PATH );
		return options;
	}

	public void importAndLoadTestCase(String filePath, String transaction)
	{
		MiscUtils.reportToConsole("******************** importAndLoadTestCase Started ******************");
		//navigating to "Test Preparation" section
		clickTestPreparations(transaction);
		importTestCaseFile(filePath, transaction);

		selectTestCaseFromImportedCases(transaction);
	}

	private void importTestCaseFile(String fileName,  String transaction)
	{
		MiscUtils.reportToConsole("******************** importTestCaseFile Started ******************");
		activateMas(transaction);
		winiumClickOperation(TEST_CASES);
		performClickOperation("importFile");
		wait(8000);
		executeAutoITExe("ImportTestCase.exe "+ fileName );
		wait(3000);
	}

	public void importAndLoadCardProfile(String filePath, String transaction)
	{				
		MiscUtils.reportToConsole("******************** importAndLoadCardProfile Started ******************");
		clickTestPreparations(transaction);
		importCardProfileFile(filePath, transaction);
		if(transaction.toLowerCase().contains("emv")) {
			pressPageDown(5);
			pressTab();
			pressPageDown(5);
		}
	}

	private void importCardProfileFile(String filePath, String transaction)
	{
		activateMas(transaction);
		performClickCardProfiles(transaction);
		winiumDriver.findElementByName("Card Profiles").findElement(By.name("toolStrip1")).findElement(By.name("toolStripButton1")).click();
		wait(6000);
		executeAutoITExe("ImportCardProfile.exe "+ filePath );
	}
	private void selectTestCaseFromImportedCases(String testcaseName)
	{
		MiscUtils.reportToConsole("******************** selectTestCaseFromImportedCases Started ******************");
		MiscUtils.reportToConsole("******************** TRANSACTION to SELECT : " + testcaseName + " ******************");

		scrollUpToSelectTest(testcaseName);
		activateMas(testcaseName);
		winiumClickOperation(TEST_CASES);
		performClickOperationOnImages(ISSUER_TEST);
		pressLeftArrow();
		performClickOperation("Imported");
		pressRightArrow(4);
		pressPageDown();	
	}

	private void performExecution(String transaction) {
		MiscUtils.reportToConsole("******************** performExecution Started ******************");
		//clicking click Test Monitor
		clickTestMonitor(transaction);
		wait(3000);
		selectTestCaseFromImportedCases(transaction);
		activateMas(transaction);
		winiumClickOperation(TEST_CASES);
		performDoubleClickOperation("RunTest");
		wait(5000);
		activateMas(transaction);
		winiumClickOperation("OK");
	}

	public String verifyResults()
	{
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResults("MAS");
		wait(8000);
		winiumClickOperation("Sequential View");
		scrollUpToSelectTestResults("MAS");
		pressPageDown(4);
		return getResult();
	}

	public String verifyResultsOnMdfs()
	{
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResultsOnMdfs();
		wait(8000);
		winiumClickOperation("Sequential View");
		scrollUpToSelectTestResultsOnMdfs();
		pressPageDown(2);
		return getResult();
	}

	private String getResult() {
		List<WebElement> lst = winiumDriver.findElements(By.xpath("//*[contains(@Name, 'Expected Results Summary')]"));
		//clicking on the last item from bottom
		lst.get(lst.size()-1).click();
		wait(5000);
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
			winiumClickOperation(CLOSE);
			aRN = addAcquirerReferenceData(trimmedRrn);
			MiscUtils.reportToConsole("rRN :  trimmedRrn : aRN  -  " + rRN  + " : - : "  + trimmedRrn  + " : - :"  + aRN  );
			updatePanNumber(SimulatorConstantsData.SAMPLE_PAN_NUMBER);
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the
			// table
			pressPageUp();
			clickMiddlePresentmentAndMessageTypeIndicator();
			searchForImageAndPerformDoubleClick("Forwarding Institution Identification Code");
			activateEditField();
			winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			setText("");
			setText("999684");
			wait(2000);
			winiumClickOperation("Set Value");
			wait(2000);
			winiumClickOperation(CLOSE);
			addField();
			loadIpmFile(getIpmFileName());
			Device device = context.get(ContextConstants.DEVICE);
			updatePanNumber(device.getDeviceNumber());
			assignUniqueFileId();
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields", e);
			MiscUtils.propagate(e);
		}
		return aRN;
	}

	private void updatePanNumber(String cardNumber) throws AWTException{
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		searchForImageAndPerformDoubleClick("Primary Account Number (PAN)");
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText(cardNumber);
		wait(2000);
		winiumClickOperation("Set Value");
		wait(2000);
		winiumClickOperation(CLOSE);
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
			winiumClickOperation(CLOSE);
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
		winiumClickOperation("OK");
		wait(2000);
		winiumClickOperation("Set Value");
		String aRN = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		wait(2000);
		winiumClickOperation(CLOSE);
		return aRN;
	}

	private void addField() throws AWTException {
		winiumClickOperation("Add a field to the current message");
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
		winiumClickOperation("Set Value");
		wait(2000);
		winiumClickOperation(CLOSE);
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
		performClickOperation("Add file to CEE");
		wait(2000);
		winiumClickOperation("Process File(s)");
		wait(5000);
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
		winiumClickOperation("1644/697 File Header");
		fillFileId(fileId);
		winiumClickOperation("1644/695 File Trailer");
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
		winiumClickOperation("OK");
		wait(2000);
		winiumClickOperation("Set Value");
		wait(2000);
		winiumClickOperation(CLOSE);
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
		clickTestResults("MAS");
		winiumClickOperation("Sequential View");
		activateMas("MAS");
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
		winiumLicenseSelectOperation("License profiles");		
		performClickOperation("License profiles");
		performClickOperation("Select");		
		wait(15000);
	}

	public void selectLicenseAndConfigure(String licenseTypeToSelect, String licenseFor)
	{
		try
		{
			String licenseForSelection = null;
			//changed from MAS 16.x to MAS so that this works for all versions of MAS
			if(licenseFor.toUpperCase().contains("MAS"))
				licenseForSelection = SimulatorConstantsData.MAS_LICENSE_TYPE;
			//changed from MDFS 16.x to MDFS so that this works for all versions of MDFS
			else if(licenseFor.toUpperCase().contains("MDFS"))
				licenseForSelection = SimulatorConstantsData.MDFS_LICENSE_TYPE;

			MiscUtils.reportToConsole("selectLicenseAndConfigure  : " + licenseForSelection);

			if(getCountOfLicenseScreen() == 0) {
				wait(1000);
			}

			executeAutoITExe("ActivateLicenseProfiles.exe");
			winiumLicenseSelectOperation(licenseTypeToSelect, licenseFor);
			winiumClickOperation("Select");
			wait(20000);
			executeAutoITExe("ActivateSelectServices.exe");

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

	public void connect2IPSHostModeAndConfigureIP(String tool)
	{
		try {
			connect2IpsHostTestMode(tool);

			//change ip and reselefct IPS Host Test Mode
			configureTestOptionsHostAndIP(tool);
			reconnect2IpsHostTestMode(tool);
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

	private void reconnect2IpsHostTestMode(String tool) {
		clickTestMode(tool);		
		reSelectLicense(tool);
		wait(10000);

		while(getWindowButtonCount() > 0) {
			winiumClickOperation("OK");
			selectLicense(tool);
			wait(5000);
		}
	}

	private void reconnect2IpsHostTestModeOnMdfs() {
		clickTestModeOnMdfs();		
		reSelectLicenseOnMdfs();
		wait(10000);

		while(getWindowButtonCount() > 0) {
			winiumClickOperation("OK");
			selectLicense("MDFS");
			wait(5000);
		}
	}

	private void connect2IpsHostTestMode(String tool) throws FindFailed {
		wait(5000);
		clickTestMode(tool);
		selectLicense(tool);
		wait(15000);
		waitForExepectedCondition("CONNECTED");
		wait(15000);
	}

	private void connect2IpsHostTestModeOnMdfs() throws FindFailed {
		wait(5000);
		clickTestModeOnMdfs();
		selectLicenseOnMdfs();
		wait(15000);
		waitForExepectedCondition("CONNECTED");
		wait(15000);
	}

	private void waitForExepectedCondition(String nameOfLocator) {
		WebDriverWait wait = new WebDriverWait(winiumDriver, 20);
		// Waiting to get connected
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameOfLocator)));
	}

	public void addBinRangeAndCurrencyDetailsBasedOnCardNumber(Transaction transactionData, String transaction, Boolean sameCard)
	{
		//we do not have to perform this step if it same card on which operations are being performed
		if(!sameCard) {
			if(!isContains(transaction, "mdfs")) {
				configureBinRangeForMas(transactionData);
			} else {
				configureBinRangeForMdfs(transactionData);
			}
		}
	}


	private void configureBinRangeForMdfs(Transaction transactionData)
	{
		String bin = transactionData.getCardNumber();
		String issuerCountryCode = transactionData.getIssuerCountryCode() ; //"356"; // transactionData.getCurrency(); //356
		String issuerCurrencyCode =  transactionData.getIssuerCurrencyCode();  //value from DE Element 49
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency(); //value from DE Element 61_13

		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";

		try
		{
			clickTestOptions("MDFS");

			activateMas("MDFS");	
			winiumClickOperation(BIN_TABLE);
			wait(1000);
			//clicking again just incase as test will fais if this click fails
			winiumClickOperation(BIN_TABLE);
			wait(2000);
			performClickOperation("Add New");
			wait(10000);
			executeAutoITExe(ADD_BIN_RANGE_SCROLL);
			winiumClickOperation("General");
			pressTab();
			setText(binBinMinRange);
			pressTab();
			setText(binMaxBinRange);
			wait(1000);
			pressTab();
			wait(1000);
			pressTab();
			wait(1000);
			setText("00"); // fianancial Network Code
			pressTab();
			setText(issuerCountryCode);
			pressEnter();
			//			pressTab();
			pressTab();
			setText(issuerCurrencyCode);
			pressTab();
			setText(cardHolderBillingCurrency);

			// In MDFS 17.x, the OK button does not show up until we scroll down hence tabbing so that the focus goes to OK button
			executeAutoITExe(ADD_BIN_RANGE_MAKE_OK_VISIBLE);

			winiumClickOperation("OK");
			wait(2000);
			if(isImagePresent("OK")) {
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

	private void configureBinRangeForMas(Transaction transactionData)
	{
		String bin = transactionData.getCardNumber();
		String issuerCountryCode = transactionData.getIssuerCountryCode() ; //"356"; // transactionData.getCurrency(); //356
		String issuerCurrencyCode =  transactionData.getIssuerCurrencyCode();  //value from DE Element 49
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency(); //value from DE Element 61_13

		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";

		try
		{
			clickTestOptions("MAS");

			activateMas("MAS");	
			winiumClickOperation(BIN_TABLE);
			wait(1000);
			//clicking again just incase as test will fais if this click fails
			winiumClickOperation(BIN_TABLE);
			wait(2000);
			performClickOperation("Add New");
			wait(10000);
			executeAutoITExe(ADD_BIN_RANGE_SCROLL);
			winiumClickOperation("General");
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

			// In MAS 17.x, the OK button does not show up until we scroll down hence tabbing so that the focus goes to OK button
			executeAutoITExe(ADD_BIN_RANGE_MAKE_OK_VISIBLE);

			winiumClickOperation("OK");
			wait(4000);
			if(isImagePresent("OK")) {
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
		winiumClickOperation("ICC Related Data");
		winiumClickOperation("Drop Down Button");
		wait(1000);
		winiumClickOperation("00999 - Example ETEC1 - 0213");	
		wait(1000);
		winiumClickOperation("OK");
		wait(1000);
	}

	private void fillCvvData(String cvvData) {

		String cvvDataValue = "000" + cvvData;
		executeAutoITExe("ActivateEditCardProfile.exe");
		winiumClickOperation("Track Data");
		//clicking on 035.05 Discretionary Data
		winiumDriver.findElementByXPath("//*[contains(@AutomationId,'DEXXX_Field_DE035_05 ')]").sendKeys(cvvDataValue);
		wait(1000);
		winiumClickOperation("OK");
		wait(1000);
	}

	public void closeSimulator(String name) 
	{
		winiumDriver = null;
		//to kill previous instance of MAS 17
		if(SimulatorConstantsData.MAS_LICENSE_TYPE.contains("17"))
			name = "MAS17";
		if(SimulatorConstantsData.MDFS_LICENSE_TYPE.contains("17"))
			name = "MDFS17";

		if(name.equalsIgnoreCase("visa")) 
			disconnectAndCloseVts();

		MiscUtils.killProcessFromTaskManager("WINIUM");
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP(String tool)
	{
		try {
			clickTestOptions(tool);

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
		parameters =   "\"" + SimulatorConstantsData.MAS_PARENT_HANDLE + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
				+  PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
	}

	private void configureTestOptionsHostAndIPOnMdfs()
	{
		try {
			clickTestOptionsOnMdfs();

			String ipAdd = mdfsSimulator.getIpAddress();
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
		parameters =   "\"" + SimulatorConstantsData.MDFS_PARENT_HANDLE + PATH_BUILDER + mdfsSimulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER  + getValue(ip[1]) +  PATH_BUILDER + getValue(ip[2])
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

	public String searchTransactionWithDeviceAndGetStatus(Device device, TransactionSearch ts){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithDeviceAndGetStatus(device, ts);
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
		performDoubleClickOperation(MESSAGE_REVERSAL_INDICATOR);
		executeAutoITExe("GetVauleFromMessageReversalIndicator.exe"); 
		winiumClickOperation("OK");
		wait(1000);
		winiumClickOperation(CLOSE);
	}

	private void winiumLicenseSelectOperation(String locator, String tool) {
		activateMas(tool);
		List<WebElement> lst = winiumDriver.findElements(By.name(locator));
		MiscUtils.reportToConsole("winiumLicenseSelectOperation Count : " + lst);
		lst.get(0).click();
	}

	private void winiumLicenseSelectOperation(String locator) {
		List<WebElement> lst = winiumDriver.findElements(By.name(locator));
		MiscUtils.reportToConsole("winiumLicenseSelectOperation Count : " + lst);
		lst.get(0).click();
	}
	
	private void winiumClickOperation(String locator) {
		logger.info(WINIUM_LOG_COMMENT + locator);
		winiumDriver.findElementByName(locator).click();
	}

	private void performClickCardProfiles (String tool) {
		activateMas(tool);
		winiumClickOperation("Card Profiles");
	} 

	public Boolean isContains(String incomingValue, String lookFor) {
		Boolean isContains = false;
		if(incomingValue.toLowerCase().contains(lookFor.toLowerCase())) 
			isContains = true;
		return isContains;
	}

	private void selectLicense() {
		WebElement dd = winiumDriver.findElementById("comboBox1");
		ComboBox box = new ComboBox(dd);
		box.expand();
		dd.findElement(By.name("IPS Host Testing")).click();
	}

	private void selectLicense(String tool) {
		if(!isContains(tool, "mdfs")) 
			//			executeAutoITExe(SELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"" );
			selectLicense();
		else
			selectLicenseOnMdfs();
	}

	private void selectLicenseOnMdfs() {
		//		executeAutoITExe(SELECT_IPS_HOST_TESTMODE  + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"" );
		selectLicense();
	}

	private void reSelectLicense(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(RESELECT_IPS_HOST_TESTMODE  + SEPERATOR +SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			reSelectLicenseOnMdfs();
	}

	private void reSelectLicenseOnMdfs() {
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE  + SEPERATOR +SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	private void scrollUpToSelectTest(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(SCROLL_UP_ON_TESTCASES   + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			scrollUpToSelectTestOnMdfs();
	}

	private void scrollUpToSelectTestOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTCASES  + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	private void scrollUpToSelectTestResults(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(SCROLL_UP_ON_TESTRESULTS + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			scrollUpToSelectTestResultsOnMdfs();
	}

	private void scrollUpToSelectTestResultsOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS   + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	private void handleDialogs() { 
		executeAutoITExe("HandleUnhandlesDialogs.exe");
	}

	private void activateMas(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(ACTIVATE_MAS   + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			activateMdfs();
	}

	public void activateMdfs() {
		executeAutoITExe(ACTIVATE_MAS  + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
		wait(1000);
	}

	private void activateMcps() {
		executeAutoITExe("ActivateMCPS.exe"  + SEPERATOR + SimulatorConstantsData.MCPS_PARENT_HANDLE + "\"" );
		wait(1000);
	}

	private void clickTDG() {
		executeAutoITExe("ClickTDG.exe"  + SEPERATOR + SimulatorConstantsData.MCPS_PARENT_HANDLE + "\"" );
	}

	public void clickTestOptions(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(CLICK_TEST_OPTIONS   + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			clickTestOptionsOnMdfs();
	}

	public void clickTestOptionsOnMdfs() {
		executeAutoITExe(CLICK_TEST_OPTIONS  + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	public void clickTestMonitor(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe( CLICK_TEST_MONITOR   + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			clickTestMonitorOnMdfs();
	}

	public void clickTestMonitorOnMdfs() {
		executeAutoITExe(CLICK_TEST_MONITOR  + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	public void clickTestMode(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(CLICK_TEST_MODE  + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			clickTestModeOnMdfs();
	}

	public void clickTestModeOnMdfs() {
		executeAutoITExe(CLICK_TEST_MODE  + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	public void clickTestPreparations(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(CLICK_TEST_PREPARATION  + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			clickTestPreparationsOnMdfs();
	}

	public void clickTestPreparationsOnMdfs() {
		executeAutoITExe(CLICK_TEST_PREPARATION   + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
		wait(5000);
	}

	public void clickTestResults(String tool) {
		if(!isContains(tool, "mdfs")) 
			executeAutoITExe(CLICK_TEST_RESULTS  + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"" );
		else
			clickTestResultsOnMdfs();
	}

	public void clickTestResultsOnMdfs() {
		executeAutoITExe(CLICK_TEST_RESULTS   + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"" );
	}

	public void connectAndStartVtsCommunication() { 
		activateVts();

		WebElement visaTestSystemFrame = winiumDriver.findElement(By.xpath("*[starts-with(@Name, 'Visa Test System')]"));
		visaTestSystemFrame.click();
		winiumClickOperation("Start Communications");
		wait(2000);
		setVtsIpAddress();
		winiumClickOperation(VTS_COMM_HANDLER);
		winiumClickOperation("Start Line");
		Boolean connectionEstablished = winiumDriver.findElement(By.name("UP")).isDisplayed();
		if(connectionEstablished) {
			logger.info("VTS connection established succcessful!");
			assertTrue("VTS connection established succcessful!", true );
		} else {
			assertFalse("VTS connection is NOT succcessful!", false);
			throw new ValidationException("VTS connection is NOT succcessful!");
		}
		winiumClickOperation("Minimize");
	}

	private void loadVisaInputFile(String transaction) {
		String transactionName = visaTestCaseNameKeyValuePair.getVisaTestDataFileNameToUpload(transaction);
		//path has be put in "\" only hence the replace statement 
		String vtsInputFilePath = getResourceFolderPath().replace("\\\\", "\\") + SimulatorConstantsData.VISA_INPUT_FILE_PATH + transactionName +".stf";
		logMessage("Loading Visa Input File ", vtsInputFilePath);
		WebElement visaTestSystemFrame = winiumDriver.findElement(By.xpath("*[starts-with(@Name, 'Visa Test System')]"));
		visaTestSystemFrame.click();
		winiumClickOperation("Open");
		wait(2000);
		executeAutoITExe("ImportVisaTestFile.exe " + vtsInputFilePath);
		wait(3000);

		//		collapseTreeMenuOnVts(transactionToSelect);
	}

	private void collapseTreeMenuOnVts(String selection) {
		activateVts();
		winiumClickOperation(selection);
		pressEnter();
		pressLeftArrow();

		int i = 0;
		while (i < 7) { 
			pressDownArrow();
			pressLeftArrow();
			i++;
		}
	}

	public void activateVts() {
		executeAutoITExe("ActivateVTSAndHandleOKDialog.exe");
	}

	public void disconnectAndCloseVts() {
		executeAutoITExe("vtsCloseIncomingAndLogViewer.exe"); // close VTS
		executeAutoITExe("CloseVTS.exe");
	}

	private void setVtsIpAddress() {
		//for keying ip and port on VTS if present
		String parameter =   "\"" + vtsSimulator.getVtsIpAddress() + PATH_BUILDER + vtsSimulator.getHostIpAddress() + PATH_BUILDER + vtsSimulator.getHostPort() + "\"";

		executeAutoITExe(SET_VTS_IP + parameter );
		logMessage(" ******* Parameter for setVtsIpAddress : ******"  , parameter );     
	}

	public void performVisaTransaction(String transaction) {
		browserMinimize();
		String transactionName = visaTestCaseNameKeyValuePair.getVisaTestCaseToSelect(transaction);
		logMessage("VISA Transaction Test Case Name : ",  transactionName );
		
		loadVisaInputFile(transaction);
		//method to change values in Excel based on Device Context values so that this file can be uploaded into the system
		setValuesInExcelTemplateBasedOnDeviceContext();
		loadVisaTestGroupTemplate();

		selectVisaTestCaseToMakeDataElementChange(transactionName);

		executeVisaTest();
	}

	private void navigateToVariableManagerAndLoadTestGroupTemplate() { 
		executeAutoITExe("VTSNavigateToVariablesManager.exe"  + SEPERATOR + vtsTestGroupInputFilePath + "\"");
		executeAutoITExe("VTSHandleVariablesManager.exe");
	}

	private void loadVisaTestGroupTemplate() { 
		//method to load the excel template after navigating to VariableManager and importing the File to generate new Automation Test Group Template
		navigateToVariableManagerAndLoadTestGroupTemplate();
	}

	private void selectVisaTestCaseToMakeDataElementChange(String transaction) {
		MiscUtils.reportToConsole(" ******* selectVisaTestCaseToMakeDataElementChange ******" );     
		activateVts();
		winiumClickOperation(transaction);
		pressEnter();
		pressDownArrow(1); // to select Properties
		executeAutoITExe("VtsSetDefaultAutoamtionCardInProperties.exe"); 	// to select properties file and set default Test Group;
		winiumClickOperation(transaction);
		pressEnter();
	}

	private void editFeildValues(String fieldNumber, String value) {
		MiscUtils.reportToConsole(" ******* editFeildValues ******" );     
		activateVts();
		String parameter =   "\"" + value + PATH_BUILDER + "\"";
		winiumClickOperation(fieldNumber);
		executeAutoITExe("SetValueInVisaMessageEditor.exe " + parameter);
	}

	private String getFeildDescriptionFromLogViewer(String propertyByName) {
		String resultResponse = "validations ok";
		String tempValue;
		MiscUtils.reportToConsole(" ******* getFeildDescriptionFromLogViewer ******" );     

		executeAutoITExe("VtsManageLogViewer.exe");
		WebElement logViewerFrame = winiumDriver.findElement(By.name("Incoming Message"));
		if(!logViewerFrame.isDisplayed()) {
			logMessage(VISA_FAILURE_MESSAGE, "");
			return VISA_FAILURE_MESSAGE;
		}
		logViewerFrame.click();
		winiumClickOperation("F2"); //selecting this to be able to scroll on the page and F2 is always visible even when we are at the botton of the frame
		pressPageUp(); //scrolling to top of frame
		if(winiumDriver.findElement(By.name(propertyByName)).isDisplayed()) {
			winiumClickOperation(propertyByName);
		} else {
			logViewerFrame.click();
			pressPageDown(2); // scrolling down to the end of the page
			winiumClickOperation(propertyByName);
		}
		List<WebElement> result= winiumDriver.findElement(By.name(propertyByName)).findElements(By.xpath("./*[contains(@LocalizedControlType, 'text')]"));
		//printing values .. not needed but left it so that values can be seen in console
		for(WebElement e : result) {
			MiscUtils.reportToConsole(e.getAttribute("Name"));
			}
		//getting value from last section from F39 list item
		tempValue = result.get(result.size()-1).getAttribute("Name");
		logMessage("F39 response is : ", tempValue);		
		if(tempValue.toString() != "00") 
			resultResponse =  "validations not ok";
		
		logMessage("Visa Output Response Set to : ", resultResponse);	
		return resultResponse;
	}

	public void executeVisaTest() {
		MiscUtils.reportToConsole(" ******* executeVisaTest ******" );
		//delete older logs from Detail Log
		//deleteOldLogs();  // sometimes system is not responding when we delete old logs and click on Execute Test.. it crashes
		winiumClickOperation("Execute Test");
		wait(5000);
		executeAutoITExe("visaTestExeution.exe");
	}

	public String verifyVisaOutput(String transaction) {
		String results;
		MiscUtils.reportToConsole(" ******* verifyVisaOutput ******" );     

		winiumClickOperation(transaction);
		pressEnter();
		//		pressDownArrow(2); // to select the Out Req
		winiumClickOperation("View Detail Log");
		wait(9000); // transaction does not always reflect immediately hence the wait
		winiumClickOperation(RESULT_IDENTIFIER);
		wait(1000);
		winiumClickOperation(RESULT_IDENTIFIER);
		wait(1000);
		winiumClickOperation(RESULT_IDENTIFIER);

		// here we are not sure as to what are we verifying
		Actions action = new Actions(winiumDriver);
		List<WebElement> lst = winiumDriver.findElements(By.name("0110 ISO Message, INCOMING. Match found"));
		if(lst.isEmpty()) {
			logMessage(VISA_FAILURE_MESSAGE, "");
			return VISA_FAILURE_MESSAGE;
		}
		//clicking on the last item from bottom
		lst.get(0).click();
		action.doubleClick(lst.get(0)).perform(); 
		// outout screen comes up on double clicking on the first item in the list
		winiumClickOperation("Maximize");

		results = getVisaResult();
		browserMaximize();
		return results;
	}

	private void deleteOldLogs() { 
		executeAutoITExe("vtsDeleteOlderLogViewerLogs.exe");
		executeAutoITExe("vtsCloseLogViewer.exe"); // when there are no previous logs in the logger, then the above exe will leave the logger window open hence to close it.. thsi call
	}

	private String getVisaResult() {
		return getFeildDescriptionFromLogViewer("F39");
	}

	public void browserMinimize() {
		webProvider.get().manage().window().setPosition(new Point(-2000, 0));
	}

	public void browserMaximize() {
		webProvider.get().manage().window().maximize();
	}

	private void getMasDetails() { 
		MasDetailsKeyValuePair.initializeMasData();
		if(!simulatorVersion.getMasVersion().toUpperCase().contains("LATEST")) {
			MasDetailsKeyValuePair.getSpecificMasVersionDetails(simulatorVersion.getMasVersion());
		} else {
			MasDetailsKeyValuePair.getLatestVersionMasDetailsInstalledOnMachine();
		}
	}

	private void getMdfsDetails() { 
		MdfsDetailsKeyValuePair.initializeMdfsData();
		if(!simulatorVersion.getMdfsVersion().toUpperCase().contains("LATEST")) {
			MdfsDetailsKeyValuePair.getSpecificMdfsVersionDetails(simulatorVersion.getMdfsVersion());
		} else {
			MdfsDetailsKeyValuePair.getLatestVersionMdfsDetailsInstalledOnMachine();
		}
	}

	private void launchRequiredSimulatorSession(String simulator) {
		//to fetch latest MAS details installed on the machine
		if(simulator.toUpperCase().contains("MAS")) {
			getMasDetails();
		} else if(simulator.toUpperCase().contains("MDFS")) {
			getMdfsDetails(); 
		}
	}

	private void setValuesInExcelTemplateBasedOnDeviceContext() {
		Device device = context.get(ContextConstants.DEVICE);
		SimulatorUtilities sm = new SimulatorUtilities();
		String sheetName = "Card Groups";
		// when data is dynamically passed when scripts run from end-2-end
		if (device != null) {
			// _____________________FOR PINLESS CARD________________ device plan context is used to get Expiry Date incase of PinLess card
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setServiceCode(devicePlan.getServiceCode());
			if ("YES".equalsIgnoreCase(devicePlan.getIsPinLess())) {
				device.setExpirationDate(devicePlan.getExpiryDate());
				device.setPinNumberForTransaction("PINLESS");
			}
			// _____________________FOR PINLESS CARD________________ __________________CURRENCY VAL FROM EXCEL _________ fetching currency value from excel
			if ("Fixed [F]".equalsIgnoreCase(devicePlan.getExpiryFlag())) {
				device.setExpirationDate(devicePlan.getExpiryDate());
			}

			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F002 - PAN", device.getDeviceNumber());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F014 - EXPDATE", device.getExpirationDate());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName,"F023 - CARD SEQ NUM", device.getSequenceNumber());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName,"F035.04 - SVCCODE",  device.getServiceCode());
		} else {
			//else block implemented for Testing purpose.. keys in static data in the excel "VisaUploadTemplate.xls" @ ..\\src\main\resources\Simulator\VisaInputFile
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F002 - PAN", "4761340000000019");
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F014 - EXPDATE", "2210" );
			sm.setCellData(vtsTestGroupInputFilePath, sheetName,"F023 - CARD SEQ NUM", "111");
			sm.setCellData(vtsTestGroupInputFilePath, sheetName,"F035.04 - SVCCODE",  "101");
		}
	}

	private void logMessage(String message1, String message2) {
		logger.info(message1, message2 );
		MiscUtils.reportToConsole(message1 + message2 );
	}
	
	public String getARN(String deviceNumber, TransactionSearch ts){
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithDevice(deviceNumber, ts);
	}
}