package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement.ProgramSetupSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
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
