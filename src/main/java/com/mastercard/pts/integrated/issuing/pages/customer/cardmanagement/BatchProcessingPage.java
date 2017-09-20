package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.BatchType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CustomMCWebElementImpl;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.CustomMCWebElement;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.QMRPDFUtility;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author E070234 - Implement this class for the basic functionality of batch
 *         processing and QMR report downloading and validation.
 *
 */

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1OPERATION, CardManagementNav.L2PROCESSING_BATCHES,
		CardManagementNav.L3PROCESS_BATCHES })

public class BatchProcessingPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(BatchProcessingPage.class);

	@Autowired
	QMRPDFUtility pdfUtil;

	final Logger logger = LoggerFactory.getLogger(BatchProcessingPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchType:input:dropdowncomponent")
	public MCWebElement batchTypeDDwn;
	// ProcessingBatches

	@PageElement(findBy = FindBy.NAME, valueToFind = "batchId:input:dropdowncomponent")
	public MCWebElement batchName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement batchQuater;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:2:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	public MCWebElement chkBxbatchregenerate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement batchCurrencyCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanel:inputPanel:rows:1:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement batchYear;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonPanel:submitButton")
	public MCWebElement btnSubmit;

	@PageElement(findBy = FindBy.LINK, valueToFind = "Status")
	public MCWebElement statusLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//table[1]/tbody/tr[3]/td[4]/span")
	public MCWebElement lablstatus;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='jobId']/span")
	public MCWebElement batchScheduledID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	public MCWebElement btnClose;

@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	public MCWebElement selectcomplianceReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "goButton")
	public MCWebElement btnGo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_year:input:dropdowncomponent")
	public MCWebElement yearDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	public MCWebElement btngenerateRepor;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_quarter:input:dropdowncomponent")
	public MCWebElement quaterDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_currency_code:input:dropdowncomponent")
	public MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "p_file_type:input:dropdowncomponent")
	public MCWebElement reportTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Submit']")
	public MCWebElement submitBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[.='%s']/following::input[1]")
	public MCWebElement submitBtn1;

	@CustomMCWebElement(findBy = FindBy.X_PATH, valueToFind = "//span[.='%s']/following::input[1]")
	public CustomMCWebElementImpl fileCheckBox;

	public BatchProcessingPage() {
		fileCheckBox = new CustomMCWebElementImpl();
	}

	public MCWebElement fileCheckBox(String fileName) {
		fileCheckBox.getCustomMCWebElement(this, fileName).click();
		return getMCWebElementFromWebElement(FindBy.X_PATH,
				"//span[.='%s']/following::input[1]".replace("%s", fileName));
	}

	public String FILE_CHK_BOX = "//span[.='%s']/following::input[1]";
	public String JOB_ID = "//span[.='%s']/following::span[1]";
	public String JOB_STATUS = "//span[.='%s']/following::a[1]";

	public void clickSubmitBtn() {
		clickWhenClickable(submitBtn);
	}

	public void selectBatchType(String option) {
		selectByVisibleText(batchTypeDDwn, option);
	}

	public void selectBatchName(String option) {
		selectByVisibleText(batchName, option);
	}

	public void processUploadBatch(String batchName) {
		selectBatchType(BatchType.UPLOAD);
		selectBatchName(batchName);
	}

	public void processDownloadBatch(String batchName) {
		selectBatchType(BatchType.DOWNLOAD);
		selectBatchName(batchName);
	}

	public void processSystemInternalBatch(String batchName) {
		selectBatchType(BatchType.SYSTEM_INTERNAL);
		selectBatchName(batchName);
	}

	public void checkFileCheckBox(String FileName) {
		// fileCheckBox.getCustomMCWebElement(FileName).click();;
		waitForElementVisible(submitBtn);
		//clickWhenClickable(getMCWebElementFromWebElement(FindBy.X_PATH, FileName));
		waitForElementVisible(Element(FILE_CHK_BOX.replace("%s", FileName)));
		clickWhenWebElementClickable(Element(FILE_CHK_BOX.replace("%s", FileName)));
		//fileCheckBox(FileName).click();
	}

	public void checkAndSumbitFile(String FileName) {
		checkFileCheckBox(FileName);
		clickSubmitBtn();
	}

	public String retrieveJobID(String fileName) {
		return Element(JOB_ID.replace("%s", fileName)).getText();
	}

	public void getBatchStatus(String fileName) {
		clickWhenClickable(getMCWebElementFromWebElement(FindBy.X_PATH,
				JOB_STATUS.replace("%s", fileName)));
	}

	/**
	 * Implement this function to run the batch
	 * 
	 * @param QuaterType
	 */
	public void runProcessBatch(String quaterType) {
		SelectDropDownByText(batchTypeDDwn,
				MapUtils.fnGetInputDataFromMap("BatchType"));
		waitForElementVisible(batchName);

		SelectDropDownByText(batchName,
				MapUtils.fnGetInputDataFromMap("BatchName"));
		waitForElementVisible(batchQuater);

		SelectDropDownByText(batchQuater, quaterType);

		SelectDropDownByText(batchYear,
				MapUtils.fnGetInputDataFromMap("BatchYear"));

		SelectDropDownByText(batchCurrencyCode,
				MapUtils.fnGetInputDataFromMap("BatchCurrency"));

		ClickCheckBox(chkBxbatchregenerate, true);

		ClickButton(btnSubmit);
		waitForElementVisible(statusLink);

		ClickButton(statusLink);
		waitForElementVisible(batchScheduledID);

		logger.debug("Scheduled Batch Id :- " + batchScheduledID.getText());
		switchToIframe(Constants.VIEW_BATCH_DETAILS_FRAME);
		waitForSucces();

	}

	/**
	 * Implement this function to wait till the batch executed status becomes
	 * sucess.
	 * 
	 * @param statusString
	 *            ,statuslabelTxt
	 */
	public void waitForSucces() {

		String statusString = "SUCCESS [2]";
		String statuslabelTxt;

		Integer i = 0;
		do {
			statuslabelTxt = lablstatus.getText();

			CustomUtils.ThreadDotSleep(2000);

		} while (!(statuslabelTxt.trim().contains(statusString.trim()))
				&& i++ < 20);

		CustomUtils.ThreadDotSleep(2000);
		logger.info("Status  -", statuslabelTxt);
		btnClose.click();
		SwitchToDefaultFrame();

	}

	/**
	 * Implement this function to download the compliance report.
	 * 
	 */

	public void downloadComplianceReport() {

		waitForElementVisible(selectcomplianceReportDDwn);
		SelectDropDownByText(selectcomplianceReportDDwn,
				MapUtils.fnGetInputDataFromMap("ComplianceReport"));

		waitForElementVisible(btnGo);
		btnGo.click();
		waitForElementVisible(reportTypeDDwn);
		checkDropdownValue("ReportType", reportTypeDDwn);
		checkDropdownValue("CurrencyOfInstitution", currencyDDwn);
		waitForElementVisible(reportTypeDDwn);
		SelectDropDownByText(yearDDwn,
				MapUtils.fnGetInputDataFromMap("ReportYear"));
		SelectDropDownByText(quaterDDwn,
				MapUtils.fnGetInputDataFromMap("reportQuater"));
		SelectDropDownByText(currencyDDwn,
				MapUtils.fnGetInputDataFromMap("ReportCurrency"));
		SelectDropDownByText(reportTypeDDwn,
				MapUtils.fnGetInputDataFromMap("ReportFormat"));
		SelectDropDownByText(yearDDwn,
				MapUtils.fnGetInputDataFromMap("ReportYear"));
		SelectDropDownByText(quaterDDwn,
				MapUtils.fnGetInputDataFromMap("reportQuater"));
		SelectDropDownByText(currencyDDwn,
				MapUtils.fnGetInputDataFromMap("ReportCurrency"));
		SelectDropDownByText(reportTypeDDwn,
				MapUtils.fnGetInputDataFromMap("ReportFormat"));
		waitForElementVisible(btngenerateRepor);
		btngenerateRepor.click();

	}

	/**
	 * This is common function to verify the drop down value.
	 * 
	 */
	public void checkDropdownValue(String columnType,
			MCWebElement reportTypeDropDwn) {
		String[] reportTypeFromSheet = MapUtils.fnGetInputDataFromMap(
				columnType).split("\\,");

		List<WebElement> interchangePresent = reportTypeDropDwn.getSelect()
				.getOptions();

		for (int i = 0; i < reportTypeFromSheet.length; i++) {
			Assert.assertEquals(
					"Report type Drop Down Present :",
					true,
					interchangePresent.get(i + 1).getText().trim()
							.contains(reportTypeFromSheet[i].trim()));

		}

	}

	public void getNewCards() {
		// To be implemented
	}
	public void verifyUiOperationStatus() {
		logger.info("Batch Processing");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(selectReportDDwn)
				);


}