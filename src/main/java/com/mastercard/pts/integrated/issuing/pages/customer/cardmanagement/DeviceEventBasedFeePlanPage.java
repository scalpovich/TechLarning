package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlanDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_EVENT_BASED_FEE_PLAN })
public class DeviceEventBasedFeePlanPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(DeviceEventBasedFeePlanPage.class);

	// main screen locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceEventFeePlanCode']/input")
	private MCWebElement deviceEventFeePlanCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='description']/input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='productType']/select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Search]")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".dataview tbody a")
	private MCWebElement tableRowOneCode;

	// iframe Locators
	@PageElement(findBy = FindBy.ID, valueToFind = "_wicket_window_3")
	private MCWebElement iframeMain;

	@PageElement(findBy = FindBy.ID, valueToFind = "_wicket_window_16")
	private MCWebElement iframeChild;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='w_close']")
	private MCWebElement dialogCloseX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceEventFeePlanCode:input:inputTextField")
	private MCWebElement iframedeviceEventFeePlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement iframedescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement iframeproductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement iframeCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement addDetailsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".dataview tbody a")
	private MCWebElement iframeTableRowOneCode;

	// child iframe locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='deviceEvtFeeEffectiveDate']/..")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='deviceEvtFeeEndDate']/..")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceMntFeeEffectiveDate']//img")
	private MCWebElement effectiveDatedp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceMntFeeEndDate']//img")
	private MCWebElement endDatedp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Record Added Successfully')]")
	private MCWebElement successMessage;

	public void verifyUiOperationStatus() {
		logger.info("Device Event Based Fee Plan");
		verifySearchButton("Search");
	}

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.visibilityOf(deviceEventFeePlanCodeTxt));
	}

	// Methods for Main Screen
	public void addPlan() {
		clickAddNewButton();
	}

	public void enterDeviceEventBasedFeePlanCode(String deviceCode) {
		WebElementUtils.enterText(deviceEventFeePlanCodeTxt, deviceCode);
	}

	public void enterDescription(String descriptionData) {
		WebElementUtils.enterText(descriptionTxt, descriptionData);
	}

	public void selectProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				productType);
	}

	public String getDeviceInformationFromTable() {
		return tableRowOneCode.getText();
	}

	// Methods for Dialog Screen
	public void enterIframeDeviceEventBasedFeePlanCode(String deviceCode) {
		WebElementUtils.enterText(iframedeviceEventFeePlanCodeTxt, deviceCode);
	}

	public String getiframeDeviceInformationFromTable() {
		return iframeTableRowOneCode.getText();
	}

	public void selectIframeCurrency(String currency) {
		WebElementUtils.selectDropDownByVisibleText(iframeCurrency, currency);
	}

	public void enterIframeDescription(String descriptionData) {
		WebElementUtils.enterText(iframedescriptionTxt, descriptionData);
	}

	public void selectIframeProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(iframeproductTypeDDwn,
				productType);
	}

	public void clickIframeDialogCloseX() {
		dialogCloseX.click();
	}

	public boolean validatePlanCreation() {
		return successMessage.getText().equalsIgnoreCase(
				ConstantData.SUCCESS_MESSAGE);
	}

	// Child iframe methods
	public void enterIframeEffectiveDate() {
		effectiveDatedp.click();
	}

	public void enterIframeEndDate() {
		endDatedp.click();
	}

	public void createDeviceEventBasedFeePlan(
			DeviceEventBasedFeePlan deviceEventPlanDataObject) {
		logger.info("Create Device Event Based Fee Plan: {}",
				deviceEventPlanDataObject.getDeviceCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Device Event Based Fee Plan",
				() -> {
					enterIframeDeviceEventBasedFeePlanCode(deviceEventPlanDataObject
							.getDeviceCode());
					enterIframeDescription(deviceEventPlanDataObject
							.getDescription());
					selectIframeProductType(deviceEventPlanDataObject
							.getProductType());
					selectIframeCurrency(deviceEventPlanDataObject
							.getCurrency());
					clickAddDetailsButton();

					deviceEventPlanDataObject
							.getDeviceEventBasedFeePlanDetails().forEach(
									this::addDetails);

					clickSaveButton();
				});

		verifyOperationStatus();
	}

	private void addDetails(DeviceEventBasedFeePlanDetails details) {
		clickAddNewButton();

		runWithinPopup(
				"Add Device Event Based Fee Plan Details",
				() -> {
					WebElementUtils.pickDate(effectiveDateDPkr,
							details.getEffectiveDate());
					WebElementUtils.pickDate(endDateDPkr, details.getEndDate());
					clickSaveButton();
				});

		verifyRecordMarkedForUpdationStatusWarning();
	}

}