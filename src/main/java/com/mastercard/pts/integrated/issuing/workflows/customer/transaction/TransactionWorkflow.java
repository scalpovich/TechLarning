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
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.LoadBalanceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.pages.agent.settlement.InitiateSettlementPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceApprovePage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceRequestPage;
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
	private static final String PATH_BUILDER = "\" \"";
	private static final String ISSUER_TEST = "IssuerTest";
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
	private static final String SET_MAS_IP = "SetMASIP.exe ";
	private static final String SEPERATOR = " \"";
	private static final String MESSAGE_REVERSAL_INDICATOR = "messageReversalIndicator";
	private static final String BIN_TABLE = "BIN Table";
	private static final String TEST_CASES = "Test Cases (Issuer Testing)";
	private static final String ADD_BIN_RANGE = "ActivateAddBINrange.exe";
	private LoadBalanceRequestPage lbrpage;
	private LoadBalanceApprovePage lbapage;
	private InitiateSettlementPage ispage;

	@Autowired
	private MasSimulator simulator;

	@Autowired
	private FinSimSimulator finSimSimulator;

	@Autowired
	private Navigator navigator;

	private WiniumDriver winiumDriver;

	@Autowired
	private TestContext context;

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
			winiumDriver.findElementByName("1240/200 First Presentment").click();
			winiumDriver.findElementByName("Add a field to the current message").click();
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
			activateEditField();
			performClickOperation("AddRemove");
			wait(2000);
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
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
			// saving this file after modifications
			performClickOperation("Save");
			performClickOperation("OK");
			wait(2000);
		} catch (Exception e) {
		}
	}

	public void performOptimizedMasTransaction(String transaction, Transaction transactionData, Boolean sameCard) {
		handleDialogs();

		addBinRangeAndCurrencyDetailsBasedOnCardNumber(transactionData, transaction, sameCard);

		importAndLoadCardProfile(transactionData.getCardProfile(), transaction);

		// filling Chip details for EMV cards
		if (transaction.toLowerCase().contains("emv")) {
			activateMas(transaction);
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

	public String getCurrencyToBeUsed(String currency) {
		List<String> theList = Arrays.asList(currency.split(""));
		String currencyTemp = "356";
		if (!theList.isEmpty()) {
			currencyTemp = currency;
		}
		return currencyTemp;
	}

	public void launchAndConnectToFinSim() {
		connectToFINSim();
	}

	public void launchAndConnectToMCPS() {
		selectMCPSLicense();
		wait(5000);
		while (getLoadingMCPSSimulatorWindowCount() > 0) {
			wait(500);
		}
	}

	public String verifyTestResults() {
		return verifyResults();
	}

	public String verifyTestResultsOnMdfs() {
		return verifyResultsOnMdfs();
	}

	public void launchWiniumAndSimulator(String simulator) {
		MiscUtils.killProcessFromTaskManager("WINIUM");
		MiscUtils.killProcessFromTaskManager(simulator);

		try {
			startWiniumDriverWithSimulator(simulator);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}

		if (simulator.toUpperCase().contains("FINSIM")) {
			launchAndConnectToFinSim();

		} else if (simulator.toUpperCase().contains("MAS")) {
			selectLicenseAndConfigure("Credit - Professional", "MAS 16.4");
			wait(4000);
			connect2IPSHostModeAndConfigureIP("MAS");

			// clicking click Test Preparation
			clickTestPreparations("MAS");
			performClickTestCases("MAS");

			// clicking click Test Monitor
			clickTestMonitor("MAS");
			performClickTestCases("MAS");
		} else if (simulator.toUpperCase().contains("MCPS")) {
			launchAndConnectToMCPS();
		} else if (simulator.toUpperCase().contains("MDFS")) {
			selectLicenseAndConfigure("Debit - Professional", "MDFS 16.4");
			wait(4000);
			connect2IPSHostModeAndConfigureIPOnMdfs();

			// clicking click Test Preparation
			clickTestPreparationsOnMdfs();
			performClickTestCases("MDFS");

			// clicking click Test Monitor
			clickTestMonitorOnMdfs();
			performClickTestCases("MDFS");
		}
	}

	public void startWiniumDriverWithSimulator(String serviceName) {
		try {
			DesktopOptions options = launchSimulator(serviceName);
			String path = getResourceFolderPath() + SimulatorConstantsData.WINIUM_DRIVER_EXE_PATH.replace("\\", "\\\\");
			logger.info("Winium Path : " + path);
			Runtime.getRuntime().exec(path, null, new File(path.replace("Winium.Desktop.Driver.exe", "")));
			wait(3000);
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			wait(3000);
			logger.info("Winium and " + serviceName + " being launched");
			wait(5000);
		} catch (Exception e) {
			logger.debug("Exception occurred while starting Winium", e);
			MiscUtils.propagate(e);
		}
	}

	private DesktopOptions launchSimulator(String serviceName) {
		DesktopOptions option = new DesktopOptions();
		if (serviceName.toUpperCase().contains("MAS")) {
			option = launchMAS();
		} else if (serviceName.toUpperCase().contains("FINSIM")) {
			option = launchFinSim();
		} else if (serviceName.toUpperCase().contains("MCPS")) {
			option = launchMCPS();
		} else if (serviceName.toUpperCase().contains("MDFS")) {
			option = launchMDFS();
		}
		return option;
	}

	private DesktopOptions launchMAS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + SimulatorConstantsData.MAS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MAS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchFinSim() {
		DesktopOptions options = new DesktopOptions();
		String path = getResourceFolderPath() + SimulatorConstantsData.FINSIM_EXE_PATH.replace("\\", "\\\\");
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + path);
		options.setApplicationPath(path);
		wait(3000);
		return options;
	}

	private DesktopOptions launchMCPS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + SimulatorConstantsData.MCPS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MCPS_EXE_PATH);
		return options;
	}

	private DesktopOptions launchMDFS() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + SimulatorConstantsData.MAS_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.MAS_EXE_PATH);
		return options;
	}

	public void importAndLoadTestCase(String filePath, String transaction) {
		MiscUtils.reportToConsole("******************** importAndLoadTestCase Started ******************");
		// navigating to "Test Preparation" section
		clickTestPreparations(transaction);
		importTestCaseFile(filePath, transaction);

		selectTestCaseFromImportedCases(transaction);
	}

	private void importTestCaseFile(String fileName, String transaction) {
		MiscUtils.reportToConsole("******************** importTestCaseFile Started ******************");
		activateMas(transaction);
		winiumClickOperation(TEST_CASES);
		performClickOperation("importFile");
		wait(8000);
		executeAutoITExe("ImportTestCase.exe " + fileName);
		wait(3000);
	}

	public void importAndLoadCardProfile(String filePath, String transaction) {
		MiscUtils.reportToConsole("******************** importAndLoadCardProfile Started ******************");
		clickTestPreparations(transaction);
		importCardProfileFile(filePath, transaction);
		if (transaction.toLowerCase().contains("emv")) {
			pressPageDown(5);
			pressTab();
			pressPageDown(5);
		}
	}

	private void importCardProfileFile(String filePath, String transaction) {
		activateMas(transaction);
		performClickCardProfiles(transaction);
		winiumDriver.findElementByName("Card Profiles").findElement(By.name("toolStrip1")).findElement(By.name("toolStripButton1")).click();
		wait(6000);
		executeAutoITExe("ImportCardProfile.exe " + filePath);
	}

	/*
	 * public void removeLastEntry() { clickTestPreparations(); activateMas(); performClickOperation("Imported"); pressPageDown(); pressDelete(); wait(5000); }
	 */

	private void selectTestCaseFromImportedCases(String testcaseName) {
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
		// clicking click Test Monitor
		clickTestMonitor(transaction);
		wait(3000);
		selectTestCaseFromImportedCases(transaction);
		activateMas(transaction);
		winiumClickOperation(TEST_CASES);
		performDoubleClickOperation("RunTest");
		wait(5000);
		executeAutoITExe("ActivateStartTestDialogAndClose.exe");
	}

	public String verifyResults() {
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResults("MAS");
		wait(8000);

		winiumDriver.findElementByName("Sequential View").click();
		scrollUpToSelectTestResults("MAS");
		pressPageDown(2);
		return getResult();
	}

	public String verifyResultsOnMdfs() {
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResultsOnMdfs();
		wait(8000);

		winiumDriver.findElementByName("Sequential View").click();
		scrollUpToSelectTestResultsOnMdfs();
		pressPageDown(2);
		return getResult();
	}

	private String getResult() {
		List<WebElement> lst = null;
		if (context.get(ConstantData.TRANSACTION_NAME).toString().contains("COMPLETION"))
			lst = winiumDriver.findElements(By.name("0130 : NTW to APS Rcvd (ACQUIRERSTREAM1)"));
		else
			lst = winiumDriver.findElements(By.name("0110 : NTW to APS Rcvd (ACQUIRERSTREAM1)"));
		// clicking on the last item from bottom
		lst.get(lst.size() - 1).click();
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
			logger.debug("Exception occurred while loading file in MCPS {} ", e);
			MiscUtils.propagate(e);
		}
	}

	public void loadIPMFileIntoMCPS(String fileName) {
		clickTDG();
		performClickOperation("folder");
		executeAutoITExe("ActivateOpenExistingFileScreen.exe");
		loadFile(fileName);
	}

	private void loadAuthFileIntoMCPS(String fileName) {
		clickTDG();
		performClickOperation("Down Arrow");
		performClickOperation("Import Auth file");
		executeAutoITExe("LoadAuthFile.exe " + fileName);
		loadFile(fileName);
	}

	private void clickMiddlePresentmentAndMessageTypeIndicator() {
		clickMiddlePresentment();
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
	}

	private void clickMiddlePresentment() {
		performClickOperationOnImages(MIDDLE_PRESENTMENT);
	}

	private String editFieldsAndProcess() {
		String aRN = "";
		try {
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
			MiscUtils.reportToConsole("rRN :  trimmedRrn : aRN  -  " + rRN + " : - : " + trimmedRrn + " : - :" + aRN);
			updatePanNumber(SimulatorConstantsData.SAMPLE_PAN_NUMBER);
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
			pressPageUp();
			clickMiddlePresentmentAndMessageTypeIndicator();
			searchForImageAndPerformDoubleClick("Forwarding Institution Identification Code");
			activateEditField();
			winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			setText("");
			setText("999684");
			wait(2000);
			winiumDriver.findElementByName("Set Value").click();
			wait(2000);
			winiumDriver.findElementByName(CLOSE).click();
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

	private void updatePanNumber(String cardNumber) throws AWTException {
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		searchForImageAndPerformDoubleClick("Primary Account Number (PAN)");
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText(cardNumber);
		wait(2000);
		winiumDriver.findElementByName("Set Value").click();
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
	}

	public String assignUniqueARN() {
		String rRN = MiscUtils.generateRandomNumberAsString(12);
		String arnNumber = "";
		try {
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

	private void activateEditField() {
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
		winiumDriver.findElementByName("Set Value").click();
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
		winiumDriver.findElementByName("Set Value").click();
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
		performClickOperation("Add file to CEE");
		wait(2000);
		winiumDriver.findElementByName("Process File(s)").click();
		wait(5000);
		executeAutoITExe("GetCEEData.exe");
	}

	private String getIpmFileName() throws IOException {
		String fileData = getFileData("CEEData.txt");
		String[] splitString = fileData.split("\\s+");
		logger.info("CEEData Text Data : ", splitString[5]);
		return splitString[5];
	}

	public void loadIpmFile(String fileName) {
		try {
			clickTDG();
			performClickOperation("folder"); // open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName);
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
			performClickOperation("folder"); // open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName);
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

	public void assignUniqueFileId() throws AWTException {
		activateMcps();
		String fileId = RandomStringUtils.randomNumeric(5);
		// step to ensure that File Header is not already selecdted
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		winiumDriver.findElementByName("1644/697 File Header").click();
		fillFileId(fileId);
		winiumDriver.findElementByName("1644/695 File Trailer").click();
		fillFileId(fileId);
		performClickOperation("Save");
		performClickOperation("OK");
		wait(2000);
	}

	private void fillFileId(String value) throws AWTException {
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
		winiumDriver.findElementByName("Set Value").click();
		wait(2000);
		winiumDriver.findElementByName(CLOSE).click();
	}

	public void authFileGeneration() {
		try {
			generateAuthFileFromMas();
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public String getFileData(String filePath) throws IOException {
		try (FileInputStream fis = new FileInputStream(getTempDirectoryLocationForSimulatorResults() + "//" + filePath);) {
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String fileName = br.readLine();
			fis.close();
			return fileName;
		}
	}

	private void generateAuthFileFromMas() throws AWTException {
		wait(5000);
		clickTestResults("MAS");
		winiumDriver.findElementByName("Sequential View").click();
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

	private void selectMCPSLicense() {
		wait(5000);
		executeAutoITExe("ActivateLicenseProfiles.exe");
		performClickOperation("License profiles");
		performClickOperation("Select");
		wait(5000);
	}

	public void selectLicenseAndConfigure(String licenseTypeToSelect, String licenseFor) {
		try {
			String licenseForSelection = null;
			if (licenseFor.toUpperCase().contains("MAS 16.4"))
				licenseForSelection = SimulatorConstantsData.MAS_LICENSE_TYPE_16X;
			else if (licenseFor.toUpperCase().contains("MDFS 16.4"))
				licenseForSelection = SimulatorConstantsData.MDFS_LICENSE_TYPE_16X;

			MiscUtils.reportToConsole("selectLicenseAndConfigure  : " + licenseForSelection);

			if (getCountOfLicenseScreen() == 0) {
				wait(1000);
			}

			executeAutoITExe("ActivateLicenseProfiles.exe");
			winiumLicenseSelectOperation(licenseTypeToSelect, licenseFor);
			winiumClickOperation("Select");
			wait(15000);
			executeAutoITExe("ActivateSelectServices.exe");
			if (getLoadServicesScreen() > 0) {
				executeAutoITExe("ActivateSelectServices.exe");
				wait(2000);
				winiumClickOperation(licenseForSelection);
				pressSpaceBar();
				winiumClickOperation("Load the services");
			}

			wait(5000);
			while (getLoadingSimulatorWindowCount() > 0) {
				wait(500);
			}
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void connect2IPSHostModeAndConfigureIP(String tool) {
		try {
			connect2IpsHostTestMode(tool);

			// change ip and reselefct IPS Host Test Mode
			configureTestOptionsHostAndIP(tool);
			reconnect2IpsHostTestMode(tool);
		} catch (FindFailed e) {
			throw MiscUtils.propagate(e);
		}
	}

	public void connect2IPSHostModeAndConfigureIPOnMdfs() {
		try {
			connect2IpsHostTestModeOnMdfs();

			// change ip and reselefct IPS Host Test Mode
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

		while (getWindowButtonCount() > 0) {
			winiumDriver.findElementByName("OK").click();
			selectLicense(tool);
			wait(5000);
		}
	}

	private void reconnect2IpsHostTestModeOnMdfs() {
		clickTestModeOnMdfs();
		reSelectLicenseOnMdfs();
		wait(10000);

		while (getWindowButtonCount() > 0) {
			winiumDriver.findElementByName("OK").click();
			selectLicense("MDFS");
			wait(5000);
		}
	}

	private void connect2IpsHostTestMode(String tool) throws FindFailed {
		wait(5000);
		clickTestMode(tool);
		selectLicense(tool);
		wait(15000);
		waitForImageToAppear("CONNECTED");
		wait(15000);
	}

	private void selectLicense() {
		WebElement dd = winiumDriver.findElementById("comboBox1");
		ComboBox box = new ComboBox(dd);
		box.expand();
		dd.findElement(By.name("IPS Host Testing")).click();
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

	public void addBinRangeAndCurrencyDetailsBasedOnCardNumber(Transaction transactionData, String transaction, Boolean sameCard) {
		// we do not have to perform this step if it same card on which operations are being performed
		if (!sameCard) {
			configureBinRange(transactionData, transaction);
		}
	}

	private void configureBinRange(Transaction transactionData, String transaction) {
		String bin = transactionData.getCardNumber();
		String issuerCountryCode = transactionData.getIssuerCountryCode(); // "356"; transactionData.getCurrency();
		String issuerCurrencyCode = transactionData.getIssuerCurrencyCode(); // value from DE Element 49
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency(); // value from DE Element 61_13

		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";

		try {
			clickTestOptions(transaction);
			activateMas(transaction);
			winiumClickOperation(BIN_TABLE);
			wait(1000);
			// clicking again just incase as test will fais if this click fails
			winiumClickOperation(BIN_TABLE);
			wait(2000);
			performClickOperation("Add New");
			wait(10000);
			executeAutoITExe(ADD_BIN_RANGE);
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
			// mdfs has differnet options compared to MAS
			if (!isContains(transaction, "mdfs")) {
				executeAutoITExe(ADD_BIN_RANGE);
				pressTab();
				wait(1000);
				setText(issuerCountryCode);
				pressTab();
				setText(issuerCurrencyCode);
				pressTab();
				setText(cardHolderBillingCurrency);
			} else {
				executeAutoITExe(ADD_BIN_RANGE);
				setText(issuerCountryCode);
				pressTab();
				pressTab();
				setText(issuerCurrencyCode);
				pressTab();
				setText(cardHolderBillingCurrency);
			}
			executeAutoITExe(ADD_BIN_RANGE);
			winiumClickOperation("OK");
			wait(2000);
			if (isImagePresent("OK")) {
				performClickOperation("OK");
				wait(2000);
			}
		} catch (Exception e) {
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

	public void closeSimulator(String name) {
		winiumDriver = null;
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP(String tool) {
		try {
			clickTestOptions(tool);
			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");
			setMasIp(ip);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void clickTestOption() {
		List<WebElement> allTOButtons = winiumDriver.findElementsByName("Test Options");
		logger.info("Number of all available buttons = {}", allTOButtons.size());
		for (WebElement webElement : allTOButtons) {
			logger.info("Name of Buttons = {} ", webElement.getAttribute("Name"));
			webElement.click();
		}
	}

	private void setMasIp(String[] ip) {
		String parameters;
		// for keying ip and port on MAS 16.x if present
		parameters = "\"" + SimulatorConstantsData.MAS_16_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue(ip[0]) + PATH_BUILDER + getValue(ip[1]) + PATH_BUILDER + getValue(ip[2])
				+ PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
		/*
		 * for keying ip and port on MAS 17.x if present parameters = "\"" + SimulatorConstantsData.MAS_17_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER +
		 * getValue(ip[1]) + PATH_BUILDER + getValue(ip[2]) + PATH_BUILDER + getValue(ip[3]) + "\""; setMasIpAddress(parameters);
		 */
	}

	private void configureTestOptionsHostAndIPOnMdfs() {
		try {
			clickTestOptionsOnMdfs();

			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");
			setMasIpOnMdfs(ip);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void setMasIpOnMdfs(String[] ip) {
		String parameters;
		// for keying ip and port on MAS 16.x if present
		parameters = "\"" + SimulatorConstantsData.MDFS_16_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue(ip[0]) + PATH_BUILDER + getValue(ip[1]) + PATH_BUILDER + getValue(ip[2])
				+ PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
		/*
		 * for keying ip and port on MAS 17.x if present parameters = "\"" + SimulatorConstantsData.MDFS_17_X + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue( ip[0]) + PATH_BUILDER +
		 * getValue(ip[1]) + PATH_BUILDER + getValue(ip[2]) + PATH_BUILDER + getValue(ip[3]) + "\""; setMasIpAddress(parameters);
		 */
	}

	private void setMasIpAddress(String parameter) {
		executeAutoITExe(SET_MAS_IP + parameter);
		MiscUtils.reportToConsole(" ******* Parameter for setMasIp : ******" + parameter);
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

	private void connectToFINSim() {
		try {
			executeAutoITExe("HandleFinSimLicenseValidationProblem.exe");
			wait(2000);
			if (performWiniumOperationIsObjectDisplayed("Password :")) {
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
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public String getPinNumber(Transaction transactionData) {
		try {
			winiumDriver.findElementByName("User Name:").sendKeys("Automation");
			wait(2000);
			// Ex: SelectValuesFromPinOffsetCalculator.exe "5877650150876119" "EE9A8BACEE127B4B2DC900D8EEA9221D" "1234567890123456" "4" "12" "F" "7782" "4"
			String parameters = "\"" + transactionData.getCardNumber() + PATH_BUILDER + transactionData.getPinKey() + PATH_BUILDER + transactionData.getDecimalisationTable() + PATH_BUILDER
					+ transactionData.getValidationDataStart() + PATH_BUILDER + transactionData.getCardLength() + PATH_BUILDER + transactionData.getPad() + PATH_BUILDER
					+ transactionData.getOffSetForCard() + PATH_BUILDER + transactionData.getPinLength() + "\"";
			MiscUtils.reportToConsole(" ******* Parameter for SelectValuesFromPinOffsetCalculator : ******" + parameters);
			executeAutoITExe("SelectValuesFromPinOffsetCalculator.exe " + parameters);
			wait(7000);
			return getPinText();
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
			return null;
		}
	}

	private Boolean performWiniumOperationIsObjectDisplayed(String clickOn) {
		wait(1000);
		return winiumDriver.findElementByName(clickOn).isDisplayed();
	}

	public String getAuthorizationStatus(String arnNumber, TransactionSearch ts) {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithARN(arnNumber, ts);
	}

	public String getFeePostingStatus(String arnNumber, TransactionSearch ts) {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithArnAndGetFee(arnNumber, ts);
	}

	public String searchTransactionWithArnAndGetStatus(String arnNumber, TransactionSearch ts) {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithArnAndGetStatus(arnNumber, ts);
	}

	public String getDecimalisationTableValue(String text) {
		return text.toUpperCase().replace("A", "0").replace("B", "1").replace("C", "2").replace("D", "3").replace("E", "4").replace("F", "5").replace("G", "6").replace("H", "7").replace("I", "8")
				.replace("J", "9");
	}

	public void verifychargeBackOutgoingMsg() {
		performClickOperation("firstChargeBack");
		performDoubleClickOperation("cardIssuerReferenceData");
		wait(10000);
		String text = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
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

	private void winiumClickOperation(String locator) {
		logger.info(" *****  winiumClick Operation is being performed :  " + locator);
		winiumDriver.findElementByName(locator).click();
	}

	private void performClickTestCases(String tool) {
		activateMas(tool);
		winiumClickOperation("Test Cases (Issuer Testing)");
	}

	private void performClickCardProfiles(String tool) {
		activateMas(tool);
		winiumClickOperation("Card Profiles");
	}

	public Boolean isContains(String incomingValue, String lookFor) {
		Boolean isContains = false;
		if (incomingValue.toLowerCase().contains(lookFor.toLowerCase()))
			isContains = true;
		return isContains;
	}

	private void selectLicense(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(SELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			selectLicenseOnMdfs();
	}

	private void selectLicenseOnMdfs() {
		executeAutoITExe(SELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	private void reSelectLicense(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			reSelectLicenseOnMdfs();
	}

	private void reSelectLicenseOnMdfs() {
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	private void scrollUpToSelectTest(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(SCROLL_UP_ON_TESTCASES + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			scrollUpToSelectTestOnMdfs();
	}

	private void scrollUpToSelectTestOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTCASES + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	private void scrollUpToSelectTestResults(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(SCROLL_UP_ON_TESTRESULTS + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			scrollUpToSelectTestResultsOnMdfs();
	}

	private void scrollUpToSelectTestResultsOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	private void handleDialogs() {
		executeAutoITExe("HandleUnhandlesDialogs.exe");
	}

	private void activateMas(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(ACTIVATE_MAS + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			activateMdfs();
	}

	public void activateMdfs() {
		executeAutoITExe(ACTIVATE_MAS + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
		wait(1000);
	}

	private void activateMcps() {
		executeAutoITExe("ActivateMCPS.exe" + SEPERATOR + SimulatorConstantsData.MCPS_16_X + "\"");
		wait(1000);
	}

	private void clickTDG() {
		executeAutoITExe("ClickTDG.exe" + SEPERATOR + SimulatorConstantsData.MCPS_16_X + "\"");
	}

	public void clickTestOptions(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(CLICK_TEST_OPTIONS + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			clickTestOptionsOnMdfs();
	}

	public void clickTestOptionsOnMdfs() {
		executeAutoITExe(CLICK_TEST_OPTIONS + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	public void clickTestMonitor(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(CLICK_TEST_MONITOR + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			clickTestMonitorOnMdfs();
	}

	public void clickTestMonitorOnMdfs() {
		executeAutoITExe(CLICK_TEST_MONITOR + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	public void clickTestMode(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(CLICK_TEST_MODE + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			clickTestModeOnMdfs();
	}

	public void clickTestModeOnMdfs() {
		executeAutoITExe(CLICK_TEST_MODE + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}

	public void clickTestPreparations(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(CLICK_TEST_PREPARATION + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			clickTestPreparationsOnMdfs();
	}

	public void clickTestPreparationsOnMdfs() {
		executeAutoITExe(CLICK_TEST_PREPARATION + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
		wait(5000);
	}

	public void clickTestResults(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(CLICK_TEST_RESULTS + SEPERATOR + SimulatorConstantsData.MAS_16_X + "\"");
		else
			clickTestResultsOnMdfs();
	}

	public void clickTestResultsOnMdfs() {
		executeAutoITExe(CLICK_TEST_RESULTS + SEPERATOR + SimulatorConstantsData.MDFS_16_X + "\"");
	}
}