package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class EmbossingPriorityPassPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	@Autowired
	MenuSubMenuPage menusubMenuPage;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addEmbossingPriorityPassBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planDesc:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fileType:input:dropdowncomponent")
	private MCWebElement FileTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement ProgramDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePlanCode:input:dropdowncomponent")
	private MCWebElement DevicePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorCode:input:dropdowncomponent")
	private MCWebElement VendorCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "priority:input:inputTextField")
	private MCWebElement PriorityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "filenameExpression:input:dropdowncomponent")
	private MCWebElement FileNameTagDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "filenameExpression1:input:textAreaComponent")
	private MCWebElement TextareaTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@class ='btn_or_sbt'][@value ='ADD Tag']")
	private MCWebElement AddTagBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void addembossingprioritypass(String embossPriorityPassDesc, String productType,
			String embossPriorityInterchange, String embossPriority) {
		retryUntilNoErrors(() -> menusubMenuPage.getEmbossingParameters().click());
		ClickButton(addEmbossingPriorityPassBtn);
		switchToIframe(Constants.ADD_EMBOSS_PRIORITY_PASS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(FileTypeDDwn);
		SelectDropDownByText(FileTypeDDwn, Constants.EmbossingPriorityPass_fileType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(DescriptionTxt, embossPriorityPassDesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductTypeDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(InterchangeDDwn, embossPriorityInterchange);
		addWicketAjaxListeners(getFinder().getWebDriver());
		// SelectDropDownByIndex(DevicePlanDDwn, 1);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PriorityTxt, embossPriority);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addTagsFileName();
		ClickButton(SaveBtn);
		try {
			PanelErrorTxt.isVisible();
			logger.info("inside error pannel");
			ClickButton(CancelBtn);

		} catch (Exception e) {
			logger.error(e.toString());
			logger.info("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	public void addTagsFileName() {
		waitForElementVisible(AddTagBtn);
		// Adding mandatory name
		// tags[INSTITUTION_CODE][NETWORK_CODE][VENDOR_CODE][PROGRAM_CODE][SEQUENCE_NUMBER][DEVICE_PLAN]
		String[] Tags = new String[] { "SEQUENCE_NUMBER [SEQUENCE_NUMBER]", "INSTITUTION_CODE [INSTITUTION_CODE]",
				"NETWORK_CODE [NETWORK_CODE]", "VENDOR_CODE [VENDOR_CODE]", "PROGRAM_CODE [PROGRAM_CODE]",
				"DEVICE_PLAN [DEVICE_PLAN]" };
		enterText(TextareaTxt, "AUTO");
		ClickButton(AddTagBtn);
		for (int i = 0; i < Tags.length; i++) {
			waitForElementVisible(FileNameTagDDwn);
			SelectDropDownByText(FileNameTagDDwn, Tags[i]);
			ClickButton(AddTagBtn);

		}

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
