package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_PRE_PRODUCTION_BATCH })
public class PreProductionBatchPage extends AbstractBasePage {

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Autowired
	private TestContext context;

	private static final Logger logger = LoggerFactory.getLogger(PreProductionBatchPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Search'][@type = 'submit']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productionPanel:BasicDataTable:datatable:body:rows:1:cells:8:cell:columnCheckBox")
	private MCWebElement preProductionBatchRecordChkBx;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value ='Process Selected'][@type= 'submit']")
	private MCWebElement processSelectedBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement batchTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement sourceJobIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:saveAll")
	private MCWebElement processAllBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class = 'repeat']//div[2]//li[2]//span[@class = 'feedbackPanelINFO']")
	private MCWebElement confirmationMsgTxt;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview tbody tr:nth-of-type(1) td:nth-of-type(3)")
	private MCWebElement batchNumberFirstRowTxt;

	public void preproduction(String product, String batchNum) {
		menuSubMenuPage.getPreProductionBatch().click();
		selectDropDownByText(productTypeDDwn, product);
		if (batchNum != null) {
			enterText(batchNumberTxt, batchNum);
		}
		ClickButton(searchBtn);
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		clickWhenClickable(processAllBtn);
		switchToDefaultFrame();
	}

	public void processPreProductionBatch(PreProductionBatch batch) {
		logger.info("Pre-Production Batch: {}", batch.getBatchNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		waitAndSearchForRecordToExist();
		verifyOperationStatus();
	}

	public void processPreProductionBatch1(PreProductionBatch batch) {
		waitForLoaderToDisappear();
		selectDropDownByText(productTypeDDwn, batch.getProductType());
		CustomUtils.ThreadDotSleep(8000);
		logger.info(batch.getJobID());
		enterText(sourceJobIdTxt, batch.getJobID());
		clickWhenClickable(searchBtn);
		SimulatorUtilities.wait(3000);
		String batchNumberWebElement = "//table[@class='dataview']//tbody/tr/td[3]/span";
		String batchNumber = getFinder().getWebDriver().findElement(By.xpath(batchNumberWebElement)).getText().trim();
		logger.info("BatchNumber - {} ", batchNumber);
		batch.setBatchNumber(batchNumber);
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
		switchToDefaultFrame();

	}

	public void processPreProductionBatchNewApplication(PreProductionBatch batch) {
		waitForLoaderToDisappear();
		selectDropDownByText(productTypeDDwn, batch.getProductType());
		CustomUtils.ThreadDotSleep(10000);		
		enterText(batchNumberTxt, context.get(CreditConstants.NEW_APPLICATION_BATCH));
		ClickButton(searchBtn);
		waitAndSearchForRecordToAppear();
		setQuantityRequested();
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
		switchToDefaultFrame();
	}
	
	public void setQuantityRequested(){		
		context.put(CreditConstants.QUANTITY_REQUESTED, getCellTextByColumnName(1,"Quantity Requested")); 
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Pre-Prodcution Batch");
		verifySearchButton("Search");
	}

	public void selectProduct(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByText(productTypeDDwn, bulkdeviceGenBatch.getProduct());
	}

	public void enterBatchNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(batchNumberTxt, bulkdeviceGenBatch.getBatchNumber());
	}

	public void enterSourceJobId(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(sourceJobIdTxt, bulkdeviceGenBatch.getJobId());
	}

	public void selectBatchType(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(batchTypeDDwn, bulkdeviceGenBatch.getBatchType());
	}

	public void search() {
		clickWhenClickable(searchBtn);
	}

	public void clickPreProductionChkBox(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		CustomUtils.ThreadDotSleep(5000);
		search();
		// WebElement SelectProcessChkBx =
		// getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
		// + bulkdeviceGenBatch.getJobId()
		// +
		// "')]/following::span/input[@name='productionPanel:BasicDataTable:datatable:body:rows:1:cells:8:cell:columnCheckBox']"));
		clickWhenClickable(preProductionBatchRecordChkBx);
	}

	public void clickProcessSelectedBtn() {
		clickWhenClickable(processSelectedBtn);
	}

	public void searchBulkPreProductionBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectProduct(bulkdeviceGenBatch);
		enterBatchNumber(bulkdeviceGenBatch);
		enterSourceJobId(bulkdeviceGenBatch);
		search();
	}

	public void ProcessSelectedBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		clickPreProductionChkBox(bulkdeviceGenBatch);
		clickProcessSelectedBtn();
	}

	public boolean verifyErrorsOnPreProductionPage() {
		return publishErrorOnPage();
	}

	public void verifyPreProductionRequestSuccess() {
		if (!verifyErrorsOnPreProductionPage()) {
			logger.info("Pre-Production batch succesful");
			switchToDefaultFrame();
		} else {
			logger.info("Error in batch");
			switchToDefaultFrame();
		}
	}

	public String checkPreProductionJobID() {
		String strOutputMessage = confirmationMsgTxt.getText().split("\\n")[0];
		return strOutputMessage.replaceAll("[^\\d]", "").trim();

	}

	public void processPreProductionBatchNewDevice(PreProductionBatch batch) {
		waitForLoaderToDisappear();
		selectDropDownByText(productTypeDDwn, batch.getProductType());
		CustomUtils.ThreadDotSleep(8000);
		String batchNumber=context.get(CreditConstants.PRIMARY_BATCH_NUMBER);
		enterText(batchNumberTxt, batchNumber);
		ClickButton(searchBtn);
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		ClickButton(processSelectedBtn);
		verifyOperationStatus();
		switchToDefaultFrame();
	}	

	public void processPreProductionBatchNewApplicationForFileUpload(PreProductionBatch batch) {
        List<String>batchNumbers=context.get(CreditConstants.ALL_BATCH_NUMBERS_PREPRODUCTION);
		waitForLoaderToDisappear();
		selectDropDownByText(productTypeDDwn, batch.getProductType());
		SimulatorUtilities.wait(5000);
		enterText(batchNumberTxt, batchNumbers.get(0));
		SimulatorUtilities.wait(3000);
		ClickButton(searchBtn);
		SimulatorUtilities.wait(3000);
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		SimulatorUtilities.wait(3000);
		ClickButton(processSelectedBtn);
		SimulatorUtilities.wait(3000);
		verifyOperationStatus();
		SimulatorUtilities.wait(3000);
		switchToDefaultFrame();
	}
		
	public void processPreProductionBatchNewApplicationForFileUploadForPrepaid(PreProductionBatch batch) {
		String jobID = context.get(CreditConstants.JOB_ID);
		waitForLoaderToDisappear();
		selectDropDownByText(productTypeDDwn, batch.getProductType());
		SimulatorUtilities.wait(5000);
		enterText(sourceJobIdTxt, jobID);
		ClickButton(searchBtn);
		ClickCheckBox(preProductionBatchRecordChkBx, true);
		context.put(CreditConstants.BATCH_NUMBER_FILEUPLOAD, batchNumberFirstRowTxt.getText());
		ClickButton(processSelectedBtn);
		verifyOperationStatus();
		switchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNumberTxt));
	}

}
