package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_DEVICE, CardManagementNav.L3_DEVICE_PRODUCTION_BULK_DEVICE_REQUEST })

@Component
public class BulkDeviceRequestPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(ProgramPage.class);

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBulkDeviceRequestBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement ProgramTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:dropdowncomponent")
	private MCWebElement BranchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "corporateClientCode:input:dropdowncomponent")
	private MCWebElement CorporateClientCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "quantity:input:inputTextField")
	private MCWebElement QuantityRequestedTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePlanCode:input:dropdowncomponent")
	private MCWebElement DevicePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement ConfirmationMsgTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

	public String createBulkDeviceRequest(String productType, String program, String quantityReq) {

		menuSubMenuPage.getBulkDeviceRequest().click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addBulkDeviceRequestBtn);
		switchToIframe(Constants.ADD_BULK_DEVICE_REQUEST_FRAME);
		SelectDropDownByText(ProductTypeDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(BranchDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProgramTypeDDwn, program);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CorporateClientCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DevicePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(QuantityRequestedTxt, quantityReq);
		ClickButton(SaveBtn);
		SwitchToDefaultFrame();
		return getBatchNumber();

	}

	public String getBatchNumber() {
		String strOutputMessage = ConfirmationMsgTxt.getText().split("\\n")[0];
		System.out.println("Request Number " + strOutputMessage);
		// Record Added Successfully, Batch Number is 17149055
		String strOuputMessagePattern = "Record\\s*Added\\d*\\s*Successfully\\s*,\\s*Batch\\s*Number\\s*is\\s*";
		System.out.println("strOuputMessagePattern" + strOuputMessagePattern);
		// Assert.assertTrue("Record Added Successfully",
		// strOutputMessage.matches(strOuputMessagePattern));

		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		// int intIndex = strOutputMessage.indexOf("is");
		// String strRequestNumber = strOutputMessage.substring(43, intIndex +
		// 1);
		System.out.println("Request Number is " + strRequestNumber);
		MapUtils.fnSetInputDataToInputMap("BatchNumber", strRequestNumber);
		return strRequestNumber;

	}

	public void clickAddBulkDeviceRequestBtn() {
		waitForElementVisible(addBulkDeviceRequestBtn);
		clickWhenClickable(addBulkDeviceRequestBtn);
		switchToIframe(Constants.ADD_BULK_DEVICE_REQUEST_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectBranch() {
		waitForLoaderToDisappear();
		SelectDropDownByIndex(BranchDDwn, 1);
	}

	public void selectProgram(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		waitForElementVisible(ProgramTypeDDwn);
		selectByVisibleText(ProgramTypeDDwn, bulkdeviceGenBatch.getProgram());
	}

	public void selectCorporateClientCode() {
		SelectDropDownByIndex(CorporateClientCodeDDwn, 1);
	}

	public void selectDevicePlan(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectByVisibleText(DevicePlanDDwn, bulkdeviceGenBatch.getDevicePlan());
	}

	public void enterQuantityRequested(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		enterValueinTextBox(QuantityRequestedTxt, bulkdeviceGenBatch.getQuantityRequested());
	}

	public void Save() {
		clickWhenClickable(SaveBtn);
		SwitchToDefaultFrame();
	}

	public void addBulkDeviceRequestGeneral(DeviceCreation deviceCreation, BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectProduct(deviceCreation);
		selectBranch();
		selectProgram(bulkdeviceGenBatch);
		selectCorporateClientCode();
	}

	public void selectDevice(BulkDeviceRequestbatch bulkdeviceGenBatch) {
		selectDevicePlan(bulkdeviceGenBatch);
		enterQuantityRequested(bulkdeviceGenBatch);
	}

	public boolean verifyErrorsOnBulkDevicePage() {
		return publishErrorOnPage();
	}

	public void verifyBulkDeviceRequestSuccess() {
		if (!verifyErrorsOnBulkDevicePage()) {
			logger.info("Record Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String checkBatchNumber() {
		String strOutputMessage = ConfirmationMsgTxt.getText().split("\\n")[0];
		return strOutputMessage.replaceAll("[^\\d]", "").trim();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
