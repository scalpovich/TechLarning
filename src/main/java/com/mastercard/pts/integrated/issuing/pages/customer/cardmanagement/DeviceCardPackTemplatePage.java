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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION, CardManagementNav.L3_DEVICE_PRIORITYPASSID_CARDPACKID_TEMPLATE_PLAN })
public class DeviceCardPackTemplatePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceCardPackTemplatePage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceCardPackTemplateBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateType:input:dropdowncomponent")
	private MCWebElement TemplateTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateDesc:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:cardNumberLength:input:inputTextField")
	private MCWebElement TemplateLengthTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescBin:input:dropdowncomponent")
	private MCWebElement Field1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenBin:input:inputTextField")
	private MCWebElement Length1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc2:input:dropdowncomponent")
	private MCWebElement Field2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen2:input:inputTextField")
	private MCWebElement Length2Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc3:input:dropdowncomponent")
	private MCWebElement Field3DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen3:input:inputTextField")
	private MCWebElement Length3Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc4:input:dropdowncomponent")
	private MCWebElement Field4DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen4:input:inputTextField")
	private MCWebElement Length4Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc5:input:dropdowncomponent")
	private MCWebElement Field5DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen5:input:inputTextField")
	private MCWebElement Length5Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:submitTemplate")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void clickAddDeviceCardPackTemplate() {
		clickWhenClickable(addDeviceCardPackTemplateBtn);
		switchToAddDeviceCardPackPriorityPassFrame();
	}

	public void switchToAddDeviceCardPackPriorityPassFrame() {
		switchToIframe(Constants.ADD_DEVICE_PRIORITYPASS_CARDPACKID_TEMPLATE_FRAME);
	}

	public void selectTemplateType(DeviceCreation deviceCreation) {
		selectByVisibleText(TemplateTypeDDwn, deviceCreation.getTemplateType());
	}

	public void enterCardpackDeviceDescription() {
		enterValueinTextBox(DescriptionTxt, "CardTemplate/DeviceTemplate");
	}

	public void enterTemplateLength(DeviceCreation deviceCreation) {
		enterValueinTextBox(TemplateLengthTxt, deviceCreation.getLength());
	}

	public void selectField1(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(Field1DDwn, devicecardtemplate.getField1());
		enterValueinTextBox(Length1Txt, devicecardtemplate.getLength1());

	}

	public void selectField2(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(Field2DDwn, devicecardtemplate.getField2());
		enterValueinTextBox(Length2Txt, devicecardtemplate.getLength2());
	}

	public void selectField3(DeviceCardPackTemplate devicecardtemplate) {
		selectByVisibleText(Field3DDwn, devicecardtemplate.getField3());
		enterValueinTextBox(Length3Txt, devicecardtemplate.getLength3());
	}

	public void selectField4(DeviceCreation deviceCreation, DeviceCardPackTemplate devicecardtemplate) {
		if (deviceCreation.getTemplateType().contains("Device Template")) {
			selectByVisibleText(Field4DDwn, devicecardtemplate.getField4());
			enterValueinTextBox(Length4Txt, devicecardtemplate.getLength4());
		}
		if (deviceCreation.getTemplateType().contains("Card Pack ID Template")) {
			selectByVisibleText(Field4DDwn, devicecardtemplate.getField6());
		}
	}

	public void selectField5(DeviceCardPackTemplate devicecardtemplate) {
		if (devicecardtemplate.getField5() != null && devicecardtemplate.getLength5() != null) {
			selectByVisibleText(Field5DDwn, devicecardtemplate.getField5());
			enterValueinTextBox(Length5Txt, devicecardtemplate.getLength5());
		}
	}

	public void clickSubmit() {
		clickWhenClickable(submitBtn);
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnDeviceTemplatePage() {
		return publishErrorOnPage();
	}

	public void verifyNewVendorSuccess() {
		if (!verifyErrorsOnDeviceTemplatePage()) {
			logger.info("Template Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void addTemplateFields(DeviceCreation deviceCreation) {
		selectTemplateType(deviceCreation);
		enterCardpackDeviceDescription();
		enterTemplateLength(deviceCreation);
	}

	public void selectDeviceTemplateFields(DeviceCreation deviceCreation, DeviceCardPackTemplate devicetemplate) {
		selectField1(devicetemplate);
		 
	}

	public void selectCardTemplateFields(DeviceCreation deviceCreation, DeviceCardPackTemplate devicetemplate) {
		selectField1(devicetemplate);
		selectField2(devicetemplate);
		 
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
