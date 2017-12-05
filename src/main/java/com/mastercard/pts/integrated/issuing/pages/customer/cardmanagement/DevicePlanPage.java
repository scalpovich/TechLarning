package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP, CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_PLAN })
public class DevicePlanPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DevicePlanPage.class);
	private static final String STATUS_YES = "Yes";

	@Autowired
	MenuSubMenuPage menuSubMenuPage;
	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;
	
	@Autowired
	private TestContext context;

	public Vendor vendor;
	// main screen locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][1]/input")
	private MCWebElement devicePlanCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][2]/input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][1]/select")
	private MCWebElement associationDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][2]/select")
	private MCWebElement deviceTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a")
	private MCWebElement tableRowOneCode;

	// iframe Locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//iframe[@class='wicket_modal']")
	private MCWebElement iframe;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='w_close']")
	private MCWebElement dialogCloseX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode:input:inputTextField")
	private MCWebElement iframeDevicePlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement iframeDescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement iframeAssociationDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement iframeProductTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceType:input:dropdowncomponent")
	private MCWebElement iframeDeviceTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:serviceCode:refDiv:input:inputTextField")
	private MCWebElement iframeServiceCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deliveryMode:input:dropdowncomponent")
	private MCWebElement iframeDeliveryModeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardTemplatePlanCode:input:dropdowncomponent")
	private MCWebElement iframeDeviceIDGenerationTemplateDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardPackDefaultTmp:input:dropdowncomponent")
	private MCWebElement iframeCardPackIDGenerationTemplateDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customCodeForCardNumber:input:inputTextField")
	private MCWebElement iframeCustomCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceDataTrasmission:input:dropdowncomponent")
	private MCWebElement iframeDeviceDataTransmissionDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:plasticId:input:dropdowncomponent")
	private MCWebElement iframePlasticIdDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pictureCode:input:dropdowncomponent")
	private MCWebElement iframePictureCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:priorityPassInd:checkBoxComponent")
	private MCWebElement iframePriorityPassIndicatorChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:priorityPassIDDefault:input:dropdowncomponent")
	private MCWebElement iframePriorityPassIDTemplateDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:priorityPassExpiryDt:input:inputTextField")
	private MCWebElement iframePriorityPassExpiryInMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:priorityPassVendor:input:dropdowncomponent")
	private MCWebElement iframePriorityPassVendorDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardProductionInd:checkBoxComponent")
	private MCWebElement iframeCardProductionChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardCarrierInd:checkBoxComponent")
	private MCWebElement iframeCourierTrackingChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:manuTrackingInd:checkBoxComponent")
	private MCWebElement iframeManufacturingTrackingChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:personalEmboVendor:input:dropdowncomponent")
	private MCWebElement iframeEmbossingVendorDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvvGenerate:checkBoxComponent")
	private MCWebElement iframePersonalizationGenerateCVVCVCChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvv2Generate:checkBoxComponent")
	private MCWebElement iframePersonalizationGenerateCVV2CVC2Chkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardActivation:multiChoice")
	private MCWebElement iframeActivationModeLst;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfDays:input:inputTextField")
	private MCWebElement iframePersonalizationNoOfDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cafInd:checkBoxComponent")
	private MCWebElement iframePersonalizationCAFChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryFlag:input:dropdowncomponent")
	private MCWebElement iframeExpiryFlagDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:validityIniMonths:input:inputTextField")
	private MCWebElement iframeValidityOnInitialMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryDate:input:inputTextField")
	private MCWebElement iframeExpiryDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Next >']")
	private MCWebElement iframeNextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceEvtFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement iframeBaseDeviceEventBasedPlanDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceMntFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement iframeBaseDeviceJoiningMemberShipPlanDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnLimitPlanCode:input:dropdowncomponent")
	private MCWebElement iframeTransactionLimitPlanDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnSetAftKyc:input:dropdowncomponent")
	private MCWebElement iframeAfterKYCDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnSetBefKyc:input:dropdowncomponent")
	private MCWebElement iframeBeforeKYCDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:emvChipType:input:dropdowncomponent")
	private MCWebElement iframeChipTypeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Finish']")
	private MCWebElement iframeFinishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Record Added Successfully')]")
	private MCWebElement successMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#ecommValues select")
	private MCWebElement cavvCheckLst;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#pinValidationList select")
	private MCWebElement pinValidationLst;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cvv2multilist select")
	private MCWebElement cvcCvvLst;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardExpiration input")
	private MCWebElement expiryDateChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cvcCvvCheck input")
	private MCWebElement cvccCvvChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#ecommAllowed input")
	private MCWebElement ecommAllowedChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cvvGenerate]")
	private MCWebElement generateCVVChk;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cvv2Generate]")
	private MCWebElement generateCVV2Chk;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pinRequired]")
	private MCWebElement pinRequiredChk;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pinLength]")
	private MCWebElement pinLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pinDataTransmission:input:dropdowncomponent")
	private MCWebElement pinDataTransmissionDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pinProductionVendor:input:dropdowncomponent")
	private MCWebElement pinProductionVendorDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pinGenerationOption:input:dropdowncomponent")
	private MCWebElement pinGenerationOptionDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pinRetryLimit]")
	private MCWebElement pinRetryLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:allowRenewal:checkBoxComponent")
	private MCWebElement allowRenewalChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:renewalDeviceTech:input:dropdowncomponent")
	private MCWebElement renwalDeviceTechnologyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:validityOnRenewalMonths:input:inputTextField")
	private MCWebElement validityOnRenewalMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:autoRenewalDays:input:inputTextField")
	private MCWebElement autoRenewalDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:advanceRenewalReport:input:inputTextField")
	private MCWebElement advanceRenewalReportTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:renewalActivationMode:refDiv:input:inputTextField")
	private MCWebElement renewalActivationModeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:newExpiryDateReplace:checkBoxComponent")
	private MCWebElement replacementNewExpiryFlagChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:replaceNoOfDays:input:inputTextField")
	private MCWebElement replacementNoOfDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:validityOnReplaceMonths:input:inputTextField")
	private MCWebElement validityOnReplacementMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:allowInstantCardReplace:checkBoxComponent")
	private MCWebElement allowInstanceDeviceReplaceChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:replacementDeviceTech:input:dropdowncomponent")
	private MCWebElement replacementDeviceTechnologyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:emvIcvvOption:checkBoxComponent")
	private MCWebElement iCVVOptionChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:atcFlag:checkBoxComponent")
	private MCWebElement atcFlagChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:response:input:dropdowncomponent")
	private MCWebElement emvPlanResponseDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:minAtcCounter:input:inputTextField")
	private MCWebElement acceptableBelowATCRangeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxAtcCounter:input:inputTextField")
	private MCWebElement acceptableAboveATCRangeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:allowFallBack:checkBoxComponent")
	private MCWebElement allowFallBackChkBx;
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
		waitForElementVisible(ExpiryFlagDDwn);
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
		PlasticIdDDwn.getSelect().selectByIndex(1);
		//SelectDropDownByIndex(PlasticIdDDwn, 1);
	}

	public void selectPictureCode() {
		PictureCodeDDwn.getSelect().selectByIndex(1);
		//SelectDropDownByIndex(PictureCodeDDwn, 1);
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
		if (!(CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| CardType.MOBILE.contains(deviceplan.getDeviceType())
				|| CardType.ATM_ADMIN.contains(deviceplan.getDeviceType()))) {
			Assert.assertTrue("courier tracking checkbox is enabled", courierTrackingChkBx.isEnabled());
			ClickCheckBox(courierTrackingChkBx, true);
		} else {
			Assert.assertTrue("courier tracking checkbox is disabled for " + deviceplan.getDeviceType(),
					!(courierTrackingChkBx.isEnabled()));
		}
	}

	public void checkManufacturingTracking(DevicePlan deviceplan) {
		if (!(CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				|| CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				|| CardType.MOBILE.contains(deviceplan.getDeviceType())
				|| CardType.ATM_ADMIN.contains(deviceplan.getDeviceType()))) {
			Assert.assertTrue("Manufactoring tracking checkbox dropdown is enabled",
					ManuFactoringTrackingChkBx.isEnabled());
		} else {
			Assert.assertTrue("Manufactoring tracking checkbox disabled for " + deviceplan.getDeviceType(),
					!(ManuFactoringTrackingChkBx.isEnabled()));
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
			waitForElementVisible(CustomCodeTxt);
			enterValueinTextBox(CustomCodeTxt, deviceplan.getCustomCode());
		}
	}

	public void clickNextButton() {
		Scrolldown(NextBtn);
		clickWhenClickable(NextBtn);
	}

	public void selectEventBasedFeePlan() {
		SelectDropDownByIndex(EventBasedFeePlanDDwn, 3);
	}

	public void selectJoiningMembershipFeePlan() {
		SelectDropDownByIndex(MembershipFeePlanDDwn, 3);
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
		enterValueinTextBox(VelocityTxt, deviceplan.getVelocity1());
	}

	public void enterValidity(DevicePlan deviceplan) {
		enterValueinTextBox(ValidityTxt, deviceplan.getValidity1());
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
		//enterCustomCode(deviceplan);
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

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(devicePlanCodeTxt));
	}

	// Methods for Main Screen
	public void verifyUiOperationStatus() {
		logger.info("Device Plan");
		verifySearchButton("Search");
	}

	public void addPlan() {
		clickAddNewButton();
	}

	public void enterDevicePlanCode(String deviceCode) {
		WebElementUtils.enterText(devicePlanCodeTxt, deviceCode);
	}

	public void enterDescription(String descriptionData) {
		WebElementUtils.enterText(descriptionTxt, descriptionData);
	}

	public void selectAssociationDDwn(String associationType) {
		WebElementUtils.selectDropDownByVisibleText(associationDDwn, associationType);
	}

	public void selectDeviceTypeDDwn(String deviceType) {
		WebElementUtils.selectDropDownByVisibleText(deviceTypeDDwn, deviceType);
	}

	public String getDeviceInformationFromTable() {
		return tableRowOneCode.getText();
	}

	// Methods for Dialog Screen
	public void enterIframeDevicePlanCode(String deviceCode) {
		WebElementUtils.enterText(iframeDevicePlanCodeTxt, deviceCode);
	}

	public void enterIframeDescription(String descriptionData) {
		WebElementUtils.enterText(iframeDescriptionTxt, descriptionData);
	}

	public void selectIframeAssociationType(String associationType) {
		WebElementUtils.selectDropDownByVisibleText(iframeAssociationDdwn, associationType);
	}

	public void selectIframeProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(iframeProductTypeDdwn, productType);
	}

	public void selectIframeDeviceType(String deviceType) {
		WebElementUtils.selectDropDownByVisibleText(iframeDeviceTypeDdwn, deviceType);
	}

	public void enterIframeServiceCode(String servicecode) {
		WebElementUtils.enterText(iframeServiceCodeTxt, servicecode);
	}

	public void selectIframeDeliveryMode(String deliveryMode) {
		if (deliveryMode != null) {
			WebElementUtils.selectDropDownByVisibleText(iframeDeliveryModeDdwn, deliveryMode);
		}
	}

	public void selectIframeDeviceIDGenerationTemplate(String deviceIdTemplate) {
		WebElementUtils.selectDropDownByVisibleText(iframeDeviceIDGenerationTemplateDdwn, deviceIdTemplate);
	}

	public void selectIframeCardPackIDGenerationTemplate(String cardPackIdTemplate) {
		WebElementUtils.selectDropDownByVisibleText(iframeCardPackIDGenerationTemplateDdwn, cardPackIdTemplate);
	}

	public void selectIframePlasticIdDdwn(String plasticId) {
		if (plasticId != null) {
			WebElementUtils.selectDropDownByVisibleText(iframePlasticIdDdwn, plasticId);
		}
	}

	public void selectIframePictureCodeDdwn(String pictureCode) {
		if (pictureCode != null) {
			WebElementUtils.selectDropDownByVisibleText(iframePictureCodeDdwn, pictureCode);
		}
	}

	public void enableIframeCardProductionChkbx() {
		iframeCardProductionChkbx.click();
	}

	public void selectIframeEmbossingVendorDdwn(String embossingVendor) {
		WebElementUtils.selectDropDownByVisibleText(iframeEmbossingVendorDdwn, embossingVendor);
	}

	public void selectIframeActivationModeLst(String activationMode) {
		WebElementUtils.selectDropDownByVisibleText(iframeActivationModeLst, activationMode);
	}

	public void selectIframeExpiryFlagDdwn(String expiryFlag) {
		WebElementUtils.selectDropDownByVisibleText(iframeExpiryFlagDdwn, expiryFlag);
	}

	public void enterIframeValidityOnInitialMonthsTxt(String months) {
		WebElementUtils.enterText(iframeValidityOnInitialMonthsTxt, months);
	}

	public void enterIframeExpiryDateTxt(String expiryDate) {
		WebElementUtils.enterText(iframeExpiryDateTxt, expiryDate);
	}

	public void selectIframeBaseDeviceEventBasedPlanDdwn(String baseDeviceEventBasedPlan) {
		if(iframeBaseDeviceEventBasedPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeBaseDeviceEventBasedPlanDdwn, baseDeviceEventBasedPlan);
	}

	public void selectIframeBaseDeviceJoiningMemberShipPlanDdwn(String deviceJoiningMemberShipPlan) {
		if(iframeBaseDeviceJoiningMemberShipPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeBaseDeviceJoiningMemberShipPlanDdwn, deviceJoiningMemberShipPlan);
	}

	public void selectIframeTransactionLimitPlanDdwn(String transactionLimitPlan) {
		if(iframeTransactionLimitPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeTransactionLimitPlanDdwn, transactionLimitPlan);
	}

	public void selectIframeAfterKYCDdwn(String kycType) {
		WebElementUtils.selectDropDownByVisibleText(iframeAfterKYCDdwn, kycType);
	}

	public void selectIframeBeforeKYCDdwn(String kycType) {
		WebElementUtils.selectDropDownByVisibleText(iframeBeforeKYCDdwn, kycType);
	}

	public void selectIframeChipTypeDdwnDdwn(String chipType) {
		WebElementUtils.selectDropDownByVisibleText(iframeChipTypeDdwn, chipType);
	}

	public void clickIframeFinishButton() {
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(iframeFinishBtn)).click();
	}

	public void clickIframeNextButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(iframeNextBtn)).click();
	}

	public void selectAllcavv() {
		WebElementUtils.selectAllOptionsInListBox(cavvCheckLst);
	}

	public void selectAllPinValidation() {
		WebElementUtils.selectAllOptionsInListBox(pinValidationLst);
	}

	public void selectAllcvccvv() {
		WebElementUtils.selectAllOptionsInListBox(cvcCvvLst);
	}

	public void checkExpiryDate() {
		expiryDateChkBx.click();
	}

	public void checkCvcCvv() {
		cvccCvvChkBx.click();
	}

	public void clickIframeDialogCloseX() {
		dialogCloseX.click();
	}

	public boolean validatePlanCreation() {
		return successMessage.getText().equalsIgnoreCase(ConstantData.SUCCESS_MESSAGE);
	}

	public void createDevicePlan(DevicePlan devicePlanDataObject) {
		logger.info("Create Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		clickAddNewButton();

		runWithinPopup("Add Device Plan", () -> {
			enterIframeDevicePlanCode(devicePlanDataObject.getDevicePlanCode());
			enterIframeDescription(devicePlanDataObject.getDescription());
			selectIframeAssociationType(devicePlanDataObject.getAssociation());
			selectIframeProductType(devicePlanDataObject.getProductType());
			selectIframeDeviceType(devicePlanDataObject.getDeviceType());
			enterIframeServiceCode(devicePlanDataObject.getServiceCode());
			selectIframeDeliveryMode(devicePlanDataObject.getDeliveryMode());
			selectIframeDeviceIDGenerationTemplate(devicePlanDataObject.getDeviceIdGenerationTemplate());
			selectIframeCardPackIDGenerationTemplate(devicePlanDataObject.getCardPackIdGenerationTemplate());
			selectIframePlasticIdDdwn(devicePlanDataObject.getPlasticId());
			selectIframePictureCodeDdwn(devicePlanDataObject.getPictureCode());
			selectIframeActivationModeLst(devicePlanDataObject.getActivationMode());
			selectIframeExpiryFlagDdwn(devicePlanDataObject.getExpiryFlag());
			// next steps have been pushed to below method due to SONAR
			// limitation
			createDevicePlanContinuation(devicePlanDataObject);
		});

		verifyOperationStatus();
	}

	private void createDevicePlanContinuation(DevicePlan devicePlan) {

		cvvCvv2PinGenerationSelectionScreen(devicePlan);

		fillDevicePlanPage(devicePlan);

		selectIframeBeforeKYCDdwn(devicePlan.getBeforeKYC());
		selectIframeAfterKYCDdwn(devicePlan.getAfterKYC());
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES))
			selectAllcavv();

		// perform below steps only when pinRequired is true which is the
		// default state
		if("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			selectAllPinValidation();
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES))
			selectAllcvccvv();
		checkExpiryDate();
		if("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			checkCvcCvv();
		WebElementUtils.checkCheckbox(ecommAllowedChkBx, devicePlan.isEcommerceAllowed());

		if (!devicePlan.getDeviceType().equals(DeviceType.STATIC_VIRTUAL_CARD) && "true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())) {
			WebElementUtils.enterText(pinRetryLimitTxt, devicePlan.getPinRetryLimit());
		}
		clickIframeNextButton();
		clickIframeNextButton();

		if (DeviceType.EMV_CARD.equals(devicePlan.getDeviceType()) || DeviceType.PHYSICAL_NFC_DEVICE_EMV_PAYPASS.equals(devicePlan.getDeviceType())) {
			forEmvOrNfc(devicePlan);
		}
		clickIframeFinishButton();
	}

	private void fillDevicePlanPage(DevicePlan devicePlan) {
		selectIframeBaseDeviceEventBasedPlanDdwn(devicePlan.getBaseDeviceEventBasedPlan());
		selectIframeBaseDeviceJoiningMemberShipPlanDdwn(devicePlan.getBaseDeviceJoiningMemberShipPlan());
		selectIframeTransactionLimitPlanDdwn(devicePlan.getTransactionLimitPlan());
		clickIframeNextButton();
	}

	private void cvvCvv2PinGenerationSelectionScreen(DevicePlan devicePlan) {
		generateCVVChk.click();
		generateCVV2Chk.click();
		//filling date when flag is fixed
		if("Fixed [F]".equalsIgnoreCase(devicePlan.getExpiryFlag()))
		{
			enterIframeExpiryDateTxt(devicePlan.getValidityOnInitialMonths());
			// making necessary changes so that this value can be set in the required format so that it can be used when a pinless card is used
			String dateInYYMM = getValueInYYMMFormatForExpiryDate(devicePlan.getValidityOnInitialMonths());
			devicePlan.setExpiryDate(dateInYYMM);
		}
		else
		{
			enterIframeValidityOnInitialMonthsTxt(devicePlan.getValidityOnInitialMonths());
		}
		enableIframeCardProductionChkbx();

		if(iframeEmbossingVendorDdwn.isEnabled())
			selectIframeEmbossingVendorDdwn(devicePlan.getEmbossingVendor());
		if(devicePlan.getFillRenewalSection().equalsIgnoreCase(STATUS_YES))
			fillRenewalSection(devicePlan);
		if (devicePlan.getFillReplacementSection().equalsIgnoreCase(STATUS_YES))
			fillReplacementSection(devicePlan);
		if (!devicePlan.getDeviceType().equals(DeviceType.STATIC_VIRTUAL_CARD))
			fillPinGenerationSection(devicePlan);
		clickIframeNextButton();
	}

	private String getValueInYYMMFormatForExpiryDate(String dateVal) {
		//for format of date to be passed is YYMM .Ex: Input is 10-2022.. output should be 2210
		String [] tempArr = dateVal.split("-");
		String tempVal = dateVal.substring(dateVal.length()-2);		
		return tempVal  + tempArr[0];
	}

	private void forEmvOrNfc(DevicePlan devicePlan) {
		iCVVOptionChkBx.click();
		selectIframeChipTypeDdwnDdwn(devicePlan.getChipType());
		if (devicePlan.getFillEMVPlan().equalsIgnoreCase(STATUS_YES))
		{
			atcFlagChkBx.click();
			WebElementUtils.selectDropDownByVisibleText(emvPlanResponseDdwn,devicePlan.getEmvPlanResponse());
			WebElementUtils.enterText(acceptableBelowATCRangeTxt,devicePlan.getEmvBelowATCRange());
			WebElementUtils.enterText(acceptableAboveATCRangeTxt,devicePlan.getEmvAboveATCRange());
			allowFallBackChkBx.click();
		}
	}

	private void fillPinGenerationSection(DevicePlan devicePlan) {
		// perform below steps only when pinRequired is true which is the
		// default state
		if("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())) {
			WebElementUtils.scrollDown(driver(), 0, 250);
			pinRequiredChk.click();
			WebElementUtils.selectDropDownByVisibleText(pinDataTransmissionDDwn, devicePlan.getPinDataTransmission());
			WebElementUtils.enterText(pinLengthTxt, devicePlan.getPinLength());
			WebElementUtils.selectDropDownByVisibleText(pinProductionVendorDDwn, devicePlan.getEmbossingVendor());
			WebElementUtils.selectDropDownByVisibleText(pinGenerationOptionDDwn, devicePlan.getPinGenerationOption());
		}
	}

	private void fillRenewalSection(DevicePlan devicePlan) {
		allowRenewalChkBx.click();
		WebElementUtils.selectDropDownByVisibleText(renwalDeviceTechnologyDdwn, devicePlan.getDeviceType());
		WebElementUtils.enterText(validityOnRenewalMonthsTxt, devicePlan.getValidityOnRenewalMonths());
		WebElementUtils.enterText(autoRenewalDaysTxt, devicePlan.getAutoRenewalDays());
		WebElementUtils.enterText(advanceRenewalReportTxt, devicePlan.getAdvanceRenewalReport());
		WebElementUtils.enterText(renewalActivationModeTxt, devicePlan.getRenewalActivationMode());
	}

	private void fillReplacementSection(DevicePlan devicePlan) {
		replacementNewExpiryFlagChkBx.click();
		WebElementUtils.enterText(replacementNoOfDaysTxt, devicePlan.getReplacementNoOfDays());
		WebElementUtils.enterText(validityOnReplacementMonthsTxt, devicePlan.getValidityOnReplacementMonths());
		allowInstanceDeviceReplaceChkBx.click();
		if (devicePlan.getReplacementDeviceTechnology() != "")
			WebElementUtils.selectDropDownByVisibleText(replacementDeviceTechnologyDdwn, devicePlan.getReplacementDeviceTechnology());
	}
}