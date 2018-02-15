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
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
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
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_EMBOSSING_PARAMETERS,
		CardManagementNav.L3_EMBOSSING_TEMPLATE })
public class EmbossingTemplatePage extends AbstractBasePage {
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

	public void clickAddEmbossingTemplate() {
		clickWhenClickable(addDeviceCardPackTemplateBtn);
		switchToAddEmbossingTemplateFrame();
	}

	public void switchToAddEmbossingTemplateFrame() {
		// addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);
	}

	public String enterEmbossingFileCode(EmbossingFile embossingFile) {
		if (embossingFile.getEmbossingTempCode().length() != 0) {
			enterValueinTextBox(EmbossingFileTemplateCodeTxt, embossingFile.getEmbossingTempCode());
		} else {
			enterValueinTextBox(EmbossingFileTemplateCodeTxt, CustomUtils.randomNumbers(3));
		}
		return EmbossingFileTemplateCodeTxt.getAttribute("value");
	}

	public String enterEmbossingFileDecsription(EmbossingFile embossingFile) {
		if (embossingFile.getEmbossingTempDescription().length() != 0) {
			enterValueinTextBox(DescriptionTxt, embossingFile.getEmbossingTempDescription());
		} else {
			enterValueinTextBox(DescriptionTxt, "AutoEmboss");
		}
		return DescriptionTxt.getAttribute("value");
	}

	public void selectFileType(EmbossingFile embossing) {
		selectByVisibleText(FileTypeDDwn, embossing.getEmbosstemplateType());
	}

	@Override
	public void clickSaveButton() {
		clickWhenClickable(SaveBtn);
	}

	public boolean verifyErrorsOnEmbossingTemplatePage() {
		return publishErrorOnPage();
	}

	public void verifyEmbossingTemplateSuccess(EmbossingFile embossingFile) {
		String EmbossingFileName = "EmbossingInputTemplate";
		if (!verifyErrorsOnEmbossingTemplatePage()) {
			logger.info("Embossing Template Added Successfully");
			SwitchToDefaultFrame();
			switchToAddEmbossingTemplateFrame();
			clickAddSubdetails();
			enterSequenceNoTxt();
			selectField();
			clickSaveButton();
			CustomUtils.ThreadDotSleep(3000);
			waitForPageToLoad(getFinder().getWebDriver());
			SwitchToDefaultFrame();
			addOrderFormatRecord();
			switchToAddEmbossingTemplateFrame();
			CustomUtils.ThreadDotSleep(3000);
			clickSaveButton();
			try {
				editEmbossTemplate(MapUtils.fnGetInputDataFromMap("LegalType"), EmbossingFileName, embossingFile);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void clickAddSubdetails() {
		clickWhenClickable(AddSubDetailsBtn);
		SwitchToDefaultFrame();
		switchToAddRecordFieldFormatFrame();
	}

	public void switchToAddRecordFieldFormatFrame() {
		switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
	}

	public void enterSequenceNoTxt() {
		enterValueinTextBox(SequenceNoTxt, "1");
	}

	public void selectField() {
		// addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(FieldDDwn);
		selectByVisibleText(FieldDDwn, "CARD NUMBER [DEVICE_NUMBER]");
	}

	public void clickAddSubDetails2() {
		clickWhenClickable(AddSubDetails2Btn);
		switchToAddOrderFieldFormatFrame();
	}

	public void switchToAddOrderFieldFormatFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_ORDER_FIELD_FORMAT_FRAME);
	}

	public void enterPriority() {
		enterValueinTextBox(PriorityTxt, "1");
	}

	public String addEmbossingGeneral(EmbossingFile embossing) {
		String templateCode;
		String EmbossingDesc;
		templateCode = enterEmbossingFileCode(embossing);
		EmbossingDesc = enterEmbossingFileDecsription(embossing);
		selectFileType(embossing);
		clickSaveButton();
		waitForPageToLoad(getFinder().getWebDriver());
		return buildDescriptionAndCode(EmbossingDesc, templateCode);

	}

	public String addembossingtemplate(String Embosscode, String EmbossDesc, String EmbossFileType, String sequenceNo,
			String EmbossingField, String EmbossTempField, String priority) {
		String flag = null;

		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingTemplate().click());
		// addDeviceCardPackTemplate();
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

	public void editEmbossTemplate(String legalType, String excelName, EmbossingFile embossingFile)
			throws InterruptedException {
		WebElement EditEmbossingTemp = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
				+ embossingFile.getEmbossingTempCode() + "')]/following::a[1]/img[@alt='Edit Record']"));
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
			clickAddSubdetails();
			excelTestData.dataProviderIterator(map, String.valueOf(i));
			String FieldToBeAdded = MapUtils.getIterativeDataFromDatamap("Template Fields");
			String LengthOfField = MapUtils.getIterativeDataFromDatamap("Length");
			selectByVisibleText(DrpDown, FieldToBeAdded);
			enterValueinTextBox(LengthTxt, LengthOfField);
			CustomUtils.ThreadDotSleep(3000);
			clickWhenClickable(SaveBtn);

			if (FieldToBeAdded.equalsIgnoreCase(Constants.Legal_Id_String)) {
				waitForPageToLoad(getFinder().getWebDriver());
				// SelectDropDownByValue(LegalIDTypeDDwn, legalType);
				selectByVisibleText(LegalIDTypeDDwn, legalType);
				waitForLoaderToDisappear();
				clickWhenClickable(SaveBtn);
				break;
			}
			if (FieldToBeAdded.contains(Constants.Filler_String)) {
				waitForLoaderToDisappear();
				enterValueinTextBox(FillerValueTxt, enterFilter(Integer.valueOf(LengthOfField)));
				clickSaveButton();
			}
		}
		SwitchToDefaultFrame();
		switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
		clickSaveButton();
	}

	public String enterFilter(int fillerLenght) {
		waitForPageToLoad(getFinder().getWebDriver());
		String filler = "";
		for (int i = 0; i < fillerLenght; i++) {
			filler = filler + "|";
		}
		return filler;
	}

	public void addOrderFormatRecord() {
		switchToAddEmbossingTemplateFrame();
		clickAddSubDetails2();
		selectField();
		enterPriority();
		clickSaveButton();
		SwitchToDefaultFrame();
	}

	public void createPINOffsetTemplate(String PINfield, ExamplesTable pinTable, EmbossingFile embossingfile) {
		clickAddEmbossingTemplate();
		addEmbossingGeneral(embossingfile);
		clickAddSubdetails();
		enterEmbossingFileCode(embossingfile);
		SelectDropDownByText(FieldDDwn, PINfield);
		clickSaveButton();
		addRecordPIN(FieldDDwn, pinTable);
		SwitchToDefaultFrame();
		addOrderFormatRecord();
		SwitchToDefaultFrame();
	}

	public void addRecordPIN(MCWebElement DrpDown, ExamplesTable pinTable) {
		String DropDownValue = null;
		for (int i = 0; i < pinTable.getRows().size(); i++) {
			SwitchToDefaultFrame();
			switchToAddEmbossingTemplateFrame();
			clickAddSubdetails();
			DropDownValue = pinTable.getRow(i).get(pinTable.getHeaders().get(0));
			SelectDropDownByText(DrpDown, DropDownValue);
			if (DropDownValue.equalsIgnoreCase(Constants.Delimiter_String)) {
				enterValueinTextBox(FillerValueTxt, ":");
				clickSaveButton();
			}
			if (DropDownValue.equalsIgnoreCase(Constants.Filler_String)) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				enterValueinTextBox(FillerValueTxt, "|");
				clickSaveButton();

			} else {
				clickSaveButton();
			}

		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
