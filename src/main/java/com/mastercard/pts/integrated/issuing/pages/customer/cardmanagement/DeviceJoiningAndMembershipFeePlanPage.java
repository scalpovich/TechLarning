package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlanDetails;
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
		CardManagementNav.L3_DEVICE_JOINING_AND_MEMBERSHIP_FEE_PLAN })
public class DeviceJoiningAndMembershipFeePlanPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(DeviceJoiningAndMembershipFeePlanPage.class);

	// main screen locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceMaintFeePlanCode']/input")
	private MCWebElement deviceJoiningMembershipFeePlanCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='description']/input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='productType']/select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Search]")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a")
	private MCWebElement tableRowOneCode;

	// iframe Locators
	@PageElement(findBy = FindBy.ID, valueToFind = "_wicket_window_3")
	private MCWebElement iframeMain;

	@PageElement(findBy = FindBy.ID, valueToFind = "_wicket_window_16")
	private MCWebElement iframeChild;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='w_close']")
	private MCWebElement dialogCloseX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceMaintFeePlanCode:input:inputTextField")
	private MCWebElement iframedeviceJoiningMembershipFeePlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement iframedescriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement iframeproductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement iframeCurrency;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a")
	private MCWebElement iframeTableRowOneCode;

	// child iframe locators
	@PageElement(findBy = FindBy.ID, valueToFind = "deviceMntFeeEffectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.ID, valueToFind = "deviceMntFeeEndDate")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceMntFeeEffectiveDate']//img")
	private MCWebElement effectiveDatedp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='deviceMntFeeEndDate']//img")
	private MCWebElement endDatedp;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement feeTypeddwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "postIssuanceFeeOn:input:dropdowncomponent")
	private MCWebElement postIssuanceFeeOnDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Record Added Successfully')]")
	private MCWebElement successMessage;

	public void verifyUiOperationStatus() {
		logger.info("Device Joining and Membership Fee Plan");
		verifySearchButton("Search");
	}

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.visibilityOf(deviceJoiningMembershipFeePlanCodeTxt));
	}

	// Methods for Main Screen
	public void addPlan() {
		clickAddNewButton();
	}

	public void enterDeviceJoiningMembershipFeePlanCode(String deviceCode) {
		WebElementUtils.enterText(deviceJoiningMembershipFeePlanCodeTxt,
				deviceCode);
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

	public void selectIframeCurrency(String currency) {
		WebElementUtils.selectDropDownByVisibleText(iframeCurrency, currency);
	}

	// Methods for Dialog Screen
	public void enterIframeDeviceJoiningMembershipFeePlanCode(String deviceCode) {
		WebElementUtils.enterText(iframedeviceJoiningMembershipFeePlanCodeTxt,
				deviceCode);
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

	public String getiframeDeviceInformationFromTable() {
		return iframeTableRowOneCode.getText();
	}

	// Child iframe methods
	public void enterIframeEffectiveDate() {
		effectiveDatedp.click();
	}

	public void enterIframeEndDate() {
		endDatedp.click();
	}

	public void selectIframeFeeType(String feeType) {
		WebElementUtils.selectDropDownByVisibleText(feeTypeddwn, feeType);
	}

	public void selectIframePostIssuanceFeeOn(String postIssuanceFeeOn) {
		WebElementUtils.selectDropDownByVisibleText(postIssuanceFeeOnDdwn, postIssuanceFeeOn);
	}

	public boolean validatePlanCreation() {
		return successMessage.getText().equalsIgnoreCase(ConstantData.SUCCESS_MESSAGE);
	}

	public void createDeviceJoiningOrMembershipFeePlan(
			DeviceJoiningAndMemberShipFeePlan devicePlanDataObject) {
		logger.info("Create Device Joining Or Membership Fee Plan: {}", devicePlanDataObject.getDeviceCode());
		clickAddNewButton();

		runWithinPopup("Add Device Joining Or Membership Fee Plan", () -> {
			enterIframeDeviceJoiningMembershipFeePlanCode(devicePlanDataObject.getDeviceCode());
			enterIframeDescription(devicePlanDataObject.getDescription());
			selectIframeProductType(devicePlanDataObject.getProductType());
			selectIframeCurrency(devicePlanDataObject.getCurrency());
			clickAddDetailsButton();

			devicePlanDataObject.getDeviceJoiningAndMemberShipFeePlanDetails().forEach(this::addDetails);

			clickSaveButton();
		});

		verifyOperationStatus();
	}

	private void addDetails(DeviceJoiningAndMemberShipFeePlanDetails details) {
		clickAddNewButton();

		runWithinPopup(
				"Add Device Joining And Membership Fee Plan Details", () -> {
					WebElementUtils.pickDate(effectiveDateDPkr, details.getEffectiveDate());
					WebElementUtils.pickDate(endDateDPkr, details.getEndDate());
					selectIframeFeeType(details.getFeeType());
					selectIframePostIssuanceFeeOn(details.getPostIssuanceFeeOn());
					clickSaveButton();
				});

		verifyRecordMarkedForUpdationStatusWarning();
	}

}
