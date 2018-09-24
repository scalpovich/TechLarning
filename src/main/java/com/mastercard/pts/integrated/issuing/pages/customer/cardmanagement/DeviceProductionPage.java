package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_DEVICE_PRODUCTION_BATCH })
public class DeviceProductionPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DeviceProductionPage.class);
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Autowired
	TestContext context;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDD;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchNumber]")
	private MCWebElement batchNumberText;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Product Type')]//following-sibling::td[2]//select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='batchNumber']")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cardNumber']")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox")
	private MCWebElement deviceProductionBatchRecordChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processSelected")
	private MCWebElement processSelectedBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processAll")
	private MCWebElement processAllBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Action Code')]//following-sibling::td[2]//select")
	private MCWebElement actionCodeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement confirmationMsgTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr[@class!='headers' and @class!='navigation'][1]/td[2]/span")
	private MCWebElement deviceNumberFetch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr")
	private MCWebElements rowSize;

	public void deviceproduction(String prodType, String batchNum, String DeviceNumber) {
		menuSubMenuPage.getDeviceProduction().click();
		selectDropDownByText(productTypeDDwn, prodType);
		if (batchNum != null) {
			enterText(batchNumberTxt, batchNum);
		}

		if (DeviceNumber != null) {
			enterText(deviceNumberTxt, DeviceNumber);
		}
		ClickButton(searchBtn);

		if (deviceProductionBatchRecordChkBx.isVisible()) {
			ClickCheckBox(deviceProductionBatchRecordChkBx, true);
		} else {
			ClickButton(searchBtn);
			CustomUtils.ThreadDotSleep(10000);
		}
		ClickButton(processSelectedBtn);

	}

	public void processDeviceProductionBatch(DeviceProductionBatch batch) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		waitAndSearchForRecordToExist();
		verifyOperationStatus();

	}

	public void processDeviceProductionBatchForAll(DeviceProductionBatch batch) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		waitAndSearchForRecordToExist();
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();

	}
	
	public void processDeviceProductionBatchForAllForFileUpload(DeviceProductionBatch batch) {
		List<String> batchNumbers = context.get(CreditConstants.ALL_BATCH_NUMBERS_PREPRODUCTION);
		waitForLoaderToDisappear();
		WebElementUtils.selectDropDownByVisibleText(productTypeDD, batch.getProductType());
		WebElementUtils.enterText(batchNumberText, batchNumbers.get(0));
		waitAndSearchForRecordToAppear();
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
	}

	public void processDeviceProductionBatchForAllForFileUploadForPrepaid(DeviceProductionBatch batch) {
		String batchNumber = context.get(CreditConstants.BATCH_NUMBER_FILEUPLOAD);
		waitForLoaderToDisappear();
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt,batchNumber);
		waitAndSearchForRecordToAppear();
		clickWhenClickable(processAllBtn);
		verifyOperationStatus();
	}
	
	public void selectProduct(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(productTypeDDwn, bulkdeviceGenBatch.getProduct());
	}

	public void enterBatchNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(batchNumberTxt, bulkdeviceGenBatch.getBatchNumberForDeviceProduction());
	}

	public void enterDeviceNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(deviceNumberTxt, bulkdeviceGenBatch.getDeviceNumber());
	}

	public void selectActionCode(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(actionCodeDDwn, bulkdeviceGenBatch.getActionCode());
	}

	public void search() {
		clickWhenClickable(searchBtn);
	}

	public void clickDeviceProductionChkBox(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		// WebElement SelectProcessChkBx =
		// getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
		// + bulkdeviceGenBatch.getBatchNumberForDeviceGeneration()
		// +
		// "')]/following::span/input[@name='dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox']"));
		waitForElementVisible(deviceProductionBatchRecordChkBx);
		clickWhenClickable(deviceProductionBatchRecordChkBx);
	}

	public void clickProcessSelectedBtn() {
		clickWhenClickable(processSelectedBtn);
	}

	public void clickProcessAllBtn() {
		clickWhenClickable(processAllBtn);
	}

	public void searchDeviceProductionBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectProduct(bulkdeviceGenBatch);
		enterBatchNumber(bulkdeviceGenBatch);
		search();
	}

	public void ProcessSelectedBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		clickDeviceProductionChkBox(bulkdeviceGenBatch);
		clickProcessSelectedBtn();
	}

	public void ProcessAllBatch(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		clickProcessAllBtn();
	}

	public boolean verifyErrorsOnDeviceProductionPage() {
		return publishErrorOnPage();
	}

	public void verifyDeviceProductionRequestSuccess() {
		if (!verifyErrorsOnDeviceProductionPage()) {
			logger.info("Device-Production batch succesful");
			switchToDefaultFrame();
		} else {
			logger.info("Error in batch");
			switchToDefaultFrame();
		}
	}

	public String checkDeviceProductionJobID() {
		String strOutputMessage = confirmationMsgTxt.getText().split("\\n")[0];
		return strOutputMessage.replaceAll("[^\\d]", "").trim();

	}

	public String getDeviceNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		WebElement SelectProcessChkBx = getFinder().getWebDriver().findElement(By.xpath("//tr[1]//td[contains(.,'"
				+ bulkdeviceGenBatch.getBatchNumberForDeviceGeneration() + "')]/preceding-sibling::td[3]"));
		return SelectProcessChkBx.getText().substring(9);
	}

	public void processDeviceProductionBatchNewApplication(DeviceProductionBatch batch) {
		String batchNumber = context.get(CreditConstants.NEW_APPLICATION_BATCH);
		WebElementUtils.enterText(batchNumberTxt,batchNumber);
		waitForRecordAndAssignDevice();
		verifyOperationStatus();
	}

	public void processDeviceProductionBatchNewDevice(DeviceProductionBatch batch) {
		Device device = context.get(ContextConstants.DEVICE);
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt, device.getBatchNumber());
		waitAndSearchForRecordToExist();
		verifyOperationStatus();
	}
	
	public void processDeviceProductionBatchNewDeviceSupplementary(DeviceProductionBatch batch) {		
		String batchNumber = context.get(CreditConstants.PRIMARY_BATCH_NUMBER);
		selectByVisibleText(productTypeDDwn, batch.getProductType());
		WebElementUtils.enterText(batchNumberTxt, batchNumber);		
		waitAndSearchForRecordToExistForSupplementary();
		verifyOperationStatus();
	}
   
	protected void waitForRecordAndAssignDevice() {
		waitAndSearchForRecordToAppear();
		context.put(CreditConstants.EXISTING_DEVICE_NUMBER, deviceNumberFetch.getText());
		context.put(CreditConstants.DEVICE_NUMBER, deviceNumberFetch.getText());
		selectFirstRecord();
		clickProcessSelectedButton();		
	public int deviceNumberHeaderIndexFetch() {
		int index = 0;
		for (int i = 0; i < deviceNumberHeaderTxt.getElements().size(); i++) {
			if (deviceNumberHeaderTxt.getElements().get(i).getText().equals("Device Number")) {
				index = i;
			}
		}
		return index + 1;
	}
	
	public List<String> deviceNumbers() {
		List<WebElement> allDeviceNumbers = new ArrayList<>();
		List<String> allDeviceNumberfText = new ArrayList<>();
		String deviceNumberToFetch="//table[@class='dataview']//tr[@class='even' or 'odd']/td["+deviceNumberHeaderIndexFetch()+"]/span";
		allDeviceNumbers = Elements(deviceNumberToFetch);

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}
}