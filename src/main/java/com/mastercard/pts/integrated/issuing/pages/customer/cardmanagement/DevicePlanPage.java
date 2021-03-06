package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION, CardManagementNav.L3_DEVICE_PLAN })
public class DevicePlanPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DevicePlanPage.class);
	private static final String STATUS_YES = "Yes";
	private static final String STATUS_NO = "No";
	private static final String MAIL = "Mail [2]";

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@Autowired
	private TestContext context;
	
	@Autowired
	private DBUtility dbUtils;

	public Vendor vendor;
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnFeePlanCode:input:dropdowncomponent")
	private MCWebElement iframeTransactionFeePlanDdwn;

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
	private MCWebElement renewalDeviceTechnologyDdwn;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:serviceCode:refDiv:input:inputTextField")
	private MCWebElement serviceCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deliveryMode:input:dropdowncomponent")
	private MCWebElement deliveryModeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardTemplatePlanCode:input:dropdowncomponent")
	private MCWebElement deviceIDGenerationTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardPackDefaultTmp:input:dropdowncomponent")
	private MCWebElement cardPackIDGenerationTemplateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:plasticId:input:dropdowncomponent")
	private MCWebElement plasticIdDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pictureCode:input:dropdowncomponent")
	private MCWebElement pictureCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardProductionInd:checkBoxComponent")
	private MCWebElement cardProductionChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:personalEmboVendor:input:dropdowncomponent")
	private MCWebElement embossingVendorDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardCarrierInd:checkBoxComponent")
	private MCWebElement courierTrackingChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:manuTrackingInd:checkBoxComponent")
	private MCWebElement manuFactoringTrackingChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvvGenerate:checkBoxComponent")
	private MCWebElement generateCvvChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvv2Generate:checkBoxComponent")
	private MCWebElement generateCvv2ChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cardActivation']//select")
	private MCWebElement activationMode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryFlag:input:dropdowncomponent")
	private MCWebElement expiryFlagDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:expiryDate:input:inputTextField")
	private MCWebElement expiryDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:validityIniMonths:input:inputTextField")
	private MCWebElement validityOnInitialMonthsTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customCodeForCardNumber:input:inputTextField")
	private MCWebElement customCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Next >']")
	public MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceEvtFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement eventBasedFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceMntFeePlanCodeCard1:input:dropdowncomponent")
	private MCWebElement membershipFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnFeePlanCode:input:dropdowncomponent")
	private MCWebElement iframeTransactionFee;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnLimitPlanCode:input:dropdowncomponent")
	private MCWebElement transactionLimitPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnSetAftKyc:input:dropdowncomponent")
	private MCWebElement transactionSetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:emvChipType:input:dropdowncomponent")
	private MCWebElement chipTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:ecommAllowed:checkBoxComponent")
	private MCWebElement ecomChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcPerTxnLimit:input:inputAmountField")
	private MCWebElement perTranscLimitTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#pinChangeTnxFirst input")
	private MCWebElement pinChangeTransactionFirstChbx;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#crossBorderTxnCheck input")
	private MCWebElement crossBorderTransaction;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#crossBorderTxnCheckTime input")
	private MCWebElement timeIntervalCrossBorder;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:virtualDeviceCreditLimit:input:inputTextField")
	private MCWebElement virtualDeviceCrediLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcTotalTxnAmtLimit:input:inputAmountField")
	private MCWebElement totalTranscLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcTotalVelocity:input:inputTextField")
	private MCWebElement velocityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lvcValidity:input:inputTextField")
	private MCWebElement validityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement panelErrorTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement panelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:issueDevicePair:checkBoxComponent")
	private MCWebElement issuePairDevicesChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:intTxnAllowed:checkBoxComponent")
	private MCWebElement intTxnAllowedChkBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=devicePlanCode]")
	private MCWebElement devicePlanCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Authorization']")
	private MCWebElement authorizationTab;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:virtualDeviceCreditLimit:input:inputTextField")	
	private MCWebElement virtualDeviceCreditLimitTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopListFlag:checkBoxComponent")
	private MCWebElement stoplistFlagChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:issuerScripting:checkBoxComponent")	
	private MCWebElement issuerScriptingChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:ucol:input:inputAmountField")	
	private MCWebElement ucol;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:ucota:input:inputAmountField")	
	private MCWebElement ucota;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:lcol:input:inputAmountField")	
	private MCWebElement lcol;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:lcota:input:inputAmountField")	
	private MCWebElement lcota;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:applicationBlock:checkBoxComponent")	
	private MCWebElement applicationBlockChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:applicationUnblock:checkBoxComponent")	
	private MCWebElement applicationUnblockChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:putData:checkBoxComponent")	
	private MCWebElement putDataChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:pinChange:checkBoxComponent")	
	private MCWebElement pinChangeChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:pinUnblock:checkBoxComponent")	
	private MCWebElement pinUnblockChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:appBlockPriority:input:dropdowncomponent")	
	private MCWebElement applicationBlockPriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:appUnblockPriority:input:dropdowncomponent")	
	private MCWebElement applicationUnblockPriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:putDataPriority:input:dropdowncomponent")	
	private MCWebElement putDataPriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:pinChangePriority:input:dropdowncomponent")	
	private MCWebElement pinChangePriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="view:pinUnblockPriority:input:dropdowncomponent")	
	private MCWebElement pinUnblockPriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="presentmentTimeLimit:input:inputTextField")	
	private MCWebElement txtPresentmentTimeLimit;
	
	public void AddDevicePlan() {
		clickWhenClickable(AddDevicePlanBtn);
		switchToAddDevicePlanFrame();
	}

	public void switchToAddDevicePlanFrame() {
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
	}

	public String enterDevicePlanCode(DevicePlan devicePlan) {
		if (devicePlan.getDevicePlanCode().length() != 0) {
			enterValueinTextBox(iframeDevicePlanCodeTxt, devicePlan.getDevicePlanCode());
		} else {
			enterValueinTextBox(iframeDevicePlanCodeTxt, CustomUtils.randomNumbers(2));
		}
		return iframeDevicePlanCodeTxt.getAttribute("value");
	}

	public String enterDescription(DevicePlan deviceplan) {
		if (deviceplan.getDescription().length() != 0) {
			enterValueinTextBox(iframeDescriptionTxt, deviceplan.getDescription());
		} else {
			enterValueinTextBox(iframeDescriptionTxt, "DevicePlan");
		}
		deviceplan.setDescription(iframeDescriptionTxt.getAttribute("value"));
		return iframeDescriptionTxt.getAttribute("value");
	}

	public void selectAssociation(DevicePlan deviceplan) {
		selectByVisibleText(iframeAssociationDdwn, deviceplan.getAssociation());
	}

	public void selectproduct(DevicePlan deviceplan) {
		selectByVisibleText(iframeProductTypeDdwn, deviceplan.getProductType());
	}

	public void selectDeviceType(DevicePlan deviceplan) {
		selectByVisibleText(iframeDeviceTypeDdwn, deviceplan.getDeviceType());
	}

	public void enterServiceCode(DevicePlan deviceplan) {
		enterValueinTextBox(iframeServiceCodeTxt, deviceplan.getServiceCode());
	}

	public void selectDeviceIDGenerationTemplate() {
		selectDropDownByIndex(iframeDeviceIDGenerationTemplateDdwn, 1);
	}

	public void selectCardPackGenerationTemplate() {
		selectDropDownByIndex(iframeCardPackIDGenerationTemplateDdwn, 1);
	}

	public void selectActivationMode(DevicePlan deviceplan) {
		if (!CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType()) ) {
			Assert.assertTrue("Card activation Mode dropdown is enabled", activationMode.isEnabled());
			selectByText(activationMode, deviceplan.getActivationMode());
		} else {
			Assert.assertTrue("Card activation Mode dropdown is disabled", !activationMode.isEnabled());
		}
	}

	public void selectExpiryFlag(DevicePlan deviceplan) {
		selectByVisibleText(expiryFlagDDwn, deviceplan.getExpiryFlag());
		if (deviceplan.getExpiryFlag().contains("Fixed")) {
			enterValueinTextBox(expiryDateTxt, deviceplan.getExpiryDate());
		} else {
			enterValueinTextBox(validityOnInitialMonthsTxt, deviceplan.getValidateonInitialMonths());
		}
	}

	public void selectDeliveryMode(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType()) 
				&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("delivery Mode dropdown is enabled", deliveryModeDDwn.isEnabled());
			selectByVisibleText(deliveryModeDDwn, deviceplan.getDeliveryMode());
		} else {
			Assert.assertTrue("delivery Mode dropdown is disabled for " + deviceplan.getDeviceType(),
					!deliveryModeDDwn.isEnabled());
		}
	}

	public void selectPlasticId() {
		plasticIdDDwn.getSelect().selectByIndex(1);
	}

	public void selectPictureCode() {
		pictureCodeDDwn.getSelect().selectByIndex(1);
	}

	public void clickissuePairDevices() {
		ClickCheckBox(issuePairDevicesChkBx, true);
	}

	public void selectEmbossingVendor(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			ClickCheckBox(cardProductionChkBx, true);
			Assert.assertTrue("card production checkbox is enabled", cardProductionChkBx.isEnabled());
			waitForLoaderToDisappear();
			Assert.assertTrue("Embossing vendor dropdown is enabled", embossingVendorDDwn.isEnabled());
			selectByVisibleText(embossingVendorDDwn, deviceplan.getEmbossiongVendor());
		} else {
			Assert.assertTrue("card production is disabled for " + deviceplan.getDeviceType(),
					!cardProductionChkBx.isEnabled());
			Assert.assertTrue("Embossing vendor dropdown is disabled for " + deviceplan.getDeviceType(),
					!embossingVendorDDwn.isEnabled());
		}
	}

	public void checkCourierTracking(DevicePlan deviceplan) {
		if (deviceplan.getProductType().equalsIgnoreCase(ProductType.Debit)) {
			if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
					&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
					&& !CardType.MOBILE.contains(deviceplan.getDeviceType())
					&& !CardType.ATM_ADMIN.contains(deviceplan.getDeviceType())) {
				Assert.assertTrue("courier tracking checkbox is enabled", courierTrackingChkBx.isEnabled());
			}
		} else if (deviceplan.getProductType().equalsIgnoreCase(ProductType.Prepaid)
				|| deviceplan.getProductType().equalsIgnoreCase(ProductType.Credit)) {
			if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
					&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
					&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
				Assert.assertTrue("courier tracking checkbox is enabled", courierTrackingChkBx.isEnabled());
			}
			ClickCheckBox(courierTrackingChkBx, true);
		} else {
			Assert.assertTrue("courier tracking checkbox is disabled for " + deviceplan.getDeviceType(),
					!(courierTrackingChkBx.isEnabled()));
		}
	}

	public void checkManufacturingTracking(DevicePlan deviceplan) {
		if (deviceplan.getProductType().equalsIgnoreCase(ProductType.Debit)) {
			if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
					&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
					&& !CardType.MOBILE.contains(deviceplan.getDeviceType())
					&& !CardType.ATM_ADMIN.contains(deviceplan.getDeviceType())) {
				Assert.assertTrue("Manufactoring tracking checkbox dropdown is enabled",
						manuFactoringTrackingChkBx.isEnabled());
			}
		} else if (deviceplan.getProductType().equalsIgnoreCase(ProductType.Prepaid)
				|| deviceplan.getProductType().equalsIgnoreCase(ProductType.Credit)) {
			if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
					&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
					&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
				Assert.assertTrue("Manufactoring tracking checkbox dropdown is enabled",
						manuFactoringTrackingChkBx.isEnabled());
			}
		} else {
			Assert.assertTrue("Manufactoring tracking checkbox disabled for " + deviceplan.getDeviceType(),
					!(manuFactoringTrackingChkBx.isEnabled()));

		}
	}

	public void checkGenerateCVV(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Generate CVV/CVC checkbox is enabled", generateCvvChkBx.isEnabled());
		} else {
			Assert.assertTrue("Generate CVV/CVC checkbox is disabled for " + deviceplan.getDeviceType(),
					!generateCvvChkBx.isEnabled());
		}
	}

	public void checkGenerateCVV2(DevicePlan deviceplan) {
		if (!CardType.STATIC_VIRTUAL.contains(deviceplan.getDeviceType())
				&& !CardType.LIMITED_VALIDITY.contains(deviceplan.getDeviceType())
				&& !CardType.MOBILE.contains(deviceplan.getDeviceType())) {
			Assert.assertTrue("Generate CVV2/CVC2 checkbox is enabled", generateCvv2ChkBx.isEnabled());
		} else {
			Assert.assertTrue("Generate CVV2/CVC2 checkbox is disabled for " + deviceplan.getDeviceType(),
					!generateCvv2ChkBx.isEnabled());
		}
	}

	public void enterCustomCode(DevicePlan deviceplan) {
		if (customCodeTxt.isEnabled()) {
			enterValueinTextBox(customCodeTxt, deviceplan.getCustomCode());
		}
	}

	@Override
	public void clickNextButton() {
		Scrolldown(nextBtn);
		clickWhenClickable(nextBtn);
	}

	public void selectEventBasedFeePlan() {
		selectDropDownByIndex(eventBasedFeePlanDDwn, 1);
	}

	public void selectJoiningMembershipFeePlan() {
		selectDropDownByIndex(membershipFeePlanDDwn, 1);
	}

	public void selectTransactionLimitPlan() {
		selectDropDownByIndex(transactionLimitPlanDDwn, 1);
	}

	public void next() {
		logger.info("before second next button");
		clickWhenClickable(nextBtn);
	}

	public void selectAfterKYC() {
		selectDropDownByIndex(transactionSetDDwn, 1);
	}

	public void clickEcomCheckBox() {
		ClickCheckBox(ecomChkBx, true);
	}

	public void clickIntTxnAllowedCheckBox() {
		ClickCheckBox(intTxnAllowedChkBx, true);
	}

	public void clickGenerateCvv() {
		ClickCheckBox(generateCvvChkBx, true);
	}

	public void clickGenerateCvv2() {
		ClickCheckBox(generateCvv2ChkBx, true);
	}

	public void clickNext3Button() {
		logger.info("before third next button");
		clickWhenClickable(nextBtn);
	}
	
	public void enterVirtualDeviceCreditLimit(DevicePlan deviceplan){

		if (virtualDeviceCreditLimitTxt.isVisible()) {
			if (virtualDeviceCreditLimitTxt.isEnabled())
				enterValueinTextBox(virtualDeviceCreditLimitTxt, deviceplan.getVirtualCreditCardLimit());
		}
	}
	
	public void enterPerTransactionLimit(DevicePlan deviceplan) {
		if (perTranscLimitTxt.isVisible()) {
			if (perTranscLimitTxt.isEnabled())
				enterValueinTextBox(perTranscLimitTxt, deviceplan.getPerTransactionLimit());
		}
	}

	public void enterTotalTransactionLimit(DevicePlan deviceplan) {
		if (totalTranscLimitTxt.isVisible()) {
			if (totalTranscLimitTxt.isEnabled())
				enterValueinTextBox(totalTranscLimitTxt, deviceplan.getTotalTransactionLimit());
		}
	}

	public void enterVelocity(DevicePlan deviceplan) {
		if (velocityTxt.isVisible()) {
			if (velocityTxt.isEnabled())
				enterValueinTextBox(velocityTxt, deviceplan.getVelocity());
		}
	}
	
	public void enterVirtualCreditLimit(DevicePlan devicePlan){
		if (virtualDeviceCreditLimitTxt.isVisible()) {
			if (virtualDeviceCreditLimitTxt.isEnabled())
				enterValueinTextBox(virtualDeviceCreditLimitTxt, devicePlan.getPerTransactionLimit());
		}
	}

	public void enterValidity(DevicePlan deviceplan) {
		if (validityTxt.isVisible()) {
			if (validityTxt.isEnabled())
				enterValueinTextBox(validityTxt, deviceplan.getValidity());
		}
	}

	public void clickNext4Button() {
		logger.info("before fourth next button");
		clickWhenClickable(nextBtn);
	}

	public void selectChipType() {
		selectDropDownByIndex(chipTypeDDwn, 1);
	}

	public void Finish() {
		logger.info("after fourth next button");
		clickWhenClickable(finishBtn);
	}

	public String provideGeneralDetails(DevicePlan deviceplan) {
		enterDevicePlanCode(deviceplan);
		enterDescription(deviceplan);
		selectAssociation(deviceplan);
		selectproduct(deviceplan);
		selectDeviceType(deviceplan);
		enterServiceCode(deviceplan);
		selectDeliveryMode(deviceplan);
		return buildDescriptionAndCode(enterDescription(deviceplan), enterDevicePlanCode(deviceplan));
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
		Scrolldown(nextBtn);
		ClickButton(nextBtn);
	}

	public void transactionFeeAndLimitPlans() {
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
			switchToDefaultFrame();
		} else {
			logger.info("Error in Device plan Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
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
		selectByVisibleText(iframeAssociationDdwn, associationType);
	}

	public void selectIframeProductType(String productType) {
		selectByVisibleText(iframeProductTypeDdwn, productType);
	}

	public void selectIframeDeviceType(String deviceType) {
		selectByVisibleText(iframeDeviceTypeDdwn, deviceType);
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
		selectByVisibleText(iframeDeviceIDGenerationTemplateDdwn, deviceIdTemplate);
	}

	public void selectIframeCardPackIDGenerationTemplate(String cardPackIdTemplate) {
		selectByVisibleText(iframeCardPackIDGenerationTemplateDdwn, cardPackIdTemplate);
	}

	public void selectIframePlasticIdDdwn(String plasticId) {
		if (plasticId != null) {
			selectByVisibleText(iframePlasticIdDdwn, plasticId);
		}
	}

	public void selectIframePictureCodeDdwn(String pictureCode) {
		if (pictureCode != null) {
			selectByVisibleText(iframePictureCodeDdwn, pictureCode);
		}
	}

	public void enableIframeCardProductionChkbx() {
		if (iframeCardProductionChkbx.isEnabled()) {
			iframeCardProductionChkbx.click();
		}
	}

	public void enableIframeCourierTrackingChkbx() {
		if (iframeCourierTrackingChkbx.isEnabled()) {
			iframeCourierTrackingChkbx.click();
		}
	}
	
	public void enableIframeManufacturingTrackingChkbx() {
		if (iframeManufacturingTrackingChkbx.isEnabled()) {
			iframeManufacturingTrackingChkbx.click();
		}
	}
	
	public void selectIframeEmbossingVendorDdwn(String embossingVendor) {
		selectByVisibleText(iframeEmbossingVendorDdwn, embossingVendor);
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
		if (iframeBaseDeviceEventBasedPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeBaseDeviceEventBasedPlanDdwn, baseDeviceEventBasedPlan);
	}

	public void selectIframeBaseDeviceJoiningMemberShipPlanDdwn(String deviceJoiningMemberShipPlan) {
		if (iframeBaseDeviceJoiningMemberShipPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeBaseDeviceJoiningMemberShipPlanDdwn,
					deviceJoiningMemberShipPlan);
	}

	public void selectIframeTransactionFeePlan(String transactionFeePlan) {
		if (iframeTransactionFeePlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeTransactionFeePlanDdwn, 
					transactionFeePlan);
	}

	public void selectIframeTransactionLimitPlanDdwn(String transactionLimitPlan) {
		if (iframeTransactionLimitPlanDdwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(iframeTransactionLimitPlanDdwn, transactionLimitPlan);
	}

	public void selectIframeAfterKYCDdwn(String kycType) {
		WebElementUtils.selectDropDownByVisibleText(iframeAfterKYCDdwn, kycType);
	}

	public void selectIframeBeforeKYCDdwn(String kycType) {
		if (iframeBeforeKYCDdwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(iframeBeforeKYCDdwn,kycType);
		}
	}

	public void selectIframeChipTypeDdwnDdwn(String chipType) {
		WebElementUtils.selectDropDownByVisibleText(iframeChipTypeDdwn, chipType);
	}

	public void clickIframeFinishButton() {
		SimulatorUtilities.wait(900);
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(iframeFinishBtn));
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(iframeFinishBtn)).click();
	}

	public void clickIframeNextButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		SimulatorUtilities.wait(500);
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec).until(WebElementUtils.visibilityOf(iframeNextBtn));
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(iframeNextBtn)).click();
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

	public void checkCvcCvv(boolean status) {
		ClickCheckBox(cvccCvvChkBx, status);
	}
	
	public void checkPinChangeTransactionFirst(boolean status) {
		ClickCheckBox(pinChangeTransactionFirstChbx, status);
	}

	public void checkCrossBorderTransaction(boolean status) {
		ClickCheckBox(crossBorderTransaction, status);
	}
	
	public void checkStoplistFlag(boolean status) {
		ClickCheckBox(stoplistFlagChkBx, status);
	}
	

	public void clickIframeDialogCloseX() {
		dialogCloseX.click();
	}

	public boolean validatePlanCreation() {
		return successMessage.getText().equalsIgnoreCase(ConstantData.SUCCESS_MESSAGE);
	}

	public void updateCVCCVVDevicePlan(DevicePlan devicePlanDataObject) {
		logger.info("Update Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		enterValueinTextBox(devicePlanCode, devicePlanDataObject.getDevicePlanCode());
		clickSearchButton();
		editFirstRecord();				
		runWithinPopup("Edit Device Plan", () -> {			
			WebElementUtils.elementToBeClickable(authorizationTab);
			clickWhenClickable(authorizationTab);
			WebElementUtils.elementToBeClickable(cvccCvvChkBx);
			checkCvcCvv(false);
			clickSaveButton();
		});

		verifyOperationStatus();
	}
	
	public void updatePinChangeTransactionFirst(DevicePlan devicePlanDataObject) {
		logger.info("Update Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		enterValueinTextBox(devicePlanCode, devicePlanDataObject.getDevicePlanCode());
		clickSearchButton();
		editFirstRecord();
		runWithinPopup("Edit Device Plan", () -> {
			WebElementUtils.elementToBeClickable(authorizationTab);
			clickWhenClickable(authorizationTab);
			WebElementUtils.elementToBeClickable(pinChangeTransactionFirstChbx);
			checkPinChangeTransactionFirst(true);
			clickSaveButton();
		});
		verifyOperationStatus();
	}

	public void checkCrossBorderTransaction(DevicePlan devicePlanDataObject) {
		logger.info("Update Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		enterValueinTextBox(devicePlanCode, devicePlanDataObject.getDevicePlanCode());
		clickSearchButton();
		editFirstRecord();
		runWithinPopup("Edit Device Plan", () -> {
			WebElementUtils.elementToBeClickable(authorizationTab);
			clickWhenClickable(authorizationTab);
			WebElementUtils.elementToBeClickable(crossBorderTransaction);
			checkCrossBorderTransaction(true);
			WebElementUtils.enterText(timeIntervalCrossBorder, 20);
			clickSaveButton();
		});
		verifyOperationStatus();
	}
	
	public void createDevicePlan(DevicePlan devicePlanDataObject) {
		logger.info("Create Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		clickAddNewButton();

		runWithinPopup("Add Device Plan", () -> {
			enterIframeDevicePlanCode(devicePlanDataObject.getDevicePlanCode());
			enterIframeDescription(devicePlanDataObject.getDescription());
	
			selectIframeAssociationType(devicePlanDataObject.getAssociation());
			selectIframeProductType(devicePlanDataObject.getProductType());
			
			if (devicePlanDataObject.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
				SimulatorUtilities.wait(2000);
				selectByVisibleText(iframeDeviceTypeDdwn,devicePlanDataObject.getDeviceType());
				if (devicePlanDataObject.getDeviceType().contains("EMV")) {
					WebElementUtils.enterText(iframeServiceCodeTxt,Constants.EMV_SERVICE_CODE);
					devicePlanDataObject.setServiceCode(Constants.EMV_SERVICE_CODE);
				} else if (devicePlanDataObject.getDeviceType().contains("Mag")) {
					WebElementUtils.enterText(iframeServiceCodeTxt,Constants.MSR_SERVICE_CODE);
					devicePlanDataObject.setServiceCode(Constants.MSR_SERVICE_CODE );
				}else{
					WebElementUtils.enterText(iframeServiceCodeTxt,Constants.MSR_SERVICE_CODE);
				}
			} else {
				selectIframeDeviceType(devicePlanDataObject.getDeviceType());
				enterIframeServiceCode(devicePlanDataObject.getServiceCode());
			}
			selectIframeDeliveryMode(devicePlanDataObject.getDeliveryMode());
			selectIframeDeviceIDGenerationTemplate(devicePlanDataObject.getDeviceIdGenerationTemplate());
			selectIframeCardPackIDGenerationTemplate(devicePlanDataObject.getCardPackIdGenerationTemplate());
			selectIframePlasticIdDdwn(devicePlanDataObject.getPlasticId());
			selectIframePictureCodeDdwn(devicePlanDataObject.getPictureCode());
			
			//Priority pass
			if(Objects.nonNull(devicePlanDataObject.getPriorityPassIndicator())){
				if(devicePlanDataObject.getPriorityPassIndicator().equalsIgnoreCase("with")){				
					checkPriorityPas();
					selectPriorityIDtemplate(devicePlanDataObject);
					priorityPassExMonth(devicePlanDataObject);
					selectPriorityPassVendor(devicePlanDataObject);
				}
			}
			
			if(devicePlanDataObject.getProductType().equalsIgnoreCase(ProductType.CREDIT)&& !DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.contains(devicePlanDataObject.getDeviceType())){
				selectIframeActivationModeLst(devicePlanDataObject.getActivationMode());
				selectIframeExpiryFlagDdwn(devicePlanDataObject.getExpiryFlag());	
			}else{
				selectIframeActivationModeLst(devicePlanDataObject.getActivationMode());
				selectIframeExpiryFlagDdwn(devicePlanDataObject.getExpiryFlag());
			}	
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
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES)){
			selectAllcavv();
		}			
		// perform below steps only when pinRequired is true which is the
		// default state
		if ("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())){
			selectAllPinValidation();
		}	
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES)) {
			selectAllcvccvv();
			// as of now, we do not need CVV check for MDFS pin change transactions
			//if(!getStoryName().toLowerCase().contains("pin_change"))
			checkCvcCvv(true);
		}			
		checkExpiryDate();		

		//if(devicePlan.getAllowInternationalTransaction().equalsIgnoreCase(STATUS_YES))
		clickIntTxnAllowedCheckBox();

		WebElementUtils.checkCheckbox(ecommAllowedChkBx, devicePlan.isEcommerceAllowed());
	
		if("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())){
			if (!(DeviceType.STATIC_VIRTUAL_CARD.contains(devicePlan.getDeviceType())
					|| DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.contains(devicePlan.getDeviceType()))) {
				WebElementUtils.enterText(pinRetryLimitTxt, devicePlan.getPinRetryLimit());
			}	
		}
		
		clickIframeNextButton();
		SimulatorUtilities.wait(300);
		
		if (DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.contains(devicePlan.getDeviceType())) {
			fillVirtualDeviceDetails(devicePlan);
			enterVirtualDeviceCreditLimit();
		} else if (DeviceType.STATIC_VIRTUAL_CARD.contains(devicePlan.getDeviceType())) {
			enterVirtualDeviceCreditLimit();
		}
		
		clickIframeNextButton();
		
		if (DeviceType.EMV_CARD.contains(devicePlan.getDeviceType()) || DeviceType.PHYSICAL_NFC_DEVICE_EMV_PAYPASS.contains(devicePlan.getDeviceType())) {
			forEmvOrNfc(devicePlan);
		}		
		clickIframeFinishButton();
	}

	private void fillDevicePlanPage(DevicePlan devicePlan) {
		selectIframeBaseDeviceEventBasedPlanDdwn(devicePlan.getBaseDeviceEventBasedPlan());
		selectIframeBaseDeviceJoiningMemberShipPlanDdwn(devicePlan.getBaseDeviceJoiningMemberShipPlan());
		if(!devicePlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)){
			selectIframeTransactionFeePlan(devicePlan.getTransactionFeePlan());
		}
		selectIframeTransactionFeePlan(devicePlan.getTransactionFeePlan());
		selectIframeTransactionLimitPlanDdwn(devicePlan.getTransactionLimitPlan());
		clickIframeNextButton();		
	}

	private void cvvCvv2PinGenerationSelectionScreen(DevicePlan devicePlan) {
		generateCVVChk.click();
		generateCVV2Chk.click();
		// filling date when flag is fixed
		if(!devicePlan.DeviceType.equalsIgnoreCase("Limited Validity Virtual Card [8]")){
			if ("Fixed [F]".equalsIgnoreCase(devicePlan.getExpiryFlag())) {
				if(devicePlan.getProductType().equalsIgnoreCase(ProductType.CREDIT) )
				{
					if(!DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.contains(devicePlan.getDeviceType()))
					{
						String currentDateString = dbUtils.getCurrentDateForInstitution(context.get(Constants.USER_INSTITUTION_SELECTED));
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
					    LocalDateTime dateTime = LocalDateTime.parse(currentDateString, formatter);
					    dateTime = dateTime.plusYears(10);
					    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM-yyyy");
					    String tenYearsPlus = dateTime.format(formatter1);
						enterIframeExpiryDateTxt(tenYearsPlus);
						String dateInYYMM = getValueInYYMMFormatForExpiryDate(tenYearsPlus);
						devicePlan.setExpiryDate(dateInYYMM);
						logger.info("Expiry date for device = {}",devicePlan.getExpiryDate());
					}
				}
				else
				{
					enterIframeExpiryDateTxt(devicePlan.getValidityOnInitialMonths());
					// making necessary changes so that this value can be set in the
					// required format so that it can be used when a pinless card is
					// used
					logger.info("Validity On Initial Months = {} ", devicePlan.getValidityOnInitialMonths());
					String dateInYYMM = getValueInYYMMFormatForExpiryDate(devicePlan.getValidityOnInitialMonths());
					devicePlan.setExpiryDate(dateInYYMM);
				}
			} else {
				enterIframeValidityOnInitialMonthsTxt(devicePlan.getValidityOnInitialMonths());
			}
		
		if(devicePlan.getProductType().equalsIgnoreCase(ProductType.CREDIT) && DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.contains(devicePlan.getDeviceType())){
			logger.info("Skipping anable of card production check box");
		}else{
			enableIframeCardProductionChkbx();
		}
		
		if(iframeEmbossingVendorDdwn.isEnabled())
			selectIframeEmbossingVendorDdwn(devicePlan.getEmbossingVendor());
		}
		
		if (devicePlan.getDeliveryMode().equalsIgnoreCase(MAIL)){
			enableIframeCourierTrackingChkbx();
			enableIframeManufacturingTrackingChkbx();
		}
		
		if (devicePlan.getFillRenewalSection().equalsIgnoreCase(STATUS_YES))
			fillRenewalSection(devicePlan);
	
		if (devicePlan.getFillReplacementSection().equalsIgnoreCase(STATUS_YES)){
			fillReplacementSection(devicePlan);
		}	
		if("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())){
			fillPinGenerationSection(devicePlan);
		}		
		
		clickIframeNextButton();
	}
	
	private String getValueInYYMMFormatForExpiryDate(String dateVal) {
		// for format of date to be passed is YYMM .Ex: Input is 10-2022..
		// output should be 2210
		String[] tempArr = dateVal.split("-");
		String tempVal = dateVal.substring(dateVal.length() - 2);
		return tempVal + tempArr[0];
	}

	private void forEmvOrNfc(DevicePlan devicePlan) {
		iCVVOptionChkBx.click();
		if(devicePlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)){
			WebElementUtils.selectDropDownByIndex(iframeChipTypeDdwn, 1);
		}else{
			selectIframeChipTypeDdwnDdwn(devicePlan.getChipType());
		}		
		
		if (devicePlan.getFillEMVPlan().equalsIgnoreCase(STATUS_YES)) {
			clickWhenClickable(atcFlagChkBx);
			//atcFlagChkBx.click();
			WebElementUtils.selectDropDownByVisibleText(emvPlanResponseDdwn, devicePlan.getEmvPlanResponse());
			WebElementUtils.enterText(acceptableBelowATCRangeTxt, devicePlan.getEmvBelowATCRange());
			WebElementUtils.enterText(acceptableAboveATCRangeTxt, devicePlan.getEmvAboveATCRange());
			clickWhenClickable(allowFallBackChkBx);
		}
		if (devicePlan.getEmvPlanIssuerScripting() != null) {
			fillIssuerScriptingDetails(devicePlan);
        }
		
	}
	
	private void fillIssuerScriptingDetails(DevicePlan devicePlan )
	{
		if (devicePlan.getEmvPlanIssuerScripting().equalsIgnoreCase(STATUS_YES))
		{
			clickWhenClickable(issuerScriptingChkBx);
			WebElementUtils.enterText(ucol, devicePlan.getEmvPlanUcol());
			WebElementUtils.enterText(ucota, devicePlan.getEmvPlanUcota());
			WebElementUtils.enterText(lcol, devicePlan.getEmvPlanLcol());
			WebElementUtils.enterText(lcota, devicePlan.getEmvPlanLcota());

			if (devicePlan.getEmvPlanApplicationBlock().equalsIgnoreCase(STATUS_YES)) {
				clickWhenClickable(applicationBlockChkBx);
				selectByVisibleText(applicationBlockPriorityDdwn,
						devicePlan.getEmvPlanApplicationBlockPriority());
			}

			if (devicePlan.getEmvPlanApplicationUnblock().equalsIgnoreCase(STATUS_YES)) {
				clickWhenClickable(applicationUnblockChkBx);
				selectByVisibleText(applicationUnblockPriorityDdwn,
						devicePlan.getEmvPlanApplicationUnblockPriority());
			}
		
			if (devicePlan.getEmvPlanPutData().equalsIgnoreCase(STATUS_YES)) {
				clickWhenClickable(putDataChkBx);
	}

			if (devicePlan.getEmvPlanPinChange().equalsIgnoreCase(STATUS_YES)) {
				clickWhenClickable(pinChangeChkBx);
			}

			if (devicePlan.getEmvPlanPinUnblock().equalsIgnoreCase(STATUS_YES)) {
				clickWhenClickable(pinUnblockChkBx);
			}
			WebElementUtils.selectDropDownByVisibleText(applicationBlockPriorityDdwn,
					devicePlan.getEmvPlanApplicationBlockPriority());
			WebElementUtils.selectDropDownByVisibleText(applicationUnblockPriorityDdwn,
					devicePlan.getEmvPlanApplicationUnblockPriority());
			WebElementUtils.selectDropDownByVisibleText(pinChangePriorityDdwn,
					devicePlan.getEmvPlanPinChangePriority());
			WebElementUtils.selectDropDownByVisibleText(putDataPriorityDdwn,
					devicePlan.getEmvPlanPutDataPriority());
			WebElementUtils.selectDropDownByVisibleText(pinUnblockPriorityDdwn,
					devicePlan.getEmvPlanPinUnblockPriority());
			
			if (devicePlan.getEmvIssuerScriptingNegative().equalsIgnoreCase(STATUS_NO)) {
				selectByVisibleText(pinChangePriorityDdwn, devicePlan.getEmvPlanPinChangePriority());
				selectByVisibleText(putDataPriorityDdwn, devicePlan.getEmvPlanPutDataPriority());
				selectByVisibleText(pinUnblockPriorityDdwn, devicePlan.getEmvPlanPinUnblockPriority());
			}
		}

	}

	private void fillPinGenerationSection(DevicePlan devicePlan) {
		// perform below steps only when pinRequired is true which is the
		// default state
		if (!(DeviceType.STATIC_VIRTUAL_CARD.toLowerCase().contains(devicePlan.getDeviceType().toLowerCase()) || DeviceType.LIMITED_VALIDITY_VIRTUAL_CARD.toLowerCase().contains(devicePlan.getDeviceType().toLowerCase()))){
			WebElementUtils.scrollDown(driver(), 0, 250);
			pinRequiredChk.click();
			WebElementUtils.selectDropDownByVisibleText(pinDataTransmissionDDwn, devicePlan.getPinDataTransmission());

			WebElementUtils.enterText(pinLengthTxt, devicePlan.getPinLength());			
			selectByVisibleText(pinProductionVendorDDwn, devicePlan.getEmbossingVendor());
			WebElementUtils.selectDropDownByVisibleText(pinGenerationOptionDDwn, devicePlan.getPinGenerationOption());
		}
	}

	private void fillRenewalSection(DevicePlan devicePlan) {
		if(devicePlan.getDeviceType().contains(DeviceType.MAGNETIC_STRIPE_CARD) 
				|| devicePlan.getDeviceType().contains(DeviceType.EMV_CARD) 
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_MAG_STRIPE_PAYPASS)
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_EMV_PAYPASS)
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_PAYPASS)){
			allowRenewalChkBx.click();
			selectByVisibleText(renewalDeviceTechnologyDdwn,devicePlan.getDeviceType());
			WebElementUtils.enterText(validityOnRenewalMonthsTxt, devicePlan.getValidityOnRenewalMonths());
			WebElementUtils.enterText(autoRenewalDaysTxt, devicePlan.getAutoRenewalDays());
			WebElementUtils.enterText(advanceRenewalReportTxt, devicePlan.getAdvanceRenewalReport());
			WebElementUtils.enterText(renewalActivationModeTxt, devicePlan.getRenewalActivationMode());
		}
	}

	private void fillReplacementSection(DevicePlan devicePlan) {
		if(devicePlan.getDeviceType().contains(DeviceType.MAGNETIC_STRIPE_CARD) 
				|| devicePlan.getDeviceType().contains(DeviceType.EMV_CARD) 
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_MAG_STRIPE_PAYPASS)
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_EMV_PAYPASS)
				|| devicePlan.getDeviceType().contains(DeviceType.PHYSICAL_NFC_DEVICE_PAYPASS)){
			replacementNewExpiryFlagChkBx.click();
			WebElementUtils.enterText(replacementNoOfDaysTxt, devicePlan.getReplacementNoOfDays());
			WebElementUtils.enterText(validityOnReplacementMonthsTxt, devicePlan.getValidityOnReplacementMonths());
			allowInstanceDeviceReplaceChkBx.click();
			if (!devicePlan.getReplacementDeviceTechnology().isEmpty()) {
				WebElementUtils.selectDropDownByVisibleText(replacementDeviceTechnologyDdwn,
						devicePlan.getReplacementDeviceTechnology());
			}
		}
	}

	public void fillVirtualDeviceDetails(DevicePlan devicePlan) {
		enterPerTransactionLimit(devicePlan);
		enterTotalTransactionLimit(devicePlan);
		enterVelocity(devicePlan);
		enterValidity(devicePlan);
	}
	
	public void enterVirtualDeviceCreditLimit(){	
		if(virtualDeviceCreditLimitTxt.isEnabled()){
			WebElementUtils.enterText(virtualDeviceCreditLimitTxt,CustomUtils.randomNumbers(3));
		}
	}
	
	private String getStoryName(){
		String name = System.getProperty("storyName").toString();
		logger.info("System.getStoryName  : "+name);
		return name;
	}
	
	public void enableStopListFlag(DevicePlan devicePlanDataObject) {
		logger.info("Update Device Plan: {}", devicePlanDataObject.getDevicePlanCode());
		enterValueinTextBox(devicePlanCode, devicePlanDataObject.getDevicePlanCode());
		clickSearchButton();
		editFirstRecord();				
		runWithinPopup("Edit Device Plan", () -> {			
			WebElementUtils.elementToBeClickable(authorizationTab);
			clickWhenClickable(authorizationTab);
			checkStoplistFlag(true);
			clickSaveButton();
		});

		verifyOperationStatus();
	}
	
	public void checkPriorityPas(){	
		ClickCheckBox(iframePriorityPassIndicatorChkbx,true);
	}
	
	public void selectPriorityIDtemplate(DevicePlan devicePlan){
		selectByVisibleText(iframePriorityPassIDTemplateDdwn, devicePlan.getPriorityPassIdTemplate());
	}
	
	public void priorityPassExMonth(DevicePlan devicePlan){		
		enterText(iframePriorityPassExpiryInMonthsTxt, devicePlan.getPriorityPassExpiry());
	}
	
	public void selectPriorityPassVendor(DevicePlan devicePlan){	
		selectByVisibleText(iframePriorityPassVendorDdwn, devicePlan.getPriorityPassVendor());
	}
	
	public void editDevicePlan(DevicePlan device) {
		enterValueinTextBox(devicePlanCode, device.getDevicePlanCode());
		clickSearchButton();
		editFirstRecord();				
		runWithinPopup("Edit Device Plan", () -> {			
			WebElementUtils.elementToBeClickable(authorizationTab);
			clickWhenClickable(authorizationTab);
			enterValueinTextBox(txtPresentmentTimeLimit, device.getTransSetPresentmentTimeLimit());
			clickSaveButton();
		});

		verifyOperationStatus();
		
	}
}