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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.springframework.beans.factory.annotation.Value;

import winium.elements.desktop.ComboBox;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
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
	private static final String SELECT_DE_VALUE = "Drop Down Button";
	private static final String BILLING_CURRENCY_VALUE = "356 - Indian Rupee";
	private static final String SAVE = "Save";
	private static final String SET_VALUE = "Set Value";
	private static final String CLOSE = "Close";
	private static final String OK = "OK";
	private static final String MESSAGE_TYPE_INDICATOR = "Message Type Indicator";
	private static final String MIDDLE_PRESENTMENT = "Middle Presentment";
	private static final String PATH_BUILDER = "\" \"";
	private static final String ISSUER_TEST = "IssuerTest";
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
	private static final String ADD_BIN_RANGE_SCROLL = "AddBinRangeScrolling.exe";
	private static final String ADD_BIN_RANGE_MAKE_OK_VISIBLE = "AddBinRangeMakeOkVisible.exe";
	private LoadBalanceRequestPage lbrpage;
	private LoadBalanceApprovePage lbapage;
	private InitiateSettlementPage ispage;
	private static final String VTS_COMM_HANDLER = "VTS Communications Handler (1)";
	private static final String SET_VTS_IP = "SetVTSIP.exe ";
	private static final String WINIUM_LOG_COMMENT = " *****  winiumClick Operation is being performed :: {} ";
	private String vtsTestGroupInputFilePath = getResourceFolderPath().replace("\\\\", "\\") + SimulatorConstantsData.VISA_EXCEL_TEMPLATE_FILE_PATH;
	private static final String RESULT_IDENTIFIER = "Refresh";
	private static final String VISA_FAILURE_MESSAGE = "Visa Incomming Message for transaction did not come :: {}";
	private static final String SIMULATOR_LICENSE_TYPE_17 = "17";
	private static final String SIMULATOR_LICENSE_TYPE_18 = "18";

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

	@Autowired
	private LinuxBox linuxbox;

	@Value("${linux.host.name}")
	private String hostName;

	@Value("${linux.port.number}")
	private String number;

	@Value("${linux.user.name}")
	private String username;

	@Value("${linux.folder.path}")
	private String folderPath;

	@Value("${linux.WinSCPTool.Path}")
	private String winSCPPath;

	public WiniumDriver getWiniumDriver() {
		return winiumDriver;
	}

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
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			activateMcps();
			captureSaveScreenShot(methodName);
			winiumClickOperation("1240/200 First Presentment");
			captureSaveScreenShot(methodName);
			winiumClickOperation("Add a field to the current message");
			captureSaveScreenShot(methodName);
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
			captureSaveScreenShot(methodName);
			activateEditField();
			winiumClickOperation("Add/Remove");
			wait(2000);
			captureSaveScreenShot(methodName);
			searchForImageAndPerformDoubleClick(MESSAGE_REVERSAL_INDICATOR);
			wait(3000);
			captureSaveScreenShot(methodName);
			executeAutoITExe("ActivateEditSubfieldValueScreen.exe");
			captureSaveScreenShot(methodName);
			winiumClickOperation("Central Site Processing Date Of Original Message");
			captureSaveScreenShot(methodName);
			winiumDriver.findElementByName("Edit Subfield Value - Format: n(6) [YYMMDD] ").sendKeys("");
			wait(2000);
			pressTab();
			captureSaveScreenShot(methodName);
			setText("");
			setText(DateUtils.currentDateYYMMDD());
			wait(2000);
			captureSaveScreenShot(methodName);
			executeAutoITExe("ActivateEditSubfieldAndClickOK.exe");
			wait(2000);
			captureSaveScreenShot(methodName);
			winiumClickOperation(SET_VALUE);
			captureSaveScreenShot(methodName);
			winiumClickOperation(CLOSE);
			captureSaveScreenShot(methodName);
			winiumClickOperation("Save");
			captureSaveScreenShot(methodName);
			winiumClickOperation("OK");
			wait(2000);
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	private void captureSaveScreenShot(String methodName) {
		SimulatorUtilities.takeScreenShot(winiumDriver, methodName + "_" + new SimpleDateFormat("dd-MMM-yyyy-hh.mm.ss-aaa").format(new Timestamp(System.currentTimeMillis())));
	}

	public void performOptimizedMasTransaction(String transaction, Transaction transactionData, Boolean sameCard) {
		handleDialogs();
		addBinRangeAndCurrencyDetailsBasedOnCardNumber(transactionData, transaction, sameCard);
		if (!sameCard) {
			importAndLoadCardProfile(transactionData.getCardProfile(), transaction);
			if (isContains(transaction, "emv")) {
				activateMas(transaction);
				performClickOperationOnImages("AUTOMATION CARD");
				performRightClickOperation("AUTOMATION CARD_Selected");
				wait(1000);
				performClickOperation("Edit Node");
				wait(4000);
				fillEmvChipKeySetDetails();
			}
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
		launchRequiredSimulatorSession(simulator); // to fetch required Simulator installed on the machine or read value from WhichSimulatorVersionToChoose.java
		closeSimulator(simulator);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			startWiniumDriverWithSimulator(simulator);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}

		if (simulator.toUpperCase().contains("FINSIM")) {
			launchAndConnectToFinSim();
		} else if (simulator.toUpperCase().contains("MAS")) {
			captureSaveScreenShot(methodName);
			selectLicenseAndConfigure(SimulatorConstantsData.SELECT_MAS_LICENSE, SimulatorConstantsData.MAS_LICENSE_TYPE);
			wait(4000);
			connect2IPSHostModeAndConfigureIP("MAS");
			captureSaveScreenShot(methodName);
			selectLicenseAndConfigure(SimulatorConstantsData.SELECT_MAS_LICENSE, SimulatorConstantsData.MAS_LICENSE_TYPE);
		} else if (simulator.toUpperCase().contains("MCPS")) {
			launchAndConnectToMCPS();
		} else if (simulator.toUpperCase().contains("MDFS")) {
			browserMinimize();
			selectLicenseAndConfigure(SimulatorConstantsData.SELECT_MDFS_LICENSE, SimulatorConstantsData.MDFS_LICENSE_TYPE);
			wait(4000);
			connect2IPSHostModeAndConfigureIPOnMdfs();
		} else if (simulator.toUpperCase().contains("VISA")) {
			connectAndStartVtsCommunication();
		}
		captureSaveScreenShot(methodName);
	}

	public void startWiniumDriverWithSimulator(String serviceName) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			DesktopOptions options = launchSimulator(serviceName);
			String path = getResourceFolderPath() + SimulatorConstantsData.WINIUM_DRIVER_EXE_PATH.replace("\\", "\\\\");
			Runtime.getRuntime().exec(path, null, new File(path.replace("Winium.Desktop.Driver.exe", "")));
			wait(3000);
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			captureSaveScreenShot(methodName);
			wait(8000);
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.debug("Exception occurred while starting Winium", e);
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
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
		} else if (serviceName.toUpperCase().contains("VISA")) {
			option = launchVISA();
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

	private DesktopOptions launchVISA() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + SimulatorConstantsData.VISA_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.VISA_EXE_PATH);
		return options;
	}

	public void importAndLoadTestCase(String filePath, String transaction) {
		MiscUtils.reportToConsole("******************** importAndLoadTestCase Started ******************");
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
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		executeAutoITExe("ImportCardProfile.exe " + filePath);
		captureSaveScreenShot(methodName);
	}

	private void selectTestCaseFromImportedCases(String testcaseName) {
		MiscUtils.reportToConsole("******************** selectTestCaseFromImportedCases Started ******************");
		MiscUtils.reportToConsole("******************** TRANSACTION to SELECT : " + testcaseName + " ******************");
		scrollUpToSelectTest(testcaseName);
		winiumClickOperation(TEST_CASES);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		pressTab();
		pressRightArrow(2);
		performClickOperationOnImages(ISSUER_TEST);
		captureSaveScreenShot(methodName);
		pressLeftArrow();
		performClickOperation("Imported");
		captureSaveScreenShot(methodName);
		pressRightArrow(4);
		pressPageDown();
		captureSaveScreenShot(methodName);
	}

	private void performExecution(String transaction) {
		MiscUtils.reportToConsole("******************** performExecution Started ******************");
		clickTestMonitor(transaction);
		wait(3000);
		selectTestCaseFromImportedCases(transaction);
		activateMas(transaction);
		winiumClickOperation(TEST_CASES);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		performDoubleClickOperation("RunTest");
		wait(5000);
		captureSaveScreenShot(methodName);
		activateMas(transaction);
		winiumClickOperation("OK");
		captureSaveScreenShot(methodName);

	}

	public String verifyResults() {
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResults("MAS");
		wait(8000);
		winiumClickOperation("Sequential View");
		scrollUpToSelectTestResults("MAS");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		pressPageDown(4);
		captureSaveScreenShot(methodName);
		return getResult();
	}

	public String verifyResultsOnMdfs() {
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResultsOnMdfs();
		wait(8000);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		winiumClickOperation("Sequential View");
		scrollUpToSelectTestResultsOnMdfs();
		captureSaveScreenShot(methodName);
		pressPageDown(2);
		captureSaveScreenShot(methodName);
		return getResult();
	}

	private String getResult() {
		List<WebElement> lst = winiumDriver.findElements(By.xpath("//*[contains(@Name, 'Expected Results Summary')]"));
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
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		wait(5000);
		try {
			wait(2000);
			executeAutoITExe("ActivateMCPSImportSuccessMessageDialog.exe");
			captureSaveScreenShot(methodName);
			handleDialogs();
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS :: {}", e);
			captureSaveScreenShot(methodName);
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
		activateMcps();
		Actions action = new Actions(winiumDriver);
		winiumDriver.findElementByName("TDG").click();
		action.moveToElement(winiumDriver.findElementByName("toolStripSplitButton1")).moveByOffset(10, 0).click().build().perform();
		action.moveToElement(winiumDriver.findElementByName("toolStripSplitButton1")).moveByOffset(10, 16).click().build().perform();
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		executeAutoITExe("LoadAuthFile.exe " + fileName);
		captureSaveScreenShot(methodName);
		loadFile(fileName);
	}

	private void clickMiddlePresentmentAndMessageTypeIndicator() {
		clickMiddlePresentment();
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	private void clickMiddlePresentment() {
		performClickOperationOnImages(MIDDLE_PRESENTMENT);
	}

	private String editFieldsAndProcess() {
		Actions action = new Actions(winiumDriver);
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
			winiumClickOperation(CLOSE);
			aRN = addAcquirerReferenceData(trimmedRrn);
			MiscUtils.reportToConsole("rRN :  trimmedRrn : aRN  -  " + rRN + " : - : " + trimmedRrn + " : - :" + aRN);
			updatePanNumber(SimulatorConstantsData.SAMPLE_PAN_NUMBER);
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
			pressPageUp();
			clickMiddlePresentmentAndMessageTypeIndicator();
			action.moveToElement(winiumDriver.findElementByName("033 - Forwarding Institution Identification Code")).doubleClick().build().perform();
			activateEditField();
			winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			setText("");
			setText("999684");
			wait(2000);
			winiumClickOperation(SET_VALUE);
			wait(2000);
			winiumClickOperation(CLOSE);
			wait(1000);
			updateAuthCode();
			wait(1000);
			addField();
			loadIpmFile(getIpmFileName());
			Device device = context.get(ContextConstants.DEVICE);
			updatePanNumber(device.getDeviceNumber());
			updateAmountCardHolderBilling();
			updateBillingCurrencyCode();
			assignUniqueFileId();
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields :: {}", e);
			throw MiscUtils.propagate(e);
		}
		return aRN;
	}

	private void updateAuthCode() throws AWTException {
		activateMcps();
		Actions action = new Actions(winiumDriver);
		String authCode = "" + context.get(ConstantData.AUTHORIZATION_CODE);
		clickMiddlePresentmentAndMessageTypeIndicator();
		action.moveToElement(winiumDriver.findElementByName("038 - Approval Code")).doubleClick().build().perform();
		activateEditField();
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText(authCode.toString());
		wait(2000);
		winiumClickOperation(SET_VALUE);
		wait(2000);
		winiumClickOperation(CLOSE);
	}

	private void updateBillingCurrencyCode() throws AWTException {
		Actions action = new Actions(winiumDriver);
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		pressPageDown();
		pressPageDown();
		action.moveToElement(winiumDriver.findElementByName("051 - Currency Code, Cardholder Billing")).doubleClick().build().perform();
		activateEditField();
		wait(2000);
		winiumDriver.findElementByName(SELECT_DE_VALUE).click();
		wait(2000);
		winiumDriver.findElementByName(BILLING_CURRENCY_VALUE).click();
		winiumClickOperation(SET_VALUE);
		wait(2000);
		winiumClickOperation(CLOSE);
	}

	private void updateAmountCardHolderBilling() throws AWTException {
		String amount = "" + getTransactionAmount();
		Actions action = new Actions(winiumDriver);
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		action.moveToElement(winiumDriver.findElementByName("006 - Amount, Cardholder Billing")).doubleClick().build().perform();
		activateEditField();
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText(amount.toString());
		wait(2000);
		winiumClickOperation(SET_VALUE);
		wait(2000);
		winiumClickOperation(CLOSE);
	}

	private String getTransactionAmount() throws AWTException {
		Actions action = new Actions(winiumDriver);
		String amount;
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		action.moveToElement(winiumDriver.findElementByName("004 - Amount, Transaction")).doubleClick().build().perform();
		activateEditField();
		amount = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		winiumClickOperation(CLOSE);
		return amount.toString();
	}

	private void updatePanNumber(String cardNumber) throws AWTException {
		Actions action = new Actions(winiumDriver);
		activateMcps();
		clickMiddlePresentmentAndMessageTypeIndicator();
		action.moveToElement(winiumDriver.findElementByName("002 - Primary Account Number (PAN)")).doubleClick().build().perform();
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText(cardNumber);
		wait(2000);
		winiumClickOperation(SET_VALUE);
		wait(2000);
		winiumClickOperation(CLOSE);
	}

	public String assignUniqueARN() {
		Actions action = new Actions(winiumDriver);
		String rRN = MiscUtils.generateRandomNumberAsString(12);
		String arnNumber = "";
		try {
			wait(2000);
			activateMcps();
			clickMiddlePresentmentAndMessageTypeIndicator();
			action.moveToElement(winiumDriver.findElementByName("037 - Retrieval Reference Number")).doubleClick().build().perform();
			wait(2000);
			activateEditField();
			wait(2000);
			setText("");
			setText(rRN);
			performClickOperation(SET_VALUE);
			winiumClickOperation(CLOSE);
			String trimmedRrn = rRN.substring(1, rRN.length());
			arnNumber = addAcquirerReferenceData(trimmedRrn);
			winiumClickOperation("Save");
			winiumClickOperation("OK");
		} catch (Exception e) {
			logger.debug("Exception occurred while editing fields :: {} ", e);
			throw MiscUtils.propagate(e);
		}
		return arnNumber;
	}

	private void activateEditField() {
		executeAutoITExe("ActivateEditFieldValueScreen.exe");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	private String addAcquirerReferenceData(String rRN) throws AWTException {
		Actions action = new Actions(winiumDriver);
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		pressPageUp();
		clickMiddlePresentment();
		action.moveToElement(winiumDriver.findElementByName("031 - Acquirer Reference Data")).doubleClick().build().perform();
		executeAutoITExe("ActivateEditSubfieldValueScreen.exe");
		winiumClickOperation("Acquirer's Sequence Number");
		wait(2000);
		pressTab();
		setText("");
		setText(rRN);
		winiumClickOperation(OK);
		wait(2000);
		winiumClickOperation(SET_VALUE);
		String aRN = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		wait(2000);
		winiumClickOperation(CLOSE);
		return aRN;
	}

	private void addField() throws AWTException {
		activateMcps();
		Actions action = new Actions(winiumDriver);
		winiumClickOperation("Add a field to the current message");
		wait(3000);
		pressPageDown();
		pressPageDown();
		pressPageDown();
		action.moveToElement(winiumDriver.findElementByName("093 - Transaction Destination Institution ID Code")).doubleClick().build().perform();
		winiumClickOperation("Add/Remove");
		wait(2000);
		activateMcps();
		winiumClickOperation("001 - Bit Map, Secondary");
		wait(2000);
		pressPageDown();
		pressPageDown();
		action.moveToElement(winiumDriver.findElementByName("093 - Transaction Destination Institution ID Code")).doubleClick().build().perform();
		winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
		setText("");
		setText("999684");
		winiumClickOperation(SET_VALUE);
		wait(1000);
		winiumClickOperation(CLOSE);
		activateMcps();
		wait(2000);
		action.moveToElement(winiumDriver.findElementByName("toolStripSplitButton1")).moveByOffset(35, 0).click().build().perform();
		wait(1000);
		winiumClickOperation(OK);
		wait(2000);
		activateMcps();
		action.moveToElement(winiumDriver.findElementByName("Send File to CEE")).click().build().perform();
		wait(2000);
		action.moveToElement(winiumDriver.findElementByName("Process File(s)")).click().build().perform();
		wait(5000);
		executeAutoITExe("GetCEEData.exe");
	}

	private String getIpmFileName() throws IOException {
		String fileData = getFileData("CEEData.txt");
		String[] splitString = fileData.split("\\s+");
		logger.info("CEEData Text Data : {} ", splitString[5]);
		return splitString[5];
	}

	public void loadIpmFile(String fileName) {
		try {
			clickTDG();
			winiumClickOperation("toolStripSplitButton1"); // open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName);
			wait(5000);
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS :: {}", e);
			throw MiscUtils.propagate(e);
		}
	}

	public void loadDownloadedIpmFileAndProcess(String fileName) {
		try {
			activateMcps();
			clickTDG();
			winiumClickOperation("toolStripSplitButton1"); // open ipm file
			wait(2000);
			executeAutoITExe("ActivateOpenIPMFileScreen.exe " + fileName);
			wait(5000);
			winiumClickOperation("Send File to CEE");
			wait(2000);
			winiumClickOperation("Process File(s)");
			winiumClickOperation("OK");
		} catch (Exception e) {
			logger.debug("Exception occurred while loading file in MCPS :: {}", e);
			throw MiscUtils.propagate(e);
		}
	}

	public void assignUniqueFileId() throws AWTException {
		activateMcps();
		Actions action = new Actions(winiumDriver);
		String fileId = RandomStringUtils.randomNumeric(5);
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		winiumClickOperation("1644/697 File Header");
		fillFileId(fileId);
		winiumClickOperation("1644/695 File Trailer");
		fillFileId(fileId);
		activateMcps();
		action.moveToElement(winiumDriver.findElementByName("toolStripSplitButton1")).moveByOffset(35, 0).click().build().perform();
		wait(1000);
		winiumClickOperation("OK");
		wait(2000);
	}

	private void fillFileId(String value) throws AWTException {
		activateMcps();
		Actions action = new Actions(winiumDriver);
		action.moveToElement(winiumDriver.findElementByName("0105 - File ID")).doubleClick().build().perform();
		winiumClickOperation("File Sequence Number");
		wait(2000);
		pressTab();
		setText("");
		setText(value);
		winiumClickOperation("OK");
		wait(2000);
		winiumClickOperation(SET_VALUE);
		wait(2000);
		winiumClickOperation(CLOSE);
	}

	public void authFileGeneration() {
		try {
			generateAuthFileFromMas();
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			throw MiscUtils.propagate(e);
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
		winiumClickOperation("Sequential View");
		activateMas("MAS");
		performClickOperation("Generate Auth File");
		performClickOperation("Select Auth File");
		wait(5000);
		executeAutoITExe("ActivateImportAuthFileScreen.exe");
		winiumClickOperation(SAVE);
		wait(3000);
		setText(String.valueOf("AuthFileName"));
		winiumClickOperation("OK");
		pressEscape();
	}

	private void selectMCPSLicense() {
		wait(5000);
		executeAutoITExe("ActivateLicenseProfiles.exe");
		winiumLicenseSelectOperation("License profiles");
		winiumDriver.findElementByName("License profiles").click();
		winiumDriver.findElementByName("Select").click();
		wait(2000);
		if (winiumDriver.findElements(By.name("OK")).size() > 0) {
			winiumDriver.findElement(By.name("OK")).click();
		}
		wait(15000);
	}

	public void selectLicenseAndConfigure(String licenseTypeToSelect, String licenseFor) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			String licenseForSelection = null;
			if (licenseFor.toUpperCase().contains("MAS"))
				licenseForSelection = SimulatorConstantsData.MAS_LICENSE_TYPE;
			else if (licenseFor.toUpperCase().contains("MDFS"))
				licenseForSelection = SimulatorConstantsData.MDFS_LICENSE_TYPE;
			MiscUtils.reportToConsole("selectLicenseAndConfigure  : " + licenseForSelection);
			if (getCountOfLicenseScreen() == 0)
				wait(1000);
			executeAutoITExe("ActivateLicenseProfiles.exe");
			winiumLicenseSelectOperation(licenseTypeToSelect, licenseFor);
			winiumClickOperation("Select");
			wait(2000);
			if (winiumDriver.findElements(By.name("OK")).size() > 0) {
				winiumDriver.findElement(By.name("OK")).click();
			}
			wait(20000);
			executeAutoITExe("ActivateSelectServices.exe");
			captureSaveScreenShot(methodName);
			if (getLoadServicesScreen() > 0) {
				executeAutoITExe("ActivateSelectServices.exe");
				wait(2000);
				winiumClickOperation(licenseForSelection);
				captureSaveScreenShot(methodName);
				pressSpaceBar();
				winiumClickOperation("Load the services");
				captureSaveScreenShot(methodName);
			}
			wait(5000);
			while (getLoadingSimulatorWindowCount() > 0) {
				wait(500);
			}
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	public void connect2IPSHostModeAndConfigureIP(String tool) {
		try {
			connect2IpsHostTestMode(tool);
			configureTestOptionsHostAndIP(tool);
			reconnect2IpsHostTestMode(tool);
		} catch (FindFailed e) {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	public void connect2IPSHostModeAndConfigureIPOnMdfs() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			connect2IpsHostTestModeOnMdfs();
			captureSaveScreenShot(methodName);
			configureTestOptionsHostAndIPOnMdfs();
			captureSaveScreenShot(methodName);
			reconnect2IpsHostTestModeOnMdfs();
			captureSaveScreenShot(methodName);
		} catch (FindFailed e) {
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	private void reconnect2IpsHostTestMode(String tool) {
		clickTestMode(tool);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		reSelectLicense(tool);
		wait(10000);
		captureSaveScreenShot(methodName);
		while (getWindowButtonCount() > 0) {
			winiumClickOperation("OK");
			captureSaveScreenShot(methodName);
			selectLicense(tool);
			wait(5000);
			captureSaveScreenShot(methodName);
		}
	}

	private void reconnect2IpsHostTestModeOnMdfs() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		clickTestModeOnMdfs();
		captureSaveScreenShot(methodName);
		reSelectLicenseOnMdfs();
		wait(10000);
		captureSaveScreenShot(methodName);
		while (getWindowButtonCount() > 0) {
			winiumClickOperation("OK");
			selectLicense("MDFS");
			wait(5000);
		}
	}

	private void connect2IpsHostTestMode(String tool) throws FindFailed {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		wait(5000);
		clickTestMode(tool);
		captureSaveScreenShot(methodName);
		selectLicense(tool);
		wait(15000);
		captureSaveScreenShot(methodName);
		waitForExepectedCondition("CONNECTED");
		wait(15000);
		captureSaveScreenShot(methodName);
	}

	private void connect2IpsHostTestModeOnMdfs() throws FindFailed {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		wait(5000);
		clickTestModeOnMdfs();
		captureSaveScreenShot(methodName);
		selectLicenseOnMdfs();
		wait(15000);
		captureSaveScreenShot(methodName);
		waitForExepectedCondition("CONNECTED");
		wait(15000);
		captureSaveScreenShot(methodName);
	}

	private void waitForExepectedCondition(String nameOfLocator) {
		WebDriverWait wait = new WebDriverWait(winiumDriver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameOfLocator)));
	}

	public void addBinRangeAndCurrencyDetailsBasedOnCardNumber(Transaction transactionData, String transaction, Boolean sameCard) {
		if (!sameCard) {
			if (!isContains(transaction, "mdfs")) {
				configureBinRangeForMas(transactionData);
			} else {
				configureBinRangeForMdfs(transactionData, transaction);
			}
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			captureSaveScreenShot(methodName);
		}
	}

	private void configureBinRangeForMdfs(Transaction transactionData, String transactionName) {
		String bin = transactionData.getCardNumber();
		String issuerCurrencyCode = transactionData.getIssuerCurrencyCode(); // value from DE element 49
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency(); // value from DE element 61_13
		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";
		try {
			clickTestOptions("MDFS");
			activateMas("MDFS");
			winiumClickOperation(BIN_TABLE);
			wait(1000);
			winiumClickOperation(BIN_TABLE);
			wait(2000);
			executeAutoITExe("ClickOnAddNew.exe");
			Boolean connectionEstablished = winiumDriver.findElement(By.name("Max Account Range")).isDisplayed();
			if (!connectionEstablished) {
				winiumClickOperation(BIN_TABLE);
				wait(2000);
				executeAutoITExe("ClickOnAddNew.exe");
			}
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
			pressTab();
			setText(issuerCurrencyCode);
			pressTab();
			setText(cardHolderBillingCurrency);
			executeAutoITExe(ADD_BIN_RANGE_MAKE_OK_VISIBLE);
			if ("MDFS_MSR_PIN_CHANGE".equalsIgnoreCase(transactionName)) {
				pressTab(); // pressing tab so that General tab is visible
				winiumClickOperation("M/Chip and PIN");
				wait(2000);
				winiumClickOperation("Yes");
				pressTab();
				wait(1000);
				pressTab();
			}

			winiumClickOperation("OK");
			wait(2000);
			if (isImagePresent("OK")) {
				performClickOperation("OK");
				wait(2000);
			}
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			throw MiscUtils.propagate(e);
		}
	}

	private void configureBinRangeForMas(Transaction transactionData) {
		String bin = transactionData.getCardNumber();
		String issuerCountryCode = transactionData.getIssuerCountryCode();
		String issuerCurrencyCode = transactionData.getIssuerCurrencyCode();
		String cardHolderBillingCurrency = transactionData.getCardHolderBillingCurrency();
		String binBinMinRange = bin.substring(0, 9) + "00";
		String binMaxBinRange = bin.substring(0, 9) + "99";
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			clickTestOptions("MAS");
			activateMas("MAS");
			winiumClickOperation(BIN_TABLE);
			captureSaveScreenShot(methodName);
			wait(1000);
			winiumClickOperation(BIN_TABLE);
			wait(2000);
			captureSaveScreenShot(methodName);
			performClickOperation("Add New");
			wait(10000);
			captureSaveScreenShot(methodName);
			executeAutoITExe(ADD_BIN_RANGE_SCROLL);
			captureSaveScreenShot(methodName);
			winiumClickOperation("General");
			pressTab();
			setText(binBinMinRange);
			pressTab();
			captureSaveScreenShot(methodName);
			setText(binMaxBinRange);
			wait(1000);
			pressTab();
			captureSaveScreenShot(methodName);
			wait(1000);
			pressTab();
			wait(1000);
			pressTab();
			wait(1000);
			setText(issuerCountryCode);
			pressTab();
			captureSaveScreenShot(methodName);
			setText(issuerCurrencyCode);
			pressTab();
			setText(cardHolderBillingCurrency);
			captureSaveScreenShot(methodName);
			executeAutoITExe(ADD_BIN_RANGE_MAKE_OK_VISIBLE);
			captureSaveScreenShot(methodName);
			winiumClickOperation("OK");
			wait(4000);
			if (isImagePresent("OK")) {
				performClickOperation("OK");
				wait(2000);
			}
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	private void fillEmvChipKeySetDetails() {
		if ("stagesa".equalsIgnoreCase(getEnv()))
			selectMChipKeySet("00998 - Example ETEC1 - 0213");
		else if ("automation".equalsIgnoreCase(getEnv()) || "demo".equalsIgnoreCase(getEnv()))
			if (SimulatorConstantsData.MAS_LICENSE_TYPE.contains("18") || SimulatorConstantsData.MAS_LICENSE_TYPE.contains("16"))
				selectMChipKeySet("00999 - Example ETEC1 - 0213");
			else
				selectMChipKeySet("00999 - Example - M/Chip  2.1 Select");
		else
			selectMChipKeySet("00999 - Example ETEC1 - 0213");
	}

	public void selectMChipKeySet(String valueToSelect) {
		executeAutoITExe("ActivateEditCardProfile.exe");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		winiumClickOperation("ICC Related Data");
		captureSaveScreenShot(methodName);
		winiumClickOperation("Drop Down Button");
		wait(2000);
		captureSaveScreenShot(methodName);
		winiumClickOperation(valueToSelect);
		wait(1000);
		captureSaveScreenShot(methodName);
		winiumClickOperation("OK");
		wait(1000);
		captureSaveScreenShot(methodName);
	}

	public String getEnv() {
		String env = System.getProperty("env").toString();
		logger.info("System.getProperty ENV :: {} ", env);
		return env;
	}

	private void fillCvvData(String cvvData) {
		String cvvDataValue = "000" + cvvData;
		executeAutoITExe("ActivateEditCardProfile.exe");
		winiumClickOperation("Track Data");
		winiumDriver.findElementByXPath("//*[contains(@AutomationId,'DEXXX_Field_DE035_05 ')]").sendKeys(cvvDataValue);
		wait(1000);
		winiumClickOperation("OK");
		wait(1000);
	}

	public void closeSimulator(String name) {
		if (winiumDriver != null) {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			captureSaveScreenShot(methodName);
		}
		winiumDriver = null;

		if (name.equalsIgnoreCase("MAS")) {
			if (SimulatorConstantsData.MAS_LICENSE_TYPE.contains(SIMULATOR_LICENSE_TYPE_18)) {
				name = "MAS18";
			} else if (SimulatorConstantsData.MAS_LICENSE_TYPE.contains(SIMULATOR_LICENSE_TYPE_17)) {
				name = "MAS17";
			}
		} else if (name.equalsIgnoreCase("MDFS")) {
			if (SimulatorConstantsData.MDFS_LICENSE_TYPE.contains(SIMULATOR_LICENSE_TYPE_18)) {
				name = "MDFS18";
			} else if (SimulatorConstantsData.MDFS_LICENSE_TYPE.contains(SIMULATOR_LICENSE_TYPE_17)) {
				name = "MDFS17";
			}
		}
		if ("visa".equalsIgnoreCase(name)) {
			disconnectAndCloseVts();
		}
		MiscUtils.killProcessFromTaskManager("WINIUM");
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			clickTestOptions(tool);
			captureSaveScreenShot(methodName);
			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");
			captureSaveScreenShot(methodName);
			setMasIp(ip);
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			captureSaveScreenShot(methodName);
			MiscUtils.propagate(e);
		}
	}

	private void setMasIp(String[] ip) {
		String parameters;
		parameters = "\"" + SimulatorConstantsData.MAS_PARENT_HANDLE + PATH_BUILDER + simulator.getPort() + PATH_BUILDER + getValue(ip[0]) + PATH_BUILDER + getValue(ip[1]) + PATH_BUILDER
				+ getValue(ip[2]) + PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
	}

	private void configureTestOptionsHostAndIPOnMdfs() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			clickTestOptionsOnMdfs();
			captureSaveScreenShot(methodName);
			String ipAdd = mdfsSimulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");
			winiumClickOperation("TCP/IP");
			wait(2000);
			winiumClickOperation("TCP/IP");
			captureSaveScreenShot(methodName);
			setMasIpOnMdfs(ip);
			captureSaveScreenShot(methodName);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			captureSaveScreenShot(methodName);
			throw MiscUtils.propagate(e);
		}
	}

	private void setMasIpOnMdfs(String[] ip) {
		String parameters;
		parameters = "\"" + SimulatorConstantsData.MDFS_PARENT_HANDLE + PATH_BUILDER + mdfsSimulator.getPort() + PATH_BUILDER + getValue(ip[0]) + PATH_BUILDER + getValue(ip[1]) + PATH_BUILDER
				+ getValue(ip[2]) + PATH_BUILDER + getValue(ip[3]) + "\"";
		setMasIpAddress(parameters);
	}

	private void setMasIpAddress(String parameter) {
		executeAutoITExe(SET_MAS_IP + parameter);
		MiscUtils.reportToConsole(" ******* Parameter for setMasIp : ******" + parameter);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
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
			String parameters = "\"" + finSimSimulator.getIpAddress() + PATH_BUILDER + finSimSimulator.getPort() + PATH_BUILDER + finSimSimulator.getPassword() + "\"";
			MiscUtils.reportToConsole(" ******* Parameter for connectToFinSim : ******" + parameters);
			executeAutoITExe("connectToFinSim.exe " + parameters);
			wait(5000);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			throw MiscUtils.propagate(e);
		}
	}

	public String getPinNumber(Transaction transactionData) {
		MiscUtils.reportToConsole("******** getPinNumber Start ***** ");
		try {
			wait(5000);
			String parameters = "\"" + transactionData.getCardNumber() + PATH_BUILDER + transactionData.getPinKey() + PATH_BUILDER + transactionData.getDecimalisationTable() + PATH_BUILDER
					+ transactionData.getValidationDataStart() + PATH_BUILDER + transactionData.getCardLength() + PATH_BUILDER + transactionData.getPad() + PATH_BUILDER
					+ transactionData.getOffSetForCard() + PATH_BUILDER + transactionData.getPinLength() + "\"";
			MiscUtils.reportToConsole(" ******* Parameter for SelectValuesFromPinOffsetCalculator : ******" + parameters);
			executeAutoITExe("SelectValuesFromPinOffsetCalculator.exe " + parameters);
			wait(10000);
			return getPinText();
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			return null;
		}
	}

	@SuppressWarnings("unused")
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

	public String searchTransactionWithDeviceAndGetStatus(Device device, TransactionSearch ts) {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithDeviceAndGetStatus(device, ts);
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

	private void winiumLicenseSelectOperation(String locator) {
		List<WebElement> lst = winiumDriver.findElements(By.name(locator));
		MiscUtils.reportToConsole("winiumLicenseSelectOperation Count : " + lst);
		lst.get(0).click();
	}

	private void winiumClickOperation(String locator) {
		logger.info(WINIUM_LOG_COMMENT, locator);
		winiumDriver.findElementByName(locator).click();
	}

	private void performClickCardProfiles(String tool) {
		activateMas(tool);
		winiumClickOperation("Card Profiles");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	public Boolean isContains(String incomingValue, String lookFor) {
		Boolean isContains = false;
		if (incomingValue.toLowerCase().contains(lookFor.toLowerCase()))
			isContains = true;
		return isContains;
	}

	private void selectLicense() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		WebElement dd = winiumDriver.findElementById("comboBox1");
		ComboBox box = new ComboBox(dd);
		box.expand();
		dd.findElement(By.name("IPS Host Testing")).click();
		captureSaveScreenShot(methodName);
	}

	private void selectLicense(String tool) {
		if (!isContains(tool, "mdfs"))
			selectLicense();
		else
			selectLicenseOnMdfs();
	}

	private void selectLicenseOnMdfs() {
		selectLicense();
	}

	private void reSelectLicense(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
		else
			reSelectLicenseOnMdfs();
	}

	private void reSelectLicenseOnMdfs() {
		executeAutoITExe(RESELECT_IPS_HOST_TESTMODE + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
	}

	private void scrollUpToSelectTest(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(SCROLL_UP_ON_TESTCASES + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			scrollUpToSelectTestOnMdfs();
	}

	private void scrollUpToSelectTestOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTCASES + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	private void scrollUpToSelectTestResults(String tool) {
		if (!isContains(tool, "mdfs"))
			executeAutoITExe(SCROLL_UP_ON_TESTRESULTS + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
		else
			scrollUpToSelectTestResultsOnMdfs();
	}

	private void scrollUpToSelectTestResultsOnMdfs() {
		executeAutoITExe(SCROLL_UP_ON_TESTRESULTS + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
	}

	private void handleDialogs() {
		executeAutoITExe("HandleUnhandlesDialogs.exe");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	private void activateMas(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(ACTIVATE_MAS + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			activateMdfs();
	}

	public void activateMdfs() {
		executeAutoITExe(ACTIVATE_MAS + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		wait(1000);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	private void activateMcps() {
		executeAutoITExe("ActivateMCPS.exe" + SEPERATOR + SimulatorConstantsData.MCPS_PARENT_HANDLE + "\"");
		wait(1000);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);

	}

	private void clickTDG() {
		executeAutoITExe("ClickTDG.exe" + SEPERATOR + SimulatorConstantsData.MCPS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	public void clickTestOptions(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(CLICK_TEST_OPTIONS + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			clickTestOptionsOnMdfs();
	}

	public void clickTestOptionsOnMdfs() {
		executeAutoITExe(CLICK_TEST_OPTIONS + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	public void clickTestMonitor(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(CLICK_TEST_MONITOR + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			clickTestMonitorOnMdfs();
	}

	public void clickTestMonitorOnMdfs() {
		executeAutoITExe(CLICK_TEST_MONITOR + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	public void clickTestMode(String tool) {
		if (!isContains(tool, "mdfs")) {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			captureSaveScreenShot(methodName);
			executeAutoITExe(CLICK_TEST_MODE + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			clickTestModeOnMdfs();
	}

	public void clickTestModeOnMdfs() {
		executeAutoITExe(CLICK_TEST_MODE + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
	}

	public void clickTestPreparations(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(CLICK_TEST_PREPARATION + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else {
			clickTestPreparationsOnMdfs();
			captureSaveScreenShot(methodName);
		}
	}

	public void clickTestPreparationsOnMdfs() {
		executeAutoITExe(CLICK_TEST_PREPARATION + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		wait(5000);
	}

	public void clickTestResults(String tool) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		if (!isContains(tool, "mdfs")) {
			executeAutoITExe(CLICK_TEST_RESULTS + SEPERATOR + SimulatorConstantsData.MAS_PARENT_HANDLE + "\"");
			captureSaveScreenShot(methodName);
		} else
			clickTestResultsOnMdfs();
	}

	public void clickTestResultsOnMdfs() {
		executeAutoITExe(CLICK_TEST_RESULTS + SEPERATOR + SimulatorConstantsData.MDFS_PARENT_HANDLE + "\"");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);

	}

	public void connectAndStartVtsCommunication() {
		browserMinimize();
		wait(5000);
		activateVts();
		WebElement visaTestSystemFrame = winiumDriver.findElement(By.xpath("*[starts-with(@Name, 'Visa Test System')]"));
		visaTestSystemFrame.click();
		winiumClickOperation("Start Communications");
		wait(2000);
		setVtsIpAddress();
		winiumClickOperation(VTS_COMM_HANDLER);
		winiumClickOperation("Start Line");
		Boolean connectionEstablished = winiumDriver.findElement(By.name("UP")).isDisplayed();
		if (connectionEstablished) {
			logger.info("VTS connection established succcessful!");
			assertTrue("VTS connection established succcessful!", true);
		} else {
			assertFalse("VTS connection is NOT succcessful!", false);
			throw new ValidationException("VTS connection is NOT succcessful!");
		}
		winiumClickOperation("Minimize"); // to minimize Communication handler
		wait(2000);
		winiumClickOperation("Maximize"); // to Maximize Visa Test System
	}

	private void loadVisaInputFile(String transaction) {
		String transactionName = visaTestCaseNameKeyValuePair.getVisaTestDataFileNameToUpload(transaction);
		String vtsInputFilePath = getResourceFolderPath().replace("\\\\", "\\") + SimulatorConstantsData.VISA_INPUT_FILE_PATH + transactionName + ".stf";
		logMessage("Loading Visa Input File ", vtsInputFilePath);
		WebElement visaTestSystemFrame = winiumDriver.findElement(By.xpath("*[starts-with(@Name, 'Visa Test System')]"));
		visaTestSystemFrame.click();
		winiumClickOperation("Open");
		wait(2000);
		executeAutoITExe("ImportVisaTestFile.exe " + vtsInputFilePath);
		wait(3000);
	}

	@SuppressWarnings("unused")
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
		wait(10000);
		executeAutoITExe("CloseVTS.exe");
	}

	private void setVtsIpAddress() {
		String parameter = "\"" + vtsSimulator.getVtsIpAddress() + PATH_BUILDER + vtsSimulator.getHostIpAddress() + PATH_BUILDER + vtsSimulator.getHostPort() + "\"";
		executeAutoITExe(SET_VTS_IP + parameter);
		logMessage(" ******* Parameter for setVtsIpAddress : ******", parameter);
	}

	public void performVisaTransaction(String transaction) {
		String transactionName = visaTestCaseNameKeyValuePair.getVisaTestCaseToSelect(transaction);
		logMessage("VISA Transaction Test Case Name : ", transactionName);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		loadVisaInputFile(transaction);
		captureSaveScreenShot(methodName);
		setValuesInExcelTemplateBasedOnDeviceContext();
		loadVisaTestGroupTemplate();
		captureSaveScreenShot(methodName);
		selectVisaTestCaseToMakeDataElementChange(transactionName);
		Device device = context.get(ContextConstants.DEVICE);
		if (transaction.toLowerCase().contains("pin"))
			setValueInMessageEditorForTransction("F52", transactionName, device.getPinNumberForTransaction());
		captureSaveScreenShot(methodName);
		executeVisaTest(transactionName);
	}

	private void setValueInMessageEditorForTransction(String key, String element, String value) {
		winiumClickOperation(element);
		pressEnter();
		pressDownArrow(2);
		executeAutoITExe("OpenMessageEditor.exe");
		winiumClickOperation("F2");
		pressPageDown();
		editFeildValues(key, value);
		logger.info("Values modfied in Mesagge editor : Key/value {} :", key + " / " + value);
	}

	private void navigateToVariableManagerAndLoadTestGroupTemplate() {
		executeAutoITExe("VtsVariableManagerLaunch.exe");
		if (!winiumDriver.findElementByName("Close Database").isEnabled())
			winiumClickOperation("Open Most Recent Database");
		wait(5000);
		executeAutoITExe("vtsVariableManagerLoadExcelTestDataFile.exe" + SEPERATOR + vtsTestGroupInputFilePath + "\"");
		executeAutoITExe("VTSHandleVariablesManager.exe");
	}

	private void loadVisaTestGroupTemplate() {
		navigateToVariableManagerAndLoadTestGroupTemplate();
	}

	private void selectVisaTestCaseToMakeDataElementChange(String transaction) {
		MiscUtils.reportToConsole(" ******* selectVisaTestCaseToMakeDataElementChange ******");
		activateVts();
		winiumClickOperation(transaction);
		pressEnter();
		pressDownArrow(1); // to select Properties
		executeAutoITExe("VtsSetDefaultAutoamtionCardInProperties.exe");
	}

	private void editFeildValues(String fieldNumber, String value) {
		String parameter = "\"" + value + PATH_BUILDER + "\"";
		winiumClickOperation(fieldNumber);
		wait(2000);
		executeAutoITExe("SetValueInVisaMessageEditor.exe " + parameter);
	}

	private String getFeildDescriptionFromLogViewer(String propertyByName) {
		String resultResponse;
		String cardNumberOutput;
		String rRnOutput;
		String f39output;
		Device device = context.get(ContextConstants.DEVICE);
		MiscUtils.reportToConsole(" ******* getFeildDescriptionFromLogViewer ******");
		executeAutoITExe("VtsManageLogViewer.exe");
		if (winiumDriver.findElement(By.name(propertyByName)).isDisplayed()) {
			winiumClickOperation(propertyByName);
		} else {
			winiumClickOperation("F2");
			pressPageDown(2); // scrolling down to the end of the page
			winiumClickOperation(propertyByName);
		}
		cardNumberOutput = getDataForVisaTransaction("F2");
		logMessage("**********  Card Number for Visa Transaction ********** ", cardNumberOutput);
		if (!cardNumberOutput.equalsIgnoreCase(device.getDeviceNumber().trim())) {
			logger.error("Card Number not updated in Visa Variable Manager. Please verify.");
			return "validations not ok";
		}
		rRnOutput = getDataForVisaTransaction("F37");
		logMessage("**********  RRN Number for Visa Transaction ********** ", rRnOutput);
		f39output = getDataForVisaTransaction("F39");
		logMessage("**********  Output Response from F39 for Visa Transaction ********** ", f39output);
		if ("00".equalsIgnoreCase(f39output.trim()))
			resultResponse = "validations is ok. And value shown in the F39 response is : " + f39output;
		else
			resultResponse = "validations not ok. And value shown in the F39 response is : " + f39output;
		logMessage("Visa Output Response Set to : ", resultResponse);
		return resultResponse;
	}

	private String getDataForVisaTransaction(String propertyByName) {
		String tempValue;
		winiumClickOperation(propertyByName);
		List<WebElement> result = winiumDriver.findElement(By.name(propertyByName)).findElements(By.xpath("./*[contains(@LocalizedControlType, 'text')]"));
		for (WebElement e : result) {
			MiscUtils.reportToConsole(e.getAttribute("Name"));
		}
		tempValue = result.get(result.size() - 1).getAttribute("Name");
		logMessage(" ********* " + propertyByName + " :  response is : ", tempValue);
		return tempValue;
	}

	public void executeVisaTest(String transaction) {
		MiscUtils.reportToConsole(" ******* executeVisaTest ******");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		captureSaveScreenShot(methodName);
		deleteOldLogs();
		captureSaveScreenShot(methodName);
		winiumClickOperation(transaction);
		captureSaveScreenShot(methodName);
		pressEnter();
		captureSaveScreenShot(methodName);
		winiumClickOperation("Execute Test");
		wait(5000);
		captureSaveScreenShot(methodName);
		executeAutoITExe("visaTestExeution.exe");
		captureSaveScreenShot(methodName);
	}

	public String verifyVisaOutput(String transaction) {
		String results;
		MiscUtils.reportToConsole(" ******* verifyVisaOutput ******");
		winiumClickOperation(transaction);
		pressEnter();
		winiumClickOperation("View Detail Log");
		wait(9000);
		winiumClickOperation(RESULT_IDENTIFIER);
		wait(1000);
		winiumClickOperation(RESULT_IDENTIFIER);
		wait(1000);
		winiumClickOperation(RESULT_IDENTIFIER);
		Actions action = new Actions(winiumDriver);
		List<WebElement> lst = winiumDriver.findElements(By.name("0110 ISO Message, INCOMING. Match found"));
		if (lst.isEmpty()) {
			logMessage(VISA_FAILURE_MESSAGE, "");
			return VISA_FAILURE_MESSAGE;
		}
		lst.get(0).click();
		action.doubleClick(lst.get(0)).perform();
		winiumClickOperation("Maximize");
		results = getVisaResult();
		browserMaximize();
		return results;
	}

	private void deleteOldLogs() {
		executeAutoITExe("vtsDeleteOlderLogViewerLogs.exe");
		executeAutoITExe("vtsCloseLogViewer.exe");
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
		if (!simulatorVersion.getMasVersion().toUpperCase().contains("LATEST")) {
			MasDetailsKeyValuePair.getSpecificMasVersionDetails(simulatorVersion.getMasVersion());
		} else
			MasDetailsKeyValuePair.getLatestVersionMasDetailsInstalledOnMachine();
	}

	private void getMdfsDetails() {
		MdfsDetailsKeyValuePair.initializeMdfsData();
		if (!simulatorVersion.getMdfsVersion().toUpperCase().contains("LATEST")) {
			MdfsDetailsKeyValuePair.getSpecificMdfsVersionDetails(simulatorVersion.getMdfsVersion());
		} else
			MdfsDetailsKeyValuePair.getLatestVersionMdfsDetailsInstalledOnMachine();
	}

	private void launchRequiredSimulatorSession(String simulator) {
		if (simulator.toUpperCase().contains("MAS")) {
			getMasDetails();
		} else if (simulator.toUpperCase().contains("MDFS"))
			getMdfsDetails();
	}

	private void setValuesInExcelTemplateBasedOnDeviceContext() {
		Device device = context.get(ContextConstants.DEVICE);
		SimulatorUtilities sm = new SimulatorUtilities();
		String sheetName = "Card Groups";
		if (device != null) {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setServiceCode(devicePlan.getServiceCode());
			if ("YES".equalsIgnoreCase(devicePlan.getIsPinLess())) {
				device.setExpirationDate(devicePlan.getExpiryDate());
				device.setPinNumberForTransaction("PINLESS");
			}
			if ("Fixed [F]".equalsIgnoreCase(devicePlan.getExpiryFlag()))
				device.setExpirationDate(devicePlan.getExpiryDate());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F002 - PAN", device.getDeviceNumber());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F014 - EXPDATE", device.getExpirationDate());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F023 - CARD SEQ NUM", device.getSequenceNumber());
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F035.04 - SVCCODE", device.getServiceCode());
			String track1Data = device.getDeviceNumber() + "^CARD 1/VISA TEST^22121011499100129000000";
			sm.setCellData(vtsTestGroupInputFilePath, sheetName, "F045 - TRACK1 DATA", track1Data);
		}
	}

	private void logMessage(String message1, String message2) {
		logger.info(message1, message2);
		MiscUtils.reportToConsole(message1 + message2);
	}

	public String getARN(String deviceNumber, TransactionSearch ts) {
		TransactionSearchPage page = navigator.navigateToPage(TransactionSearchPage.class);
		return page.searchTransactionWithDevice(deviceNumber, ts);
	}

	private DesktopOptions setWinSCPAsApplication() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT + winSCPPath);
		options.setApplicationPath(winSCPPath);
		return options;
	}

	private void startWiniumDriverWithApplication(DesktopOptions options) {
		MiscUtils.killProcessFromTaskManager("WINIUM");
		try {
			String path = getResourceFolderPath() + SimulatorConstantsData.WINIUM_DRIVER_EXE_PATH.replace("\\", "\\\\");
			Runtime.getRuntime().exec(path, null, new File(path.replace("Winium.Desktop.Driver.exe", "")));
			wait(3000);
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			wait(8000);
		} catch (Exception e) {
			logger.debug("Exception occurred while starting Winium", e);
			MiscUtils.propagate(e);
		}
	}

	public void launchWinSCP() {
		browserMinimize();
		startWiniumDriverWithApplication(setWinSCPAsApplication());
	}

	public void loginToWinSCP() {
		try {
			winiumClickOperation("Session");
			wait(2000);
			pressTab();
			pressTab();
			pressTab();
			setText(hostName);
			pressTab();
			setText(number);
			pressTab();
			setText(username);
			pressTab();
			setText(linuxbox.getPassword());
			winiumClickOperation("Login");
			logger.info("User Logged Into WinSCP Application");
		} catch (AWTException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void setFolderPermisson(String fName) {
		try {
			String folderName = (folderPath + fName).substring((folderPath + fName).lastIndexOf("/") + 1);
			Actions action = new Actions(winiumDriver);
			wait(20000);
			action.moveToElement(winiumDriver.findElement(By.name("Rights"))).moveByOffset(0, -30).doubleClick().build().perform();
			wait(3000);
			setText((folderPath + fName).replace(folderName, "")); // Folder Path
			wait(2000);
			winiumClickOperation("OK");
			wait(2000);
			winiumClickOperation(folderName); // Folder Name
			pressF9Key();
			wait(3000);
			action.moveToElement(winiumDriver.findElement(By.name("Cancel"))).moveByOffset(0, -30).click().build().perform();
			wait(3000);
			action.moveToElement(winiumDriver.findElement(By.name("Cancel"))).moveByOffset(-20, -90).doubleClick().build().perform();
			setText("0777");
			wait(3000);
			winiumClickOperation("OK");
		} catch (AWTException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void closeWinSCP() {
		winiumClickOperation("Close");
		wait(2000);
		winiumClickOperation("OK");

	}
}