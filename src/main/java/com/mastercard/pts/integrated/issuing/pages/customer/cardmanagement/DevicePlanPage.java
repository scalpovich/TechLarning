package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement.ProgramSetupSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_PLAN })
public class DevicePlanPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(DevicePlanPage.class);
	private static final String STATUS_YES = "Yes";

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@Autowired
	Vendor vendor;
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvvGenerate:checkBoxComponent")
	private MCWebElement GenerateCvvChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cvv2Generate:checkBoxComponent")
	private MCWebElement GenerateCvv2ChkBx;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:plasticId:input:dropdowncomponent")
	private MCWebElement iframePlasticIdDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:pictureCode:input:dropdowncomponent")
	private MCWebElement iframePictureCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardProductionInd:checkBoxComponent")
	private MCWebElement iframeCardProductionChkbx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:personalEmboVendor:input:dropdowncomponent")
	private MCWebElement iframeEmbossingVendorDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardActivation:multiChoice")
	private MCWebElement iframeActivationModeLst;

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

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(devicePlanCodeTxt));
	}

	public void verifyUiOperationStatus() {
		logger.info("Device Plan");
		verifySearchButton("Search");
	}
	public void addPlan() {
		clickAddNewButton();
	}
	public void clickAddDevicePlan() {
		waitForElementVisible(AddDevicePlanBtn);
		ClickButton(AddDevicePlanBtn);
	}

	public void switchToAddDevicePlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
	}

	public String enterDevicePlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DevicePlanCodeTxt, CustomUtils.randomNumbers(5));
		return DevicePlanCodeTxt.getAttribute("value");
	}

	public String enterDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, "DevicePlan");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectAssociation(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(AssociationDDwn, deviceCreation.getInterchange());
	}

	public void selectproduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectDeviceType(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		selectByVisibleText(DeviceTypeDDwn, getDeviceType());
	}

	public void enterServiceCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ServiceCodeTxt, deviceplanDataprovider().getServiceCode());
	}

	public void selectDeviceIDGenerationTemplate() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DeviceIDGenerationTemplateDDwn, 1);
	}

	public void selectCardPackGenerationTemplate() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CardPackIDGenerationTemplateDDwn, 1);
	}

	public void selectActivationMode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(ActivationModeonManual);
	}

	public void selectExpiryDate() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ExpiryFlagDDwn, deviceplanDataprovider().getExpiryFlag());
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ExpiryDateTxt, deviceplanDataprovider().getExpiryDate());
	}

	public void selectDeliveryMode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(DeliveryModeDDwn, deviceplanDataprovider().getDeliveryMode());
	}

	public void selectPlasticId() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PlasticIdDDwn, 1);
	}

	public void selectPictureCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(PictureCodeDDwn, 1);
	}

	public void selectEmbossingVendor() {
		ClickCheckBox(CardProductionChkBx, true);
		selectByVisibleText(EmbossingVendorDDwn, vendor.getVendor());
	}

	public void enterCustomCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (CustomCodeTxt.isEnabled()) {
			enterText(CustomCodeTxt, deviceplanDataprovider().getCustomCode());
			addWicketAjaxListeners(getFinder().getWebDriver());
		}
	}

	public void clickNextButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(5000);
		Scrolldown(NextBtn);
		ClickButton(NextBtn);
		CustomUtils.ThreadDotSleep(5000);
	}

	public void selectEventBasedFeePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(EventBasedFeePlanDDwn, 1);
	}

	public void selectMembershipFeePlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(MembershipFeePlanDDwn, 1);
	}

	public void selectTransactionLimitPlan() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionLimitPlanDDwn, 1);
	}

	public void clickNext2Button() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		logger.info("before second next button");
		ClickButton(Next2Btn);
	}

	public void selectAfterKYC() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionSetDDwn, 1);
	}

	public void clickEcomCheckBox() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(EcomChkBx, true);
	}

	public void clickGenerateCvv() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(GenerateCvvChkBx, true);
	}

	public void clickGenerateCvv2() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickCheckBox(GenerateCvv2ChkBx, true);
	}

	public void clickNext3Button() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		logger.info("before third next button");
		ClickButton(Next3Btn);
	}

	public void enterPerTransactionLimit(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PerTranscLimitTxt, deviceplanDataprovider().getPerTransactionLimit());
	}

	public void enterTotalTransactionLimit() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(TotalTranscLimitTxt, deviceplanDataprovider().getTotalTransactionLimit());
	}

	public void enterVelocity(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(VelocityTxt, deviceplanDataprovider().getVelocity());
	}

	public void enterValidity(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ValidityTxt, deviceplanDataprovider().getValidity());
	}

	public void clickNext4Button() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		logger.info("before fourth next button");
		ClickButton(Next4Btn);
	}

	public void selectChipType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(ChipTypeDDwn, 1);
	}

	public void clickFinishButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		logger.info("after fourth next button");
		ClickButton(FinishBtn);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			try {
				if (PanelErrorTxt.isVisible()) {
					logger.info("inside error pannel");
					CancelBtn.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public void adddeviceplan(String devicePlanCodeText, String planDevice, String customCode, String deviceAssoc,
			String prodType, String deviceType, String deviceServiceCode, String deliveryMode, String embossingVendor,
			String expiryFlag, String expiryDate, String perTransLimit, String totalTransLimit, String velocity,
			String validity) {
		menuSubMenuPage.getDevicePlan().click();
		ClickButton(AddDevicePlanBtn);
		switchToIframe(Constants.ADD_DEVICE_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DevicePlanCodeTxt, devicePlanCodeText);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, planDevice);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(AssociationDDwn, deviceAssoc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		SelectDropDownByText(DeviceTypeDDwn, deviceType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(ServiceCodeTxt, deviceServiceCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DeviceIDGenerationTemplateDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(CardPackIDGenerationTemplateDDwn, 1);
		if (deviceType.equalsIgnoreCase(Constants.StaticVirtualCard_String)) {
			ClickButton(ActivationModeonManual);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(ExpiryFlagDDwn, expiryFlag);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(ExpiryDateTxt, expiryDate);
		}
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
		addWicketAjaxListeners(getFinder().getWebDriver());
		if (CustomCodeTxt.isEnabled()) {
			enterText(CustomCodeTxt, customCode);
			addWicketAjaxListeners(getFinder().getWebDriver());
		}
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
			String embossingVendor, String expiryFlag, String expiryDate, String perTransLimit, String totalTransLimit,
			String velocity, String validity) {
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
		if (deviceType.equalsIgnoreCase(Constants.LimitedValidityVirtualCard_String)) {
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
		if (deviceType.equalsIgnoreCase(Constants.StaticVirtualCard_String)) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickCheckBox(EcomChkBx, true);
			logger.info("before third next button");
			ClickButton(Next3Btn);

		}
		if (deviceType.equals(Constants.EmvCard_String)) {
			logger.info("before third next button");
			ClickButton(Next3Btn);
			logger.info("before fourth next button");
			ClickButton(Next4Btn);
			SelectDropDownByIndex(ChipTypeDDwn, 1);
		}
		// if (deviceType.equals("Magnetic Stripe Card [1]")) {
		logger.info("before third next button");
		ClickButton(Next3Btn);
		logger.info("before fourth next button");
		ClickButton(Next4Btn);
		// }
		logger.info("after fourth next button");
		ClickButton(FinishBtn);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
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

	public void selectIframeChipTypeDdwnDdwn(String chipType) {
		WebElementUtils.selectDropDownByVisibleText(iframeChipTypeDdwn, chipType);
	}

	public void clickIframeFinishButton() {
		new WebDriverWait(getFinder().getWebDriver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(iframeFinishBtn)).click();
	}

	public void clickIframeNextButton() {
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

		selectIframeAfterKYCDdwn(devicePlan.getAfterKYC());
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES))
			selectAllcavv();

		// perform below steps only when pinRequired is true which is the
		// default state
		if (ProgramSetupSteps.pinRequired)
			selectAllPinValidation();
		if (devicePlan.getSelectAllCVCCVV().equalsIgnoreCase(STATUS_YES))
			selectAllcvccvv();
		checkExpiryDate();
		checkCvcCvv();
		WebElementUtils.checkCheckbox(ecommAllowedChkBx, devicePlan.isEcommerceAllowed());

		if (!devicePlan.getDeviceType().equals(DeviceType.STATIC_VIRTUAL_CARD)) {
			if (ProgramSetupSteps.pinRequired)
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

		enterIframeValidityOnInitialMonthsTxt(devicePlan.getValidityOnInitialMonths());
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
		if (ProgramSetupSteps.pinRequired) {
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
