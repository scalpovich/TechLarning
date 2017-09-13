package com.mastercard.pts.integrated.issuing.workflows.customer.transaction;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private static final String EDIT_DE_VALUE = "Edit DE Value";
	private static final String SET_VALUE = "Set Value";
	private static final String CLOSE = "Close";
	private static final String MESSAGE_TYPE_INDICATOR = "Message Type Indicator";
	private static final String MIDDLE_PRESENTMENT = "Middle Presentment";
	private static final String PATH_BUILDER =  "\" \"";
	private static final String ISSUER_TEST = 	"IssuerTest";

	@Autowired
	private MasSimulator simulator;

	@Autowired
	private FinSimSimulator finSimSimulator;

	@Autowired
	private Navigator navigator;

	private WiniumDriver winiumDriver;

	@Autowired
	private TestContext context;

	public void performOptimizedMasTransaction(String transaction, Transaction transactionData)
	{
		handleDialogs();

		addBinRangeAndCurrencyDetailsBasedOnCardNumber(transactionData);

		importAndLoadCardProfile(transactionData.getCardProfile());
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

	public Boolean verifyTestResults()
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
			selectMASLicenseAndConfigure("Credit - Professional");
			connect2IPSHostModeAndConfigureIP(); 	

			//clicking click Test Preparation
			clickTestPreparations();
			performClickTestCases();

			//clicking click Test Monitor
			clickTestMonitor();
			performClickTestCases();

		} else if(simulator.toUpperCase().contains("MCPS")) {
			launchAndConnectToMCPS();
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
			wait(3000);
			MiscUtils.reportToConsole("************" + serviceName + " started******************");
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

	private DesktopOptions launchExpressMap() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + SimulatorConstantsData.EXPRESSMAP_EXE_PATH);
		options.setApplicationPath(SimulatorConstantsData.EXPRESSMAP_EXE_PATH);
		return options;
	}

	public void importAndLoadTestCase(String filePath, String transaction)
	{
		MiscUtils.reportToConsole("******************** importAndLoadTestCase Started ******************");
		//navigating to "Test Preparation" section
		clickTestPreparations();
		importTestCaseFile(filePath);
		handleDialogs();
		
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
		handleDialogs();
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
		performDoubleClickOperation("ClearResults");
		wait(3000);
		executeAutoITExe("HandleClearTestResultsWindow.exe");
		pressEnter();
		activateMas();
		performDoubleClickOperation("RunTest");
		wait(5000);
		executeAutoITExe("ActivateStartTestDialogAndClose.exe");
	}

	private void activateMas()
	{
		executeAutoITExe("ActivateMAS.exe");
		wait(1000);
	}

	private void activateMcps()
	{
		executeAutoITExe("ActivateMCPS");
	}

	private void clickTDG()
	{
		executeAutoITExe("ClickTDG");
	}

	private Boolean verifyResults()
	{
		MiscUtils.reportToConsole("******************** verifyResults Started ******************");
		clickTestResults();
		wait(8000);

		winiumDriver.findElementByName("Sequential View").click();
		
		if(areImagesPresent("0110_NTW to APS Rcvd"))
		{
			performDoubleClickOperationOnImages("0110_NTW to APS Rcvd");
			wait(2000);
			if(areImagesPresent("0110_Response_Approved"))
			{
				performClickOperationOnImages("0110_Response_Approved");
				return true;
			}
		}
		return false;
	}

	public String loadAuthFileToMCPS(String fullFileNameAndPath) {
		loadAuthFileIntoMCPS(fullFileNameAndPath);
		return editFieldsAndProcess();
	}

	public void loadFile(String fileName) {
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

	public void loadIPMFileIntoMCPS(String fileName)
	{
		clickTDG();
		performClickOperation("folder");
		executeAutoITExe("ActivateOpenExistingFileScreen");
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

	private String editFieldsAndProcess(){
		String aRN = "";
		try{
			wait(2000);
			activateMcps();
			performClickOperation(MIDDLE_PRESENTMENT);
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
			searchForImageAndPerformDoubleClick("Retrieval Reference Number");
			wait(2000);
			activateEditField();
			String rRN = winiumDriver.findElementByName(EDIT_DE_VALUE).getText();
			String trimmedRrn = rRN.substring(1, rRN.length());
			winiumDriver.findElementByName(CLOSE).click();

			aRN = addAcquirerReferenceData(trimmedRrn);

			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
			pressPageUp();
			performClickOperation(MIDDLE_PRESENTMENT);
			performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
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

	private void activateEditField()
	{
		executeAutoITExe("ActivateEditFieldValueScreen");
	}

	private String addAcquirerReferenceData(String rRN) throws AWTException {
		performClickOperation(MESSAGE_TYPE_INDICATOR); // selecting the table
		pressPageUp();
		performClickOperation(MIDDLE_PRESENTMENT);
		searchForImageAndPerformDoubleClick("Acquirer Reference Data");
		executeAutoITExe("ActivateEditSubfieldValueScreen");
		performClickOperation("Acquirer Sequence Number");
		wait(2000);
		pressTab(1);
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
		executeAutoITExe("GetCEEData");
	}

	private String getIpmFileName() throws IOException{
		String fileData = getFileData("CEEData.txt");
		String [] splitString = fileData.split("\\s+");
		return splitString[5];	
	}

	private void loadIpmFile(String fileName) {
		clickTDG();
		performClickOperation("folder"); //open ipm file
		executeAutoITExe("ActivateOpenIPMFileScreen");
		loadFile(fileName);		
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

		performClickOperation("Generate Auth File");
		performClickOperation("Select Auth File");
		wait(5000);
		executeAutoITExe("ActivateImportAuthFileScreen");
		setText(String.valueOf("AuthFileName"));
		pressTab(2);
		pressEnter();
		wait(3000);
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
			performDoubleClickOperationOnImages(licenseTypeToSelect);
			wait(15000);

			if(getLoadServicesScreen() > 0)	{
				executeAutoITExe("ActivateSelectServices");
				wait(2000);
//				performClickOperation("MAS 16.4");
				winiumClickOperation("MAS 16.4");
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

	private void selectIpsModeWithWinium() {
		winiumDriver.findElementByName("Select Test Mode").findElement(By.xpath(("//*[contains(@AutomationId,'comboBox1')]"))).click();
		winiumDriver.findElementByName("Select Test Mode").findElement(By.name("IPS Host Testing")).click();
		wait(20000);
	}
	
	private void reSelectIpsModeWithWinium() {
		winiumDriver.findElementByName("Select Test Mode").findElement(By.xpath(("//*[contains(@AutomationId,'comboBox1')]"))).click();
		winiumDriver.findElementByName("Select Test Mode").findElement(By.name("Select Test Mode")).click();
		wait(5000);
		winiumDriver.findElementByName("Select Test Mode").findElement(By.name("IPS Host Testing")).click();
		wait(20000);
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

	private void connect2IpsHostTestMode() throws FindFailed {
		wait(5000);
		executeAutoITExe("ClickTestMode.exe");
		selectLicense();
		wait(15000);
		waitForImageToAppear("CONNECTED");
		wait(15000);
	}

	public void clickTestOptions()
	{
		executeAutoITExe("ClickTestOptions.exe");
	}

	public void clickTestMonitor()
	{
		executeAutoITExe("ClickTestMonitor.exe");
	}

	public void clickTestMode()
	{
		executeAutoITExe("ClickTestMode.exe");
	}

	public void clickTestPreparations()
	{
		executeAutoITExe("ClickTestPreparation.exe");
		wait(5000);
	}

	public void clickTestResults()
	{
		executeAutoITExe("ClickTestResults.exe");
	}

	public void addBinRangeAndCurrencyDetailsBasedOnCardNumber(Transaction transactionData)
	{
		configureBinRange(transactionData);
	}

	private void configureBinRange(Transaction transactionData)
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

	public void closeSimulator(String name) 
	{
		winiumDriver = null;
		MiscUtils.killProcessFromTaskManager(name);
	}

	private void configureTestOptionsHostAndIP()
	{
		try
		{
			clickTestOptions();

			String tempVariable;
			String ipAdd = simulator.getIpAddress();
			String[] ip = ipAdd.split("\\.");

			winiumClickOperation("TCP/IP");
			winiumClickOperation("Client");
			winiumSetTextOperation("Port :", simulator.getPort());
			pressTab();
			for (int i = 0; i<  ip.length; i++)
			{
				tempVariable = stringleftPadWith0(ip[i], 3);
				setText(tempVariable);
				wait(1000);
			}
			pressTab();
			winiumClickOperation("Apply");
			wait(2000);
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
		logger.info(" *****  winiumClick Operation is being performed :  "+ locator);
		activateMas();
		winiumDriver.findElementByName(locator).click();
	}

	private void winiumSetTextOperation(String locator, String text) {
		logger.info("***** winiumSetText Operation performed : locator/text : " + locator + " / " + text);
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
		executeAutoITExe("SelectIPSHostTestMode.exe");
	}

	private void reSelectLicense() {
		executeAutoITExe("ReSelectIPSHostTestMode.exe");
	}

	private void scrollUpToSelectTest() {
		executeAutoITExe("ActivateMASandScrollUpOnTestCases.exe");
	}
	
	private void handleDialogs() { 
		executeAutoITExe("HandleUnhandlesDialogs.exe");
	}
}