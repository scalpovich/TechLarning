package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlanDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceEventBasedFeePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceEventFeePlanCode:input:inputTextField")
	private MCWebElement DeviceEventBasedFeePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement Currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[4]//a[contains(text(), 'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
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

	public void addDeviceEventBasedFeePlan() {
		waitForElementVisible(addDeviceEventBasedFeePlan);
		addDeviceEventBasedFeePlan.click();
	}

	public void switchToAddDeviceEventBasedFeeFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
	}

	public String enterDeviceEventBasedFeePlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DeviceEventBasedFeePlanCode, CustomUtils.randomNumbers(6));
		return DeviceEventBasedFeePlanCode.getAttribute("value");
	}

	public String enterDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Device Event Based Fee plan");
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void selectCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(Currency, deviceeventbasedfeeplanDataProvider().getCurrency());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickAddDeviceEventBasedFeeDetails() {
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddDeviceEventBasedFeeDetailsFrame() {
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_DETAILS_FRAME);
	}

	public void selectDate() {
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDateNxtMonth.click();
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		selectEndDate.click();
	}

	public void adddeviceeventbasedfeeplan(String product, String currency) {
		addDeviceEventBasedFeePlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DeviceEventBasedFeePlanCode, CustomUtils.randomNumbers(6));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Device Event Based Fee plan");
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Currency, currency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		adddeviceEventBasedFeeDetails();
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
		ClickButton(save);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();

	}

	public void adddeviceEventBasedFeeDetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_DETAILS_FRAME);
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EffectiveDateNxtMonth.click();
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		selectEndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		// addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void adddeviceeventbasedfeeplanprepaid() {
		addDeviceEventBasedFeePlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// DeviceEventBasedFeePlanCode.sendKeys(env.getProperty("is.dinners.deviceeventbasedfeeplan.DeviceEventBasedFeePlanCode"));
		DeviceEventBasedFeePlanCode.sendKeys(CustomUtils.randomNumbers(6));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.deviceeventbasedfeeplanpr.Description"));
		CustomUtils.ThreadDotSleep(1000);
		ProductType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.deviceeventbasedfeeplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		Currency.getSelect().selectByVisibleText(env.getProperty("is.dinners.deviceeventbasedfeeplanpr.Currency"));
		CustomUtils.ThreadDotSleep(1000);

		save2.click();
		CustomUtils.ThreadDotSleep(2000);

		addSubDetails.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
		CustomUtils.ThreadDotSleep(2000);

		EffectiveDate.click();
		CustomUtils.ThreadDotSleep(2000);
		EffectiveDateNxtMonth.click();

		selectEffectiveDate.click();
		CustomUtils.ThreadDotSleep(2000);
		EndDate.click();

		EndDateNxtMonth.click();
		CustomUtils.ThreadDotSleep(2000);
		selectEndDate.click();
		CustomUtils.ThreadDotSleep(2000);

		save.click();
		// System.out.println("window 16 saved");
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		// System.out.println("window 3 saved");
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}
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