package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2DEVICE_CONFIGURATION, CardManagementNav.L3DEVICE_PLAN })
public class DevicePlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DevicePlanPage.class);

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	public Vendor vendor;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardCarrierInd:checkBoxComponent")
	private MCWebElement courierTrackingChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:manuTrackingInd:checkBoxComponent")
	private MCWebElement ManuFactoringTrackingChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvvGenerate:checkBoxComponent")
	private MCWebElement GenerateCvvChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvv2Generate:checkBoxComponent")
	private MCWebElement GenerateCvv2ChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cardActivation']//select")
	private MCWebElement ActivationMode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryFlag:input:dropdowncomponent")
	private MCWebElement ExpiryFlagDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryDate:input:inputTextField")
	private MCWebElement ExpiryDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:validityIniMonths:input:inputTextField")
	private MCWebElement ValidityOnInitialMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customCodeForCardNumber:input:inputTextField")
	private MCWebElement CustomCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Next >']")
	private MCWebElement NextBtn;
	/*
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind = "") private
	 * MCWebElement Next2Btn;
	 * 
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind =
	 * "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	 * private MCWebElement Next3Btn;
	 * 
	 * @PageElement(findBy = FindBy.X_PATH, valueToFind =
	 * "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	 * private MCWebElement Next4Btn;
	 */
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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

	public void AddDevicePlan() {
		clickWhenClickable(AddDevicePlanBtn);
		switchToAddDevicePlanFrame();
	}

	public void switchToAddDevicePlanFrame() {
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
	}

	public String enterDevicePlanCode(DevicePlan deviceplan) {
		enterValueinTextBox(DevicePlanCodeTxt, deviceplan.getDevicePlanCode());
		return DevicePlanCodeTxt.getAttribute("value");
	}

	public String enterDescription() {
		enterValueinTextBox(DescriptionTxt, "DevicePlan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectAssociation(DevicePlan deviceplan) {
		selectByVisibleText(AssociationDDwn, deviceplan.getAssociation());
	}

	public void selectproduct(DevicePlan deviceplan) {
		selectByVisibleText(ProductTypeDDwn, deviceplan.getProductType());
	}

	public void selectDeviceType(DevicePlan deviceplan) {
		selectByVisibleText(DeviceTypeDDwn, deviceplan.getDeviceType());
	}

	public void enterServiceCode(DevicePlan deviceplan) {
		enterValueinTextBox(ServiceCodeTxt, deviceplan.getServiceCode());
	}

	public void selectDeviceIDGenerationTemplate() {
		SelectDropDownByIndex(DeviceIDGenerationTemplateDDwn, 1);
	}

	public void selectCardPackGenerationTemplate() {
		SelectDropDownByIndex(CardPackIDGenerationTemplateDDwn, 1);
	}

	public void selectActivationMode(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Card activation Mode dropdown is enabled", ActivationMode.isEnabled());
			selectByText(ActivationMode, deviceplan.getActivationMode());
		} else {
			Assert.assertTrue("Card activation Mode dropdown is disabled", !ActivationMode.isEnabled());
		}
	}

	public void selectExpiryFlag(DevicePlan deviceplan) {
		selectByVisibleText(ExpiryFlagDDwn, deviceplan.getExpiryFlag());
		if (deviceplan.getExpiryFlag().contains("Fixed")) {
			enterValueinTextBox(ExpiryDateTxt, deviceplan.getExpiryDate());
		} else {
			enterValueinTextBox(ValidityOnInitialMonthsTxt, deviceplan.getValidateonInitialMonths());
		}
	}

	public void selectDeliveryMode(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("delivery Mode dropdown is enabled", DeliveryModeDDwn.isEnabled());
			selectByVisibleText(DeliveryModeDDwn, deviceplan.getDeliveryMode());
		} else {
			Assert.assertTrue("delivery Mode dropdown is disabled for " + deviceplan.getDeviceType(),
					!DeliveryModeDDwn.isEnabled());
		}
	}

	public void selectPlasticId() {
		SelectDropDownByIndex(PlasticIdDDwn, 1);
	}

	public void selectPictureCode() {
		SelectDropDownByIndex(PictureCodeDDwn, 1);
	}

	public void selectEmbossingVendor(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			ClickCheckBox(CardProductionChkBx, true);
			Assert.assertTrue("card production checkbox is enabled", CardProductionChkBx.isEnabled());
			waitForLoaderToDisappear();
			Assert.assertTrue("Embossing vendor dropdown is enabled", EmbossingVendorDDwn.isEnabled());
			waitForPageToLoad(getFinder().getWebDriver());
			System.out.println(deviceplan.getEmbossiongVendor());
			selectByVisibleText(EmbossingVendorDDwn, deviceplan.getEmbossiongVendor());
		} else {
			Assert.assertTrue("card production is disabled for " + deviceplan.getDeviceType(),
					!CardProductionChkBx.isEnabled());
			Assert.assertTrue("Embossing vendor dropdown is disabled for " + deviceplan.getDeviceType(),
					!EmbossingVendorDDwn.isEnabled());
		}
	}

	public void checkCourierTracking(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("courier tracking checkbox is enabled", courierTrackingChkBx.isEnabled());
			ClickCheckBox(courierTrackingChkBx, true);
		} else {
			Assert.assertTrue("courier tracking checkbox is disabled for " + deviceplan.getDeviceType(),
					courierTrackingChkBx.isEnabled());
		}
	}

	public void checkManufacturingTracking(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Manufactoring tracking checkbox dropdown is enabled",
					ManuFactoringTrackingChkBx.isEnabled());
		} else {
			Assert.assertTrue("Manufactoring tracking checkbox disabled for " + deviceplan.getDeviceType(),
					ManuFactoringTrackingChkBx.isEnabled());
		}
	}

	public void checkGenerateCVV(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Generate CVV/CVC checkbox is enabled", GenerateCvvChkBx.isEnabled());
		} else {
			Assert.assertTrue("Generate CVV/CVC checkbox is disabled for " + deviceplan.getDeviceType(),
					GenerateCvvChkBx.isEnabled());
		}
	}

	public void checkGenerateCVV2(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Generate CVV2/CVC2 checkbox is enabled", GenerateCvv2ChkBx.isEnabled());
		} else {
			Assert.assertTrue("Generate CVV2/CVC2 checkbox is disabled for " + deviceplan.getDeviceType(),
					GenerateCvv2ChkBx.isEnabled());
		}
	}

	public void enterCustomCode(DevicePlan deviceplan) {
		if (CustomCodeTxt.isEnabled()) {
			enterValueinTextBox(CustomCodeTxt, deviceplan.getCustomCode());
		}
	}

	public void clickNextButton() {
		Scrolldown(NextBtn);
		clickWhenClickable(NextBtn);
	}

	public void selectEventBasedFeePlan() {
		SelectDropDownByIndex(EventBasedFeePlanDDwn, 1);
	}

	public void selectJoiningMembershipFeePlan() {
		SelectDropDownByIndex(MembershipFeePlanDDwn, 1);
	}

	public void selectTransactionLimitPlan() {
		SelectDropDownByIndex(TransactionLimitPlanDDwn, 1);
	}

	public void next() {
		logger.info("before second next button");
		clickWhenClickable(NextBtn);
	}

	public void selectAfterKYC() {
		SelectDropDownByIndex(TransactionSetDDwn, 1);
	}

	public void clickEcomCheckBox() {
		ClickCheckBox(EcomChkBx, true);
	}

	public void clickGenerateCvv() {
		ClickCheckBox(GenerateCvvChkBx, true);
	}

	public void clickGenerateCvv2() {
		ClickCheckBox(GenerateCvv2ChkBx, true);
	}

	public void clickNext3Button() {
		logger.info("before third next button");
		clickWhenClickable(NextBtn);
	}

	public void enterPerTransactionLimit(DevicePlan deviceplan) {
		enterValueinTextBox(PerTranscLimitTxt, deviceplan.getPerTransactionLimit());
	}

	public void enterTotalTransactionLimit(DevicePlan deviceplan) {
		enterValueinTextBox(TotalTranscLimitTxt, deviceplan.getTotalTransactionLimit());
	}

	public void enterVelocity(DevicePlan deviceplan) {
		enterValueinTextBox(VelocityTxt, deviceplan.getVelocity());
	}

	public void enterValidity(DevicePlan deviceplan) {
		enterValueinTextBox(ValidityTxt, deviceplan.getValidity());
	}

	public void clickNext4Button() {
		logger.info("before fourth next button");
		clickWhenClickable(NextBtn);
	}

	public void selectChipType() {
		SelectDropDownByIndex(ChipTypeDDwn, 1);
	}

	public void Finish() {
		logger.info("after fourth next button");
		clickWhenClickable(FinishBtn);
	}

	public String provideGeneralDetails(DevicePlan deviceplan) {
		String devicePlan;
		devicePlan = enterDevicePlanCode(deviceplan);
		enterDescription();
		selectAssociation(deviceplan);
		selectproduct(deviceplan);
		selectDeviceType(deviceplan);
		enterServiceCode(deviceplan);
		selectDeliveryMode(deviceplan);
		return devicePlan;
	}

	public void deviceNumberGeneration(DevicePlan deviceplan) {
		selectDeviceIDGenerationTemplate();
		selectCardPackGenerationTemplate();
		waitForLoaderToDisappear();
		waitForPageToLoad(getFinder().getWebDriver());
		enterCustomCode(deviceplan);
		selectPlasticId();
		waitForPageToLoad(getFinder().getWebDriver());
		selectPictureCode();
	}

	public void personalization(DevicePlan deviceplan) {
		selectEmbossingVendor(deviceplan);
		checkCourierTracking(deviceplan);
		checkManufacturingTracking(deviceplan);
		checkGenerateCVV(deviceplan);
		checkGenerateCVV2(deviceplan);
		selectActivationMode(deviceplan);
		selectExpiryFlag(deviceplan);
		Scrolldown(NextBtn);
		ClickButton(NextBtn);
	}

	public void TransactionFeeAndLimitPlans() {
		selectEventBasedFeePlan();
		selectJoiningMembershipFeePlan();
		selectTransactionLimitPlan();
	}

	public void provideAuthorizationDetails(DevicePlan deviceplan) {
		selectAfterKYC();
		if (CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| CardType.ATM_ADMIN.contains(deviceplan.getDeviceType())) {
			clickEcomCheckBox();
		}
	}

	/*
	 * public void EnterAuthorizationTabDetails(String deviceType, String
	 * perTransLimit, String totalTransLimit, String velocity, String validity)
	 * { SelectDropDownByIndex(TransactionSetDDwn, 1); if (deviceType
	 * .equalsIgnoreCase(Constants.LimitedValidityVirtualCard_String)) {
	 * addWicketAjaxListeners(getFinder().getWebDriver());
	 * ClickCheckBox(EcomChkBx, true); logger.info("before third next button");
	 * ClickButton(Next3Btn); enterText(PerTranscLimitTxt, perTransLimit);
	 * enterText(TotalTranscLimitTxt, totalTransLimit); enterText(VelocityTxt,
	 * velocity); enterText(ValidityTxt, validity);
	 * logger.info("before fourth next button"); ClickButton(Next4Btn); } if
	 * (deviceType.equalsIgnoreCase(Constants.StaticVirtualCard_String)) {
	 * addWicketAjaxListeners(getFinder().getWebDriver());
	 * ClickCheckBox(EcomChkBx, true); logger.info("before third next button");
	 * ClickButton(Next3Btn);
	 * 
	 * } if (deviceType.equals(Constants.EmvCard_String)) {
	 * logger.info("before third next button"); ClickButton(Next3Btn);
	 * logger.info("before fourth next button"); ClickButton(Next4Btn);
	 * SelectDropDownByIndex(ChipTypeDDwn, 1); } // if
	 * (deviceType.equals("Magnetic Stripe Card [1]")) {
	 * logger.info("before third next button"); ClickButton(Next3Btn);
	 * logger.info("before fourth next button"); ClickButton(Next4Btn); // }
	 * logger.info("after fourth next button"); ClickButton(FinishBtn); }
	 */

	public boolean verifyErrorsOnDevicePlanPage() {
		return publishErrorOnPage();
	}

	public void verifyNewDevicePlanSuccess() {
		if (!verifyErrorsOnDevicePlanPage()) {
			logger.info("Device Plan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Device plan Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

}
