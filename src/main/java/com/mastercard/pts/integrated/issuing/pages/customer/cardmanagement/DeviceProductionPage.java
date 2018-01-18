package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION,
		CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_DEVICE_PRODUCTION_BATCH })
public class DeviceProductionPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DeviceProductionPage.class);
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox")
	private MCWebElement deviceProductionBatchRecordChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processSelected")
	private MCWebElement processSelectedBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processAll")
	private MCWebElement processAllBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement actionCodeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement confirmationMsgTxt;

	public void deviceproduction(String prodType, String batchNum, String DeviceNumber) {
		menuSubMenuPage.getDeviceProduction().click();
		SelectDropDownByText(productTypeDDwn, prodType);
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
		WebElementUtils.enterText(batchNumberTxt, batch.getBatchNumber());
		ClickButton(searchBtn);
		if (deviceProductionBatchRecordChkBx.isVisible()) {
			ClickCheckBox(deviceProductionBatchRecordChkBx, true);
		} else {
			ClickButton(searchBtn);
		}
		ClickButton(processSelectedBtn);
		verifyOperationStatus();

	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(productTypeDDwn, deviceCreation.getProduct());
	}

	public void enterBatchNumber(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(batchNumberTxt, bulkdeviceGenBatch.getBatchNumber());
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
		WebElement SelectProcessChkBx = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
				+ bulkdeviceGenBatch.getBatchNumberForDeviceGeneration()
				+ "')]/following::span/input[@name='dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox']"));
		waitForElementVisible(SelectProcessChkBx);
		clickWhenClickable(SelectProcessChkBx);
	}

	public void clickProcessSelectedBtn() {
		clickWhenClickable(processSelectedBtn);
	}

	public void clickProcessAllBtn() {
		clickWhenClickable(processAllBtn);
	}

	public void searchDeviceProductionBatch(DeviceCreation deviceCreation, BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectProduct(deviceCreation);
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
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in batch");
			SwitchToDefaultFrame();
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}