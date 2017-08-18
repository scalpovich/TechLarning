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

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePriorityPassIDAndCardPackIDTemplate;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_PRIORITYPASSID_CARDPACKID_TEMPLATE_PLAN })
public class DevicePriorityPassIDAndCardPackIDTemplatePage extends
		AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(DevicePriorityPassIDAndCardPackIDTemplatePage.class);

	private static final String RADIOBUTTON_NAME_SEQUENTIAL = "Sequential";
	private static final String RADIOBUTTON_NAME_RANDOM = "Random";
	private static final String DIALOG_POPUP_TITLE = "Add Device, Priority Pass ID, Card Pack ID Template";

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][1]/input")
	private MCWebElement templateCodeTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='field'][2]/input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Search]")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a")
	private MCWebElement tableRowOneCode;

	// iframe Locators
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//iframe[@class='wicket_modal']")
	private MCWebElement iframe;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='w_close']")
	private MCWebElement dialogCloseX;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateType:input:dropdowncomponent")
	private MCWebElement iframetemplateTypeddwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateDesc:input:inputTextField")
	private MCWebElement iframedescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:cardNumberLength:input:inputTextField")
	private MCWebElement iframeTemplateLengthTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='radioInput']/input[1]")
	private MCWebElement iframeSequentialRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='radioInput']/input[2]")
	private MCWebElement iframeRandomRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@class='chkField']")
	private MCWebElement iframeCheckDigitchkbx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Submit]")
	private MCWebElement submitbtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "mainContainer:trnsTypeDescBin:input:dropdowncomponent")
	private MCWebElement iframeFieldddwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "mainContainer:trnsTypeDescLenBin:input:inputTextField")
	private MCWebElement iframeLengthtxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Record Added Successfully')]")
	private MCWebElement successMessage;

	// table data
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescBin:input:dropdowncomponent")
	private MCWebElement iframeTableFirstRecordFieldDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenBin:input:inputTextField")
	private MCWebElement iframeTableFirstRecordLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc2:input:dropdowncomponent")
	private MCWebElement iframeTableSecondRecordFieldDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen2:input:inputTextField")
	private MCWebElement iframeTableSecondRecordLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescChkDgt:input:dropdowncomponent")
	private MCWebElement iframeTableLastRecordFieldDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenChkDgt:input:inputTextField")
	private MCWebElement iframeTableLastRecordLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeChkDgtCstValue:input:inputTextField")
	private MCWebElement iframeTableLastRecordCustomFeildValue1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeChkDgtCstValue1:input:inputTextField")
	private MCWebElement iframeTableLastRecordCustomFeildValue2Txt;

	public void verifyUiOperationStatus() {
		logger.info("Device Priority Pass ID and Card Pack ID Template");
		verifySearchButton("Search");
	}

	// Methods
	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(templateCodeTxt));
	}

	// Methods for Main Screen
	public void addPlan() {
		clickAddNewButton();
	}

	public void enterTemplateCode(String templateCode) {
		WebElementUtils.enterText(templateCodeTxt, templateCode);
	}

	public void enterDescription(String descriptionData) {
		WebElementUtils.enterText(descriptionTxt, descriptionData);
	}

	public String getDeviceInformationFromTable() {
		return tableRowOneCode.getText();
	}

	// Methods for Dialog Screen
	public void selectIframeTemplateType(String templateType) {
		WebElementUtils.selectDropDownByVisibleText(iframetemplateTypeddwn,
				templateType);
	}

	public void enterIframeDescription(String descriptionData) {
		WebElementUtils.enterText(iframedescriptionTxt, descriptionData);

	}

	public void enterIframeTemplateLength(String templateLength) {
		WebElementUtils.enterText(iframeTemplateLengthTxt, templateLength);

	}

	public void selectIframeRadioBtn(String radioButtonName) {
		if (RADIOBUTTON_NAME_SEQUENTIAL.equalsIgnoreCase(radioButtonName))
			iframeSequentialRBtn.click();
		else if (RADIOBUTTON_NAME_RANDOM.equalsIgnoreCase(radioButtonName))
			iframeRandomRBtn.click();
	}

	public void enableCheckDigit() {
		if (!iframeCheckDigitchkbx.isEnabled())
			iframeCheckDigitchkbx.click();
	}

	public void clickIframeSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitbtn)).click();
		waitForWicket();
	}

	public void clickIframeDialogCloseX() {
		dialogCloseX.click();
	}

	public boolean validatePlanCreation() {
		return successMessage.getText().equalsIgnoreCase(
				ConstantData.SUCCESS_MESSAGE);
	}

	public void selectIframeTableFirstRecordField(String fieldType) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTableFirstRecordFieldDdwn, fieldType);
	}

	public void enterIframeTableFirstRecordLength(String value) {
		WebElementUtils.enterText(iframeTableFirstRecordLengthTxt, value);

	}

	public void selectIframeTableSecondRecordField(String fieldType) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTableSecondRecordFieldDdwn, fieldType);
	}

	public void enterIframeTableSecondRecordLength(String value) {
		WebElementUtils.enterText(iframeTableSecondRecordLengthTxt, value);

	}

	public void selectIframeTableLastRecordField(String fieldType) {
		WebElementUtils.selectDropDownByVisibleText(
				iframeTableLastRecordFieldDdwn, fieldType);
	}

	public void enterIframeTableLastRecordLength(String value) {
		WebElementUtils.enterText(iframeTableLastRecordLengthTxt, value);

	}

	public void enterIframeTableLastRecordCustomFeildValue1(String value) {
		WebElementUtils.enterText(iframeTableLastRecordCustomFeildValue1Txt,
				value);

	}

	public void enterIframeTableLastRecordCustomFeildValue2(String value) {
		WebElementUtils.enterText(iframeTableLastRecordCustomFeildValue2Txt,
				value);

	}

	// workflow methods
	public String createCardPackIDTemplate(
			DevicePriorityPassIDAndCardPackIDTemplate devicePlanDataObject) {
		logger.info("Create Card Pack ID Template: {}",
				devicePlanDataObject.getTemplateType());
		clickAddNewButton();

		runWithinPopup(DIALOG_POPUP_TITLE,
				() -> {
					selectIframeTemplateType(devicePlanDataObject
							.getTemplateType());
					enterIframeDescription(devicePlanDataObject
							.getDescription());
					enterIframeTemplateLength(devicePlanDataObject
							.getTemplateLength());
					// Add Field Data
				selectIframeTableFirstRecordField(devicePlanDataObject
						.getTableFirstRecordField());
				clickIframeSubmitButton();

				clickSaveButton();
			});

		verifyOperationStatus();
		return getDeviceInformationFromTable();
	}

	public String createDeviceTemplate(
			DevicePriorityPassIDAndCardPackIDTemplate devicePlanDataObject) {
		logger.info("Create Device Template: {}",
				devicePlanDataObject.getTemplateType());
		clickAddNewButton();

		runWithinPopup(DIALOG_POPUP_TITLE,
				() -> {
					selectIframeTemplateType(devicePlanDataObject
							.getTemplateType());
					enterIframeDescription(devicePlanDataObject
							.getDescription());
					enterIframeTemplateLength(devicePlanDataObject
							.getTemplateLength());
					selectIframeRadioBtn(devicePlanDataObject.getIndicator());
					enableCheckDigit();
					// Add Table Data
				enterIframeTableFirstRecordLength(devicePlanDataObject
						.getTableFirstRecordLength());
				selectIframeTableSecondRecordField(devicePlanDataObject
						.getTableSecondRecordField());
				enterIframeTableSecondRecordLength(devicePlanDataObject
						.getTableSecondRecordLength());
				clickIframeSubmitButton();
				clickSaveButton();
			});

		verifyOperationStatus();
		return getDeviceInformationFromTable();
	}

	public String createPriorityPassID(
			DevicePriorityPassIDAndCardPackIDTemplate devicePlanDataObject) {
		logger.info("Create Priority Pass ID: {}",
				devicePlanDataObject.getTemplateType());
		clickAddNewButton();

		runWithinPopup(DIALOG_POPUP_TITLE,
				() -> {
					selectIframeTemplateType(devicePlanDataObject
							.getTemplateType());
					enterIframeDescription(devicePlanDataObject
							.getDescription());
					enterIframeTemplateLength(devicePlanDataObject
							.getTemplateLength());
					// Add Table Data
				enterIframeTableLastRecordLength(devicePlanDataObject
						.getTableLastRecordLength());
				selectIframeTableFirstRecordField(devicePlanDataObject
						.getTableFirstRecordField());
				enterIframeTableFirstRecordLength(devicePlanDataObject
						.getTableFirstRecordLength());
				enterIframeTableLastRecordCustomFeildValue1(devicePlanDataObject
						.getTableLastRecordCustomFeildValue1());
				enterIframeTableLastRecordCustomFeildValue2(devicePlanDataObject
						.getTableLastRecordCustomFeildValue2());
				clickIframeSubmitButton();
				clickSaveButton();
			});

		verifyOperationStatus();
		return getDeviceInformationFromTable();
	}
}