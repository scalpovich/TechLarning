package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.HashMap;

import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingFile;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.thucydides.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2EMBOSSING_PARAMETERS,
		CardManagementNav.L3EMBOSSING_TEMPLATE })
public class EmbossingTemplatePage extends EmbossingFile {
	final Logger logger = LoggerFactory.getLogger(EmbossingTemplatePage.class);

	@Autowired
	MenuSubMenuPage menusubMenuPage;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	// ------------- Card Management > Institution Parameter Setup > Embossing
	// Parameters > Embossing and Priority Pass File Template [ISW013]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceCardPackTemplateBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a/img[@alt='Edit Record']")
	private MCWebElement EditDeviceCardPackTemplateBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "checksumRequired:checkBoxComponent")
	private MCWebElement CheckSumChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "header1:checkBoxComponent")
	private MCWebElement HeaderChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "trailer:checkBoxComponent")
	private MCWebElement TrailerChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paramValue:input:inputTextField")
	private MCWebElement FillerValueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "templateId:input:inputTextField")
	private MCWebElement EmbossingFileTemplateCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "templateDesc:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fileType:input:dropdowncomponent")
	private MCWebElement FileTypeDDwn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "sequenceNumber:input:inputTextField")
	private MCWebElement SequenceNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "param:input:dropdowncomponent")
	private MCWebElement FieldDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paramLength:input:inputTextField")
	private MCWebElement LengthTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='EmbossingFileParamDetailsOrderBy']//div//a[@class='addR']")
	private MCWebElement AddSubDetails2Btn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "legalIdType:input:dropdowncomponent")
	private MCWebElement LegalIDTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paramPriority:input:inputTextField")
	private MCWebElement PriorityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElements addBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//iframe[@class = 'wicket_modal']")
	private MCWebElements framepopup;

	public void addDeviceCardPackTemplate() {
		ClickButton(addDeviceCardPackTemplateBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);

	}

	public void clickAddEmbossingTemplate() {
		waitForElementVisible(addDeviceCardPackTemplateBtn);
		ClickButton(addDeviceCardPackTemplateBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void switchToAddEmbossingTemplateFrame() {
		// addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);
	}

	public String enterEmbossingFileCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(EmbossingFileTemplateCodeTxt, CustomUtils.randomNumbers(3));
		return EmbossingFileTemplateCodeTxt.getAttribute("value");
	}

	public String enterEmbossingFileDecsription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, "AutoEmboss");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectFileType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(FileTypeDDwn, getTemplateType());
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		ClickButton(SaveBtn);
	}

	public void checkRecordError() {
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
			addWicketAjaxListeners(getFinder().getWebDriver());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("inside error pannel");
		}
		SwitchToDefaultFrame();
	}

	public void clickAddSubdetails() {
		waitForElementVisible(AddSubDetailsBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(AddSubDetailsBtn);
		SwitchToDefaultFrame();
	}

	public void switchToAddRecordFieldFormatFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
	}

	public void enterSequenceNoTxt() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(SequenceNoTxt, "1");
	}

	public void selectField() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(FieldDDwn, "CARD NUMBER [DEVICE_NUMBER]");
	}

	public void clickAddSubDetails2() {
		CustomUtils.ThreadDotSleep(2000);
		waitForElementVisible(AddSubDetails2Btn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(AddSubDetails2Btn);
	}

	public void switchToAddOrderFieldFormatFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_ORDER_FIELD_FORMAT_FRAME);
	}

	public void enterPriority() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PriorityTxt, "1");
	}

	public String addembossingtemplate(String Embosscode, String EmbossDesc, String EmbossFileType, String sequenceNo,
			String EmbossingField, String EmbossTempField, String priority) {
		String flag = null;

		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingTemplate().click());
		addDeviceCardPackTemplate();
		enterText(EmbossingFileTemplateCodeTxt, Embosscode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, EmbossDesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(FileTypeDDwn, EmbossFileType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(2000);
		ClickButton(SaveBtn);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
				flag = "Not added";
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			ClickButton(AddSubDetailsBtn);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(SequenceNoTxt, sequenceNo);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(FieldDDwn, EmbossingField);
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickButton(SaveBtn);
			SwitchToDefaultFrame();
			addOrderFormatRecord();
			flag = "Added";
		}
		SwitchToDefaultFrame();
		return flag;
	}

	public void editEmbossTemplate(String legalType, String excelName) throws InterruptedException {
		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingTemplate().click());
		WebElement EditEmbossingTemp = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
				+ MapUtils.fnGetInputDataFromMap("Embosscode") + "')]/following::a[1]/img[@alt='Edit Record']"));
		EditEmbossingTemp.click();
		switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
		ClickCheckBox(CheckSumChkBx, true);
		ClickCheckBox(HeaderChkBx, true);
		ClickCheckBox(TrailerChkBx, true);
		addRecordFormatData(FieldDDwn, excelName, legalType);
		SwitchToDefaultFrame();
	}

	public void addRecordFormatData(MCWebElement DrpDown, String filepath, String legalType)
			throws InterruptedException {
		HashMap<String, HashMap<String, String>> map = excelTestData.fnReadEntireTestData(filepath, "Sheet1", "Sr. No");
		for (int i = 1; i < map.size(); i++) {
			SwitchToDefaultFrame();
			switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			waitForElementVisible(AddSubDetailsBtn);
			CustomUtils.ThreadDotSleep(2000);
			retryUntilNoErrors(() -> ClickButton(AddSubDetailsBtn));
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
			excelTestData.dataProviderIterator(map, String.valueOf(i));
			String FieldToBeAdded = MapUtils.getIterativeDataFromDatamap("Template Fields");
			String LengthOfField = MapUtils.getIterativeDataFromDatamap("Length");
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByValue(DrpDown, FieldToBeAdded);
			addWicketAjaxListeners(getFinder().getWebDriver());
			CustomUtils.ThreadDotSleep(2000);
			if (LengthTxt.isEnabled()) {
				waitForElementVisible(LengthTxt);
				CustomUtils.ThreadDotSleep(2000);
				LengthTxt.clearField();
				addWicketAjaxListeners(getFinder().getWebDriver());
				waitForElementVisible(LengthTxt);
				enterText(LengthTxt, LengthOfField);
			}
			addWicketAjaxListeners(getFinder().getWebDriver());
			if (FieldToBeAdded.equalsIgnoreCase(Constants.Legal_Id_String)) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				SelectDropDownByValue(LegalIDTypeDDwn, legalType);
				ClickButton(SaveBtn);
				break;
			}
			if (FieldToBeAdded.contains(Constants.Filler_String)) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				waitForElementVisible(FillerValueTxt);
				enterText(FillerValueTxt, enterFilter(Integer.valueOf(LengthOfField)));
				waitForElementVisible(SaveBtn);
				ClickButton(SaveBtn);
				CustomUtils.ThreadDotSleep(2000);

			} else {
				ClickButton(SaveBtn);
				CustomUtils.ThreadDotSleep(2000);
			}

		}
		SwitchToDefaultFrame();
		switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(SaveBtn);
		CustomUtils.ThreadDotSleep(2000);
	}

	public String enterFilter(int fillerLenght) {
		String filler = "";
		for (int i = 0; i < fillerLenght; i++) {
			filler = filler + "|";
		}
		return filler;
	}

	public void addOrderFormatRecord() {
		switchToAddEmbossingTemplateFrame();
		CustomUtils.ThreadDotSleep(1000);
		clickAddSubDetails2();
		switchToAddOrderFieldFormatFrame();
		selectField();
		enterPriority();
		clickSaveButton();
		SwitchToDefaultFrame();
	}

	public void createPINOffsetTemplate(String TempCode, String TempDesc, String PINFileType, String sequenceNo,
			String PINfield, ExamplesTable pinTable, String EmbossTempField, String priority) {
		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingTemplate().click());
		addDeviceCardPackTemplate();
		enterText(EmbossingFileTemplateCodeTxt, TempCode);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, TempDesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(FileTypeDDwn, PINFileType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(SaveBtn);
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(SaveBtn);
		CustomUtils.ThreadDotSleep(2000);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			ClickButton(AddSubDetailsBtn);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			enterText(SequenceNoTxt, sequenceNo);
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(FieldDDwn, PINfield);
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickButton(SaveBtn);
			// SwitchToDefaultFrame();
			addRecordPIN(FieldDDwn, pinTable);
			SwitchToDefaultFrame();
			addOrderFormatRecord();
		}
		SwitchToDefaultFrame();
	}

	public void addRecordPIN(MCWebElement DrpDown, ExamplesTable pinTable) {
		String DropDownValue = null;
		for (int i = 0; i < pinTable.getRows().size(); i++) {
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			waitForElementVisible(AddSubDetailsBtn);
			CustomUtils.ThreadDotSleep(1000);
			retryUntilNoErrors(() -> ClickButton(AddSubDetailsBtn));
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);

			DropDownValue = pinTable.getRow(i).get(pinTable.getHeaders().get(0));
			addWicketAjaxListeners(getFinder().getWebDriver());

			SelectDropDownByText(DrpDown, DropDownValue);
			addWicketAjaxListeners(getFinder().getWebDriver());
			if (DropDownValue.equalsIgnoreCase(Constants.Delimiter_String)) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				enterText(FillerValueTxt, ":");
				ClickButton(SaveBtn);
			}
			if (DropDownValue.equalsIgnoreCase(Constants.Filler_String)) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				enterText(FillerValueTxt, "|");
				ClickButton(SaveBtn);

			} else {
				ClickButton(SaveBtn);
				CustomUtils.ThreadDotSleep(2000);
			}

		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
