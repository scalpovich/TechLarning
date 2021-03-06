package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCardPackTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_DEVICE_PRIORITYPASSID_CARDPACKID_TEMPLATE_PLAN })
public class DeviceCardPackTemplatePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceCardPackTemplatePage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceCardPackTemplateBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateType:input:dropdowncomponent")
	private MCWebElement templateTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateDesc:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:cardNumberLength:input:inputTextField")
	private MCWebElement templateLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescBin:input:dropdowncomponent")
	private MCWebElement field1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenBin:input:inputTextField")
	private MCWebElement length1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc2:input:dropdowncomponent")
	private MCWebElement field2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen2:input:inputTextField")
	private MCWebElement length2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc3:input:dropdowncomponent")
	private MCWebElement field3DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen3:input:inputTextField")
	private MCWebElement length3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc4:input:dropdowncomponent")
	private MCWebElement field4DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen4:input:inputTextField")
	private MCWebElement length4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc5:input:dropdowncomponent")
	private MCWebElement field5DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen5:input:inputTextField")
	private MCWebElement length5Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescChkDgt:input:dropdowncomponent")
	private MCWebElement field12DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenChkDgt:input:inputTextField")
	private MCWebElement length12Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeChkDgtCstValue:input:inputTextField")
	private MCWebElement firstCustom12Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeChkDgtCstValue1:input:inputTextField")
	private MCWebElement secondCustom12Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:submitTemplate")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddDeviceCardPackTemplate() {
		clickWhenClickable(addDeviceCardPackTemplateBtn);
		switchToAddDeviceCardPackPriorityPassFrame();
	}

	public void switchToAddDeviceCardPackPriorityPassFrame() {
		switchToIframe(Constants.ADD_DEVICE_PRIORITYPASS_CARDPACKID_TEMPLATE_FRAME);
	}

	public void selectTemplateType(DeviceCreation deviceCreation) {
		selectByVisibleText(templateTypeDDwn, deviceCreation.getTemplateType());
	}

	public void enterCardpackDeviceDescription() {
		enterValueinTextBox(descriptionTxt, "CardTemplate/DeviceTemplate");
	}

	public void enterTemplateLength(DeviceCreation deviceCreation) {
		enterValueinTextBox(templateLengthTxt, deviceCreation.getLength());
	}

	public void selectField1(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(field1DDwn, devicecardtemplate.getField1());
		enterValueinTextBox(length1Txt, devicecardtemplate.getLength1());

	}

	public void selectField2(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(field2DDwn, devicecardtemplate.getField2());
		enterValueinTextBox(length2Txt, devicecardtemplate.getLength2());
	}

	public void selectField3(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(field3DDwn, devicecardtemplate.getField3());
		enterValueinTextBox(length3Txt, devicecardtemplate.getLength3());
	}

	public void selectField4(DeviceCreation deviceCreation, DeviceCardPackTemplate devicecardtemplate) {
		if (deviceCreation.getTemplateType().contains("Device Template")) {
			selectByVisibleText(field4DDwn, devicecardtemplate.getField4());
			enterValueinTextBox(length4Txt, devicecardtemplate.getLength4());
		}
		if (deviceCreation.getTemplateType().contains("Card Pack ID Template")) {
			selectByVisibleText(field4DDwn, devicecardtemplate.getField6());
		}
	}

	public void selectField5(DeviceCardPackTemplate devicecardtemplate) {
		if (devicecardtemplate.getField5() != null && devicecardtemplate.getLength5() != null) {
			selectByVisibleText(field5DDwn, devicecardtemplate.getField5());
			enterValueinTextBox(length5Txt, devicecardtemplate.getLength5());
		}
	}

	public void clickSubmit() {
		clickWhenClickable(submitBtn);
	}

	@Override
	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		switchToDefaultFrame();
	}

	public boolean verifyErrorsOnDeviceTemplatePage() {
		return publishErrorOnPage();
	}

	public void verifyNewVendorSuccess() {
		if (!verifyErrorsOnDeviceTemplatePage()) {
			logger.info("Template Added Successfully");
			switchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
		}
	}

	public void addTemplateFields(DeviceCreation deviceCreation) {
		selectTemplateType(deviceCreation);
		enterCardpackDeviceDescription();
		enterTemplateLength(deviceCreation);
	}

	public void selectDeviceTemplateFields(DeviceCardPackTemplate devicetemplate) {
		selectField1(devicetemplate);

	}

	public void selectCardTemplateFields(DeviceCardPackTemplate devicetemplate) {
		selectField1(devicetemplate);
		selectField2(devicetemplate);

	}
	
	public void createTemplates(DeviceCreation devicecreation,DeviceCardPackTemplate devicetemplate){
		clickWhenClickable(addDeviceCardPackTemplateBtn);
		runWithinPopup("Add Device, Priority Pass ID, Card Pack ID Template", ()->{
			
			selectByVisibleText(templateTypeDDwn, devicecreation.getTemplateType());
			enterText(descriptionTxt, CustomUtils.randomString(10));
			enterText(templateLengthTxt,devicecreation.getLength());			
			selectByVisibleText(field1DDwn,devicetemplate.getField1());
			enterValueinTextBox(length1Txt,devicetemplate.getLength1());			
			enterValueinTextBox(length12Txt, devicetemplate.getLength12());			
			clickInRect(firstCustom12Txt);
			enterValueinTextBox(firstCustom12Txt,devicetemplate.getFirstCustomValue12());
			enterValueinTextBox(secondCustom12Txt,devicetemplate.getSecondCustomValue12());			
			clickWhenClickable(submitBtn);
			clickWhenClickable(saveBtn);			
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}