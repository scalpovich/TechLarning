package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningMembershipFeePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2DEVICE_CONFIGURATION, CardManagementNav.L3DEVICE_JOINING_AND_MEMBERSHIP_FEE_PLAN })
public class DeviceJoiningPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceJoiningPage.class);

	@Autowired
	DatePicker date;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceJoiningBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceMaintFeePlanCode:input:inputTextField")
	private MCWebElement MembershipFeePlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement CurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2Btn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement FeeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "postIssuanceFeeOn:input:dropdowncomponent")
	private MCWebElement PostIssuanceFeeOnDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maintFeeBillingCycle:input:dropdowncomponent")
	private MCWebElement PeriodicFrequencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycle:input:inputTextField")
	private MCWebElement NumberofWaiverPeriodTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public String Calelement = "//span[@id = 'deviceMntFeeEndDate']";

	public void clickAddDeviceJoining() {
		clickWhenClickable(addDeviceJoiningBtn);
		switchToAddDeviceJoiningFrame();
	}

	public void switchToAddDeviceJoiningFrame() {
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
	}

	public String enterMembershipFeePlanCode() {
		enterValueinTextBox(MembershipFeePlanCodeTxt, CustomUtils.randomNumbers(6));
		return MembershipFeePlanCodeTxt.getAttribute("value");
	}

	public String enterDescription() {
		enterValueinTextBox(DescriptionTxt, "Retail Prepaid joining and maint fee plan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectCurency(DeviceJoiningMembershipFeePlan devicejoiningmembershipfeeplan) {
		selectByVisibleText(CurrencyDDwn, devicejoiningmembershipfeeplan.getCurrency());
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnDeviceJoiningPage() {
		return publishErrorOnPage();
	}

	public void verifyDeviceJoiningSuccess() {
		if (!verifyErrorsOnDeviceJoiningPage()) {
			logger.info("DeviceJoining Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addDeviceJoiningMembershipPlan(DeviceCreation deviceCreation,
			DeviceJoiningMembershipFeePlan devicejoiningmembershipfeeplan) {
		String devicejoiningplancode;
		String devicejoiningplandesc;
		devicejoiningplancode = enterMembershipFeePlanCode();
		devicejoiningplandesc = enterDescription();
		selectProduct(deviceCreation);
		selectCurency(devicejoiningmembershipfeeplan);
		return devicejoiningplandesc + " " + "[" + devicejoiningplancode + "]";
	}

	public void clickAddDeviceJoiningPlanDetails() {
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_FRAME);
		clickWhenClickable(addSubDetailsBtn);
		switchToAddDeviceJoiningPlanDetailsFrame();

	}

	public void switchToAddDeviceJoiningPlanDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_DEVICE_JOINING_PLAN_DETAILS_FRAME);
	}

	public void selectEffectiveDate(DeviceJoiningMembershipFeePlan deviceJoiningPlan) {
		date.setDate(deviceJoiningPlan.getEffectiveDate());
	}

	public void selectEndDate(DeviceJoiningMembershipFeePlan deviceJoiningPlan) {
		date.setDateCalendar2(deviceJoiningPlan.getEndDate(), Calelement);
	}

	public void selectFeeType(String feeType) {
		selectByVisibleText(FeeTypeDDwn, feeType);
	}

	public void selectPostIssuanceFeeOn() {
		SelectDropDownByIndex(PostIssuanceFeeOnDDwn, 1);
	}

	public void selectPeriodicFrequency() {
		SelectDropDownByIndex(PeriodicFrequencyDDwn, 1);
	}

	public void enterWaiverPeriod(DeviceJoiningMembershipFeePlan deviceJoiningPlan) {
		enterValueinTextBox(NumberofWaiverPeriodTxt, deviceJoiningPlan.getWaiverPeriod());
	}

	public void addDeviceJoiningIssuingPlanDetails(DeviceJoiningMembershipFeePlan deviceJoiningPlan) {
		clickAddDeviceJoiningPlanDetails();
		selectEffectiveDate(deviceJoiningPlan);
		selectEndDate(deviceJoiningPlan);
		selectFeeType(Constants.JOINING_ISSUANCE_FEE);
		selectPostIssuanceFeeOn();
		clickSaveButton();
		switchToAddDeviceJoiningFrame();
	}

	public void addDeviceJoiningMembershipPLanDetails(DeviceJoiningMembershipFeePlan deviceJoiningPlan) {
		clickAddDeviceJoiningPlanDetails();
		selectEffectiveDate(deviceJoiningPlan);
		selectEndDate(deviceJoiningPlan);
		selectFeeType(Constants.MEMBERSHIP_FEE);
		selectPeriodicFrequency();
		enterWaiverPeriod(deviceJoiningPlan);
		clickSaveButton();
		switchToAddDeviceJoiningFrame();
	}

	public boolean verifyErrorsOnDeviceJoiningMembershipPage() {
		return publishErrorOnPage();
	}

	public void verifyDeviceJoiningMembershipSuccess() {
		if (!verifyErrorsOnDeviceJoiningMembershipPage()) {
			logger.info("Device Joining Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}
}
