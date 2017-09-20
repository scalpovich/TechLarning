package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author e074127 Process Batches Page class
 */

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES,
		CardManagementNav.L3_PROCESS_BATCHES })
public class ProcessBatchesPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ProcessBatchesPage.class);

	@Autowired
	ProcessBatches processBatchesDomain;

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchType:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchId:input:dropdowncomponent")
	private MCWebElement batchNameDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:submitButton")
	private MCWebElement submitBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "selectAll")
	private MCWebElement selectAllChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='productType']/select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:inputFiles:0:fileChecked:checkBoxComponent")
	private MCWebElement selectFirstChkBx;

	

	@PageElement(findBy = FindBy.CSS, valueToFind = "td[class='displayName'] a span")
	private MCWebElement statusBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:Cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement closeBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement feedbackInfoPanel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Status :')]//following::span[position()=1]/span")
	private MCWebElement processBatchStatusTxt;

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

	private String batchStatus;
	public void processBatch(String uploadedFileName) {
		String elementXpath = String.format("//span[contains(text(),'%s')]",
				uploadedFileName);
		String selectXpath = elementXpath
				+ "//parent::td//following-sibling::td/input";
		selectByVisibleText(batchTypeDdwn,
				ProcessBatches.fromShortName(processBatchesDomain
						.getBatchType()));
		CustomUtils.ThreadDotSleep(500);
		selectByVisibleText(batchNameDdwn,
				ProcessBatches.fromShortName(processBatchesDomain
						.getBatchName()));
		CustomUtils.ThreadDotSleep(2000);
		WebElement uploadedFilename = getFinder().getWebDriver().findElement(
				By.xpath(elementXpath));
		WebElement checkbox = getFinder().getWebDriver().findElement(
				By.xpath(selectXpath));

		waitForElementVisible(selectFirstChkBx);
		if (uploadedFileName.equalsIgnoreCase(uploadedFilename.getText())) {
			if (!checkbox.isSelected())
				checkbox.click();
			ClickButton(submitBtn);
		} else {
			logger.error("Uploaded file is not seen on the Process Batches page");
		}
	}

	public boolean verifyFileProcess() {
		String elementXpath = String.format("//span[contains(text(),'%s')]",
				FileCreation.filenameStatic);
		Boolean isProcessed = false;
		String statusXpath = elementXpath
				+ "//parent::td//following-sibling::td/a";
		CustomUtils.ThreadDotSleep(500);
		getFinder().getWebDriver().findElement(By.xpath(statusXpath)).click();
		switchToIframe(Constants.VIEW_BATCH_DETAILS);

		// unless it is completed, refresh it - No of attempts: 5
		for (int i = 0; i < 5; i++) {
			if (processBatchStatusTxt.getText().equalsIgnoreCase("PENDING [0]")
					|| processBatchStatusTxt.getText().equalsIgnoreCase(
							"IN PROCESS [1]")) {
				ClickButton(closeBtn);
				getFinder().getWebDriver().switchTo().defaultContent();
				CustomUtils.ThreadDotSleep(3000);
				getFinder().getWebDriver().findElement(By.xpath(statusXpath))
						.click();
				switchToIframe(Constants.VIEW_BATCH_DETAILS);
				waitForElementVisible(processBatchStatusTxt);
			} else if (processBatchStatusTxt.getText().equalsIgnoreCase(
					"SUCCESS [2]")) {
				isProcessed = true;
				break;
			}
		}
		ClickButton(closeBtn);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(200);
		return isProcessed;
	}
	public String processUploadBatch(ProcessBatches batch) {
		logger.info("Process Upload Batch: {}", batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn,
				batch.getBatchType());
		WebElementUtils.selectDropDownByVisibleText(batchNameDDwn,
				batch.getBatchName());
		selectChkBx.click();
		submitBtn.click();
		viewFirstRecord();
		runWithinPopup("View Batch Details",  () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			clickCloseButton();
		});
		return batchStatus;
	}

	public String processSystemInternalProcessingBatch(ProcessBatches batch){
		logger.info("Process System Internal Processing Batch: {}", batch.getBatchName());
		Date todayDate;
		Date dateFromUI;
		batchStatus=null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn, "SYSTEM INTERNAL PROCESSING [B]");
		selectInternalBatchType(batch.getBatchName());
		if(batch.getProductType()!=null && ! ("".equals(batch.getProductType())))
		{
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		}
		try {
			todayDate = dateFormatter.parse(dateFormatter
					.format(new Date()));
			dateFromUI =getDateFromUI(dateFormatter,batch);
		} catch (ParseException e) {
			throw Throwables.propagate(e);
		}
		if(!dateFromUI.after(todayDate))
		{
		submitBtn.click();
		statusBtn.click();
		runWithinPopup("View Batch Details",  () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			clickCloseButton();
		});
		}
		return batchStatus;
	}	

	private void selectInternalBatchType(String batchName) {
		if ("Matching".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn,
					"Matching Batch [MATCHING_BATCH]");

		else if ("Pre-clearing".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn,
					"Pre-Clearing [PRE_CLR]");

		else if ("EOD-Prepaid".equalsIgnoreCase(batchName))
			WebElementUtils.selectDropDownByVisibleText(batchNameDDwn,
					"End Of Day - Prepaid [EOD]");
	}

	public String processDownloadBatch(ProcessBatches batch) {
		logger.info("Process Download Batch: {}", batch.getBatchName());

		if ("Authorization Download [AUTHORIZATION_DOWNLOAD]".equals(batch
				.getBatchName()))
			processAuthorizationDownloadBatch(batch);
		else if ("Cardholder Dump [CARDHOLDER_DUMP]".equals(batch
				.getBatchName()))
			processCardHolderDownloadBatch(batch);
		else if ("Account Dump [ACCOUNT_DUMP]".equals(batch.getBatchName()))
			processAccountsDownloadBatch(batch);
		else if("Statement Download [STATEMENT_DOWNLOAD]".equals(batch.getBatchName()))
				 statementDownloadBatch(batch);
		
		return batchStatus;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchTypeDDwn));
	}

	public void processAuthorizationDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);

		WebElementUtils.selectDropDownByVisibleText(extractTypeDrpDwn,
				batch.getExtractType());

		WebElementUtils.selectDropDownByVisibleText(interchangeTypeDDwn,
				batch.getInterchangeType());

		WebElementUtils.enterText(authFromDateHHTxtBx, "00");

		WebElementUtils.enterText(authFromDateMMTxtBx, "00");

		WebElementUtils.enterText(authToDateHHTxtBx, "23");

		WebElementUtils.enterText(authToDateMMTxtBx, "00");

		WebElementUtils.pickDate(fromDateAuth, LocalDate.now().minusDays(60));

		WebElementUtils.pickDate(toDateAuth, LocalDate.now().minusDays(1));

		submitAndVerifyBatch();
	}

	public void processCardHolderDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);

		WebElementUtils.selectDropDownByVisibleText(extractTypeDrpDwn,
				batch.getExtractType());

		WebElementUtils.pickDate(fromDateAuth, LocalDate.now().minusDays(60));

		WebElementUtils.pickDate(toDateAuth, LocalDate.now().minusDays(1));

		WebElementUtils.enterText(cardHolderKycFromDateHHTxtBx, "00");

		WebElementUtils.enterText(cardHolderKycFromDateMMTxtBx, "00");

		WebElementUtils.enterText(cardHolderKycToDateHHTxtBx, "23");

		WebElementUtils.enterText(cardHolderKycToDateMMTxtBx, "00");

		submitAndVerifyBatch();
	}

	public void processAccountsDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);
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
		statusBtn.click();
		runWithinPopup("View Batch Details", () -> {
			logger.info("Retrieving batch status");
			waitForBatchStatus();
			batchStatus = batchStatusTxt.getText();
			clickCloseButton();
		});
	}

	public void statementDownloadBatch(ProcessBatches batch) {
		selectDownloadBatch(batch);

		WebElementUtils.pickDate(fromDateTxt, LocalDate.now().minusDays(2));
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());

		submitAndVerifyBatch();
	}

	public void selectDownloadBatch(ProcessBatches batch) {
		WebElementUtils.selectDropDownByVisibleText(batchTypeDDwn,
				"DOWNLOAD [D]");
		WebElementUtils.selectDropDownByVisibleText(batchNameDDwn,
				batch.getBatchName());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				batch.getProductType());
	}
	
	public Date getDateFromUI(SimpleDateFormat dateFormatter, ProcessBatches batch) throws ParseException
	{
		Date dateFromUI= new Date();
		String businessDate="";
		 if("Pre-clearing".equalsIgnoreCase(batch.getBatchName()))
		 {
			 while("".equalsIgnoreCase(businessDate))
			 {
				 businessDate= businessDatePreClearing.getAttribute("value");
			 }
				dateFromUI= dateFormatter.parse(businessDate); 
		 }
		else if("EOD-Prepaid".equalsIgnoreCase(batch.getBatchName()))
		{
			 WebElementUtils.visibilityOf(businessDatePrepaidEod);
			 waitForWicket();
			dateFromUI= dateFormatter.parse(businessDatePrepaidEod.getText()); 
		}
		 return dateFromUI;
	}
}
