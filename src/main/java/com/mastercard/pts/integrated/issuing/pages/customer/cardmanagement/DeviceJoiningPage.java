package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningMembershipFeePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2DEVICE_CONFIGURATION, CardManagementNav.L3DEVICE_JOINING_AND_MEMBERSHIP_FEE_PLAN })
public class DeviceJoiningPage extends DeviceJoiningMembershipFeePlan {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceJoining;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceMaintFeePlanCode:input:inputTextField")
	private MCWebElement MembershipFeePlanCode;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[4]//a[contains(text(), 'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/span/table/tbody/tr[5]/td[3]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement FeeType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "postIssuanceFeeOn:input:dropdowncomponent")
	private MCWebElement PostIssuanceFeeOn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maintFeeBillingCycle:input:dropdowncomponent")
	private MCWebElement PeriodicFrequency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycle:input:inputTextField")
	private MCWebElement NumberofWaiverPeriod;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void clickAddDeviceJoining() {
		waitForElementVisible(addDeviceJoining);
		addDeviceJoining.click();
	}

	public void switchToAddDeviceJoiningFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
	}

	public String enterMembershipFeePlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MembershipFeePlanCode, CustomUtils.randomNumbers(6));
		return MembershipFeePlanCode.getAttribute("value");
	}

	public String enterDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Retail Prepaid joining and maint fee plan");
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void selectCurency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(Currency, devicejoiningmembershipfeeplanDataProvider().getCurrency());
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickAddDeviceJoiningPlanDetails() {
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
		waitForElementVisible(addSubDetails);
		addSubDetails.click();
	}

	public void switchToAddDeviceJoiningPlanDetailsFrame() {
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_DETAILS_FRAME);
	}

	public void selectDate() {
		addWicketAjaxListeners(getFinder().getWebDriver());
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

	public void selectFeeType(String feeType) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(FeeType, feeType);
	}

	public void selectPostIssuanceFeeOn() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PostIssuanceFeeOn, 1);
	}

	public void selectPeriodicFrequency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PeriodicFrequency, 1);
	}

	public void enterWaiverPeriod() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(NumberofWaiverPeriod, devicejoiningmembershipfeeplanDataProvider().getWaiverPeriod());
	}

	public void adddevicejoining(String product, String currency) {
		addDeviceJoining.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
		enterText(MembershipFeePlanCode, CustomUtils.randomNumbers(6));
		enterText(Description, "Retail Prepaid joining and maint fee plan");
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Currency, currency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addDeviceJoiningMemPlanDetails();
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addDeviceJoiningMemPlanDetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
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
		SelectDropDownByIndex(FeeType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PostIssuanceFeeOn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);

	}

	public void adddevicejoiningprepaid() {
		addDeviceJoining.click();

		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		//
		// MembershipFeePlanCode.sendKeys(env.getProperty("is.dinners.devicejoining.MembershipFeePlanCode"));
		MembershipFeePlanCode.sendKeys(CustomUtils.randomNumbers(6));
		String memPlanCode = MembershipFeePlanCode.getText();
		Description.sendKeys(env.getProperty("is.dinners.devicejoiningpr.Description"));
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicejoiningpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		Currency.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicejoiningpr.Currency"));
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
		CustomUtils.ThreadDotSleep(2000);
		EndDateNxtMonth.click();
		selectEndDate.click();
		CustomUtils.ThreadDotSleep(2000);
		FeeType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicejoiningpr.FeeType"));
		CustomUtils.ThreadDotSleep(2000);
		PostIssuanceFeeOn.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.devicejoiningpr.PostIssuanceFeeOn"));
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
}
