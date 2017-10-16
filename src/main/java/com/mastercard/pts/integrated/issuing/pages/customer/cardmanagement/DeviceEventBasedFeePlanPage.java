package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
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
		CardManagementNav.L2DEVICE_CONFIGURATION, CardManagementNav.L3DEVICE_EVENT_BASED_FEE_PLAN })
public class DeviceEventBasedFeePlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceEventBasedFeePlanPage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@Autowired
	DatePicker date;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceEventBasedFeePlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceEventFeePlanCode:input:inputTextField")
	private MCWebElement DeviceEventBasedFeePlanCodeTxt;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public String Calelement = "//td[4]";

	public void ClickAddDeviceEventBasedFeePlan() {
		clickWhenClickable(addDeviceEventBasedFeePlanBtn);
		switchToAddDeviceEventBasedFeeFrame();
	}

	public void switchToAddDeviceEventBasedFeeFrame() {
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
	}

	public String enterDeviceEventBasedFeePlanCode() {
		enterValueinTextBox(DeviceEventBasedFeePlanCodeTxt, CustomUtils.randomNumbers(6));
		return DeviceEventBasedFeePlanCodeTxt.getAttribute("value");
	}

	public String enterDescription() {
		enterValueinTextBox(DescriptionTxt, "Device Event Based Fee plan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectCurrency(DeviceEventBasedFeePlan deviceeventbasedfeeplan) {
		selectByVisibleText(CurrencyDDwn, deviceeventbasedfeeplan.getCurrency());
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public void clickAddDeviceEventBasedFeeDetails() {
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_FRAME);
		clickWhenClickable(addSubDetailsBtn);
		switchToAddDeviceEventBasedFeeDetailsFrame();
	}

	public void switchToAddDeviceEventBasedFeeDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_DEVICE_EVENT_BASED_FEE_DETAILS_FRAME);
	}

	public void selectEffectiveDate(DeviceEventBasedFeePlan deviceeventbasedfeeplan) {
		date.setDate(deviceeventbasedfeeplan.getEffectiveDate());
	}

	public void selectEndDate(DeviceEventBasedFeePlan deviceeventbasedfeeplan) {
		date.setDateCalendar2(deviceeventbasedfeeplan.getEndDate(), Calelement);
	}

	public String addDeviceEventBasedFeePlan(DeviceCreation deviceCreation,
			DeviceEventBasedFeePlan deviceeventbasedfeeplan) {
		String deviceEventPlancode;
		String deviceEventDesc;
		deviceEventPlancode = enterDeviceEventBasedFeePlanCode();
		deviceEventDesc = enterDescription();
		selectProduct(deviceCreation);
		selectCurrency(deviceeventbasedfeeplan);
		clickSaveButton();
		return deviceEventDesc + " " + "[" + deviceEventPlancode + "]";
	}

	public boolean verifyErrorsOnDeviceEventBasedFeePlanPage() {
		return publishErrorOnPage();
	}

	public void verifyDeviceEventBasedFeePlanSuccess() {
		if (!verifyErrorsOnDeviceEventBasedFeePlanPage()) {
			logger.info("Plan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void adddeviceEventBasedFeeDetails(DeviceEventBasedFeePlan deviceeventbasedfeeplan) {
		clickAddDeviceEventBasedFeeDetails();
		selectEffectiveDate(deviceeventbasedfeeplan);
		selectEndDate(deviceeventbasedfeeplan);
		clickSaveButton();
		switchToAddDeviceEventBasedFeeFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
