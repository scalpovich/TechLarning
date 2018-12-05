package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.BatchType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3PROCESS_BATCHES })
public class ProcessBatchesPage extends AbstractBasePage {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private DBUtility dbUtils;

	private static final Logger logger = LoggerFactory.getLogger(ProcessBatchesPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchType:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchId:input:dropdowncomponent")
	private MCWebElement batchNameDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:submitButton")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Rejected')]")
	private MCWebElement rejectBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class!='headers']//td[3]/span")
	private MCWebElement rejectDueToMandatory;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='productType']/select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:inputFiles:0:fileChecked:checkBoxComponent")
	private MCWebElement selectChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "td[class='displayName'] a span")
	private MCWebElement statusBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Status :']]/following-sibling::td[1]")
	private MCWebElement batchStatusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='privateField11']/..")
	private MCWebElement fromDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='privateField12']/..")
	private MCWebElement toDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name='childPanel:inputPanel:rows:5:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent']")
	private MCWebElement extractTypeDrpDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='privateField4']/select")
	private MCWebElement interchangeTypeDDwn;

	// Authorization dump specific locators start here

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@fld_fqn='privateField11']/..")
	private MCWebElement fromDateAuth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@fld_fqn='privateField12']/..")
	private MCWebElement toDateAuth;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:8:cols:colspanMarkup:inputField:input:dateTimeField:hours")
	private MCWebElement authFromDateHHTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:8:cols:colspanMarkup:inputField:input:dateTimeField:minutes")
	private MCWebElement authFromDateMMTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:8:cols:nextCol:colspanMarkup:inputField:input:dateTimeField:hours")
	private MCWebElement authToDateHHTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:8:cols:nextCol:colspanMarkup:inputField:input:dateTimeField:minutes")
	private MCWebElement authToDateMMTxtBx;

	// Card HOLDER specific locators start here

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:7:cols:nextCol:colspanMarkup:inputField:input:dateTimeField:hours")
	private MCWebElement cardHolderKycToDateHHTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:7:cols:nextCol:colspanMarkup:inputField:input:dateTimeField:minutes")
	private MCWebElement cardHolderKycToDateMMTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:7:cols:colspanMarkup:inputField:input:dateTimeField:hours")
	private MCWebElement cardHolderKycFromDateHHTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:7:cols:colspanMarkup:inputField:input:dateTimeField:minutes")
	private MCWebElement cardHolderKycFromDateMMTxtBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='privateField12']/span/span")
	private MCWebElement businessDatePrepaidEod;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=privateField14]")
	private MCWebElement businessDatePreClearing;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table[class='dataview'] tbody tr:nth-child(2) td:nth-child(3)")
	private MCWebElement jobId;

	private String batchStatus;
	
	private String jobID;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "batchType:input:dropdowncomponent")
	private MCWebElement batchTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchId:input:dropdowncomponent")
	private MCWebElement batchNameDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "selectAll")
	private MCWebElement selectAllChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:inputFiles:0:fileChecked:checkBoxComponent")
	private MCWebElement selectFirstChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:Cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement closeBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement feedbackInfoPanel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Status :')]//following::span[position()=1]/span")
	private MCWebElement processBatchStatusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='jobId']//span[@class='labeltextf']")
	private MCWebElement processBatchjobIDTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "*//td[@width='150px']/span[@class='labeltextf']")
	private MCWebElement processBatchjobIDPathTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='dispTraceLink']/a")
	private MCWebElement tracesLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='recRejectCnt']/span/span")
	private MCWebElements rejectedCountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement methodToGenerateFileDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement binDDwn;

	// Parameters Added for CardHolder Dump
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-skin-sam']/..")
	private MCWebElement businessDate;
	
	@PageElement( findBy = FindBy.X_PATH, valueToFind="//span[@id='jobId'] ")
	private MCWebElement jobIDNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.yui-skin-sam")
	private MCWebElement bussinessDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='File Type']/../following-sibling::td[1]//span/select")
	private MCWebElement fileTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Vendor Name']/../following-sibling::td[1]//span/select")
	private MCWebElement vendorNameDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='processFileName']//span[@class='labeltextf']")
	private MCWebElement processFileNameTxt;

	public final String SYSTEM_INTERNAL_PROCESSING = "SYSTEM INTERNAL PROCESSING [B]";

	private static final int NUMBER_OF_ATTEMPTS_TO_CHECK_SUCCESS_STATE=100;

	private String reasonToReject = "";
	
	private Boolean isProcess = false;
	
	private final String failStatus = "FAILED [3]";
	
	private final String successStatus = "SUCCESS [2]";
	
	private static final String  POST_MAINTENANCE_FEE_BATCH = "Post Maintenance Fee Batch [POST_MAINTENANCE_FEE]";

	public void selectBatchType(String option) {
		selectByVisibleText(batchTypeDDwn, option);
	}

	public void selectBatchName(String option) {
		waitForPageToLoad(driver());
		selectByVisibleText(batchNameDDwn, option);
	}

	public void clickSubmitBtn() {
		clickWhenClickable(submitBtn);
	}

	public static final String FILE_CHK_BOX = "//span[.='%s']/following::input[1]";
	public static final String JOB_ID = "//span[.='%s']/following::span[1]";
	public static final String JOB_STATUS = "//span[.='%s']/following::a[1]";

	public String retrieveJobID(String fileName) {
		return Element(JOB_ID.replace("%s", fileName)).getText();
	}

	public void checkFileCheckBox(String filename) {
		waitForElementVisible(submitBtn);
		waitForElementVisible(Element(FILE_CHK_BOX.replace("%s", filename)));
		clickWhenWebElementClickable(Element(FILE_CHK_BOX.replace("%s", filename)));
	}

	public void checkAndSumbitFile(String fileName) {
		checkFileCheckBox(fileName);
		clickSubmitBtn();
	}

	private By tracesDescription = By.xpath("//table[@class='modelFormClass']//table[@class='dataview']//tr//child::td[position()=4]");

	private List<String> errorDescription = new ArrayList<String>();

	public void processUploadBatch(String batchName) {
		selectBatchType(BatchType.UPLOAD);
		selectBatchName(batchName);
	}

	public void processBatch(String uploadedFileName, ProcessBatches processBatchesDomain) {
		String elementXpath = String.format("//span[contains(text(),'%s')]", uploadedFileName);
		String selectXpath = elementXpath + "//parent::td//following-sibling::td/input";
		selectByVisibleText(batchTypeDdwn, processBatchesDomain.getBatchType());
		SimulatorUtilities.wait(500);
		selectByVisibleText(batchNameDdwn, processBatchesDomain.getBatchName());
		SimulatorUtilities.wait(4000);
		WebElement uploadedFilename = getFinder().getWebDriver().findElement(By.xpath(elementXpath));
		WebElement checkbox = getFinder().getWebDriver().findElement(By.xpath(selectXpath));

		waitForElementVisible(selectFirstChkBx);
		if (uploadedFileName.equalsIgnoreCase(uploadedFilename.getText())) {
			if (!checkbox.isSelected())
				checkbox.click();
			ClickButton(submitBtn);
		} else {
			logger.error("Uploaded file is not seen on the Process Batches page");
		}
	}

	public boolean verifyFileProcess(ProcessBatches processBatchesDomain) {
		String elementXpath = String.format("//span[contains(text(),'%s')]", FileCreation.filenameStatic);
		Boolean isProcessed = false;
		String statusXpath = elementXpath + "//parent::td//following-sibling::td/a";
		SimulatorUtilities.wait(500);
		getFinder().getWebDriver().findElement(By.xpath(statusXpath)).click();
		switchToIframe(Constants.VIEW_BATCH_DETAILS);

		// unless it is completed, refresh it - No of attempts: 5
		for (int i = 0; i < NUMBER_OF_ATTEMPTS_TO_CHECK_SUCCESS_STATE; i++) {
			if (processBatchStatusTxt.getText().equalsIgnoreCase("PENDING [0]") || processBatchStatusTxt.getText().equalsIgnoreCase("IN PROCESS [1]")) {
				SimulatorUtilities.wait(8000);
				ClickButton(closeBtn);
				getFinder().getWebDriver().switchTo().defaultContent();
				getFinder().getWebDriver().findElement(By.xpath(statusXpath)).click();
				switchToIframe(Constants.VIEW_BATCH_DETAILS);
				waitForElementVisible(processBatchStatusTxt);
			} else if (processBatchStatusTxt.getText().equalsIgnoreCase("SUCCESS [2]")) {
				if (rejectedCountTxt.getText().contains("0") || rejectedCountTxt.getText().contains("-")) {
					isProcessed = true;
					break;
				} else {
					ClickButton(tracesLink);
					getBatchTraces();
					break;
				}
			} else if (processBatchStatusTxt.getText().equalsIgnoreCase("FAILED [3]")) {
				ClickButton(tracesLink);
				getBatchTraces();
				break;
			}
		}
		processBatchesDomain.setJoBID(processBatchjobIDTxt.getText());
		ClickButton(closeBtn);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		return isProcessed;
	}

	public void getBatchTraces() {
		getFinder().getWebDriver().switchTo().defaultContent();
		switchToIframe(Constants.TROUBLESHOOTING_TRACES);
		List<WebElement> tracesList = getFinder().getWebDriver().findElements(tracesDescription);

		for (WebElement element : tracesList) {
			errorDescription.add(element.getText());
		}

		ClickButton(closeBtn);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		switchToIframe(Constants.VIEW_BATCH_DETAILS);
	}

	public boolean verifyErrorMessage(String errorType) {
		boolean isSimilar = false;
		String propertyFileKey = "";
		String[] errorMessageArray = errorType.split(" ");
		String key = "";
		for (int i = 0; i < errorMessageArray.length; i++)
			key += errorMessageArray[i].trim();
		propertyFileKey = "cer.errormessage." + key;

		for (int j = 0; j < errorDescription.size(); j++) {
			if (env.getProperty(propertyFileKey).equalsIgnoreCase(errorDescription.get(j))) {
				isSimilar = true;
				break;
			}
		}
		return isSimilar;
	}

	public Map<String, String> processUploadBatch(ProcessBatches batch) {
		logger.info("Process Upload Batch: {}", batch.getBatchName());
		HashMap<String, String> hm = new HashMap<>();
		WebElementUtils.selectDDByVisibleText(batchTypeDDwn, batch.getBatchType());
		WebElementUtils.selectDDByVisibleText(batchNameDDwn, batch.getBatchName());
		/*
		 * WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, batch.getBatchType()); WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, batch.getBatchName());
		 */
		SimulatorUtilities.wait(5000);//this delay is for table to load data 
		WebElement selectChkIPM = driver().findElement(By.xpath("//td[.//*[text()='"+batch.getFileName()+"']]/following-sibling::td[1]/input"));
		selectChkIPM.click();
		//selectChkBx.click();
		WebElementUtils.scrollDown(driver(), 0, 250);
		submitBtn.click();
		WebElementUtils.waitForWicket(driver());
		viewFirstRecord();
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			clickCloseButton();
		});
		SimulatorUtilities.wait(3000);//this delay is for table to load data
		String jobNumber = jobId.getText();
		hm.put("JobId", jobNumber);
		hm.put("BatchStatus", batchStatus);
		return hm;
	}

	public String processSystemInternalProcessingBatchMatchingBatch(ProcessBatches batch) {

		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "SYSTEM INTERNAL PROCESSING [B]");
		selectInternalBatchType(batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		submitAndVerifyBatch();
		return batchStatus;

	}
	
	public String processSystemInternalProcessingBatchWithoutDateCheck(ProcessBatches batch) {
		logger.info("Process System Internal Processing Batch: {}", batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "SYSTEM INTERNAL PROCESSING [B]");
		selectInternalBatchType(batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		submitAndVerifyBatch();
		return batchStatus;
	}

	public void inputToDate(LocalDate date) {
		WebElementUtils.pickDate(businessDate, date);
	}

	public String processSystemInternalProcessingBatch(ProcessBatches batch) {
		logger.info("Process System Internal Processing Batch: {}", batch.getBatchName());
		Date todayDate = null;
		Date dateFromUI = null;
		batchStatus = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "SYSTEM INTERNAL PROCESSING [B]");
		selectInternalBatchType(batch.getBatchName());
		if (!(batch.getBatchName().contains("Loyalty"))) {

		if (batch.getProductType() != null && !("".equals(batch.getProductType()))) {
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		}
		try {
				if ((batch.getProductType().equalsIgnoreCase(ProductType.CREDIT)) || (batch.getBatchName().equalsIgnoreCase("End Of Day - Credit [DAILY]"))) {
					String query = Constants.INSTITUTION_NUMBER_QUERY_START + context.get(Constants.USER_INSTITUTION_SELECTED) + Constants.INSTITUTION_NUMBER_QUERY_END;
					String colName = Constants.INSTITUTION_DATE+"('"+ context.get(Constants.USER_INSTITUTION_SELECTED) +"')";
					inputToDate(DateUtils.convertInstitutionCurrentDateInLocalDateFormat(dbUtils.getSingleRecordColumnValueFromDB(query, colName)));
					submitAndVerifyBatch();
				} else {
			todayDate = dateFormatter.parse(dateFormatter.format(new Date()));
			dateFromUI = getDateFromUI(dateFormatter, batch);
				}

		} catch (ParseException e) {
			throw Throwables.propagate(e);
		}

			if (dateFromUI != null && !dateFromUI.after(todayDate))
			submitAndVerifyBatch();
		} else {
			submitAndVerifyBatch();
		}

		return batchStatus;
	}

	private void selectInternalBatchType(String batchName) {
		if ("Matching".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Matching Batch [MATCHING_BATCH]");

		else if ("Pre-clearing".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Pre-Clearing [PRE_CLR]");

		else if ("EOD-Prepaid".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "End Of Day - Prepaid [EOD]");

		else if ("Loyalty-Calc".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Loyalty Calculation [LYT_CALC]");
		
		else if("EOD-Credit".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "End Of Day - Credit [DAILY]");
		
		else if("Statement Extract".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Statement Extract [STATEMENT_GENERATION]"); 
		
		else if("Billing Process - Credit".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Billing Process - Credit [BILLING]"); 
		
		else if(POST_MAINTENANCE_FEE_BATCH.equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, POST_MAINTENANCE_FEE_BATCH); 
		
		else if("Ageing".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, "Ageing Batch [AGEING_BATCH]");
		else
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, batchName);
	}

	public String processDownloadBatch(ProcessBatches batch) {
		logger.info("Process Download Batch: {}", batch.getBatchName());

		if ("Authorization Download [AUTHORIZATION_DOWNLOAD]".equals(batch.getBatchName()))
			processAuthorizationDownloadBatch(batch);
		else if ("Cardholder Dump [CARDHOLDER_DUMP]".equals(batch.getBatchName()))
			processCardHolderDownloadBatch(batch);
		else if ("Account Dump [ACCOUNT_DUMP]".equals(batch.getBatchName()))
			processAccountsDownloadBatch(batch);
		else if ("Statement Download [STATEMENT_DOWNLOAD]".equals(batch.getBatchName()))
			statementDownloadBatch(batch);

		return batchStatus;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchTypeDDwn));
	}

	public void processAuthorizationDownloadBatch(ProcessBatches batch) {
		selectAccountDumpAndCHDump(batch);
		WebElementUtils.selectDDByVisibleText(extractTypeDrpDwn, batch.getExtractType());
		WebElementUtils.selectDDByVisibleText(interchangeTypeDDwn, batch.getInterchangeType());
		WebElementUtils.enterText(authFromDateHHTxtBx, "00");
		WebElementUtils.enterText(authFromDateMMTxtBx, "00");
		WebElementUtils.enterText(authToDateHHTxtBx, "23");
		WebElementUtils.enterText(authToDateMMTxtBx, "00");
		WebElementUtils.pickDate(fromDateAuth, LocalDate.now().minusDays(60));
		WebElementUtils.pickDate(toDateAuth, LocalDate.now().minusDays(1));
		submitAndVerifyBatch();
	}

	public void processCardHolderDownloadBatch(ProcessBatches batch) {
		selectAccountDumpAndCHDump(batch);
		WebElementUtils.selectDDByVisibleText(extractTypeDrpDwn, batch.getExtractType());
		WebElementUtils.pickDate(fromDateAuth, LocalDate.now().minusDays(60));
		WebElementUtils.pickDate(toDateAuth, LocalDate.now().minusDays(1));
		WebElementUtils.enterText(cardHolderKycFromDateHHTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycFromDateMMTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycToDateHHTxtBx, "23");
		WebElementUtils.enterText(cardHolderKycToDateMMTxtBx, "00");
		submitAndVerifyBatch();
	}

	public void processAccountsDownloadBatch(ProcessBatches batch) {
		selectAccountDumpAndCHDump(batch);
		submitAndVerifyBatch();
	}

	public void processKYCDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);
		WebElementUtils.enterText(cardHolderKycFromDateHHTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycFromDateMMTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycToDateHHTxtBx, "23");
		WebElementUtils.enterText(cardHolderKycToDateMMTxtBx, "00");
		submitAndVerifyBatch();
	}

	public void submitAndVerifyBatch() {
		submitBtn.click();
		//statusBtn.click();
		clickWhenClickable(statusBtn);
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			jobID = processBatchjobIDTxt.getText();
			context.put(ContextConstants.DAT_FILE_NAME, processFileNameTxt.getText());
			try{
			clickCloseButton();
			}
			catch(StaleElementReferenceException ex)
			{
				clickCloseButton();
			}
			SimulatorUtilities.wait(1000);
		});
	}
	
	public void submitAndVerifyBaseIIBatch() {
		ClickButton(submitBtn);
		ClickButton(statusBtn);
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			WebElementUtils.scrollDown(driver(), 0, 350);
			ClickButton(closeBtn);
		});
	}
	
	public void getVisaOutGoingFileName() {	
		WebElement fileNameLbl = getFinder().getWebDriver().findElement(By.xpath("//*[@id='outputFileName']//span[@class='labeltextf'] "));
		context.put(ConstantData.VISA_OUT_GOING_FILE_NAME, fileNameLbl.getText());
	}

	public void statementDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now().minusDays(2));
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		submitAndVerifyBatch();
	}

	public void selectDownloadBatch(ProcessBatches batch) {
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "DOWNLOAD [D]");
		WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
	}

	public String ipmDownloadBatch(ProcessBatches batch) {
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "DOWNLOAD [D]");
		WebElementUtils.selectDropDownByVisibleText(batchNameDDwn, batch.getBatchName());
		submitAndVerifyBatch();
		return batchStatus;
	}

	public void selectAccountDumpAndCHDump(ProcessBatches batch) {
		WebElementUtils.selectDDByVisibleText(batchTypeDDwn, "DOWNLOAD [D]");
		WebElementUtils.selectDDByVisibleText(batchNameDDwn, batch.getBatchName());
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, batch.getProductType());
	}

	public Date getDateFromUI(SimpleDateFormat dateFormatter, ProcessBatches batch) throws ParseException {
		Date dateFromUI = new Date();
		String businessDate = "";
		if ("Pre-clearing".equalsIgnoreCase(batch.getBatchName())) {
			while ("".equalsIgnoreCase(businessDate)) {
				businessDate = businessDatePreClearing.getAttribute("value");
			}
			dateFromUI = dateFormatter.parse(businessDate);
		} else if ("EOD-Prepaid".equalsIgnoreCase(batch.getBatchName())) {
			WebElementUtils.visibilityOf(businessDatePrepaidEod);
			waitForWicket();
			dateFromUI = dateFormatter.parse(businessDatePrepaidEod.getText());
		}
		return dateFromUI;
	}

	public boolean verifyFileProcessUpload(ProcessBatches processBatchesDomain, String fileName) {
		FileCreation.filenameStatic = fileName;
        Boolean isProcessed = true;
		String elementXpath = String.format("//span[contains(text(),'%s')]", FileCreation.filenameStatic);
		String statusXpath = elementXpath + "//parent::td//following-sibling::td/a";
		SimulatorUtilities.wait(20000);
		clickWhenClickable(getFinder().getWebDriver().findElement(By.xpath(statusXpath)));
        
        SimulatorUtilities.wait(5000);//this delay is for table to load data 
        runWithinPopup("View Batch Details", () -> {
              logger.info("Retrieving batch status");
              waitForBatchStatus();
              SimulatorUtilities.wait(5000);
              batchStatus = batchStatusTxt.getText();
		processBatchesDomain.setJoBID(processBatchjobIDTxt.getText());
              SimulatorUtilities.wait(5000);
              clickCloseButton();
        });
        SimulatorUtilities.wait(3000);//this delay is for table to load data
		MiscUtils.reportToConsole("JobID: {}", processBatchesDomain.getJoBID());
		context.put(CreditConstants.JOB_ID, processBatchesDomain.getJoBID());
		waitForWicket(driver());
		getFinder().getWebDriver().switchTo().defaultContent();
		return isProcessed;

	}
	
	public boolean processBatchUpload(ProcessBatches processBatchesDomain, String fileName){
		FileCreation.filenameStatic = fileName;
		String statusXpath = String.format("//span[contains(text(),'%s')]", FileCreation.filenameStatic) + "//parent::td//following-sibling::td/a";
		SimulatorUtilities.wait(10000);
		clickWhenClickable(getFinder().getWebDriver().findElement(By.xpath(statusXpath)));
		SimulatorUtilities.wait(5000);//this delay is for table to load data 
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			SimulatorUtilities.wait(5000);
			batchStatus = batchStatusTxt.getText();
			processBatchesDomain.setJoBID(processBatchjobIDTxt.getText());
			SimulatorUtilities.wait(5000);
			if(batchStatus.equalsIgnoreCase(successStatus)){
				isProcess = true;
			}
			else if(batchStatus.equals(failStatus)){
				isProcess = true;
				SimulatorUtilities.wait(5000);
				ClickButton(rejectBtn);
				SimulatorUtilities.wait(5000);
				runWithinPopup("Rejected Record Details", () -> {
					reasonToReject = getTextFromPage(rejectDueToMandatory);
					context.put(ContextConstants.REJECTED_FILE_UPLOAD, reasonToReject);
					clickCloseButton();
				});
			}
			clickCloseButton();
		});
		SimulatorUtilities.wait(3000);//this delay is for table to load data
		MiscUtils.reportToConsole("JobID: {}", processBatchesDomain.getJoBID());
		context.put(CreditConstants.JOB_ID, processBatchesDomain.getJoBID());
		waitForWicket(driver());
		return isProcess;
	}
	
	public String visaOutgoingDownloadBatch(ProcessBatches batch) {
		Device device=context.get(ContextConstants.DEVICE);
		selectBatchType(batch.getBatchType());
		selectBatchName(batch.getBatchName());
		selectMethodToGenerateFile(batch.getMethodToGenerateFile());
	    selectBin(device.getDeviceNumber().substring(0, 6));
		submitAndVerifyBaseIIBatch();
		getVisaOutGoingFileName();
		return batchStatus;
	}
	public void selectMethodToGenerateFile(String option)
	{
		waitForElementVisible(methodToGenerateFileDD);
		WebElementUtils.selectDropDownByVisibleText(methodToGenerateFileDD, option);
	}
	public void selectBin(String option)
	{
		WebElementUtils.selectDropDownByVisibleText(binDDwn, option);
	}
	
	/**
	 * This function is written to execute batches which has only one date field.
	 * @param batch 
	 * @return status of batch e.g pass, fail
	 */
	public ProcessBatches processCreditBillingBatch(ProcessBatches batch) {
		ProcessBatches batches = new ProcessBatches();
		selectBatchTypeAndName(batch);
		WebElementUtils.pickDate(bussinessDateTxt, DateUtils.convertInstitutionDateInLocalDateFormat(getTextFromPage(institutionDateTxt)));
		submitAndVerifyBatch();
		batches.setJoBID(jobID);
		batches.setStatus(batchStatus);
		return batches;
	}

	/**
	 * This function is written to execute batches which has two date field.
	 * @param batch 
	 * @return status of batch e.g pass, fail
	 */
	public String processStatementExtractBatch(ProcessBatches batch) {
		selectBatchTypeAndName(batch);
		LocalDate fromDate = DateUtils.convertInstitutionDateInLocalDateFormat(getInstitutionDate());
		LocalDate toDate = DateUtils.convertInstitutionDateInLocalDateFormat(getInstitutionDate()).minusDays(30);
		WebElementUtils.pickDate(fromDateTxt, fromDate);
		WebElementUtils.pickDate(toDateTxt,toDate);
		context.put(ContextConstants.STATEMENT_FROM_DATE, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH).format(fromDate));
		context.put(ContextConstants.STATEMENT_TO_DATE, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH).format(toDate));
		context.put(ContextConstants.STATEMENT_DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(fromDate));
		submitAndVerifyBatch();
		return batchStatus;
	}
	
	private void selectBatchTypeAndName(ProcessBatches batch) {
		logger.info("Process System Internal Processing Batch: {}", batch.getBatchName());
		batchStatus = null;
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, SYSTEM_INTERNAL_PROCESSING);		
		selectInternalBatchType(batch.getBatchName());
		if(batch.getBatchName().equalsIgnoreCase("Pre-clearing"))
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
	}

	public String processSystemInternalProcessingBatchPostMaintenance(ProcessBatches batch) {
		logger.info("Process System Internal Processing Batch: {}", batch.getBatchName());
		Date todayDate;
		Date dateFromUI;
		batchStatus = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "SYSTEM INTERNAL PROCESSING [B]");
		SimulatorUtilities.wait(2000);
		selectInternalBatchType(batch.getBatchName());
		SimulatorUtilities.wait(2000);

		try {
			todayDate = dateFormatter.parse(dateFormatter.format(new Date()));
			dateFromUI = getDateFromUI(dateFormatter, batch);
		} catch (ParseException e) {
			throw MiscUtils.propagate(e);
		}

		submitAndVerifyBatch();
		return batchStatus;
	}
	
	public String processCarrierDownloadBatch(ProcessBatches batch) {
		logger.info("Process Carrier Download Batch: {}", batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, batch.getBatchType());
		doSelectByVisibleText(batchNameDDwn, batch.getBatchName());
		SimulatorUtilities.wait(5000);
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		doSelectByVisibleText(fileTypeDDwn, batch.getFileType());
		SimulatorUtilities.wait(5000);
		WebElementUtils.selectDropDownByVisibleText(vendorNameDDwn, batch.getVendorName());
		submitAndVerifyBatch();
		return batchStatus;
	}

	
	public void processDownloadBatch(String batchType, String batchName)
	{
		selectByVisibleText(batchTypeDdwn, "DOWNLOAD [D]");
		if(batchName.equalsIgnoreCase("CLIENT_PHOTO_BATCH"))
			selectByVisibleText(batchNameDdwn, Constants.CLIENT_PHOTO_FLAT_FILE_DOWNLOAD_BATCH);
		else
		{
			if(batchName.equalsIgnoreCase("CardholderDump"))
				selectByVisibleText(batchNameDdwn, Constants.CARDHOLDER_DUMP_BATCH);
		}
		SimulatorUtilities.wait(2000);
		selectByVisibleText(productTypeDDwn, context.get(ConstantData.PRODUCT_IDENTITY));
		selectByVisibleText(extractTypeDrpDwn, Constants.EXTRACT_TYPE_FULL);
		WebElementUtils.pickDate(fromDateAuth, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDateAuth, LocalDate.now());
		WebElementUtils.enterText(cardHolderKycFromDateHHTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycFromDateMMTxtBx, "00");
		WebElementUtils.enterText(cardHolderKycToDateHHTxtBx, "23");
		WebElementUtils.enterText(cardHolderKycToDateMMTxtBx, "00");
		clickSubmitBtn();
		context.put(ContextConstants.JOB_ID, jobIDNumber.getText());
		SimulatorUtilities.wait(3000);
		
		
	}
}