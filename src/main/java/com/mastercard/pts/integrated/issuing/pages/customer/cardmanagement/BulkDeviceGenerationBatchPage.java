package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_BULK_DEVICE_GENERATION_BATCH })
public class BulkDeviceGenerationBatchPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BulkDeviceGenerationBatchPage.class);
	@Autowired
	MenuSubMenuPage menuSubMenuPage;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement branchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement programDDwn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBulkDeviceGenerationBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement batchNumTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productionPanel:BasicDataTable:datatable:body:rows:1:cells:9:cell:columnCheckBox")
	private MCWebElement selectProcessChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value ='Process Selected'][@type= 'submit']")
	private MCWebElement processSelectedBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class = 'repeat']//div[2]//li[2]//span[@class = 'feedbackPanelINFO']")
	private MCWebElement confirmationMsgTxt;

	public void addbulkdevicegenerationbatch(String product, String batchNum) {
		menuSubMenuPage.getBulkDeviceGeneration().click();
		// addWicketAjaxListeners(getFinder().getWebDriver());
		selectDropDownByText(productTypeDDwn, product);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(batchNumTxt, batchNum);
		ClickButton(searchBtn);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(selectProcessChkBx, true);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(processSelectedBtn);
		switchToDefaultFrame();

	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByText(productTypeDDwn, deviceCreation.getProduct());
	}

	public void enterBatchNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(batchNumTxt, bulkdeviceGenBatch.getBatchNumber());
		// enterValueinTextBox(BatchNumTxt, "29465257");
	}

	public void selectBranch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(branchDDwn, bulkdeviceGenBatch.getBranch());
	}

	public void selectProgram(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(programDDwn, bulkdeviceGenBatch.getProgram());
	}

	public void clickSearchBtn() {
		clickWhenClickable(searchBtn);
	}

	public void clickbulkGenerationChkBox(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		// WebElement SelectProcessChkBx =
		// getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
		// + bulkdeviceGenBatch.getBatchNumber()
		// +
		// "')]/following::span/input[@name='productionPanel:BasicDataTable:datatable:body:rows:1:cells:9:cell:columnCheckBox']"));

		clickWhenClickable(selectProcessChkBx);
	}

	public void clickProcessSelectedBtn() {
		clickWhenClickable(processSelectedBtn);
	}

	public void searchBulkDeviceGenBatch(DeviceCreation deviceCreation, BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectProduct(deviceCreation);
		enterBatchNumber(bulkdeviceGenBatch);
		clickSearchBtn();
	}

	public void ProcessSelectedBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		clickbulkGenerationChkBox(bulkdeviceGenBatch);
		clickProcessSelectedBtn();
	}

	public boolean verifyErrorsOnBulkDeviceGenerationPage() {
		return publishErrorOnPage();
	}

	public void verifyBulkDeviceRequestSuccess() {
		if (!verifyErrorsOnBulkDeviceGenerationPage()) {
			logger.info("Bulk device generation batch succesful");
			switchToDefaultFrame();
		} else {
			logger.info("Error in batch");
			switchToDefaultFrame();
		}
	}

	public void processBulkDeviceGenerationBatch(BulkDeviceGenerationBatch batch) {
		logger.info("Bulk Device Generation Batch: {}", batch.getBatchNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumTxt, batch.getBatchNumber());
		clickSearchButton();
		selectFirstRecord();
		clickProcessSelectedButton();
		verifyOperationStatus();
	}

	public void verifyUiOperationStatus() {
		logger.info("Bulk Device Generation Batch");
		verifySearchButton("Search");
	}

	public String checkJobID() {
		String strOutputMessage = confirmationMsgTxt.getText().split("\\n")[0];
		return strOutputMessage.replaceAll("[^\\d]", "").trim();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(batchNumberTxt));
	}

}