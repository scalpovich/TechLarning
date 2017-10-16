package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class EmbossingTemplatePage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingTemplatePage.class);

	@Autowired
	MenuSubMenuPage menusubMenuPage;

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

	public void addembossingtemplate(String Embosscode, String EmbossDesc, String EmbossFileType, String sequenceNo,
			String EmbossingField, String EmbossTempField, String priority) {
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
			SelectDropDownByText(FieldDDwn, EmbossingField);
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickButton(SaveBtn);
			SwitchToDefaultFrame();
			addOrderFormatRecord(EmbossTempField, priority);
		}
		SwitchToDefaultFrame();
	}

	public void editEmbossTemplate(String legalType, ExamplesTable parameters) throws InterruptedException {
		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingTemplate().click());
		ClickButton(EditDeviceCardPackTemplateBtn);
		switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
		ClickCheckBox(CheckSumChkBx, true);
		ClickCheckBox(HeaderChkBx, true);
		ClickCheckBox(TrailerChkBx, true);
		addRecordFormatData(FieldDDwn, parameters, legalType);
		SwitchToDefaultFrame();
	}

	public void addRecordFormatData(MCWebElement DrpDown, ExamplesTable parametersTable, String legalType)
			throws InterruptedException {
		String DropDownValue = null;
		for (int i = 0; i < parametersTable.getRows().size(); i++) {
			SwitchToDefaultFrame();
			switchToIframe(Constants.EDIT_EMBOSS_TEMPLATE_FRAME);
			retryUntilNoErrors(() -> ClickButton(AddSubDetailsBtn));
			SwitchToDefaultFrame();
			switchToIframe(Constants.ADD_RECORD_FIELD_FORMAT_FRAME);
			DropDownValue = parametersTable.getRow(i).get(parametersTable.getHeaders().get(0));
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(DrpDown, DropDownValue);
			addWicketAjaxListeners(getFinder().getWebDriver());
			if (DropDownValue.equalsIgnoreCase("LEGAL_ID [LEGAL_ID]")) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				CustomUtils.ThreadDotSleep(2000);
				SelectDropDownByText(LegalIDTypeDDwn, legalType);
				ClickButton(SaveBtn);

				break;
			}
			if (DropDownValue.equalsIgnoreCase("FILLER [FILLER]")) {
				addWicketAjaxListeners(getFinder().getWebDriver());
				CustomUtils.ThreadDotSleep(2000);
				enterText(FillerValueTxt, "|");
				Thread.sleep(2000);
				ClickButton(SaveBtn);

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

	public void addOrderFormatRecord(String EmbossTempField, String priority) {

		switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);
		ClickButton(AddSubDetails2Btn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_ORDER_FIELD_FORMAT_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(FieldDDwn, EmbossTempField);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PriorityTxt, priority);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(SaveBtn);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_EMBOSS_TEMPLATE_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(SaveBtn);

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
