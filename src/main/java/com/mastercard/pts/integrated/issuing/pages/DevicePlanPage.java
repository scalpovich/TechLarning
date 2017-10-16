package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DevicePlanPage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(DevicePlanPage.class);

	@Autowired
	MenuSubMenuPage menuSubMenuPage;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddDevicePlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode:input:inputTextField")
	private MCWebElement DevicePlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement AssociationDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceType:input:dropdowncomponent")
	private MCWebElement DeviceTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:serviceCode:refDiv:input:inputTextField")
	private MCWebElement ServiceCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deliveryMode:input:dropdowncomponent")
	private MCWebElement DeliveryModeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardTemplatePlanCode:input:dropdowncomponent")
	private MCWebElement DeviceIDGenerationTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardPackDefaultTmp:input:dropdowncomponent")
	private MCWebElement CardPackIDGenerationTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:plasticId:input:dropdowncomponent")
	private MCWebElement PlasticIdDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pictureCode:input:dropdowncomponent")
	private MCWebElement PictureCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardProductionInd:checkBoxComponent")
	private MCWebElement CardProductionChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:personalEmboVendor:input:dropdowncomponent")
	private MCWebElement EmbossingVendorDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table/tbody/tr[18]/td[2]/span/select/option[1]")
	private MCWebElement ActivationMode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table/tbody/tr[18]/td[2]/span/select/option[6]")
	private MCWebElement ActivationModeonManual;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryFlag:input:dropdowncomponent")
	private MCWebElement ExpiryFlagDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryDate:input:inputTextField")
	private MCWebElement ExpiryDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customCodeForCardNumber:input:inputTextField")
	private MCWebElement CustomCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value ='Next >']")
	private MCWebElement NextBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement Next2Btn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement Next3Btn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement Next4Btn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceEvtFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement EventBasedFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceMntFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement MembershipFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnLimitPlanCode:input:dropdowncomponent")
	private MCWebElement TransactionLimitPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnSetAftKyc:input:dropdowncomponent")
	private MCWebElement TransactionSetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:emvChipType:input:dropdowncomponent")
	private MCWebElement ChipTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:ecommAllowed:checkBoxComponent")
	private MCWebElement EcomChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcPerTxnLimit:input:inputAmountField")
	private MCWebElement PerTranscLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcTotalTxnAmtLimit:input:inputAmountField")
	private MCWebElement TotalTranscLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcTotalVelocity:input:inputTextField")
	private MCWebElement VelocityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcValidity:input:inputTextField")
	private MCWebElement ValidityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement FinishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

	public void adddeviceplan(String devicePlanCodeText, String planDevice, String customCode, String deviceAssoc,
			String prodType, String deviceType, String deviceServiceCode, String deliveryMode,
			String deviceIdGenTemplate, String embossingVendor, String expiryFlag, String expiryDate,
			String perTransLimit, String totalTransLimit, String velocity, String validity) {
		menuSubMenuPage.getDevicePlan().click();
		ClickButton(AddDevicePlanBtn);
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
		enterText(DevicePlanCodeTxt, devicePlanCodeText);
		enterText(DescriptionTxt, planDevice);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(AssociationDDwn, deviceAssoc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DeviceTypeDDwn, deviceType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ServiceCodeTxt, deviceServiceCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DeviceIDGenerationTemplateDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CardPackIDGenerationTemplateDDwn, 1);
		if (deviceType.equalsIgnoreCase("Static Virtual Card [7]")) {
			ClickButton(ActivationModeonManual);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(ExpiryFlagDDwn, expiryFlag);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(ExpiryDateTxt, expiryDate);
		}
		if (deviceType.equalsIgnoreCase("Magnetic Stripe Card [1]")) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(DeliveryModeDDwn, deliveryMode);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByIndex(PlasticIdDDwn, 1);
			SelectDropDownByIndex(PictureCodeDDwn, 1);
			ClickCheckBox(CardProductionChkBx, true);
			SelectDropDownByText(EmbossingVendorDDwn, embossingVendor);
			ClickButton(ActivationModeonManual);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(ExpiryFlagDDwn, expiryFlag);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(ExpiryDateTxt, expiryDate);
		}
		if (deviceType.equalsIgnoreCase("EMV Card [2]")) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(DeliveryModeDDwn, deliveryMode);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByIndex(PlasticIdDDwn, 1);
			SelectDropDownByIndex(PictureCodeDDwn, 1);
			ClickCheckBox(CardProductionChkBx, true);
			SelectDropDownByText(EmbossingVendorDDwn, embossingVendor);
			ClickButton(ActivationModeonManual);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(ExpiryFlagDDwn, expiryFlag);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(ExpiryDateTxt, expiryDate);
		}

		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CustomCodeTxt, customCode);
		ClickButton(NextBtn);
		EnterDetailsFeesTab();
		EnterAuthorizationTabDetails(deviceType, perTransLimit, totalTransLimit, velocity, validity);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			SwitchToDefaultFrame();
		}
	}

	public void adddeviceplanprepaid(String devicePlanCodeText, String prepaidPlanDevice, String customCode,
			String deviceAssoc, String prodType, String deviceType, String deviceServiceCode, String deliveryMode,
			String deviceIdGenTemplate, String embossingVendor, String expiryFlag, String expiryDate,
			String perTransLimit, String totalTransLimit, String velocity, String validity) {
		// addWicketAjaxListeners(getFinder().getWebDriver());
		menuSubMenuPage.getDevicePlan().click();
		ClickButton(AddDevicePlanBtn);
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
		enterText(DevicePlanCodeTxt, devicePlanCodeText);
		enterText(DescriptionTxt, prepaidPlanDevice);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(AssociationDDwn, deviceAssoc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DeviceTypeDDwn, deviceType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ServiceCodeTxt, deviceServiceCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(DeliveryModeDDwn, deliveryMode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DeviceIDGenerationTemplateDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CardPackIDGenerationTemplateDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PlasticIdDDwn, 1);
		SelectDropDownByIndex(PictureCodeDDwn, 1);
		ClickCheckBox(CardProductionChkBx, true);
		SelectDropDownByText(EmbossingVendorDDwn, embossingVendor);
		ClickButton(ActivationModeonManual);
		SelectDropDownByText(ExpiryFlagDDwn, expiryFlag);
		enterText(ExpiryDateTxt, expiryDate);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CustomCodeTxt, customCode);
		ClickButton(NextBtn);
		EnterDetailsFeesTab();
		EnterAuthorizationTabDetails(deviceType, perTransLimit, totalTransLimit, velocity, validity);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			SwitchToDefaultFrame();
		}
	}

	public void EnterDetailsFeesTab() {
		SelectDropDownByIndex(EventBasedFeePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(MembershipFeePlanDDwn, 1);
		SelectDropDownByIndex(TransactionLimitPlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		logger.info("before second next button");
		ClickButton(Next2Btn);
	}

	public void EnterAuthorizationTabDetails(String deviceType, String perTransLimit, String totalTransLimit,
			String velocity, String validity) {
		SelectDropDownByIndex(TransactionSetDDwn, 1);
		if (deviceType.equalsIgnoreCase("Limited Validity Virtual Card [8]")) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickCheckBox(EcomChkBx, true);
			logger.info("before third next button");
			ClickButton(Next3Btn);
			enterText(PerTranscLimitTxt, perTransLimit);
			enterText(TotalTranscLimitTxt, totalTransLimit);
			enterText(VelocityTxt, velocity);
			enterText(ValidityTxt, validity);
			logger.info("before fourth next button");
			ClickButton(Next4Btn);
		}
		if (deviceType.equalsIgnoreCase("Static Virtual Card [7]")) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickCheckBox(EcomChkBx, true);
			logger.info("before third next button");
			ClickButton(Next3Btn);

		}
		if (deviceType.equals("EMV Card [2]")) {
			logger.info("before third next button");
			ClickButton(Next3Btn);
			logger.info("before fourth next button");
			ClickButton(Next4Btn);
			SelectDropDownByIndex(ChipTypeDDwn, 1);
		}
		if (deviceType.equals("Magnetic Stripe Card [1]")) {
			logger.info("before third next button");
			ClickButton(Next3Btn);
			logger.info("before fourth next button");
			ClickButton(Next4Btn);
		}
		logger.info("after fourth next button");
		ClickButton(FinishBtn);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
